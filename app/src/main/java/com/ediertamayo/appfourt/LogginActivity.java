package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogginActivity extends AppCompatActivity {
    EditText etUsuario,etClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        etUsuario=findViewById(R.id.etUsuario);
        etClave=findViewById(R.id.etClave);

    }

    public void registro(View view) {
        Intent i=new Intent(this,RegistroActivity.class);
        startActivityForResult(i,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
