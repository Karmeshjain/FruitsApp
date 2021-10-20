package com.example.fruitsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
<<<<<<< Updated upstream
||||||| constructed merge base

=======

    private static final String URL="https://fruityvice.com/api/fruit/all";
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< Updated upstream
        RecyclerView fruitlist = (RecyclerView) findViewById(R.id.fruitlist);
        fruitlist.setLayoutManager(new LinearLayoutManager(this));
        String[] Fruits = {"Apple" , "Banana", "Pear" , "Kiwi" , "Strawberry", "Mango","Papaya","Apple" ,
                "Banana", "Pear" , "Kiwi" , "Strawberry", "Mango","Papaya"};
        fruitlist.setAdapter(new Fruitadaptor(Fruits));

        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        fruitlist.addItemDecoration(dividerItemDecoration);



||||||| constructed merge base
=======
        fetchData();
        putData();

>>>>>>> Stashed changes
    }

    private void fetchData() {
        StringRequest stringRequest=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE",response);
              //  Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
                Fruit[] fruitsArray=gson.fromJson(response,Fruit[].class);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            //    Toast.makeText(MainActivity.this, "Try Again Please", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
    private void putData()
    {
        
    }


}