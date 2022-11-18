package com.example.movieapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder> {

    private ArrayList<Movie> listMovies;
    public ListMovieAdapter(ArrayList<Movie> list) {
        this.listMovies = list;
    }

    public ListMovieAdapter(ArrayList<com.example.movieapp.Movie> listMovies) {
    }

    @NonNull
    @Override
    public ListMovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieAdapter.ListViewHolder holder, int position) {
        Movie movie = listMovies.get(position);
        Glide.with(holder.itemView.getContext()).load(movie.getPosterImage()).into(holder.ivMoviePoster);
        holder.tvMovieTitle.setText(movie.getTitle());
        holder.tvMovieDescription.setText(movie.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                Toast.makeText(holder.itemView.getContext(), movie.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMoviePoster;
        TextView tvMovieTitle, tvMovieDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMoviePoster = itemView.findViewById(R.id.iv_movie_poster);
            tvMovieTitle = itemView.findViewById(R.id.tv_movie_title);
            tvMovieDescription = itemView.findViewById(R.id.tv_movie_description);
        }
    }
}