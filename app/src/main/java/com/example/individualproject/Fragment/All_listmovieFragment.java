package com.example.individualproject.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.individualproject.Adater.MovieAllAdapter;
import com.example.individualproject.MVVM.Movieviewmodel;
import com.example.individualproject.Model.Moviemodel;
import com.example.individualproject.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;


public class All_listmovieFragment extends Fragment implements MovieAllAdapter.GetOnemovie{

    FirebaseFirestore firebaseFirestore;
    MovieAllAdapter mAdapter;
    RecyclerView recyclerView;
    Movieviewmodel viewModel;
    NavController navController;





    public All_listmovieFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_listmovie, container, false);
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = view.findViewById(R.id.recViewAll);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter =new MovieAllAdapter(this);
        navController = Navigation.findNavController(view);
        viewModel = new ViewModelProvider(getActivity()).get(Movieviewmodel.class);
        viewModel.getHomeList().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {
                mAdapter.setMoviemodelList(moviemodels);
                recyclerView.setAdapter(mAdapter);
            }
        });


    }
    //傳送目前click的電影data，從而傳送data給其他fragment
    @Override
    public void clickedmovie(int position, List<Moviemodel> moviemodels) {

        String introduce = moviemodels.get(position).getIntroduce();
        String moviename = moviemodels.get(position).getMoviename();
        String iamgeURL = moviemodels.get(position).getImageURL();
        String score = moviemodels.get(position).getScore();
        int price = moviemodels.get(position).getPrice();


        All_listmovieFragmentDirections.ActionAllListmovieFragmentToDetailmovieFragment
                action = All_listmovieFragmentDirections.actionAllListmovieFragmentToDetailmovieFragment();


        action.setMoviename(moviename);
        action.setIntroduce(introduce);
        action.setImageURL(iamgeURL);
        action.setScore(score);
        action.setTkprice(price);



        navController.navigate(action);
    }


    @Override
    public void clickedmovie2(int position, List<Moviemodel> moviemodels) {
        int price = moviemodels.get(position).getPrice();
        String moviename = moviemodels.get(position).getMoviename();
        String stime1 = moviemodels.get(position).getTime1();
        String stime2 = moviemodels.get(position).getTime2();
        String stime3 = moviemodels.get(position).getTime3();
        String sfomate1 = moviemodels.get(position).getFomate1();
        String sfomate2 = moviemodels.get(position).getFomate2();
        String sfomate3 = moviemodels.get(position).getFomate3();
        String iamgeURL = moviemodels.get(position).getImageURL();

        All_listmovieFragmentDirections.ActionAllListmovieFragmentToBuyTicKetFragment
                action = All_listmovieFragmentDirections.actionAllListmovieFragmentToBuyTicKetFragment();
        action.setTkprice(price);
        action.setMoviebname(moviename);
        action.setTime1(stime1);
        action.setTime2(stime2);
        action.setTime3(stime3);
        action.setFomate1(sfomate1);
        action.setFomate2(sfomate2);
        action.setFomate3(sfomate3);
        action.setImageURL(iamgeURL);

        navController.navigate(action);


    }

    @Override
    public void clickedmovie3(int position, List<Moviemodel> moviemodels) {

        String moviename = moviemodels.get(position).getMoviename();


        All_listmovieFragmentDirections.ActionAllListmovieFragmentToCommentFragment
                action = All_listmovieFragmentDirections.actionAllListmovieFragmentToCommentFragment();
        action.setMoviebname(moviename);
        navController.navigate(action);



    }
}