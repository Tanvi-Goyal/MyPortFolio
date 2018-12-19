package com.example.tanvi.myportfolio;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;
import com.hanks.htextview.fade.FadeTextView;

public class SplashScreen extends AppCompatActivity {

    private FadeTextView hTextView;
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        hTextView = findViewById(R.id.textView);
        hTextView.setAnimationListener(new SimpleAnimationListener(this));
        hTextView.animateText("Tanvi Goyal");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, ProfileActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    //Text Animator.
    class SimpleAnimationListener implements AnimationListener {
        private Context context;
        public SimpleAnimationListener(Context context) {
            this.context = context;
        }
        @Override
        public void onAnimationEnd(HTextView hTextView) {

        }
    }
}
