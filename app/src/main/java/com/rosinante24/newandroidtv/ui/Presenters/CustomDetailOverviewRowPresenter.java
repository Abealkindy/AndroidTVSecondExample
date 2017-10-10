package com.rosinante24.newandroidtv.ui.Presenters;

import android.content.Context;
import android.support.v17.leanback.widget.DetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;

import com.rosinante24.newandroidtv.R;

/**
 * Created by Rosinante24 on 10/10/17.
 */

public class CustomDetailOverviewRowPresenter extends DetailsOverviewRowPresenter {
    private static final String TAG = CustomDetailOverviewRowPresenter.class.getSimpleName();

    private Context mContext;

    public CustomDetailOverviewRowPresenter(Presenter presenter, Context context) {
        super(presenter);
        mContext = context;
    }

    @Override
    protected void onRowViewAttachedToWindow(RowPresenter.ViewHolder vh) {
        Log.v(TAG, "onRowViewAttachedToWindow");
        super.onRowViewAttachedToWindow(vh);
    }

    @Override
    protected void onBindRowViewHolder(RowPresenter.ViewHolder holder, Object item) {
        Log.v(TAG, "onBindRowViewHolder");
        setBackgroundColor(mContext.getResources().getColor(R.color.default_background));
        setStyleLarge(true);
        // It must be called "after" above function call
        super.onBindRowViewHolder(holder, item);
    }

    @Override
    protected void onRowViewExpanded(RowPresenter.ViewHolder vh, boolean expanded) {
        Log.v(TAG, "onRowViewExpanded");
        super.onRowViewExpanded(vh, expanded);
    }
}
