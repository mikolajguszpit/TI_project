package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teams extends AppCompatActivity {
    public LinearLayout scrollView;
    public String TeamURL;
    public String[] HomeID1 = new String[20];
    public RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        requestQueue = Volley.newRequestQueue(this);
        scrollView = findViewById(R.id.new_layout);
        ImageButton homeButton = findViewById(R.id.HomeButton);
        ImageButton tableButton = findViewById(R.id.TableButton);
        ImageButton resultsButton = findViewById(R.id.ResultsButton);
        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Teams.this,Table.class);
                startActivity(intent);
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Teams.this,MainActivity.class);
                startActivity(intent);
            }
        });
        resultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Teams.this,Results.class);
                startActivity(intent);
            }
        }
        );
        ImageButton historyButton = findViewById(R.id.HistoryButton);
        historyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Teams.this,History.class);
                startActivity(intent);
            }
        });
        Request3();
    }
    View.OnClickListener handleOnClick(final ImageView imageView, final int i) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                TeamURL = ("https://api.football-data.org/v2/teams/" + HomeID1[i]);
                Intent intent = new Intent(Teams.this,Team.class);
                intent.putExtra("TeamURL",TeamURL);
                startActivity(intent);
                Log.d("blad1",TeamURL);
            }
        };
    }
    public void Request3() {
        String url = "https://api.football-data.org/v2/competitions/PL/teams?seasons=2019";
        //String url = "https://api.myjson.com/bins/1e1dve";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("teams");
                            String[] HomeTeam1 = new String[jsonArray.length()];
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject OuterObject = jsonArray.getJSONObject(i);
                                String HomeTeam = OuterObject.getString("name");
                                String HomeID = OuterObject.getString("id");
                                HomeID1[i]=HomeID;
                                HomeTeam1[i]=HomeTeam;

                            }
                            for (int j=0;j<jsonArray.length();j++)
                            {

                                LinearLayout relativeLayout = new LinearLayout(Teams.this);
                                LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                                params.setMargins(0,10,0,10);
                                relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                                relativeLayout.getBackground().setAlpha(156);
                                relativeLayout.setLayoutParams(params);

                                TextView newtext = new TextView(Teams.this);
                                RelativeLayout.LayoutParams params2 =new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                                newtext.setTextColor(Color.parseColor("#000000"));
                                newtext.setTextSize(20);
                                newtext.setTypeface(null, Typeface.BOLD);
                                newtext.setPadding(20,40,20,20);
                                newtext.setText(HomeTeam1[j]);
                                newtext.setLayoutParams(params2);

                                ImageView image1 = new ImageView(Teams.this);
                                RelativeLayout.LayoutParams params3 =new RelativeLayout.LayoutParams(150,150);
                                String HID = ("b"+HomeID1[j]);
                                int ID1 = getResources().getIdentifier(HID,"drawable",getPackageName());
                                image1.setImageResource(ID1);
                                image1.setLayoutParams(params3);
                                image1.setOnClickListener(handleOnClick(image1,j));


                                scrollView.addView(relativeLayout);
                                relativeLayout.addView(image1);
                                relativeLayout.addView(newtext);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("blad","blad");
                error.printStackTrace();

            }
        })
        {
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("X-Auth-Token", "91cf9bdd1fde4312b7d08593834a4be7");
                return headers;
            }
        };

        requestQueue.add(request);
    }
}
