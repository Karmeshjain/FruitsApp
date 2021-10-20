package com.example.fruitsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView fruitlist = (RecyclerView) findViewById(R.id.fruitlist);
        fruitlist.setLayoutManager(new LinearLayoutManager(this));
        String[] Fruits = {"Apple" , "Banana", "Pear" , "Kiwi" , "Strawberry", "Mango","Papaya","Apple" ,
                "Banana", "Pear" , "Kiwi" , "Strawberry", "Mango","Papaya"};
        fruitlist.setAdapter(new Fruitadaptor(Fruits));

        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        fruitlist.addItemDecoration(dividerItemDecoration);



    }
}