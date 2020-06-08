package com.example.myapplication;

public class Name {
    public static String getShort(String team)
    {
        switch(team){
            case "Liverpool FC":
                return "LFC";
            case "Leicester City FC":
                return "LEI";
            case "Manchester City FC":
                return "MCI";
            case "Chelsea FC":
                return "CHE";
            case "Wolverhampton Wanderers FC":
                return "WOL";
            case "Sheffield United FC":
                return "SHU";
            case "Burnley FC":
                return "BUR";
            case "Arsenal FC":
                return "ARS";
            case "Manchester United FC":
                return "MUN";
            case "Tottenham Hotspur FC":
                return "TOT";
            case "AFC Bournemouth":
                return "BOR";
            case "Brighton & Hove Albion FC":
                return "BHA";
            case "Newcastle United FC":
                return "NEW";
            case "Crystal Palace FC":
                return "CRY";
            case "Everton FC":
                return "EVE";
            case "West Ham United FC":
                return "WHU";
            case "Aston Villa FC":
                return "AVL";
            case "Norwich City FC":
                return "NOR";
            case "Southampton FC":
                return "SOU";
            case "Watford FC":
                return "WAT";
            default:
                return "AAA";

        }

    }
}
