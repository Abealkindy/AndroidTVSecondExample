package com.rosinante24.newandroidtv.ui.Presenters;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.rosinante24.newandroidtv.model.Movie;

/**
 * Created by Rosinante24 on 10/10/17.
 */

public class DescriptionPresenter extends AbstractDetailsDescriptionPresenter {
    private static final String TAG = DescriptionPresenter.class.getSimpleName();

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        viewHolder.getTitle().setText(((Movie) item).getTitle());
        viewHolder.getSubtitle().setText(((Movie) item).getStudio());
    }
}
