package com.chat.ajitrajeev.buyhatke.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chat.ajitrajeev.buyhatke.R;
import com.chat.ajitrajeev.buyhatke.model.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gallery extends AppCompatActivity {
    RadioGroup mLayoutGroup;
    Toolbar mToolbar;
    RecyclerView horizontal_recycler_view;
    HorizontalAdapter horizontalAdapter;
    private List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mLayoutGroup = (RadioGroup)findViewById(R.id.layout_group);
        horizontal_recycler_view= (RecyclerView) findViewById(R.id.image_recycler);
        data = fill_with_data();
        horizontalAdapter=new HorizontalAdapter(data, getApplication());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(Gallery.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
        horizontal_recycler_view.addOnItemTouchListener(
                new RecyclerItemClickListener(Gallery.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), "Position" + position, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Gallery.this, FullScreenViewActivity.class);
                        i.putExtra("position", position);
                        startActivity(i);
                    }
                })
             );
        mLayoutGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.linearlayout){
                    initListDisplay();
                    Toast.makeText(getApplicationContext(),"Linear Layout Selected",Toast.LENGTH_LONG).show();
                }

                else {
                    if (i==R.id.gridlayout){
                        initGridDisplay();
                        Toast.makeText(getApplicationContext(),"Grid Layout Selected",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data( R.drawable.imag1, "Image 1"));
        data.add(new Data( R.drawable.imag2, "Image 2"));
        data.add(new Data( R.drawable.imag3, "Image 3"));
        data.add(new Data( R.drawable.imag4, "Image 4"));
        data.add(new Data( R.drawable.imag5, "Image 5"));
        data.add(new Data( R.drawable.imag6, "Image 6"));
        data.add(new Data( R.drawable.imag7, "Image 7"));
        data.add(new Data( R.drawable.imag8, "Image 8"));
        data.add(new Data( R.drawable.imag9, "Image 9"));
        data.add(new Data( R.drawable.imag10, "Image 10"));
        data.add(new Data( R.drawable.imag11, "Image 11"));
        data.add(new Data( R.drawable.imag12, "Image 12"));
        data.add(new Data( R.drawable.imag13, "Image 13"));
        data.add(new Data( R.drawable.imag14, "Image 14"));
        data.add(new Data( R.drawable.imag15, "Image 15"));
        data.add(new Data( R.drawable.imag16, "Image 16"));
        data.add(new Data( R.drawable.imag17, "Image 17"));
        data.add(new Data( R.drawable.imag18, "Image 18"));
        data.add(new Data( R.drawable.imag19, "Image 19"));
        data.add(new Data( R.drawable.imag19, "Image 20"));
        data.add(new Data( R.drawable.imag21, "Image 21"));
        data.add(new Data( R.drawable.imag22, "Image 22"));
        data.add(new Data( R.drawable.imag23, "Image 23"));
        data.add(new Data( R.drawable.imag24, "Image 24"));
        data.add(new Data( R.drawable.imag25, "Image 25"));
        data.add(new Data( R.drawable.imag26, "Image 26"));
        data.add(new Data( R.drawable.imag27, "Image 27"));


        return data;
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder>
    {

        List<Data> horizontalList = Collections.EMPTY_LIST;
        Context context;

        public HorizontalAdapter(List<Data> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.imageView.setImageResource(horizontalList.get(position).imageId);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    Toast.makeText(Gallery.this, list, Toast.LENGTH_SHORT).show();
                }

            });
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView ;
            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView)itemView.findViewById(R.id.image);

            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){

            case R.id.action_settings:

                // handle settings
                break;

         /*   case R.id.main_Linear:
                // Setup the LinearLayoutManager
                initListDisplay();
                break;


            case R.id.main_grid:

                // Setup the GridLayoutManager
                initGridDisplay();
                break;*/

        }
        return super.onOptionsItemSelected(item);
    }
    // Display a list
    private void initListDisplay(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        horizontal_recycler_view.setLayoutManager(layoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
    }

    // Display the Grid
    private void initGridDisplay(){
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        horizontal_recycler_view.setLayoutManager(layoutManager);
    }
}
