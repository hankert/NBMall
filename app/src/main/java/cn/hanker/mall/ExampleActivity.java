package cn.hanker.mall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import cn.hanker.latte.app.Latte;
import cn.hanker.latte.app.activities.ProxyActivity;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latte.app.ui.launcher.ILauncherListener;
import cn.hanker.latte.app.ui.launcher.OnLauncherFinishTag;
import cn.hanker.latteec.ec.launcher.LauncherDelegate;
import cn.hanker.latteec.ec.sign.ISignListener;
import cn.hanker.latteec.ec.sign.SignInDelegate;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public LatteDelegate setRootDelegate() {
//        return new ExampleDelegate();
        return new LauncherDelegate();
//        return new SignUpDelegate();
//        return new LauncherScrollDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_SHORT).show();
                // 跳转主页
                startWithPop(new ExampleDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束，用户没登录", Toast.LENGTH_SHORT).show();
                // 启动并且将当前页面关闭
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
