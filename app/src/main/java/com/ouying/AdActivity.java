package com.ouying;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdActivity extends AppCompatActivity {

    TextView ad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ad=findViewById(R.id.tv_ad);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=5;i>=0;i--){
                    SystemClock.sleep(1000);

                    final int oo=i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ad.setText("点击跳转"+oo);
                        }
                    });

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(AdActivity.this,MainActivity.class);
                        startActivity(intent);
                        fileList();
                    }
                });
            }
        }).start();








    }
}
