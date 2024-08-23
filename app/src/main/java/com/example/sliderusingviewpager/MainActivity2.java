package com.example.sliderusingviewpager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity2 extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<Integer> arrayList;
    RecycleSlider recycleSlider;
    //Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager2 = findViewById(R.id.viewpager2);
        arrayList = new ArrayList<>();
        recycleSlider = new RecycleSlider(arrayList);
        arrayList.add(R.drawable.image1);
        arrayList.add(R.drawable.iamge2);
        arrayList.add(R.drawable.image3);
        arrayList.add(R.drawable.image4);
        arrayList.add(R.drawable.iamge5);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.setAdapter(recycleSlider);
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                handler.removeCallbacks(sliderunnable);
//                handler.postDelayed(sliderunnable,2000);
//            }
//        });


    }

//        Runnable sliderunnable=new Runnable() {
//            @Override
//            public void run() {
//                viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
//            }
//        };
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        handler.removeCallbacks(sliderunnable);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        handler.postDelayed(sliderunnable,2000);
//    }



}