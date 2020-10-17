package com.example.avjindersinghsekhon.minimaltodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;

import java.util.ArrayList;

public class AddCategory extends AppCompatActivity {

    EditText et;
    Button bt;
    ListView lv;
    ListView lv1;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_category);

        et = (EditText) findViewById(R.id.etName1);
        bt = (Button) findViewById(R.id.button1);
        lv = (ListView) findViewById(R.id.lvNote1);
        lv1 = (ListView) findViewById(R.id.lvNote2);

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(AddCategory.this, android.R.layout.simple_list_item_1,
                arrayList);
        lv.setAdapter(adapter);

        String[] category = {"All notes", "Daily", "Work", "Receipt"};
        ListAdapter myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, category);
        lv1.setAdapter(myadapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i1 = new Intent(AddCategory.this, AllNotes.class);
                    startActivity(i1);
                }
                if (position == 1) {
                    Intent i2 = new Intent(AddCategory.this, MainActivity.class);
                    startActivity(i2);
                }
                if (position == 2) {
                    Intent i3 = new Intent(AddCategory.this, MainActivity.class);
                    startActivity(i3);
                }
                if (position == 3) {
                    Intent i4 = new Intent(AddCategory.this, MainActivity.class);
                    startActivity(i4);
                }
            }
        });

        onBtnClick();
    }

    public void onBtnClick() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = et.getText().toString();
                adapter.add(result);
                adapter.notifyDataSetChanged();
            }
        });
    }
}