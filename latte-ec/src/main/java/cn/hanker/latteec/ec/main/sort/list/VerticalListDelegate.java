package cn.hanker.latteec.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latte.app.net.RestClient;
import cn.hanker.latte.app.net.callback.IError;
import cn.hanker.latte.app.net.callback.ISuccess;
import cn.hanker.latte.app.ui.recycler.MultipleItemEntity;
import cn.hanker.latte.app.util.log.LatteLogger;
import cn.hanker.latteec.R;
import cn.hanker.latteec.R2;
import cn.hanker.latteec.ec.main.sort.SortDelegate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/25.
 */
public class VerticalListDelegate extends LatteDelegate {

    @BindView(R2.id.rv_vertical_menu_list)
    RecyclerView mRecyclerView;

    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    private void initRecyclerView() {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        // 屏蔽动画效果
        mRecyclerView.setItemAnimator(null);


    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initRecyclerView();

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("sort_list.php")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        LatteLogger.d("list_menu", response);
                        final List<MultipleItemEntity> data = new VerticalListDataConvert().setJsonData(response).convert();
                        final SortDelegate delegate = getParentDelegate();
                        final SortRecyclerAdapter adapter = new SortRecyclerAdapter(data, delegate);
                        mRecyclerView.setAdapter(adapter);

                    }
                }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

                }
            })
                .build()
                .get();
    }
}
