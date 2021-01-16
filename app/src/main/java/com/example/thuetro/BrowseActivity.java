package com.example.thuetro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thuetro.MealList.MealList;
import com.example.thuetro.Model.Meal;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BrowseActivity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();

    private ArrayList<Meal> mealList = new ArrayList<Meal>();
    private ArrayAdapter<String> adapter = null;

    Meal meal;
    ListView lvMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        init();
    }

    public void init() {

        DatabaseReference getMeal = db.getReference("Meal");
        lvMeal = (ListView) findViewById(R.id.lvMeal);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        getMeal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    String title = data.getValue().toString();
                    adapter.add(title);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lvMeal.setAdapter(adapter);
    }
}