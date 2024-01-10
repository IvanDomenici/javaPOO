/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Carrinho;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Luiza
 */
public class ListaVendas {
    
    private ArrayList<Venda> listaVendas;

    public ListaVendas() {
        this.listaVendas = new ArrayList<Venda>();
    }
    
    
    
    public ArrayList<Venda> getListaVendas (){
        return listaVendas;
    }   
    
    public void addVendas(Venda v){
        listaVendas.add(v);
        JOptionPane.showMessageDialog(null, "VENDIDO COM SUCESSO!","SUCCES",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
