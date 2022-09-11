package com.example.avestafani.tourism;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AVESTAFANI on 11/18/2021.
 */

public class myadapter_ker extends RecyclerView.Adapter<myadapter_ker.myviewholder> implements View.OnClickListener {

    private static List<datamodel_ker>mylist;
    ArrayList<datamodel_ker>filter;
    private static dbhelper1 dbhelper1;
     private Context context;

    public myadapter_ker(List<datamodel_ker> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
        filter=new ArrayList<>(mylist);


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
            dbhelper1=new dbhelper1(context);
            SharedPreferences prefs=context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
            boolean firststart=prefs.getBoolean("firststart",true);
            if (firststart){
                CreateTableOnFirstStart();
            }
            View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hotel_kermanshah,parent,false);
        return new myviewholder(itemview);
    }

    private void CreateTableOnFirstStart() {
        dbhelper1.insertEmpty();
        SharedPreferences prefs=context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putBoolean("firststart",false);
        editor.apply();
    }

    @Override
    public void onBindViewHolder(myviewholder holder, int position) {
        final datamodel_ker mylist=filter.get(position);
        holder.txtname.setText(mylist.getName());
        holder.txtname1.setText(mylist.getName1());
        holder.t.setText(mylist.getName2());
        holder.img.setImageResource(mylist.getImg());
        holder.t1.setText(mylist.getT1());
        holder.t2.setText(mylist.getT2());
        holder.t3.setText(mylist.getT3());
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
        Animation animation= AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_therre);
        holder.itemView.startAnimation(animation);
        boolean isvisible=mylist.visiblity;
        holder.layout.setVisibility(isvisible?View.VISIBLE:View.GONE);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),show_hotel.class);
                i.putExtra("name",mylist.getName());
                i.putExtra("name1",mylist.getName1());
                i.putExtra("name2",mylist.getName2());
                i.putExtra("img",mylist.getImg());
                i.putExtra("n1",mylist.getT1());
                i.putExtra("n2",mylist.getT2());
                i.putExtra("n3",mylist.getT3());
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

        ReadCursorData(mylist,holder);


    }

    private void ReadCursorData(datamodel_ker datamodel_ker,myviewholder myviewholder) {
        Cursor cursor=dbhelper1.readalldata(datamodel_ker.getkey_id());
        SQLiteDatabase db=dbhelper1.getReadableDatabase();
        try {
            while (cursor.moveToNext()){
                String item_fav_stutus=cursor.getString(cursor.getColumnIndex(dbhelper1.TABLE_NAME3));
                datamodel_ker.setFavstutus(item_fav_stutus);
                if (item_fav_stutus!=null&&item_fav_stutus.equals("1")){


                myviewholder.imageView4.setBackgroundResource(R.drawable.ghalb);
                }else if (item_fav_stutus!=null&&item_fav_stutus.equals("0")){
                    myviewholder.imageView4.setBackgroundResource(R.drawable.ghalb2);

                }
            }
        }finally {
            if (cursor !=null&&cursor.isClosed())
                cursor.close();
            db.close();
        }
    }


    @Override
    public int getItemCount() {
        return filter.size();
    }

    @Override
    public void onClick(View v) {





    }

    static class myviewholder extends RecyclerView.ViewHolder {
        TextView txtname,txtname1,t,t1,t2,t3;;
        ImageView img,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20;
        CardView card;
        LinearLayout layout;
        Button imageView4;

        public myviewholder(View itemView) {
            super(itemView);
            imageView4 = (Button) itemView.findViewById(R.id.imageView4);
            txtname= (TextView) itemView.findViewById(R.id.txt1);
            txtname1= (TextView) itemView.findViewById(R.id.txt2);
            t= (TextView) itemView.findViewById(R.id.t);
            t1= (TextView) itemView.findViewById(R.id.t1);
            t2= (TextView) itemView.findViewById(R.id.t2);
            t3= (TextView) itemView.findViewById(R.id.t3);
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
            img= (ImageView) itemView.findViewById(R.id.img);
            card= (CardView) itemView.findViewById(R.id.card);
            layout= (LinearLayout) itemView.findViewById(R.id.layout);
            imageView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    datamodel_ker data = mylist.get(position);
                    if (data.getFavstutus().equals("0")) {

                    data.setFavstutus("1");
                    dbhelper1.insertInto(data.getName(), data.getImg(), data.getkey_id(), data.getFavstutus());
                    imageView4.setBackgroundResource(R.drawable.ghalb);
                    }
                    else {
                        data.setFavstutus("0");
                        dbhelper1.remove(data.getkey_id());
                        imageView4.setBackgroundResource(R.drawable.ghalb2);
                    }

                }

            });

        }

    }


}
