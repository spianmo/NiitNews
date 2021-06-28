package com.kirito666.niitnews.ui.single;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.kirito666.niitnews.component.adapter.TimeLineAdapter;
import com.kirito666.niitnews.component.model.OrderStatus;
import com.kirito666.niitnews.component.model.Orientation;
import com.kirito666.niitnews.component.model.TimeLineModel;
import com.kirito666.niitnews.databinding.PageTimelineBinding;
import com.kirshi.framework.viewbinding.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:TimeLinePage.java
 * @LastModified:2021/06/29 02:16:29
 */

public class TimeLinePage extends BaseActivity<PageTimelineBinding> {

    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(v.toolbar);
        v.toolbar.getBackground().setAlpha(255);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        v.recyclerView.setLayoutManager(getLinearLayoutManager());
        v.recyclerView.setHasFixedSize(true);

        initView();
    }

    private LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    private void initView() {
        setDataListItems();
        mTimeLineAdapter = new TimeLineAdapter(mDataList, Orientation.VERTICAL, false);
        v.recyclerView.setAdapter(mTimeLineAdapter);
    }

    private void setDataListItems() {
        mDataList.add(new TimeLineModel("alpha定版！完善邀请会话相关逻辑，增加会话分享相关逻辑修改JNI HTTP接口为线上服务器，优化各种用户体验，优化界面，友好提示，后端PeerTrunk优化HandShake机制，RestfulServer预留App启动页数据接口，公告接口，更新接口，md5防篡改接口等。", "2021-04-14 20:05", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("修改Protobuf协议，增加屏幕观看和触摸报文，增加屏幕转播推流，增加H265，H264编解码支持，被控端增加基于Accessible实现的多种手势重建模拟，基于GestureDetector实现多种手势识别，根据触摸轨迹的曲率标准差判断是否为Fling手势，应用Douglas–Peucker算法对轨迹点进行抽稀压缩。", "2021-04-13 22:24", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("ScreenLive VirtualDisplay实现横竖屏自动销毁Display实例重建MediaCodec编码器(持久化录屏权限)。ScreenLive测试Accessibility进行触摸的模拟，实现了TAP,LONGTAP,FLING,GUESTURES等触摸手势", "2021-04-13 08:27", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("完成选择协助选项页面，完善选择协助选项页面权限的定时刷新，并利用onPause和onResume实现前台后台被压栈时不刷新权限组(场景省流)，修复release版本中缺少通用HeaderInterceptor的问题。", "2021-04-12 02:42", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("规范版本号命名以及渠道号设置，增加关于页面和三方开源库开源许可页面，完成主页Toolbar溢出菜单各项item的点击事件，即将动工protobuf+连接池+握手+screenlive", "2021-04-12 12:39", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("协助连接对话框 定版，主页定版。增加生成不重复Vid的后端接口，完成创建协作会话的BottomPopup的非重复Vid。", "2021-04-11 08:27", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("完善currentUser生命周期的管理，修复DaemonService在安卓11上两处权限异常。解决Gson序列化java.sql.Timestamp的日期格式问题。为保活服务的Binder机制添加前台服务支持", "2021-04-11 12:28", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("增加JobSchedule服务以及核心Daemon服务，用于设备信息上传。完成AssitList会话列表设备在线状态的小圆点设计", "2021-04-10 15:21", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("增加Once开源库依赖，配合Alerter实现首次打开应用提示帮助，完成两种创建协助会话的UI以及代码实现，修改SDK版本为30(experimental)。设计完成Assist空视图以及协助会话连接Dialog布局", "2021-04-08 19:48", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("初步完成个人中心Fragment，处理了登出逻辑和缓存销毁。", "2021-04-07 12:32", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("优化登录持久化，协助会话列表功能完成。设计空白页EmptyView视图，采用Alerter作为强提醒SnackBar。后端Controller层协助会话列表接口与客户端打通", "2021-04-06 11:18", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("完成协助会话列表列表视图适配器，修改协助者协助会话DTO。优化RetrofitClient(增加GSON泛型和RXJAVA)。增加协助会话列表设备机型图标资源，23 icons。", "2021-04-06 16:32", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("完成Session机制，持久化SuperKey，在Retrofit中给所有请求添加header superkey和uid，完成Assist和Device相关Retrofit接口，抽象出统一的DtoCallback回调业务数据", "2021-04-06 14:21", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("SpringBoot后端完善了Superkey机制，配合拦截器以注解AOP的方式动态控制接口访问权限，增加检测Vid创建者和修改者的注解，优化设备表和协助会话表的结构，增加角色检测拦截器，完善设备restful和协助会话restful。", "2021-04-02 09:20", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("SpringBoot后端初步完善Invite、Device、Session的Dao层、Service层、Cntroller层，封装随机数类以生成随机UID和SuperKey，初步设计了Superkey机制，配合拦截器以注解AOP的方式动态控制接口访问权限，还需完善", "2021-04-01 20:03", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("进一步封装BaseActivity功能，减少子类重复代码，修复账号密码登录结果状态码不一致的问题，利用反射实现自动化创建基类Presenter子类的实例，将showSnackBar抽离封装到Presenter基类中，解决了输入框获取焦点时SnackBar被遮挡的BUG。增加了基类Activity当中反射处理无参Presenter构造器的情况。", "2021-03-30 12:35", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("完成注册登录，以及User数据的持久化，主页MainFrame初步设计完毕。优化ViewBinding封装，更改BaseActivity和BaseActivityCompat的继承关系", "2021-03-29 19:16", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("完成后端数据库表的设计。完成Splash页面、欢迎界面、注册登录页面布局V以及代码逻辑P/M的编写", "2021-03-29 17:12", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("增加若干矢量图片资源，精简了社会化登录库库里的非常用CPU架构.so，迁移了以往项目中常用的Component", "2021-03-29 19:06", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("Protocol模块当中添加Cmake支持，增加JNI层面的APK反破解机制(签名的HashCode、APK自身的MD5等等)", "2021-03-29 17:11", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("修复若干Activity和Fragment基类当中的小Bug，Presenter基类当中增加Log.e,Log.w的LiveTemplate", "2021-03-29 17:05", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("RetrofitClient增加CookieJar持久化和HTTPS支持", "2021-03-28 01:34", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("配置App Net的SecurityConfig部分，修改themes", "2021-03-28 01:10", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("设计核心Framework的Activity和Fragment的各基类，实现自动化ViewBinding，增加若干自定义视图组件", "2021-03-28 12:38", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("接入腾讯互联SDK，设计Freya图标为WindRose，初步应用名称定为FreyaLinker，定位安卓远程控制(屏幕操控、共享位置、实时音视频)", "2021-03-27 12:36", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("完成Retrofit请求框架以及检测XPosed的Protect组件", "2021-03-26 20:04", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("Hook Application类实现Activity栈生命周期管理", "2021-03-26 02:38", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("Freya框架设计MVP，Material UI,Protobuf等", "2021-03-22 12:06", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("FreyaLinker项目确立", "2021-03-22 09:37", OrderStatus.ACTIVE));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LOGE(item.toString());
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}