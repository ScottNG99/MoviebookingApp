package com.example.individualproject.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.individualproject.Adater.HomemovieAdapter;
import com.example.individualproject.Adater.SliderAdapter;
import com.example.individualproject.MVVM.homeviewmodel;
import com.example.individualproject.Model.homemodel;
import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;


public class HomeFragment extends Fragment {

    NavController navController;
    FirebaseFirestore firebaseFirestore;
    HomemovieAdapter mAdapter;
    RecyclerView recyclerView;
    homeviewmodel viewModel;
    private FirebaseAuth mAuth;
    String userid;
    FirebaseUser user;
    TextView togoalllist,togocommentlist;
    ImageView tocartlist;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    DocumentReference reference;

    TextView navusername,navuseremail;


    SliderView sliderView;
        /* 用array裝圖片*/
    int[] images = {R.drawable.doctor,
            R.drawable.spider,
            R.drawable.venom2
            };


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.nav_view);
        toolbar = view.findViewById(R.id.toolbar);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userid = user.getUid();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        navigationView.bringToFront();
        /*reference=firebaseFirestore.collection("users").document(userid);*/
        navuseremail = view.findViewById(R.id.nav_user_mail);
        navusername = view.findViewById(R.id.nav_username);


        togocommentlist = view.findViewById(R.id.titlename);
        togoalllist = view.findViewById(R.id.togoallview);
        tocartlist = view.findViewById(R.id.fab);
        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = view.findViewById(R.id.recently_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new HomemovieAdapter();
        navController = Navigation.findNavController(view);
        /* 獲取firebasedata + 獲取Adapter的位置*/
        viewModel = new ViewModelProvider(getActivity()).get(homeviewmodel.class);
        viewModel.getHomeList().observe(getViewLifecycleOwner(), new Observer<List<homemodel>>() {
            @Override
            public void onChanged(List<homemodel> homemodels) {
                mAdapter.setHomemodelList(homemodels);
                recyclerView.setAdapter(mAdapter);
            }
        });

        /* silder banner*/
        sliderView = view.findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        /* 設置圓點動畫效果*/
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        /* 設置滾動動畫效果*/
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();


        /* 跳頁到alllist_fragment*/
        togoalllist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_homeFragment_to_all_listmovieFragment);

            }
        });

        tocartlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.ticketFragment);
            }
        });

        togocommentlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.listAllcommentFragment);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.nav_home){
                    navController.navigate(R.id.homeFragment);
                }else if (item.getItemId()==R.id.nav_signout){
                    mAuth.signOut();
                    navController.navigate(R.id.loginFragment);

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        /*updateNavHeader();*/


    }

    /*private void updateNavHeader() {
        View headerView =navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.nav_username);
        TextView navUserMail = headerView.findViewById(R.id.nav_user_mail);

        reference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    String username,userEmail;
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.getResult().exists()){
                            username=task.getResult().getString("Name");
                            userEmail=task.getResult().getString("Email");
                            navUserMail.setText(userEmail);
                            navUsername.setText(username);

                        }


                    }
                });

    }*/






}