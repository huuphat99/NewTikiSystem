package com.system.newtikisystem.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.system.newtikisystem.HomeActivity;
import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.Advertisement;
import com.system.newtikisystem.entity.ImageSliderModel;
import com.system.newtikisystem.navigation_home;

import java.util.List;

public class ImageSliderAdapter extends SliderViewAdapter<SliderViewHolder> {

    Context context;
    List<Advertisement> imageSliderModelList;

    public ImageSliderAdapter(Context context, List<Advertisement> imageSliderModelList) {
        this.context = context;
        this.imageSliderModelList = imageSliderModelList;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        //viewHolder.sliderImageView.setImageResource(imageSliderModelList.get(position).getImage());
        Picasso.get().load(imageSliderModelList.get(position).getMediaUrl()).into(viewHolder.sliderImageView);
        int productId = imageSliderModelList.get(position).getProductId();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ProductDetailActivity.class);
                intent.putExtra("productId",productId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getCount() {
        return imageSliderModelList.size();
    }
}

class SliderViewHolder extends SliderViewAdapter.ViewHolder {
    ImageView sliderImageView;
    public SliderViewHolder(View itemView) {
        super(itemView);
        sliderImageView = itemView.findViewById(R.id.imageView);
    }
}
