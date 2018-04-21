package cn.hanker.latte.app.wechat.templates;

import cn.hanker.latte.app.wechat.BaseWXEntryActivity;
import cn.hanker.latte.app.wechat.LatteWeChat;

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
