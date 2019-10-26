package com.study.hong.knowledgecommon.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.study.hong.knowledgecommon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by hong on 2019/10/26.
 */

public class SharedPreferencesSave extends Activity {
    @BindView(R.id.text_out)
    TextView textOut;
    @BindView(R.id.username)
    TextInputEditText username;
    @BindView(R.id.layout_username)
    TextInputLayout layoutUsername;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.layout_password)
    TextInputLayout layoutPassword;
    @BindView(R.id.save)
    Button save;
    @BindView(R.id.clean)
    Button clean;
    @BindView(R.id.read)
    Button read;
    private Unbinder unbind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_save);
        unbind = ButterKnife.bind(this);
    }

    @OnClick({R.id.save, R.id.clean, R.id.read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.save:
                if (!TextUtils.isEmpty(username.getText()) && !TextUtils.isEmpty(password.getText())) {
                    SharedPreferences.Editor editor = getSharedPreferences("sharedpreferences_save", Context.MODE_PRIVATE).edit();
                    editor.putString("username",username.getText()+"");
                    editor.putString("password",password.getText()+"");
                    editor.apply();
                }else {
                    Toast.makeText(getApplicationContext(),"账号和密码不能为空！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.clean:
                username.setText("");
                password.setText("");
                textOut.setText("");
                break;
            case R.id.read:
                SharedPreferences preferences=getSharedPreferences("sharedpreferences_save", Context.MODE_PRIVATE);
                textOut.setText(preferences.getString("username","")+"\n"+
                preferences.getString("password",""));
                break;
        }
    }
}
