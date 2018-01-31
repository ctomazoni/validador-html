/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validador;

import java.io.IOException;

/**
 *
 * @author Cleber Tomazoni, Gabriel Deggau
 */
public class MainParaTestes {
    
    public static void main(String[] args) throws IOException {
        ManipulaArquivo mp = new ManipulaArquivo();
        mp.validarArqHtml("src/arquivoParaTestes/htmlTeste.html");
    }
    
}
