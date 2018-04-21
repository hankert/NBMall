package cn.hanker.mall.generators;

import com.hanker.annotations.PayEntryGenerator;

import cn.hanker.latte.app.wechat.templates.WXPayEntryTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "cn.hanker.mall",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WechatPayEntry {
}
