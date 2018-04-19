package cn.hanker.latte.app.net;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import cn.hanker.latte.app.net.callback.IError;
import cn.hanker.latte.app.net.callback.IFailure;
import cn.hanker.latte.app.net.callback.IRequest;
import cn.hanker.latte.app.net.callback.ISuccess;
import cn.hanker.latte.app.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/18.
 */

public class RestClientBuilder {

    private  String mUrl = null;
    private  static  final  Map<String, Object> PARAMS = RestCreator.getParams();
    private  IRequest mIRequest = null;
    private  IFailure mIFailure = null;
    private  ISuccess mISuccess = null;
    private  IError mIError = null;
    private  RequestBody mBody = null;
    private LoaderStyle mLoaderStyle = null;
    private Context mContext = null;
    private File mFile = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    RestClientBuilder(){


    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> parsms){
        PARAMS.putAll(parsms);
        return this;
    }

    public final RestClientBuilder params(String key, Object value){
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
       this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
       return this;
    }

    public final RestClientBuilder success(ISuccess success){
        this.mISuccess = success;
        return this;
    }
    public final RestClientBuilder error(IError error){
        this.mIError = error;
        return this;
    }
    public final RestClientBuilder onRequest(IRequest request){
        this.mIRequest = request;
        return this;
    }
    public final RestClientBuilder failure(IFailure failure){
        this.mIFailure = failure;
        return this;
    }
    public final RestClientBuilder file(File file){
        this.mFile = file;
        return this;
    }
    public final RestClientBuilder file(String filePath){
        this.mFile = new File(filePath);
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }
    public final RestClientBuilder loader(Context context, LoaderStyle style){
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }
    public final RestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }

    public final RestClient build(){
        return  new RestClient(mUrl, PARAMS, mIRequest, mIFailure, mISuccess, mIError, mBody, mLoaderStyle, mContext, mFile, mDownloadDir, mExtension, mName);
    }

}
