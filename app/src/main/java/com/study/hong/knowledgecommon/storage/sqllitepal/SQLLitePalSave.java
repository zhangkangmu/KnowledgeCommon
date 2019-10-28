package com.study.hong.knowledgecommon.storage.sqllitepal;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.study.hong.knowledgecommon.R;
import com.study.hong.knowledgecommon.storage.sql.SQLInfoDao;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by hong on 2019/10/28.
 */

public class SQLLitePalSave extends Activity {
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
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.modity)
    Button modity;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_save);
        unbinder = ButterKnife.bind(this);
        delete.setVisibility(View.VISIBLE);
        modity.setVisibility(View.VISIBLE);

    }

    @OnClick({R.id.save, R.id.clean, R.id.read, R.id.delete, R.id.modity})
    public void onViewClicked(View view) {
        final SQLLitepalDao dao = new SQLLitepalDao();
        switch (view.getId()) {
            case R.id.save:
                Connector.getDatabase();

                if (!TextUtils.isEmpty(username.getText()) && !TextUtils.isEmpty(password.getText())) {
                    dao.setName(username.getText().toString());
                    dao.setPassword(password.getText().toString());
                    dao.save();
                }
                break;
            case R.id.clean:
                username.setText("");
                password.setText("");
                textOut.setText("");
                break;
            case R.id.read:
                StringBuffer buffer = new StringBuffer();
                List<SQLLitepalDao> daoList = DataSupport.findAll(SQLLitepalDao.class);
                for (SQLLitepalDao daos:daoList) {
                    buffer.append(daos.getName()+"--"+daos.getPassword()+"\n");
                }
                textOut.setText(buffer.toString());
                break;
                //删除
            case R.id.delete:

                final AlertDialog.Builder builder = new AlertDialog.Builder(this);//实例化
                View inflate = View.inflate(getApplicationContext(), R.layout.sqldatasave_alertdialog, null);
                builder.setView(inflate);
                builder.create();
                final AlertDialog dialog = builder.show();
                final EditText edittext = inflate.findViewById(R.id.edittext);
                Button sure = inflate.findViewById(R.id.sure);
                Button cal = inflate.findViewById(R.id.cal);

                sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DataSupport.deleteAll(SQLLitepalDao.class, "nameName=?", edittext.getText().toString());
                        dialog.dismiss();
                    }
                });
                cal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder.setNegativeButton("取消", null);
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.modity:
                final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);//实例化
                View inflate2 = View.inflate(getApplicationContext(), R.layout.sqldatasave_alertdialog, null);
                builder2.setView(inflate2);
                builder2.create();
                final AlertDialog dialog2 = builder2.show();
                Button sure2 = inflate2.findViewById(R.id.sure);
                Button cal2 = inflate2.findViewById(R.id.cal);

                final EditText edittext2 = inflate2.findViewById(R.id.edittext);
                sure2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dao.setPassword(edittext2.getText().toString());
                        //这里修成成默认的密码，就不设置对话框了
                        dao.setPassword("123456");
                        dao.updateAll("nameName=?", edittext2.getText().toString());
                        Log.e("zzzzzzz", edittext2.getText().toString());
                        dialog2.dismiss();
                    }
                });
                cal2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder2.setNegativeButton("取消", null);
                        dialog2.dismiss();
                    }
                });
                builder2.setNeutralButton("跳过", null);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
