package com.kirshi.framework.daemon;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:JobSchedulerService.java
 * @LastModified:2021/06/29 02:16:29
 */

/**
 * @author sunfusheng on 2018/8/1.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService {
    private static final String TAG = "---> JobService";
    private static final int JOB_ID = 10000;

    public static void scheduleJobService(Context context) {
        boolean isSuccess = false;
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, new ComponentName(context, JobSchedulerService.class));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setMinimumLatency(DaemonUtil.getIntervalTime());
            builder.setOverrideDeadline(DaemonUtil.getIntervalTime() * 2);
            builder.setBackoffCriteria(DaemonUtil.getIntervalTime(), JobInfo.BACKOFF_POLICY_LINEAR);
        } else {
            builder.setPeriodic(DaemonUtil.getIntervalTime());
        }
        builder.setPersisted(true);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        if (jobScheduler != null) {
            jobScheduler.cancelAll();
            isSuccess = jobScheduler.schedule(builder.build()) == JobScheduler.RESULT_SUCCESS;
        }
        if (isSuccess) {
            Log.d(TAG, "Scheduler Success!");
        } else {
            Log.e(TAG, "Scheduler Failed!");
        }
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "onStartJob()");
        DaemonHolder.startService();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "onStopJob()");
        DaemonHolder.startService();
        return false;
    }
}
