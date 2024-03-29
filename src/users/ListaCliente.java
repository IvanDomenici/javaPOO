/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import java.util.ArrayList;


public class ListaCliente {
    
     private ArrayList<Cliente> listaCliente;
     
     public ListaCliente() {
         
        this.listaCliente =  new ArrayList<Cliente>();
    }
 
    public void addCliente (Cliente c){
        listaCliente.add(c);
        
    
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }
    
    public void removerCliente(Cliente c){
    listaCliente.remove(c);
    }
    
    public void MostrarCliente(){
        System.out.println(listaCliente.size());
    }
    
    public Cliente buscaClientePorNome(String nome){
        for(Cliente cliente : this.listaCliente){
            if(cliente.getNome().equals(nome)){
                return cliente;
            }
        }
        throw new IllegalArgumentException("Usuário Inexistente");
    }
}
 
