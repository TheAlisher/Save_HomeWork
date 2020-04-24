package com.example.save_homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText saveText;
    TextView listText;
    RecyclerView recyclerView;
    MainAdapter adapter;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);


        saveText = findViewById(R.id.ET_search);
        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        saveText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*listText = findViewById(R.id.list);
                listText.setText(s);*/
                s = s.toString().toLowerCase();
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i <list.size() ; i++) {
                    String text = list.get(i).toLowerCase();
                    if (text.contains(s)){
                        arrayList.add(list.get(i));
                    }
                }
                adapter.update(arrayList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        list = new ArrayList<>();
        Button save = findViewById(R.id.button_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = saveText.getText().toString();
                list.add(0, info);
                adapter.update(list);
            }
        });
    }
}


