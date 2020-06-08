package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class History extends AppCompatActivity {
    public RequestQueue requestQueue;
    public LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout2);
        requestQueue = Volley.newRequestQueue(this);
        ImageButton homeButton = findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ImageButton teamsButton = findViewById(R.id.TeamsButton);
        teamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, Teams.class);
                startActivity(intent);
            }
        });
        ImageButton tableButton = findViewById(R.id.TableButton);
        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, Table.class);
                startActivity(intent);
            }
        });
        ImageButton resultsButton = findViewById(R.id.ResultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, Results.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout1 = new LinearLayout(History.this);
        LinearLayout.LayoutParams layout_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2000);
        layout_params.setMargins(0, 20, 0, 20);
        linearLayout1.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout1.getBackground().setAlpha(156);
        linearLayout1.setLayoutParams(layout_params);

        TextView historytext = new TextView(History.this);
        LinearLayout.LayoutParams text_params = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT, 1);
        historytext.setTextColor(Color.parseColor("#000000"));
        historytext.setTextSize(16);
        historytext.setGravity(Gravity.CENTER);
        historytext.setText("English Premier League (nazywana także Premiership) – najwyższa w hierarchii klasa męskich ligowych rozgrywek piłkarskich w Anglii," +
                " będąca jednocześnie najwyższym szczeblem centralnym (I poziom ligowy), utworzona w 1992 roku i zarządzana od samego początku przez FA Premier League. " +
                "Zmagania w jej ramach toczą się cyklicznie (co sezon od sierpnia do maja) i przeznaczone są dla 20 najlepszych krajowych klubów piłkarskich. " +
                "Jej triumfator zostaje Mistrzem Anglii, zaś najsłabsze drużyny są relegowane do League Championship (II ligi angielskiej).\n" +
                "\nDotychczasowi triumfatorzy Premier League:" +
                "\n2019 Manchester City" +
                "\n2018 Manchester City" +
                "\n2017 Chelsea FC" +
                "\n2016 Leicester City" +
                "\n2015 Chelsea FC" +
                "\n2014 Manchester City" +
                "\n2013 Manchester United" +
                "\n2012 Manchester City" +
                "\n2011 Manchester United" +
                "\n2010 Chelsea FC" +
                "\n2009 Manchester United" +
                "\n2008 Manchester United" +
                "\n2007 Manchester United" +
                "\n2006 Chelsea FC" +
                "\n2005 Chelsea FC" +
                "\n2004 Arsenal FC" +
                "\n2003 Manchester United" +
                "\n2002 Arsenal FC" +
                "\n2001 Manchester United" +
                "\n2000 Manchester United" +
                "\n1999 Manchester United" +
                "\n1998 Arsenal FC" +
                "\n1997 Manchester United" +
                "\n1996 Manchester United" +
                "\n1995 Blackburn Rovers" +
                "\n1994 Manchester United" +
                "\n1993 Manchester United");
        historytext.setLayoutParams(text_params);

        linearLayout.addView(linearLayout1);
        linearLayout1.addView(historytext);
    }
}

