package com.ediertamayo.appfourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.CursorAnchorInfo;
import android.widget.Toast;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {
    String usuarioM,claveM,nombreM,emailM;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Principal");

        Bundle extras = getIntent().getExtras();
        usuarioM = extras.getString("usuarioL");
        claveM = extras.getString("claveL");
        nombreM = extras.getString("nombreL");
        emailM = extras.getString("emailL");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mPerfil){
            Intent intent = new Intent(MainActivity.this,PerfilActivity.class);
            intent.putExtra("usuarioM",usuarioM);
            intent.putExtra("claveM",claveM);
            intent.putExtra("nombreM",nombreM);
            intent.putExtra("emailM",emailM);
            startActivityForResult(intent,3);
        }else if(id ==R.id.mCerrarSesion){
            Intent intent = new Intent(MainActivity.this,LogginActivity.class);
            intent.putExtra("usuarioM",usuarioM);
            intent.putExtra("claveM",claveM);
            intent.putExtra("nombreM",nombreM);
            intent.putExtra("emailM",emailM);
            setResult(RESULT_OK,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==3 && resultCode == RESULT_CANCELED){
            usuarioM=String.valueOf(data.getExtras().getString("usuarioP"));
            claveM=String.valueOf(data.getExtras().getString("claveP"));
            Intent intent = new Intent(MainActivity.this,LogginActivity.class);
            intent.putExtra("usuarioM",usuarioM);
            intent.putExtra("claveM",claveM);
            intent.putExtra("nombreM",nombreM);
            intent.putExtra("emailM",emailM);
            setResult(RESULT_OK,intent);
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent(MainActivity.this,LogginActivity.class);
            intent.putExtra("usuarioM",usuarioM);
            intent.putExtra("claveM",claveM);
            intent.putExtra("nombreM",nombreM);
            intent.putExtra("emailM",emailM);
            setResult(RESULT_CANCELED,intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
