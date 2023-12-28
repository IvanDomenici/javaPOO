/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria.usuario;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class TesteUser {
    public static void main(String[] args) {
        Comprador u = new Comprador(300.0, 100, "Rafael", "rafael@email.com.br","senha123");
        Comprador u2 =  new Comprador(150.0, 90, "Claudia", "claudia@email.com.br","senha321");
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("1 para sair\n2 para add ambos no banco\n3 para buscar info do banco");
            escolha = in.nextInt();
            switch(escolha){
                case 1:
                    break;
                case 2:
                    u.insereUsuarioBD();
                    u2.insereUsuarioBD();
                case 3:
                    u.getUsuariosBD();
                    u2.getUsuariosBD();
            }
        }while(escolha != 1);
    }
    
}
