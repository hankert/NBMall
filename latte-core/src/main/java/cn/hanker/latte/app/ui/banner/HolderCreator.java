package cn.hanker.latte.app.ui.banner;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class HolderCreator implements CBViewHolderCreator<ImageHolder>{
    @Override
    public ImageHolder createHolder() {
        return new ImageHolder();
    }
}
