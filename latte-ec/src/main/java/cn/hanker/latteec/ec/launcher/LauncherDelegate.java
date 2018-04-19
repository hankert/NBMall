package cn.hanker.latteec.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latte.app.util.timer.BaseTimerTask;
import cn.hanker.latte.app.util.timer.ITimerListener;
import cn.hanker.latteec.R;
import cn.hanker.latteec.R2;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/19.
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener{


    private Timer mTimer = null;

    private int mCount = 5;

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvLauncherTimer = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView(){


    }

    private void initTimer(){
        mTimer = new Timer();
        final BaseTimerTask timerTask = new BaseTimerTask(this);
        mTimer.schedule(timerTask, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        initTimer();

    }


    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mTvLauncherTimer != null){
                    mTvLauncherTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0){
                        if (mTimer != null){
                            mTimer.cancel();
                            mTimer = null;
                        }
                    }
                }
            }
        });
    }
}
