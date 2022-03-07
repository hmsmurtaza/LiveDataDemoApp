package com.example.livedatademoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameTextView = findViewById(R.id.nameTextView);

        // Get the ViewModel.
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // Create the Observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String name) {
                nameTextView.setText(name);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer
        mainActivityViewModel.getCurrentName().observe(this, nameObserver);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anotherName = "Hadi Murtaza";
                mainActivityViewModel.getCurrentName().setValue(anotherName);
            }
        });
    }
}