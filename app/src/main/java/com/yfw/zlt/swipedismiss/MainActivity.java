package com.yfw.zlt.swipedismiss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yfw.zlt.swipedismiss.adapter.MyRecyclerAdapter;
import com.yfw.zlt.swipedismiss.view.SwipeDismissRecyclerViewTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final RecyclerView anotherRecyclerView = (RecyclerView) findViewById(R.id.recyclerHorizontalView);

        //管理recyclerview
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this);
        horizontalLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        anotherRecyclerView.setLayoutManager(horizontalLayoutManager);

        List list=new ArrayList();
        for(int i=0; i<100; i++){
            list.add("item"+i);
        }
        final MyRecyclerAdapter adapter=new MyRecyclerAdapter(list);

        recyclerView.setAdapter(adapter);
        anotherRecyclerView.setAdapter(adapter);

        // Bind touch listener
        SwipeDismissRecyclerViewTouchListener listener = new SwipeDismissRecyclerViewTouchListener.Builder(recyclerView, new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
            @Override
            public boolean canDismiss(int position) {
                return true;
            }

            @Override
            public void onDismiss(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                Toast.makeText(getBaseContext(), String.format("Delete item %d", position), Toast.LENGTH_LONG).show();
            }
        })
                .setIsVertical(false)
                .setItemClickCallback(new SwipeDismissRecyclerViewTouchListener.OnItemClickCallBack() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getBaseContext(), String.format("Click item %d", position), Toast.LENGTH_LONG).show();
            }
        }).create();

        recyclerView.setOnTouchListener(listener);

        // set touch listener for recyclerHorizontalView(horizontal swipe to remove)
        SwipeDismissRecyclerViewTouchListener anotherListener = new SwipeDismissRecyclerViewTouchListener.Builder(anotherRecyclerView, new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
            @Override
            public boolean canDismiss(int position) {
                return true;
            }

            @Override
            public void onDismiss(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                Toast.makeText(getBaseContext(), String.format("Delete item %d", position), Toast.LENGTH_LONG).show();
            }
        })
                .setIsVertical(true)
                .setItemClickCallback(new SwipeDismissRecyclerViewTouchListener.OnItemClickCallBack() {
                    @Override
                    public void onClick(int position) {
                        Toast.makeText(getBaseContext(), String.format("Click item %d", position), Toast.LENGTH_LONG).show();
                    }
                }).create();
        anotherRecyclerView.setOnTouchListener(anotherListener);

    }
}
