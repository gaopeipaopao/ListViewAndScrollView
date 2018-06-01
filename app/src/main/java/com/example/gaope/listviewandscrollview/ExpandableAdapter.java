package com.example.gaope.listviewandscrollview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gaope on 2018/6/1.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private String[] group;
    private String[][] member;
    private Context context;

    public ExpandableAdapter(Context contexts,String[] group,String[][] member){
        this.group = group;
        this.member = member;
        this.context = contexts;
    }

    static class ViewHolder{
        TextView textView1;
        ViewHolder(View view){
            textView1 = (TextView) view.findViewById(R.id.textaaa);
        }
    }

    //返回分组的个数
    @Override
    public int getGroupCount() {
        return group.length;
    }

    //返回指定分组中的子选项的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return member[groupPosition].length;
    }

    //获取指定的分组的数据
    @Override
    public Object getGroup(int groupPosition) {
        return group[groupPosition];
    }

    //获取指定的分组的子选项的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return member[groupPosition][childPosition];
    }

    //获取指定分组的id,id是一定的
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取指定分组的子选项的id,id是一定的
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //        分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们。
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.expandable_text,parent,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(group[groupPosition]);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.expandable_text,parent,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(member[groupPosition][childPosition]);
        return view;
    }

    //        指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
