package com.ethan.adapterdesign.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import static android.widget.LinearLayout.HORIZONTAL;

/**
 * 碧云天
 *
 * MyTabLayout
 */
public class MyTabLayout extends ScrollView {

    private LinearLayout mLinearLayout;
    private BaseAdapter mBaseAdapter;
    private int itemCount;

    public MyTabLayout(Context context) {
        this(context, null);
    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr){
        mLinearLayout = new LinearLayout(context);
        mLinearLayout.setOrientation(HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLinearLayout.setLayoutParams(layoutParams);
        // 我们这个 View继承自 ScrollView，只能有一个字View
        // 所以我们给它添加一个 LinearLayout，来装所有的 ItemView
        addView(mLinearLayout);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        if (baseAdapter == null){
            throw  new NullPointerException("Adapter is null");
        }
        mBaseAdapter = baseAdapter;
        itemCount = mBaseAdapter.getCount();
        addItem();
    }

    private void addItem(){
       for (int i = 0 ; i < itemCount; i ++){
           // 向布局 LinearLayout循环添加 所有 ItemView
           mLinearLayout.addView(mBaseAdapter.getView(mLinearLayout, i));
       }
    }
}
