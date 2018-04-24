package cn.hanker.mall.generators;

import com.hanker.annotations.PayEntryGenerator;

import com.flowbank.wo.wechat.templates.WXPayEntryTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.flowbank.wo",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WechatPayEntry {
}
