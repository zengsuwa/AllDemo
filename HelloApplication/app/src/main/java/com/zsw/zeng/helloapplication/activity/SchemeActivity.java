package com.zsw.zeng.helloapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.zsw.zeng.helloapplication.R;

public class SchemeActivity extends AppCompatActivity {
    private static final String SCHEME_DOMAIN = "scheme_activity";
    private static final String TAG = SchemeActivity.class.getSimpleName();
    private TextView textView;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(Html.fromHtml("<a href='mqq://domain/path?params'>打开QQ</a>"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(Html.fromHtml("<a href='andy://scheme_activity?type=0&buffer=这是个字符串'>点我一下</a>"));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri uri = intent.getData();
        if (uri != null) {
            dispatchUri(uri);
        } else {
            Log.e(TAG, "Uri is null");
        }
    }

    private void dispatchUri(Uri uri) {
        try {
            final String domain = uri.getAuthority();
            if (TextUtils.equals(SCHEME_DOMAIN, domain)) {
                final String buffer = uri.getQueryParameter("buffer");
                final int type = Integer.valueOf(uri.getQueryParameter("type"));
                Toast.makeText(this, type + "  " + buffer, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e(TAG, "Uri Parse Error");
        }
    }
}
