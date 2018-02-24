package edu.dartmouth.devents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/*
*Code provided by XD for firebase demo
 */

public class SignUpActivity extends AppCompatActivity implements Button.OnClickListener{
    private EditText passwordEditText;
    private EditText emailEditText;
    private Button signUpButton;
    private FirebaseAuth firebaseAuth;
    private Task<AuthResult> task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        passwordEditText = (EditText)findViewById(R.id.passwordField);
        emailEditText = (EditText)findViewById(R.id.emailField);
        signUpButton = (Button)findViewById(R.id.signupButton);
        signUpButton.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onClick(View view){
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        if(email.isEmpty() || password.isEmpty())
            Utilities.showLogInDialog(this, "Error!",
                    "Please make sure you enter a valid email address and password");
        else{
            task = firebaseAuth.createUserWithEmailAndPassword(email, password);
            task.addOnCompleteListener(new AuthOnCompleteListener(this));
        }
    }

}


