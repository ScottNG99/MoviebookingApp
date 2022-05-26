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

import com.example.individualproject.Adater.TicketAdapter;
import com.example.individualproject.Model.TicketModel;
import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class TicketFragment extends Fragment {

    TicketAdapter mAdapter;
    RecyclerView recyclerView;
    FirebaseFirestore firestore;

    List<TicketModel> ticketModelList = new ArrayList<>();



    public TicketFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firestore = FirebaseFirestore.getInstance();
        mAdapter =new TicketAdapter();

        recyclerView= view.findViewById(R.id.ticketview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        //list all Cart的資料
        firestore.collection("Cart").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(Task<QuerySnapshot> task) {

                ticketModelList.clear();
                if (task.isSuccessful()) {


                    for (DocumentSnapshot ds: task.getResult().getDocuments()) {


                        TicketModel ticketModel = ds.toObject(TicketModel.class);
                        ticketModelList.add(ticketModel);

                        mAdapter.setTicketModelList(ticketModelList);
                        recyclerView.setAdapter(mAdapter);



                    }


                }



            }
        });
    }
}