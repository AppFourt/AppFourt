package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    EditText etUsuario,etClave,etNombre,etEmail,etRepClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario=findViewById(R.id.etUsuario);
        etClave=findViewById(R.id.etClave);
        etNombre=findViewById(R.id.etNombre);
        etEmail=findViewById(R.id.etEmail);
        etRepClave=findViewById(R.id.etRepClave);
    }

    public void guardar(View view) {
        if(!etUsuario.getText().toString().equals("")&&!etNombre.getText().toString().equals("")&&!etEmail.getText().toString().equals("")
                &&!etRepClave.getText().toString().equals("")&&!etClave.getText().toString().equals("")){
            if(etClave.getText().toString().equals(etRepClave.getText().toString())){
                Intent intent=new Intent();
                intent.putExtra("retUsuario",etUsuario.getText().toString());
                intent.putExtra("retClave",etClave.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }else{
                Toast.makeText(RegistroActivity.this, "Claves diferentes",
                       Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(RegistroActivity.this, "Faltan campos",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
