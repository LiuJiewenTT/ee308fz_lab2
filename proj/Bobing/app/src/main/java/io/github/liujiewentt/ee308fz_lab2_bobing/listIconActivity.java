package io.github.liujiewentt.ee308fz_lab2_bobing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.*;

public class listIconActivity extends AppCompatActivity {
    private RecyclerView rv_img;
    private TextView tv_img_msg;
    private String TAG = "listIconActivity";
    public List<ImgFile> iconList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.listicons);
        tv_img_msg = findViewById(R.id.tv_icon_msg);
        rv_img = findViewById(R.id.rv_icon);
        loadUI();
    }

    public void loadUI(){
        ImgFile img = new ImgFile();
        Resources resources = getResources();

        img.setFileName("c3");
        img.setFileSrc(resources.getDrawable(R.drawable.c3));
        iconList.add(img);
        img = new ImgFile();
        img.setFileName("c4");
        img.setFileSrc(resources.getDrawable(R.drawable.c4));
        iconList.add(img);
        img = new ImgFile();
        img.setFileName("c5");
        img.setFileSrc(resources.getDrawable(R.drawable.c5));
        iconList.add(img);

        if(iconList != null && iconList.size() > 0){
            GridLayoutManager layoutManager = new GridLayoutManager(listIconActivity.this,3);
            rv_img.setLayoutManager(layoutManager);
            imgAdapter adapter = new imgAdapter(iconList);
            rv_img.setAdapter(adapter);
        }else{
            tv_img_msg.setVisibility(View.VISIBLE);
        }
    }
    class imgAdapter extends RecyclerView.Adapter<imgAdapter.ViewHolder>{
        private String TAG="imgAdapter";

        private List<ImgFile> list;
        public imgAdapter(List<ImgFile> list){ this.list = list; }

        class ViewHolder extends RecyclerView.ViewHolder{
            View myView;
            TextView tv_name;
            ImageView iv_img;
            public ViewHolder(View itemView) {
                super(itemView);
                myView = itemView;
                tv_name = (TextView) itemView.findViewById(R.id.tv_name);
                iv_img = (ImageView)itemView.findViewById(R.id.iv_img);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(listIconActivity.this).inflate(R.layout.icon_item, parent, false);
            return new ViewHolder(v);
        }

        @SuppressLint("NewApi")
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ImgFile img = list.get(position);
//            holder.iv_img.setImageResource(R.drawable.ic_launcher_foreground);
            holder.iv_img.setImageDrawable(img.getFileSrc());
            Log.d(TAG, "onBindViewHolder: " + holder.iv_img.getTransitionName());
            holder.tv_name.setText(img.getFileName());
            holder.myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View ve) {
                    // It was starting another fullscreen activity
//                    Intent intent = new Intent(ve.getContext(), icon_viewfull_fgActivity.class);
//
////                    intent.putExtras(new Bundle().putSerializable("view",(Serializable) ve));
//                    ve.getContext().startActivity(
//                            intent,
//                            // 注意这里的sharedView
//                            // Content，View（动画作用view），String（和XML一样）
//                            ActivityOptions.makeSceneTransitionAnimation((Activity) ve.getContext(),
//                                    ve,"sharedView").toBundle()
//                    );

                    // Now set directly.
                    TextView textView = (TextView) ve.findViewById(R.id.tv_name);
                    setLauncherIcon("icon_"+ textView.getText());
                }
            });
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }
    }

    class ImgFile {
        private String fileName;
        private Drawable fileSrc;

        public ImgFile(){}

        public String getFileName() { return fileName; }

        public void setFileName(String fileName) { this.fileName = fileName; }

        public Drawable getFileSrc() { return fileSrc; }

        public void setFileSrc(Drawable fileSrc) { this.fileSrc = fileSrc; }
    }

    void setLauncherIcon(String aliasName){
        Log.d(TAG, "setLauncherIcon: " + aliasName);

        PackageManager packageManager = getPackageManager();

        // Disable all icon
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() + ".ScrollingActivity"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        for (int i=0; i<iconList.size(); ++i){
            String name = iconList.get(i).getFileName();
            packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() + ".icon_" + name), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        }

        // Enable select icon
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() + "." + aliasName), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

    }
}
