package cn.hanker.mall;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.hanker.R;
import cn.hanker.latte.app.Latte;
import cn.hanker.latte.app.net.interceptors.DebugInterceptor;
import cn.hanker.latteec.ec.database.DatabaseManager;
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
                .withApiHost("http://192.168.2.8/RestServer/api/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withWechatAppId("wx9b10f06dd604f9df")
                .withWechatAppSecret("sinobyte888809876543211234567890")
//                .withInterceptor()
                .configure();

        DatabaseManager.getInstance().init(this);

        initStetho();

    }
        private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
