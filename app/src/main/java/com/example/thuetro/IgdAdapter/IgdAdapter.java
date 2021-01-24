package com.example.thuetro.IgdAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thuetro.Model.Ingredients;

import java.util.ArrayList;

public class IgdAdapter extends ArrayAdapter<Ingredients> {
    Activity context = null;
    ArrayList<Ingredients> igdList = null;
    int layoutId;

    public IgdAdapter(Activity context, int layoutId, ArrayList<Ingredients> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.igdList = arr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (igdList.size() > 0 && position >= 0) {
            
        }
    }
}
