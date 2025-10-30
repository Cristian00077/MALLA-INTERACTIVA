package core.persistencia;
import java.util.*;

public class Grafo {
    private final Map<String, Nodo> nodos = new HashMap<>();
    
    public Nodo registrar(String id, javax.swing.JButton boton) {
        Nodo n = new Nodo(id, boton);
        nodos.put(id, n);
        return n;
    }

    public void prereq(String curso, String pre) {
        nodos.get(curso).getPrereqs().add(pre);
        nodos.get(pre).getSucesoras().add(curso);
    }

    public Map<String, Nodo> getNodos() { 
        return nodos; 
    }
}
