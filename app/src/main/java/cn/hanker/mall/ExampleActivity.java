package cn.hanker.mall;

import cn.hanker.latte.app.activities.ProxyActivity;
import cn.hanker.latte.app.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
