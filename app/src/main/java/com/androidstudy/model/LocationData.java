package com.androidstudy.model;

import android.graphics.drawable.Drawable;

/**
 * Created by chosw on 2017-04-08.
 */

public class LocationData {

    private Drawable locationImage;
    private String locationName;

    public LocationData(Drawable locationImage, String locationName) {
        this.locationImage = locationImage;
        this.locationName = locationName;
    }

    public Drawable getLocationImage() {
        return locationImage;
    }

    public void setLocationImage(Drawable locationImage) {
        this.locationImage = locationImage;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
