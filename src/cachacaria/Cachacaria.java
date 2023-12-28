
package cachacaria;

import cachacaria.databases.DataBase;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Gabriel
 */
public class Cachacaria {
    
    public static void main(String[] args) throws ParseException {
        ImageIcon icon = new ImageIcon("c:/pers.png");
        
        //Iniciando o sistema
        JOptionPane.showMessageDialog(null, "Bem vindo ao sistema da cachaçaria!","Bem Vindo!", JOptionPane.INFORMATION_MESSAGE, icon);
        int response;
        
        //criando um novo estoque
        Estoque estoque = new Estoque();
        
        //repetição do menu de ações
        do{
            //opções de ações disponíveis
            String[] options = new String[] {"Cadastrar novo lote", "Vizualizar estoque", "Vender", "Sair"};
            response = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Ações",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            icon, options, options[0]);
            /* 
                0 - Cadastrar novo lote
                1 - Vizualizar estoque
                2 - Vender
                3 - Sair
            */
            switch(response){
                case 0 -> {
                    //Lendo a data de fabricação do lote
                    String retorno = JOptionPane.showInputDialog(null, "Data de fabricação do lote: ","Data",JOptionPane.QUESTION_MESSAGE);
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar dataF = Calendar.getInstance();
                    dataF.setTime(df.parse(retorno));
                    
                    //Lendo a quantidade de litros produzidos
                    retorno = JOptionPane.showInputDialog(null, "Valor investido: ","Investido",JOptionPane.QUESTION_MESSAGE);
                    double valor = Double.parseDouble(retorno);
        
                    //Lendo a quantidade de litros produzidos
                    retorno = JOptionPane.showInputDialog(null, "Litros produzidos: ","Litros",JOptionPane.QUESTION_MESSAGE);
                    double litros = Double.parseDouble(retorno);
                                 
                    //criando o lote
                    Lote lote = new Lote(dataF, valor);
                    System.out.println("ID LOTE"+lote.getLoteId());
                    DataBase db = new DataBase();
                    db.insereLote(lote);
                    int lote_id = lote.getLoteId();
                    /*
                    
                    
                    podemos utilizar garrafas de 1L ou de 750ML
                    primeiramente perguntamos ao usuário a quantidade de garrafas de 1L que deseja
                    */
                    int max1L = (int)litros;
                    String msg = "De " + max1L +" litros.\nQuantidade de garrafas de 1L:";
                    retorno = JOptionPane.showInputDialog(null, msg,"Garrafas",JOptionPane.QUESTION_MESSAGE);
                    int garrafas1L = Integer.parseInt(retorno);
                    double litrosRestantes = litros - garrafas1L;
                    int garrafas750ml = (int)(litrosRestantes/0.75);
                    
                    retorno = JOptionPane.showInputDialog(null, "Qual o valor das garrafas?","Garrafas",JOptionPane.QUESTION_MESSAGE);
                    valor = Double.parseDouble(retorno);
                    
                    //instanciando garrafas de 1L
                    for(int i = 0; i < garrafas1L; i++){
                        Garrafa garrafa1l = new Garrafa(1.0, valor, lote_id);
                        lote.addProduto(garrafa1l);
                    }
                    
                    //instaciando garrafas de 750ml
                    for(int j = 0; j < garrafas750ml; j++){
                        Garrafa garrafa750ml = new Garrafa(0.75, valor,lote_id);
                        lote.addProduto(garrafa750ml);
                    }
                    
                    estoque.addLote(lote);
                }

                case 1 -> {
                    String str_estoque = estoque.toString();
                    JOptionPane.showMessageDialog(null, str_estoque, "ESTOQUE", JOptionPane.PLAIN_MESSAGE);
                }
                case 2 -> {
                    options = new String[] {"1 Litro", "750ml"}; //vetor de opções do JOPT
                    response = JOptionPane.showOptionDialog(null, "Qual a garrafa da venda?", "Ações",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    double volume = response == 0 ? 1.0 : 0.75;
                    //Lendo a quantidade de litros garrafas a serem vendidas
                    String retorno = JOptionPane.showInputDialog(null, "Quantidade de garrafas da venda: ","Venda",JOptionPane.QUESTION_MESSAGE);
                    int vendas = Integer.parseInt(retorno);
                    String resultado = estoque.venda(volume, vendas);
                    JOptionPane.showMessageDialog(null, resultado, "VENDA", JOptionPane.WARNING_MESSAGE, null);
                }
                    
            }
        }while(response != 3);
        
    }
}
