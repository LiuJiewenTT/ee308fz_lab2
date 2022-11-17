package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
    }
}
