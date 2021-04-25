package com.example111.womenssafetysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public TextView name;
    public TextView user_contact;
    public TextView contact1;
    public TextView contact2;
    public TextView massage;
    public AutoCompleteTextView source;
    public AutoCompleteTextView destination;
    public Button startJourney;
    String name1;
    String userContact;
    String familyContact1;
    String familyContact2;
    String helpMassage;
    String source1;
    String destination1;
   static Node root=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.userName);
        user_contact = findViewById(R.id.userContact);
        contact1 = findViewById(R.id.contact1);
        contact2 = findViewById(R.id.contact2);
        massage = findViewById(R.id.massage);
        source = findViewById(R.id.startLocation);
        destination = findViewById(R.id.destination);
        startJourney = findViewById(R.id.startJourney);


        

        startJourney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = name.getText().toString();
                userContact=user_contact.getText().toString();
                familyContact1=contact1.getText().toString();
                familyContact2=contact2.getText().toString();
                helpMassage= massage.getText().toString();
                source1=source.getText().toString();
                destination1=destination.getText().toString();
                if(TextUtils.isEmpty(name1)){
                    Toast.makeText(MainActivity.this, "Please Enter the name", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(userContact)){
                    Toast.makeText(MainActivity.this, "Please Enter the Your Contact Number", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(familyContact1)){
                    Toast.makeText(MainActivity.this, "Please Enter the Family Contact Number", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(familyContact2)){
                    Toast.makeText(MainActivity.this, "Please Enter the Family Contact Number", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(helpMassage)){
                    Toast.makeText(MainActivity.this, "Please Enter the Help Massage", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(source1)){
                    Toast.makeText(MainActivity.this, "Please Enter the Starting Location", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(destination1)){
                    Toast.makeText(MainActivity.this, "Please Enter the Destination", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Happy Journey", Toast.LENGTH_SHORT).show();
                  Intent i=  new Intent(MainActivity.this, StartJourney.class);
                  i.putExtra(StartJourney.NAME,name1);
                    i.putExtra(StartJourney.UserContact,userContact);
                    i.putExtra(StartJourney.Contact1,familyContact1);
                    i.putExtra(StartJourney.Contact2,familyContact2);
                    i.putExtra(StartJourney.Source,source1);
                    i.putExtra(StartJourney.Destination,destination1);
                    i.putExtra(StartJourney.Massage,helpMassage);




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

                    int source2 = locations1.get(source1);
                    int destination2 = locations1.get(destination1);

                    int[][] arr = {{0,3,5,0,9,0,0,8,4,9,0,1,3,5,0,2,9,0,0,8,2,7,1,7},
                            {0,0,0,8,6,0,5,6,0,2,0,8,0,6,4,0,0,0,5,2,6,0,6,5},
                            {1,0,0,6,9,0,2,0,0,6,3,1,0,2,0,3,1,0,0,6,0,6,9,1},
                            {2,8,1,0,0,8,0,6,0,1,0,0,0,4,6,2,0,2,0,1,0,2,9,0},
                            {8,3,5,8,0,0,4,0,8,0,1,0,0,5,0,2,0,0,1,4,6,0,0,3},
                            {6,1,3,2,0,0,8,0,4,0,2,8,5,6,0,0,2,0,7,0,0,3,1,0},
                            {5,8,2,2,0,0,0,3,5,0,1,0,0,0,6,1,4,0,2,0,0,4,0,4},
                            {2,0,3,0,4,0,1,0,0,6,4,1,0,2,0,7,0,2,0,4,6,0,0,5},
                            {0,3,5,0,5,0,4,0,0,3,1,2,1,0,0,2,4,0,0,2,0,0,2,7},
                            {7,8,6,4,0,0,6,9,1,0,0,0,4,0,2,1,3,0,4,0,5,2,0,0},
                            {0,4,2,0,2,0,0,4,0,0,0,2,4,6,0,0,4,5,3,4,3,6,0,0},
                            {4,0,1,2,3,0,0,4,0,3,0,0,4,0,1,4,0,2,3,4,0,5,0,1},
                            {0,1,0,2,1,3,6,0,0,0,3,0,0,3,0,4,0,4,2,0,0,2,0,4},
                            {3,2,0,0,6,4,0,0,3,2,0,1,0,0,8,0,3,6,5,0,5,0,1,0},
                            {3,0,0,0,6,0,2,3,0,0,5,0,2,3,0,0,4,1,0,4,0,0,4,6},
                            {0,1,0,5,0,6,0,2,0,1,0,0,0,4,0,0,0,0,3,6,4,0,6,0},
                            {0,6,4,0,0,1,0,0,6,4,0,6,5,2,0,0,0,2,1,3,6,0,0,4},
                            {1,0,4,0,0,5,3,0,3,0,0,2,3,0,1,0,1,0,6,0,4,2,0,0},
                            {0,0,5,2,0,0,1,0,2,0,0,8,2,0,4,0,4,2,0,3,0,4,0,3},
                            {6,0,1,0,3,0,0,2,4,0,2,3,0,5,6,4,0,0,2,0,6,0,0,2},
                            {0,3,0,0,1,0,0,6,4,4,0,7,0,2,1,3,0,0,0,2,0,5,4,5},
                            {1,6,0,0,4,3,0,6,0,0,1,2,3,4,0,8,0,0,5,2,0,0,6,7},
                            {0,0,8,0,1,0,0,4,7,0,6,0,5,0,4,1,3,0,4,0,0,6,0,5},
                            {1,0,2,0,3,7,0,0,6,5,5,0,4,0,1,0,0,0,2,0,4,2,0,0},};
                   int [] loc=new int[24];
                    Integer dist1=Dijesktra.dijkstra(arr,loc,source2,destination2);
                    i.putExtra(StartJourney.dist,dist1.toString());
                    i.putExtra(StartJourney.loc,loc);




                    root=Bst.insertNode(root,11,"nanded","very less transportation services like bus/taxy, no police station","Bus stand","Very deserted area be alert.");
                    root=Bst.insertNode(root,15,"Shukravar Peth","not much transport services available like bus/taxy","Bus stand, few public shops, Shukravar police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,16,"budhvar peth","not much transport services available like bus/taxy","Bus stand, few public shops, Budhvar police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,21,"ganesh peth","bus/taxy stand and many other public places available","Bus stand, hostels, Ganesh police station, tempels ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,22,"narayan peth","bus/taxy stand and many other public places available","Bus stand, hostels, Narayan police station ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,10,"vimamnagar","very less transportation services like bus/taxy, no police station","Bus stand","Very deserted area be alert.");
                    root=Bst.insertNode(root,9,"gangadham","very less transportation services like bus/taxy, no police station","Bus stand","Very deserted area be alert.");
                    root=Bst.insertNode(root,4,"bibwewadi","not much transport services available like bus/taxy","Bus stand, few public shops, Bibwewadi police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,19,"shanivar peth","bus stand and many other public places available","Bus stand hostels nanded city police station ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,1,"katraj","bus/taxy stand and many other public places available","Bus stand, hostels, Katraj police station, late night shops ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,23,"rasta peth","not much transport services available like bus/taxy","Bus stand, few public shops, Rasta police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,7,"appa balvant chauk","bus/taxy stand and many other public places available","Bus stand, hostels, ABC police station, shops ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,0,"navi peth","bus/taxy stand and many other public places available","Bus stand, hostels, navi police station ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,6,"swarget","many bus/taxy stand and many other public places available","Bus stand, hostels, Swarget police station ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,3,"kondhva","not much transport services available like bus/taxy","Bus stand, few public shops, Kondhva police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,17,"guruvar peth","not much transport services available like bus/taxy","Bus stand, few public shops, Guruvar police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,14,"ravivar peth","not much transport services available like bus/taxy","Bus stand, few public shops, Ravivar police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,2,"bharatividyapith","bus/taxy stand and many other public places available","Bus stand, hostels, Bharti Vidyapith police station ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,5,"sahkarnagar","very less transportation services like bus/taxy, no police station","Bus stand","Very deserted area be alert.");
                    root=Bst.insertNode(root,18,"mangalvar peth","not much transport services available like bus/taxy","Bus stand, few public shops, Mangalvar police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,8,"hadapsar","very less transportation services like bus/taxy, no police station","Bus stand","Very deserted area be alert.");
                    root=Bst.insertNode(root,20,"sadashiv peth","bus/taxy stand and many other public places available","Bus stand, public attractions, hostels, Sadshiv police station ","This ia a crowed places dont worry");
                    root=Bst.insertNode(root,12,"kothrud","not much transport services available like bus/taxy","Bus stand, few public shops, Kothrud police station ","This is mildly crowded area be aware.");
                    root=Bst.insertNode(root,13,"kasba peth","bus/taxy stand and many other public places available","Bus stand, public attractions, hostels, nanded city police station ","This ia a crowed places dont worry");
                    startActivity(i);
                }

            }
        });

        final String []locationList = new String[]{"katraj","bharatividyapith","kondhva","bibwewadi","sahkarnagar","swarget",
                "appa balvant chauk","hadapsar","vimamnagar","gangadham","nanded",
                "kothrud","kasba peth","ravivar peth","shukravar peth","budhvar peth","guruvar peth",
                "mangalvar peth","shanivar peth","sadashiv peth","ganesh peth","narayan peth","rasta peth","navi peth","katraj"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,locationList);
        source.setAdapter(adapter);
        destination.setAdapter(adapter);
        source.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                    source.showDropDown();
            }
        });

        destination.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                destination.showDropDown();
            }
        });



    }
}