package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class ScrollingActivity extends AppCompatActivity {

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Intent intent = new Intent(ScrollingActivity.this , rulePageActivity.class);
//                startActivity(intent);
                alertDialog.show();
            }
        });


        builder.setView(R.layout.alertdialog_showrule);
//        builder.setCancelable(true);
        alertDialog = builder.create();

        // for buttons in scrolling content
//        Button button_go_temp1 = findViewById(R.id.btn_gotemp1);
        Button button_go_single = findViewById(R.id.go_single);
        Button button_go_multi_home = findViewById(R.id.go_multi_home);
        Button button_go_rulepage = findViewById(R.id.go_rulepage);
        Button button_go_about = findViewById(R.id.go_about);
//        button_go_temp1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ScrollingActivity.this, temp1.class);
//                startActivity(intent);
//            }
//        });
        button_go_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this, single_play_home_Activity.class);
                startActivity(intent);
            }
        });
        button_go_multi_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this, multi_play_home_Activity.class);
                startActivity(intent);
            }
        });
        button_go_rulepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this, rulePageActivity.class);
                startActivity(intent);
            }
        });
        button_go_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this, aboutPageActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_showRules){
            alertDialog.show();
        }
        else if(id == R.id.action_showAbout){
            startActivity(new Intent(ScrollingActivity.this, aboutPageActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}