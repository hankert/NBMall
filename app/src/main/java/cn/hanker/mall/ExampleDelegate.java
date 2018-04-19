package cn.hanker.mall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.util.WeakHashMap;

import cn.hanker.R;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latte.app.net.RestClient;
import cn.hanker.latte.app.net.RestCreator;
import cn.hanker.latte.app.net.callback.IError;
import cn.hanker.latte.app.net.callback.IFailure;
import cn.hanker.latte.app.net.callback.ISuccess;
import cn.hanker.latte.app.net.rx.RxRestClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/13.
 */

public class ExampleDelegate extends LatteDelegate {


    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

//        test();
//        testRx();
        onCallRxRestClient();


    }

    private void test() {
        RestClient.builder()
                .url("https://127.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }

    // TODO: 测试方法
    private void testRx() {
        final String url = "http://127.0.0.1/index";
        final WeakHashMap<String, Object> params = new WeakHashMap<>();

        final Observable<String> observable = RestCreator.getRxRestService().get(url, params);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(String s) {

                        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void onCallRxRestClient() {
        final String url = "http://127.0.0.1/index";
        RxRestClient.builder()
                .url(url)
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
//                        LatteLoader.showLoading(getContext());
                    }

                    @Override
                    public void onNext(String s) {
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                LatteLoader.stopLoading();
//                            }
//                        }, 2000);
                        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
