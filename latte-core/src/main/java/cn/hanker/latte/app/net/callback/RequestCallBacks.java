package cn.hanker.latte.app.net.callback;


import android.os.Handler;

import cn.hanker.latte.app.ui.loader.LatteLoader;
import cn.hanker.latte.app.ui.loader.LoaderStyle;
import cn.hanker.latte.app.util.log.LatteLogger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/18.
 */

public class RequestCallBacks implements Callback<String>{

    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = new Handler();


    public RequestCallBacks(IRequest request, IFailure failure, ISuccess success, IError error, LoaderStyle style) {
        REQUEST = request;
        FAILURE = failure;
        SUCCESS = success;
        ERROR = error;
        this.LOADER_STYLE = style;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()){
            if (call.isExecuted()){
                if (SUCCESS != null){
                    SUCCESS.onSuccess(response.body());
                    LatteLogger.d("Response_success", response.body());
                }
            }
        }else{
            if (ERROR != null){
                ERROR.onError(response.code(), response.message());
                LatteLogger.d("Response_error", "错误码_"+response.code()+"错误信息_"+response.message());
            }
        }
        stopLoading();
    }

    private void stopLoading() {
        if (LOADER_STYLE != null){
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            }, 1000);
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
            if (FAILURE != null){
                FAILURE.onFailure();
                LatteLogger.d("Response_failure", "请求失败");
            }
            if (REQUEST != null){
                REQUEST.onRequestEnd();
            }
        stopLoading();

    }
}
