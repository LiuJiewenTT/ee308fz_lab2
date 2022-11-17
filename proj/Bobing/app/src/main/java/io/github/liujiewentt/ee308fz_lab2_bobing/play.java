package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("res_s", resv_s);
                bundle.putIntArray("resv_i", resv_i);
                intent.putExtra("bundle", bundle);
                setResult(1, intent);
            }
        });

        resv_i = new int[6];

        throwDices();

    }

    public void throwDices(){
        int i;
        for( i=0; i<6; ++i){
            resv_i[i] = (int) (Math.random() * 6) + 1 ;
            Log.d(TAG, "throwDices: i" + i);
        }
    }


}
