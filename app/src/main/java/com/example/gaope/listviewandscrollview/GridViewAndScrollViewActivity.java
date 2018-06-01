package com.example.gaope.listviewandscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *  GridView和ScrollView的冲突
 *  ScrollView嵌套GridView时，GridView只显示第一个item
 *  https://www.jianshu.com/p/dd5b90720a12
 *  ScrollView和GridView的源码onMeasure()方法分析得到冲突的原因
 *  通过改变GridView的onMeasure()方法解决冲突
 */


public class GridViewAndScrollViewActivity extends AppCompatActivity {

    private List<String> stringList;
    private GridView gridView;
    private ListViewAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_and_scroll_view);

        init();
        gridView = (GridView) findViewById(R.id.gridview);
        listAdapter = new ListViewAdapter(stringList,getBaseContext());
        gridView.setAdapter(listAdapter);
    }

    private void init() {
        stringList = new ArrayList<>();
        for (int i = 0;i < 40;i++){
            stringList.add("第" + i + "个");
        }
    }
}
