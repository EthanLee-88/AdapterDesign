package com.ethan.adapterdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ethan.adapterdesign.adapter.BaseAdapter;
import com.ethan.adapterdesign.adapter.MyTabLayout;
import com.ethan.adapterdesign.adapter.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyTabLayout mTableLayout;
    private List<String> data = new ArrayList<>();
    private BaseAdapter mTabLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTableLayout = findViewById(R.id.my_tab);
        data.add("首页");
        data.add("手机");
        data.add("美妆");
        data.add("运动");
        data.add("食品");
        init();
    }

    private void init(){
        mTabLayoutAdapter = new TabLayoutAdapter().setData(data);
        // 设置适配器
        mTableLayout.setAdapter(mTabLayoutAdapter);
    }
}