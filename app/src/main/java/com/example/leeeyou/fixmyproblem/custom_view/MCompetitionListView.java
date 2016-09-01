package com.example.leeeyou.fixmyproblem.custom_view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.model.GameRoundScore;
import com.example.leeeyou.fixmyproblem.model.ScoreData;
import com.example.leeeyou.fixmyproblem.util.DisplayUtil;

import java.util.List;

/**
 * Created by leeeyou on 16/6/8.
 * <p/>
 * 赛事 数据界面 积分榜详情自定义UI
 */
public class MCompetitionListView extends LinearLayout {
    Paint mPaint;

    int groupHeight = 36;
    int itemHeight = 25;

    int groupHeightDp, itemHeightDp;

    ScoreData scoreData;

    TextView tv_ranking;
    TextView tv_team_name;
    TextView tv_round;
    TextView tv_result;
    TextView tv_score;

    LayoutInflater mLayoutInflater;

    public MCompetitionListView(Context context) {
        super(context);
    }

    public MCompetitionListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOrientation(LinearLayout.VERTICAL);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        initPaint();

        initHeight(context);
    }

    private void initHeight(Context context) {
        groupHeightDp = DisplayUtil.dip2px(context, groupHeight);
        itemHeightDp = DisplayUtil.dip2px(context, itemHeight);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setColor(Color.RED);
    }

    private void renderingUIDetails() {

        removeAllViews();

        View view_group = mLayoutInflater.inflate(R.layout.item_point_race_group, this, false);

        TextView tv_group_name = (TextView) view_group.findViewById(R.id.tv_group_name);
        if (!TextUtils.isEmpty(scoreData.groupName)) {
            tv_group_name.setVisibility(VISIBLE);
            tv_group_name.setText(scoreData.groupName);
            addView(view_group, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, groupHeightDp));
        } else {
            tv_group_name.setVisibility(GONE);
        }

        List<GameRoundScore> pointsRaceInfos = scoreData.pointsRaceInfos;
        int size = pointsRaceInfos.size();
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, itemHeightDp);
        GameRoundScore pointsRaceInfo;

        for (int i = 0; i < size; i++) {
            pointsRaceInfo = pointsRaceInfos.get(i);

            View view_detail = mLayoutInflater.inflate(R.layout.item_point_race_detail, this, false);

            tv_ranking = (TextView) view_detail.findViewById(R.id.tv_ranking);
            tv_team_name = (TextView) view_detail.findViewById(R.id.tv_team_name);
            tv_round = (TextView) view_detail.findViewById(R.id.tv_round);
            tv_result = (TextView) view_detail.findViewById(R.id.tv_result);
            tv_score = (TextView) view_detail.findViewById(R.id.tv_score);

            tv_ranking.setText(String.valueOf(i + 1) + "、");
            tv_team_name.setText(TextUtils.isEmpty(pointsRaceInfo.getTeamName()) ? "" : pointsRaceInfo.getTeamName());
            tv_round.setText(String.valueOf(pointsRaceInfo.getProducts()));
            tv_result.setText(pointsRaceInfo.getWins() + "/" + pointsRaceInfo.getFails() + "/" + pointsRaceInfo.getTies());
            tv_score.setText(String.valueOf((int) Math.floor(pointsRaceInfo.getScore())));

            addView(view_detail, params);
        }
    }

    public MCompetitionListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScoreData(ScoreData scoreData) {
        this.scoreData = scoreData;
        renderingUIDetails();
    }

}
