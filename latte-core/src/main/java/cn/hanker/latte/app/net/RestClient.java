package cn.hanker.latte.app.net;

import android.content.Context;

import java.util.Map;
import java.util.WeakHashMap;

import cn.hanker.latte.app.net.callback.IError;
import cn.hanker.latte.app.net.callback.IFailure;
import cn.hanker.latte.app.net.callback.IRequest;
import cn.hanker.latte.app.net.callback.ISuccess;
import cn.hanker.latte.app.net.callback.RequestCallBacks;
import cn.hanker.latte.app.ui.LatteLoader;
import cn.hanker.latte.app.ui.LoaderStyle;
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


    public RestClient(String url, Map<String, Object> params, IRequest request,
                      IFailure failure, ISuccess success, IError error, RequestBody body, LoaderStyle loaderStyle, Context context) {
        URL = url;
        PARAMS.putAll(params);
        REQUEST = request;
        FAILURE = failure;
        SUCCESS = success;
        ERROR = error;
        BODY = body;
        LOADER_STYLE = loaderStyle;
        CONTEXT = context;
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
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
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
        request(HttpMethod.POST);
    }
    public final void put(){
        request(HttpMethod.PUT);
    }
    public final void delete(){
        request(HttpMethod.DELETE);
    }

}











