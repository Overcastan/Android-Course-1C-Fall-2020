package com.github.overcastan.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

public class ListActivity extends AppCompatActivity implements DataAdapter.Listener {

    @Override
    public void onCardClick(final long id) {
        startActivity(DetailActivity.getIntent(this, id));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        final RecyclerView recyclerView = findViewById(R.id.dataRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 5);

        final DataAdapter adapter = new DataAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setDataList(DataRepository.getDataList());
        adapter.setListener(this);
    }
}