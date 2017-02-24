package com.example.vamp.expandablelistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by VAMP on 23-Feb-17.
 */

public class MainActivity extends AppCompatActivity {
ExpandableListView expandableListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView)findViewById(R.id.exp_listview);
        List<String> Headings= new ArrayList<String>();
        List<String> L1= new ArrayList<String>();
        List<String> L2= new ArrayList<String>();
        List<String> L3= new ArrayList<String>();
        HashMap<String,List<String>> ChildList = new HashMap<String, List<String>>();
        String heading_items[] = getResources().getStringArray(R.array.header);
        String l1[]=getResources().getStringArray(R.array.h1_item);
        String l2[]=getResources().getStringArray(R.array.h2_item);
        String l3[]=getResources().getStringArray(R.array.batman);
        for (String title: heading_items)
        {
          Headings.add(title);
        }
        for (String title: l1)
        {
            L1.add(title);
        }for (String title: l2)
        {
            L2.add(title);
        }
        for (String title: l3)
        {
            L3.add(title);
        }
        ChildList.put(Headings.get(0),L1);
        ChildList.put(Headings.get(1),L2);
        ChildList.put(Headings.get(2),L3);
        MyAdaptor myAdaptor = new MyAdaptor(this,Headings,ChildList);
        expandableListView.setAdapter(myAdaptor);






    }
}
