package com.ethan.adapterdesign.adapter;

import android.view.View;

public abstract class BaseAdapter {

    // 定义标签数量
    protected abstract int getCount();
    // 创建标签的 View
    protected abstract View getView(View parent, int index);

}
