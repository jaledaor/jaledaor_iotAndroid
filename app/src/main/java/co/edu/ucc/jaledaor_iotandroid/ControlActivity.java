package co.edu.ucc.jaledaor_iotandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class ControlActivity extends AppCompatActivity {

    private int estadoSala=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        ButterKnife.bind(this);

        String nomUsuario = getIntent().getStringExtra("nomUsuario");

        setTitle("Bienvenido "+ nomUsuario);
    }
}
