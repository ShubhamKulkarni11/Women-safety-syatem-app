package com.example111.womenssafetysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    public static final String Name="Name";
    public static final String UserContact = "UserContact";
    public static final String Contact1 = "Contact1";
    public static final String Contact2 = "Contact2";
    public static String Massage="Massage";
    private TextView help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        help=findViewById(R.id.massagehelp);

        String name1;
        String familyContact1;
        String familyContact2;
        String helpMassage;
        Intent i=getIntent();
        name1= i.getStringExtra(Name);
        familyContact1 = i.getStringExtra(Contact1);
        familyContact2 = i.getStringExtra(Contact2);
        helpMassage = i.getStringExtra(Massage);

        help.setText("Hey"+", "+name1+"\n\n"+"We have send your help massage to following contact"+"\n\n"+familyContact1+"\n"+familyContact2+"\n\n"+"Massage :"+helpMassage);


    }

}