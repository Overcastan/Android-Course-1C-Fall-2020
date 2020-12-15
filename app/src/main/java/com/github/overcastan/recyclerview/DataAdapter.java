package com.github.overcastan.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    public interface Listener {
        void onCardClick(long id);
    }

    private List<Data> dataList = new ArrayList<>();
    private Listener listener;

    public void setListener(final Listener listener) {
        this.listener = listener;
    }

    public void setDataList(final List<Data> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(
                R.layout.activity_list_item,
                parent,
                false
        );
        Log.d("DataAdapter", "onCreateViewHolder");
        return new DataViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder holder, final int position) {
        holder.bind(dataList.get(position));
        Log.d("DataAdapter", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
