package com.example.hinata.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.memo_list);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setMemoList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_create:
                Intent intent = new Intent(MainActivity.this, MemoCreateActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void setMemoList() {
        List<MemoDB> memoList = new Select().from(MemoDB.class).execute();

        ArrayAdapter<MemoDB> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.memo_row, memoList);
        mListView.setAdapter(adapter);
    }

}
