package com.example.avestafani.tourism;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AVESTAFANI on 11/18/2021.
 */

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> implements View.OnClickListener {

    private List<datamodel>mylist;
    ArrayList<datamodel>filter;
    Context context;

    public myadapter(List<datamodel> mylist, Context context) {
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
                String name=mylist.get(i).getName();

                if (name.toLowerCase().contains(searchword)){
                    filter.add(mylist.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }





    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.listdata,parent,false);
        return new myviewholder(itemview);
    }

    @Override
    public void onBindViewHolder(myviewholder holder, int position) {
        final datamodel mylist=filter.get(position);
        holder.txtname.setText(mylist.getName());
        holder.t.setText(mylist.getName1());
        holder.t1.setText(mylist.getT1());
        holder.t2.setText(mylist.getT2());
        holder.t3.setText(mylist.getT3());
        holder.img.setImageResource(mylist.getImg());
        holder.img11.setImageResource(mylist.getImg1());
        holder.img12.setImageResource(mylist.getImg2());
        holder.img13.setImageResource(mylist.getImg3());
        holder.img14.setImageResource(mylist.getImg4());
        holder.img15.setImageResource(mylist.getImg5());
        holder.img16.setImageResource(mylist.getImg6());
        holder.img17.setImageResource(mylist.getImg7());
        holder.img18.setImageResource(mylist.getImg8());
        holder.img19.setImageResource(mylist.getImg9());
        holder.img20.setImageResource(mylist.getImg10());
        Animation animation= AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_four);
        holder.itemView.startAnimation(animation);
        boolean isvisible=mylist.visiblity;
        holder.layout.setVisibility(isvisible?View.VISIBLE:View.GONE);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),show_jazbh.class);
                i.putExtra("name",mylist.getName());
                i.putExtra("name1",mylist.getName1());
                i.putExtra("n1",mylist.getT1());
                i.putExtra("n2",mylist.getT2());
                i.putExtra("n3",mylist.getT3());
                i.putExtra("img",mylist.getImg());
                i.putExtra("img1",mylist.getImg1());
                i.putExtra("img2",mylist.getImg2());
                i.putExtra("img3",mylist.getImg3());
                i.putExtra("img4",mylist.getImg4());
                i.putExtra("img5",mylist.getImg5());
                i.putExtra("img6",mylist.getImg6());
                i.putExtra("img7",mylist.getImg7());
                i.putExtra("img8",mylist.getImg8());
                i.putExtra("img9",mylist.getImg9());
                i.putExtra("img10",mylist.getImg10());

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
        TextView txtname,t,t1,t2,t3;
       ImageView img,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20;
        CardView card;
        LinearLayout layout;

        public myviewholder(View itemView) {
            super(itemView);
            txtname= (TextView) itemView.findViewById(R.id.txtname);
            t= (TextView) itemView.findViewById(R.id.t);
            t1= (TextView) itemView.findViewById(R.id.t1);
            t2= (TextView) itemView.findViewById(R.id.t2);
            t3= (TextView) itemView.findViewById(R.id.t3);
            img= (ImageView) itemView.findViewById(R.id.img);
            img11= (ImageView) itemView.findViewById(R.id.img11);
            img12= (ImageView) itemView.findViewById(R.id.img12);
            img13= (ImageView) itemView.findViewById(R.id.img13);
            img14= (ImageView) itemView.findViewById(R.id.img14);
            img15= (ImageView) itemView.findViewById(R.id.img15);
            img16= (ImageView) itemView.findViewById(R.id.img16);
            img17= (ImageView) itemView.findViewById(R.id.img17);
            img18= (ImageView) itemView.findViewById(R.id.img18);
            img19= (ImageView) itemView.findViewById(R.id.img19);
            img20= (ImageView) itemView.findViewById(R.id.img20);
            card= (CardView) itemView.findViewById(R.id.card);
            layout= (LinearLayout) itemView.findViewById(R.id.layout);
        }

    }


}
