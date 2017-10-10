package com.rosinante24.newandroidtv.ui.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rosinante24.newandroidtv.R;
import com.rosinante24.newandroidtv.ui.Fragments.ErrorFragment;

/**
 * Created by Rosinante24 on 10/10/17.
 */

public class ErrorActivity extends Activity {
    private static final String TAG = ErrorActivity.class.getSimpleName();

    private ErrorFragment mErrorFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testError();
    }

    private void testError() {
        mErrorFragment = new ErrorFragment();
        getFragmentManager().beginTransaction().add(R.id.main_browse_fragment, mErrorFragment).commit();
    }
}
