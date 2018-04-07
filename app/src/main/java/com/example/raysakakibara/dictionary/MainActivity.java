package com.example.raysakakibara.dictionary;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    EditText wordEditText;
    EditText meanEditText;
    EditText searchWordEditText;

    HashMap<String, String> hashMap;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TreeSet<String> wordset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView1);
        wordEditText = (EditText) findViewById(R.id.word);
        meanEditText = (EditText) findViewById(R.id.mean);
        searchWordEditText = (EditText) findViewById(R.id.searchWord);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        this.hashMap = new HashMap<>();
        wordset = new TreeSet<String>();
        pref = getSharedPreferences("dictionary", MODE_PRIVATE);
        editor = pref.edit();

        editor.putString("technology", "科学技術");
        editor.putString("develop", "開発する");
        editor.commit();

        wordset.add("technology");
        wordset.add("develop");

        for (String word : wordset) {
            this.hashMap.put(word, pref.getString(word, null));

            adapter.add("【" + word + "】" + pref.getString(word, null));
        }
        listView.setAdapter(adapter);

    }
}
