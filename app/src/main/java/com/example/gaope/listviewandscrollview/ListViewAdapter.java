package com.example.gaope.listviewandscrollview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * ListView的适配器
 * Created by gaope on 2018/5/30.
 */

public class ListViewAdapter extends BaseAdapter {

    private List<String> stringList;
    private Context context;



    public ListViewAdapter(List<String> stringList,Context context){
        this.stringList = stringList;
        this.context = context;
    }

    static class ViewHolder{

        TextView textView;

        public ViewHolder(View view ){
            textView = view.findViewById(R.id.list_text);
        }
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView:将之间加载好的布局进行缓存
        //View中的setTag(Onbect)给View添加一个格外的数据
        //用getTag()获取到对应的View
        //setTag()与getTag()是成对出现的
        View view;
        ViewHolder viewHolder;
        String aa = stringList.get(position);
        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.listview_adapter,parent,false);
            viewHolder = new ViewHolder(view);
            //将ViewHolder存储在view中
            view.setTag(viewHolder);
        }else {
            view = convertView;
            //重新获取ViewHolder
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(aa);
        return view;
    }

}
