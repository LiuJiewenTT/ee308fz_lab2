package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class icon_viewfull_fgActivity extends AppCompatActivity {

    private ImageView iv_fangda_img;
    private String TAG = "icon_viewfull_fgActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.icon_viewfull);
        iv_fangda_img = findViewById(R.id.iv_fangda_img);

//        Log.d(TAG, "onCreate: " + iv_fangda_img.getTransitionName());
        iv_fangda_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 注意这里不使用finish
                ActivityCompat.finishAfterTransition(icon_viewfull_fgActivity.this);
            }
        });
    }
}
