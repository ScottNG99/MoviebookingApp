package com.example.individualproject.Adater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.individualproject.Model.MovieReviewModel;
import com.example.individualproject.R;

import java.util.List;

public class MovieReviewAdapter extends RecyclerView.Adapter<MovieReviewAdapter.MoviereviewHolder> {

    List<MovieReviewModel> movieReviewModelList;

    @NonNull
    @Override
    public MovieReviewAdapter.MoviereviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_style, parent, false);
        return new MoviereviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieReviewAdapter.MoviereviewHolder holder, int position) {

        holder.moviename.setText(movieReviewModelList.get(position).getMoviename());
        holder.username.setText(movieReviewModelList.get(position).getUsername());
        holder.content.setText(movieReviewModelList.get(position).getContent());

    }

    public void setMovieReviewModelList(List<MovieReviewModel>movieReviewModelList){
        this.movieReviewModelList=movieReviewModelList;
    }

    @Override
    public int getItemCount() {
        return movieReviewModelList.size();
    }

    public class MoviereviewHolder extends RecyclerView.ViewHolder {

        TextView moviename,username,content;
        public MoviereviewHolder(@NonNull View itemView) {
            super(itemView);

            moviename= itemView.findViewById(R.id.getmoviename);
            username= itemView.findViewById(R.id.username);
            content= itemView.findViewById(R.id.contenmovie);
        }
    }
}
