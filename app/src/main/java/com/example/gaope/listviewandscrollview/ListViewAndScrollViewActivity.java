package com.example.gaope.listviewandscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *  ListView和ScrollView的冲突
 *  ScrollView嵌套ListView时，ListView只显示第一个item
 *  https://www.jianshu.com/p/dd5b90720a12
 *  ScrollView和ListView的源码onMeasure()方法分析得到冲突的原因
 *  通过改变ListView的onMeasure()方法解决冲突
 */

public class ListViewAndScrollViewActivity extends AppCompatActivity {


    private List<String> stringList;
    private ListView listView;
    private ListViewAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_and_scroll_view);

        init();
        listView = (ListView) findViewById(R.id.listview);
        listAdapter = new ListViewAdapter(stringList,getBaseContext());
        listView.setAdapter(listAdapter);
    }

    private void init() {
        stringList = new ArrayList<>();
        for (int i = 0;i < 20;i++){
            stringList.add("第" + i + "个");
        }
    }
}
