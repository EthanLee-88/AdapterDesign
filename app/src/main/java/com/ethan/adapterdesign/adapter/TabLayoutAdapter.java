package com.ethan.adapterdesign.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ethan.adapterdesign.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutAdapter extends BaseAdapter{
    private List<String> data;

    public TabLayoutAdapter(){
        data = new ArrayList<>();
    }

    public TabLayoutAdapter setData(List<String> data1){
        data.clear();
        data.addAll(data1);
        // 链式结构
        return this;
    }

    @Override
    protected int getCount() {
        return data.size();
    }

    @Override
    protected View getView(View parent, int index) {
        // 创建一个 Item
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab, null);
        TextView textView = itemView.findViewById(R.id.tab_text);
        textView.setText(data.get(index));
        // 测试
        if (index == 3) textView.setTextColor(Color.RED);
        // 返回 Item
        return itemView;
    }
}