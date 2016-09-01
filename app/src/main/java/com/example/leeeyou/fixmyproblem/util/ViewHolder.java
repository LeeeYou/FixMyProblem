package com.example.leeeyou.fixmyproblem.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leeeyou.fixmyproblem.R;

import java.io.ByteArrayOutputStream;

public class ViewHolder {
    private final SparseArray<View> mViews;

    private View mConvertView;

    private Context context;

    public ViewHolder(Context context, ViewGroup parent, int resLayoutId, int position) {
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(resLayoutId, parent, false);
        mConvertView.setTag(R.id.convertView_id, this);
        this.context = context;
    }

    /**
     * 获取ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param resLayoutId
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int resLayoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, resLayoutId, position);
        }

        ViewHolder vh = (ViewHolder) convertView.getTag(R.id.convertView_id);
        return vh;
    }

    public <T extends View> T getView(int viewId) {
        return retrieveView(viewId);
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T retrieveView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setText(int viewId, SpannableStringBuilder style) {
        TextView tv = getView(viewId);
        tv.setText(style);
        return this;
    }

    public ViewHolder setTextColor(int viewId, int color) {
        TextView tv = getView(viewId);
        tv.setTextColor(color);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int drawableId) {
        Glide.with(context)
                .load(drawableId)
                .centerCrop()
                .into((ImageView) retrieveView(viewId));
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        byte[] bitmapBytes = bitmapToByte(bm);

        Glide.with(context)
                .load(bitmapBytes)
                .centerCrop()
                .into((ImageView) retrieveView(viewId));
        return this;
    }

    private byte[] bitmapToByte(Bitmap bm) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, out);
        return out.toByteArray();
    }

    public ViewHolder setImageByUrl(int viewId, String url) {
        return setImageByUrl(viewId, url, -1);
    }

    public ViewHolder setImageByUrl(int viewId, String url, int defaultImageRes) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .error(defaultImageRes)
                .into((ImageView) retrieveView(viewId));
        return this;
    }

    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public ViewHolder setTextBackground(int viewId, int color) {
        TextView tv = getView(viewId);
        tv.setBackgroundColor(color);
        return this;
    }

    public ViewHolder setTextBackgroundDrawable(int viewId, @DrawableRes int drawable) {
        TextView tv = getView(viewId);
        tv.setBackgroundResource(drawable);
        return this;
    }

    public ViewHolder setRadioButtonText(int viewId, String text) {
        RadioButton radioButton = getView(viewId);
        radioButton.setText(text);
        return this;
    }

    public ViewHolder setRadioButtonChecked(int viewId, boolean checked) {
        RadioButton radioButton = getView(viewId);
        radioButton.setChecked(checked);
        return this;
    }

    public ViewHolder setVisible(int viewId, int visible) {
        View view = getView(viewId);
        view.setVisibility(visible);
        return this;
    }

    public ViewHolder setRating(int viewId, float ratingValue) {
        RatingBar view = getView(viewId);
        view.setRating(ratingValue);
        return this;
    }

}
