package core.persistencia;
import java.util.*;
import javax.swing.JButton;

public class Grafo {
    private final Map<String, Nodo> nodos = new HashMap<>();
    
    public Nodo registrar(String id, JButton boton, int creditos) {
        Nodo n = new Nodo(id, boton, creditos);
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
    
    public void aprobarNodo(Nodo n) {
        n.setEstado(Estado.APROBADA);
        for (String sucId : n.getSucesoras()) {
            Nodo s = nodos.get(sucId);
            if (todosPreAprobados(s) && s.getEstado() != Estado.APROBADA) {
                s.setEstado(Estado.DISPONIBLE);
            }
        }
    }
    
    public boolean todasAprobadas() {
    for (Nodo nodo : nodos.values()) {
        if (nodo.getEstado() != Estado.APROBADA) {
            return false;
        }
    }
        return true;
    }
    
    public boolean todosPreAprobados(Nodo n) {
        for (String pre : n.getPrereqs()) {
            if (nodos.get(pre).getEstado() != Estado.APROBADA) 
                return false;
        }
        return true;
    }
    
    public int calcularCreditosAprobados() {
    int total = 0;
    for (Nodo nodo : nodos.values()) {
        if (nodo.getEstado() == Estado.APROBADA) {
            total = total + nodo.getCreditos();
        }
    }
        return total;
    }
    
    /*public void revocarNodo(Nodo n) {
    n.setEstado(Estado.DISPONIBLE);
    // Bloquear las sucesoras dependientes de este nodo
    for (String sucId : n.getSucesoras()) {
        Nodo s = nodos.get(sucId);
        // Si alguna de sus prereqs ahora ya no está aprobada, se bloquea
        if (!todosPreAprobados(s)) {
            s.setEstado(Estado.BLOQUEADA);
            // Y se propaga el bloqueo recursivamente
            revocarNodo(s);
        }
        }
    }*/
    
    /*public void revocarNodo(Nodo n){
        n.setEstado(Estado.DISPONIBLE);
        for (String sucId : n.getSucesoras()) {
            Nodo s = nodos.get(sucId);
            if (!todosPreAprobados(s)) {
                s.setEstado(Estado.BLOQUEADA);
                
            }
        }
    }*/
    
    public void revocarNodo(Nodo n) {
    n.setEstado(Estado.DISPONIBLE);
    for (String sucId : n.getSucesoras()) {
        Nodo s = nodos.get(sucId);
            if (!todosPreAprobados(s)) {
                bloquearEnCadena(s);
            }
        }
    }   
    
    private void bloquearEnCadena(Nodo n) {
    if (n.getEstado() == Estado.BLOQUEADA)
        return; 
    n.setEstado(Estado.BLOQUEADA);
    for (String sucId : n.getSucesoras()) {
        Nodo s = nodos.get(sucId);
        bloquearEnCadena(s); 
    }
}

    
}
