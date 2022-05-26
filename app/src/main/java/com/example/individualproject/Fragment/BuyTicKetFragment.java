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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.individualproject.Adater.BuyticketAdapter;
import com.example.individualproject.Model.Moviemodel;
import com.example.individualproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BuyTicKetFragment extends Fragment  {

    FirebaseFirestore firebaseFirestore;
    NavController navController;
    TextView price,stime,sfomate;
    ImageView schari1, schari2, schari3,schari4,schari5,schari6;
    Button Time1, Time2, Time3, sfomate1, sfomate2, sfomate3, pay;

    BuyticketAdapter mAdapter;
    List<Moviemodel> moviemodelList = new ArrayList<>();

    int totalPrice = 0;
    int quantity = 0;
    int count=0,count1=0,count2=0,count3=0,count4=0,count5=0,tcount1=0,tcount2=0,tcount3=0,fcount1=0,fcount2=0,fcount3=0;
    int ticketprice=0;


    String selectfomate, name,selcttime,imageURL;
    String tostime1,tostime2,tostime3;
    String tosfomate1,tosfomate2,tosfomate3;


    public BuyTicKetFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_tic_ket, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);

        price=view.findViewById(R.id.totalprice);
        schari1=view.findViewById(R.id.chair1);
        schari2=view.findViewById(R.id.chair2);
        schari3=view.findViewById(R.id.chair3);
        schari4=view.findViewById(R.id.chair4);
        schari5=view.findViewById(R.id.chair5);
        schari6=view.findViewById(R.id.chair6);
        Time1=view.findViewById(R.id.stime1);
        Time2=view.findViewById(R.id.stime2);
        Time3=view.findViewById(R.id.stime3);
        sfomate1=view.findViewById(R.id.twod);
        sfomate2=view.findViewById(R.id.threed);
        sfomate3=view.findViewById(R.id.imax);
        pay=view.findViewById(R.id.topay);

        /*stime=view.findViewById(R.id.showtime);
        sfomate=view.findViewById(R.id.showfomate);*/



        ticketprice = BuyTicKetFragmentArgs.fromBundle(getArguments()).getTkprice();
        name=BuyTicKetFragmentArgs.fromBundle(getArguments()).getMoviebname();
        imageURL=BuyTicKetFragmentArgs.fromBundle(getArguments()).getImageURL();

        tostime1 = BuyTicKetFragmentArgs.fromBundle(getArguments()).getTime1();
        tostime2 = BuyTicKetFragmentArgs.fromBundle(getArguments()).getTime2();
        tostime3 = BuyTicKetFragmentArgs.fromBundle(getArguments()).getTime3();

        tosfomate1 =BuyTicKetFragmentArgs.fromBundle(getArguments()).getFomate1();
        tosfomate2 =BuyTicKetFragmentArgs.fromBundle(getArguments()).getFomate2();
        tosfomate3 =BuyTicKetFragmentArgs.fromBundle(getArguments()).getFomate3();




        //座位click時候反應

        schari1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                //採用奇偶數判斷加減以及更改數據
                if ( count % 2 == 0){
                    schari1.setImageResource(R.drawable.chari);
                    quantity--;
                    totalPrice=quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));
                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });
                }else {
                    schari1.setImageResource(R.drawable.chari2);
                    quantity++;

                    totalPrice = quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));

                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });




                }


            }
        });

        schari2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1++;

                if ( count1 % 2 == 0){
                    schari2.setImageResource(R.drawable.chari);
                    quantity--;
                    totalPrice=quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));
                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });
                }else {
                    schari2.setImageResource(R.drawable.chari2);
                    quantity++;

                    totalPrice = quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));

                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });



                }


            }
        });

        schari3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count2++;

                if ( count2 % 2 == 0){
                    schari3.setImageResource(R.drawable.chari);
                    quantity--;
                    totalPrice=quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));
                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });
                }else {
                    schari3.setImageResource(R.drawable.chari2);
                    quantity++;

                    totalPrice = quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));

                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });



                }

            }
        });

        schari4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count3++;

                if ( count3 % 2 == 0){
                    schari4.setImageResource(R.drawable.chari);
                    quantity--;
                    totalPrice=quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));
                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });
                }else {
                    schari4.setImageResource(R.drawable.chari2);
                    quantity++;

                    totalPrice = quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));

                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });



                }

            }


        });



        schari5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count4++;

                if ( count4 % 2 == 0){
                    schari5.setImageResource(R.drawable.chari);
                    quantity--;
                    totalPrice=quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));
                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });
                }else {
                    schari5.setImageResource(R.drawable.chari2);
                    quantity++;

                    totalPrice = quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));

                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });



                }

            }


        });


        schari6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count5++;

                if ( count5 % 2 == 0){
                    schari6.setImageResource(R.drawable.chari);
                    quantity--;
                    totalPrice=quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));
                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });
                }else {
                    schari6.setImageResource(R.drawable.chari2);
                    quantity++;

                    totalPrice = quantity*ticketprice;
                    price.setText(String.valueOf("$ "+ totalPrice));

                    firebaseFirestore.collection("allmovielist").document(name).update("quantity", quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });



                }

            }


        });


        Time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcount1++;
                //採用奇偶數判斷button變化
                if (tcount1 % 2 == 0){
                    Time1.setBackgroundResource(R.drawable.button_edge);




                }else {
                    Time1.setBackgroundResource(R.drawable.button_gradient);
                    selcttime=tostime1;

                    Time2.setBackgroundResource(R.drawable.button_edge);
                    Time3.setBackgroundResource(R.drawable.button_edge);
                    tcount2=0;
                    tcount3=0;
                }


            }
        });

        Time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcount2++;

                if (tcount2 % 2 == 0){
                    Time2.setBackgroundResource(R.drawable.button_edge);


                }else {
                    Time2.setBackgroundResource(R.drawable.button_gradient);
                    selcttime=tostime2;

                    Time1.setBackgroundResource(R.drawable.button_edge);
                    Time3.setBackgroundResource(R.drawable.button_edge);
                    tcount1=0;
                    tcount3=0;
                }


            }
        });


        Time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcount3++;

                if (tcount3 % 2 == 0){
                    Time3.setBackgroundResource(R.drawable.button_edge);


                }else {
                    Time3.setBackgroundResource(R.drawable.button_gradient);
                    selcttime=tostime3;
                    Time1.setBackgroundResource(R.drawable.button_edge);
                    Time2.setBackgroundResource(R.drawable.button_edge);
                    tcount1=0;
                    tcount2=0;
                }


            }
        });


        sfomate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcount1++;
                //採用奇偶數判斷button變化
                if (fcount1 % 2 ==0){
                    sfomate1.setBackgroundResource(R.drawable.button_edge);

                }else {
                    sfomate1.setBackgroundResource(R.drawable.button_gradient);
                    selectfomate=tosfomate1;

                    sfomate2.setBackgroundResource(R.drawable.button_edge);
                    sfomate3.setBackgroundResource(R.drawable.button_edge);
                    fcount2=0;
                    fcount3=0;


                }
            }
        });


        sfomate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcount2++;

                if (fcount2 % 2 ==0){
                    sfomate2.setBackgroundResource(R.drawable.button_edge);

                }else {
                    sfomate2.setBackgroundResource(R.drawable.button_gradient);
                    selectfomate=tosfomate2;
                    sfomate1.setBackgroundResource(R.drawable.button_edge);
                    sfomate3.setBackgroundResource(R.drawable.button_edge);
                    fcount1=0;
                    fcount3=0;



                }
            }
        });



        sfomate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcount3++;

                if (fcount3 % 2 ==0){
                    sfomate3.setBackgroundResource(R.drawable.button_edge);

                }else {
                    sfomate3.setBackgroundResource(R.drawable.button_gradient);
                    selectfomate=tosfomate3;
                    sfomate2.setBackgroundResource(R.drawable.button_edge);
                    sfomate1.setBackgroundResource(R.drawable.button_edge);
                    fcount1=0;
                    fcount2=0;




                }
            }
        });


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddToCart();

                //清除所有button按鈕
                sfomate2.setBackgroundResource(R.drawable.button_edge);
                sfomate1.setBackgroundResource(R.drawable.button_edge);
                sfomate3.setBackgroundResource(R.drawable.button_edge);
                fcount1=0;
                fcount2=0;
                fcount3=0;

                Time1.setBackgroundResource(R.drawable.button_edge);
                Time2.setBackgroundResource(R.drawable.button_edge);
                Time3.setBackgroundResource(R.drawable.button_edge);
                tcount1=0;
                tcount2=0;
                tcount3=0;

            }
        });







    }

    private void AddToCart(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("moviename", name);
        hashMap.put("quantity", quantity);
        hashMap.put("totalprice", totalPrice);
        hashMap.put("time", selcttime);
        hashMap.put("fomate", selectfomate);
        hashMap.put("imageURL", imageURL);

        //新增document為Cart在firebase 儲Cart資料
        firebaseFirestore.collection("Cart").document(name).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {



            }
        });


    }





}