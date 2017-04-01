package com.example.leeeyou.fixmyproblem.view.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.model.bean.RoundUser;
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

        jsonStringToJsonObj();
        jsonArrayToJsonObj();
        jsonObjToJsonObj();
        listStringToJsonArray();
        listObjToJsonArray();
    }

    private void listObjToJsonArray() {
        ArrayList<RoundUser> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RoundUser user = new RoundUser();
            user.setAccount("account" + i);
            user.setAge(20 + i);
            user.setGender(i);
            user.setIcon("https://uimg.quncaotech.com/dynamic/F2QYRR1423.jpg!/fwfh/1120x595/format/webp/quality/65/compress/true/strip/true");
            user.setMobile("1536189040" + i);
            user.setNick("nick" + i);
            user.setRealName("realName" + i);
            userList.add(user);
        }

        try {
            JSONArray jsonArray = new JSONArray(new Gson().toJson(userList));

            Log.e("com.jsonarray", "listObjToJsonArray ---- " + jsonArray.toString());

            JSONArray jsonArray2 = new JSONArray(userList);
            Log.e("com.jsonarray", "listObjToJsonArray 直接转换 ---- " + jsonArray2.toString());

            Log.e("com.jsonarray", "-------------------- ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void listStringToJsonArray() {
        List<String> imageList = new ArrayList<>();
        imageList.add("http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg");
        imageList.add("http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg");
        imageList.add("http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg");
        imageList.add("http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg");

        try {
            JSONArray jsonArray = new JSONArray(new Gson().toJson(imageList));

            Log.e("com.jsonarray", "listStringToJsonArray Gson ---- " + jsonArray.toString());

            JSONArray jsonArray2 = new JSONArray(imageList);
            Log.e("com.jsonarray", "listStringToJsonArray 直接转换 ---- " + jsonArray2.toString());

            Log.e("com.jsonarray", "-------------------- ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonObjToJsonObj() {
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
        Log.e("com.jsonarray", "jsonObjToJsonObj ---- " + jsonObject.toString());

        Log.e("com.jsonarray", "jsonObjToJsonObj Gson ---- " + new Gson().toJson(jsonObject));

        Log.e("com.jsonarray", "-------------------- ");
    }

    private void jsonArrayToJsonObj() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg");
        jsonArray.put("http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg");

        //直接调用toString可以将JSONArray转换成json字符串
        Log.e("com.jsonarray", "jsonArrayToJsonObj ---- " + jsonArray.toString());

        Log.e("com.jsonarray", "-------------------- ");
    }

    private void jsonStringToJsonObj() {
        String imageObject = "{\"imageList\":[{\"id\": 292,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg\"},{\"id\": 289,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg\"},{\"id\": 288,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg\"},{\"id\": 291,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg\"}]}";
        FixedPrice fixedPrice = new Gson().fromJson(imageObject, FixedPrice.class);
        Log.e("com.jsonarray", "jsonStringToJsonObj ---- " + fixedPrice.toString());

        String imageArray = "[{\"id\": 292,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/51c1e24b6b821c916f732c2aa5b1dc9f.jpg\"},{\"id\": 289,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/8ad331112d30453d2ace4c31903c5c55.jpg\"},{\"id\": 288,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/839f7a8407047bab2d7a721c114912df.jpg\"},{\"id\": 291,\"imageUrl\": \"http://quncao-app.b0.upaiyun.com/369ca74245ebc32d512eae501e7de807.jpg\"}]";
        List<Image> imageList = new Gson().fromJson(imageArray, new TypeToken<List<Image>>() {
        }.getType());

        Log.e("com.jsonarray", "jsonStringToJsonObj gson fromJson ---- " + fixedPrice.toString());
        Log.e("com.jsonarray", "jsonStringToJsonObj TypeToken ---- " + imageList.toString());

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

