package hr.zavrsni.peoplemeter.activities;

import androidx.appcompat.app.AppCompatActivity;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.models.User;
import hr.zavrsni.peoplemeter.services.UserService;
import hr.zavrsni.peoplemeter.utils.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextUsername = findViewById(R.id.editText_login_username);
        final EditText editTextPassword = findViewById(R.id.editText_login_password);

        final Button buttonLogin = findViewById(R.id.button_login);
        final Button buttonRegister = findViewById(R.id.button_register);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if(username.isEmpty() || password.isEmpty())
                    Toast.makeText(MainActivity.this, getString(R.string.enter_cred_login), Toast.LENGTH_LONG).show();

                User user = new User(username, password);
                Auth.setUser(user);

                Intent intent = new Intent(MainActivity.this, ChannelListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}
