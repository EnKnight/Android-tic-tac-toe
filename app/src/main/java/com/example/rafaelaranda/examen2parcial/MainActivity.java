package com.example.rafaelaranda.examen2parcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private Intent intent;
  private Button jugarmp;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    jugarmp = (Button)findViewById(R.id.jugarmp);

    jugarmp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        intent = new Intent(MainActivity.this, MultiplayerActivity.class);
        startActivity(intent);
      }
    });
  }
}
