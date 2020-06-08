package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Results extends AppCompatActivity {

    public RequestQueue requestQueue;
    public LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);

        linearLayout = findViewById(R.id.linearLayout2);

        requestQueue = Volley.newRequestQueue(this);
        Request4();

        ImageButton homeButton = findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Results.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ImageButton teamsButton = findViewById(R.id.TeamsButton);
        teamsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Results.this,Teams.class);
                startActivity(intent);
            }
        });
        ImageButton tableButton = findViewById(R.id.TableButton);
        tableButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Results.this,Table.class);
                startActivity(intent);
            }
        });
        ImageButton historyButton = findViewById(R.id.HistoryButton);
        historyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Results.this,History.class);
                startActivity(intent);
            }
        });
    }

    public void Request4() {
        Date currentTime = new Date(System.currentTimeMillis());
        String url = "https://api.football-data.org/v2/competitions/PL/matches?matchday="+(Dates.getDate(currentTime)-1);
        //String url = "https://api.myjson.com/bins/1e1dve";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("matches");
                            String[] HomeTeam1 = new String[jsonArray.length()];
                            String[] AwayTeam1 = new String[jsonArray.length()];
                            String[] HomeID1 = new String[jsonArray.length()];
                            String[] AwayID1 = new String[jsonArray.length()];
                            String[] ScoreAway1 = new String[jsonArray.length()];
                            String[] ScoreHome1 = new String[jsonArray.length()];
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject OuterObject = jsonArray.getJSONObject(i);
                                JSONObject InnerObject1 = OuterObject.getJSONObject("homeTeam");
                                String HomeTeam = InnerObject1.getString("name");
                                String HomeID = InnerObject1.getString("id");
                                JSONObject InnerObject2 = OuterObject.getJSONObject("awayTeam");
                                String AwayTeam = InnerObject2.getString("name");
                                String AwayID = InnerObject2.getString("id");
                                HomeID1[i]=HomeID;
                                AwayID1[i]=AwayID;
                                HomeTeam1[i]=Name.getShort(HomeTeam);
                                AwayTeam1[i]=Name.getShort(AwayTeam);
                                JSONObject ScoreObject = OuterObject.getJSONObject("score");
                                JSONObject FullTimeObject = ScoreObject.getJSONObject("fullTime");
                                String ScoreHome = FullTimeObject.getString("homeTeam");
                                String ScoreAway =FullTimeObject.getString("awayTeam");
                                ScoreAway1[i]= ScoreAway;
                                ScoreHome1[i]= ScoreHome;
                            }
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                LinearLayout linearLayout1 = new LinearLayout(Results.this);
                                LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,100);
                                params.setMargins(0,20,0,20);
                                linearLayout1.setBackgroundColor(Color.parseColor("#ffffff"));
                                linearLayout1.getBackground().setAlpha(156);
                                linearLayout1.setLayoutParams(params);

                                TextView newtext = new TextView(Results.this);
                                LinearLayout.LayoutParams params2 =new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT,1);
                                newtext.setTextColor(Color.parseColor("#000000"));
                                newtext.setTextSize(25);
                                newtext.setGravity(Gravity.CENTER);
                                newtext.setTypeface(null, Typeface.BOLD);
                                newtext.setText(HomeTeam1[i] + " " + ScoreHome1[i]+":"+ ScoreAway1[i] + " "  + AwayTeam1[i]);
                                newtext.setLayoutParams(params2);

                                ImageView image1 = new ImageView(Results.this);
                                LinearLayout.LayoutParams params3 =new LinearLayout.LayoutParams(10,RelativeLayout.LayoutParams.MATCH_PARENT,1);
                                String HID = ("b"+HomeID1[i]);
                                int ID1 = getResources().getIdentifier(HID,"drawable",getPackageName());
                                image1.setImageResource(ID1);
                                image1.setLayoutParams(params3);

                                ImageView image2 = new ImageView(Results.this);
                                LinearLayout.LayoutParams params4 =new LinearLayout.LayoutParams(10,RelativeLayout.LayoutParams.MATCH_PARENT,1);
                                String AID = ("b"+AwayID1[i]);
                                int ID2 = getResources().getIdentifier(AID,"drawable",getPackageName());
                                image2.setImageResource(ID2);
                                image2.setLayoutParams(params4);

                                linearLayout.addView(linearLayout1);
                                linearLayout1.addView(image1);
                                linearLayout1.addView(newtext);
                                linearLayout1.addView(image2);
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





