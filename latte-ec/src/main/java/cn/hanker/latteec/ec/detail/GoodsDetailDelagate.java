package cn.hanker.latteec.ec.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latteec.R;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class GoodsDetailDelagate extends LatteDelegate{

    public static GoodsDetailDelagate create(){
        return new GoodsDetailDelagate();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}
