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


    public ViewPagerAdapter(Context context, int[] img) {
        this.context = context;
        this.img = img;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                StringBuilder s = new StringBuilder();
                int a=0;
                switch(position){
                    case 0: s.append("Dermatologist");
                            a=0;
                            break;
                    case 1: s.append("Orthopedic");
                            a=1;
                        break;
                    case 2: s.append("paediatrician");
                            a=3;
                        break;
                    case 3: s.append("gynaecologist");
                            a=4;
                            break;
                    case 4: s.append("Family Physician");
                            a=5;
                        break;
                }
                Intent pd= new Intent(context.getApplicationContext(),BookAppointment.class);
                pd.putExtra("Concern : ",s.toString());
                pd.putExtra("specialist",a);
                context.startActivity(pd);
            }
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
