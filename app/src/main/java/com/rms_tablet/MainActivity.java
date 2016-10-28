package com.rms_tablet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class MainActivity extends Activity {
	private XWalkView xWalkView;
	private WebView mWebView;
	private String siteUrl = UrlAddress.url;
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
		xWalkView= (XWalkView) findViewById(R.id.webView);
		xWalkView.load("javascript:document.body.contentEditable=true;", null);
		xWalkView.addJavascriptInterface(new JsInterface(this), "gou");
		xWalkView.setUIClient(new XWalkUIClient(xWalkView));
		xWalkView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				return true;
			}
		});
		xWalkView.setResourceClient(new XWalkResourceClient(xWalkView){
			@Override
			public void onLoadFinished(XWalkView view, String url) {
				super.onLoadFinished(view, url);
			}
			@Override
			public void onLoadStarted(XWalkView view, String url) {
				super.onLoadStarted(view, url);
			}
		});
		if (getResources().getConfiguration().locale.getCountry().equals("CN")) {
			appLang = "chinese";
		} else if (getResources().getConfiguration().locale.getCountry()
				.equals("KR")) {
			appLang = "korean";
		} else {
			appLang = "english";
		}
		Log.d("TESTURL:", UrlAddress.url);

		xWalkView.load(UrlAddress.url + "tablet/?appLang=" + appLang,null);
	/*	mWebView = (WebView) findViewById(R.id.webView);
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
		
		
		mWebView.loadUrl(siteUrl + "?appLang=" + appLang);*/
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}
}
