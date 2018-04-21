package cn.hanker.latte.app.net.interceptors;

import android.support.annotation.RawRes;

import java.io.IOException;

import cn.hanker.latte.app.util.file.FileUtil;
import cn.hanker.latte.app.util.log.LatteLogger;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/19.
 */

public class DebugInterceptor extends BaseInterceptor {

    private final String DEBUG_RUL;
    private final int DEBUG_RAW_ID;

    public DebugInterceptor(String debug_rul, int debug_raw_id) {
        this.DEBUG_RUL = debug_rul;
        this.DEBUG_RAW_ID = debug_raw_id;
    }

    private Response getResponse(Chain chain, String json){
        return new Response.Builder()
                .code(200)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), json))
                .message("ok")
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .build();
    }

    private Response debugResponse(Chain chain, @RawRes int rawId){
        final String json = FileUtil.getRawFile(rawId);
        return getResponse(chain,json);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final String url = chain.request().url().toString();
        if (url.contains(DEBUG_RUL)){
            return debugResponse(chain, DEBUG_RAW_ID);
        }
        LatteLogger.d("Request_url",  url);
        return chain.proceed(chain.request());
    }


}
