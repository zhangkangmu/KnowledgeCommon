package com.study.hong.knowledgecommon.storage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.study.hong.knowledgecommon.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by hong on 2019/10/26.
 */

public class TextSave extends Activity {
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
    @BindView(R.id.text_out)
    TextView textOut;
    private Unbinder unbinder;
    private FileOutputStream user_text;
    private BufferedWriter writer;
    private FileInputStream in;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_save);
        unbinder = ButterKnife.bind(this);
        //监听文本
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("zzzzzzz", "beforeTextChanged：" + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("zzzzzzz", "onTextChanged：" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("zzzzzzz", "afterTextChanged：" + s);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.save, R.id.clean, R.id.read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.save:
                save();
                Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.clean:
                username.setText("");
                password.setText("");
                textOut.setText("");
                break;
            case R.id.read:
                load();
                break;
        }
    }

    private void save() {
        try {
//            Context.MODE_PRIVATE:默认，下次存储的时候会清除
//            Context.MODE_APPEND：追加
            user_text = openFileOutput("user_text", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(user_text));
            writer.write(username.getText() + "-" + password.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void load() {
        try {
            in = openFileInput("user_text");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                textOut.setText(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
