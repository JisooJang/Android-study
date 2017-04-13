package com.androidstudy.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.androidstudy.R;
import com.androidstudy.databinding.RecyclerItemBinding;
import com.androidstudy.model.LocationData;
import com.androidstudy.viewmodel.LocationDataVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chosw on 2017-04-04.
 */

public class DataBindingRecyclerAdapter extends RecyclerView.Adapter<DataBindingRecyclerAdapter.ViewHolder>{

    private int layoutManager = 0;
    private List<LocationData> locationDataList = new ArrayList<>();

    public DataBindingRecyclerAdapter()
    {
    }

    public void setLocationDataList(List<LocationData> locationDataList)
    {
        this.locationDataList = locationDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        RecyclerItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(locationDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return locationDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private RecyclerItemBinding binding;

        public ViewHolder(RecyclerItemBinding binding) {
            super(binding.placeHolder);
            this.binding = binding;
        }

        void bindItem(LocationData locationData) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new LocationDataVM(locationData));
            } else {
                binding.getViewModel().setLocationData(locationData);
            }
        }
    }
}
