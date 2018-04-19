package cn.hanker.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * @auther jh
 * @des app 配置类  final类型 不能继承
 * Created by J.H on 2018/4/13.
 */

public final class Latte {


        public static Configurator init(Context context){
            getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
            return Configurator.getInstance();

        }

        public static HashMap<String, Object> getConfigurations(){
            return Configurator.getInstance().getLatteConfigs();
        }

        public static Context getApplicationContext(){
            return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
        }


}
