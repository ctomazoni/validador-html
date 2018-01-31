package lista;

public class Lista <T> {
    
    private NoLista<T> primeiro;
    
    public Lista() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }
    
    public void inserir(T info) {
        NoLista<T> novo = new NoLista();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }
    
    public void exibir() {
        NoLista<T> p = primeiro;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }
    
    public boolean estaVazia() {
        return primeiro == null;
    }
    
    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }
    
    public void retirar(T info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;
        
        // procura o nó que contém dado a ser removido, guardando o anterior
        while (p != null && !p.getInfo().equals(info)) {
            anterior = p;
            p = p.getProximo();
        }
        
        // Se achou nó, retira da lista
        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }
    
    public int obterComprimento() {
        NoLista<T> p = primeiro;
        int comprimento = 0;
        
        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }
        
        return comprimento;
    }
    
    public T obterUltimo() {        
        if (estaVazia()) {
            throw new ListaVaziaException();
        }
        
        NoLista<T> p = primeiro;
        
        while(p.getProximo() != null) {
            p = p.getProximo();
        }
        
        return p.getInfo();
    }
    
    @Override
    public boolean equals(Object lista) {
        if (this == lista) {
            return true;
        }
        if (lista == null) {
            return false;
        }
        if (getClass() != lista.getClass()) {
            return false;
        }
        
        Lista<T> outraLista = (Lista<T>) lista;
        
        NoLista<T> p1 = this.getPrimeiro();
        NoLista<T> p2 = outraLista.getPrimeiro();
        
        while ((p1!=null) && (p2!=null)) {
            if (!(p1.getInfo().equals(p2.getInfo()))) {
                return false;
            }
            
            p1 = p1.getProximo();
            p2 = p2.getProximo();
        }
        
        return (p1==null) && (p2==null);
    }
    
    public NoLista<T> getNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException("Nó inválido.");
        }
           
        NoLista<T> p = primeiro; 
        
        while((p != null) && (idx > 0)) {
            idx--;
            p = p.getProximo();
        }
        
        if (p == null) {
            throw new IndexOutOfBoundsException("Nó inválido.");
        }
            
        return p;
    }
    
    public Lista<T> criarInvertida() {
        Lista<T> invertida = new Lista<>();
        NoLista<T> p = primeiro;
        
        while (p != null) {
            invertida.inserir(p.getInfo());
            p = p.getProximo();
        }
        
        return invertida;
    }
    
}
