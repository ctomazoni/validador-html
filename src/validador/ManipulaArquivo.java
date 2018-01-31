/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lista.Lista;
import pilha.PilhaLista;

/**
 *
 * @author Cleber Tomazoni, Gabriel Deggau
 */
public class ManipulaArquivo {
    
    private BufferedReader arquivo;
    PilhaLista<String> pilha = new PilhaLista<>();
    Lista<Tag> tags = new Lista<>();

    public BufferedReader getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arq) throws IOException {
        this.arquivo = new BufferedReader(new FileReader(arq));
    }
    
    private boolean isTagSemPar(String nomeTag) {
        if (nomeTag.equals("br")
                || nomeTag.equals("meta")
                || nomeTag.equals("base")
                || nomeTag.equals("col")
                || nomeTag.equals("command")
                || nomeTag.equals("embed")
                || nomeTag.equals("hr")
                || nomeTag.equals("img")
                || nomeTag.equals("input")
                || nomeTag.equals("link")
                || nomeTag.equals("param")
                || nomeTag.equals("source")
                || nomeTag.equals("!DOCTYPE")) {
            return true;
        }
        return false;
    }
    
    private void lerArquivo() throws IOException, RuntimeException {
        String linha = getArquivo().readLine();
        String nomeTag = "";
        int numLinha = 0;
        while ((linha) != null) {
            numLinha++;
            int i = 0;
            while (i < linha.length() - 1) {
                if (linha.charAt(i) == '<') {
                    if (linha.charAt(i+1) != '/') {
                        i++;
                        while (linha.charAt(i) != '>'
                                && linha.charAt(i) != ' ') {
                            nomeTag += linha.charAt(i);
                            i++;                            
                        }
                        nomeTag = nomeTag.replaceAll("/", "");
                        if (!isTagSemPar(nomeTag)) {
                            pilha.push(nomeTag);
                        }
                        contabilizarTag(nomeTag);
                        nomeTag = "";
                    } else {
                        i += 2;
                        while (linha.charAt(i) != '>') {
                            nomeTag += linha.charAt(i);
                            i++;
                        }
                        if (pilha.peek().equals(nomeTag)) {
                            pilha.pop();
                            nomeTag = "";
                        } else {
                            throw new FechaTagException(numLinha, pilha.peek(), nomeTag);
                        }
                    }
                } else {
                    i++;
                }
            }
            linha = getArquivo().readLine();
        }
        if (!pilha.estaVazia()) {
            throw new TagNaoFechadaException(pilha.toString());
        }
    }
    
    private void contabilizarTag(String nomeTag) {
        boolean tagExiste = false;
        for (int i = 0; i < tags.obterComprimento(); i++) {
            if (tags.getNo(i).getInfo().getNome().equals(nomeTag)) {
                tags.getNo(i).getInfo().incrementaQtd();
                tagExiste = true;
            }
        }
        if (!tagExiste) {
            Tag tag = new Tag(nomeTag);
            tags.inserir(tag);
        }
    }
    
    private void exibirQtdTags() {
        for (int i = 0; i < tags.obterComprimento(); i++) {
            System.out.println("Tag " + tags.getNo(i).getInfo().getNome() +
                    " apareceu " + tags.getNo(i).getInfo().getQuantidade() + " vez(es).");
        }
    }
    
    public void validarArqHtml(String arqHtml) throws IOException {
        System.out.println("Validando arquivo...");
        this.setArquivo(arqHtml);
        this.lerArquivo();
        this.exibirQtdTags();
        this.fechaArquivo();
        System.out.println("Arquivo validado.");
    }
    
    private void fechaArquivo() throws IOException {
        getArquivo().close();
    }
    
}
