package com.example.fruitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class AddActivity extends AppCompatActivity {

    private static final String URL="https://fruityvice.com/api/fruit";
    private EditText genus,name,family,order,carbs,protien,fat,calorie,sugar;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        genus=(EditText)findViewById(R.id.edittxt1);
        name=(EditText)findViewById(R.id.edittxt2);
        family=(EditText)findViewById(R.id.edittxt3);
        order=(EditText)findViewById(R.id.edittxt4);
        carbs=(EditText)findViewById(R.id.edittxt5);
        protien=(EditText)findViewById(R.id.edittxt6);
        fat=(EditText)findViewById(R.id.edittxt7);
        calorie=(EditText)findViewById(R.id.edittxt8);
        sugar=(EditText)findViewById(R.id.edittxt9);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(checkEmpty())
                putDataIntoApi();
                else
                {
                    Toast.makeText(AddActivity.this, "Please Fill All the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean checkEmpty()
    {
        if(genus.getText().toString().equals("")&&
                name.getText().toString().equals("")&&
                family.getText().toString().equals("")&&
                order.getText().toString().equals("")&&
                carbs.getText().toString().equals("")&&
                protien.getText().toString().equals("")&&
                fat.getText().toString().equals("")&&
                calorie.getText().toString().equals("")&&
                sugar.getText().toString().equals("")
        )
            return false;
        else
            return true;
    }

    private void putDataIntoApi()
    {
        try {

            Fruit fruit=getFruit();
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("genus", fruit.getGenus());
            jsonBody.put("name", fruit.getName());
            jsonBody.put("family", fruit.getFamily());
            jsonBody.put("order", fruit.getOrder());
            JSONObject nutritions = new JSONObject();
            nutritions.put("carbohydrates",fruit.getNutritions().getCarbohydrates());
            nutritions.put("protein",fruit.getNutritions().getProtein());
            nutritions.put("fat",fruit.getNutritions().getFat());
            nutritions.put("calories",fruit.getNutritions().getCalories());
            nutritions.put("sugar",fruit.getNutritions().getSugar());
            jsonBody.put("nutritions",nutritions);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                    Log.d("Body",requestBody);
                    Toast.makeText(AddActivity.this, "Successfully Uploaded", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                    Log.d("Body",requestBody);
                    Toast.makeText(AddActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Fruit getFruit() {
        Fruit fruit1=new Fruit();
        fruit1.setGenus(genus.getText().toString());
        fruit1.setFamily(family.getText().toString());
        fruit1.setName(name.getText().toString());
        fruit1.setOrder(order.getText().toString());
        Nutritions nutritionsobj =new Nutritions();
        nutritionsobj.setCalories(Double.parseDouble(String.valueOf(calorie.getText())));
        nutritionsobj.setCarbohydrates(Double.parseDouble(String.valueOf(carbs.getText())));
        nutritionsobj.setFat(Double.parseDouble(String.valueOf(fat.getText())));
        nutritionsobj.setProtein(Double.parseDouble(String.valueOf(protien.getText())));
        nutritionsobj.setSugar(Double.parseDouble(String.valueOf(sugar.getText())));
        fruit1.setNutritions(nutritionsobj);
        return fruit1;
    }
}