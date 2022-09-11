package com.example.avestafani.tourism;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AVESTAFANI on 03/06/2022.
 */

public class myadapter2 extends RecyclerView.Adapter<myadapter2.ViewHolder> {
   Context context;
    ArrayList<mymodel2>data=new ArrayList<>();
    ArrayList<mymodel2>filter;
    show_safar det;


    public myadapter2(ArrayList<mymodel2> data,Context context ) {
        this.context = context;
        this.data = data;
        det = (show_safar) context;
        filter=new ArrayList<>(data);

    }






    public void filter1(String searchword){
        searchword=searchword.toLowerCase();
        if (searchword.isEmpty()){
            filter=new ArrayList<>(data);
        }else {
            filter=new ArrayList<>();
            for (int i=0;i<data.size();i++){
                String name=data.get(i).getName();


                if (name.toLowerCase().contains(searchword)){
                    filter.add(data.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }


    @Override
    public myadapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem12, parent, false);
        ViewHolder viewholder=new ViewHolder(view,det);
        return viewholder;



    }

    @Override
    public void onBindViewHolder(final myadapter2.ViewHolder holder, int position) {
        final mymodel2 md=filter.get(position);
        holder.imageavatar.setImageBitmap(md.getProavator());
        holder.name1.setText(md.getName());
        holder.loc1.setText(md.getLocation());
        holder.date1.setText(md.getDate());
        holder.fri1.setText(md.getFriends());
        if (!det.is_in_action_mode)
        {
            holder.chekbox1.setVisibility(View.GONE);

        }
        else {
            holder.chekbox1.setVisibility(View.VISIBLE);
            holder.chekbox1.setChecked(false);
        }


    }

    @Override
    public int getItemCount() {
        return filter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name1,loc1,date1,fri1;
        ImageView imageavatar;
        CheckBox chekbox1;
        show_safar det;
        CardView cardView;




        public ViewHolder(View itemView,show_safar det) {
            super(itemView);

            name1= (TextView) itemView.findViewById(R.id.txtname);
            loc1= (TextView) itemView.findViewById(R.id.txtloc);
            date1= (TextView) itemView.findViewById(R.id.date1);
            fri1= (TextView) itemView.findViewById(R.id.txtdes);
            imageavatar= (ImageView) itemView.findViewById(R.id.viewavator);
            chekbox1= (CheckBox) itemView.findViewById(R.id.checkBox1);
            this.det = det;
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            chekbox1.setOnClickListener(this);
            cardView.setOnLongClickListener(det);




        }

        @Override
        public void onClick(View v) {
            det.selection(v,getAdapterPosition());

        }
    }
}
