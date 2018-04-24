package com.flowbank.wo.wechat.templates;

import com.flowbank.wo.wechat.BaseWXEntryActivity;
import com.flowbank.wo.wechat.LatteWeChat;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
public class WXEntryTemplate extends BaseWXEntryActivity{


    @Override
    protected void onResume() {
        super.onResume();
        finish();
        //去掉关闭页面的动画
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallBack().onSignInSuccess(userInfo);
    }
}
