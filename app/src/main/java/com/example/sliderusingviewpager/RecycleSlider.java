package com.example.sliderusingviewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class RecycleSlider extends RecyclerView.Adapter<RecycleSlider.SliderViewholder> {
    ArrayList<Integer> arrayList;
    ViewPager2 viewPager2;

    public RecycleSlider(ArrayList<Integer> arrayList){
        this.arrayList=arrayList;
        this.viewPager2=viewPager2;
    }

    @NonNull
    @Override
    public SliderViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.costume_swipe,parent,false);
        return new SliderViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewholder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position));
//        if(position==arrayList.size()-1){
//            viewPager2.post(runnable);
//
//        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class SliderViewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public SliderViewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);
        }
    }

//    Runnable runnable=new Runnable() {
//        @Override
//        public void run() {
//            arrayList.addAll(arrayList);
//            notifyDataSetChanged();
//        }
//    };
}
