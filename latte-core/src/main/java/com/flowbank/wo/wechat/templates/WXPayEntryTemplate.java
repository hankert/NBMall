package com.flowbank.wo.wechat.templates;

import android.widget.Toast;

import com.tencent.mm.opensdk.modelbase.BaseReq;

import com.flowbank.wo.wechat.BaseWXPayEntryActivity;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
public class WXPayEntryTemplate extends BaseWXPayEntryActivity {


    @Override
    protected void onPaySuccess() {
        Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onPayFail() {
        Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onPayCancel() {
        Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }
}
