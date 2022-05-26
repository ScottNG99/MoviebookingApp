package com.example.individualproject.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.individualproject.Adater.BuyticketAdapter;
import com.example.individualproject.Adater.MovieAllAdapter;
import com.example.individualproject.MVVM.Movieviewmodel;
import com.example.individualproject.Model.Moviemodel;
import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DetailmovieFragment extends Fragment implements  BuyticketAdapter.GetOnemovie1 {

    NavController navController;
    FirebaseFirestore firebaseFirestore;
    TextView moviename, introduce, score,tkprice;
    ImageView imageView;


    Movieviewmodel viewModel;

    int totalPrice = 0;
    int quantity = 0;

    BuyticketAdapter mAdapter;

    String movieid, name, movieintroduce, imageURL, moviescore;
    int price = 0;

    List<Integer> savequantity = new ArrayList<>();
    int quantitysum = 0;


    public DetailmovieFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailmovie, container, false);
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);

        imageView = view.findViewById(R.id.bigimage);
        moviename = view.findViewById(R.id.moviename2);
        introduce = view.findViewById(R.id.introduce);
        score = view.findViewById(R.id.score1);

        tkprice = view.findViewById(R.id.totalprice);
        //繼承data來顯示目前click的電影資料
        name = DetailmovieFragmentArgs.fromBundle(getArguments()).getMoviename();
        movieintroduce = DetailmovieFragmentArgs.fromBundle(getArguments()).getIntroduce();
        imageURL = DetailmovieFragmentArgs.fromBundle(getArguments()).getImageURL();
        moviescore = DetailmovieFragmentArgs.fromBundle(getArguments()).getScore();
        price = DetailmovieFragmentArgs.fromBundle(getArguments()).getTkprice();


        Glide.with(view.getContext()).load(imageURL).into(imageView);
        moviename.setText(name);
        introduce.setText(movieintroduce);
        score.setText(moviescore);


        mAdapter= new BuyticketAdapter(this);
        viewModel = new ViewModelProvider(getActivity()).get(Movieviewmodel.class);
        viewModel.getHomeList().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {
                mAdapter.setMoviemodelList(moviemodels);

            }
        });





    }


    @Override
    public void clickedmovie1(int position, List<Moviemodel> moviemodels) {


        int price = moviemodels.get(position).getPrice();

        DetailmovieFragmentDirections.ActionDetailmovieFragmentToBuyTicKetFragment2
                action = DetailmovieFragmentDirections.actionDetailmovieFragmentToBuyTicKetFragment2();


        action.setTkprice(price);

        navController.navigate(action);
    }
}

