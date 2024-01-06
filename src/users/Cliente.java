/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

public class Cliente extends Usuario {
    private String endereco;
    private double valorGasto;

    public Cliente(String nome, String senha) {
        super(nome, senha);
        this.endereco = "";
        this.valorGasto = 0.0;
    }

    public void addValorGasto(double valor) {
        this.valorGasto += valor;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
