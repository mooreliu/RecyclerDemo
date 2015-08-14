package com.example.mooreliu.recyclerdemo.ui;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mooreliu.recyclerdemo.R;

/**
 * Created by mooreliu on 2015/8/13.
 */
public class Page3Fragment  extends Fragment{

    View rootView;
    AnimationDrawable picAnimation;
    RatioImageView viewpager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_page3, container, false);
        initiew();
//        rootView.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e("Fragment3", "ACTION_DOWN");
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    //do something
//                    Log.e("Fragment3", "ACTION_DOWN");
//                    picAnimation.start();
//                }
//                return true;
//            }
//        });
        return rootView;
    }

    private void initiew() {
        viewpager = (RatioImageView) rootView.findViewById(R.id.anim_img);
        viewpager.setBackgroundResource(R.drawable.anim_page3fragment);
        viewpager.setScaleType(ImageView.ScaleType.FIT_XY);
        picAnimation = (AnimationDrawable) viewpager.getBackground();
        picAnimation.start();
        MainActivity.MyTouchListener myTouchListener = new MainActivity.MyTouchListener() {
            @Override
            public void onTouchEvent(MotionEvent event) {
                // 处理手势事件

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //do something
                    Log.e("Fragment3", "ACTION_DOWN");
                    picAnimation.start();
                   // viewpager.setImageDrawable(R.drawable.anim_page3fragment);
                }

            }
        };

        // 将myTouchListener注册到分发列表
        ((MainActivity)this.getActivity()).registerMyTouchListener(myTouchListener);

    }


}
