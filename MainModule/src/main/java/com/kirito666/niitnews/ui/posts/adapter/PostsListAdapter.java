package com.kirito666.niitnews.ui.posts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.databinding.ItemPostsLightBinding;
import com.kirito666.niitnews.databinding.LoadMoreFootviewLayoutBinding;
import com.kirito666.niitnews.entity.dto.SimplePost;
import com.kirito666.niitnews.ui.posts.ForumChildFragment;
import com.kirito666.niitnews.util.Tools;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostsListAdapter.java
 * @LastModified:2021/06/30 04:02:30
 */

public class PostsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<SimplePost> items;
    private final
    ForumChildFragment ctx;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //没有加载更多 隐藏
    public static final int NO_LOAD_MORE = 2;

    private int mLoadMoreStatus = NO_LOAD_MORE;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onShare(String title, String detail);

        void onForward(SimplePost post);

        void onFavor(int pid, OnFavorResult callback);

        void onFavorCancel(int pid, OnFavorResult callback);

        void onCommit(SimplePost post, boolean allow);

        void onItemClick(SimplePost post);
    }

    public interface OnFavorResult {
        void onSuccess();

        void onFailure();
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public PostsListAdapter(
            ForumChildFragment context, List<SimplePost> items) {
        this.items = items;
        ctx = context;
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
            SimplePost post = items.get(position);
            originalViewHolder.v.postAuthorNickname.setText(post.getNickname());
            Tools.displayImageOriginal(ctx.getContext(), originalViewHolder.v.postAuthorAvatar, post.getAvatar());
            originalViewHolder.v.postAuthorAccount.setText("@" + post.getAccount());

            originalViewHolder.v.postContentText.setText(post.getTextSmp());
            if (post.getAttachPic() == null || post.getAttachPic().isEmpty()) {
                originalViewHolder.v.postCover.setVisibility(View.GONE);
            } else {
                Tools.displayImageOriginal(ctx.getContext(), originalViewHolder.v.postCover, post.getAttachPic().get(0));
            }
            originalViewHolder.v.btnFavorBling.setChecked(post.isFavor(), true);
            originalViewHolder.v.tvViewsCount.setText(String.valueOf(post.getViewsNum()));
            originalViewHolder.v.tvShareCount.setText(String.valueOf(post.getShareCount()));
            originalViewHolder.v.tvFavorCount.setText(String.valueOf(post.getFavorCount()));
            originalViewHolder.v.tvCommitCount.setText(String.valueOf(post.getCommitCount()));
            originalViewHolder.v.btnPostShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener == null) {
                        return;
                    }
                    mOnItemClickListener.onShare(post.getTitle(), post.getTextSmp());
                }
            });
            originalViewHolder.v.btnPostForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener == null) {
                        return;
                    }
                    mOnItemClickListener.onForward(post);
                }
            });
            originalViewHolder.v.btnFavorBling.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!post.isFavor()) {
                        mOnItemClickListener.onFavor((int) post.getPid(), new OnFavorResult() {
                            @Override
                            public void onSuccess() {
                                post.setFavorCount(post.getFavorCount() + 1);
                                post.setFavor(true);
                                notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure() {
                                originalViewHolder.v.btnFavorBling.setChecked(false, true);
                            }
                        });
                    } else {
                        mOnItemClickListener.onFavorCancel((int) post.getPid(), new OnFavorResult() {
                            @Override
                            public void onSuccess() {
                                post.setFavorCount(post.getFavorCount() - 1);
                                post.setFavor(false);
                                notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure() {
                                originalViewHolder.v.btnFavorBling.setChecked(true, true);
                            }
                        });
                    }
                }
            });
            originalViewHolder.v.btnPostCommit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener == null) {
                        return;
                    }
                    mOnItemClickListener.onCommit(post, post.isAllowComment());
                }
            });

            originalViewHolder.v.postContent.setOnClickListener(v -> {
                if (mOnItemClickListener == null) {
                    return;
                }
                mOnItemClickListener.onItemClick(post);
                post.setViewsNum(post.getViewsNum() + 1);
                notifyDataSetChanged();
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
