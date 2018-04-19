package cn.hanker.mall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import cn.hanker.R;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latte.app.net.RestClient;
import cn.hanker.latte.app.net.callback.IError;
import cn.hanker.latte.app.net.callback.IFailure;
import cn.hanker.latte.app.net.callback.ISuccess;

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

        test();


    }

    private void test(){
        RestClient.builder()
                .url("https://news.baidu.com")
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
}
