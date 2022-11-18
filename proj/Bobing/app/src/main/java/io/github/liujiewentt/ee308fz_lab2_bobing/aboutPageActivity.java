package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.app.UiModeManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

public class aboutPageActivity extends AppCompatActivity {

    private static final String TAG = "abp";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutpage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.abp_tb);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutPageActivity.this.finish();
            }
        });

        // not able to introduce daynight mode
//        AppCompatDelegate acd = getDelegate();
//        int i = acd.getDefaultNightMode();
////        int i = acd.getLocalNightMode();
//        Log.d(TAG, "onCreate: i-" + i);


        ImageView iv1 = findViewById(R.id.abp_iv1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = (int)(Math.random()*6) + 1;
                switch (i){
                    case 1:
                        iv1.setImageResource(R.drawable.a8);
                        break;
                    case 2:
                        iv1.setImageResource(R.drawable.a6);
                        break;
                    case 3:
                        iv1.setImageResource(R.drawable.a17);
                        break;
                    case 4:
                        iv1.setImageResource(R.drawable.a10);
                        break;
                    case 5:{
                        int j = (int)(Math.random()*6) + 1;
                        switch (j){
                            case 1:
                                iv1.setImageResource(R.drawable.dv1);
                                break;
                            case 2:
                                iv1.setImageResource(R.drawable.dv2);
                                break;
                            case 3:
                                iv1.setImageResource(R.drawable.dv3);
                                break;
                            case 4:
                                iv1.setImageResource(R.drawable.dv4);
                                break;
                            case 5:
                                iv1.setImageResource(R.drawable.dv5);
                                break;
                            case 6:
                                iv1.setImageResource(R.drawable.dv6);
                                break;
                        }
                        break;
                    }
                    case 6:
                        iv1.setImageResource(R.drawable.a15);
                        break;
                }

            }
        });



    }

//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        int currentNightMode = newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK;
//        ImageView iv = findViewById(R.id.abp_iv1);
//        switch (currentNightMode) {
//            case Configuration.UI_MODE_NIGHT_NO:
//                // Night mode is not active, we're using the light theme
//                Log.i(TAG, "onConfigurationChanged: light");
//                iv.setImageResource(R.drawable.a8);
//                break;
//            case Configuration.UI_MODE_NIGHT_YES:
//                // Night mode is active, we're using dark theme
//                Log.i(TAG, "onConfigurationChanged: dark");
//                iv.setImageResource(R.drawable.a6);
//                break;
//            default:
//                break;
//        }
//    }


//    @Override
//    protected void onNightModeChanged(int mode) {
//        super.onNightModeChanged(mode);
//        Log.d(TAG, "onNightModeChanged: mode");
//    }
}
