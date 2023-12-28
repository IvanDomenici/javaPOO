/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria.usuario;

/**
 *
 * @author Gabriel
 */
public abstract class Usuario {
    private String nome, email, senha;
    private boolean acessoADM;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acessoADM = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAcessoADM() {
        return acessoADM;
    }

    public void setAcessoADM(boolean acessoADM) {
        this.acessoADM = acessoADM;
    }
    
    
    
}
