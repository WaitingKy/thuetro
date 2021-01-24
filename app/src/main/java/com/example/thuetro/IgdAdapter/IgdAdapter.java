package com.example.thuetro.IgdAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thuetro.Model.Ingredients;
import com.example.thuetro.Model.Meal;
import com.example.thuetro.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.R;

public class IgdAdapter extends ArrayAdapter<String> {
    Activity context = null;
    ArrayList<String> igdArray = null;
    int layoutId;

    public IgdAdapter(Activity context, int layoutId, ArrayList<String> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.igdArray = arr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        final TextView txtdisplay = (TextView) convertView.findViewById(com.example.thuetro.R.id.txtIgdName);
        return convertView;
    }
}
