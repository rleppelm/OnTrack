package capstone.ontrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createAccount(View view) {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void verifyAccount(View view) {
        Boolean error = false;
        EditText email = (EditText)findViewById(R.id.loginEmail);
        EditText password = (EditText)findViewById(R.id.loginPassword);
        if (email.getText().toString().trim().equalsIgnoreCase("")) {
            email.setError("Enter email");
            error = true;
        }
        if (password.getText().toString().trim().equalsIgnoreCase("")) {
            password.setError("Enter password");
            error = true;
        }
        if(error == false){
            socketHandler socket = new socketHandler(email.getText().toString());
            socket.execute();
            socket = new socketHandler(password.getText().toString());
            socket.execute();

            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        }
    }
}
