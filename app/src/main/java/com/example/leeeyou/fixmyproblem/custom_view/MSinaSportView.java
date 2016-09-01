package com.example.leeeyou.fixmyproblem.custom_view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewConfigurationCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.model.GameSchedule;
import com.example.leeeyou.fixmyproblem.model.GameTeam;
import com.example.leeeyou.fixmyproblem.util.DisplayUtil;
import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leeeyou on 16/6/6.
 * <p/>
 * 淘汰赛制 仿新浪体育-赛事-欧冠 UI
 * <p>
 * 整体思路:
 * 1、先根据第一轮的参赛队伍数,生成对应的Node
 * 2、再依次生成之后的轮次Node
 * 3、最后将数据渲染到各个Node上  renderingToView()
 * <p>
 * 同时利用内部拦截法处理的事件冲突
 */
public class MSinaSportView extends HorizontalScrollView {
    private int round_first_size = 16;//第一轮的块数

    private int clearance_horizontal;//水平间隙
    private int clearance_vertical;//垂直间隙
    private int rectHeight, rectWidth;//rect的高和宽

    private LinkedList<Node> mNodeList;
    private LinkedList<Node> currentColumnNodeList;//存放当前的node

    private float mXDown, mYDown;

    private int mTouchSlop;

    private List<GameSchedule> gameScheduleList;//淘汰赛列表

    private Context ctx;

    int column = 0;//列编码
    int currentTeamNum = round_first_size;//控制淘汰赛剩下的队列数,初始为TEAM_COUNT

    public MSinaSportView(Context context) {
        super(context);
    }

    public MSinaSportView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        ctx = context;

        initData(context);

