package com.example.parcial2_dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.parcial2_dsm.Adapter.FoodAdapter;
import com.example.parcial2_dsm.Models.Food;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

     public static final int REQUEST_CODE=1;
     FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("PUPUSAS",R.drawable.pupusas, 1,"Pupusas de arroz y maíz"));
        foods.add(new Food("ENCHILADAS",R.drawable.enchiladas, 2,"Enchiladas tostatidas con salsa de tomate"));
        foods.add(new Food("HORCHATA",R.drawable.horchata, 2,"Horchata de Morro"));
        foods.add(new Food("PASTELITOS",R.drawable.pastelitos, 1,"Pastelitos rellenos de picado de verdura"));
        foods.add(new Food("PLATANOS FRITOS",R.drawable.platanos, 1,"Platanos fritos con crema y queso"));



        adapter = new FoodAdapter(this, foods);
        ListView orderListView = (ListView) findViewById(R.id.order_list_view);
        orderListView.setAdapter(adapter);
        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MenuActivity.this,FoodDetailActivity.class);

                Food currentFood = foods.get(position);
                Log.e("FOOD NAME", currentFood.getFoodName());
                i.putExtra("name", currentFood.getFoodName());
                i.putExtra("image", currentFood.getmImageResource());
                i.putExtra("price", currentFood.getFoodPrice());
                i.putExtra("type", currentFood.getType());
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_cart: Intent i = new Intent(MenuActivity.this, CartListActivity.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}