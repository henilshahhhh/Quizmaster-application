package com.example.quizmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

   public static ArrayList<Modelclass> list;

/*
   DatabaseReference databaseReference;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list=new ArrayList<>();

        list.add(new Modelclass("The ratio of width of our National flag to its length is:","3:5","2:3","3:4","2:4","2:3"));
        list.add(new Modelclass("The words 'Satyameva Jayate' inscribed below the base plate of the emblem of India are taken from","Rigveda","Satpath Brahmana","Mundak Upanishad","Ramayana","Mundak Upanishad"));
        list.add(new Modelclass("Which of the following folk dance forms is associated with Gujarat?","Nautanki","Garba","Kathakali","Bhangra","Garba"));
        list.add(new Modelclass("The Rath Yatra at Puri is celebrated in honour of which Hindu deity","Ram","Jaganath","Shiva","Vishnu","Jaganath"));
        list.add(new Modelclass("The book of Parsis is","Torah","Bible","Zend Avesta","Gita","Zend Avesta"));
        list.add(new Modelclass("'Kathakali' is a folk dance prevalent in which state?","Karnataka","Orissa","Manipur","Kerala","Kerala"));
        list.add(new Modelclass("'Madhubani', a style of folk paintings, is popular in which of the following states in India?","Uttar Pradesh","Rajasthan","Madhya Pradesh","Bihar","Bihar"));
        list.add(new Modelclass("The National Song of India was composed by","Rabindranath Tagore","Bankim Chandra Chatterji","Iqbal","Jai Shankar Prasad","Bankim Chandra Chatterji"));
        list.add(new Modelclass("Which of the following places is famous for Chikankari work, which is a traditional art of embroidery?","Lucknow","Hyderabad","Jaipur","Mysore","Lucknow"));
        list.add(new Modelclass("Which e-learning platform has been featured in Time Magazine's 2021 list of 100 most influential companies?","BYJU's","Edukart","Unacademy","Toppr","BYJU's"));
        list.add(new Modelclass("Which organisation has launched the CollabCAD software to provide a total engineering solution for students?","National Informatics Centre","CBSE","HSC","Both A and B","Both A and B"));
        list.add(new Modelclass("Anti COVID Drug 2-DG has been developed by which organization?","DRDO","ISRO","CDIR","DGCI","DRDO"));
        list.add(new Modelclass("Which education board has launched the mobile application 'Dost for Life'?","ICSE Board","CBSE Board","Open Board","All of above","CBSE Board"));
        list.add(new Modelclass("Which company has partnered with the Indian government to roll out a vaccine finder tool on its mobile app in India to get vaccinated?","Google","Microsoft","Amazon","Facebook","Facebook"));
        list.add(new Modelclass("What is the name of the Worlds 1st Artificial Intelligence Ship?","Sunflower 40","Earth 2030","Mayflower 400","Seafarer 66","Mayflower 400"));
        list.add(new Modelclass("Which IIT has transformed an existing Nitrogen Plant into an Oxygen Generator?","IIT Bombay","IIT Kharagpur","IIT Madras","IIT Kanpur","IIT Bombay"));
        list.add(new Modelclass("Microsoft has opened its new IDC facility in which city?","Faridabad","Mumbai","Surat","Noida","Noida"));
        list.add(new Modelclass("Which telecom company has become the first one in India to demonstrate the operation of the 5G network?","Reliance Jio","Airtel","Vi","BSNL","Airtel"));
        list.add(new Modelclass("Which company has completed the acquisition of smart wearable company Fitbit?","Hike","Facebook","Google","Flipkart","Google"));
        list.add(new Modelclass("What is the name of India's first social media app named launched by Vice President Venkiah Naidu?","Milap","Chatmat","Elyments","Connect","Elyments"));

/*
        databaseReference= FirebaseDatabase.getInstance().getReference("Question");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("DATA", snapshot.exists() +"");
                Log.e("DATA", snapshot.exists() +"");
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Modelclass modelclass=dataSnapshot.getValue(Modelclass.class);
                    list.add(modelclass);
                }
                Intent intent = new Intent(SplashActivity.this,DashboardActivity.class);
                intent.putExtra("LIST", list);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

*/





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(SplashActivity.this,DashboardActivity.class);
                startActivity(intent);
/*
                findViewById(R.id.ic_exit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                        builder.setTitle("Exit");
                        builder.setMessage("Are you sure you want to exit?");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.create().show();

                    }
                });
*/                  new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                },500);






            }
        },1500);
    }


}