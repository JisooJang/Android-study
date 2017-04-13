package com.androidstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidstudy.R;
import com.androidstudy.model.LocationData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chosw on 2017-04-04.
 */

public class DefaultRecyclerAdapter extends RecyclerView.Adapter<DefaultRecyclerAdapter.ViewHolder>{

    private List<LocationData> locationDataList = new ArrayList<>();

    public DefaultRecyclerAdapter()
    {
    }

    public void setLocationDataList(List<LocationData> locationDataList)
    {
        this.locationDataList = locationDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(locationDataList.get(position).getLocationImage());
        holder.textView.setText(locationDataList.get(position).getLocationName());
    }

    @Override
    public int getItemCount() {
        return locationDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.locationImage);
            textView = (TextView) view.findViewById(R.id.locationName);
        }
    }
}
