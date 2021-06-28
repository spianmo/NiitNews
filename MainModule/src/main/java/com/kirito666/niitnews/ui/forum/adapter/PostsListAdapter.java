package com.kirito666.niitnews.ui.forum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.databinding.ItemPostsLightBinding;
import com.kirito666.niitnews.databinding.LoadMoreFootviewLayoutBinding;
import com.kirito666.niitnews.entity.dto.SimplePost;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostsListAdapter.java
 * @LastModified:2021/06/28 10:54:28
 */

public class PostsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<SimplePost> items;
    private final Context ctx;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //没有加载更多 隐藏
    public static final int NO_LOAD_MORE = 2;

    private int mLoadMoreStatus = 1;

    @LayoutRes
    private final int layoutId;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, SimplePost obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public PostsListAdapter(Context context, List<SimplePost> items, @LayoutRes int layoutId) {
        this.items = items;
        ctx = context;
        this.layoutId = layoutId;
    }


    public static class OriginalViewHolder extends RecyclerView.ViewHolder {
        ItemPostsLightBinding v;

        public OriginalViewHolder(ItemPostsLightBinding binding) {
            super(binding.getRoot());
            v = binding;
        }
    }

    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            ItemPostsLightBinding v = ItemPostsLightBinding.inflate(LayoutInflater.from(parent.getContext()));
            return new OriginalViewHolder(v);
        } else if (viewType == TYPE_FOOTER) {
            LoadMoreFootviewLayoutBinding v = LoadMoreFootviewLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new FooterViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder originalViewHolder = (OriginalViewHolder) holder;

            SimplePost n = items.get(position);
            // TODO: 6/28/2021 帖子点击事件与视图显示
            originalViewHolder.v.itemRoot.setOnClickListener(v -> {
                if (mOnItemClickListener == null) {
                    return;
                }
                mOnItemClickListener.onItemClick(v, items.get(position), position);
            });
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;

            switch (mLoadMoreStatus) {
                case PULLUP_LOAD_MORE:
                    footerViewHolder.v.tvLoadText.setText("上拉加载更多数据~");
                    break;
                case LOADING_MORE:
                    footerViewHolder.v.tvLoadText.setText("一大波新的新闻来啦~");
                    break;
                case NO_LOAD_MORE:
                    footerViewHolder.v.itemRoot.setVisibility(View.GONE);
                    break;

            }
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        LoadMoreFootviewLayoutBinding v;

        public FooterViewHolder(LoadMoreFootviewLayoutBinding binding) {
            super(binding.getRoot());
            v = binding;
        }
    }


    @Override
    public int getItemViewType(int position) {

        if (position + 1 == getItemCount()) {
            //最后一个item设置为footerView
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }


    public void addHeaderItem(List<SimplePost> items) {
        items.addAll(0, items);
        notifyDataSetChanged();
    }

    public void clearData() {
        items.clear();
    }

    public void addFooterItem(List<SimplePost> items) {
        items.addAll(items);
        notifyDataSetChanged();
    }


    /**
     * 更新加载更多状态
     *
     * @param status
     */
    public void changeMoreStatus(int status) {
        mLoadMoreStatus = status;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

}
