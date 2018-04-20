package cn.hanker.mall;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.hanker.latte.app.activities.ProxyActivity;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latteec.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
//        return new ExampleDelegate();
//        return new LauncherDelegate();
        return new SignUpDelegate();
//        return new LauncherScrollDelegate();
    }
}
