package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {
    Bundle extras=getIntent().getExtras();
    EditText etUsuario,etClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario=findViewById(R.id.etUsuario);
        etClave=findViewById(R.id.etClave);
    }

    public void guardar(View view) {
        Intent intent=new Intent();
        intent.putExtra("retUsuario",etUsuario.getText().toString());
        intent.putExtra("retClave",etClave.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
