package com.example.quizmaster;

import static com.example.quizmaster.SplashActivity.list;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    ProgressBar progressBar;
    AlertDialog.Builder builder;


    List<Modelclass> allQuestionList;
    Modelclass modelclass;
    int index = 0;
    int CorrectCount = 0;
    int WrongCount = 0;
    LinearLayout nextbtn;
    TextView card_question, card_optiona, card_optionb, card_optionc, card_optiond,ic_exit;
    CardView carda, cardb, cardc, cardd;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();

//        if(getIntent().getExtras() != null){
//            if(getIntent().hasExtra("LIST")){
//                allQuestionList = (List<Modelclass>) getIntent().getExtras().getSerializable("LIST");
//            }
//        }


        allQuestionList = list;
        Collections.shuffle(allQuestionList);
        modelclass = list.get(index);
/*
        setAllData();
*/
        carda.setBackgroundColor(getResources().getColor(R.color.white));
        cardb.setBackgroundColor(getResources().getColor(R.color.white));
        cardc.setBackgroundColor(getResources().getColor(R.color.white));
        cardd.setBackgroundColor(getResources().getColor(R.color.white));

        nextbtn.setClickable(false);

/*
        private void starttimer() {
            countDownTimer = new CountDownTimer(20000, 1000) {
                @Override
                public void onTick(long l) {
                    timerValue = timerValue - 1;
                    progressBar.setProgress(timerValue);
                }

                @Override
                public void onFinish() {
                    Dialog dialog = new Dialog(DashboardActivity.this);
                    dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                    dialog.setContentView(R.layout.time_out_dialog);

                    dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                            startActivity(intent);

                        }
                    });

                    dialog.show();
                }
            }.start();
            setAllData();
        }
*/
        setAllData();
        stoptimer();


    }

    private void setAllData() {
        card_question.setText(modelclass.getQuestion());
        card_optiona.setText(modelclass.getoA());
        card_optionb.setText(modelclass.getoB());
        card_optionc.setText(modelclass.getoC());
        card_optiond.setText(modelclass.getoD());

    }



    private void Hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        card_question = findViewById(R.id.card_question);
        card_optiona = findViewById(R.id.card_optiona);
        card_optionb = findViewById(R.id.card_optionb);
        card_optionc = findViewById(R.id.card_optionc);
        card_optiond = findViewById(R.id.card_optiond);

        carda = findViewById(R.id.carda);
        cardb = findViewById(R.id.cardb);
        cardc = findViewById(R.id.cardc);
        cardd = findViewById(R.id.cardd);


        nextbtn = findViewById(R.id.nextbtn);
        ic_exit=findViewById(R.id.ic_exit);
        builder = new AlertDialog.Builder(this);

        ic_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Alert!!")
                        .setMessage("Do you want to close the app?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();


            }
        });
        ic_back=findViewById(R.id.ic_back);
        builder = new AlertDialog.Builder(this);
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Alert!!")
                        .setMessage("You cannot go back once you submit")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })

                        .show();


            }
        });



    }



    public void Correct(CardView cardView) {
        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CorrectCount++;
                index++;
                modelclass = list.get(index);
                resetcolor();
                setAllData();
                enableButton();
                stoptimer();

            }
        });

    }

    private void stoptimer() {
        timerValue = 20;
        progressBar.setProgress(0);
        if (countDownTimer != null)
            countDownTimer.cancel();
//        progressBar.setProgress(1000);
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                Log.e("Tick >> ", timerValue + "");
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                });

                dialog.show();
            }
        }.start();

    }


    public void Wrong(CardView cardView) {

        cardView.setCardBackgroundColor(getResources().getColor(R.color.red1));

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WrongCount++;
                if (index < list.size() - 1) {
                    index++;
                    modelclass = list.get(index);

                    resetcolor();
                    setAllData();
                    enableButton();
                    stoptimer();


                } else {
                    GameWon();
                }
            }
        });

    }

    private void GameWon() {

        Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
        intent.putExtra("correct", CorrectCount);
        intent.putExtra("wrong", WrongCount);
        startActivity(intent);
    }

    public void enableButton() {
        carda.setClickable(true);
        cardb.setClickable(true);
        cardc.setClickable(true);
        cardd.setClickable(true);


    }

    public void disableButton() {
        carda.setClickable(false);
        cardb.setClickable(false);
        cardc.setClickable(false);
        cardd.setClickable(false);


    }

    public void resetcolor() {
        carda.setBackgroundColor(getResources().getColor(R.color.white));
        cardb.setBackgroundColor(getResources().getColor(R.color.white));
        cardc.setBackgroundColor(getResources().getColor(R.color.white));
        cardd.setBackgroundColor(getResources().getColor(R.color.white));


    }

    public void OptionAClick(View view) {
        disableButton();

        if (modelclass.getoA().equals(modelclass.getAns())) {
            carda.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(carda);

            } else {
                GameWon();
            }

        } else {
            carda.setBackgroundColor(getResources().getColor(R.color.green));

            Wrong(carda);
        }
    }

    public void OptionBClick(View view) {
        disableButton();


        if (modelclass.getoB().equals(modelclass.getAns())) {
            cardb.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(cardb);

            } else {
                GameWon();
            }

        } else {
            cardb.setBackgroundColor(getResources().getColor(R.color.green));

            Wrong(cardb);
        }

    }

    public void OptionCClick(View view) {
        disableButton();

        if (modelclass.getoC().equals(modelclass.getAns())) {
            cardc.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(cardc);

            } else {
                GameWon();
            }

        } else {
            cardc.setBackgroundColor(getResources().getColor(R.color.green));

            Wrong(cardc);
        }

    }

    public void OptionDClick(View view) {
        disableButton();

        if (modelclass.getoD().equals(modelclass.getAns())) {
            cardd.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < list.size() - 1) {
                Correct(cardd);

            } else {
                GameWon();
            }

        } else {
            cardd.setBackgroundColor(getResources().getColor(R.color.green));

            Wrong(cardd);
        }

    }
}