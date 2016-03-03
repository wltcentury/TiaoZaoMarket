package com.newer.fleamarket;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClassifyActivity extends AppCompatActivity {



    RecyclerView recyclerView_list_classify;
     ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);

        recyclerView_list_classify = (RecyclerView)findViewById(R.id.recyclerView_list_classify);

        for(int i=1;i<9;i++){
            data.add("");
        }
        CAdapter adapter= new CAdapter(this,data);

        recyclerView_list_classify.setLayoutManager(new StaggeredGridLayoutManager(1, GridLayoutManager.VERTICAL));
        recyclerView_list_classify.setAdapter(adapter);
    }

    public void to_home(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.imageView_list_classify:
                intent.setClass(ClassifyActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }


    public class CAdapter extends RecyclerView.Adapter<CAdapter.Holder> {
        private Context context;
        private ArrayList<String> data;

        public CAdapter(Context context,ArrayList<String> data){
            this.context=context;
            this.data=data;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_list_classify, parent, false);
            Holder holder=new Holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
//            holder.textView.setText(data.get(position));
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class Holder extends RecyclerView.ViewHolder {


            public TextView textname_list_classify;
            public TextView textprice_list_classify;
            public ImageView imageView_list_classify;

            public Holder(View view) {
                super(view);
                textname_list_classify= (TextView) view.findViewById(R.id.textname_list_classify);
                textprice_list_classify= (TextView) view.findViewById(R.id.textprice_list_classify);
                imageView_list_classify = (ImageView) findViewById(R.id.imageView_list_classify);
            }
        }
    }
}
