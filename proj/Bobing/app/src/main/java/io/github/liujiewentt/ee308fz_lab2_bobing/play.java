package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class play extends AppCompatActivity {

    private static final String TAG = "play activity";
    int number = 0;
    int[] resv_i;
    String resv_s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playpage);

        Toolbar toolbar = findViewById(R.id.play_tb);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null){
            number = 0;
        }
        else{
            number = savedInstanceState.getInt("Number");
        }
        Log.d(TAG, "onCreate: number" + number);

        resv_i = new int[6];

    }


}
