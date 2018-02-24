package edu.dartmouth.devents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check for a logged in user
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //if user isn't logged in, go to log in window
        if(firebaseUser == null)
            Utilities.showActivity(this, LogInActivity.class);
        else{
            userID = firebaseUser.getUid();
            databaseReference = databaseReference.child("users").child(userID).child("items");
            //databaseReference.addChildEventListener(new ListViewChildEventListener(adapter));
        }
    }
}
