package com.andevcba.materializeme.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pattern implements Parcelable {

    public String id;
    public String name;
    public String shortDescription;
    public String description;

    public Pattern(String id, String name, String shortDescription, String description) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.shortDescription);
        dest.writeString(this.description);
    }

    protected Pattern(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.shortDescription = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Pattern> CREATOR = new Creator<Pattern>() {
        @Override
        public Pattern createFromParcel(Parcel source) {
            return new Pattern(source);
        }

        @Override
        public Pattern[] newArray(int size) {
            return new Pattern[size];
        }
    };
}
