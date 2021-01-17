package com.example.thuetro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.thuetro.Model.Ingredients;
import com.example.thuetro.Model.Meal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Meal5Activity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference getMeal = db.getReference("Meal");
    DatabaseReference getIngredients = db.getReference("Ingredients");

    CheckBox cbx1, cbx2, cbx3, cbx4, cbx5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal5);

        init();
    }

    public void init() {
        cbx1 = (CheckBox) findViewById(R.id.cbx1);
        cbx2 = (CheckBox) findViewById(R.id.cbx2);
        cbx3 = (CheckBox) findViewById(R.id.cbx3);
        cbx4 = (CheckBox) findViewById(R.id.cbx4);
        cbx5 = (CheckBox) findViewById(R.id.cbx5);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        int intkey = Integer.parseInt(key);
        if (intkey < 10) {
            String stringkey = "0" + String.valueOf(intkey);
            getIngredients.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Ingredients igd = snapshot.child(stringkey).getValue(Ingredients.class);
                    cbx1.setText(igd.getMot());
                    cbx2.setText(igd.getHai());
                    cbx3.setText(igd.getBa());
                    cbx4.setText(igd.getBon());
                    cbx5.setText(igd.getNam());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}