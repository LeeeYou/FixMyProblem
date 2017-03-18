package com.example.leeeyou.fixmyproblem.model.bean;

/**
 * Created by leeeyou on 16/7/12.
 */
public class GameRoundScore {
    private int id;
    private int gameRoundId;
    private int gameEventTeamId;
    private int groupType;
    private float score;
    private int products;
    private int wins;
    private int fails;
    private int ties;
    private long updateTime;
    private long createTime;
    private String teamName;

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getGameRoundId() {
        return gameRoundId;
    }

    public void setGameRoundId(int gameRoundId) {
        this.gameRoundId = gameRoundId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public int getFails() {
        return fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }

    public int getGameEventTeamId() {
        return gameEventTeamId;
    }

    public void setGameEventTeamId(int gameEventTeamId) {
        this.gameEventTeamId = gameEventTeamId;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
