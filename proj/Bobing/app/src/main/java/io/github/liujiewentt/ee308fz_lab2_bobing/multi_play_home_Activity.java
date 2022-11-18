package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Arrays;

public class multi_play_home_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_play_home);

//        mtoolbar mulp_mtb = findViewById(R.id.mulp_tb);

//        mulp_mtb.setTitle(R.string.multiplayer_mode);

        Toolbar toolbar = findViewById(R.id.mulp_tb);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multi_play_home_Activity.this.finish();
            }
        });

        SeekBar seekBar = findViewById(R.id.mulp_seekBar);

        TextView tv = findViewById(R.id.mulp_hplayernb_tv);
        tv.setText(""+seekBar.getProgress());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar.setMin(2);
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView tv = findViewById(R.id.mulp_hplayernb_tv);
                if(i<1){
                    seekBar.setProgress(2);
                    i = 2;
                }
                tv.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                return;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                return;
            }
        });

        Button btn = findViewById(R.id.mulp_hnextp_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(multi_play_home_Activity.this, multi_play_hall_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("numlimit", seekBar.getProgress());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
