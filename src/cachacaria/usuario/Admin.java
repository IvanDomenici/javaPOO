/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cachacaria.usuario;

/**
 *
 * @author Gabriel
 */
public class Admin extends Usuario{
    private String cargo;
    private int Matricula;

    public Admin(String cargo, int Matricula, String nome, String email, String senha) {
        super(nome, email, senha);
        this.cargo = cargo;
        this.Matricula = Matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    @Override
    public void setAcessoADM(boolean acessoADM) {
        super.setAcessoADM(acessoADM); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
