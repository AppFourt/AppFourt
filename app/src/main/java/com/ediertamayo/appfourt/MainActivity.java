package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String usuarioM,claveM;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mPerfil){
            Intent intent = new Intent(MainActivity.this,PerfilActivity.class);
            intent.putExtra("usuarioM",usuarioM);
            intent.putExtra("claveM",claveM);
            startActivity(intent);
        }else if(id ==R.id.mCerrarSesion){
            Intent intent = new Intent(MainActivity.this,LogginActivity.class);
            intent.putExtra("valor",1);
            intent.putExtra("usuarioM",usuarioM);
            intent.putExtra("claveM",claveM);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
