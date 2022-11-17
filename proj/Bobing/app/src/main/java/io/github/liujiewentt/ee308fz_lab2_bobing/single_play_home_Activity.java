package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class single_play_home_Activity extends AppCompatActivity {

    private static final String TAG = "sgpa";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_play_home);

//        ActionBar actionBar = getSupportActionBar();
////        actionBar.hide();
////        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayShowTitleEnabled(false);
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                single_play_home_Activity.this.finish();
            }
        });

        Button btn = findViewById(R.id.sgm_go_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(single_play_home_Activity.this, play.class);
                Bundle bundle = new Bundle();
                bundle.putInt("number", 0);
                startActivityForResult(intent, 1, bundle);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        Log.d(TAG, "onActivityResult: " + bundle.getString("resv_s"));
//        findViewById(R.id.)
    }
}
