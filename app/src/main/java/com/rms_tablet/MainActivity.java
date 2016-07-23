package com.rms_tablet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView mWebView;
	private String siteUrl = UrlAddress.url + "tablet/";
	private String appLang = "chinese";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		
		setContentView(R.layout.activity_main);
		
		startApp();
	}
	
	public void startApp(){
		mWebView = (WebView) findViewById(R.id.webView);
		WebSettings setting = mWebView.getSettings();
		setting.setJavaScriptEnabled(true);
		setting.setJavaScriptCanOpenWindowsAutomatically(true);
		mWebView.clearCache(true);
		mWebView.setWebChromeClient(new WebChromeClient());
		mWebView.setWebViewClient(new WebViewClient() {			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
		});	
		
		if (getResources().getConfiguration().locale.getCountry().equals("CN")){
			appLang = "chinese";
		}else if(getResources().getConfiguration().locale.getCountry().equals("KR")){
			appLang = "korean";
		}else{
			appLang = "english";
		}
		
		
		mWebView.loadUrl(siteUrl + "?appLang=" + appLang);
	}

}
