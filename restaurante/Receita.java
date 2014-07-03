package restaurante;

import java.util.ArrayList;

public class Receita {
    
    private String nome;
    private ArrayList<Ingrediente> listaIngredientes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }
    
    
    
}
