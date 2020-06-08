package com.example.myapplication;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

        import androidx.appcompat.app.AppCompatActivity;

        import android.graphics.Color;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.Volley;

        import android.util.Log;
        import android.view.Gravity;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.ScrollView;
        import android.widget.TextView;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.HashMap;
        import java.util.Map;

public class Table extends AppCompatActivity {

    public RequestQueue requestQueue;
    public LinearLayout linearLayout;
    public LinearLayout Table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        linearLayout = findViewById(R.id.linearLayout2);
        Table = findViewById(R.id.linearLayout3);
        requestQueue = Volley.newRequestQueue(this);
        Request2();
        ImageButton homeButton = findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Table.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ImageButton teamsButton = findViewById(R.id.TeamsButton);
        teamsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Table.this,Teams.class);
                startActivity(intent);
            }
        });
        ImageButton resultsButton = findViewById(R.id.ResultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Table.this,Results.class);
                startActivity(intent);
            }
        });
        ImageButton historyButton = findViewById(R.id.HistoryButton);
        historyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Table.this,History.class);
                startActivity(intent);
            }
        });
    }
    public void Request2() {
        String url = "https://api.football-data.org/v2/competitions/PL/standings?standingType=TOTAL";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("standings");
                            String[] Position1 = new String[20];
                            String[] Team1 = new String[20];
                            String[] Played1 = new String[20];
                            String[] Points1 = new String[20];
                            String[] Won1 = new String[20];
                            String[] Draw1 = new String[20];
                            String[] Lost1 = new String[20];
                            String[] TeamID1 = new String[20];
                            TextView PosText = new TextView(Table.this);
                            TextView TeamText = new TextView(Table.this);
                            TextView PlayedText = new TextView(Table.this);
                            TextView PointsText = new TextView(Table.this);
                            TextView WonText = new TextView(Table.this);
                            TextView DrawnText = new TextView(Table.this);
                            TextView LostText = new TextView(Table.this);
                            LinearLayout linearLayout3 = new LinearLayout(Table.this);
                            LinearLayout.LayoutParams layout_params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,1);
                            LinearLayout.LayoutParams Pos_params =new LinearLayout.LayoutParams(120,LinearLayout.LayoutParams.WRAP_CONTENT,1);
                            LinearLayout.LayoutParams rest_params =new LinearLayout.LayoutParams(60,LinearLayout.LayoutParams.WRAP_CONTENT,1);
                            layout_params.setMargins(0,30,0,30);
                            PosText.setTypeface(null, Typeface.BOLD);
                            PosText.setLayoutParams(Pos_params);
                            PosText.setTextColor(Color.parseColor("#000000"));
                            PosText.setGravity(Gravity.START|Gravity.CENTER_VERTICAL);
                            linearLayout3.setLayoutParams(layout_params);
                            linearLayout3.setBackgroundColor(Color.parseColor("#ffffff"));


                            PosText.setText("Pos");
                            PosText.setTextSize(22);
                            TeamText.setText("Team");
                            TeamText.setTextSize(22);
                            TeamText.setTextColor(Color.parseColor("#000000"));
                            PlayedText.setText("| Pld");
                            PlayedText.setTextSize(22);
                            PlayedText.setTextColor(Color.parseColor("#000000"));
                            PointsText.setText("| Pts");
                            PointsText.setTextSize(22);
                            PointsText.setTextColor(Color.parseColor("#000000"));
                            WonText.setText("| W");
                            WonText.setTextSize(22);
                            WonText.setTextColor(Color.parseColor("#000000"));
                            DrawnText.setText("| D");
                            DrawnText.setTextSize(22);
                            DrawnText.setTextColor(Color.parseColor("#000000"));
                            LostText.setText("| L");
                            LostText.setTextSize(22);
                            LostText.setTextColor(Color.parseColor("#000000"));

                            PosText.setLayoutParams(Pos_params);
                            TeamText.setLayoutParams(Pos_params);
                            PlayedText.setLayoutParams(rest_params);
                            PointsText.setLayoutParams(rest_params);
                            WonText.setLayoutParams(rest_params);
                            DrawnText.setLayoutParams(rest_params);
                            LostText.setLayoutParams(rest_params);


                            Table.addView(linearLayout3);
                            linearLayout3.addView(PosText);
                            linearLayout3.addView(TeamText);
                            linearLayout3.addView(PlayedText);
                            linearLayout3.addView(PointsText);
                            linearLayout3.addView(WonText);
                            linearLayout3.addView(DrawnText);
                            linearLayout3.addView(LostText);
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject StandingsObject = jsonArray.getJSONObject(i);
                                JSONArray TableArray = StandingsObject.getJSONArray("table");
                                for (int j=0;j<20;j++)
                                {
                                    JSONObject TableObject = TableArray.getJSONObject(j);
                                    String Position = TableObject.getString("position");
                                    JSONObject TeamObject = TableObject.getJSONObject("team");
                                    String Team = TeamObject.getString("name");
                                    String TeamID =TeamObject.getString("id");
                                    String Played = TableObject.getString("playedGames");
                                    String Points = TableObject.getString("points");
                                    String Won = TableObject.getString("won");
                                    String Draw = TableObject.getString("draw");
                                    String Lost = TableObject.getString("lost");
                                    Position1[j] = Position;
                                    Team1[j] = Name.getShort(Team);
                                    TeamID1[j] = TeamID;
                                    Played1[j] = Played;
                                    Points1[j] = Points;
                                    Won1[j] = Won;
                                    Draw1[j] = Draw;
                                    Lost1[j] =Lost;


                                }
                            }
                            for (int i=0;i<20;i++)
                            {

                                LinearLayout linearLayout1 = new LinearLayout(Table.this);
                                LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,100,1);
                                params.setMargins(0,20,0,20);
                                linearLayout1.setBackgroundColor(Color.parseColor(Placement.getColor(Position1[i])));
                                linearLayout1.getBackground().setAlpha(156);
                                linearLayout1.setLayoutParams(params);

                                TextView PosText2 = new TextView(Table.this);
                                LinearLayout.LayoutParams params2 =new LinearLayout.LayoutParams(60,LinearLayout.LayoutParams.WRAP_CONTENT,1);
                                PosText2.setTextColor(Color.parseColor("#000000"));
                                PosText2.setGravity(Gravity.START);
                                PosText2.setTypeface(null, Typeface.BOLD);
                                PosText2.setTextSize(22);
                                PosText2.setText(Position1[i]);
                                PosText2.setLayoutParams(params2);

                                ImageView logo = new ImageView(Table.this);
                                LinearLayout.LayoutParams params3 =new LinearLayout.LayoutParams(120,LinearLayout.LayoutParams.MATCH_PARENT,1);
                                String TID = ("b"+TeamID1[i]);
                                int ID = getResources().getIdentifier(TID,"drawable",getPackageName());
                                logo.setImageResource(ID);
                                logo.setLayoutParams(params3);

                                TextView TeamText2 = new TextView(Table.this);
                                LinearLayout.LayoutParams params0 =new LinearLayout.LayoutParams(60,LinearLayout.LayoutParams.WRAP_CONTENT,1);
                                TeamText2.setTextColor(Color.parseColor("#000000"));
                                TeamText2.setGravity(Gravity.START);
                                TeamText2.setTypeface(null, Typeface.BOLD);
                                TeamText2.setText(Team1[i]);
                                TeamText2.setLayoutParams(params0);

                                TextView PlayedText2 = new TextView(Table.this);
                                PlayedText2.setTextColor(Color.parseColor("#000000"));
                                PlayedText2.setGravity(Gravity.START);
                                PlayedText2.setTypeface(null, Typeface.BOLD);
                                PlayedText2.setText("| "+Played1[i]);
                                PlayedText2.setLayoutParams(params0);

                                TextView PointsText2 = new TextView(Table.this);
                                PointsText2.setTextColor(Color.parseColor("#000000"));
                                PointsText2.setGravity(Gravity.START);
                                PointsText2.setTypeface(null, Typeface.BOLD);
                                PointsText2.setText("| "+Points1[i]);
                                PointsText2.setLayoutParams(params0);

                                TextView WonText2 = new TextView(Table.this);
                                WonText2.setTextColor(Color.parseColor("#000000"));
                                WonText2.setGravity(Gravity.START);
                                WonText2.setTypeface(null, Typeface.BOLD);
                                WonText2.setText("| "+Won1[i]);
                                WonText2.setLayoutParams(params0);

                                TextView DrawnText2 = new TextView(Table.this);
                                DrawnText2.setTextColor(Color.parseColor("#000000"));
                                DrawnText2.setGravity(Gravity.START);
                                DrawnText2.setTypeface(null, Typeface.BOLD);
                                DrawnText2.setText("| "+Draw1[i]);
                                DrawnText2.setLayoutParams(params0);

                                TextView LostText2 = new TextView(Table.this);
                                LostText2.setTextColor(Color.parseColor("#000000"));
                                LostText2.setGravity(Gravity.START);
                                LostText2.setTypeface(null, Typeface.BOLD);
                                LostText2.setText("| "+Lost1[i]);
                                LostText2.setLayoutParams(params0);

                                linearLayout.addView(linearLayout1);
                                linearLayout1.addView(PosText2);
                                linearLayout1.addView(logo);
                                linearLayout1.addView(TeamText2);
                                linearLayout1.addView(PlayedText2);
                                linearLayout1.addView(PointsText2);
                                linearLayout1.addView(WonText2);
                                linearLayout1.addView(DrawnText2);
                                linearLayout1.addView(LostText2);


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
