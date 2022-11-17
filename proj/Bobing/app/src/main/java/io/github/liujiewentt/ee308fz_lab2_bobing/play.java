package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Arrays;

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

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
                Intent intent = pack();
                setResult(1, intent);
                play.this.finish();
            }
        });

        resv_i = new int[6];

        throwDices();

    }

    private Intent pack(){
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resv_s", resv_s);
        bundle.putIntArray("resv_i", resv_i);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    public void onBackPressed() {
        Intent intent = pack();
        setResult(1, intent);
        super.onBackPressed();
    }

    protected void throwDices(){
        int i;
        for( i=0; i<6; ++i){
            resv_i[i] = (int) (Math.random() * 6) + 1 ;
            Log.d(TAG, "throwDices: i" + i + ":" + resv_i[i]);
        }
        resv_s = judge(resv_i);
        Log.d(TAG, "throwDices: s:" + resv_s);
    }

    
    public String judge(int[] input){
        String str = "Not judged";
        if (input == null){
            input = this.resv_i;
        }
        Arrays.sort(input);
        for(int i=0; i<3; ++i){
            int j = input[i];
            input[i] = input[5-i];
            input[5-i] = j;
        }
        for(int i=0; i<6; ++i){
            Log.d(TAG, "throwDices: input" + i + ":" + input[i]);
        }
//        if(input[0] == 4 && input[5] == 4){
//            resv_s = getResources().getString(R.string.ZhuangYuan);
//        }
//        else if(input[0] == 1 && input[5] == 1){
//            resv_s = getResources().getString(R.string.ZhuangYuan);
//        }
//        else if(input[0] == 4 && input[3] == 4 && input[4] == 1){
//            resv_s = getResources().getString(R.string.ZhuangYuan);
//        }
//        else if()
        if(input[0] == input[4]){
            str = getResources().getString(R.string.ZhuangYuan);
        }
        else{
            int i;
            for ( i=0; i<6; ++i){
                if(input[i] == 4)
                    break;
            }
            if(i<2 && input[i] == 4 && input[i+3] == 4){
                str = getResources().getString(R.string.ZhuangYuan);
            }
            else if(i<3 && isBangYan(input)){
                str = getResources().getString(R.string.BangYan);
            }
            else if(i<4 && input[i] == 4 && input[i+2] == 4){
                str = getResources().getString(R.string.TanHua);
            }
            else if(i<5 && input[i] == 4 && input[i+1] == 4){
                str = getResources().getString(R.string.JuRen);
            }
            else if(i<6){
                str = getResources().getString(R.string.XiuCai);
            }
            else{
                str = getResources().getString(R.string.Nothing);
            }
        }
        return str;
    }

    public boolean isBangYan(int[] input){
        boolean flag = true;
        for(int i=0; i<6; ++i){
            flag = resv_i[i] > resv_i[i+1];
            if(!flag)
                break;
        }
        return flag;
    }

}
