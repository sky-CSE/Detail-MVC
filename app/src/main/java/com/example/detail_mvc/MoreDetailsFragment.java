package com.example.detail_mvc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MoreDetailsFragment extends DialogFragment {
    protected TextView name, phone, address, birthday, email;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_more_details,container,false);

        // Inflate the layout for this fragment
        name = view.findViewById(R.id.fragment_name);
        phone = view.findViewById(R.id.fragment_phone);
        address = view.findViewById(R.id.fragment_address);
        birthday = view.findViewById(R.id.fragment_bday);
        email = view.findViewById(R.id.fragment_email);

        return view;
    }


}