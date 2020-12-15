package com.github.overcastan.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private TextView mainInfoTextView;
    private TextView dateTextView;
    private ImageView previewImageView;
    private CardView mainCardView;
    private long id;

    public DataViewHolder(
            final View itemView,
            final DataAdapter.Listener listener
    ) {
        super(itemView);
        mainInfoTextView = itemView.findViewById(R.id.mainInfoTextView);
        dateTextView = itemView.findViewById(R.id.date);
        previewImageView = itemView.findViewById(R.id.previewImage);
        mainCardView = itemView.findViewById(R.id.mainCard);
        mainCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (listener != null) {
                    listener.onCardClick(id);
                }
            }
        });
    }

    public void bind(final Data data) {
        mainInfoTextView.setText(data.getInfo());
        id = data.getId();
        dateTextView.setText(data.getDate());
        previewImageView.setImageResource(data.getImage());
    }
}
