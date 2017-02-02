package com.example.hinata.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MemoDetailActivity extends AppCompatActivity {

    MemoDB mMemoDB;
    EditText mTitle;
    EditText mMemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);

        mTitle = (EditText) findViewById(R.id.detail_title);
        mMemo = (EditText) findViewById(R.id.detail_memo);

        setmMemo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memu_memo_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    void setmMemo() {
        Intent intent = getIntent();
        List<MemoDB> memoList = new Select().from(MemoDB.class).where("date = ?", intent.getStringExtra("date")).execute();
        mMemoDB = memoList.get(0);
        mTitle.setText(mMemoDB.title);
        mMemo.setText(mMemoDB.memo);
    }

    void updateMemo() {
        mMemoDB.title = mTitle.getText().toString();
        mMemoDB.memo = mMemo.getText().toString();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        mMemoDB.date = sdf.format(date);
        mMemoDB.save();
    }

    void deleteMemo() {
        mMemoDB.delete();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.detail_save:
                updateMemo();
                finish();
                return true;

            case R.id.detail_delete:
                deleteMemo();
                finish();

                return true;
        }
        return onOptionsItemSelected(item);
    }
}

