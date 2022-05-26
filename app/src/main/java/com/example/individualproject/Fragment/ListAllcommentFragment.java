package com.example.individualproject.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.individualproject.Adater.MovieReviewAdapter;
import com.example.individualproject.Model.MovieReviewModel;
import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class ListAllcommentFragment extends Fragment {

    MovieReviewAdapter mAdapter;
    RecyclerView recyclerView;
    FirebaseFirestore firestore;

    List<MovieReviewModel> movieReviewModelList =new ArrayList<>();




    public ListAllcommentFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_allcomment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firestore = FirebaseFirestore.getInstance();
        mAdapter = new MovieReviewAdapter();
        recyclerView = view.findViewById(R.id.listallcomment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //get MovieReview全部data
        firestore.collection("MovieReview").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(Task<QuerySnapshot> task) {

                movieReviewModelList.clear();
                if (task.isSuccessful()) {


                    for (DocumentSnapshot ds: task.getResult().getDocuments()) {


                        MovieReviewModel movieReviewModel = ds.toObject(MovieReviewModel.class);
                        movieReviewModelList.add(movieReviewModel);

                        mAdapter.setMovieReviewModelList(movieReviewModelList);
                        recyclerView.setAdapter(mAdapter);



                    }


                }



            }
        });
    }
}