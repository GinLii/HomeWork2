package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application2.recycler.LinearItemDecoration;
import com.example.application2.recycler.MyAdapter;
import com.example.application2.recycler.TestData;
import com.example.application2.recycler.TestDataSet;

public class MainActivity extends AppCompatActivity implements MyAdapter.IOnItemClickListener {

    private static final String TAG = "TAG";

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    private LinearLayout Root;
    private ImageButton btn0;
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private View tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        Log.i(TAG, "RecyclerViewActivity onCreate");
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler);
        Root = findViewById(R.id.Lroot);
        btn0= findViewById(R.id.button0);
        btn1= findViewById(R.id.button1);
        btn2= findViewById(R.id.button2);
        btn3= findViewById(R.id.button3);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(MainActivity.this, Button0.class);
                startActivity(intent9);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(MainActivity.this, Button1.class);
                startActivity(intent10);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11 = new Intent(MainActivity.this, Button2.class);
                startActivity(intent11);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(MainActivity.this, Button3.class);
                startActivity(intent12);
            }
        });

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(TestDataSet.getData());
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);
        LinearItemDecoration itemDecoration = new LinearItemDecoration(Color.GREEN);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        DefaultItemAnimator animator = new DefaultItemAnimator();
//        animator.setAddDuration(3000);
//        recyclerView.setItemAnimator(animator);
        int num = Count(Root);
        String Num = Integer.toString(num);
        Log.i(TAG,"the number of view is "+Num);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "RecyclerViewActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "RecyclerViewActivity onResume");
    }


    public int Count(View root) {
        int viewCount = 0;
        if (null == root) {
            return 0;
        }
        if (root instanceof ViewGroup) {
            viewCount++;
            for (int i = 0; i < ((ViewGroup) root).getChildCount(); i++) {
                View view = ((ViewGroup) root).getChildAt(i);
                if (view instanceof ViewGroup) {
                    viewCount += Count(view);
                } else {
                    viewCount++;
                }
            }
        }
        return viewCount;
    }




    @Override
    public void onItemCLick(int position, TestData data) {
        switch (position){
            case 0: Intent intent = new Intent(this, Item0.class);
                    startActivity(intent);break;
            case 1: Intent intent1 = new Intent(this, Item1.class);
                    startActivity(intent1);break;
            case 2: Intent intent2 = new Intent(this, Item2.class);
                    startActivity(intent2);break;
            case 3: Intent intent3 = new Intent(this, Item3.class);
                    startActivity(intent3);break;
            case 4: Intent intent4 = new Intent(this, Item4.class);
                    startActivity(intent4);break;
            case 5: Intent intent5 = new Intent(this, Item5.class);
                    startActivity(intent5);break;
            case 6: Intent intent6 = new Intent(this, Item6.class);
                    startActivity(intent6);break;
            case 7: Intent intent7 = new Intent(this, Item7.class);
                    startActivity(intent7);break;
            case 8: Intent intent8 = new Intent(this, Item8.class);
                    startActivity(intent8);break;
        }
    }

    @Override
    public void onItemLongCLick(int position, TestData data) {
        Toast.makeText(MainActivity.this, "长按了第" + position + "条", Toast.LENGTH_SHORT).show();
    }
}