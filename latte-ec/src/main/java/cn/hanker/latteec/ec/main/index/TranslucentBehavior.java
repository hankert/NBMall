package cn.hanker.latteec.ec.main.index;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import cn.hanker.latte.app.Latte;
import cn.hanker.latteec.R;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class TranslucentBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    //    // 顶部距离
//    private int mDisstanceY = 0;
//    //颜色变化的速率
//    private static final int SHOW_SPEED = 3;
//    // 定义变化的颜色
//    private final RgbValue RGB_VALUE = RgbValue.create(255, 124, 2);
//
//
//    public TranslucentBehavior(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    @Override
//    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
//        return dependency.getId() == R.id.rv_index;
//    }
//
//    @Override
//    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
//        return true;
//    }
//
//    @Override
//    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
//        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
//        // 增加滑动距离
//        mDisstanceY +=dy;
//        //toolbar的高度
//        final int targetHeight = child.getBottom();
//        //当滑动时候 并且距离小于toolbar的时候 调整渐变色
//        if (mDisstanceY > 0 && mDisstanceY <= targetHeight){
//            final float scale = (float) mDisstanceY/targetHeight;
//            final float alpha = scale * 255;
//            child.setBackgroundColor(Color.argb((int)alpha,RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
//
//        }else if (mDisstanceY > targetHeight){
//            child.setBackgroundColor(Color.rgb(RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
//        }
//    }
//注意这个变量一定要定义成类变量
    private int mOffset = 0;
    //延长滑动过程
    private static final int MORE = 100;

    public TranslucentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency.getId() == R.id.rv_index;
    }

    @Override
    public boolean onStartNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout
            , @NonNull Toolbar child
            , @NonNull View directTargetChild
            , @NonNull View target
            , int axes
            , int type) {
        return true;
    }

    @Override
    public void onNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout
            , @NonNull Toolbar toolbar
            , @NonNull View target
            , int dxConsumed
            , int dyConsumed
            , int dxUnconsumed
            , int dyUnconsumed
            , int type) {
        final int startOffset = 0;
        final Context context = Latte.getApplicationContext();
        final int endOffset = context.getResources().getDimensionPixelOffset(R.dimen.header_height) + MORE;
        mOffset += dyConsumed;
        if (mOffset <= startOffset) {
            toolbar.getBackground().setAlpha(0);
        } else if (mOffset > startOffset && mOffset < endOffset) {
            final float percent = (float) (mOffset - startOffset) / endOffset;
            final int alpha = Math.round(percent * 255);
            toolbar.getBackground().setAlpha(alpha);
        } else if (mOffset >= endOffset) {
            toolbar.getBackground().setAlpha(255);
        }
    }
}
