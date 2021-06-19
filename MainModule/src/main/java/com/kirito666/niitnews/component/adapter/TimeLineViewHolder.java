package com.kirito666.niitnews.component.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.vipulasri.timelineview.TimelineView;
import com.kirito666.niitnews.R;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:TimeLineViewHolder.java
 * @LastModified:2021/06/19 16:51:19
 */

/**
 * Created by HP-HP on 05-12-2015.
 */
public class TimeLineViewHolder extends RecyclerView.ViewHolder {

    TextView mDate;
    TextView mMessage;
    TimelineView mTimelineView;

    TimeLineViewHolder(View itemView, int viewType) {
        super(itemView);
        mDate = itemView.findViewById(R.id.text_timeline_date);
        mMessage = itemView.findViewById(R.id.text_timeline_title);
        mTimelineView = itemView.findViewById(R.id.time_marker);
        mTimelineView.initLine(viewType);
    }
}
