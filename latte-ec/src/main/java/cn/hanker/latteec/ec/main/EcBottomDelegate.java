package cn.hanker.latteec.ec.main;

import android.graphics.Color;

import java.util.LinkedHashMap;

import cn.hanker.latte.app.delegates.BaseBottom.BaseBottomDelegate;
import cn.hanker.latte.app.delegates.BaseBottom.BottomItemDelegate;
import cn.hanker.latte.app.delegates.BaseBottom.BottomTabBean;
import cn.hanker.latte.app.delegates.BaseBottom.ItemBuilder;
import cn.hanker.latteec.ec.main.index.IndexDelegate;
import cn.hanker.latteec.ec.main.sort.SortDelegate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class EcBottomDelegate extends BaseBottomDelegate {


    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
