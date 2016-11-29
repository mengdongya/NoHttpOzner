package com.mdy.nohttpozner;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mdy.nohttpozner.util.HttpHelper;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_btn_login)
    TextView loginIn;
    @BindView(R.id.login_btn_codeget)
    TextView getCode;
    @BindView(R.id.login_btn_voice)
    TextView getVoiceCode;
    @BindView(R.id.login_et_phone)
    TextView telephone;
    @BindView(R.id.login_et_code)
    TextView code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_btn_login,R.id.login_btn_codeget,R.id.login_btn_voice})
    void doClick(View v) {
        switch (v.getId()){
            case R.id.login_btn_codeget:
                HttpHelper.getPhoneCode(LoginActivity.this,telephone.getText().toString().trim(),new Listener());
                getCode.setEnabled(false);
                break;
            case R.id.activity_login:
                HttpHelper.loginIn(LoginActivity.this,telephone.getText().toString().trim(),code.getText().toString().trim(),new Listener());
                break;
            case R.id.login_btn_voice:
                HttpHelper.getVoiceCode(LoginActivity.this,telephone.getText().toString().trim(),new Listener());
                break;
        }
    }


    class Listener implements OnResponseListener {
        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response response) {

        }

        @Override
        public void onFailed(int what, Response response) {

        }

        @Override
        public void onFinish(int what) {

        }
    }
}
