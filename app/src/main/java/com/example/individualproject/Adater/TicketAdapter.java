package com.example.individualproject.Adater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.individualproject.Model.TicketModel;
import com.example.individualproject.R;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketHolder> {

    List<TicketModel> ticketModelList;



    @Override
    public TicketAdapter.TicketHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_style, parent, false);
        return new TicketHolder(view);
    }

    @Override
    public void onBindViewHolder( TicketAdapter.TicketHolder holder, int position) {

        holder.mprice.setText(String.valueOf(ticketModelList.get(position).getTotalprice()));
        holder.mname.setText(ticketModelList.get(position).getMoviename());
        holder.mqty.setText(String.valueOf(ticketModelList.get(position).getQuantity()));
        holder.mfomate.setText(ticketModelList.get(position).getFomate());
        holder.mtime.setText(ticketModelList.get(position).getTime());
        Glide.with(holder.itemView.getContext()).load(ticketModelList.get(position).getImageURL()).into(holder.mimageURL);


    }

    @Override
    public int getItemCount() {
        return ticketModelList.size();
    }

    public void setTicketModelList(List<TicketModel> ticketModelList){
        this.ticketModelList= ticketModelList;
    }

    public class TicketHolder extends RecyclerView.ViewHolder {

        TextView mname,mtime,mfomate,mqty,mprice;
        ImageView mimageURL;

        public TicketHolder( View itemView) {
            super(itemView);

            mname = itemView.findViewById(R.id.cartmoviename);
            mtime =itemView.findViewById(R.id.tickettime);
            mfomate =itemView.findViewById(R.id.ticketfomate);
            mqty = itemView.findViewById(R.id.ticketqty);
            mprice = itemView.findViewById(R.id.ticketprice);
            mimageURL = itemView.findViewById(R.id.bgmovieimage);
        }
    }
}
