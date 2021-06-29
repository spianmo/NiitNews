package com.kirito666.niitnews.ui.post_detail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.databinding.ItemPostCommitBinding;
import com.kirito666.niitnews.entity.dto.CommitDto;
import com.kirito666.niitnews.util.Tools;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CommitListAdapter.java
 * @LastModified:2021/06/29 10:37:29
 */

public class CommitListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<CommitDto> items;
    private final
    Context ctx;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onEnterCommitOwnerPofile(View view, int ownerId, int position);

        void onReplyCommit(View view, CommitDto obj, int position);

        void onDeleteCommit(View view, CommitDto obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public CommitListAdapter(
            Context context, List<CommitDto> items) {
        this.items = items;
        ctx = context;
    }


    public static class OriginalViewHolder extends RecyclerView.ViewHolder {
        ItemPostCommitBinding v;

        public OriginalViewHolder(ItemPostCommitBinding binding) {
            super(binding.getRoot());
            v = binding;
        }
    }

    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        ItemPostCommitBinding v = ItemPostCommitBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new OriginalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        OriginalViewHolder originalViewHolder = (OriginalViewHolder) holder;
        CommitDto commit = items.get(position);
        Tools.displayImageOriginal(ctx, originalViewHolder.v.commitAuthorAvatar, commit.getAvatar());
        originalViewHolder.v.commitAuthorNickname.setText(commit.getNickname());
        originalViewHolder.v.commitContent.setText(commit.getText());
        originalViewHolder.v.commitTime.setText(commit.getCreateTime().toGMTString());
        originalViewHolder.v.commitAuthorInfo.setOnClickListener(v -> {

        });
        originalViewHolder.v.commitAuthorInfo.setOnClickListener(v -> {
            if (mOnItemClickListener == null) {
                return;
            }
            mOnItemClickListener.onEnterCommitOwnerPofile(v, (int) commit.getOwnerId(), position);
        });
        originalViewHolder.v.commitRoot.setOnClickListener(v -> {
            if (mOnItemClickListener == null) {
                return;
            }
            mOnItemClickListener.onReplyCommit(v, commit, position);
        });
        originalViewHolder.v.commitRoot.setOnLongClickListener(v -> {
            if (mOnItemClickListener == null) {
                return false;
            }
            mOnItemClickListener.onDeleteCommit(v, commit, position);
            return true;
        });
    }


    public void clearData() {
        items.clear();
    }


    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

}
