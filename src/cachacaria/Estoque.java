/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Estoque {
    private ArrayList<Lote> lotes;
    private int numVendas, disp750, disp1l;
    private double valorArrecadado;
    private double valorGasto;

    public Estoque() {
        this.lotes = new ArrayList<Lote>();
        this.numVendas = 0;
        this.disp750 = 0;
        this.disp1l = 0;
        this.valorArrecadado = 0;
        this.valorGasto = 0;
    }
    
    
    

    
    public String venda(double volume, int quantidade){          
        
        int vendidos = 0;
        while(vendidos != quantidade){//enquanto não terminar de vender todos

            Lote lote = buscaPrimeiroDisp(volume);
            if(lote == null){
                return "Não possuimos lotes suficientes";
            }

            for(int i = vendidos; i < quantidade; i++){//e
               if(lote.vende(volume)){
                    vendidos++;
               }else{
                   break;
               }
            }
        }
    
        this.atualiza_info();
        return "Venda bem sucedida.";
   
    }
    
    private void atualiza_info(){
        int n_garrafas_1L = 0;
        int n_garrafas750 = 0; 
        int n_vendidas = 0;
        double valor_arrec = 0;
        double valor_gasto = 0;
        int numero_lotes = this.lotes.size();
        for(int i = 0; i < numero_lotes; i++){
            Lote lote = this.lotes.get(i);
            n_garrafas_1L += lote.getNumDisp750();
            n_garrafas750 += lote.getNumDisp1L();
            valor_gasto += lote.getValorGasto();
            
            int ven = lote.getNum_vendidas_lote();
            ArrayList<Garrafa> vendidas = lote.getGarrafasVendidas();
            n_vendidas += ven;
            for(int j = 0; j < n_vendidas; j++){
                Garrafa vendida = vendidas.get(j);
                valor_arrec+=vendida.getValor();
            }
            
        }
        
        this.setDisp1l(n_garrafas_1L);
        this.setDisp750(n_garrafas750);
        this.setNumVendas(n_vendidas);
        this.setValorArrecadado(valor_arrec);
        this.setValorGasto(valor_gasto);
    }
    
    
    private Lote buscaPrimeiroDisp(double volume){
        System.out.println(volume);
        int quantidade_lotes = this.lotes.size();
        int g_disp;
        for(int i = 0; i < quantidade_lotes; i++){
            g_disp = 0;
            Lote lote = this.lotes.get(i);
            if(volume == 1.0){
                g_disp = lote.getNumDisp1L();
            }else{
                g_disp = lote.getNumDisp750();
            }
            if(g_disp > 0){
                return lote;
            }
        }
        return null;
    }
    
  
    @Override
    public String toString(){
        this.atualiza_info();
       String estoque = " ____________________________\n"+
                        "| • NÚMERO DE LOTES   === "+this.getQuantLotes()+"\n"+
                        "| • DISPONÍVEIS 1L    === "+this.getDisp1l()+"\n"+
                        "| • DISPONÍVEIS 750ML === "+this.getDisp750()+"\n"+
                        "| ===========================\n"+
                        "| • GARRAFAS VENDIDAS === "+this.getNumVendas()+"\n"+
                        "| • VALOR INVESTIDO   === "+this.getValorGasto()+"\n"+
                        "| • VALOR ARRECADADO  === "+this.getValorArrecadado()+ "\n"+
                        "| • LUCRO OBTIDO      === "+this.getLucro()+ "\n"+
                        "|____________________________";
       return estoque;
    }

    public int getDisp750() {
        return disp750;
    }

    public void setDisp750(int disp750) {
        this.disp750 = disp750;
    }

    public int getDisp1l() {
        return disp1l;
    }

    public void setDisp1l(int disp1l) {
        this.disp1l = disp1l;
    }
    
    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public void setValorArrecadado(double valorArrecadado) {
        this.valorArrecadado = valorArrecadado;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }
    
    public void addLote(Lote lote){
        this.lotes.add(lote);
    }
    private int getQuantLotes(){
        return this.lotes.size();
    }
    
    private double getLucro(){
        return this.getValorArrecadado() - this.getValorGasto();
    }
    
    
    
    
    
}
