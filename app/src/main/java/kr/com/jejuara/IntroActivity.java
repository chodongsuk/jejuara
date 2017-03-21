package kr.com.jejuara;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016-11-08.
 */
public class IntroActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);
        mHandler.postDelayed(mMyTask, 3000); // 3초후에 실행
    }


    private Runnable mMyTask = new Runnable() {
        @Override
        public void run() {
            OnNext();
        }
    };


    public void OnNext(){
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
        finish();
    }
}
