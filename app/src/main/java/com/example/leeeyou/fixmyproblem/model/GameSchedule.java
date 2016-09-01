package com.example.leeeyou.fixmyproblem.model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by evan on 16/6/30.
 */
public class GameSchedule implements Serializable {


    /**
     * id : 50
     * startTime : 675575765
     * endTime : 89797987898
     * isAccess : 0
     * recordStatus : 0
     * curTime : 121212121
     * score : 12:29
     */

    private int id;
    private long startTime;
    private long endTime;
    private int isAccess;
    private int recordStatus; //比分录入状态：状态;0、等待录入；1、等待确认 ；2 、录入正常；-1、存在争议
    private long curTime;
    private String score;
    private PlaceUnitInfo placeUnitInfo;
    private GameTeam homeGameTeam;
    private GameTeam awayGameTeam;
    private int group;
    private String gameName;
    private int gameId;
    private int type; //赛事类型
    private int isWin; //输赢；1主场赢；0客场赢；-1，平
    private long roundId;
    private int categoryId;
    private int gameEventType;
    private String roundName;//第几组第几场
    private String timeDesc;//比赛时间
    private String placeDesc;//比赛场地

    public GameSchedule() {

    }

    public GameSchedule(GameSchedule gameSchedule) {
        this.id = gameSchedule.getId();
        this.startTime = gameSchedule.getStartTime();
        this.endTime = gameSchedule.getEndTime();
        this.isAccess = gameSchedule.getIsAccess();
        this.recordStatus = gameSchedule.getRecordStatus();
        this.curTime = gameSchedule.getCurTime();
        this.score = gameSchedule.getScore();
        this.placeUnitInfo = gameSchedule.getPlaceUnitInfo();
        this.homeGameTeam = gameSchedule.getHomeGameTeam();
        this.awayGameTeam = gameSchedule.getAwayGameTeam();
        this.gameName = gameSchedule.getGameName();
        this.type = gameSchedule.getType();
        this.isWin = gameSchedule.getIsWin();
        this.group = gameSchedule.getGroup();
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public String getTimeDesc() {
        return timeDesc;
    }

    public void setTimeDesc(String timeDesc) {
        this.timeDesc = timeDesc;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getIsAccess() {
        return isAccess;
    }

    public void setIsAccess(int isAccess) {
        this.isAccess = isAccess;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public long getCurTime() {
        return curTime;
    }

    public void setCurTime(long curTime) {
        this.curTime = curTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public PlaceUnitInfo getPlaceUnitInfo() {
        return placeUnitInfo;
    }

    public void setPlaceUnitInfo(PlaceUnitInfo placeUnitInfo) {
        this.placeUnitInfo = placeUnitInfo;
    }

    public GameTeam getHomeGameTeam() {
        return homeGameTeam;
    }

    public void setHomeGameTeam(GameTeam homeGameTeam) {
        this.homeGameTeam = homeGameTeam;
    }

    public GameTeam getAwayGameTeam() {
        return awayGameTeam;
    }

    public void setAwayGameTeam(GameTeam awayGameTeam) {
        this.awayGameTeam = awayGameTeam;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsWin() {
        return isWin;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    public long getRoundId() {
        return roundId;
    }

    public void setRoundId(long roundId) {
        this.roundId = roundId;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getGameEventType() {
        return gameEventType;
    }

    public void setGameEventType(int gameEventType) {
        this.gameEventType = gameEventType;
    }
}
