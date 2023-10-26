package com.example.midterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.midterm.FoodAdapter.FoodAdapter;
import com.example.midterm.FoodItem.FoodItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements FoodAdapter.OnItemClickListener {
    private List<FoodItem> foodList;
    private TextView selectedFoodTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedFoodTextView = findViewById(R.id.selectedFoodTextView);

        // Khởi tạo danh sách món ăn
        foodList = new ArrayList<>();
        foodList.add(new FoodItem(R.drawable.food1, "Bread"));
        foodList.add(new FoodItem(R.drawable.food2, "Cherry Cheesecake"));
        foodList.add(new FoodItem(R.drawable.food3, "Gingerbread House"));
        foodList.add(new FoodItem(R.drawable.food4, "Hamburger"));
        foodList.add(new FoodItem(R.drawable.food5, "Sunny Side Up Eggs"));
        foodList.add(new FoodItem(R.drawable.food5, "Sunny Side Up Eggs"));
        foodList.add(new FoodItem(R.drawable.food4, "Hamburger"));
        foodList.add(new FoodItem(R.drawable.food3, "Gingerbread House"));
        foodList.add(new FoodItem(R.drawable.food2, "Cherry Cheesecake"));
        foodList.add(new FoodItem(R.drawable.food1, "Bread"));


        // Sắp xếp danh sách món ăn theo yêu cầu
        Collections.reverse(foodList.subList(5, foodList.size()));

        // Thiết lập RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FoodAdapter adapter = new FoodAdapter(foodList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(FoodItem item) {
        selectedFoodTextView.setText(item.getName());
    }
    
}