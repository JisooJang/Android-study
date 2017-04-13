package com.androidstudy.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidstudy.R;
import com.androidstudy.adapter.DataBindingRecyclerAdapter;
import com.androidstudy.adapter.DefaultRecyclerAdapter;
import com.androidstudy.model.LocationData;

import java.util.ArrayList;
import java.util.List;

public class DefaultMainActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private DefaultRecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setRecyclerView(recyclerView);
    }

    private List<LocationData> getLocationData()
    {
        List<LocationData> locationDataList = new ArrayList<>();

        for(int i=0; i<9; i++)
        {
            locationDataList.add(new LocationData(getResources().getDrawable(R.drawable.station01+i), "Location 0"+i));
        }

        return locationDataList;
    }

    private void setRecyclerView(RecyclerView recyclerView)
    {
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new DefaultRecyclerAdapter();
        adapter.setLocationDataList(getLocationData());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
