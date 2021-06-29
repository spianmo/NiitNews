package com.kirito666.niitnews.ui.post_edit;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.recyclerview.widget.GridLayoutManager;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.PagePostEditBinding;
import com.kirito666.niitnews.entity.Post;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.net.retrofit.RetrofitClient;
import com.kirito666.niitnews.ui.post_edit.adapter.FullyGridLayoutManager;
import com.kirito666.niitnews.ui.post_edit.adapter.GridImageAdapter;
import com.kirito666.niitnews.util.GlideCacheEngine;
import com.kirito666.niitnews.util.GlideEngine;
import com.kirshi.framework.viewbinding.BaseActivity;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.instagram.InsGallery;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.tools.ScreenUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostEditPage.java
 * @LastModified:2021/06/29 20:34:29
 */

public class PostEditPage extends BaseActivity<PagePostEditBinding> {

    private GridImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(v.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        FullyGridLayoutManager manager = new FullyGridLayoutManager(this,
                4, GridLayoutManager.VERTICAL, false);
        v.postImg.setLayoutManager(manager);

        v.postImg.addItemDecoration(new GridSpacingItemDecoration(4,
                ScreenUtils.dip2px(this, 8), false));
        mAdapter = new GridImageAdapter(mContext, new GridImageAdapter.onAddPicClickListener() {
            @Override
            public void onAddPicClick() {
                InsGallery.openGallery(mContext, GlideEngine.createGlideEngine(), GlideCacheEngine.createCacheEngine(), mAdapter.getData(), new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {
                        for (LocalMedia media : result) {
                            Log.i(TAG, "是否压缩:" + media.isCompressed());
                            Log.i(TAG, "压缩:" + media.getCompressPath());
                            Log.i(TAG, "原图:" + media.getPath());
                            Log.i(TAG, "是否裁剪:" + media.isCut());
                            Log.i(TAG, "裁剪:" + media.getCutPath());
                            Log.i(TAG, "是否开启原图:" + media.isOriginal());
                            Log.i(TAG, "原图路径:" + media.getOriginalPath());
                            Log.i(TAG, "Android Q 特有Path:" + media.getAndroidQToPath());
                            Log.i(TAG, "Size: " + media.getSize());
                        }
                        mAdapter.getData().addAll(result);
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancel() {

                    }
                });
            }
        });
        InsGallery.setCurrentTheme(InsGallery.THEME_STYLE_DEFAULT);
        mAdapter.setSelectMax(9);
        v.postImg.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((v, position) -> {
            List<LocalMedia> selectList = mAdapter.getData();
            if (selectList.size() > 0) {
                LocalMedia media = selectList.get(position);
                String mimeType = media.getMimeType();
                int mediaType = PictureMimeType.getMimeType(mimeType);
                switch (mediaType) {
                    case PictureConfig.TYPE_VIDEO:
                        // 预览视频
                        PictureSelector.create(mContext)
                                .themeStyle(R.style.picture_default_style)
                                .externalPictureVideo(media.getPath());
                        break;
                    case PictureConfig.TYPE_AUDIO:
                        // 预览音频
                        PictureSelector.create(mContext)
                                .externalPictureAudio(PictureMimeType.isContent(media.getPath()) ? media.getAndroidQToPath() : media.getPath());
                        break;
                    default:
                        //PictureWindowAnimationStyle animationStyle = new PictureWindowAnimationStyle();
                        //animationStyle.activityPreviewEnterAnimation = R.anim.picture_anim_up_in;
                        //animationStyle.activityPreviewExitAnimation = R.anim.picture_anim_down_out;
                        PictureSelector.create(mContext)
                                .themeStyle(R.style.picture_default_style)
                                //.setPictureWindowAnimationStyle(animationStyle)
                                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                                .isNotPreviewDownload(true)
                                .imageEngine(GlideEngine.createGlideEngine())
                                .openExternalPreview(position, selectList);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editor_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LOGE(item.toString());
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_save:
                Post post = new Post();
                post.setText(v.postText.getText().toString());
                RetrofitClient.getInstance().getApi().insertPost(post).enqueue(new Callback<BaseResponse<String>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {

                    }

                    @Override
                    public void onFailure(Call<BaseResponse<String>> call, Throwable t) {

                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
