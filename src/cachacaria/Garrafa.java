/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Garrafa{
    private int id;
    private int idLote;
    private double volume;
    private double valor;
    private boolean venda;
    
    public Garrafa(double volume, double valor, int idLote){
        Random r = new Random();
        this.id = r.nextInt(Integer.MAX_VALUE);
        this.volume = volume;
        this.valor = valor;
        this.venda = false;
        this.idLote = idLote;
    }

    public boolean isVenda() {
        return venda;
    }

    public void setVenda(boolean venda) {
        this.venda = venda;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public int getIdLote() {
        return idLote;
    }
    
    
    
    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", volume=" + volume + ", valor=" + valor + '}';
    }
    
    
}
