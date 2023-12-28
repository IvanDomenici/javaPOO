/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria.databases;
import cachacaria.Garrafa;
import cachacaria.Lote;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gabriel
 */
public class DataBase {
    private Connection cnn;
    private String host;
    private String user;
    private String pass;
    private String base;
    
    public DataBase(){
        this.host = "127.0.0.1:3306";
        this.base = "poo";
        this.user = "gabriel";
        this.pass = "1234";
        this.cnn = null;
    }

    public Connection getCnn() {
        return cnn;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getBase() {
        return base;
    }

    
    private boolean connect(){
        try{
            String sqlCnn = "jdbc:mysql://"+this.getHost()+"/"+this.getBase()+"?user="+this.getUser()+
                    "&password="+this.getPass();
            this.cnn = DriverManager.getConnection(sqlCnn);
            System.out.println("CONECTADO COM SUCESSO");
            return true;
        }catch(SQLException ex){
            System.out.println("ERRO SQL na conexão: "+ex.toString());
        }
        return false;
    }
    
    private boolean close_cnn(){
        try{
            this.cnn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("ERRO SQL na conexão: "+ex.toString());
        }
        return false;
    }
    
    public ResultSet select(String query){
        
        try{
            this.connect();
            Statement comando = this.cnn.createStatement();
            ResultSet result = comando.executeQuery(query);
            return result;
        }catch(SQLException ex){
            System.out.println("ERRO SQL na execução: "+ex.toString());
        }
        this.close_cnn();
        return null;        
    }
    
    public boolean insert(String query){
        this.connect();
        try{
            Statement st = this.cnn.createStatement();
            st.executeUpdate(query);
            return true;
        }catch(SQLException ex){
            System.out.println("ERRO SQL na execução: "+ex.toString());
        }
        this.close_cnn();
        return false;
    }
    
    public void insereGarrafa(Garrafa g){
        double volume, valor;
        int venda, id_lote;
        
        volume = g.getVolume();
        valor = g.getValor();
        venda = g.isVenda()? 1 : 0;
        id_lote = g.getIdLote();
        
        String sql = "INSERT INTO poo.garrafa(volume, venda, valor, idLote) VALUES ("+
                volume+","+
                venda+","+
                valor+","+
                id_lote+");";
        
        
        boolean result = this.insert(sql);
        if (result){
            System.out.println("Garrafa Inserida com sucesso");
        }
        else{
            System.out.println("Garrafa Não Inserida");
        }
    }
    
    private String trataData(Calendar calendar){
        Instant instant = calendar.toInstant();
        Date myDate = Date.from(instant);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String output = formatter.format(myDate);
        return output;
}
    
    public void insereLote(Lote lote){
        Calendar dataF, dataV;
        
        dataF = lote.getDataFabricacao();
        dataV = lote.get_dataV();
        double valorg = lote.getValorGasto();
        
        String sql = "INSERT INTO poo.lote(data_fab, data_venc, valor_gasto) VALUES ('"+
                this.trataData(dataF)+"','"+
                this.trataData(dataV)+"',"+
                valorg+");";
        
        
        boolean result = this.insert(sql);
        if (result){
            System.out.println("Lote Inserido com sucesso");
        }
        else{
            System.out.println("Lote Não Inserida");
        }
    }
    
    public int getIdDisp(String columm, String table){
        try {
            String sql = "SELECT MAX("+columm+")+1 AS id FROM poo."+table+";";
            ResultSet rs = this.select(sql);
            int id = 0;
            while(rs.next()){
                //Display values
                id = rs.getInt("id");

            }           
            return id;
        } catch (SQLException ex) {
            System.out.println("Id erro");
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
