package com.example.leeeyou.fixmyproblem;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * jsonobject , jsonarray , json 互转
 */
public class Problem10_JSONArray_Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonarray);

        jsonStringTojsonObj();
        jsonArrayTojsonObj();
        jsonObjTojsonObj();
        listobjTojsonArray();
    }

    private void listobjTojsonArray() {
        List<String> imageList = new ArrayList<>();
        imageList.add("http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg");
        imageList.add("http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg");
        imageList.add("http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg");
        imageList.add("http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg");

        try {
            JSONArray jsonArray = new JSONArray(new Gson().toJson(imageList));

            Log.e("com.jsonarray", "listobjTojsonArray Gson ---- " + jsonArray.toString());

            JSONArray jsonArray2 = new JSONArray(imageList);
            Log.e("com.jsonarray", "listobjTojsonArray 直接转换 ---- " + jsonArray2.toString());

            Log.e("com.jsonarray", "-------------------- ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonObjTojsonObj() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg");

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("imageList", jsonArray);
            jsonObject.put("age", 28);
            jsonObject.put("nickName", "Jack");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //直接调用toString可以将JSONObject转换成json字符串
        Log.e("com.jsonarray", "jsonObjTojsonObj ---- " + jsonObject.toString());

        Log.e("com.jsonarray", "jsonObjTojsonObj Gson ---- " + new Gson().toJson(jsonObject));

        Log.e("com.jsonarray", "-------------------- ");
    }

    private void jsonArrayTojsonObj() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg");

        //直接调用toString可以将JSONArray转换成json字符串
        Log.e("com.jsonarray", "jsonArrayTojsonObj ---- " + jsonArray.toString());

        Log.e("com.jsonarray", "-------------------- ");
    }

    private void jsonStringTojsonObj() {
        String imageObject = "{\"imageList\":[{\"id\": 292,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg\"},{\"id\": 289,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg\"},{\"id\": 288,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg\"},{\"id\": 291,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg\"}]}";
        FixedPrice fixedPrice = new Gson().fromJson(imageObject, FixedPrice.class);
        Log.e("com.jsonarray", "jsonStringTojsonObj ---- " + fixedPrice.toString());

        String imageArray = "[{\"id\": 292,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg\"},{\"id\": 289,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg\"},{\"id\": 288,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg\"},{\"id\": 291,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg\"}]";
        List<Image> imageList = new Gson().fromJson(imageArray, new TypeToken<List<Image>>() {
        }.getType());

        Log.e("com.jsonarray", "jsonStringTojsonObj gson fromJson ---- " + fixedPrice.toString());
        Log.e("com.jsonarray", "jsonStringTojsonObj TypeToken ---- " + imageList.toString());

        Log.e("com.jsonarray", "-------------------- ");
    }

    class Image {
        public int id;
        public String imageUrl;

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    class FixedPrice {
        public List<Image> imageList;

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

}

