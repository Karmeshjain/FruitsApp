package com.example.fruitsapp;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Fruitadaptor extends RecyclerView.Adapter<Fruitadaptor.Fruitviewholder> {

    private String[] data;
    public Fruitadaptor(String[] data)
    {
        this.data =data;
    }



    @NonNull
    @Override
    public Fruitviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout,parent,false);
        return new Fruitviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Fruitviewholder holder, int position) {
     String title =data[position];
     holder.txt1.setText(title);
    }



    @Override
    public int getItemCount() {
        return data.length;
    }

    public  class Fruitviewholder extends RecyclerView.ViewHolder{
        TextView txt1,txt2;

        public Fruitviewholder(@NonNull View itemView) {
            super(itemView);
            txt1=(TextView) itemView.findViewById(R.id.txt1);
            txt2=(TextView) itemView.findViewById(R.id.txt2);

        }
    }
}
