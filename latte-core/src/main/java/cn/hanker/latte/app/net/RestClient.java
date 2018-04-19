package cn.hanker.latte.app.net;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import cn.hanker.latte.app.net.callback.IError;
import cn.hanker.latte.app.net.callback.IFailure;
import cn.hanker.latte.app.net.callback.IRequest;
import cn.hanker.latte.app.net.callback.ISuccess;
import cn.hanker.latte.app.net.callback.RequestCallBacks;
import cn.hanker.latte.app.net.download.DownloadHandler;
import cn.hanker.latte.app.ui.LatteLoader;
import cn.hanker.latte.app.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/13.
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final Context CONTEXT;
    private final File FILE;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;


    public RestClient(String url, Map<String, Object> params, IRequest request,
                      IFailure failure, ISuccess success, IError error, RequestBody body,
                      LoaderStyle loaderStyle, Context context, File file,String downloadDir,
                      String extension,
                      String name) {
        URL = url;
        PARAMS.putAll(params);
        REQUEST = request;
        FAILURE = failure;
        SUCCESS = success;
        ERROR = error;
        BODY = body;
        LOADER_STYLE = loaderStyle;
        CONTEXT = context;
        this.FILE = file;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

    private void request(HttpMethod method){
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUEST != null){
            REQUEST.onRequestStart();
        }
        if (LOADER_STYLE != null){
            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
        }

        switch (method){
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = RestCreator.getRestService().upload(URL, body);
                break;

                default:
                    break;
        }
        if (call != null){
            call.enqueue(getRequestCallback());

        }

    }

    private Callback<String> getRequestCallback(){
        return new RequestCallBacks(REQUEST, FAILURE, SUCCESS, ERROR, LOADER_STYLE);
    }

    public final void get(){
        request(HttpMethod.GET);
    }
    public final void post(){
        if (BODY != null){
            request(HttpMethod.POST);
        }else{
            if (!PARAMS.isEmpty()){
                throw new RuntimeException("params must be null");
            }
            request(HttpMethod.POST_RAW);
        }

    }
    public final void put(){
        if (BODY != null){
            request(HttpMethod.PUT);
        }else{
            if (!PARAMS.isEmpty()){
                throw new RuntimeException("params must be null");
            }
            request(HttpMethod.PUT_RAW);
        }
    }
    public final void delete(){
        request(HttpMethod.DELETE);
    }
    public final void upload(){
        request(HttpMethod.UPLOAD);
    }

    public final void download(){
        new DownloadHandler(URL, REQUEST, FAILURE, SUCCESS, ERROR, DOWNLOAD_DIR, EXTENSION, NAME).handleDownload();
    }

}











