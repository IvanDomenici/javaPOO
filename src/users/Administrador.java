/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import bebidas.Produto;

public class Administrador extends Usuario {
    private String cargo;
    private int nVendas;

    public Administrador(String nome, String senha, String cargo) {
        super(nome, senha);
        this.cargo = cargo;
        this.nVendas = 0;
    }

    public void vender(Produto p) {
      
        this.nVendas++;
    }

    public int getNVendas() {
        return nVendas;
    }
}
