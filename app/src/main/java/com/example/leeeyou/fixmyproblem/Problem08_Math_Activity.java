package com.example.leeeyou.fixmyproblem;

import android.os.Bundle;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Math中小数的处理
 */
public class Problem08_Math_Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        mathProcess();

        floatProcess();

        floatToJson();
    }

    private void floatToJson() {
        float value1 = 0.01f;

        Person person = new Person();
        person.score = value1;

        System.out.println("float型转json  : " + new Gson().toJson(person));
    }

    private static void floatProcess() {
        float value1 = 109.82964f;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String strValue = decimalFormat.format(value1);
        System.out.println("DecimalFormat 0.00 会四舍五入小数部分, " + value1 + " 约等于 " + strValue);


        DecimalFormat decimalFormat2 = new DecimalFormat("#.00");
        String strValue2 = decimalFormat2.format(value1);
        System.out.println("DecimalFormat #.00 会四舍五入小数部分, " + value1 + " 约等于 " + strValue2);

        System.out.println("String format %.2f 会四舍五入小数部分, " + value1 + " 约等于 " + String.format("%.2f", value1));

        BigDecimal bigDecimal = new BigDecimal(value1);
        BigDecimal bigDecimalValue = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println("BigDecimal  3位小数 BigDecimal.ROUND_HALF_UP 会四舍五入小数部分, " + value1 + " 约等于 " + bigDecimalValue.toString());

        BigDecimal bigDecima2 = new BigDecimal(value1);
        BigDecimal bigDecimalValue2 = bigDecima2.setScale(3, BigDecimal.ROUND_DOWN);
        System.out.println("BigDecimal  3位小数 BigDecimal.ROUND_DOWN 直接舍弃小数部分, " + value1 + " 约等于 " + bigDecimalValue2.toString());
    }

    private static void mathProcess() {
        float value1 = 109.82934f;

        System.out.println("Math.ceil(" + value1 + ") = " + Math.ceil(value1));
        System.out.println("Math.floor(" + value1 + ") = " + Math.floor(value1));

        //它表示“四舍五入”，算法为Math.floor(x+0.5)，即将原来的数字加上0.5后再向下取整
        System.out.println("Math.round(" + value1 + ") = " + Math.round(value1));
    }

    class Person {
        public String name = "Jack";
        public float score;
    }
}

