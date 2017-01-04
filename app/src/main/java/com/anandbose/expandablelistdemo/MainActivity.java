package com.anandbose.expandablelistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    Button buttonRefr;
    ExpandableListAdapter adapter;
    List<ListItem> data = new ArrayList<>();

    List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        buttonRefr = (Button) findViewById(R.id.buttonRefr);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getItemViewType(position) == ExpandableListAdapter.HEADER) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recyclerview.setLayoutManager(manager);

        initData();

        adapter = new ExpandableListAdapter(data);
        recyclerview.setAdapter(adapter);

        buttonRefr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                adapter.setData(data);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void initData() {
        Word w1 = new Word("Apple");
        Word w2 = new Word("Orange");
        Word w3 = new Word("Banana");
        Word w4 = new Word("Peach");
        Word w5 = new Word("Strawberry");
        Word w6 = new Word("Pineapple");
        List<Word> fruits = new ArrayList<>(Arrays.asList(w1, w2, w3, w4, w5, w6));

        Word w7 = new Word("Father");
        Word w8 = new Word("Mother");
        Word w9 = new Word("Brother");
        Word w10 = new Word("Sister");
        Word w11 = new Word("Son");
        Word w12 = new Word("Cousin");
        Word w13 = new Word("Daughter");
        List<Word> family = new ArrayList<>(Arrays.asList(w7, w8, w9, w10, w11, w12, w13));

        Word w14 = new Word("Audi");
        Word w15 = new Word("AstonMartin");
        Word w16 = new Word("BMW");
        Word w17 = new Word("Cadillac");
        List<Word> cars = new ArrayList<>(Arrays.asList(w14, w15, w16, w17));

        Word w18 = new Word("Nikolaev");
        Word w19 = new Word("Odessa");
        Word w20 = new Word("Kiev");
        Word w21 = new Word("Lvov");
        Word w22 = new Word("Kherson");
        List<Word> cities = new ArrayList<>(Arrays.asList(w18, w19, w20, w21, w22));

        Category c1 = new Category("Fruits", fruits);
        Category c2 = new Category("Family", family);
        Category c3 = new Category("Cars", cars);
        Category c4 = new Category("Cities", cities);

        categories = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));

        data = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            ListItem item = new ListItem(ExpandableListAdapter.HEADER, categories.get(i).getTitle());
            item.invisibleChildren = new ArrayList<>();
            List<Word> words = categories.get(i).getWords();
            for (int j = 0; j < words.size(); j++) {
                ListItem subItem = new ListItem(ExpandableListAdapter.CHILD, words.get(j).getTitle());
                item.invisibleChildren.add(subItem);
            }
            data.add(item);
        }
    }
}
