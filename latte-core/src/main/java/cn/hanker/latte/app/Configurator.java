package cn.hanker.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @auther jh
 * @des 管理各类配置项
 * Created by J.H on 2018/4/13.
 */

public class Configurator {

    private static final HashMap<String, Object> LATTE_CONFIGS =  new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator(){

        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static class Holder{
        private static final Configurator INSTANCE = new Configurator();


    }

    final HashMap<String, Object> getLatteConfigs(){

        return LATTE_CONFIGS;
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    private void initIcons(){
        if (ICONS.size() > 0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 0; i < ICONS.size() ; i++) {
                initializer.with(ICONS.get(i));
            }
        }

    }

    public final void configure(){
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);

    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }

}
