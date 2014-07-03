package restaurante;

import java.util.ArrayList;

/**
 *
 * @author niets
 */
public class ControleReceita {

    private ArrayList<Receita> listaReceitas;

    public ControleReceita() {
        this.listaReceitas = new ArrayList<Receita>();
    }
    
    public ArrayList<Receita> getListaReceitas() {
        return listaReceitas;
    }
    
    public void adicionar(Receita umaReceita) {
        listaReceitas.add(umaReceita);
    }
    
    public void remover(Receita umaReceita) {
        listaReceitas.remove(umaReceita);
    }
    
    public Receita pesquisar(String nome) {
        for (Receita b: listaReceitas) {
            if (b.getNome().equalsIgnoreCase(nome)) return b;
        }
        return null;
    }
}