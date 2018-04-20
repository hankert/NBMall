package cn.hanker.latte.app.net.rx;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import cn.hanker.latte.app.net.RestCreator;
import cn.hanker.latte.app.ui.loader.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/18.
 */

public class RxRestClientBuilder {

    private  String mUrl = null;
    private  static  final  Map<String, Object> PARAMS = RestCreator.getParams();

    private  RequestBody mBody = null;
    private LoaderStyle mLoaderStyle = null;
    private Context mContext = null;
    private File mFile = null;


    RxRestClientBuilder(){

    }

    public final RxRestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(WeakHashMap<String, Object> parsms){
        PARAMS.putAll(parsms);
        return this;
    }

    public final RxRestClientBuilder params(String key, Object value){
        PARAMS.put(key, value);
        return this;
    }

    public final RxRestClientBuilder raw(String raw){
       this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
       return this;
    }


    public final RxRestClientBuilder file(File file){
        this.mFile = file;
        return this;
    }
    public final RxRestClientBuilder file(String filePath){
        this.mFile = new File(filePath);
        return this;
    }


    public final RxRestClientBuilder loader(Context context, LoaderStyle style){
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }
    public final RxRestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }

    public final RxRestClient build(){
        return  new RxRestClient(mUrl, PARAMS, mBody, mLoaderStyle, mContext, mFile);
    }

}
