package com.rosinante24.newandroidtv.ui.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

import com.rosinante24.newandroidtv.R;
import com.rosinante24.newandroidtv.common.PlayBackController;
import com.rosinante24.newandroidtv.model.Movie;

/**
 * Created by Rosinante24 on 10/10/17.
 */

public class PlayBackOverlayActivity extends Activity {
    private static final String TAG = PlayBackOverlayActivity.class.getSimpleName();

    private VideoView mVideoView;
    private PlayBackController mPlaybackController;

    private Movie mSelectedMovie;
    String mCategoryName;
    //private int mCurrentItem;

    public PlayBackController getPlaybackController() {
        return mPlaybackController;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);


        mSelectedMovie = getIntent().getParcelableExtra(DetailsActivity.MOVIE);

        /* NOTE: setMediaController (in createMediaSession) must be executed
         * BEFORE inflating Fragment!
         * NOTE2: sMovieList in VideoProvider must be prepared before instantiating PlaybackController...
         */
        mPlaybackController = new PlayBackController(this);
        //mPlaybackController = new PlaybackController(this, currentItemIndex, VideoProvider.getMovieItems(mCategoryName));

        //mCurrentItem = 0;//(int) mSelectedMovie.getId() - 1;
        //mPlaybackController.setCurrentItem(mCurrentItem);

        setContentView(R.layout.activity_playback_overlay);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mPlaybackController.setVideoView(mVideoView);
        mPlaybackController.setMovie(mSelectedMovie); // it must after video view setting
        loadViews();
    }

    private void loadViews() {
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mVideoView.setFocusable(false);
        mVideoView.setFocusableInTouchMode(false);

        mPlaybackController.setVideoPath(mSelectedMovie.getVideoUrl());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlaybackController.finishPlayback();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_playback_overlay, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (!requestVisibleBehind(true)) {
            // Try to play behind launcher, but if it fails, stop playback.
            mPlaybackController.playPause(false);
        }
    }
}
