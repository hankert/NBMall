package cn.hanker.latte.app.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import cn.hanker.latte.app.ConfigKeys;
import cn.hanker.latte.app.Latte;
import cn.hanker.latte.app.wechat.callbacks.IWeChatSignInCallBack;

/**
 * @auther jh
 * @des
 * Created by J.H on 2018/4/21.
 */
public class LatteWeChat {

    public static final String  APP_ID = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    public static final String  APP_SECRET = Latte.getConfiguration(ConfigKeys.WE_CHAT_SECRET);

    private final IWXAPI WXAPI;
    private IWeChatSignInCallBack mSignInCallBack = null;

    private static final class Holder{
        private static final LatteWeChat INSTANCE = new LatteWeChat();

    }

    public static LatteWeChat getInstance(){
        return Holder.INSTANCE;
    }

    private LatteWeChat(){
        final Activity activity = Latte.getConfiguration(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI(){
        return WXAPI;
    }

    public LatteWeChat onSignSuccess(IWeChatSignInCallBack signInCallBack){
        this.mSignInCallBack = signInCallBack;
        return this;
    }

    public IWeChatSignInCallBack getSignInCallBack() {
        return mSignInCallBack;
    }

    public final void signIn(){
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }


}
