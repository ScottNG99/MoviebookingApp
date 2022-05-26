package com.example.individualproject.MVVM;

import com.example.individualproject.Model.homemodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class homeRepositoryu {
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    List<homemodel> homemodelList = new ArrayList<>();

    HomeList interfaceomovielist;

    public homeRepositoryu(HomeList interfaceomovielist){
        this.interfaceomovielist=interfaceomovielist;
    }



    public void getMovie(){

        firebaseFirestore.collection("Homemovie").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(Task<QuerySnapshot> task) {


                if (task.isSuccessful()) {

                    homemodelList.clear();



                    for (DocumentSnapshot ds: Objects.requireNonNull(task.getResult()).getDocuments()) {

                        homemodel homemodel  = ds.toObject(homemodel.class);
                        homemodelList.add(homemodel);


                        interfaceomovielist.homeLists(homemodelList);


                    }


                }

            }
        });



    }











    public interface HomeList{
        void homeLists(List<homemodel> Homemodel);
    }


}
