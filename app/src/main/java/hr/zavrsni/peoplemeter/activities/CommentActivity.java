package hr.zavrsni.peoplemeter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.models.Feedback;
import hr.zavrsni.peoplemeter.models.Schedule;
import hr.zavrsni.peoplemeter.services.ProgramService;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;

public class CommentActivity extends AppCompatActivity {

    public static final String KEY_BUNDLE_SCHEDULE = "SCHEDULE";

    private Schedule schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            schedule = (Schedule)getIntent().getSerializableExtra(KEY_BUNDLE_SCHEDULE);
        }
        TextView commentTextView = findViewById(R.id.textView_comment_program);
        final EditText commentTitleEditText = findViewById(R.id.editText_comment_title);
        final EditText commentDescriptionEditText = findViewById(R.id.editText_comment_description);

        final Button submitButton = findViewById(R.id.button_submit_comment);

        commentTextView.setText(String.format("%s %s", commentTextView.getText(), schedule.getProgram().getTitle()));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Feedback feedback = new Feedback(commentTitleEditText.getText().toString(), commentDescriptionEditText.getText().toString());
                new ProgramService(CommentActivity.this).postFeedback(schedule.getProgram().getId(), feedback, new VolleyResponseListener<Feedback>() {
                    @Override
                    public void onResponse(Feedback response) {
                        Toast.makeText(CommentActivity.this, getString(R.string.feedback_success), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(CommentActivity.this, ChannelListActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
