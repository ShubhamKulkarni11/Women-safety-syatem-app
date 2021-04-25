package com.example111.womenssafetysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;





// Djekstra's Algorithm


    public class StartJourney extends AppCompatActivity {

        public static final String NAME = "NAME";
        public static final String UserContact = "UserContact";
        public static final String Contact1 = "Contact1";
        public static final String Contact2 = "Contact2";
        public static final String Source = "Source";
        public static final String Destination = "Destination";
        public static final String Massage = "Massage";
        public static String dist = "dist";
        public static String loc = "loc";
        public static String Dest="Dest";
        public static String Root="Root";
        public TextView distance;
        public TextView location2;
        public Button reached;
        public Button emergancy;
        int n = 0;
        String name1;
        String userContact;
        String familyContact1;
        String familyContact2;
        String helpMassage;
        String source1;
        String destination1;
        int destNum;
        Node root=MainActivity.root;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_start_journey);
            Intent i = getIntent();
            name1 = i.getStringExtra(NAME);
            userContact = i.getStringExtra(UserContact);
            familyContact1 = i.getStringExtra(Contact1);
            familyContact2 = i.getStringExtra(Contact2);
            helpMassage = i.getStringExtra(Massage);
            source1 = i.getStringExtra(Source);
            destination1 = i.getStringExtra(Destination);
            source1 = source1.toLowerCase();
            destination1 = destination1.toLowerCase();
            String dist1 = i.getStringExtra(dist);
            int[] loc1 = i.getIntArrayExtra(loc);
            location2=findViewById(R.id.location);
            emergancy=findViewById(R.id.emergancy);




            HashMap<Integer, String> locations = new HashMap<>();
            locations.put(0, "navi peth");
            locations.put(1, "katraj");
            locations.put(2, "bharatividyapith");
            locations.put(3, "kondhva");
            locations.put(4, "bibwewadi");
            locations.put(5, "sahkarnagar");
            locations.put(6, "swarget");
            locations.put(7, "appa balvant chauk");
            locations.put(8, "hadapsar");
            locations.put(9, "gangadham");
            locations.put(10, "vimamnagar");
            locations.put(11, "nanded");
            locations.put(12, "kothrud");
            locations.put(13, "kasba peth");
            locations.put(14, "ravivar peth");
            locations.put(15, "shukravar peth");
            locations.put(16, "budhvar peth");
            locations.put(17, "guruvar peth");
            locations.put(18, "mangalvar peth");
            locations.put(19, "shanivar peth");
            locations.put(20, "sadashiv peth");
            locations.put(21, "ganesh peth");
            locations.put(22, "narayan peth");
            locations.put(23, "rasta peth");


            HashMap<String,Integer> locations1 = new HashMap<>();
            locations1.put("navi peth", 0);
            locations1.put("katraj",1);
            locations1.put("bharatividyapith",2);
            locations1.put("kondhva",3);
            locations1.put("bibwewadi",4);
            locations1.put("sahkarnagar",5);
            locations1.put("swarget",6);
            locations1.put("appa balvant chauk",7);
            locations1.put("hadapsar",8);
            locations1.put("gangadham",9);
            locations1.put("vimamnagar",10);
            locations1.put("nanded",11);
            locations1.put("kothrud",12);
            locations1.put("kasba peth",13);
            locations1.put("ravivar peth",14);
            locations1.put("shukravar peth",15);
            locations1.put("budhvar peth",16);
            locations1.put("guruvar peth",17);
            locations1.put("mangalvar peth",18);
            locations1.put("shanivar peth",19);
            locations1.put("sadashiv peth",20);
            locations1.put("ganesh peth",21);
            locations1.put("narayan peth",22);
            locations1.put("rasta peth",23);






            distance = findViewById(R.id.about);
            reached = findViewById(R.id.dist);
                    destNum=locations1.get(destination1);

            //distance.setText(dist1);

            emergancy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i =new Intent(StartJourney.this,Contact.class);
                    i.putExtra(Contact.Name,name1);
                    i.putExtra(Contact.Contact1,familyContact1);
                    i.putExtra(Contact.Contact2,familyContact2);
                    i.putExtra(Contact.Massage,helpMassage);
                    startActivity(i);

                }
            });

            reached.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {




                    Node root1=nextValue();

                        String name = root1.location;
                        String publicPlaces = root1.publicPlaces.toLowerCase();
                        String transport = root1.transportation;
                        String about = root1.about;
                        location2.setText(name);
                        distance.setText("\n\n"+publicPlaces+"\n\n"+transport+"\n\n"+about);





                }


                 Node nextValue() {
                    Node ss = Bst.searchNode(root,loc1[n]);
                    if (n==destNum){
                        startActivity(new Intent(StartJourney.this,Destination.class));
                    }
                    n = n + 1;

                    return ss;

                }

            });

        }


    }

