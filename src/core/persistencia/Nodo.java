
package core.persistencia;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;

public class Nodo {
    private String materia;
    private JButton boton;             
    private Set<String> prereqs = new HashSet<>();
    private Set<String> sucesoras = new HashSet<>();
    private Estado estado = Estado.BLOQUEADA;

    public Nodo(String materia, JButton boton) {
        this.materia = materia;
        this.boton = boton;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Set<String> getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(Set<String> prereqs) {
        this.prereqs = prereqs;
    }

    public Set<String> getSucesoras() {
        return sucesoras;
    }

    public void setSucesoras(Set<String> sucesoras) {
        this.sucesoras = sucesoras;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
   
}
