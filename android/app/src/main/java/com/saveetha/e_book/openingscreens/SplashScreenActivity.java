package com.saveetha.e_book.openingscreens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.saveetha.e_book.Constant;
import com.saveetha.e_book.MainActivity;
import com.saveetha.e_book.R;
import com.saveetha.e_book.SF;
import com.saveetha.e_book.adminscreens.AdminDashboardActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 1000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sf = SF.getSignInSF(SplashScreenActivity.this);
                if(sf.getString(Constant.NAME_SI_SF,null)!=null){
                    startActivity(new Intent(SplashScreenActivity.this, AdminDashboardActivity.class));
                }else {
                    Intent intent = new Intent(SplashScreenActivity.this, SignInActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}