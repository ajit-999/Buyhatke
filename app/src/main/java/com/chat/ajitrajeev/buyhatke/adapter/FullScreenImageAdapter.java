package com.chat.ajitrajeev.buyhatke.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.chat.ajitrajeev.buyhatke.R;
import com.chat.ajitrajeev.buyhatke.helper.TouchImageView;

import java.util.ArrayList;

/**
 * Created by ajit on 30/10/17.
 */


public class FullScreenImageAdapter extends PagerAdapter {

    private Activity _activity;
    private ArrayList<Integer> _imagePaths;
    private LayoutInflater inflater;

    // constructor
    public FullScreenImageAdapter(Activity activity,
                                  ArrayList<Integer> imagePaths) {
        this._activity = activity;
        this._imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return this._imagePaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TouchImageView imgDisplay;
        Button btnClose;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
                false);

        imgDisplay = (TouchImageView) viewLayout.findViewById(R.id.imgDisplay);
        btnClose = (Button) viewLayout.findViewById(R.id.btnClose);

       BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
      /* Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position), options);
 Bitmap bitmap = BitmapFactory.decodeResource(_activity.getResources(),_activity.getResources().
                getIdentifier("imag1","drawable",_activity.getCallingPackage()));*/


         Bitmap bitmap = BitmapFactory.decodeResource(_activity.getResources(),_imagePaths.get(position) );
        Log.d("ImagePath",_imagePaths.get(position)+"");
         imgDisplay.setImageBitmap(bitmap);

        // close button click event
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _activity.finish();
            }
        });

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

}

