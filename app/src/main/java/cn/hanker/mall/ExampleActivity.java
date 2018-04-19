package cn.hanker.mall;

import cn.hanker.latte.app.activities.ProxyActivity;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latteec.ec.launcher.LauncherDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
//        return new ExampleDelegate();
        return new LauncherDelegate();
    }
}
