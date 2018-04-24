package com.flowbank.wo.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import cn.hanker.latte.app.util.log.LatteLogger;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
public abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 必须写在oncreate中
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(), this);
        LatteLogger.d("注册微信回调");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(), this);
        LatteLogger.d("注册微信回调");
    }
}
