package com.kirito666.niitnews.ui.rank;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.FragmentRankBinding;
import com.kirito666.niitnews.databinding.ItemSliderImageBinding;
import com.kirito666.niitnews.entity.Banner;
import com.kirito666.niitnews.entity.News;
import com.kirito666.niitnews.entity.Rank;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;
import com.kirito666.niitnews.ui.rank.adapter.RankListAdapter;
import com.kirito666.niitnews.ui.single.NewsDetailPage;
import com.kirito666.niitnews.ui.single.WebPage;
import com.kirito666.niitnews.util.Tools;
import com.kirshi.framework.databinding.DataBindingConfig;
import com.kirshi.framework.databinding.DataBindingFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:RankFragment.java
 * @LastModified:2021/06/23 23:42:23
 */

public class RankFragment extends DataBindingFragment<FragmentRankBinding> {
    private RankPageViewModel mRankPageViewModel;
    private RankListAdapter mAdapter;
    private final boolean isPost;

    private SliderAdapter sliderAdapter;
    private Runnable runnable = null;
    private Handler handler = new Handler(Looper.getMainLooper());

    public RankFragment(boolean isPost) {
        this.isPost = isPost;
    }

    @Override
    protected void initViewModel() {
        mRankPageViewModel = new RankPageViewModel(isPost);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_rank, BR.vm, mRankPageViewModel)
                .addBindingParam(BR.click, new RankFragment.ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        v.recyclerView.setHasFixedSize(true);
        mAdapter = new RankListAdapter(getContext(), mRankPageViewModel.ranks.getValue(), R.layout.item_news_light);
        mAdapter.setOnItemClickListener(new RankListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Rank rank, int position) {
                // TODO: 6/22/2021 热搜榜点击事件
                RetrofitClient.getInstance().getApi().getNewsById((int) rank.getPid()).enqueue(new Callback<BaseResponse<News>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<News>> call, Response<BaseResponse<News>> response) {
                        if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                            News news = response.body().getData();
                            if (TextUtils.isEmpty(news.getContent())) {
                                ///_redirect?siteId=133&columnId=4002&articleId=39723
                                Intent intent = new Intent(mActivity, WebPage.class);
                                intent.putExtra("title", news.getTitle());
                                intent.putExtra("url", "http://news.niit.edu.cn/" + news.getSourceUrl());
                                mActivity.startActivity(intent);
                            } else {
                                Intent intent = new Intent(mActivity, NewsDetailPage.class);
                                intent.putExtra("news", news);
                                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity, view, "EXTRA_VIEW");
                                //mActivity.startActivity(intent, options.toBundle());
                                mActivity.startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<News>> call, Throwable t) {

                    }
                });
            }
        });
        //((SimpleItemAnimator)v.recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        //v.recyclerView.getItemAnimator().setChangeDuration(0);
        v.recyclerView.setAdapter(mAdapter);
        mRankPageViewModel.ranks.observe(getViewLifecycleOwner(), new Observer<List<Rank>>() {
            @Override
            public void onChanged(List<Rank> ranks) {
                mAdapter.notifyDataSetChanged();
                v.refreshLayout.setRefreshing(false);
            }
        });
        mRankPageViewModel.fetchRank();
        v.refreshLayout.setColorSchemeResources(R.color.google_blue,
                R.color.google_green, R.color.google_yellow,
                R.color.google_red);
        v.refreshLayout.setDistanceToTriggerSync(300);
        v.refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        v.refreshLayout.setOnRefreshListener(() -> {
            v.refreshLayout.setRefreshing(true);
            if (v != null) {
                mRankPageViewModel.fetchRank();
            }
        });

        mRankPageViewModel.fetchBanner();

        sliderAdapter = new SliderAdapter(mActivity, mRankPageViewModel.banners.getValue());
        v.pager.setAdapter(sliderAdapter);
        mRankPageViewModel.banners.observe(getViewLifecycleOwner(), new Observer<List<Banner>>() {
            @Override
            public void onChanged(List<Banner> banners) {
                sliderAdapter.notifyDataSetChanged();
                if (!banners.isEmpty()) {
                    v.pager.setCurrentItem(0);
                    addBottomDots(v.layoutDots, sliderAdapter.getCount(), 0);
                    v.title.setText(mRankPageViewModel.banners.getValue().get(0).getTitle());
                    v.brief.setText(mRankPageViewModel.banners.getValue().get(0).getHint());
                    startAutoSlider(sliderAdapter.getCount());
                }
            }
        });

        v.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                v.title.setText(mRankPageViewModel.banners.getValue().get(position).getTitle());
                v.brief.setText(mRankPageViewModel.banners.getValue().get(position).getHint());
                addBottomDots(v.layoutDots, sliderAdapter.getCount(), position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void addBottomDots(LinearLayout layout_dots, int size, int current) {
        ImageView[] dots = new ImageView[size];

        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(mActivity);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle_outline);
            layout_dots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.shape_circle);
        }
    }

    private void startAutoSlider(final int count) {
        runnable = () -> {
            int pos = v.pager.getCurrentItem();
            pos = pos + 1;
            if (pos >= count) {
                pos = 0;
            }
            v.pager.setCurrentItem(pos);
            handler.postDelayed(runnable, 3000);
        };
        handler.postDelayed(runnable, 3000);
    }

    public static class ClickProxy implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return true;
        }
    }

    private static class SliderAdapter extends PagerAdapter {

        private final Activity activity;
        private List<Banner> items;

        private SliderAdapter.OnItemClickListener onItemClickListener;

        private interface OnItemClickListener {
            void onItemClick(View view, Banner banner);
        }

        public void setOnItemClickListener(SliderAdapter.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        private SliderAdapter(Activity activity, List<Banner> items) {
            this.activity = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        public Banner getItem(int pos) {
            return items.get(pos);
        }

        public void setItems(List<Banner> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
            return view == ((RelativeLayout) object);
        }

        @NotNull
        @Override
        public Object instantiateItem(@NotNull ViewGroup container, int position) {
            final Banner banner = items.get(position);
            ItemSliderImageBinding v = ItemSliderImageBinding.inflate(LayoutInflater.from(container.getContext()), container, false);
            Tools.displayImageOriginal(activity, v.image, banner.getPicUrl());
            v.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, banner);
                    }
                }
            });

            ((ViewPager) container).addView(v.getRoot());
            return v.getRoot();
        }

        @Override
        public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);

        }

    }

    @Override
    public void onDestroyView() {
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroyView();
    }

}
