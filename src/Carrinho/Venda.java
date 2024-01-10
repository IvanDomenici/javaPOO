/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Carrinho;
import bebidas.Produto;
import java.util.Date;
import users.Cliente;
/**
 *
 * @author Ivan Domenici
 */
public class Venda {
    private Cliente usuario;
    private Date dataVenda;
    private double valorFinal;
    private Produto produto;
    private int quantidade;

    
     public Venda(Cliente usuario, Date dataVenda, double valorFinal, Produto produto, int quantidade) {
        this.usuario = usuario;
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
     
     
    public Produto getProduto() {
        return produto;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

   

    public double getValorFinal() {
        return valorFinal;
    }
      
    
    
    public void setValorFinal(double vf){
    
    }
    
}
