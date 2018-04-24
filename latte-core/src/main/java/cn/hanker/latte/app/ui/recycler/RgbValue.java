package cn.hanker.latte.app.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
@AutoValue
public abstract class RgbValue {

    public abstract int red();
    public abstract int green();
    public abstract int blue();

    public static RgbValue create(int red, int green, int blue){
        return new AutoValue_RgbValue(red, green, blue);
    }
}
