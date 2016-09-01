package com.example.leeeyou.fixmyproblem.model;

import java.io.Serializable;

/**
 * Created by evan on 16/7/11.
 */
public class RoundClub implements Serializable {
    private static final long serialVersionUID = -5017580362821452055L;
    private int clubId;
    private String clubName;
    private String logo;
    private String introduce;
    private double score;

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
