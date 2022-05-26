package com.example.individualproject.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class CommentFragment extends Fragment {
    EditText content;
    Button submit;
    ImageView back;
    TextView moviename;

    String name;
    NavController navController;
    String userid;
    FirebaseUser user;
    DocumentReference reference;
    FirebaseFirestore firebaseFirestore;
    String username,storeusername,storemoviename;
    String moviereviewcontent;


    private String userID;

    public CommentFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        content= view.findViewById(R.id.post_content);
        submit = view.findViewById(R.id.submit_btn);
        back= view.findViewById(R.id.left_back_icon);
        moviename=view.findViewById(R.id.togetmoviename);
        navController = Navigation.findNavController(view);
        name= BuyTicKetFragmentArgs.fromBundle(getArguments()).getMoviebname();
        storemoviename=name;



        user = FirebaseAuth.getInstance().getCurrentUser();
        userid = user.getUid();
        firebaseFirestore  = FirebaseFirestore.getInstance();
        reference=firebaseFirestore.collection("users").document(userid);

        //get目前user name
        reference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.getResult().exists()){
                            username=task.getResult().getString("Name");
                            storeusername=username;

                        }
                    }
                });

        //新增firebase data store 以下資料
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moviereviewcontent=content.getText().toString();

                navController.navigate(R.id.listAllcommentFragment);


                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("username", storeusername);
                hashMap.put("content", moviereviewcontent);
                hashMap.put("moviename", storemoviename);

                firebaseFirestore.collection("MovieReview").document(storemoviename).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {



                    }
                });

            }
        });





    }


}