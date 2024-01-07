/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Carrinho;

import bebidas.Produto;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Estoque {
    
    private ArrayList<Produto> produtos;
    
    public Estoque(){
        produtos = new ArrayList();
    }
    
    public Estoque(ArrayList<Produto> array){
        produtos = array;
    }
    
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    
    
    
}
