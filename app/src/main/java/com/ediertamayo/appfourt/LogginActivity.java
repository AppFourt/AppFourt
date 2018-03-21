package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {
    EditText etUsuario,etClave;
    String usuarioL;
    String claveL,nombreL,emailL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        etUsuario=findViewById(R.id.etUsuario);
        etClave=findViewById(R.id.etClave);
    }

    public void registro(View view) {
        Intent intent=new Intent(LogginActivity.this,RegistroActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1 && resultCode == RESULT_OK){
            usuarioL=String.valueOf(data.getExtras().getString("usuarioR"));
            claveL=String.valueOf(data.getExtras().getString("claveR"));
            nombreL=String.valueOf(data.getExtras().getString("nombreR"));
            emailL=String.valueOf(data.getExtras().getString("emailR"));
        }else if(requestCode==2 && resultCode==RESULT_OK) {
            usuarioL=String.valueOf(data.getExtras().getString("usuarioM"));
            claveL=String.valueOf(data.getExtras().getString("claveM"));
            nombreL=String.valueOf(data.getExtras().getString("nombreM"));
            emailL=String.valueOf(data.getExtras().getString("emailM"));
        }else if(requestCode==2 && resultCode==RESULT_CANCELED) {
            finish();
        } else{
            if (resultCode == RESULT_CANCELED){
                Toast.makeText(LogginActivity.this, "Falló registro",
                        Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void ingresar(View view) {
        if(etUsuario.getText().toString().equals(usuarioL)&&etClave.getText().toString().equals(claveL)){
            Intent intent=new Intent(LogginActivity.this,MainActivity.class);
            intent.putExtra("usuarioL",usuarioL);
            intent.putExtra("claveL",claveL);
            intent.putExtra("nombreL",claveL);
            intent.putExtra("emailL",claveL);
            etUsuario.setText("");
            etClave.setText("");
            startActivityForResult(intent,2);
        }else{
            Toast.makeText(LogginActivity.this, "Datos incorrectos",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
