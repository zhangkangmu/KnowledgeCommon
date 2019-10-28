package com.study.hong.knowledgecommon.storage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.study.hong.knowledgecommon.R;
import com.study.hong.knowledgecommon.storage.sql.SQLDataSave;
import com.study.hong.knowledgecommon.storage.sqllitepal.SQLLitePalSave;

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
    @BindView(R.id.litepal_save)
    TextView litepalSave;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storage_main);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.text_save, R.id.shared_preference, R.id.sql_save,R.id.litepal_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_save:
                startActivity(new Intent(this, TextSave.class));
                break;
            case R.id.shared_preference:
                startActivity(new Intent(this, SharedPreferencesSave.class));
                break;
            case R.id.sql_save:
                startActivity(new Intent(this, SQLDataSave.class));
                break;
            case R.id.litepal_save:
                startActivity(new Intent(this, SQLLitePalSave.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
