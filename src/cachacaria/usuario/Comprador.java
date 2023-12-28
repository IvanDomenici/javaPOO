/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria.usuario;

import cachacaria.Garrafa;
import cachacaria.databases.DataBase;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Comprador extends Usuario implements DatabaseUsuario{
    private double valor_gasto;
    private ArrayList<Garrafa> garrafas_compradas;

    public Comprador(double valor_gasto, int garrafas_compradas, String nome, String email, String senha) {
        super(nome, email, senha);
        this.valor_gasto = valor_gasto;
        this.garrafas_compradas = new ArrayList<>();
    }

    public double getValor_gasto() {
        return valor_gasto;
    }

    public void setValor_gasto(double valor_gasto) {
        this.valor_gasto = valor_gasto;
    }
    
    public int getQuantidadeComprada(){
        return this.garrafas_compradas.size();
    }
    

   public void addGarrafa(Garrafa g){
       this.garrafas_compradas.add(g);
   }

    @Override
    public boolean insereUsuarioBD() {
        DataBase db = new DataBase();
        System.out.println("Inserindo um novo comprador;");
        String email = super.getEmail();
        String nome = super.getNome();
        String senha = super.getSenha();
        String insertQuery = "INSERT INTO poo.usuario(nome, email, senha) VALUES ('"+
                nome+"','"+
                email+"','"+
                senha+"');";
        if(db.insert(insertQuery)){
            int id_disp = db.getIdDisp("idUsuario", "usuario u WHERE u.email LIKE '"+email+"';") - 1;
            System.out.println("ID disponível = "+id_disp);
            double valorGasto = this.getValor_gasto();
            int comprasRealizadas = this.getQuantidadeComprada();
            insertQuery = "INSERT INTO poo.comprador( comprasRealizadas, valorGasto, idUsuario) VALUES ('"+
                comprasRealizadas+"','"+
                valorGasto+"','"+
                id_disp+"');";
            return db.insert(insertQuery);
        }
        return false;
    }

    @Override
    public void getUsuariosBD() {
        String selecSQL = "SELECT * FROM poo.usuario WHERE poo.email = '"+this.getEmail()+"';";
        DataBase db = new DataBase();
        ResultSet rs = db.select(selecSQL);
        
    }

    @Override
    public void deleteUsuarioBD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
