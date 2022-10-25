package com.example.detail_mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText name, phone, address, birthday, email;
    private Button submit, seeDetais;

    //database
    private final HashMap<String,Employee> hashMap = new HashMap<>();
    public static ArrayList<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.main_editText_name);
        phone = findViewById(R.id.main_editText_phone);
        address = findViewById(R.id.main_editText_address);
        birthday = findViewById(R.id.main_editText_bday);
        email = findViewById(R.id.main_editText_email);

        submit = findViewById(R.id.main_button_submit);
        seeDetais = findViewById(R.id.main_button_seeDetails);
    }

    @Override
    protected void onResume() {
        super.onResume();

        submit.setOnClickListener(view -> {
            if(!nameList.isEmpty() && hashMap.containsKey(name.getText().toString())){
                Toast.makeText(MainActivity.this,"Error: Duplicate Name",Toast.LENGTH_LONG).show();
                return;
            }

            if(check(name) &&
                    check(phone) &&
                    check(address) &&
                    check(birthday) &&
                    check(email)
            ){
                Employee employee = new Employee(name.getText().toString(),
                                                phone.getText().toString(),
                                                address.getText().toString(),
                                                birthday.getText().toString(),
                                                email.getText().toString()
                                                );

                Toast.makeText(getApplicationContext(),"Data saved",Toast.LENGTH_LONG).show();
                nameList.add(employee.getName());
                hashMap.put(employee.getName(),employee);
            }

        });

        seeDetais.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,DetailsActivity.class);
            i.putExtra("hashMap",hashMap);
            i.putStringArrayListExtra("nameList",nameList);
            startActivity(i);
//                finish();
        });
    }

    private boolean check(EditText editText){
        if(editText.getText().toString().replaceAll("\\s", "").isEmpty()){
            Toast.makeText(MainActivity.this,editText.getHint() + " cannot be empty",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
        //true -- correct state, false-- wrong state
    }

}