package com.example.zhongcheng.components;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhongcheng on 16/7/28.
 */
public class MyRect implements Parcelable{
    int left;
    int right;
    protected MyRect(Parcel in) {
        readFromParcel(in);

    }

    public MyRect(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public static final Creator<MyRect> CREATOR = new Creator<MyRect>() {
        @Override
        public MyRect createFromParcel(Parcel in) {
            return new MyRect(in);
        }

        @Override
        public MyRect[] newArray(int size) {
            return new MyRect[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(left);
        dest.writeInt(right);


    }
    public void readFromParcel(Parcel in){
        left = in.readInt();
        right = in.readInt();

    }
}
