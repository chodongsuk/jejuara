package kr.com.jejuara;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

/**
 * Created by Administrator on 2016-03-21.
 */
public class WebActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;


    //웹뷰 관련
    private static final String TAG = "WebActivity";
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static final int FILECHOOSER_RESULTCODE = 2;
    public static final int INPUT_FILE_REQUEST_CODE = 1;
    public static final int AREA_RESULTCODE = 3;
    private WebView mWebView;
    private ProgressBar pb;
    private MyWebChromeClient mChromeClient;

    private int mPostion = 9;
    private String mUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mPostion = getIntent().getIntExtra("position",9);

        if(mPostion == 1){
            mUrl = Config.URL1;
        }else if(mPostion == 2){
            mUrl = Config.URL2;
        }else if(mPostion == 3){
            mUrl = Config.URL3;
        }else if(mPostion == 4){
            mUrl = Config.URL4;
        }else if(mPostion == 5){
            mUrl = Config.URL5;
        }else if(mPostion == 6){
            mUrl = Config.URL6;
        }else if(mPostion == 7){
            mUrl = Config.URL7;
        }else if(mPostion == 8){
            mUrl = Config.URL8;
        }else if(mPostion == 9){
            mUrl = Config.URL9;
        }else{
            mUrl = Config.URL9;
        }


        initViews();
        hideWebView();
        hideProgress();
        configureOfflineWebView(savedInstanceState);

    }

    private void initViews() {
        pb = (ProgressBar) findViewById(R.id.progress_bar);
        mWebView = (WebView) findViewById(R.id.webview);
    }

    private void configureOfflineWebView(Bundle savedInstanceState) {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setDomStorageEnabled(true);

// Set cache size to 8 mb by default. should be more than enough
        webSettings.setAppCacheMaxSize(1024 * 1024 * 8);

        String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        String userAgent = mWebView.getSettings().getUserAgentString();
        mChromeClient = new MyWebChromeClient(this);
        mWebView.setWebChromeClient(mChromeClient);
        mWebView.setWebViewClient(new OfflineWebViewClient(this));

        if (savedInstanceState == null) {
                loadURL(mUrl);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadURL(String url) {
        mWebView.loadUrl(url);
    }


    public void showProgress(){
        pb.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        pb.setVisibility(View.GONE);
    }

    public void showWebView(){
        mWebView.setVisibility(View.VISIBLE);
    }

    public void hideWebView(){
        mWebView.setVisibility(View.GONE);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }else{
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }


}
