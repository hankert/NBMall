package cn.hanker.latte.app.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;

import cn.hanker.latte.app.Latte;
import cn.hanker.latte.app.net.RestClient;
import cn.hanker.latte.app.net.callback.ISuccess;
import cn.hanker.latte.app.ui.recycler.DataConverter;
import cn.hanker.latte.app.ui.recycler.MultipleRecyclerAdapter;

/**
 * @auther jh
 * @des 刷新助手
 * Created by J.H on 2018/4/24.
 */
public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener{

    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLERVIEW;
    private MultipleRecyclerAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    private RefreshHandler(SwipeRefreshLayout refresh_layout, PagingBean bean, RecyclerView recyclerview, DataConverter converter) {
        this.REFRESH_LAYOUT = refresh_layout;
        this.BEAN = bean;
        this.RECYCLERVIEW = recyclerview;
        this.CONVERTER = converter;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static RefreshHandler create(SwipeRefreshLayout refresh_layout, RecyclerView recyclerview, DataConverter converter){
        return new RefreshHandler(refresh_layout, new PagingBean(), recyclerview, converter);
    }

    private void refresh(){
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 进行网络请求 成功将状态置为false
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    public void firstPage(String url){
        BEAN.setDelayed(1000);
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject object = JSON.parseObject(response);
                        BEAN.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        // 设置adapter
                        mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this, RECYCLERVIEW);
                        RECYCLERVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();
                    }
                })
                .build()
                .get();


    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
