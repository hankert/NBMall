package cn.hanker.latte.app.delegates.BaseBottom;

/**
 * @auther jh
 * @des 底部tabBean
 * Created by J.H on 2018/4/24.
 */
public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTtile() {
        return TITLE;
    }
}
