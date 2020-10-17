package com.example.avjindersinghsekhon.minimaltodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.SearchView;


public class AllNotes extends AppCompatActivity {

    SearchView searchView;
    ListView listView;

    String[] note = new String[] {"Test1", "banana", "iphone12", "iphoneX", "iphoneXR", "iphone12 Pro Max",
            "Test7", "Test8", "Test9", "Test10", "Test11","apple", "Test13",};

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_notes);

        searchView = (SearchView) findViewById(R.id.search_view);
        listView = (ListView) findViewById(R.id.note_list);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, note);
        listView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                AllNotes.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                AllNotes.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

}