package com.example.individualproject.MVVM;

import com.example.individualproject.Model.Moviemodel;
import com.example.individualproject.Model.homemodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieRepositoryu {

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    List<Moviemodel> moviemodelList = new ArrayList<>();

    MovieList interfaceomovielist;

    public MovieRepositoryu(MovieList interfaceomovielist) {
        this.interfaceomovielist = (MovieList) interfaceomovielist;
    }


    public void getMovie() {
        //get firebase data
        firebaseFirestore.collection("allmovielist").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(Task<QuerySnapshot> task) {


                if (task.isSuccessful()) {

                    moviemodelList.clear();


                    for (DocumentSnapshot ds : Objects.requireNonNull(task.getResult()).getDocuments()) {

                        Moviemodel moviemodel = ds.toObject(Moviemodel.class);
                        moviemodelList.add(moviemodel);


                        interfaceomovielist.movieLists(moviemodelList);


                    }


                }

            }
        });


    }

    public interface MovieList{
        void movieLists(List<Moviemodel> moviemodels);
    }
}
