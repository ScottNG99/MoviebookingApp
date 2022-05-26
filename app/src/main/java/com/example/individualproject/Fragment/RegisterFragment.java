package com.example.individualproject.Fragment;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterFragment extends Fragment {

    private EditText username;
    private EditText userpassword;
    private EditText userpassword2;
    private EditText useremail;

    private Button btnRegister;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String userID;
    NavController navController;


    public RegisterFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRegister = view.findViewById(R.id.btnRegister);
        useremail = view.findViewById(R.id.regEmail);
        username = view.findViewById(R.id.regName);

        userpassword = view.findViewById(R.id.regpassword);
        userpassword2 = view.findViewById(R.id.regpassword2);
        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get user的資料
                final String name = username.getText().toString();
                final String password = userpassword.getText().toString();
                final String password2 = userpassword2.getText().toString();
                final String email = useremail.getText().toString();

                if (email.isEmpty() && name.isEmpty() && password.isEmpty() && password.equals(password2) ) {
                    Toast.makeText(getContext(), "Register fail", Toast.LENGTH_SHORT).show();
                } else {
                    createuseraccount(email, name, password);
                }
            }
        });








    }

    private void createuseraccount(String email, String name, String password) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //新增user

                if (task.isSuccessful()) {
                    navController.navigate(R.id.action_registerFragment_to_loginFragment);
                    Toast.makeText(getContext(), "User create", Toast.LENGTH_SHORT).show();
                    userID = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = db.collection("users").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("Name",name);
                    user.put("Password",password);
                    user.put("Email",email);

                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " +e.toString());
                        }
                    });
                }else{
                    Toast.makeText(getContext(), "Account creation fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }




}


