package com.myapplication.bookstore;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SP {

    SharedPreferences myPreference;

    public SP(Context context) {
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        try {
            if (context != null) {
                myPreference = context.getSharedPreferences(context.getPackageName() + "_preferences", Context.MODE_PRIVATE);
//                myPreference = context.getSharedPreferences("Common_preferences", Context.MODE_PRIVATE);

            }
        } finally {
            StrictMode.setThreadPolicy(oldPolicy);
        }
    }

//    public SP(Activity context){
//        if(context!=null) {
//            myPreference = PreferenceManager.getDefaultSharedPreferences(context);
//        }
//    }



    public void setString(Context context, String key, String Value) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }

        SharedPreferences.Editor sEdit = myPreference.edit();
        sEdit.putString(key, Value);
        //sEdit.commit();
        sEdit.apply();
    }

    public String getString(Context context, String key, String defaultValue) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        String value = myPreference.getString(key, defaultValue);
        return value;
    }

    public void setInteger(Context context, String key, Integer Value) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor sEdit = myPreference.edit();
        sEdit.putInt(key, Value);
        //sEdit.commit();
        sEdit.apply();
    }

    public Integer getInteger(Context context, String key) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        Integer value = myPreference.getInt(key, 0);
        return value;
    }

    public void setFloat(Context context, String key, Float Value) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor sEdit = myPreference.edit();
        sEdit.putFloat(key, Value);
        //sEdit.commit();
        sEdit.apply();
    }

    public Float getFloat(Context context, String key) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        Float mFloat = myPreference.getFloat(key, 0);
        return mFloat;
    }

    public Integer getInteger(Context context, String key, int defaultValue) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        Integer value = myPreference.getInt(key, defaultValue);
        return value;
    }

    public void setBoolean(Context context, String key, Boolean Value) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }

        SharedPreferences.Editor sEdit = myPreference.edit();
        sEdit.putBoolean(key, Value);
        //sEdit.commit();
        sEdit.apply();
    }

    public Boolean getBoolean(Context context, String key) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        Boolean value = myPreference.getBoolean(key, false);
        return value;
    }

    public Boolean getBoolean(Context context, String key, Boolean defaultValue) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        Boolean value = myPreference.getBoolean(key, defaultValue);
        return value;
    }

    public void setLong(Context context, String key, long Value) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor sEdit = myPreference.edit();
        sEdit.putLong(key, Value);
        //sEdit.commit();
        sEdit.apply();
    }

    public long getLong(Context context, String key, long Value) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        long value = myPreference.getLong(key, Value);
        return value;
    }

    public void clearSharedPreferences(Context context) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        if (myPreference == null) {
            myPreference = context.getSharedPreferences("COMMON_SHARED", Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor sEdit = myPreference.edit();
        sEdit.clear();
        //sEdit.commit();
        sEdit.apply();
    }
}
