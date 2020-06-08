package com.example.myapplication;

public class Placement {
    public static String getColor(String pos){

        int position = Integer.parseInt(pos);

        if (position < 5){
            return "#33aa33";
        }
        else if (position == 5){
            return "#6c39b3";
        }
        else if (position > 17){
            return "#881111";
        }
        else
            return "#ffffff";
    }
}
