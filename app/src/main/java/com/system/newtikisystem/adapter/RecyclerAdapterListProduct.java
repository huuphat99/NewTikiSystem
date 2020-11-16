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
import com.system.newtikisystem.entity.ProductList;

import java.util.ArrayList;

public class RecyclerAdapterListProduct extends RecyclerView.Adapter<RecyclerAdapterListProduct.ViewHolder>  {

    ArrayList<ProductList> products;
    private OnViewProductDetailListener onViewProductDetailListener;

    public RecyclerAdapterListProduct(ArrayList<ProductList> products,OnViewProductDetailListener onViewProductDetailListener) {
        this.products = products;
        this.onViewProductDetailListener=onViewProductDetailListener;
    }

    @NonNull
    @Override
    public RecyclerAdapterListProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_item, parent, false);
        return new ViewHolder(view,onViewProductDetailListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterListProduct.ViewHolder holder, int position) {
        holder.lpName.setText(products.get(position).getName());
        holder.lpPrice.setText(Integer.toString(products.get(position).getPrice()));
        Picasso.get().load(products.get(position).getImageUrl()).into(holder.lpImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView lpImage;
        TextView lpName, lpPrice;
        OnViewProductDetailListener onViewProductDetailListener;
        public ViewHolder(@NonNull View itemView,OnViewProductDetailListener onViewProductDetailListener) {
            super(itemView);
            lpName = itemView.findViewById(R.id.lpName);
            lpPrice = itemView.findViewById(R.id.lpPrice);
            lpImage = itemView.findViewById(R.id.lpImageView);

            this.onViewProductDetailListener= onViewProductDetailListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onViewProductDetailListener.onProductClick(getAdapterPosition());
        }
    }
    public interface OnViewProductDetailListener {
        void onProductClick(int position);
    }
}
