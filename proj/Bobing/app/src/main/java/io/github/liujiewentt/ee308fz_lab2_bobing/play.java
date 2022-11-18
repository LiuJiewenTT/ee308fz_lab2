package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Arrays;

public class play extends AppCompatActivity {

    private static final String TAG = "play activity";
    int number = 0;
    int[] resv_i, resv_i_unsorted;
    String resv_s;
    public int[] diceID, diceV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playpage);

        Toolbar toolbar = findViewById(R.id.play_tb);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        Bundle bundle = getIntent().getExtras();

        if(bundle == null){
            number = 0;
        }
        else{
            number = bundle.getInt("number");
            if(number != 0){
                Log.d(TAG, "onCreate: number not 0: " + number);
                String playerSymbol = bundle.getString("playerSymbol");
                TextView tv = findViewById(R.id.play_title_tv);
                tv.setText(getString(R.string.playHeader)+" - "+playerSymbol);
            }
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
//        diceID = new int[6];
        diceID = new int[]{R.id.dice1, R.id.dice2, R.id.dice3, R.id.dice4, R.id.dice5, R.id.dice6};
        diceV = new int[]{R.drawable.dv1, R.drawable.dv2, R.drawable.dv3, R.drawable.dv4, R.drawable.dv5, R.drawable.dv6};

        throwDices();

        TextView tv1, tv2, tv3;
        tv1 = findViewById(R.id.hheader_tv);
        tv2 = findViewById(R.id.header_tv);
        tv3 = findViewById(R.id.dice_result_i_show_tv);
        if (resv_s == getString(R.string.Nothing)){
            tv1.setText(getString(R.string.comfort));
        }
        else{
            tv1.setText(getString(R.string.congratulations));
        }
        tv2.setText(resv_s);
        tv3.setText(Arrays.toString(resv_i));

        setPics();

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
        resv_i_unsorted = resv_i.clone();
//        for( i=0; i<6; ++i){
//            Log.d(TAG, "throwDices: i_un" + i + ":" + resv_i_unsorted[i]);
//        }
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

    protected void setPics(){
        int i, j;
        String str = "dv";
        ImageView iv;
        for( i=0, j=0; i<6; ++i){
            iv = findViewById(diceID[i]);
            iv.setImageDrawable(getResources().getDrawable(diceV[resv_i_unsorted[i]-1]));
        }
    }

}
