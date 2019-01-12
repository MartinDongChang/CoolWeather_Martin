package com.example.ases_martindong.coolweather_martin.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ases_martindong.coolweather_martin.db.City;
import com.example.ases_martindong.coolweather_martin.db.County;
import com.example.ases_martindong.coolweather_martin.db.Province;

public class Utility {
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvices = new JSONArray(response);
                for(int i=0;i<allProvices.length();i++){
                    JSONObject provinceObject = allProvices.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
//                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try{
                JSONArray allCities = new JSONArray(response);
                for(int i=0;i <allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
