package com.example.detail_mvc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;


import java.util.ArrayList;
import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private Button enterDetails;

    private HashMap<String, Employee> hashMap;
    private ArrayList<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        enterDetails = findViewById(R.id.details_button_enterDetail);

        recyclerView = findViewById(R.id.details_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Intent i = getIntent();
        hashMap = (HashMap<String, Employee>) i.getSerializableExtra("hashMap");
        nameList = i.getStringArrayListExtra("nameList");

        adapter = new RecyclerAdapter(hashMap,nameList,DetailsActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        enterDetails.setOnClickListener(view -> {
              finish();
        });
    }
}