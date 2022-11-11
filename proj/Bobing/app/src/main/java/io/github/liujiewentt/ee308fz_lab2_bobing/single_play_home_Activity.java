package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class single_play_home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_play_home);

//        ActionBar actionBar = getSupportActionBar();
////        actionBar.hide();
////        actionBar.setDisplayHomeAsUpEnabled(true);
////        actionBar.setDisplayShowTitleEnabled(false);
////        actionBar.setHomeButtonEnabled(true);
////        actionBar.setDisplayShowHomeEnabled(true);
////        actionBar.setDisplayShowCustomEnabled(true);
////        actionBar.setDisplayShowHomeEnabled(true);
////        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_CUSTOM);
////        actionBar.
//
//        TextView tv_title = new TextView(this);
//        tv_title.setText(R.string.single_player_mode);
////        tv_title.setTextAppearance(this, R.style.TitleText);
//        tv_title.setTextColor(getResources().getColor(R.color.white));
////        tv_title.setAllCaps(false);
////        tv_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//        tv_title.setGravity(View.TEXT_ALIGNMENT_CENTER);
////        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setCustomView(tv_title);

//        Toolbar sgm_tb = findViewById(R.id.sgm_tb);
//        sgm_tb.set

        Toolbar toolbar = (Toolbar) findViewById(R.id.sgm_tb);
        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);



    }
}
