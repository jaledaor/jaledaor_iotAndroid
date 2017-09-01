package co.edu.ucc.jaledaor_iotandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.jaledaor_iotandroid.entidades.Espacios;

public class ControlActivity extends AppCompatActivity {


    @BindView(R.id.btn_Habitacion)
    Button btn_Habitacion;

    @BindView(R.id.btn_Bano)
    Button btn_Bano;

    @BindView(R.id.btn_Cocina)
    Button btn_Cocina;

    @BindView(R.id.btn_Sala)
    Button btn_Sala;

    private FirebaseAuth mAuth_control;
    private FirebaseDatabase database_control;
    private DatabaseReference reference_control;
    private DatabaseReference reference_usrname;
    private ValueEventListener eventListener;

    private int estado_sala;
    private int estado_alcoba;
    private int estado_bano;
    private int estado_cocina;
    String UID = "";
    String estado_sala_temp = "";
    String estado_bano_temp = "";
    String estado_cocina_temp = "";
    String estado_alcoba_temp = "";
    String usernameTaken="";
    Espacios espacio = new Espacios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String nomUsuario = getIntent().getStringExtra("nomUsuario");
        setTitle("Bienvenido " + nomUsuario);
        setContentView(R.layout.activity_control);
        ButterKnife.bind(this);
        mAuth_control = FirebaseAuth.getInstance();
        database_control = FirebaseDatabase.getInstance();
        reference_control = database_control.getReference("hogar");
        UID = mAuth_control.getCurrentUser().getUid();



        /*
        if (estado_sala_temp.equals("1")) {
            btn_Sala.setBackgroundColor(Color.YELLOW);
        } else {
            btn_Sala.setBackgroundColor(Color.RED);
        }

        if (estado_bano_temp.equals("1")) {
            btn_Bano.setBackgroundColor(Color.YELLOW);
        } else {
            btn_Bano.setBackgroundColor(Color.RED);
        }

        if (estado_alcoba_temp.equals("1")) {
            btn_Habitacion.setBackgroundColor(Color.YELLOW);
        } else {
            btn_Habitacion.setBackgroundColor(Color.RED);
        }

        if (estado_cocina_temp.equals("1")) {
            btn_Cocina.setBackgroundColor(Color.YELLOW);
        } else {
            btn_Cocina.setBackgroundColor(Color.RED);
        }*/
    }

    @OnClick(R.id.btn_Habitacion)
    public void clickHabitacion() {
        if (estado_alcoba == 0) {
            estado_alcoba = 1;
            espacio.setEstado_habitacion(estado_alcoba);
            espacio.setEstado_bano(espacio.getEstado_bano());
            espacio.setEstado_cocina(espacio.getEstado_cocina());
            espacio.setEstado_sala(espacio.getEstado_sala());
            btn_Habitacion.setBackgroundColor(Color.YELLOW);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            estado_alcoba = 0;
            espacio.setEstado_habitacion(estado_alcoba);
            espacio.setEstado_bano(espacio.getEstado_bano());
            espacio.setEstado_cocina(espacio.getEstado_cocina());
            espacio.setEstado_sala(espacio.getEstado_sala());
            btn_Habitacion.setBackgroundColor(Color.RED);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @OnClick(R.id.btn_Bano)
    public void clickBano() {
        if (estado_bano == 0) {
            estado_bano = 1;
            espacio.setEstado_habitacion(espacio.getEstado_habitacion());
            espacio.setEstado_bano(estado_bano);
            espacio.setEstado_cocina(espacio.getEstado_cocina());
            espacio.setEstado_sala(espacio.getEstado_sala());
            btn_Bano.setBackgroundColor(Color.YELLOW);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            estado_bano = 0;
            espacio.setEstado_habitacion(espacio.getEstado_habitacion());
            espacio.setEstado_bano(estado_bano);
            espacio.setEstado_cocina(espacio.getEstado_cocina());
            espacio.setEstado_sala(espacio.getEstado_sala());
            btn_Bano.setBackgroundColor(Color.RED);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @OnClick(R.id.btn_Sala)
    public void clickSala() {
        if (estado_sala == 0) {
            estado_sala = 1;
            espacio.setEstado_habitacion(espacio.getEstado_habitacion());
            espacio.setEstado_bano(espacio.getEstado_bano());
            espacio.setEstado_cocina(espacio.getEstado_cocina());
            espacio.setEstado_sala(estado_sala);
            btn_Sala.setBackgroundColor(Color.YELLOW);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            estado_sala = 0;
            espacio.setEstado_habitacion(espacio.getEstado_habitacion());
            espacio.setEstado_bano(espacio.getEstado_bano());
            espacio.setEstado_cocina(espacio.getEstado_cocina());
            espacio.setEstado_sala(estado_sala);
            btn_Sala.setBackgroundColor(Color.RED);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @OnClick(R.id.btn_Cocina)
    public void clickCocina() {
        if (estado_cocina == 0) {
            estado_cocina = 1;
            espacio.setEstado_habitacion(espacio.getEstado_habitacion());
            espacio.setEstado_bano(espacio.getEstado_bano());
            espacio.setEstado_cocina(estado_cocina);
            espacio.setEstado_sala(espacio.getEstado_sala());
            btn_Cocina.setBackgroundColor(Color.YELLOW);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            estado_cocina = 0;
            espacio.setEstado_habitacion(espacio.getEstado_habitacion());
            espacio.setEstado_bano(espacio.getEstado_bano());
            espacio.setEstado_cocina(estado_cocina);
            espacio.setEstado_sala(espacio.getEstado_sala());
            btn_Cocina.setBackgroundColor(Color.RED);
            reference_control.child(UID).setValue(espacio).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    } else {
                        Toast.makeText(ControlActivity.this,
                                "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
