package com.github.overcastan.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String ID_KEY = "ID_KEY";

    public static Intent getIntent(final Context context, final long id) {
        final Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(ID_KEY, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final long id = getIntent().getLongExtra(ID_KEY, -1);
        final Data data = DataRepository.getDataById(id);

        final TextView infoTextView = findViewById(R.id.mainInfoTextView);
        infoTextView.setText(data.getInfo());
        final ImageView imageView = findViewById(R.id.mainImage);
        imageView.setImageResource(data.getImage());
    }
}
