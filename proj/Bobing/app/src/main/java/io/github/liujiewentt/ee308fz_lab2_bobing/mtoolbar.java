package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.translation.ViewTranslationRequest;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.function.Consumer;

public class mtoolbar extends Toolbar {

    RelativeLayout rlt;
    ImageButton imgbtn;
    TextView tv;
    String name;

    public mtoolbar(Context context) {
        super(context);
        rlt = new RelativeLayout(context);
        imgbtn = new ImageButton(context);
        tv = new TextView(context);
        name = this.getTitle().toString();
        initViewArgs(context);
        rlt.addView(imgbtn);
        rlt.addView(tv);
        this.addView(rlt);
//        ((AppCompatActivity)context).getSupportActionBar
//        ((ActionBar)((Toolbar)this)).setDisplayShowTitleEnabled(false);
    }

    public mtoolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public mtoolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onCreateViewTranslationRequest(@NonNull int[] supportedFormats, @NonNull Consumer<ViewTranslationRequest> requestsCollector) {
        super.onCreateViewTranslationRequest(supportedFormats, requestsCollector);

    }



    public void initViewArgs(Context context){
        LayoutParams ltparams;
        RelativeLayout.LayoutParams rltparams;
//        ltparams = (LayoutParams) rlt.getLayoutParams();
//        ltparams.width = ltparams.MATCH_PARENT;
//        ltparams.height = ltparams.WRAP_CONTENT;
//        rlt.setLayoutParams(ltparams);
//        ltparams.width = ltparams.WRAP_CONTENT;
//        imgbtn.setLayoutParams(ltparams);
//        ltparams.height = ltparams.MATCH_PARENT;
//        tv.setLayoutParams(ltparams);
//        rlt.setBackgroundColor(getResources().getColor(R.color.golden));

        // For my Toolbar
        ltparams = (LayoutParams) this.getLayoutParams();
        ltparams.width = ltparams.MATCH_PARENT;
        int[] tl = {R.attr.actionBarSize};
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(tl);
        ltparams.height = (int) typedArray.getDimension(0,0);
        this.setLayoutParams(ltparams);

        // For RelativeLayout
        // width, height
        ltparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        rlt.setLayoutParams(ltparams);

        // For ImageButton
        rltparams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rltparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        rltparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        rltparams.addRule(RelativeLayout.CENTER_VERTICAL);
        imgbtn.setLayoutParams(rltparams);
        imgbtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24));
        imgbtn.setBackgroundColor(getResources().getColor(R.color.transparent_white));

        // For TextView
        rltparams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rltparams.addRule(RelativeLayout.CENTER_IN_PARENT);

//        rltparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        rltparams.addRule(RelativeLayout.CENTER_VERTICAL);
//        ((RelativeLayout.LayoutParams)tv.getLayoutParams()).alignWithParent = Gravity.CENTER;
        tv.setLayoutParams(rltparams);
        tv.setGravity(Gravity.CENTER);
//        ((RelativeLayout)tv).setGravity(Gravity.CENTER);
        // incorrect
//        tv.setGravity(Gravity.CENTER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv.setTextAlignment(tv.TEXT_ALIGNMENT_CENTER);
        }
        tv.setTextColor(getResources().getColor(R.color.white));
//        tv.setForegroundGravity(Gravity.CENTER);

//        int[] tl = {R.attr.textAllCaps, R.attr.gra}
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setText(name);
    }

    @Override
    public void setTitle(CharSequence title) {
        name = (String) title;
        tv.setText(name);
    }

    @Override
    public void setTitle(int resId) {
        @SuppressLint("ResourceType") TextView ttv = findViewById(resId);
        tv.setText(ttv.getText());
    }
}
