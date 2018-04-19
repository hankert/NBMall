package cn.hanker.latte.app.net.download;

import android.os.AsyncTask;

import java.util.WeakHashMap;

import cn.hanker.latte.app.net.RestCreator;
import cn.hanker.latte.app.net.callback.IError;
import cn.hanker.latte.app.net.callback.IFailure;
import cn.hanker.latte.app.net.callback.IRequest;
import cn.hanker.latte.app.net.callback.ISuccess;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @auther jh
 * @des
 * Created by J.H on 2018/4/19.
 */

public class DownloadHandler {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final String DOWNLOAD_DIR; //下载的目录
    private final String EXTENSION;  // 下载的后缀
    private final String NAME;        //下载的文件名  有这个DOWNLOAD_DIR EXTENSION 参数不用

    public DownloadHandler(String url, IRequest request, IFailure failure,
                           ISuccess success, IError error, String download_dir, String extension, String name) {
        this.URL = url;
        this.REQUEST = request;
        this.FAILURE = failure;
        this.SUCCESS = success;
        this.ERROR = error;
        this.DOWNLOAD_DIR = download_dir;
        this.EXTENSION = extension;
        this.NAME = name;
    }

    public final void handleDownload(){
        if (REQUEST != null){
            REQUEST.onRequestStart();
        }

        RestCreator.getRestService().download(URL, PARAMS)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        if (response.isSuccessful()){
                            final ResponseBody responseBody = response.body();
                            final SaveFileTask task = new SaveFileTask(REQUEST, SUCCESS);
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, DOWNLOAD_DIR, EXTENSION, responseBody, NAME);
                            //这里一定要判断 否则文件下载不全
                            if (task.isCancelled()){
                                if (REQUEST != null){
                                    REQUEST.onRequestEnd();
                                }
                            }
                        }else{
                            if (ERROR!=null){
                                ERROR.onError(response.code(), response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        if (FAILURE!=null){
                            FAILURE.onFailure();
                        }
                    }
                });
    }


}
