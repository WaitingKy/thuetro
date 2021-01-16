package com.example.thuetro.MealList;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.example.thuetro.Model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealList extends Activity {
    private List<Meal> mealList = new ArrayList<Meal>();
    private ArrayAdapter<Meal> adapter = null;
}
