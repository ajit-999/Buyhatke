package com.chat.ajitrajeev.buyhatke.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.chat.ajitrajeev.buyhatke.R;
import com.chat.ajitrajeev.buyhatke.adapter.FullScreenImageAdapter;
import com.chat.ajitrajeev.buyhatke.helper.Utils;

import static com.facebook.FacebookSdk.getApplicationContext;

public class FullScreenViewActivity extends AppCompatActivity{

    private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view);

        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new Utils(getApplicationContext());

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        Toast.makeText(FullScreenViewActivity.this,"Full"+position,Toast.LENGTH_LONG).show();

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                utils.getFilePaths());

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);
    }
}
