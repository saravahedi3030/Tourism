package com.example.avestafani.tourism;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AVESTAFANI on 11/18/2021.
 */

public class myadapter_kol extends RecyclerView.Adapter<myadapter_kol.myviewholder> implements View.OnClickListener {

    private List<datamodel_kol>mylist;
    ArrayList<datamodel_kol>filter;
    Context context;

    public myadapter_kol(List<datamodel_kol> mylist, Context context) {
        this.mylist = mylist;
        filter=new ArrayList<>(mylist);
        this.context = context;

    }
    public void filter_mlist(String searchword){
        searchword=searchword.toLowerCase();
        if (searchword.isEmpty()){
            filter=new ArrayList<>(mylist);
        }else {
            filter=new ArrayList<>();
            for (int i=0;i<mylist.size();i++){
                String name=mylist.get(i).getTxt1();

                if (name.toLowerCase().contains(searchword)){
                    filter.add(mylist.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }






    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_jazbh,parent,false);
        return new myviewholder(itemview);
    }

    @Override
    public void onBindViewHolder(myviewholder holder, int position) {
        final datamodel_kol mylist=filter.get(position);
        holder.txt1.setText(mylist.getTxt1());
        holder.txt2.setText(mylist.getTxt2());
        holder.txt3.setText(mylist.getTxt3());
        holder.image.setImageResource(mylist.getImage());

        Animation animation= AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_left);
        holder.itemView.startAnimation(animation);
        boolean isvisible=mylist.visiblity;
        holder.txt3.setVisibility(isvisible?View.VISIBLE:View.GONE);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),show_jazbh_kol.class);
                i.putExtra("name1",mylist.getTxt1());
                i.putExtra("name2",mylist.getTxt2());
                i.putExtra("name3",mylist.getTxt3());
                i.putExtra("image",mylist.getImage());

                v.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return filter.size();
    }

    @Override
    public void onClick(View v) {






    }

    static class myviewholder extends RecyclerView.ViewHolder {
        TextView txt1,txt2,txt3;
        ImageView image;
        CardView card;

        public myviewholder(View itemView) {
            super(itemView);
            txt1= (TextView) itemView.findViewById(R.id.txt1);
            txt2= (TextView) itemView.findViewById(R.id.txt2);
            txt3= (TextView) itemView.findViewById(R.id.txt3);
            image= (ImageView) itemView.findViewById(R.id.image);
            card= (CardView) itemView.findViewById(R.id.card);

        }

    }


}
