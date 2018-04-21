package cn.hanker.mall.generators;

import com.hanker.annotations.EntryGenerator;

import cn.hanker.latte.app.wechat.templates.WXEntryTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "cn.hanker.mall",
        entryTemplate = WXEntryTemplate.class
)
public interface WechatEntry {
}
