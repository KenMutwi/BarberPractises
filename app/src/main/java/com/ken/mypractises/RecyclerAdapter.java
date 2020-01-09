package com.ken.mypractises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Baberfruit> arrayList=new ArrayList<>();
    RecyclerAdapter(ArrayList<Baberfruit> arrayList){
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder viewHolder, int i) {
        Baberfruit baberfruit= arrayList.get(i);
        viewHolder.TowelIssued.setText(Integer.toString(baberfruit.getTowelsIssued()));
        viewHolder.TowelCollected.setText(Integer.toString(baberfruit.getTowelsCollected()));
        viewHolder.Barber1a.setText(Integer.toString(baberfruit.getBarber1Activity()));
        viewHolder.Barber2a.setText(Integer.toString(baberfruit.getBarber2Activity()));
        viewHolder.Barber3a.setText(Integer.toString(baberfruit.getBarber3Activity()));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView DateInserted,TowelIssued,TowelCollected,Barber1a,Barber2a,Barber3a;
        RecyclerViewHolder(View view){
            super(view);
            TowelIssued=(TextView)view.findViewById(R.id.TowelI);
            TowelCollected=(TextView)view.findViewById(R.id.Towelc);
            Barber1a=(TextView)view.findViewById(R.id.Barber1);
            Barber2a=(TextView)view.findViewById(R.id.Barber2);
            Barber3a=(TextView)view.findViewById(R.id.Barber3);

        }
    }
}
