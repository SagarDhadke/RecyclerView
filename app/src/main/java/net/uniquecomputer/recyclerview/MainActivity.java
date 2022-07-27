package net.uniquecomputer.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button listBtn,gridBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This is all ids
        recyclerView = findViewById(R.id.recyclerView);
        listBtn = findViewById(R.id.listBtn);
        gridBtn = findViewById(R.id.gridBtn);

        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("Classic Chicken Burger", R.drawable.burger));
        foods.add(new Food("Margherita Pizza", R.drawable.pizza));
        foods.add(new Food("KFC Chicken Crispy", R.drawable.kfc));
        foods.add(new Food("Red And Choco Velvet Cake", R.drawable.cake));
        foods.add(new Food("Dry Fruit Delight Ice Cream", R.drawable.ice_cream));
        foods.add(new Food("Strawberry Cream Roll", R.drawable.cream_roll));


        FoodAdapter adapter = new FoodAdapter(this,foods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
      //  linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(linearLayoutManager);

            }
        });

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });

        //you can changed "linearLayoutManager" to "gridLayoutManager" to set default
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }



}