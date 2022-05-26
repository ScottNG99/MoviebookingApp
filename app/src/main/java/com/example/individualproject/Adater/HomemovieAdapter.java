package com.example.individualproject.Adater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.example.individualproject.Model.homemodel;
import com.example.individualproject.R;




import java.util.List;

public class HomemovieAdapter extends RecyclerView.Adapter<HomemovieAdapter.HomeListHolder> {


    List<homemodel> homemodelList;
    GetOnemovie interfacegetmovie;




    public HomemovieAdapter() {

    }


    @Override
    public HomemovieAdapter.HomeListHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_viewstyle, parent, false);
        return new HomeListHolder(view);


    }

    @Override
    public void onBindViewHolder( HomemovieAdapter.HomeListHolder holder, int position) {


        holder.score.setText(homemodelList.get(position).getScore());

        Glide.with(holder.itemView.getContext()).load(homemodelList.get(position).getImageURL()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return homemodelList.size();
    }
    //    sets the movie list from viewmodel
    public void setHomemodelList(List<homemodel> homemodelList){
        this.homemodelList = homemodelList;
    }

    public class HomeListHolder extends RecyclerView.ViewHolder {

        TextView moviename, score;
        ImageView imageView;

        public HomeListHolder( View itemView) {
            super(itemView);


            score = itemView.findViewById(R.id.score);
            imageView = itemView.findViewById(R.id.imageview);




        }


        public void onClick(View v) {

            interfacegetmovie.clickedmovie(getAdapterPosition(), homemodelList);

        }
    }


    public interface GetOnemovie{
        void clickedmovie(int position, List<homemodel> homemodels);
    }
}
