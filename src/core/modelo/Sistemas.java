
package core.modelo;
import core.persistencia.*;
public class Sistemas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Sistemas.class.getName());

    public Sistemas() {
        initComponents();
        armarGrafo();
        definirAristas();
        inicializarEstados();
        conectarListeners();
        actualizarInterfaz();
    }
    
    private Grafo grafo = new Grafo();
    
    private void armarGrafo(){
        grafo.registrar("Algebra lineal", algebra);    
        grafo.registrar("Calculo 1", calculo1);   
        grafo.registrar("Introduccion a la ingenieria", introduccion);    
        grafo.registrar("Algoritmia 1", algoritmia1);
        grafo.registrar("Competencias 1",  competencias1);    
        grafo.registrar("Ingles 1",  ingles1);    
        grafo.registrar("Electiva historia",  historia);    
        grafo.registrar("Calculo 2", calculo2);   
        grafo.registrar("Fisica mecanica", fisicamecanica);
        grafo.registrar("Algoritmia 2", algoritmia2);
        grafo.registrar("Competencias 2", competencias2);
        grafo.registrar("Ingles 2", ingles2);    
        grafo.registrar("Electiva humanidades", humanidades);    
        grafo.registrar("Calculo 3", calculo3);   
        grafo.registrar("Fisica calor", fisicacalor);
        grafo.registrar("Estructuras 1", estructuras1);
        grafo.registrar("POO", poo);
        grafo.registrar("Ingles 3", ingles3);    
        grafo.registrar("Electiva ciencias de la vida", cienciasvida);    
        grafo.registrar("Ecuaciones", ecuaciones);   
        grafo.registrar("Fisica electrica", fisicaelectrica);
        grafo.registrar("Estructuras 2", estructuras2);
        grafo.registrar("Matematicas discretas", discretas);
        grafo.registrar("Ingles 4", ingles4);   
        grafo.registrar("Seminario 1", seminario1);
        grafo.registrar("Electiva ciencias basicas", cienciasbasicas);
        grafo.registrar("Analisis de datos", analisisdatos);
        grafo.registrar("Algoritmos y complejidad", complejidad);    
        grafo.registrar("Estructuras discretas", estructurasdiscretas);    
        grafo.registrar("Diseño digital", diseño);   
        grafo.registrar("Ingles 5", ingles5);
        grafo.registrar("Examen comprehensivo 1", examencom1);   
        grafo.registrar("Electiva basica profesional", basicaprofesional);
        grafo.registrar("Soluciones computacionales", soluciones);   
        grafo.registrar("Bases de datos", basesdatos);
        grafo.registrar("Redes", redes);
        grafo.registrar("Estructura del computador 1",estructuracomputador1);
        grafo.registrar("Ingles 6", ingles6);  
        grafo.registrar("Electiva etica", etica);    
        grafo.registrar("Optimizacion", optimizacion);   
        grafo.registrar("Diseño de software 1", diseñosoftware1);
        grafo.registrar("Sistemas operativos", sistemasoperativos);
        grafo.registrar("Estructura del computador 2", estructuracomputador2);
        grafo.registrar("Ingles 7", ingles7);    
        grafo.registrar("Electiva sociales", sociales);    
        grafo.registrar("Electiva profesional 1", profesional1);   
        grafo.registrar("Diseño de software 2", diseñosoftware2);
        grafo.registrar("Electiva en redes", electivaredes);
        grafo.registrar("Compiladores", compiladores);
        grafo.registrar("Ingles 8", ingles8);    
        grafo.registrar("Electiva innovacion", innovacion);    
        grafo.registrar("Electiva filosofia", filosofia);   
        grafo.registrar("Electiva profesional 2", profesional2);
        grafo.registrar("Electiva ciencias computacion", cienciascomputacion);
        grafo.registrar("Electiva gestion informatica", gestionInformatica);   
        grafo.registrar("Electiva formacion complementaria 1", formacionComplementaria1);
        grafo.registrar("Examen comprehensivo 2", examencom2);
        grafo.registrar("Electiva estudios caribe", estudiosdelcaribe);    
        grafo.registrar("Electiva profesional 3", profesional3);   
        grafo.registrar("Proyecto final", proyectofinal);
        grafo.registrar("Electiva formacion complementaria 2", formacioncomplementaria2);
        grafo.registrar("Seminario 2", seminario2);
        
    }
    
    private void definirAristas(){
        //CONECTAR LAS ARISTAS
        grafo.prereq("Calculo 3", "Algebra lineal");
        grafo.prereq("Calculo 2", "Calculo 1");
        grafo.prereq("Fisica mecanica", "Calculo 1");
        grafo.prereq("Fisica calor", "Calculo 1");
        grafo.prereq("Algoritmia 2", "Algoritmia 1");
        grafo.prereq("Competencias 2", "Competencias 1");
        grafo.prereq("Ingles 2", "Ingles 1");
        grafo.prereq("Ingles 3", "Ingles 2");
        grafo.prereq("Ingles 4", "Ingles 3");
        grafo.prereq("Ingles 5", "Ingles 4");
        grafo.prereq("Ingles 6", "Ingles 5");
        grafo.prereq("Ingles 7", "Ingles 6");
        grafo.prereq("Ingles 8", "Ingles 7");
        grafo.prereq("Calculo 3", "Calculo 2");
        grafo.prereq("Ecuaciones", "Calculo 2");
        grafo.prereq("Analisis de datos", "Calculo 2");
        grafo.prereq("Fisica electrica", "Calculo 2");
        grafo.prereq("Fisica calor", "Fisica mecanica");
        grafo.prereq("Fisica electrica", "Fisica mecanica");
        grafo.prereq("Estructuras 1", "Algoritmia 2");
        grafo.prereq("POO", "Algoritmia 2");
        grafo.prereq("Estructuras 2", "Estructuras 1");
        grafo.prereq("Compiladores", "POO");
        grafo.prereq("Soluciones computacionales", "Ecuaciones");
        grafo.prereq("Algoritmos y complejidad", "Estructuras 2");
        grafo.prereq("Compiladores", "Estructuras 2");
        grafo.prereq("Estructuras discretas", "Matematicas discretas");
        grafo.prereq("Diseño digital", "Matematicas discretas");
        grafo.prereq("Optimizacion", "Analisis de datos");
        grafo.prereq("Bases de datos", "Algoritmos y complejidad");
        grafo.prereq("Estructura del computador 1", "Diseño digital");
        grafo.prereq("Optimizacion", "Soluciones computacionales");
        grafo.prereq("Diseño de software 1", "Bases de datos");
        grafo.prereq("Electiva en redes", "Redes");
        grafo.prereq("Sistemas operativos", "Estructura del computador 1");
        grafo.prereq("Estructura del computador 2", "Estructura del computador 1");
        grafo.prereq("Diseño de software 2", "Diseño de software 1");
        grafo.prereq("Proyecto final", "Diseño de software 2");
        grafo.prereq("Proyecto final", "Examen comprehensivo 2");
        grafo.prereq("Proyecto final", "Ingles 8");
        grafo.prereq("Examen comprehensivo 2", "Examen comprehensivo 1");
    }
    
    private void inicializarEstados() {
        for (Nodo nodo : grafo.getNodos().values()) {
            nodo.setEstado(nodo.getPrereqs().isEmpty() ? Estado.DISPONIBLE : Estado.BLOQUEADA);
        }
    }
    
    private void conectarListeners() {
        for (Nodo n : grafo.getNodos().values()) {
            n.getBoton().addActionListener(e -> onClickNodo(n));
        }
    }
    
    private void onClickNodo(Nodo n) {
    
    if (n.getEstado() != Estado.DISPONIBLE) {
        java.awt.Toolkit.getDefaultToolkit().beep();
        return;
    }
    n.setEstado(Estado.APROBADA);

    // desbloquear sucesoras que ya cumplan todos los prereqs
    for (String sucId : n.getSucesoras()) {
        Nodo s = grafo.getNodos().get(sucId);
        if (todosPreAprobados(s) && s.getEstado() != Estado.APROBADA) {
            s.setEstado(Estado.DISPONIBLE);
        }
    }
    actualizarInterfaz();
    }
    
    private boolean todosPreAprobados(Nodo n) {
        for (String pre : n.getPrereqs()) {
            if (grafo.getNodos().get(pre).getEstado() != Estado.APROBADA) 
                return false;
        }
        return true;
    }
    private void actualizarInterfaz() {
        for (Nodo n : grafo.getNodos().values()) {
            switch (n.getEstado()) {
                case BLOQUEADA -> {
                    n.getBoton().setEnabled(true);
                    n.getBoton().setBackground(new java.awt.Color(200,220,220));
                    n.getBoton().setForeground(java.awt.Color.DARK_GRAY);
                }
                case DISPONIBLE -> {
                    n.getBoton().setEnabled(true);
                    n.getBoton().setBackground(javax.swing.UIManager.getColor("Button.background"));
                    n.getBoton().setForeground(java.awt.Color.BLACK);
                }
                case APROBADA -> {
                    n.getBoton().setEnabled(true);
                    n.getBoton().setContentAreaFilled(true);
                    n.getBoton().setBackground(new java.awt.Color(180,255,180));
                    n.getBoton().setForeground(java.awt.Color.BLACK);
                   
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        algebra = new javax.swing.JButton();
        competencias1 = new javax.swing.JButton();
        ingles1 = new javax.swing.JButton();
        calculo1 = new javax.swing.JButton();
        introduccion = new javax.swing.JButton();
        algoritmia1 = new javax.swing.JButton();
        RegresarBtn = new javax.swing.JButton();
        historia = new javax.swing.JButton();
        competencias2 = new javax.swing.JButton();
        ingles2 = new javax.swing.JButton();
        calculo2 = new javax.swing.JButton();
        fisicamecanica = new javax.swing.JButton();
        algoritmia2 = new javax.swing.JButton();
        humanidades = new javax.swing.JButton();
        poo = new javax.swing.JButton();
        ingles3 = new javax.swing.JButton();
        calculo3 = new javax.swing.JButton();
        fisicacalor = new javax.swing.JButton();
        estructuras1 = new javax.swing.JButton();
        cienciasvida = new javax.swing.JButton();
        discretas = new javax.swing.JButton();
        ingles4 = new javax.swing.JButton();
        ecuaciones = new javax.swing.JButton();
        fisicaelectrica = new javax.swing.JButton();
        estructuras2 = new javax.swing.JButton();
        cienciasbasicas = new javax.swing.JButton();
        diseño = new javax.swing.JButton();
        ingles5 = new javax.swing.JButton();
        analisisdatos = new javax.swing.JButton();
        complejidad = new javax.swing.JButton();
        estructurasdiscretas = new javax.swing.JButton();
        basicaprofesional = new javax.swing.JButton();
        estructuracomputador1 = new javax.swing.JButton();
        ingles6 = new javax.swing.JButton();
        soluciones = new javax.swing.JButton();
        basesdatos = new javax.swing.JButton();
        redes = new javax.swing.JButton();
        etica = new javax.swing.JButton();
        estructuracomputador2 = new javax.swing.JButton();
        ingles7 = new javax.swing.JButton();
        optimizacion = new javax.swing.JButton();
        diseñosoftware1 = new javax.swing.JButton();
        sistemasoperativos = new javax.swing.JButton();
        sociales = new javax.swing.JButton();
        compiladores = new javax.swing.JButton();
        ingles8 = new javax.swing.JButton();
        profesional1 = new javax.swing.JButton();
        diseñosoftware2 = new javax.swing.JButton();
        electivaredes = new javax.swing.JButton();
        filosofia = new javax.swing.JButton();
        formacionComplementaria1 = new javax.swing.JButton();
        examencom2 = new javax.swing.JButton();
        profesional2 = new javax.swing.JButton();
        cienciascomputacion = new javax.swing.JButton();
        gestionInformatica = new javax.swing.JButton();
        estudiosdelcaribe = new javax.swing.JButton();
        seminario2 = new javax.swing.JButton();
        profesional3 = new javax.swing.JButton();
        proyectofinal = new javax.swing.JButton();
        formacioncomplementaria2 = new javax.swing.JButton();
        seminario1 = new javax.swing.JButton();
        examencom1 = new javax.swing.JButton();
        innovacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        algebra.setText("Algebra Lineal");
        algebra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algebraActionPerformed(evt);
            }
        });

        competencias1.setText("Competencias comunicativas 1");

        ingles1.setText("Ingles 1");

        calculo1.setText("Calculo 1");

        introduccion.setText("Introduccion a ingenieria de sistemas");

        algoritmia1.setText("Algoritmia y programacion 1");

        RegresarBtn.setText("Regresar");
        RegresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBtnActionPerformed(evt);
            }
        });

        historia.setText("Electiva Historia");

        competencias2.setText("Competencias comunicativas 2");

        ingles2.setText("Ingles 2");

        calculo2.setText("Calculo 2");

        fisicamecanica.setText("Fisica mecanica");

        algoritmia2.setText("Algoritmia y programacion 2");

        humanidades.setText("Electiva Humanidades");

        poo.setText("POO ");

        ingles3.setText("Ingles 3");

        calculo3.setText("Calculo 3");

        fisicacalor.setText("Fisica calor ondas");

        estructuras1.setText("Estructura de datos 1");

        cienciasvida.setText("Electica ciencias de la vida");

        discretas.setText("Matematicas discretas");

        ingles4.setText("Ingles 4");

        ecuaciones.setText("Ecuaciones diferenciales");

        fisicaelectrica.setText("Fisica electricidad");

        estructuras2.setText("Estructura de datos 2");

        cienciasbasicas.setText("Electiva ciencias basicas ");

        diseño.setText("Diseño digital");

        ingles5.setText("Ingles 5");

        analisisdatos.setText("Analisis de datos en ing");

        complejidad.setText("Algoritmia y complejidad");

        estructurasdiscretas.setText("Estructuras discretas");

        basicaprofesional.setText("Electiva basica profesional");

        estructuracomputador1.setText("Estructura del computador 1");

        ingles6.setText("Ingles 6");

        soluciones.setText("Soluciones computacionales");

        basesdatos.setText("Bases de datos");

        redes.setText("Redes");

        etica.setText("Electiva en ética");

        estructuracomputador2.setText("Estructura del computador 2 ");

        ingles7.setText("Ingles 7");

        optimizacion.setText("Optimizacion");

        diseñosoftware1.setText("Diseño de software 1");

        sistemasoperativos.setText("Sistemas operativos");

        sociales.setText("Electiva en ciencias sociales");

        compiladores.setText("Compiladores");

        ingles8.setText("Ingles 8");
        ingles8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingles8ActionPerformed(evt);
            }
        });

        profesional1.setText("Electiva profesional 1");
        profesional1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesional1ActionPerformed(evt);
            }
        });

        diseñosoftware2.setText("Diseño de software 2");

        electivaredes.setText("Electiva redes");

        filosofia.setText("Electiva en filosofia");

        formacionComplementaria1.setText("Electiva formacion complementaria 1");

        examencom2.setText("Examen comprehensivo 2");

        profesional2.setText("Electiva profesional 2");

        cienciascomputacion.setText("Electiva ciencias de la computacion");

        gestionInformatica.setText("Electiva gestion informatica");

        estudiosdelcaribe.setText("Electiva en estudios del caribe");

        seminario2.setText("Seminario de carrera 2");

        profesional3.setText("Electiva profesional 3");

        proyectofinal.setText("Proyecto final");

        formacioncomplementaria2.setText("Electiva formacion complementaria 2");

        seminario1.setText("Seminario de carrera 1");

        examencom1.setText("Examen comprehensivo 1");

        innovacion.setText("Electiva innovacion");
        innovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                innovacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cienciasvida, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cienciasbasicas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(basicaprofesional, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(optimizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(algoritmia2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estructuras1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(poo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estructuras2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discretas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(complejidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estructurasdiscretas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diseño, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ingles5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(basesdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(redes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estructuracomputador1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(diseñosoftware1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sistemasoperativos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estructuracomputador2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profesional1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profesional2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diseñosoftware2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electivaredes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compiladores, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cienciascomputacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gestionInformatica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formacionComplementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profesional3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seminario2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(profesional3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(seminario2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cienciasvida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cienciasbasicas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(basicaprofesional, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(optimizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(profesional1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(profesional2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complejidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(basesdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diseñosoftware1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ingles1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(algoritmia2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(estructuras1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(poo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ingles3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(estructuras2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(discretas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ingles4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(estructurasdiscretas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(diseño, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ingles5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(redes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(estructuracomputador1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(sistemasoperativos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(estructuracomputador2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(diseñosoftware2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cienciascomputacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(electivaredes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(compiladores, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(gestionInformatica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(formacionComplementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarBtnActionPerformed
        SeleccionCarrera frameseleccion = new SeleccionCarrera();
        this.dispose();
        frameseleccion.setVisible(true);
    }//GEN-LAST:event_RegresarBtnActionPerformed

    private void algebraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algebraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_algebraActionPerformed

    private void ingles8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingles8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingles8ActionPerformed

    private void innovacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_innovacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_innovacionActionPerformed

    private void profesional1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesional1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesional1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Sistemas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegresarBtn;
    private javax.swing.JButton algebra;
    private javax.swing.JButton algoritmia1;
    private javax.swing.JButton algoritmia2;
    private javax.swing.JButton analisisdatos;
    private javax.swing.JButton basesdatos;
    private javax.swing.JButton basicaprofesional;
    private javax.swing.JButton calculo1;
    private javax.swing.JButton calculo2;
    private javax.swing.JButton calculo3;
    private javax.swing.JButton cienciasbasicas;
    private javax.swing.JButton cienciascomputacion;
    private javax.swing.JButton cienciasvida;
    private javax.swing.JButton competencias1;
    private javax.swing.JButton competencias2;
    private javax.swing.JButton compiladores;
    private javax.swing.JButton complejidad;
    private javax.swing.JButton discretas;
    private javax.swing.JButton diseño;
    private javax.swing.JButton diseñosoftware1;
    private javax.swing.JButton diseñosoftware2;
    private javax.swing.JButton ecuaciones;
    private javax.swing.JButton electivaredes;
    private javax.swing.JButton estructuracomputador1;
    private javax.swing.JButton estructuracomputador2;
    private javax.swing.JButton estructuras1;
    private javax.swing.JButton estructuras2;
    private javax.swing.JButton estructurasdiscretas;
    private javax.swing.JButton estudiosdelcaribe;
    private javax.swing.JButton etica;
    private javax.swing.JButton examencom1;
    private javax.swing.JButton examencom2;
    private javax.swing.JButton filosofia;
    private javax.swing.JButton fisicacalor;
    private javax.swing.JButton fisicaelectrica;
    private javax.swing.JButton fisicamecanica;
    private javax.swing.JButton formacionComplementaria1;
    private javax.swing.JButton formacioncomplementaria2;
    private javax.swing.JButton gestionInformatica;
    private javax.swing.JButton historia;
    private javax.swing.JButton humanidades;
    private javax.swing.JButton ingles1;
    private javax.swing.JButton ingles2;
    private javax.swing.JButton ingles3;
    private javax.swing.JButton ingles4;
    private javax.swing.JButton ingles5;
    private javax.swing.JButton ingles6;
    private javax.swing.JButton ingles7;
    private javax.swing.JButton ingles8;
    private javax.swing.JButton innovacion;
    private javax.swing.JButton introduccion;
    private javax.swing.JButton optimizacion;
    private javax.swing.JButton poo;
    private javax.swing.JButton profesional1;
    private javax.swing.JButton profesional2;
    private javax.swing.JButton profesional3;
    private javax.swing.JButton proyectofinal;
    private javax.swing.JButton redes;
    private javax.swing.JButton seminario1;
    private javax.swing.JButton seminario2;
    private javax.swing.JButton sistemasoperativos;
    private javax.swing.JButton sociales;
    private javax.swing.JButton soluciones;
    // End of variables declaration//GEN-END:variables
}
