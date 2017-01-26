package com.example.hinata.memo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by hinata on 2017/01/26.
 */

@Table(name = "memo_table")
public class MemoDB  extends Model{

    @Column (name = "title")
    public String title;

    @Column(name = "memo")
    public String memo;

    @Column(name = "date")
    public String date;

    @Override
    public String toString() {
        return title;
    }
}
