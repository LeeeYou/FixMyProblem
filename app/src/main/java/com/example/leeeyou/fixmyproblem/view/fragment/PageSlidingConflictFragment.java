package com.example.leeeyou.fixmyproblem.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.view.custom.MCompetitionListView;
import com.example.leeeyou.fixmyproblem.view.custom.MListView;
import com.example.leeeyou.fixmyproblem.model.bean.GameRoundScore;
import com.example.leeeyou.fixmyproblem.model.bean.ScoreData;
import com.example.leeeyou.fixmyproblem.util.UniversalAdapter;
import com.example.leeeyou.fixmyproblem.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeeyou on 16/8/31.
 * <p>
 * 事件冲突案例Fragment
 */
public class PageSlidingConflictFragment extends Fragment {

    public static final String[] chars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private UniversalAdapter<ScoreData> mScoreBoardAdapter;
    private MListView lv_scoreboard;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_sliding_conflict2, null);

        lv_scoreboard = (MListView) inflate.findViewById(R.id.lv_scoreboard);

        fillPointGameData();

        return inflate;
    }

    /**
     * 填充积分赛数据
     */
    private void fillPointGameData() {

        List<ScoreData> mScoreboardList = new ArrayList<>();
        ScoreData scoreData;

        for (int i = 0; i < 18; i++) {
            scoreData = new ScoreData();
            scoreData.groupName = chars[i] + "组";

            scoreData.pointsRaceInfos = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                GameRoundScore gameRoundScore = new GameRoundScore();
                gameRoundScore.setTeamName("阿姆斯特丹" + j);
                gameRoundScore.setGameRoundId(j);
                gameRoundScore.setGameEventTeamId(j);
                gameRoundScore.setGroupType(j);
                gameRoundScore.setScore(10);
                gameRoundScore.setWins(j + 10);
                gameRoundScore.setFails(j - 2);
                gameRoundScore.setTies(j + 2);
                scoreData.pointsRaceInfos.add(gameRoundScore);
            }
            mScoreboardList.add(scoreData);
        }

        if (mScoreBoardAdapter == null) {
            mScoreBoardAdapter = new UniversalAdapter<ScoreData>(getActivity(), mScoreboardList, R.layout.item_scoreboard2) {
                @Override
                public void convert(ViewHolder vh, ScoreData item, int position) {
                    MCompetitionListView competition_listview = vh.getView(R.id.competition_listview);
                    competition_listview.setScoreData(item);
                }
            };
            lv_scoreboard.setAdapter(mScoreBoardAdapter);
        }

    }

}
