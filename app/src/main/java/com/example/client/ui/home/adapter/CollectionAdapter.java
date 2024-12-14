package com.example.client.ui.home.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.data.model.Collection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder> {
    private final ArrayList<Collection> collections;
    private final OnCollectionClickListener listener; // Khai báo listener

    public CollectionAdapter(List<Collection> collectionList, OnCollectionClickListener listener) {
        this.collections = new ArrayList<>(collectionList);
        this.listener = listener; // Gán listener
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder holder, int position) {
        Collection currentCollection = collections.get(position);
        holder.bind(currentCollection);
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    class CollectionViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        private final LinearLayout layoutItem;

        public CollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textName);
            imageView = itemView.findViewById(R.id.image);
            layoutItem = itemView.findViewById(R.id.layoutItem);
        }

        public void bind(Collection collection) {
            textView.setText(collection.getDescription());

            Picasso.get()
                    .load(collection.getImage())
                    .placeholder(R.drawable.icon_user_gray)
                    .into(imageView);

            layoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Gọi phương thức trong listener
                    if (listener != null) {
                        listener.onCollectionClick(collection.get_id());
                    }
                }
            });
        }
    }

    public void updateData(List<Collection> collectionList) {
        collections.clear();
        collections.addAll(collectionList);
        notifyDataSetChanged();
    }

    // Định nghĩa interface ngay trong CollectionAdapter
    public interface OnCollectionClickListener {
        void onCollectionClick(String collectionId);
    }
}
