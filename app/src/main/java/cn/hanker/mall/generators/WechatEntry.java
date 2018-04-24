package cn.hanker.mall.generators;

import com.hanker.annotations.EntryGenerator;

import com.flowbank.wo.wechat.templates.WXEntryTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.flowbank.wo",
        entryTemplate = WXEntryTemplate.class
)
public interface WechatEntry {
}
