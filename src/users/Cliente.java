/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import java.util.ArrayList;

public class Cliente  {
  
    
    private double valorGasto;
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }
   

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.valorGasto = 0.0;
    }

    public void addValorGasto(double valor) {
        this.valorGasto += valor;
    }

    
}
