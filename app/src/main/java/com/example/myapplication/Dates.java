package com.example.myapplication;
import android.util.Log;

import java.util.Date;

public class Dates {
    public static int getDate(Date date)
    {
        if (date.compareTo(new Date("12/10/2019"))+date.compareTo(new Date("12/14/2019"))==0){
            return 17;
        } else if (date.compareTo(new Date("12/17/2019"))+date.compareTo(new Date("12/22/2019"))==0) {
            return 18;
        } else if (date.compareTo(new Date("12/23/2019"))+date.compareTo(new Date("12/27/2019"))==0) {
            return 19;
        } else if (date.compareTo(new Date("12/28/2019"))+date.compareTo(new Date("12/29/2019"))==0) {
            return 20;
        } else if (date.compareTo(new Date("12/30/2019"))+date.compareTo(new Date("01/02/2020"))==0) {
            return 21;
        } else if (date.compareTo(new Date("01/03/2020"))+date.compareTo(new Date("01/12/2020"))==0) {
            return 22;
        } else if (date.compareTo(new Date("01/13/2020"))+date.compareTo(new Date("01/19/2020"))==0) {
            return 23;
        } else if (date.compareTo(new Date("01/20/2020"))+date.compareTo(new Date("01/23/2020"))==0) {
            return 24;
        } else if (date.compareTo(new Date("01/24/2020"))+date.compareTo(new Date("02/01/2020"))==0) {
            return 25;
        } else if (date.compareTo(new Date("02/02/2020"))+date.compareTo(new Date("02/08/2020"))==0) {
            return 26;
        } else if (date.compareTo(new Date("02/09/2020"))+date.compareTo(new Date("02/22/2020"))==0) {
            return 27;
        } else if (date.compareTo(new Date("02/23/2020"))+date.compareTo(new Date("02/29/2020"))==0) {
            return 28;
        } else if (date.compareTo(new Date("03/01/2020"))+date.compareTo(new Date("03/07/2020"))==0) {
            return 29;
        } else if (date.compareTo(new Date("03/08/2020"))+date.compareTo(new Date("03/14/2020"))==0) {
            return 30;
        } else if (date.compareTo(new Date("03/15/2020"))+date.compareTo(new Date("03/21/2020"))==0) {
            return 31;
        } else if (date.compareTo(new Date("03/22/2020"))+date.compareTo(new Date("04/04/2020"))==0) {
            return 32;
        } else if (date.compareTo(new Date("04/05/2020"))+date.compareTo(new Date("04/11/2020"))==0) {
            return 33;
        } else if (date.compareTo(new Date("04/12/2020"))+date.compareTo(new Date("04/18/2020"))==0) {
            return 34;
        } else if (date.compareTo(new Date("04/19/2020"))+date.compareTo(new Date("04/25/2020"))==0) {
            return 35;
        } else if (date.compareTo(new Date("04/26/2020"))+date.compareTo(new Date("05/02/2020"))==0) {
            return 36;
        } else if (date.compareTo(new Date("05/03/2020"))+date.compareTo(new Date("05/09/2020"))==0) {
            return 37;
        } else if (date.compareTo(new Date("10/05/2020"))+date.compareTo(new Date("17/05/2020"))==0) {
            return 38;
        }
        return 1;

    }
}
