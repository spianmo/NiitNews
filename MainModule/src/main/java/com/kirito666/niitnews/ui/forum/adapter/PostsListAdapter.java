package com.kirito666.niitnews.ui.forum.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.kirito666.niitnews.App;
import com.kirito666.niitnews.databinding.ItemPostsLightBinding;
import com.kirito666.niitnews.databinding.LoadMoreFootviewLayoutBinding;
import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.entity.dto.SimplePost;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;
import com.kirito666.niitnews.ui.forum.ForumChildFragment;
import com.kirito666.niitnews.util.Tools;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostsListAdapter.java
 * @LastModified:2021/06/29 01:31:29
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

    private int mLoadMoreStatus = 1;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, SimplePost obj, int position);
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
            RetrofitClient.getInstance().getApi().getUserDetail((int) post.getAuthorId()).enqueue(new Callback<BaseResponse<User>>() {
                @Override
                public void onResponse(Call<BaseResponse<User>> call, Response<BaseResponse<User>> response) {
                    BaseResponse<User> rawResponse = response.body();
                    if (rawResponse.getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                        User user = response.body().getData();
                        originalViewHolder.v.postAuthorNickname.setText(user.getNickname());
                        Tools.displayImageOriginal(ctx.getContext(), originalViewHolder.v.postAuthorAvatar, user.getAvatar());
                        originalViewHolder.v.postAuthorAccount.setText(user.getAccount());
                    } else {
                        ctx.showSnackBar(rawResponse.getMsg());
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<User>> call, Throwable t) {
                    Toast.makeText(ctx.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            originalViewHolder.v.postContentText.setText(post.getTextSmp());
            if (post.getAttachPic() == null || post.getAttachPic().isEmpty()) {
                originalViewHolder.v.postCover.setVisibility(View.GONE);
            } else {
                Tools.displayImageOriginal(ctx.getContext(), originalViewHolder.v.postCover, post.getAttachPic().get(0));
            }
            originalViewHolder.v.btnFavorBling.setChecked(post.isFavor(), false);
            originalViewHolder.v.tvViewsCount.setText(String.valueOf(post.getViewsNum()));
            originalViewHolder.v.tvShareCount.setText(String.valueOf(post.getShareCount()));
            originalViewHolder.v.tvFavorCount.setText(String.valueOf(post.getFavorCount()));
            originalViewHolder.v.tvCommitCount.setText(String.valueOf(post.getCommitCount()));
            originalViewHolder.v.btnPostShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Tools.share(App.getAppContext(), post.getTitle(), post.getTextSmp());
                }
            });
            originalViewHolder.v.btnPostForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RetrofitClient.getInstance().getApi().forwardPost((int) post.getPid()).enqueue(new Callback<BaseResponse<String>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                            if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                                ctx.showSnackBar("转发成功");
                            } else {
                                ctx.showSnackBar("转发失败");
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                            Toast.makeText(ctx.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
            originalViewHolder.v.btnPostFavor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!post.isFavor()) {
                        RetrofitClient.getInstance().getApi().favorPost((int) post.getPid()).enqueue(new Callback<BaseResponse<String>>() {
                            @Override
                            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                                    originalViewHolder.v.btnFavorBling.setChecked(true, true);
                                } else {
                                    ctx.showSnackBar("点赞失败");
                                }
                            }

                            @Override
                            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                                Toast.makeText(ctx.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        RetrofitClient.getInstance().getApi().deleteFavor((int) post.getPid()).enqueue(new Callback<BaseResponse<String>>() {
                            @Override
                            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                                    originalViewHolder.v.btnFavorBling.setChecked(false, true);
                                } else {
                                    ctx.showSnackBar("取消点赞失败");
                                }
                            }

                            @Override
                            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                                Toast.makeText(ctx.getContext(), t.toString(), Toast.LENGTH_SHORT).show();
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
                    mOnItemClickListener.onItemClick(v, items.get(position), position);
                }
            });

            // TODO: 6/28/2021 帖子点击事件与视图显示
            originalViewHolder.v.postContent.setOnClickListener(v -> {
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
