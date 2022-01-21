package com.example.healpro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    int[] img;
    LayoutInflater inflater;
    int cid;
    int flag;


    public ViewPagerAdapter(Context context, int[] img,int cid,int flag) {
        this.context = context;
        this.img = img;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.cid=cid;
        this.flag=flag;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView=inflater.inflate(R.layout.item,container,false);
        ImageView imgv=(ImageView)itemView.findViewById(R.id.imageViewMain);
        imgv.setImageResource(img[position]);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag!=1){
                StringBuilder s = new StringBuilder();
                StringBuilder a = new StringBuilder();
                a.append(position);
                switch(position){
                    case 0: s.append("Dermatologist");
                            break;
                    case 1: s.append("Orthopedic");
                        break;
                    case 2: s.append("paediatrician");
                        break;
                    case 3: s.append("gynaecologist");
                            break;
                    case 4: s.append("Family Physician");
                        break;
                }
                Intent pd= new Intent(context.getApplicationContext(),BookAppointment.class);
                pd.putExtra("Concern : ",s.toString());
                pd.putExtra("specialist",a.toString());
                pd.putExtra("cid",cid);
                context.startActivity(pd);
            }}
        });
        Objects.requireNonNull(container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((LinearLayout)object);
    }
}
