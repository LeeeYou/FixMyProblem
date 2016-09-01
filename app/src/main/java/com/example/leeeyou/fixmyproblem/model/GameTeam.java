package com.example.leeeyou.fixmyproblem.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 *
 * Created by Evan-st on 16/6/27.
 */
public class GameTeam implements Serializable {


    /**
     * id : 5
     * type : 0
     * group : 1
     */

    private int id;
    private int type;//队伍类别，0个人；1俱乐部
    private int group;
    private ArrayList<RoundUser> userList;
    private RoundClub club;

    public RoundClub getClub() {
        return club;
    }

    public void setClub(RoundClub club) {
        this.club = club;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<RoundUser> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<RoundUser> userList) {
        this.userList = userList;
    }
}
