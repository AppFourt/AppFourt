package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {
    TextView tvNombre,tvUsuario,tvEmail;
    String usuarioP,claveP,nombreP,emailP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().setTitle("Perfil");

        tvNombre=findViewById(R.id.tvNombre);
        tvEmail=findViewById(R.id.tvEmail);
        tvUsuario=findViewById(R.id.tvUsuario);

        Bundle extras = getIntent().getExtras();
        usuarioP = extras.getString("usuarioM");
        claveP = extras.getString("claveM");
        nombreP = extras.getString("nombreM");
        emailP = extras.getString("emailM");

        tvUsuario.setText(extras.getString("usuarioM"));
        tvNombre.setText(extras.getString("nombreM"));
        tvEmail.setText(extras.getString("emailM"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuperfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mPrincipal){
            Intent intent = new Intent(PerfilActivity.this,MainActivity.class);
            intent.putExtra("usuarioP",usuarioP);
            intent.putExtra("claveP",claveP);
            intent.putExtra("nombreP",nombreP);
            intent.putExtra("emailP",emailP);
            setResult(RESULT_OK,intent);
            onBackPressed();
            finish();
        }else if(id ==R.id.mCerrarSesion){
            Intent intent = new Intent(PerfilActivity.this,LogginActivity.class);
            intent.putExtra("usuarioP",usuarioP);
            intent.putExtra("claveP",claveP);
            intent.putExtra("nombreP",nombreP);
            intent.putExtra("emailP",emailP);
            setResult(RESULT_CANCELED,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent(PerfilActivity.this,MainActivity.class);
            intent.putExtra("usuarioP",usuarioP);
            intent.putExtra("claveP",claveP);
            intent.putExtra("nombreP",nombreP);
            intent.putExtra("emailP",emailP);
            setResult(RESULT_OK,intent);
            onBackPressed();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
