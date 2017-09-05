package co.edu.ucc.jaledaor_iotandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.txt_nomUsuario)
    EditText txt_nomUsuario;

    @BindView(R.id.txt_Password)
    EditText txt_Password;

    @BindView(R.id.btn_Ingresar)
    Button btn_Ingresar;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database_control;
    private DatabaseReference reference_control;
    String UID = "";
    String estado_sala_temp = "0";
    String estado_bano_temp = "0";
    String estado_cocina_temp = "0";
    String estado_alcoba_temp = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);
        database_control = FirebaseDatabase.getInstance();
        reference_control = database_control.getReference("hogar");

    }

    @OnClick(R.id.btn_Ingresar)
    public void clickIngressar() {
        String email = txt_nomUsuario.getText().toString();
        String password = txt_Password.getText().toString();
        /*UID = mAuth.getCurrentUser().getUid();
        reference_control.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.getValue() != null) {
                    estado_bano_temp = snapshot.child(UID).child("estado_bano").getValue().toString();
                    estado_cocina_temp = snapshot.child(UID).child("estado_cocina").getValue().toString();
                    estado_alcoba_temp = snapshot.child(UID).child("estado_habitacion").getValue().toString();
                    estado_sala_temp = snapshot.child(UID).child("estado_sala").getValue().toString();
                } else {
                    Toast.makeText(LoginActivity.this, "no hay datos", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });*/

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                    /*inicio cambio*/



/*inicio cambio*/

                    /*fin cambio*/
                            btn_Ingresar.setEnabled(false);

                            Intent ingresar = new Intent(getApplicationContext(), ControlActivity.class);
                            /*ingresar.putExtra("bano", estado_bano_temp);
                            ingresar.putExtra("cocina", estado_cocina_temp);
                            ingresar.putExtra("alcoba", estado_alcoba_temp);
                            ingresar.putExtra("sala", estado_sala_temp);*/
                            startActivity(ingresar);
                            finish();
                            return;
                        } else {
                            Toast.makeText(getApplicationContext(), "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @OnClick(R.id.btn_Registrar)
    public void clickRegistrar() {
        Intent registerActivity = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(registerActivity);
        finish();
        return;
    }
}
