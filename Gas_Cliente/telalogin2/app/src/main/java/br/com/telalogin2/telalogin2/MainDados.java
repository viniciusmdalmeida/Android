package br.com.telalogin2.telalogin2;

public class MainDados {

    //Variáveis
    private String email;
    private String senha;

    //GetterSetter
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) { this.senha = senha;}

    //Construtor
    public MainDados(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    //Construtor Para Esqueci Minha Senha
    public MainDados(String senha) {
        this.senha = senha;
    }




}
