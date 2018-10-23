package com.example.vinic.gas_piloto;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button botao;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = 0;

        botao = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

    }

    public void enviarMensagem(View view){
        String idString  = editText.getText().toString();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue(idString);

        /*
        Pedido novoPedido = new Pedido(idString,"Inicio");
        DatabaseReference pedidoRef = myRef.child(String.valueOf(id));
        pedidoRef.child("id").setValue(idString);
        pedidoRef.child("Status").setValue("Inicio");

        id ++;
        */
    }
}
