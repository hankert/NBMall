package cn.hanker.mall;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.hanker.R;
import cn.hanker.latte.app.Latte;
import cn.hanker.latte.app.net.interceptors.DebugInterceptor;
import cn.hanker.latteec.ec.icon.FontEcModule;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/13.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.1.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
//                .withInterceptor()
                .configure();

    }
}
