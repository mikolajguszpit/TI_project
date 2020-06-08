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

public class Team extends AppCompatActivity {
    public LinearLayout scrollView;
    public RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        requestQueue = Volley.newRequestQueue(this);
        scrollView = findViewById(R.id.new_layout);
        ImageButton tableButton = findViewById(R.id.TableButton);
        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Team.this,Table.class);
                startActivity(intent);
            }
        });
        ImageButton homeButton = findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Team.this,MainActivity.class);
                startActivity(intent);
            }
        }
        );
        ImageButton teamsButton = findViewById(R.id.TeamsButton);
        teamsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Team.this,Teams.class);
                startActivity(intent);
            }
        }
        );
        ImageButton resultsButton = findViewById(R.id.ResultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Team.this,Results.class);
                startActivity(intent);
            }
        }
        );
        ImageButton historyButton = findViewById(R.id.HistoryButton);
        historyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Team.this,History.class);
                startActivity(intent);
            }
        });
        Request5();
    }

    public void Request5() {
        String url = getIntent().getStringExtra("TeamURL");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("squad");
                            String[] Name1 = new String[jsonArray.length()];
                            String[] PlayerNumber1 = new String[jsonArray.length()];
                            String[] Position1 = new String[jsonArray.length()];
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject OuterObject = jsonArray.getJSONObject(i);
                                String Name = OuterObject.getString("name");
                                Name1[i]=Name;
                                String PlayerNumber = OuterObject.getString("shirtNumber");
                                PlayerNumber1[i]=PlayerNumber;
                                String Position = OuterObject.getString("position");
                                Position1[i]=Position;
                                PlayerNumber1[i]=PlayerNumber1[i].replace("null","N");
                                Position1[i]=Position1[i].replace("null","Coach");
                                PlayerNumber1[i]=(PlayerNumber1[i]+" - ");
                                Name1[i]=(Name1[i]+" - ");


                            }

                            for (int i=0;i<jsonArray.length();i++) {
                                LinearLayout relativeLayout = new LinearLayout(Team.this);
                                LinearLayout.LayoutParams layout_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                layout_params.setMargins(0, 10, 0, 10);
                                relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                                relativeLayout.getBackground().setAlpha(156);
                                relativeLayout.setLayoutParams(layout_params);

                                TextView shirtNumber = new TextView(Team.this);
                                RelativeLayout.LayoutParams number_params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                                shirtNumber.setTextColor(Color.parseColor("#000000"));
                                shirtNumber.setTextSize(20);
                                shirtNumber.setTypeface(null, Typeface.BOLD);
                                shirtNumber.setPadding(20, 40, 20, 20);
                                shirtNumber.setText(PlayerNumber1[i]);
                                shirtNumber.setLayoutParams(number_params);

                                TextView name = new TextView(Team.this);
                                RelativeLayout.LayoutParams name_params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                                name.setTextColor(Color.parseColor("#000000"));
                                name.setTextSize(20);
                                name.setTypeface(null, Typeface.BOLD);
                                name.setPadding(20, 40, 20, 20);
                                name.setText(Name1[i]);
                                name.setLayoutParams(name_params);

                                TextView positionview = new TextView(Team.this);
                                RelativeLayout.LayoutParams position_params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                                positionview.setTextColor(Color.parseColor("#000000"));
                                positionview.setTextSize(20);
                                positionview.setTypeface(null, Typeface.BOLD);
                                positionview.setPadding(20, 40, 20, 20);
                                positionview.setText(Position1[i]);
                                positionview.setLayoutParams(position_params);


                                scrollView.addView(relativeLayout);
                                relativeLayout.addView(shirtNumber);
                                relativeLayout.addView(name);
                                relativeLayout.addView(positionview);
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
