package com.study.hong.knowledgecommon.storage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.study.hong.knowledgecommon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by hong on 2019/10/26.
 */

public class StorageMain extends Activity {
    @BindView(R.id.text_save)
    TextView textSave;
    @BindView(R.id.shared_preference)
    TextView sharedPreference;
    @BindView(R.id.sql_save)
    TextView sqlSave;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storage_main);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.text_save, R.id.shared_preference, R.id.sql_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_save:
                startActivity(new Intent(this, TextSave.class));
                break;
            case R.id.shared_preference:
                startActivity(new Intent(this, SharedPreferencesSave.class));
                break;
            case R.id.sql_save:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
