package semAlcool;

import bebidas.BebidaNaoAlcoolica;

public class Refrigerante extends BebidaNaoAlcoolica {
    private boolean contemCafeina;
    private boolean isDiet;

    public Refrigerante(boolean contemCafeina, boolean isDiet, String sabor, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(sabor, id, nome, preco, quantidadeEmEstoque);
        this.contemCafeina = contemCafeina;
        this.isDiet = isDiet;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Contém Cafeína: " + (contemCafeina ? "Sim" : "Não"));
        System.out.println("Diet: " + (isDiet ? "Sim" : "Não"));
    }

}
