package com.androidstudy.viewmodel;

import android.graphics.drawable.Drawable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.androidstudy.model.LocationData;

/**
 * Created by chosw on 2017-04-08.
 */

public class LocationDataVM {

    private LocationData locationData;

    public LocationDataVM(LocationData locationData)
    {
        this.locationData = locationData;
    }

    public void setLocationData(LocationData locationData)
    {
        this.locationData = locationData;
    }

    public String getLocationName()
    {
        return locationData.getLocationName();
    }

    public Drawable getLocationImage()
    {
        return locationData.getLocationImage();
    }

    public void locationItemClick(View view)
    {
        Snackbar.make(view, getLocationName(), BaseTransientBottomBar.LENGTH_SHORT).show();
    }
}
