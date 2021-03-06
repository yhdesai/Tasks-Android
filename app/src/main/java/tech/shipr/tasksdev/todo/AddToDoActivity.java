package tech.shipr.tasksdev.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tech.shipr.tasksdev.R;

public class AddToDoActivity extends AppCompatActivity {

    private static final int DEFAULT_MSG_LENGTH_LIMIT = 100;
    private DatabaseReference mMessagesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do_acitivty);


        final EditText mToDoEditText = findViewById(R.id.editNameToDo);
        final Button mSendButton = findViewById(R.id.submitButton);

        // Firebase instance variable
        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
        String uid = mFirebaseAuth.getUid();

        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("todo/" + uid);

        // Enable Send button when there's text to send


        mToDoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() > 0) {
                    mSendButton.setEnabled(true);
                } else {
                    mSendButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mToDoEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});

        // Send button sends a message and clears the EditText
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DeveloperToDo friendlyMessage = new DeveloperToDo(mToDoEditText.getText().toString());
                mMessagesDatabaseReference.push().setValue(friendlyMessage); // TODO: 4/10/19 Make it use the old key

                // Clear input box
                mToDoEditText.setText("");
                finish();
            }
        });
    }


}