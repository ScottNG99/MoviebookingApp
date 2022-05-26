package com.example.individualproject.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


public class LoginFragment extends Fragment {

    private EditText useremail;
    private EditText userpassword;
    private Button login;
    private TextView register;
    private FirebaseAuth mAuth;
    NavController navController;
    FirebaseFirestore firestore;



    public LoginFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        login = view.findViewById(R.id.login);
        register = view.findViewById(R.id.register);
        useremail = view.findViewById(R.id.Email);
        userpassword = view.findViewById(R.id.password);
        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();

        firestore = FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_loginFragment_to_registerFragment);

            }
        });

        //login時候會有的反應
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = useremail.getText().toString().trim();
                String password = userpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    useremail.setError("Email is required");
                }else if (TextUtils.isEmpty(password)) {
                    userpassword.setError("Password is required");
                }else {
                    login(email , password);
                }
            }
        });
    }

    private void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    navController.navigate(R.id.homeFragment);
                }else {
                    Toast.makeText(getContext(),"login fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null){
            navController.navigate(R.id.homeFragment);
        }
    }
}