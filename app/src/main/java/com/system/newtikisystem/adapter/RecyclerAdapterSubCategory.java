package com.system.newtikisystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.Subcategories;

import java.util.ArrayList;

public class RecyclerAdapterSubCategory extends RecyclerView.Adapter<RecyclerAdapterSubCategory.ViewHolder> {

    ArrayList<Subcategories> subcategories;

    public RecyclerAdapterSubCategory(ArrayList<Subcategories> subcategories) {
        this.subcategories = subcategories;
    }

    @NonNull
    @Override
    public RecyclerAdapterSubCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_sub_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterSubCategory.ViewHolder holder, int position) {
        holder.textView.setText(subcategories.get(position).getName());
        Picasso.get().load(subcategories.get(position).getImageURL()).into(holder.imageLink);
    }

    @Override
    public int getItemCount() {
        return subcategories.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageLink;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textViewSubCategory);
            imageLink=itemView.findViewById(R.id.imageViewSubCategory);
        }
    }
}
