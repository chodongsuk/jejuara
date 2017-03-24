package kr.com.jejuara;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016-11-08.
 */
public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler mHandler = new Handler();

    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;
    private ImageView mImageView5;
    private ImageView mImageView6;
    private ImageView mImageView7;
    private ImageView mImageView8;
    private ImageView mImageView9;
    private ImageView mImageView10;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);

        (mImageView1 = (ImageView)findViewById(R.id.imageView1)).setOnClickListener(this);
        (mImageView2 = (ImageView)findViewById(R.id.imageView2)).setOnClickListener(this);
        (mImageView3 = (ImageView)findViewById(R.id.imageView3)).setOnClickListener(this);
        (mImageView4 = (ImageView)findViewById(R.id.imageView4)).setOnClickListener(this);
        (mImageView5 = (ImageView)findViewById(R.id.imageView5)).setOnClickListener(this);
        (mImageView6 = (ImageView)findViewById(R.id.imageView6)).setOnClickListener(this);
        (mImageView7 = (ImageView)findViewById(R.id.imageView7)).setOnClickListener(this);
        (mImageView8 = (ImageView)findViewById(R.id.imageView8)).setOnClickListener(this);
        (mImageView9 = (ImageView)findViewById(R.id.imageView9)).setOnClickListener(this);
        (mImageView10 = (ImageView)findViewById(R.id.imageView10)).setOnClickListener(this);

    }


    public void OnNext(int i){
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("position", i);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView1:
                OnNext(1);
                break;
            case R.id.imageView2:
                OnNext(2);
                break;
            case R.id.imageView3:
                OnNext(3);
                break;
            case R.id.imageView4:
                OnNext(4);
                break;
            case R.id.imageView5:
                OnNext(5);
                break;
            case R.id.imageView6:
                OnNext(6);
                break;
            case R.id.imageView7:
                OnNext(7);
                break;
            case R.id.imageView8:
                OnNext(8);
                break;
            case R.id.imageView9:
                OnNext(9);
                break;
            case R.id.imageView10:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(getResources().getString(R.string.app_name))
                        .setMessage("어플을 종료 하시겠습니까?")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        })
                        .setNegativeButton("아니오", null)
                        .show();
                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(getResources().getString(R.string.app_name))
                    .setMessage("어플을 종료 하시겠습니까?")
                    .setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("아니오", null)
                    .show();


            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
