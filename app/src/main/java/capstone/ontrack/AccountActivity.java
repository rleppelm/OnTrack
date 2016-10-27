package capstone.ontrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.EditText;


public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void newAccount(View view) {
        Boolean error = false;
        EditText first = (EditText)findViewById(R.id.firstName);
        EditText last = (EditText)findViewById(R.id.lastName);
        EditText email = (EditText)findViewById(R.id.email);
        EditText password1 = (EditText)findViewById(R.id.password);
        EditText password2 = (EditText)findViewById(R.id.repeatPassword);


        if (first.getText().toString().trim().equalsIgnoreCase("")) {
            first.setError("Enter First Name");
            error = true;
        }
        if (last.getText().toString().trim().equalsIgnoreCase("")) {
            last.setError("Enter Last Name");
            error = true;
        }
        if (email.getText().toString().trim().equalsIgnoreCase("")) {
            email.setError("Enter Email");
            error = true;
        }
        if (password1.getText().toString().trim().equalsIgnoreCase("")) {
            password1.setError("Enter Password");
            error = true;
        }
        if (password2.getText().toString().trim().equalsIgnoreCase("")) {
            password2.setError("Repeat Password");
            error = true;
        }

        if(error == false){
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        }
    }


}
