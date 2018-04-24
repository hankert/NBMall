package cn.hanker.latte.app;

import android.content.Context;
import android.os.Handler;

/**
 * @auther jh
 * @des app 配置类  final类型 不能继承
 * Created by J.H on 2018/4/13.
 */

public final class Latte {


        public static Configurator init(Context context){
            Configurator.getInstance().getLatteConfigs()
                    .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
            return Configurator.getInstance();

        }

        public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

        public static Context getApplicationContext(){
            return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
        }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }


}
