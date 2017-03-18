package com.example.leeeyou.fixmyproblem.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.model.vo.MultipleItem;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem> {

    public MultipleItemQuickAdapter(Context context, List data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.item_text_view);
        addItemType(MultipleItem.IMG, R.layout.item_image_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv, item.getContent());
                break;
            case MultipleItem.IMG:
                helper.setText(R.id.tv_desc, item.getContent());
                break;
        }
    }

}
