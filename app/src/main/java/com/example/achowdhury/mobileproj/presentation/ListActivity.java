package com.example.achowdhury.mobileproj.presentation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.achowdhury.mobileproj.R;
import com.example.achowdhury.mobileproj.model.Post;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ListActivity extends DaggerAppCompatActivity implements ListMVP.View {
    @Inject
    ListPresenter presenter;

    private ListAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.setView(this);

        adapter = new ListAdapter();
        recyclerView = findViewById(R.id.list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        if(savedInstanceState != null && savedInstanceState.getBoolean("state")) {
            presenter.onShowListPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(presenter.viewState == true) {
            outState.putBoolean("state", true);
        }
    }

    @Override
    public void showList(List<Post> postList) {
        adapter.setList(postList);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoad() {
        Toast.makeText(this, "Loading, would normally block UI", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFail() {
        Toast.makeText(this, "Failed to make Call", Toast.LENGTH_LONG).show();
    }

    public void onClickShowList(View view) {
        presenter.onShowListPressed();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter.dropView();
    }
}
