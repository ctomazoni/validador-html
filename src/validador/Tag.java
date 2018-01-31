/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validador;

/**
 *
 * @author Cleber Tomazoni, Gabriel Deggau
 */
public class Tag {
    
    private String nome;
    private int quantidade;

    public Tag(String nome) {
        this.nome = nome;
        this.quantidade = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public void incrementaQtd() {
        quantidade++;
    }
    
}
