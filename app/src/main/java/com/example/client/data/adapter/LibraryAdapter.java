package com.example.client.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.client.R;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    private List<String> libraryItems;
    private final OnLibraryItemClickListener listener;

    public interface OnLibraryItemClickListener {
        void onLibraryItemClick(String itemName);
    }

    public LibraryAdapter(OnLibraryItemClickListener listener) {
        this.listener = listener;
    }

    public void updateData(List<String> items) {
        this.libraryItems = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_library, parent, false);
        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
        holder.bind(libraryItems.get(position));
    }

    @Override
    public int getItemCount() {
        return libraryItems != null ? libraryItems.size() : 0;
    }

    class LibraryViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemName;

        LibraryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.library_item_text);
        }

        void bind(final String name) {
            itemName.setText(name);
            itemView.setOnClickListener(v -> listener.onLibraryItemClick(name));
        }
    }
}
