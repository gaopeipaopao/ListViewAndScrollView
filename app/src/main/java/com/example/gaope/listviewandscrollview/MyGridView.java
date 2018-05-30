package com.example.gaope.listviewandscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by gaope on 2018/5/30.
 */

public class MyGridView extends GridView {

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxHeight = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, maxHeight);
    }
}
