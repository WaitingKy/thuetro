package com.example.thuetro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thuetro.Model.Ingredients;
import com.example.thuetro.Model.Meal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

public class Meal5Activity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference getMeal = db.getReference("Meal");
    DatabaseReference getIngredients = db.getReference("Ingredients");
    DatabaseReference getImage = db.getReference("Image");

    CheckBox cbx1, cbx2, cbx3, cbx4, cbx5;
    ImageView imgMeal;
    TextView txtContent;
    Bitmap bitmap;

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

        imgMeal = (ImageView) findViewById(R.id.imgMeal);

        txtContent = (TextView) findViewById(R.id.txtContent);

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

            getMeal.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Meal meal = snapshot.child(stringkey).getValue(Meal.class);
                    byte[] decodedString = Base64.decode(meal.getImage(), Base64.DEFAULT);
                    Bitmap decodeByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    imgMeal.setImageBitmap(decodeByte);
                    txtContent.setText(meal.getContent().replace("_b", "\n"));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}