package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class WebViewActivity extends Activity {

    /* renamed from: f, reason: collision with root package name */
    WebView f3461f;

    /* renamed from: c, reason: collision with root package name */
    private final BroadcastReceiver f3459c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final WebViewClient f3460d = new b();

    /* renamed from: g, reason: collision with root package name */
    private final IntentFilter f3462g = new IntentFilter("close action");

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("close action".equals(intent.getAction())) {
                WebViewActivity.this.finish();
            }
        }
    }

    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return false;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    class c extends WebChromeClient {

        class a extends WebViewClient {
            a() {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                WebViewActivity.this.f3461f.loadUrl(webResourceRequest.getUrl().toString());
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                WebViewActivity.this.f3461f.loadUrl(str);
                return true;
            }
        }

        c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z3, boolean z4, Message message) {
            a aVar = new a();
            WebView webView2 = new WebView(WebViewActivity.this.f3461f.getContext());
            webView2.setWebViewClient(aVar);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }

    public static Intent a(Context context, String str, boolean z3, boolean z4, Bundle bundle) {
        return new Intent(context, (Class<?>) WebViewActivity.class).putExtra(ImagesContract.URL, str).putExtra("enableJavaScript", z3).putExtra("enableDomStorage", z4).putExtra("com.android.browser.headers", bundle);
    }

    public static Map<String, String> b(Bundle bundle) {
        if (bundle == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f3461f = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(ImagesContract.URL);
        boolean booleanExtra = intent.getBooleanExtra("enableJavaScript", false);
        boolean booleanExtra2 = intent.getBooleanExtra("enableDomStorage", false);
        this.f3461f.loadUrl(stringExtra, b(intent.getBundleExtra("com.android.browser.headers")));
        this.f3461f.getSettings().setJavaScriptEnabled(booleanExtra);
        this.f3461f.getSettings().setDomStorageEnabled(booleanExtra2);
        this.f3461f.setWebViewClient(this.f3460d);
        this.f3461f.getSettings().setSupportMultipleWindows(true);
        this.f3461f.setWebChromeClient(new c());
        androidx.core.content.a.registerReceiver(this, this.f3459c, this.f3462g, 2);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f3459c);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4 || !this.f3461f.canGoBack()) {
            return super.onKeyDown(i3, keyEvent);
        }
        this.f3461f.goBack();
        return true;
    }
}
