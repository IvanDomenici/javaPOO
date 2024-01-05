package alcoolicas;

import bebidas.BebidaAlcoolica;

public class Cerveja extends BebidaAlcoolica {
    private String tipo; 
    private boolean artesanal; 

    public Cerveja(String tipo, boolean artesanal, double teorAlcoolico, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(teorAlcoolico, id, nome, preco, quantidadeEmEstoque);
        this.tipo = tipo;
        this.artesanal = artesanal;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: " + tipo);
        System.out.println("Artesanal: " + (artesanal ? "Sim" : "Não"));
    }
    
}
