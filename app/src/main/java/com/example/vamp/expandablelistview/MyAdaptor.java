package com.example.vamp.expandablelistview;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import java.util.*;
import android.content.*;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by VAMP on 23-Feb-17.
 */

public class MyAdaptor extends BaseExpandableListAdapter {
    private List<String> header_titles;
    private HashMap <String,List<String>> child_titles;
    private Context ctx;

    MyAdaptor(Context ctx, List<String> header_titles,HashMap <String,List<String>> child_titles){

        this.ctx=ctx;
        this.child_titles=child_titles;
        this.header_titles=header_titles;

    }
    @Override
    public int getGroupCount() {
        return header_titles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child_titles.get(header_titles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return header_titles.get(i);
    }

    @Override
    public Object getChild(int i, int j ) {
        return child_titles.get(header_titles.get(i)).get(j);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int j) {
        return j;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getGroup(i);
        if(view == null){

            LayoutInflater layoutInflater= (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.parent_layout,null);
        }
        TextView textView = (TextView) view.findViewById(R.id.heading_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int j, boolean b, View view, ViewGroup viewGroup) {

        String title=(String) this.getChild(i,j) ;
        if(view == null){

            LayoutInflater layoutInflater= (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.child_layout,null);
        }
        final TextView textView = (TextView) view.findViewById(R.id.child_item);
        textView.setText(title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int j) {
        return true;
    }
}
