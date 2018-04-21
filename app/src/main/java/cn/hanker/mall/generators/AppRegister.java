package cn.hanker.mall.generators;

import com.hanker.annotations.AppRegisterGenerator;

import cn.hanker.latte.app.wechat.templates.AppRegisterTemplate;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/21.
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "cn.hanker.mall",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
