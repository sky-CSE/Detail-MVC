package com.example.detail_mvc;


import static com.example.detail_mvc.MainActivity.hashMap;
import static com.example.detail_mvc.MainActivity.nameList;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.FrameLayout;

public class DetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private Button enterDetails;
    private FrameLayout frameLayout;

    public void showFragment() {
        MoreDetailsFragment fragment = new MoreDetailsFragment();
        fragment.show(getSupportFragmentManager(),"Dialog Fragment");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        enterDetails = findViewById(R.id.details_button_enterDetail);
        frameLayout = findViewById(R.id.details_frame);

        recyclerView = findViewById(R.id.details_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

//        Intent i = getIntent();
//        nameList = i.getStringArrayListExtra("nameList");

        adapter = new RecyclerAdapter(hashMap, nameList, DetailsActivity.this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        enterDetails.setOnClickListener(view -> finish());
    }

}