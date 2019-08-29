package com.example.tentandobluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter meuBtAdapter = null;
    int SOLICITA_ATIV = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuBtAdapter = BluetoothAdapter.getDefaultAdapter();
        if (meuBtAdapter == null){
            Toast.makeText(getApplicationContext(), "Bt inexistente", Toast.LENGTH_LONG).show();

        }else if (!meuBtAdapter.isEnabled()){
            Toast.makeText(getApplicationContext(), "Bt desativado", Toast.LENGTH_LONG).show();
            Intent solicitarBt = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(solicitarBt, SOLICITA_ATIV);
        }else if (meuBtAdapter.isEnabled()){
            Toast.makeText(getApplicationContext(), "Bt ativado!!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);
    }
}
