package cn.hanker.latteec.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.util.Patterns;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latteec.R;
import cn.hanker.latteec.R2;

/**
 * @auther jh
 * @des 登录页面
 * Created by J.H on 2018/4/20.
 */
public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.btn_sign_in)
    AppCompatButton mSignIn = null;

    @BindView(R2.id.edit_signin_email)
    TextInputEditText mEmail = null;

    @BindView(R2.id.edit_signin_pwd)
    TextInputEditText mPwd = null;

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){
        checkForm();
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat(){

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLinkSignUp(){
        start(new SignUpDelegate());
    }



    private boolean checkForm(){

        final String email = mEmail.getText().toString();
        final String pwd = mPwd.getText().toString();
        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }else{
            mEmail.setError(null);
        }

        if (pwd.isEmpty() || pwd.length()<6){
            mPwd.setError("请填写至少六位");
            isPass = false;
        }else{
            mPwd.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
