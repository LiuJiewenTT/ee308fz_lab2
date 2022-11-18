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

import java.util.Arrays;

public class multi_play_hall_Activity extends AppCompatActivity {

    private static final String TAG = "multiplayer hall";
    int number, numlimit;
    public String[] playerSymbol = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_play_hall);
        Bundle bundle = getIntent().getExtras();
        numlimit = bundle.getInt("numlimit");

        Toolbar toolbar = findViewById(R.id.mulphall_tb);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multi_play_hall_Activity.this.finish();
            }
        });

//        TextView tv;
//        tv = findViewById(R.id.mulp_hall_resShow_tv);

        number = 1;

        Button btn = findViewById(R.id.mulp_hnext_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(multi_play_hall_Activity.this, play.class);
                Bundle bundle = new Bundle();
                bundle.putInt("number", number);
                bundle.putString("playerSymbol", playerSymbol[number-1]);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        String resv_s, str1, str2;
        int[] resv_i;
        TextView tv;
        Log.d(TAG, "onActivityResult: " + bundle.getString("resv_s"));
        if(resultCode == 1){
            tv = findViewById(R.id.mulp_hall_resShow_tv);
            if(number == 1){
                tv.setText("Today is your lucky day\n");
            }
            resv_s = bundle.getString("resv_s");
            resv_i = bundle.getIntArray("resv_i");
            Log.d(TAG, "onActivityResult: " + requestCode + "-" + resultCode);
            str1 = resv_s + "\t" + Arrays.toString(resv_i) + "\n";
            str2 = String.valueOf(tv.getText());
            str2 = str2 + playerSymbol[number-1] + ": " + str1;
            tv.setText(str2);
            number++;
            if(number<=numlimit){
                tv = findViewById(R.id.mulp_hall_current_display_tv);
                tv.setText(getString(R.string.player) + " " + playerSymbol[number-1]);
            }
            else{
                Button btn = findViewById(R.id.mulp_hnext_btn);
                btn.setText(getString(R.string.gameover));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        multi_play_hall_Activity.this.finish();
                    }
                });
            }
        }
        else{
            Log.e(TAG, "onActivityResult: unexpected result code." + resultCode);
        }
    }
}
