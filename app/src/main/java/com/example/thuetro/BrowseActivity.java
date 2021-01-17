package com.example.thuetro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    private List<Meal> mealList = new ArrayList<Meal>();
    private ArrayAdapter<Meal> adapter = null;

    Meal meal;
    ListView lvMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        init();
        lvClicked();
    }

    public void init() {

        DatabaseReference getMeal = db.getReference("Meal");
        lvMeal = (ListView) findViewById(R.id.lvMeal);

        adapter = new ArrayAdapter<Meal>(this, android.R.layout.simple_list_item_1, mealList);

        getMeal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    meal = data.getValue(Meal.class);
                    mealList.add(meal);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lvMeal.setAdapter(adapter);
    }

    public void lvClicked() {
        lvMeal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseReference getIngredients = db.getReference("Ingredients");
                Intent intent = new Intent(BrowseActivity.this, Meal5Activity.class);
                String key = String.valueOf(position);
                intent.putExtra("key", key);
                startActivity(intent);
            }
        });
    }
}