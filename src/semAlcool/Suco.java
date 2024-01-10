package semAlcool;


import bebidas.BebidaNaoAlcoolica;

public class Suco extends BebidaNaoAlcoolica {
    private boolean natural; // true se o suco for natural, false se for concentrado
    private boolean semAcucar; // true se não tiver açúcar adicionado

    public Suco(boolean natural, boolean semAcucar, String sabor, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(sabor, id, nome, preco, quantidadeEmEstoque);
        this.natural = natural;
        this.semAcucar = semAcucar;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Natural: " + (natural ? "Sim" : "Não"));
        System.out.println("Sem Açúcar: " + (semAcucar ? "Sim" : "Não"));
    }

}
