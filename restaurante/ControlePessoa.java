package restaurante;

import java.util.ArrayList;

/**
 *
 * @author niets
 */
public class ControlePessoa {

    private ArrayList<Pessoa> listaPessoas;

    public ControlePessoa() {
        this.listaPessoas = new ArrayList<Pessoa>();
    }
    
    public ArrayList<Pessoa> getListaJudocas() {
        return listaPessoas;
    }
    
    public void adicionar(Pessoa umaPessoa) {
        listaPessoas.add(umaPessoa);
    }
    
    public void remover(Pessoa umaPessoa) {
        listaPessoas.remove(umaPessoa);
    }
    
    public Pessoa pesquisar(String nome) {
        for (Pessoa b: listaPessoas) {
            if (b.getNome().equalsIgnoreCase(nome)) return b;
        }
        return null;
    }
}
