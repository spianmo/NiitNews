package com.kirito666.niitnews.ui.rank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.databinding.ItemRankHorizontalBinding;
import com.kirito666.niitnews.entity.Rank;
import com.kirito666.niitnews.util.Tools;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:RankListAdapter.java
 * @LastModified:2021/06/22 14:08:22
 */

public class RankListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Rank> items;

    private final Context ctx;

    @LayoutRes
    private final int layoutId;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Rank obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public RankListAdapter(Context context, List<Rank> items, @LayoutRes int layoutId) {
        this.items = items;
        ctx = context;
        this.layoutId = layoutId;
    }


    public static class OriginalViewHolder extends RecyclerView.ViewHolder {
        ItemRankHorizontalBinding v;

        public OriginalViewHolder(ItemRankHorizontalBinding binding) {
            super(binding.getRoot());
            v = binding;
        }
    }

    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRankHorizontalBinding v = ItemRankHorizontalBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new OriginalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            Rank currentRank = items.get(position);
            view.v.title.setText(currentRank.getTitle());
            view.v.subtitle.setText(currentRank.getDesc());
            SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            view.v.date.setText(sdt.format(currentRank.getWashTime()));
            Tools.displayImageOriginal(ctx, view.v.image, currentRank.getCoverImg());
            // TODO: 6/22/2021 热搜榜item视图显示逻辑
            view.v.itemRoot.setOnClickListener(v -> {
                if (mOnItemClickListener == null) {
                    return;
                }
                mOnItemClickListener.onItemClick(v, items.get(position), position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
