package cn.hanker.latte.app.util.timer;

import java.util.TimerTask;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/19.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener itimerlistener) {
        mITimerListener = itimerlistener;
    }

    @Override
    public void run() {
           if (mITimerListener != null){
               mITimerListener.onTimer();
           }
    }
}
