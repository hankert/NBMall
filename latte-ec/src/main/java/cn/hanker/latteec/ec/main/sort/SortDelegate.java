package cn.hanker.latteec.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.hanker.latte.app.delegates.BaseBottom.BottomItemDelegate;
import cn.hanker.latteec.R;
import cn.hanker.latteec.ec.main.sort.content.ContentDelegate;
import cn.hanker.latteec.ec.main.sort.list.VerticalListDelegate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class SortDelegate extends BottomItemDelegate{


    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate = new VerticalListDelegate();
        loadRootFragment(R.id.vertical_list_container, listDelegate);
        //设置右侧第一个分类显示，默认显示分类一
//        loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1));
        replaceLoadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1), false);



    }
}
