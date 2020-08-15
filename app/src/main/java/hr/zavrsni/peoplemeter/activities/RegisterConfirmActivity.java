package hr.zavrsni.peoplemeter.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.models.ActivationUserModel;
import hr.zavrsni.peoplemeter.models.User;
import hr.zavrsni.peoplemeter.services.UserService;
import hr.zavrsni.peoplemeter.utils.Auth;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterConfirmActivity extends AppCompatActivity {

    EditText editTextCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_confirm);

        editTextCode = findViewById(R.id.editText_code);
        Button buttonRegister = findViewById(R.id.button_register_confirm_activity);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateAction();
            }
        });
    }

    private void activateAction() {
        final String username = getIntent().getStringExtra("username");
        final String password = getIntent().getStringExtra("password");
        final String code = editTextCode.getText().toString();

        Auth.setUser(new User(username, password));

        new UserService(this).enterCode(new ActivationUserModel(code), new VolleyResponseListener<User>() {
            @Override
            public void onResponse(User response) {
                Auth.setUser(response);
                Intent intent = new Intent(RegisterConfirmActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

}
