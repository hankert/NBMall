package cn.hanker.latteec.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/13.
 */

public class FontEcModule implements IconFontDescriptor{

    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
