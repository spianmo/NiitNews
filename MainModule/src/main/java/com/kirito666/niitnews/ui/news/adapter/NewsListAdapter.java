package com.kirito666.niitnews.ui.news.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.databinding.ItemNewsLightBinding;
import com.kirito666.niitnews.entity.News;
import com.kirito666.niitnews.util.Tools;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:NewsListAdapter.java
 * @LastModified:2021/06/22 10:32:22
 */

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<News> items;

    private final Context ctx;

    @LayoutRes
    private final int layoutId;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, News obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public NewsListAdapter(Context context, List<News> items, @LayoutRes int layoutId) {
        this.items = items;
        ctx = context;
        this.layoutId = layoutId;
    }


    public static class OriginalViewHolder extends RecyclerView.ViewHolder {
        ItemNewsLightBinding v;

        public OriginalViewHolder(ItemNewsLightBinding binding) {
            super(binding.getRoot());
            v = binding;
        }
    }

    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemNewsLightBinding v = ItemNewsLightBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new OriginalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            News n = items.get(position);
            if (TextUtils.isEmpty(n.getCoverImg())) {
                view.v.image.setVisibility(View.GONE);
                view.v.cardview.setVisibility(View.GONE);
            } else {
                Tools.displayImageOriginal(ctx, view.v.image, n.getCoverImg());
            }
            view.v.title.setText(n.getTitle());
            view.v.subtitle.setText(n.getHint());
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            view.v.date.setText(sdf.format(n.getPostTime().getTime()));
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
