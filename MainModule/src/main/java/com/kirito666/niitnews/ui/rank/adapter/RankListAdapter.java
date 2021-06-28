package com.kirito666.niitnews.ui.rank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * @LastModified:2021/06/29 02:16:29
 */

public class RankListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Rank> items;

    private final Context ctx;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Rank obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public RankListAdapter(Context context, List<Rank> items) {
        this.items = items;
        ctx = context;
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
            //view.v.tvRankScore.setText(sdt.format(currentRank.getWashTime()));
            view.v.tvRankScore.setText("\uD83D\uDD25热度：" + currentRank.getScore() + "℃");
            view.v.tvRankId.setText("#" + (position + 1));
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
