package com.iamwee.mvpstructure.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.iamwee.mvpstructure.R;

public class BaseActivity extends AppCompatActivity {

    private static final long DEFAULT_DELAY = 235;
    private boolean startingActivity = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }

    protected void openActivity(Intent intent) {
        openActivity(intent, false, DEFAULT_DELAY, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void openActivity(Intent intent, boolean isFinish) {
        openActivity(intent, isFinish, DEFAULT_DELAY, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void openActivity(Intent intent, long delay) {
        openActivity(intent, false, delay, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void openActivity(Intent intent, boolean isFinish, long delay) {
        openActivity(intent, isFinish, delay, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void openActivity(final Intent intent, final boolean isFinish,
                                long delay,
                                final int enterAnim,
                                final int exitAnim) {
        if (isStartingActivity()) return;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                if (isFinish) finish();
                overridePendingTransition(enterAnim, exitAnim);
                toggleStartingActivity();
            }
        }, delay);
        toggleStartingActivity();
    }

    protected void setupFragment(Bundle savedInstanceState) {

    }

    protected void setupToolbar() {

    }

    public boolean isStartingActivity() {
        return startingActivity;
    }

    public void toggleStartingActivity() {
        this.startingActivity = !this.startingActivity;
    }
}
