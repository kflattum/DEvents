package edu.dartmouth.devents;

/**
 * Created by kathrynflattum on 2/19/18.
 * Based on code provided by XD for firebasedemo
 */

import android.content.Context;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class AuthOnCompleteListener implements OnCompleteListener {
    Context context;
    public AuthOnCompleteListener(Context context){
        this.context = context;
    }

    public void onComplete(Task task){
        if(task.isSuccessful())
            Utilities.showActivity(context, MainActivity.class);
        else
            Utilities.showLogInDialog(context, "Error!", task.getException().getMessage());
    }
}
