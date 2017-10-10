package com.rosinante24.newandroidtv.ui.Presenters;

import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;

/**
 * Created by Rosinante24 on 10/10/17.
 */

public class CustomFullWidthDetailsOverviewRowPresenter extends FullWidthDetailsOverviewRowPresenter {
    private static final String TAG = CustomFullWidthDetailsOverviewRowPresenter.class.getSimpleName();

    public CustomFullWidthDetailsOverviewRowPresenter(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected void onRowViewAttachedToWindow(RowPresenter.ViewHolder vh) {
        Log.v(TAG, "onRowViewAttachedToWindow");
        super.onRowViewAttachedToWindow(vh);
    }

    @Override
    protected void onBindRowViewHolder(RowPresenter.ViewHolder holder, Object item) {
        Log.v(TAG, "onBindRowViewHolder");
        super.onBindRowViewHolder(holder, item);
    }

    @Override
    protected void onLayoutOverviewFrame(ViewHolder viewHolder, int oldState, boolean logoChanged) {
        Log.v(TAG, "onLayoutOverviewFrame");

        /* Please try selecting either one. */
        //setState(viewHolder, FullWidthDetailsOverviewRowPresenter.STATE_SMALL);
        //setState(viewHolder, FullWidthDetailsOverviewRowPresenter.STATE_FULL);
        setState(viewHolder, FullWidthDetailsOverviewRowPresenter.STATE_HALF);  // Default behavior

        super.onLayoutOverviewFrame(viewHolder, oldState, logoChanged);
    }
}
