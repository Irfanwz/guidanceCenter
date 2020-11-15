package com.example.ssuet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Notifications extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout=findViewById(R.id.drawer_layout);

        myWebView=(WebView)findViewById(R.id.webView);
        WebSettings webSettings=myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://guidancecenter.000webhostapp.com/notification.html");
        myWebView.setWebViewClient(new WebViewClient());
    }
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }
    public void ClickMenu(View view) {
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickDashboard(View view){
        MainActivity.redirectActivity(this,Dashboard.class);
    }
public void ClickNotifications(View view){recreate();}
    public void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,AboutUs.class);

    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}