package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {
    EditText etUsuario,etClave;
    String usuarioR;
    String claveR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        etUsuario=findViewById(R.id.etUsuario);
        etClave=findViewById(R.id.etClave);
    }

    public void registro(View view) {
        Intent intent=new Intent(LogginActivity.this,RegistroActivity.class);
        startActivityForResult(intent,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==123 && resultCode == RESULT_OK){
            usuarioR=String.valueOf(data.getExtras().getString("retUsuario"));
            claveR=String.valueOf(data.getExtras().getString("retClave"));
        } else {
            if (resultCode == RESULT_CANCELED){
                Toast.makeText(LogginActivity.this, "Falló registro",
                        Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void ingresar(View view) {
        if(etUsuario.getText().toString().equals(usuarioR)&&etClave.getText().toString().equals(claveR)){
            Intent intent=new Intent(LogginActivity.this,MainActivity.class);
            intent.putExtra("usuarioL",usuarioR);
            intent.putExtra("claveL",claveR);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(LogginActivity.this, "Datos incorrectos",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
