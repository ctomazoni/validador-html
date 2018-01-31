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
public class TagNaoFechadaException extends RuntimeException {

    public TagNaoFechadaException(String tagNaoFechadas) {
        super("Não foi encontrado fechamento da(s) tag(s): " + tagNaoFechadas);
    }
    
}
