package com.androidstudy.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidstudy.R;
import com.androidstudy.adapter.RecyclerAdapter;
import com.androidstudy.databinding.ActivityMainBinding;
import com.androidstudy.model.LocationData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setRecyclerView(binding.recyclerView);
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
        adapter = new RecyclerAdapter();
        adapter.setLocationDataList(getLocationData());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
