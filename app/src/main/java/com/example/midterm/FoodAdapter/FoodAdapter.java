package com.example.midterm.FoodAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midterm.FoodItem.FoodItem;
import com.example.midterm.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private final List<FoodItem> foodList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(FoodItem item);
    }

    public FoodAdapter(List<FoodItem> foodList, OnItemClickListener listener) {
        this.foodList = foodList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FoodItem item = foodList.get(position);
        holder.foodImageView.setImageResource(item.getImageResId());
        holder.foodNameTextView.setText(item.getName());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
        }
    }
}