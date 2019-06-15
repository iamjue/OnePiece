package com.iamjue.onepiece;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Onepiece> list = new ArrayList<>();
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);


        list.addAll(DataOnepiece.getListData());
        showRecyclerList();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    private void showSelectedOnepiece(Onepiece onepiece) {
        Toast.makeText(this, "Kamu memilih " + onepiece.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        String data = onepiece.getName();
        String data2 = onepiece.getNickname();
        String data3 = onepiece.getBounty();
        String data4 = onepiece.getPhoto();
        String data5 = onepiece.getDesc();

        intent.putExtra(DetailActivity.EXTRA_NAME, data);
        intent.putExtra(DetailActivity.EXTRA_NICKNAME, data2);
        intent.putExtra(DetailActivity.EXTRA_BOUNTY, data3);
        intent.putExtra(DetailActivity.EXTRA_PHOTO, data4);
        intent.putExtra(DetailActivity.EXTRA_DESC, data5);
        startActivity(intent);


    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListOnepieceAdapter listOnepieceAdapter = new ListOnepieceAdapter(this);
        listOnepieceAdapter.setListOnepiece(list);
        rvCategory.setAdapter(listOnepieceAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedOnepiece(list.get(position));
            }
        });
    }

    private void showrecyclerGird() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GirdOnepieceAdapter girdOnepieceAdapter = new GirdOnepieceAdapter(this);
        girdOnepieceAdapter.setGirdOnepiece(list);
        rvCategory.setAdapter(girdOnepieceAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedOnepiece(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        final ArrayList<Onepiece> one = new ArrayList<Onepiece>();
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewOnepieceAdapter cardViewOnepieceAdapter = new CardViewOnepieceAdapter(this);
        cardViewOnepieceAdapter.setListOnepiece(list);
        rvCategory.setAdapter(cardViewOnepieceAdapter);


    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        String title = null;
        switch (itemId) {
            case R.id.action_list:
                showRecyclerList();
                title = "Mode List";
                break;
            case R.id.action_gird:
                showrecyclerGird();
                title = "Mode Grid";
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                title = "Mode CardView";
                break;
        }
        mode = itemId;
        setActionBarTitle(title);
    }
}
