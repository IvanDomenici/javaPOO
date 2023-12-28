/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria;

import cachacaria.databases.DataBase;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Gabriel
 */


public class Lote {
    private Calendar dataFabricacao, dataValidade;
    private int loteId;
    private double valorGasto;
    private DataBase db;
    
    private ArrayList<Garrafa> garrafasDisponiveis1L;//1L
    private ArrayList<Garrafa> garrafasDisponiveis750;//750ml

    private ArrayList<Garrafa> garrafasVendidas;
    private int num_vendidas_lote; 

    public Lote(Calendar dataF, double valor){
        this.db = new DataBase();
        this.loteId = db.getIdLoteDisp();
        this.dataFabricacao = dataF;
        this.dataValidade = (Calendar)dataF.clone();
        this.valorGasto = valor;
        this.dataValidade.add(Calendar.MONTH, 3);
        garrafasDisponiveis1L = new ArrayList<>();
        garrafasDisponiveis750 = new ArrayList<>();

        garrafasVendidas = new ArrayList<>();

    }
    
    
    public void addProduto(Garrafa prod){
        
        double volume = prod.getVolume();
        
        if(volume == 1.0){
            this.garrafasDisponiveis1L.add(prod);
            
        }else{
            this.garrafasDisponiveis750.add(prod);
        }
        
        this.db.insereGarrafa(prod);
    }
    
    @Override
    public Lote clone(){
        return this.clone();
    }
    
    public Calendar get_dataV(){
        return this.dataValidade;
    }

    
    
    public boolean vende(double volume){      
        try{
            Garrafa disp = this.garrafasDisponiveis750.get(0);
            if(volume == 1.0){
                disp = this.garrafasDisponiveis1L.get(0);
            }
            rmvProduto(disp, volume);//garrafa não é mais disponível
            disp.setVenda(true);// muda o atributo boolen venda da garrafa para True
            insereVendido(disp);//insere na list de garrafas vendidas

            if(garrafasVendidas.size() > num_vendidas_lote){//vendo se o vetor aumentou de tamanho
                num_vendidas_lote++;
                return true;
            }
        }catch(IndexOutOfBoundsException ex){
            return false;
        }
        return false;
        
        
    }
        
    private void rmvProduto(Garrafa prod, double volume){//função que remove um produto da lista de garrafas disponíveis
        if(volume == 1.0){
            this.garrafasDisponiveis1L.remove(prod);
        }else{
            this.garrafasDisponiveis750.remove(prod);
        }   
    }

    public double getValorGasto() {
        return valorGasto;
    }
    
    public int getNumDisp1L(){
        return this.garrafasDisponiveis1L.size();
    }
    
    public int getNumDisp750(){
        return this.garrafasDisponiveis750.size();
    }
    
    private void insereVendido(Garrafa prod){
        this.garrafasVendidas.add(prod);
    }
   
    public Calendar getDataFabricacao() {
        return dataFabricacao;
    }


    public int getLoteId() {
        return loteId;
    }
    public ArrayList<Garrafa> getGarrafasDisponiveis1L() {
        return garrafasDisponiveis1L;
    }

    public ArrayList<Garrafa> getGarrafasDisponiveis750() {
        return garrafasDisponiveis750;
    }


    public ArrayList<Garrafa> getGarrafasVendidas() {
        return garrafasVendidas;
    }


    public int getNum_vendidas_lote() {
        return num_vendidas_lote;
    }

    
}
