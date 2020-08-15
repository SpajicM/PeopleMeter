package hr.zavrsni.peoplemeter.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.models.Channel;
import hr.zavrsni.peoplemeter.models.User;
import hr.zavrsni.peoplemeter.services.UserService;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextSurname;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    EditText editTextPhone;
    EditText editTextEmail;
    EditText editTextUsername;
    Button buttonRegister;

    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextWatcher mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                buttonRegister.setEnabled(validate());
            }
        };

        editTextName = findViewById(R.id.editText_name);
        editTextSurname = findViewById(R.id.editText_surname);
        editTextPassword = findViewById(R.id.editText_password);
        editTextConfirmPassword = findViewById(R.id.editText_password_confirm);
        editTextEmail = findViewById(R.id.editText_email);
        editTextPhone = findViewById(R.id.editText_phone);
        editTextUsername = findViewById(R.id.editText_username);

        editTextName.addTextChangedListener(mTextWatcher);
        editTextSurname.addTextChangedListener(mTextWatcher);
        editTextPassword.addTextChangedListener(mTextWatcher);
        editTextConfirmPassword.addTextChangedListener(mTextWatcher);
        editTextEmail.addTextChangedListener(mTextWatcher);
        editTextPhone.addTextChangedListener(mTextWatcher);
        editTextUsername.addTextChangedListener(mTextWatcher);

        userService = new UserService(this);

        buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setEnabled(validate());
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAction();
            }
        });
    }

    private void registerAction() {
            String name = editTextName.getText().toString();
            String surname = editTextSurname.getText().toString();
            String password = editTextPassword.getText().toString();
            String phone = editTextPhone.getText().toString();
            String username = editTextUsername.getText().toString();
            String email = editTextEmail.getText().toString();

            final User user = new User(name, surname, password, username, email, phone);

            userService.register(user, new VolleyResponseListener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("", response);
                    Intent intent = new Intent(RegisterActivity.this, RegisterConfirmActivity.class);
                    intent.putExtra("username", user.getUsername());
                    intent.putExtra("password", user.getPassword());

                    startActivity(intent);
                }
            });
        }

    private boolean validate() {
        if (editTextName.getText().toString().isEmpty())
            return false;

        if (editTextSurname.getText().toString().isEmpty())
            return false;

        if (editTextUsername.getText().toString().isEmpty())
            return false;

        if (editTextPassword.getText().toString().isEmpty())
            return false;

        if (editTextConfirmPassword.getText().toString().isEmpty())
            return false;

        if(!editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString()))
            return false;

        if (editTextEmail.getText().toString().isEmpty())
            return false;

        if (editTextPhone.getText().toString().isEmpty())
            return false;

        return true;
    }
}
