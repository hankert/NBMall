package cn.hanker.mall.generators;

import com.hanker.annotations.AppRegisterGenerator;

import com.flowbank.wo.wechat.templates.AppRegisterTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.flowbank.wo",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
