package com.rosinante24.newandroidtv.ui.Presenters;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.rosinante24.newandroidtv.model.Movie;

/**
 * Created by Rosinante24 on 10/10/17.
 */

public class DetailsDesciptionPresenter extends AbstractDetailsDescriptionPresenter {
    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        Movie movie = (Movie) item;

        if (movie != null) {
            viewHolder.getTitle().setText(movie.getTitle());
            viewHolder.getSubtitle().setText(movie.getStudio());
            viewHolder.getBody().setText(movie.getDescription());
        }

    }
}