        renderingToView(context);
    }

    /**
     * 渲染rect到视图上
     *
     * @param context the context
     */
    private void renderingToView(Context context) {
        int dataCountSize = mNodeList.size();

        FrameLayout frameLayout = new FrameLayout(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = clearance_horizontal * 4;
        frameLayout.setLayoutParams(params);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int currentPosition = 0; currentPosition < dataCountSize; currentPosition++) {
            View inflate = layoutInflater.inflate(R.layout.item_sina_sport, this, false);

            ImageView img_team1_pic = (ImageView) inflate.findViewById(R.id.img_team1_pic);
            ImageView img_team2_pic = (ImageView) inflate.findViewById(R.id.img_team2_pic);

            TextView item_team1_name = (TextView) inflate.findViewById(R.id.item_team1_name);
            TextView item_team2_name = (TextView) inflate.findViewById(R.id.item_team2_name);

            TextView tv_team1_score = (TextView) inflate.findViewById(R.id.tv_team1_score);
            TextView tv_team2_score = (TextView) inflate.findViewById(R.id.tv_team2_score);

            TextView tv_time = (TextView) inflate.findViewById(R.id.tv_time);

            if (gameScheduleList != null && currentPosition < gameScheduleList.size()) {
                GameSchedule gameSchedule = gameScheduleList.get(currentPosition);
                GameTeam homeGameTeam = gameSchedule.getHomeGameTeam();
                GameTeam awayGameTeam = gameSchedule.getAwayGameTeam();

                if (homeGameTeam != null
                        && homeGameTeam.getUserList() != null
                        && homeGameTeam.getUserList().size() > 0) {
                    Glide.with(ctx)
                            .load(homeGameTeam.getUserList().get(0).getIcon())
                            .error(R.mipmap.bg_default_color)
                            .into(img_team1_pic);

                    item_team1_name.setText(homeGameTeam.getUserList().get(0).getNick());

                    if (!TextUtils.isEmpty(gameSchedule.getScore())) {
                        tv_team1_score.setText(gameSchedule.getScore().substring(0, gameSchedule.getScore().indexOf(":")));
                    }
                }

                if (awayGameTeam == null) {
                    tv_time.setText("轮空\n直接晋级");
                } else {
                    if (awayGameTeam.getUserList() != null && awayGameTeam.getUserList().size() > 0) {
                        Glide.with(ctx)
                                .load(awayGameTeam.getUserList().get(0).getIcon())
                                .error(R.mipmap.bg_default_color)
                                .into(img_team2_pic);

                        item_team2_name.setText(awayGameTeam.getUserList().get(0).getNick());

                        if (!TextUtils.isEmpty(gameSchedule.getScore())) {
                            tv_team2_score.setText(gameSchedule.getScore().substring(gameSchedule.getScore().indexOf(":") + 1));
                        }
                    }

//                    tv_time.setText(DateUtils.getDate3(gameSchedule.getStartTime()));
                }

            }

            LayoutParams layoutParams = new LayoutParams(rectWidth, rectHeight);
            layoutParams.topMargin = mNodeList.get(currentPosition).rect.top;
            layoutParams.leftMargin = mNodeList.get(currentPosition).rect.left;

            if (currentPosition == round_first_size - 1) {//修正第一列最后一个元素的bottomMargin,使底部边缘有一定的间隙
                layoutParams.bottomMargin = clearance_horizontal * 4;
            }

            if (currentPosition == dataCountSize - 1) {//修正最后一个元素的rightMargin,使右边缘有一定的间隙
                layoutParams.rightMargin = clearance_vertical;
            }

            frameLayout.addView(inflate, layoutParams);
        }

        addView(frameLayout);
    }


    /**
     * 初始化数据
     *
     * @param context the context
     */
    private void initData(Context context) {
        currentTeamNum = round_first_size;

        initBasicData(context);

        mNodeList = new LinkedList<>();
        currentColumnNodeList = new LinkedList<>();

        if (column == 0) {
            for (int index = 0; index < currentTeamNum; index++) {
                int left, right, top, bottom;

                Node teamNode = new Node();

                teamNode.key = column;

                left = rectWidth * teamNode.key + clearance_vertical * (teamNode.key + 1);
                right = rectWidth * (teamNode.key + 1) + clearance_vertical * (teamNode.key + 1);

                top = rectHeight * index + clearance_horizontal * (index + 1);
                bottom = top + rectHeight;

                teamNode.rect = new Rect(left, top, right, bottom);

                teamNode.index = mNodeList.size();

                currentColumnNodeList.add(teamNode);
            }

            mNodeList.addAll(currentColumnNodeList);
        }

        while (currentTeamNum > 1) {

            // 生成下一列的NodeList

            LinkedList<Node> tempNodeList = new LinkedList<>();

            column += 1;

            for (int i = 0; i < currentTeamNum; i++) {
                if ((i + 1) % 2 == 0) {
                    // 生成Node
                    Node teamNode = new Node();

                    int left, right, top, bottom;

                    teamNode.key = column;

                    left = rectWidth * column + clearance_vertical * (column + 1);
                    right = rectWidth * (column + 1) + clearance_vertical * (column + 1);
                    // TODO: 16/8/11 数组越界异常
                    if (i - 1 >= 0 && i - 1 < currentColumnNodeList.size() - 1) {
                        Node leftNode = currentColumnNodeList.get(i - 1);
                        Node rightNode = currentColumnNodeList.get(i);
                        top = leftNode.rect.top + rectHeight / 2 + (rightNode.rect.top - leftNode.rect.bottom) / 2;
                        bottom = top + rectHeight;
                        teamNode.rect = new Rect(left, top, right, bottom);
                    }

                    teamNode.index = mNodeList.size();

                    tempNodeList.add(teamNode);
                } else {
                    if (i == currentTeamNum - 1) {
                        // 判断轮空的情况,生成Node添加到tempNodeList
                        Node teamNode = new Node();

                        int left, right, top = 0, bottom = 0;

                        teamNode.key = column;

                        left = rectWidth * column + clearance_vertical * (column + 1);
                        right = rectWidth * (column + 1) + clearance_vertical * (column + 1);

                        if (currentColumnNodeList.size() == currentTeamNum) {
                            Node leftNode = currentColumnNodeList.get(i);
                            top = leftNode.rect.top;
                            bottom = top + rectHeight;
                        }

                        teamNode.rect = new Rect(left, top, right, bottom);

                        teamNode.index = mNodeList.size();

                        tempNodeList.add(teamNode);
                    }
                }
            }

            currentColumnNodeList.clear();
            currentColumnNodeList.addAll(tempNodeList);
            mNodeList.addAll(currentColumnNodeList);

            if (currentTeamNum % 2 == 0) {
                currentTeamNum /= 2;
            } else {
                currentTeamNum /= 2;
                currentTeamNum += 1;
            }

        }
    }

    /**
     * 初始化长度,宽度,间隙等数据
     *
     * @param context the context
     */
    private void initBasicData(Context context) {
        clearance_horizontal = DisplayUtil.dip2px(context, 4);//水平间隙
        clearance_vertical = DisplayUtil.dip2px(context, 12);//垂直间隙
        rectWidth = DisplayUtil.dip2px(context, 185);//rect的宽度
        rectHeight = DisplayUtil.dip2px(context, 60);//rect的高度
    }

    public MSinaSportView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mXDown = ev.getRawX();
                mYDown = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float mXMove = ev.getRawX();
                float mYMove = ev.getRawY();

                float dx = Math.abs(mXMove - mXDown);
                float dy = Math.abs(mYMove - mYDown);

                if (dy > dx || dx > 12 * mTouchSlop) {//垂直滑动时,事件给到父控件
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
        }
        return super.onTouchEvent(event);
    }

    class Node {
        public Rect rect;
        public int key;//层次编码,从0开始
        public int index;//下标索引

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public void setRound_first_size(int round_first_size) {
        this.round_first_size = round_first_size;
    }

    public void setGameScheduleList(List<GameSchedule> gameScheduleList) {
        this.gameScheduleList = gameScheduleList;

        initData(ctx);

        renderingToView(ctx);
    }

}
