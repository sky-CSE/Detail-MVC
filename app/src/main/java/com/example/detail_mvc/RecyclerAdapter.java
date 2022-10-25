package com.example.detail_mvc;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.EmployeeViewHolder> {
    private HashMap<String, Employee> hashMap;
    private ArrayList<String> nameList;
    private Context context;

    public RecyclerAdapter(HashMap<String, Employee> hashMap, ArrayList<String> nameList, Context context) {
        this.hashMap = hashMap;
        this.nameList = nameList;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_design, viewGroup, false);

        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int position) {
        Employee employee = hashMap.get(nameList.get(position));

        employeeViewHolder.sno.setText(position);
        employeeViewHolder.name.setText(Objects.requireNonNull(employee).getName());
        employeeViewHolder.plus.setOnClickListener(view -> {
            //Open a fragment that shows all details of that employee wrt name
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private TextView sno;
        private TextView name;
        private Button plus;
        private CardView cardView;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_cardView); //incase delete is demanded

            sno = itemView.findViewById(R.id.card_text_sno);
            name = itemView.findViewById(R.id.card_text_name);
            plus = itemView.findViewById(R.id.card_button_plus);
        }

    }
}
