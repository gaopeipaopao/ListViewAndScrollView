package com.example.gaope.listviewandscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * ExpandableListView的尝试
 * 垂直滚动展示两级列表的视图
 */

public class ExpandableListViewActivity extends AppCompatActivity {

    private static final String TAG = "ExpandableListViewActiv";

//    private List<String> groupLists;
//    private List<String> memberLists;
    private String[] group;
    private String[][] member;
    private ExpandableListView expandableView;
    private ExpandableAdapter expandableAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);

        init();
        expandableView = (ExpandableListView) findViewById(R.id.expandable_view);
        expandableAdapter = new ExpandableAdapter(getBaseContext(),group,member);
        expandableView.setAdapter(expandableAdapter);

    }

    private void init() {
        group = new String[]{"aaa","bbb","ccc"};
        member = new String[][]{{"a","b","c","d"},{"a","b","c"},{"a","b","c"}};
    //    Log.d(TAG,":"+member[0].length);
//        groupLists = new ArrayList<>();
//        memberLists = new ArrayList<>();

    }
}
