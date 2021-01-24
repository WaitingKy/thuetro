package com.example.thuetro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thuetro.IgdAdapter.IgdAdapter;
import com.example.thuetro.Model.Ingredients;
import com.example.thuetro.Model.Meal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Meal5Activity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference getMeal = db.getReference("Meal");
    DatabaseReference getIngredients = db.getReference("Ingredients");
    DatabaseReference getImage = db.getReference("Image");

    ImageView imgMeal;
    TextView txtContent;
    ListView lvIgd;
    Bitmap bitmap;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal5);

        init();
    }

    public void init() {
        imgMeal = (ImageView) findViewById(R.id.imgMeal);
        txtContent = (TextView) findViewById(R.id.txtContent);
        lvIgd = (ListView) findViewById(R.id.lvIgd);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        int intkey = Integer.parseInt(key);
        if (intkey < 10) {
            String stringkey = "0" + String.valueOf(intkey);


            getMeal.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Meal meal = snapshot.child(stringkey).getValue(Meal.class);
                    byte[] decodedString = Base64.decode(meal.getImage(), Base64.DEFAULT);
                    Bitmap decodeByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    imgMeal.setImageBitmap(decodeByte);
                    txtContent.setText(meal.getContent().replace("_b", "\n"));
                    String[] igdList = meal.getIngredients().split("_b");
                    ArrayList<String> arrIgdName = new ArrayList<String>();
                    adapter = new ArrayAdapter<String>(Meal5Activity.this, R.layout.row_igd, arrIgdName);
                    for (int i = 0; i < igdList.length; i++) {
                       arrIgdName.add(igdList[i]);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            lvIgd.setAdapter(adapter);
        }
    }
}