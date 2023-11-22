package com.example.latihanroom;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.latihanroom.model.NamaModel;

public class WordListAdapter extends ListAdapter<NamaModel, WordViewHolder> {

    public WordListAdapter(@NonNull DiffUtil.ItemCallback<NamaModel> diffCallback) {
        super(diffCallback);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        NamaModel current = getItem(position);
        holder.bind(current.nama);
    }

    static class WordDiff extends DiffUtil.ItemCallback<NamaModel> {

        @Override
        public boolean areItemsTheSame(@NonNull NamaModel oldItem, @NonNull NamaModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull NamaModel oldItem, @NonNull NamaModel newItem) {
            return oldItem.nama.equals(newItem.nama);
        }
    }
}

