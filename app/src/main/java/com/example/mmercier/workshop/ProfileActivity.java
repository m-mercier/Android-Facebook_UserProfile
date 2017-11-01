package com.example.mmercier.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("lastname");
        String email = intent.getStringExtra("email");
        String birthday = intent.getStringExtra("birthday");
        String gender = intent.getStringExtra("gender");

        TextView nameView = (TextView) findViewById(R.id.name_surname);
        TextView emailView = (TextView) findViewById(R.id.text_email);
        TextView birthdayView = (TextView) findViewById(R.id.text_birthday);
        TextView genderView = (TextView) findViewById(R.id.text_gender);

        nameView.setText(" " + name + " " + surname);
        emailView.setText(email);
        birthdayView.setText(birthday);
        genderView.setText(gender);

        ProfilePictureView profilePicture = (ProfilePictureView) findViewById(R.id.profilePicture);
        profilePicture.setProfileId(userID);

        Button logout = (Button)findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

        private void logout() {
            LoginManager.getInstance().logOut();
            Intent login = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(login);
            finish();
        }

}
