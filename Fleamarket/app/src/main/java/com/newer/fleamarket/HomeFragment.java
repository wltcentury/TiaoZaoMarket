package com.newer.fleamarket;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-02-23.
 */
public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<String> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homefragment, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        for(int i=1;i<9;i++){
                data.add("");
        }
        RvAdapter adapter= new RvAdapter(getActivity(),data);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,GridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;
    }


    public class RvAdapter extends RecyclerView.Adapter<RvAdapter.Holder> {
        private Context context;
        private ArrayList<String> data;

        public RvAdapter(Context context, ArrayList<String> data) {
            this.context = context;
            this.data = data;
        }


        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
            Holder holder = new Holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
//           holder.textname.setText(data.get(position));
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


            public ImageButton home_product;
            public TextView textname;
            public TextView textprice;


            public Holder(View view) {
                super(view);
                home_product = (ImageButton) view.findViewById(R.id.home_product);
                textname = (TextView) view.findViewById(R.id.textname);
                textprice = (TextView) view.findViewById(R.id.textprice);
            }
        }
    }
}

