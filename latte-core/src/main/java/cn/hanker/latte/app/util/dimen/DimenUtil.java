package cn.hanker.latte.app.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import cn.hanker.latte.app.Latte;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/19.
 */

public class DimenUtil {

    public static int getScreenWidth(){

        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;

    }

    public static int getScreenHeight(){

        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;

    }

}
