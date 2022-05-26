package com.example.individualproject.Adater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.individualproject.Fragment.DetailmovieFragment;
import com.example.individualproject.Model.Moviemodel;
import com.example.individualproject.R;

import java.util.List;

public class BuyticketAdapter extends RecyclerView.Adapter<BuyticketAdapter.MovieListHolder2>{

    List<Moviemodel> moviemodelList;
    GetOnemovie1 interfacegetmovie;

    public BuyticketAdapter(GetOnemovie1 interfacegetmovie) {
        this.interfacegetmovie = interfacegetmovie;
    }

    public BuyticketAdapter() {

    }



    @NonNull
    @Override
    public MovieListHolder2 onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detailmovie, parent, false);
        return new MovieListHolder2(view);
    }

    @Override
    public void onBindViewHolder(MovieListHolder2 holder, int position) {
       

    }

    @Override
    public int getItemCount() {
        return moviemodelList.size();
    }
    public void setMoviemodelList(List<Moviemodel> moviemodelList ){
        this.moviemodelList=moviemodelList;
    }


    public class MovieListHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView tostore;
        public MovieListHolder2( View itemView) {
            super(itemView);
            tostore= itemView.findViewById(R.id.bigimage);
            
            tostore.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            interfacegetmovie.clickedmovie1(getAdapterPosition(), moviemodelList);
        }
    }

    public interface GetOnemovie1{
        void clickedmovie1(int position, List<Moviemodel> moviemodels);
    }
}
