package com.kirito666.niitnews.ui.post_edit;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.recyclerview.widget.GridLayoutManager;

import com.kirito666.niitnews.R;
import com.kirito666.niitnews.databinding.PagePostEditBinding;
import com.kirito666.niitnews.entity.Post;
import com.kirito666.niitnews.entity.base.BaseResponse;
import com.kirito666.niitnews.entity.base.HttpStatusCode;
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
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.tools.ScreenUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PostEditPage.java
 * @LastModified:2021/06/29 23:24:29
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
                3, GridLayoutManager.VERTICAL, false);
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
                            uploadFile(media);
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
        mAdapter.setSelectMax(6);
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
                        PictureWindowAnimationStyle animationStyle = new PictureWindowAnimationStyle();
                        animationStyle.activityPreviewEnterAnimation = R.anim.picture_anim_up_in;
                        animationStyle.activityPreviewExitAnimation = R.anim.picture_anim_down_out;
                        PictureSelector.create(mContext)
                                .themeStyle(R.style.picture_default_style)
                                .setPictureWindowAnimationStyle(animationStyle)
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
                String postContent = v.postText.getText().toString();
                Post post = new Post();
                post.setText(postContent);
                List<String> pictures = new ArrayList<>();
                for (LocalMedia localMedia : mAdapter.getData()) {
                    if (!TextUtils.isEmpty(localMedia.ossUrl)) {
                        pictures.add(localMedia.ossUrl);
                    }
                }
                post.setAttachPic(pictures);
                post.setTitle(postContent);
                post.setAllowComment(v.postAllowCommit.isChecked());
                post.setAllowFeed(v.postAllowFeed.isChecked());
                RetrofitClient.getInstance().getApi().insertPost(post).enqueue(new Callback<BaseResponse<String>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                        if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                            showSnackBar("发布成功");
                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                mContext.finish();
                            }, 500);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<String>> call, Throwable t) {

                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void uploadFile(LocalMedia localMedia) {
        File file = new File(localMedia.getCutPath());
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("uploadFile", file.getName(), requestFile);
        RetrofitClient.getInstance().getApi().uploadOssFile(body).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                if (response.body().getStatusCode() == HttpStatusCode.SUCCESS.getStatus()) {
                    localMedia.ossUrl = response.body().getData();
                } else {
                    showSnackBar(response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                showSnackBar(t.toString());
            }
        });

    }

}
