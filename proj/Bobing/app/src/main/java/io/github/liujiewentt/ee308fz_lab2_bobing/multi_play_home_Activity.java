package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class multi_play_home_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_play_home);

        mtoolbar mulp_mtb = findViewById(R.id.mulp_tb);

//        mulp_mtb.setTitle(R.string.multiplayer_mode);
        setSupportActionBar(mulp_mtb);
    }
}
