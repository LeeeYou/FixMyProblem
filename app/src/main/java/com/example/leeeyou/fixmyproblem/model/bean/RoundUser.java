package com.example.leeeyou.fixmyproblem.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Evan-st on 16/6/28.
 */
public class RoundUser implements Parcelable {

    private int uid;
    private String nickName;
    private String mobile;
    private String icon;
    private double score;
    private String realName;
    private int gender;
    private int age;
    private int provinceId;
    private String account;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nickName;
    }

    public void setNick(String nick) {
        this.nickName = nick;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.uid);
        dest.writeString(this.nickName);
        dest.writeString(this.mobile);
        dest.writeString(this.icon);
        dest.writeDouble(this.score);
        dest.writeString(this.realName);
        dest.writeInt(this.gender);
        dest.writeInt(this.age);
        dest.writeInt(this.provinceId);
        dest.writeString(this.account);
    }

    public RoundUser() {
    }

    protected RoundUser(Parcel in) {
        this.uid = in.readInt();
        this.nickName = in.readString();
        this.mobile = in.readString();
        this.icon = in.readString();
        this.score = in.readDouble();
        this.realName = in.readString();
        this.gender = in.readInt();
        this.age = in.readInt();
        this.provinceId = in.readInt();
        this.account = in.readString();
    }

    public static final Parcelable.Creator<RoundUser> CREATOR = new Parcelable.Creator<RoundUser>() {
        @Override
        public RoundUser createFromParcel(Parcel source) {
            return new RoundUser(source);
        }

        @Override
        public RoundUser[] newArray(int size) {
            return new RoundUser[size];
        }
    };
}
