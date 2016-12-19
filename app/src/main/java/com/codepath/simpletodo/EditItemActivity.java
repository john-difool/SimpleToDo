package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private int position;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        populateVariables();
        EditText etName = (EditText) findViewById(R.id.etEditText2);
        etName.setText(text);
        etName.setSelection(etName.getText().length());
    }

    private void populateVariables() {
        text = getIntent().getStringExtra("text");
        position = getIntent().getIntExtra("cell", 0);
    }

    public void onSaveItem(View v) {
        EditText etName = (EditText) findViewById(R.id.etEditText2);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("text", etName.getText().toString());
        data.putExtra("cell", position); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }


}

