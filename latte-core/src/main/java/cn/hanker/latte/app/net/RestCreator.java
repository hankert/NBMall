package cn.hanker.latte.app.net;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import cn.hanker.latte.app.ConfigType;
import cn.hanker.latte.app.Latte;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/18.
 */

public class RestCreator {

    private static final class ParamsHolder{
        public static final WeakHashMap<String, Object> PARSMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams(){
        return ParamsHolder.PARSMS;
    }

    public static RestService getRestService(){
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder{
        private static final String    BASE_URL = (String) Latte.getConfigurations().get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OKHttpHolder{

        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

    }

    private static final class RestServiceHolder{
        private static final RestService REST_SERVICE
                = RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);

    }

}
