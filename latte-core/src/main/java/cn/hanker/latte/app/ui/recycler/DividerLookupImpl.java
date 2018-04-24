package cn.hanker.latte.app.ui.recycler;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration.DividerLookup;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class DividerLookupImpl implements DividerLookup{

    private final int COLOR;
    private final int SIZE;

    public DividerLookupImpl(int color, int size) {
        this.COLOR = color;
        this.SIZE = size;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider.Builder()
                .size(SIZE)
                .color(COLOR)
                .build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return new Divider.Builder()
                .size(SIZE)
                .color(COLOR)
                .build();
    }
}
