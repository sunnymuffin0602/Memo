package com.example.hinata.memo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MemoCreateActivity extends AppCompatActivity {

    MemoDB mMemoDB;
    EditText mTitle;
    EditText mMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_create);

        mMemoDB = new MemoDB();
        mTitle = (EditText)findViewById(R.id.create_title);
        mMemo = (EditText)findViewById(R.id.create_memo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_memo_create, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_save:
                // createの処理をここに書く
                saveMemo();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void saveMemo(){
        mMemoDB.title = mTitle.getText().toString();
        mMemoDB.mamo = mMemo.getText().toString();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        mMemoDB.date = sdf.format(date);
        mMemoDB.save();
    }
}
