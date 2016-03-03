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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.newer.fleamarket.R.color.colorAccent;
import static com.newer.fleamarket.R.color.colorone;

/**
 * Created by Administrator on 2016-02-23.
 */
public class ClassifyFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<Integer> color = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.classifyfragment, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView2);

//添加分类
        data.add("电器");
        color.add(0xaa5CACEE);
        image.add(R.drawable.classify_one);
        data.add("书籍");
        color.add(0xaaFF00FF);
        image.add(R.drawable.classify_two);
        data.add("数码");
        color.add(0xaaFFD700);
        image.add(R.drawable.classify_three);
        data.add("日常用品");
        color.add(0xaaFF0000);
        image.add(R.drawable.classify_four);
        data.add("体育用品");
        color.add(0xaa5CACEE);
        image.add(R.drawable.classify_five);
        data.add("服饰");
        color.add(0xaaFFD700);
        image.add(R.drawable.classify_six);
        data.add("其他");
        color.add(0xaaFF00FF);
        image.add(R.drawable.classify_seven);


        RvAdapter adapter = new RvAdapter(getActivity(), data, color,image);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;
    }


    public class RvAdapter extends RecyclerView.Adapter<RvAdapter.Holder> {
        private Context context;
        private ArrayList<String> data;
        private ArrayList<Integer> color;
        private ArrayList<Integer> image;

        public RvAdapter(Context context, ArrayList<String> data, ArrayList<Integer> color,ArrayList<Integer> image) {
            this.context = context;
            this.data = data;
            this.color = color;
            this.image = image;
        }


        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_classify, parent, false);
            Holder holder = new Holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.text_classify.setText(data.get(position));
            holder.relativeLayout.setBackgroundColor(color.get(position));
            holder.imageButton_classify.setImageResource(image.get(position));
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


            public TextView text_classify;
            public ImageView imageButton_classify;
            public RelativeLayout relativeLayout;

            public Holder(View view) {
                super(view);
                text_classify = (TextView) view.findViewById(R.id.text_classify);
                relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout_classify);
                imageButton_classify = (ImageView) view.findViewById(R.id.imageView_classify);
            }
        }
    }
}
