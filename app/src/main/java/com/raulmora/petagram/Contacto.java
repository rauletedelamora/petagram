package com.raulmora.petagram;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Contacto extends AppCompatActivity{

    private TextInputEditText nombre, email, mensaje;
    private Button botonEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (TextInputEditText) findViewById(R.id.nombre_contacto);
        email = (TextInputEditText) findViewById(R.id.correo);
        mensaje = (TextInputEditText) findViewById(R.id.mensaje);
        botonEnviar = (Button) findViewById(R.id.btn_enviar);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msj = mensaje.getText().toString();
                msj = "Enviado por "+ nombre.getText().toString() +" correo: " + email.getText().toString() +"\n"+ msj;
                sendMail(msj);
            }
        });

    }

    protected void sendMail(String msj){
        String [] to = new String[]{"raul6248@hotmail.com"};
        String asunto = ("Un mensaje de Petagram!");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, msj);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"email"));


    }
}
