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
public class FechaTagException extends RuntimeException {

    public FechaTagException(int numLinha, String tagEsperada, String tagEncontrada) {
        super("Linha " + numLinha + ": Foi encontrada a tag '" + tagEncontrada +
                "' quando era esperada a tag '" + tagEsperada + "'.");
    }
    
}
