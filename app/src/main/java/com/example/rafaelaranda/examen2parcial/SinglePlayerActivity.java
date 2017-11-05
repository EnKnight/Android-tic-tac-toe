package com.example.rafaelaranda.examen2parcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SinglePlayerActivity extends AppCompatActivity {

  private ImageView iv[] = new ImageView[9], gameOver;
  private Button restart;
  public static boolean used[] = new boolean[9], winner;
  public static byte turn;
  public static  byte symbol [][] = new byte[3][3];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multiplayer);

    for(byte i=0; i<9; i++){
      used[i] = false;
    }

    for(byte i=0; i<3; i++){
      for(byte j=0; j<3; j++){
        symbol[i][j] = 0;
      }
    }

    turn = 0;
    winner = false;

    restart = (Button)findViewById(R.id.restart);
    gameOver = (ImageView)findViewById(R.id.gameOver);

    iv[0] = (ImageView)findViewById(R.id.boton1);
    iv[1] = (ImageView)findViewById(R.id.boton2);
    iv[2] = (ImageView)findViewById(R.id.boton3);
    iv[3] = (ImageView)findViewById(R.id.boton4);
    iv[4] = (ImageView)findViewById(R.id.boton5);
    iv[5] = (ImageView)findViewById(R.id.boton6);
    iv[6] = (ImageView)findViewById(R.id.boton7);
    iv[7] = (ImageView)findViewById(R.id.boton8);
    iv[8] = (ImageView)findViewById(R.id.boton9);

    restart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        for(byte i=0; i<9; i++){
          iv[i].setImageResource(R.drawable.empty);
          used[i] = false;
        }

        for(byte i=0; i<3; i++){
          for(byte j=0; j<3; j++){
            symbol[i][j] = 0;
          }
        }
        gameOver.setImageResource(R.drawable.empty);
        turn = 0;
        winner = false;
      }
    });

    iv[0].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[0] && !winner) {
          iv[0].setImageResource(R.drawable.circle);
          symbol[0][0] = 1;
          turn++;
          used[0] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
    iv[1].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (!used[1] && !winner) {
          iv[1].setImageResource(R.drawable.circle);
          symbol[0][1] = 1;
          turn++;
          used[1] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
    iv[2].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[2] && !winner){
          iv[2].setImageResource(R.drawable.circle);
          symbol[0][2] = 1;
          turn++;
          used[2] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }

    });
    iv[3].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[3] && !winner){
          iv[3].setImageResource(R.drawable.circle);
          symbol[1][0] = 1;
          turn++;
          used[3] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
    iv[4].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[4] && !winner){
          iv[4].setImageResource(R.drawable.circle);
          symbol[1][1] = 1;
          turn++;
          used[4] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
    iv[5].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[5] && !winner){
          iv[5].setImageResource(R.drawable.circle);
          symbol[1][2] = 1;
          turn++;
          used[5] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
    iv[6].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[6] && !winner){
          iv[6].setImageResource(R.drawable.circle);
          symbol[2][0] = 1;
          turn++;
          used[6] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
    iv[7].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[7] && !winner){
          iv[7].setImageResource(R.drawable.circle);
          symbol[2][1] = 1;
          turn++;
          used[7] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
    iv[8].setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!used[8] && !winner){
          iv[8].setImageResource(R.drawable.circle);
          symbol[2][2] = 1;
          turn++;
          used[8] = true;
          winner = checkCircleWinner();
          computersTurn();
        }
      }
    });
  }

  public void searchClosestCorner(){

  }

  public void searchAvailableSpace(){

  }

  public boolean blockHorizon(){
    byte cont = 0, crow=0, as=0, civ = -1, ccol=0;

    for(byte i=0; i<3; i++){
      for(byte j=0; j<3; j++){
        civ++;
        if(symbol[i][j] == 1){
          cont++;
          crow = i;
        } else{
          ccol = j;
          as = civ;
        }
      }
      if(cont == 2){
        Toast.makeText(this, "(BH) Espacio que debe bloquearse en "+crow+", "+ccol+", "+as, Toast.LENGTH_LONG).show();
        iv[as].setImageResource(R.drawable.cross);
        symbol[crow][ccol] = 2;
        turn++;
        used[as] = true;
        return true;
      }
      cont = 0;
    }

    return false;
  }

  public boolean blockVertical(){
    byte cont = 0, crow=0, as=0, civ = -1, ccol=0;

    for(byte i=0; i<3; i++){
      for(byte j=0; j<3; j++){
        civ++;
        if(symbol[j][i] == 1){
          cont++;
          ccol = i;
        } else{
          crow = j;
          as = civ;
        }
      }
      if(cont == 2){
        Toast.makeText(this, "(BV) Espacio que debe bloquearse en "+crow+", "+ccol+", "+as, Toast.LENGTH_LONG).show();
        if(as == 1 || as == 5){
          as += 2;
        } else if(as == 3 || as == 7){
          as -= 2;
        } else if(as == 2){
          as += 4;
        } else if(as == 6){
          as -= 4;
        }
        iv[as].setImageResource(R.drawable.cross);
        symbol[crow][ccol] = 2;
        turn++;
        used[as] = true;
        return true;
      }
      cont = 0;
    }

    return false;
  }

  public boolean blockVictory(){
    if(blockHorizon()) {
      //Toast.makeText(this, "Amenaza horizontal bloqueada", Toast.LENGTH_LONG).show();
      return true;
    } else {
      if(blockVertical()) {
        //Toast.makeText(this, "Amenaza vertical bloqueada", Toast.LENGTH_LONG).show();
        return true;
      }
    }
    return false;
  }

  public void computersTurn(){
    double randaux;
    boolean vb = false;
    if(turn == 1){
      if(symbol[1][1] == 1){
        randaux = Math.random() * 10;
        if(randaux <= 2.5){
          iv[0].setImageResource(R.drawable.cross);
          symbol[0][0] = 2;
          turn++;
          used[0] = true;
        } else if (randaux > 2.5 && randaux <= 5){
          iv[2].setImageResource(R.drawable.cross);
          symbol[0][2] = 2;
          turn++;
          used[2] = true;
        } else if(randaux > 5 && randaux <= 7.5){
          iv[8].setImageResource(R.drawable.cross);
          symbol[2][2] = 2;
          turn++;
          used[8] = true;
        } else{
          iv[6].setImageResource(R.drawable.cross);
          symbol[2][0] = 2;
          turn++;
          used[6] = true;
        }
      } else{
        iv[4].setImageResource(R.drawable.cross);
        symbol[1][1] = 2;
        turn++;
        used[4] = true;
      }
    } else{
      vb = blockVictory();
      Toast.makeText(this, "VIctoria tapada: "+vb, Toast.LENGTH_LONG).show();
      winner = checkCrossWinner();
    }
  }

  public boolean checkCircleWinner(){

    //Validando 3 en horizontal
    if(symbol[0][0] == 1 && symbol[0][1] == 1 && symbol[0][2] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[1][0] == 1 && symbol[1][1] == 1 && symbol[1][2] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[2][0] == 1 && symbol[2][1] == 1 && symbol[2][2] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    }

    //Validando 3 en vertical
    if(symbol[0][0] == 1 && symbol[1][0] == 1 && symbol[2][0] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[0][1] == 1 && symbol[1][1] == 1 && symbol[2][1] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[0][2] == 1 && symbol[1][2] == 1 && symbol[2][2] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    }

    //Validando diagonales
    if(symbol[0][0] == 1 && symbol[1][1] == 1 && symbol[2][2] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    }
    if(symbol[0][2] == 1 && symbol[1][1] == 1 && symbol[2][0] == 1){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 1!", Toast.LENGTH_LONG).show();
      return true;
    }

    return false;
  }

  public boolean checkCrossWinner(){

    //Validando 3 en horizontal
    if(symbol[0][0] == 2 && symbol[0][1] == 2 && symbol[0][2] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[1][0] == 2 && symbol[1][1] == 2 && symbol[1][2] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[2][0] == 2 && symbol[2][1] == 2 && symbol[2][2] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    }

    //Validando 3 en vertical
    if(symbol[0][0] == 2 && symbol[1][0] == 2 && symbol[2][0] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[0][1] == 2 && symbol[1][1] == 2 && symbol[2][1] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    } else if(symbol[0][2] == 2 && symbol[1][2] == 2 && symbol[2][2] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    }

    //Validando diagonales
    if(symbol[0][0] == 2 && symbol[1][1] == 2 && symbol[2][2] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    }
    if(symbol[0][2] == 2 && symbol[1][1] == 2 && symbol[2][0] == 2){
      gameOver.setImageResource(R.drawable.game_over);
      Toast.makeText(this, "Ganó el jugador 2!", Toast.LENGTH_LONG).show();
      return true;
    }

    return false;
  }
}
