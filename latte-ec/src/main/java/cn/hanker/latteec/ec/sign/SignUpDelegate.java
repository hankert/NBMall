package cn.hanker.latteec.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hanker.latte.app.delegates.LatteDelegate;
import cn.hanker.latteec.R;
import cn.hanker.latteec.R2;

/**
 * @auther jh
 * @des 注册页面
 * Created by J.H on 2018/4/20.
 */
public class SignUpDelegate extends LatteDelegate{


    @BindView(R2.id.edit_signup_name)
    TextInputEditText mName;
    @BindView(R2.id.edit_signup_email)
    TextInputEditText mEmail;
    @BindView(R2.id.edit_signup_phone)
    TextInputEditText mPhone;
    @BindView(R2.id.edit_signup_pwd)
    TextInputEditText mPwd;
    @BindView(R2.id.edit_signup_repwd)
    TextInputEditText mRePwd;
    @BindView(R2.id.btn_sign_up)
    AppCompatButton mSignUp;

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp(){
        if (checkForm()){
//            RestClient.builder()
//                    .url("sign_up")
//                    .params("", "")
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//
//                        }
//                    })
//                    .build()
//                    .post();
            Toast.makeText(getContext(), "验证成功", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLinkSignIn(){
       start(new SignInDelegate());
    }

    private boolean checkForm(){
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String pwd = mPwd.getText().toString();
        final String repwd = mRePwd.getText().toString();
        boolean isPass = true;

        if (name.isEmpty()){
            mName.setError("请输入姓名");
            isPass = false;
        }else{
            mName.setError(null);
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }else{
            mEmail.setError(null);
        }
        if (phone.isEmpty() || phone.length() != 11){
            mPhone.setError("请输入电话号码");
            isPass = false;
        }else{
            mPhone.setError(null);
        }
        if (pwd.isEmpty() || pwd.length()<6){
            mPwd.setError("请填写至少六位");
            isPass = false;
        }else{
            mPwd.setError(null);
        }
        if (repwd.isEmpty() || pwd.length()<6 || !pwd.equals(repwd)){
            mRePwd.setError("密码验证错误");
            isPass = false;
        }else{
            mRePwd.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
