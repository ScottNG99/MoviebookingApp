package com.example.individualproject.Adater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.individualproject.Fragment.All_listmovieFragment;
import com.example.individualproject.Model.Moviemodel;
import com.example.individualproject.Model.homemodel;
import com.example.individualproject.R;

import java.util.List;

public class MovieAllAdapter extends RecyclerView.Adapter<MovieAllAdapter.MovieListHolder> {
    //get model那些需要data
    List<Moviemodel> moviemodelList;
    //click時候 利用method傳送方式傳data
    GetOnemovie interfacegetmovie;



    public MovieAllAdapter(GetOnemovie interfacegetmovie) {
        this.interfacegetmovie = interfacegetmovie;


    }





    public MovieAllAdapter() {

    }




    @Override
    public MovieListHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_list_movie_style, parent, false);
        return new MovieListHolder(view);
    }

    @Override
    public void onBindViewHolder( MovieListHolder holder, int position) {
        //set 好所需要的擺放位置
        holder.moviename.setText(moviemodelList.get(position).getMoviename());
        holder.love.setText(moviemodelList.get(position).getLove());
        holder.cry.setText(moviemodelList.get(position).getCry());
        Glide.with(holder.itemView.getContext()).load(moviemodelList.get(position).getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return moviemodelList.size();
    }

    public void setMoviemodelList(List<Moviemodel> moviemodelList ){
        this.moviemodelList=moviemodelList;
    }

    public class MovieListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView moviename, love, cry,toitro,toschr,postcomment;

        ImageView imageView;

        public MovieListHolder(View itemView) {
            super(itemView);

            moviename = itemView.findViewById(R.id.moveName);
            love = itemView.findViewById(R.id.scoremovie);
            cry = itemView.findViewById(R.id.cryscore);
            imageView = itemView.findViewById(R.id.moveImage);

            toitro = itemView.findViewById(R.id.tointroduce);
            toschr = itemView.findViewById(R.id.tobuyticket);
            postcomment= itemView.findViewById(R.id.tocomment);

            //不同click 會傳送不同data同埋Fragment
            toitro.setOnClickListener(this);
            toschr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interfacegetmovie.clickedmovie2(getAdapterPosition(), moviemodelList);
                }
            });

            postcomment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interfacegetmovie.clickedmovie3(getAdapterPosition(), moviemodelList);
                }
            });


        }

        @Override
        public void onClick(View v) {
            interfacegetmovie.clickedmovie(getAdapterPosition(), moviemodelList);
        }
    }
        //用method傳送data
        public interface GetOnemovie{

            void clickedmovie(int position, List<Moviemodel> moviemodels);
            void clickedmovie2(int position, List<Moviemodel> moviemodels);
            void clickedmovie3(int position, List<Moviemodel> moviemodels);

        }






}
