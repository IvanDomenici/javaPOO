package semAlcool;


import bebidas.BebidaNaoAlcoolica;
import bebidas.DescontoAplicavel;

public class Suco extends BebidaNaoAlcoolica implements DescontoAplicavel {
    private String tipoFruta;
    private boolean natural; // true se o suco for natural, false se for concentrado
    private boolean semAcucar; // true se não tiver açúcar adicionado

    public Suco(String tipoFruta, boolean natural, boolean semAcucar, String sabor, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(sabor, id, nome, preco, quantidadeEmEstoque);
        this.tipoFruta = tipoFruta;
        this.natural = natural;
        this.semAcucar = semAcucar;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo de Fruta: " + tipoFruta);
        System.out.println("Natural: " + (natural ? "Sim" : "Não"));
        System.out.println("Sem Açúcar: " + (semAcucar ? "Sim" : "Não"));
    }

    // Getters e setters
    public String getTipoFruta() {
        return tipoFruta;
    }

    public void setTipoFruta(String tipoFruta) {
        this.tipoFruta = tipoFruta;
    }

    public boolean isNatural() {
        return natural;
    }

    public void setNatural(boolean natural) {
        this.natural = natural;
    }

    public boolean isSemAcucar() {
        return semAcucar;
    }

    public void setSemAcucar(boolean semAcucar) {
        this.semAcucar = semAcucar;
    }

    @Override
    public double descontoAplicavel() {
        return super.getPreco();
    }
}
