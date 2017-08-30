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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_Ingresar)
    public void clickIngressar(){
        String email = txt_nomUsuario.getText().toString();
        String password = txt_Password.getText().toString();
        btn_Ingresar.setEnabled(false);

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent ingresar = new Intent(getApplicationContext(), ControlActivity.class);
                    startActivity(ingresar);
                    finish();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Error "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_Registrar)
    public void clickRegistrar(){
        Intent registerActivity = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(registerActivity);
        finish();
        return;
    }
}
