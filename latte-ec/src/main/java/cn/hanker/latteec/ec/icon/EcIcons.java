package cn.hanker.latteec.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/13.
 */

public enum  EcIcons implements Icon{

    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
         return name().replace('_', '-');
    }

    @Override
    public char character() {
         return character;
    }
}
