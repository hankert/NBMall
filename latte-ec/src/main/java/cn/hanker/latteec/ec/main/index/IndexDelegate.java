package cn.hanker.latteec.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;
import cn.hanker.latte.app.delegates.BaseBottom.BottomItemDelegate;
import cn.hanker.latte.app.ui.recycler.BaseDecoration;
import cn.hanker.latte.app.ui.refresh.RefreshHandler;
import cn.hanker.latteec.R;
import cn.hanker.latteec.R2;
import cn.hanker.latteec.ec.main.EcBottomDelegate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class IndexDelegate extends BottomItemDelegate{


    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;

    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mSwipeRefreshLayout = null;

    @BindView(R2.id.tv_index)
    Toolbar mToolbar = null;

    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;

    @BindView(R2.id.icon_index_message)
    IconTextView mIconMessage = null;

    private RefreshHandler mRefreshHandler = null;



    private void initRefreshLayout(){
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mSwipeRefreshLayout.setProgressViewOffset(true, 120, 300);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
        mRefreshHandler.firstPage("index.php");
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    /**
     * 初始化布局管理器
     */
    private void initRecyclerView(){
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(BaseDecoration.create(ContextCompat.getColor(getContext(), R.color.app_background), 5));
        final EcBottomDelegate ecBottomDelegate = getParentDelegate();
        mRecyclerView.addOnItemTouchListener(IndexItemClickListener.create(ecBottomDelegate));

    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = RefreshHandler.create(mSwipeRefreshLayout, mRecyclerView, new IndexDataConvert());


    }
}
