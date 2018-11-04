package br.com.telalogin2.telalogin2;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declarar Objetos e Declarar Classes
    private EditText edtEmail, edtSenha;
    private MainDados    mainDados;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Tela Carregada e Identificar Objetos
        setContentView( R.layout.activity_main );
        edtEmail = (EditText) findViewById( R.id.edtNome );
        edtSenha = (EditText) findViewById( R.id.edtSenha );
    }

    public void btnEsqueciSenha (View view){
        //Pegar Dados Entrados e Instanciar Classe Dados
        String email  = edtEmail.getText().toString();
        MainDados mainDados = new MainDados( email);

        //Firebase - Esqueci Minha Senha
        firebaseAuth.sendPasswordResetEmail(mainDados.getEmail())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText( MainActivity.this, "Send", Toast.LENGTH_SHORT ).show();
                        } else {
                            Toast.makeText( MainActivity.this, "Erro", Toast.LENGTH_SHORT ).show();
                        }}});
    }

    public void btnCadastrar (View view){
        //Pegar Dados Entrados e Instanciar Classe Dados
        String nome  = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        MainDados mainDados = new MainDados( nome, senha );

        //Firebase - Cadastrar Usuário
        firebaseAuth.createUserWithEmailAndPassword(mainDados.getEmail(), mainDados.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText( MainActivity.this, "Ok", Toast.LENGTH_SHORT ).show();
                        } else {
                            Toast.makeText( MainActivity.this, "Erro", Toast.LENGTH_SHORT ).show();
                        }}});
    }

    public void btnLogin(View view){
        //Pegar Dados Entrados e Instanciar Classe Dados
        String nome  = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        MainDados mainDados = new MainDados( nome, senha );

        //Firebase - Login
        firebaseAuth.signInWithEmailAndPassword(mainDados.getEmail(), mainDados.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText( MainActivity.this, "Ok", Toast.LENGTH_SHORT ).show();
                        } else {
                            Toast.makeText( MainActivity.this, "Erro", Toast.LENGTH_SHORT ).show();
                        }
                    }});
    }
}
