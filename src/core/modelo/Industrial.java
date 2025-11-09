
package core.modelo;

import core.persistencia.Estado;
import core.persistencia.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Industrial extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Industrial.class.getName());
    private Map<Integer, List<Nodo>> materiasPorSemestre = new HashMap<>();

    public Industrial() {
        initComponents();
        armarGrafo();
        definirAristas();
        inicializarEstados();
        conectarListeners();
        actualizarInterfaz();
        agruparPorSemestre();
        conectarBotonesSemestre();
    }
    
    private Grafo grafo = new Grafo();
    
    private void armarGrafo(){
        // Semestre 1
        grafo.registrar("Algebra Lineal", algebra, 3);
        grafo.registrar("Calculo 1", calculo1, 5);
        grafo.registrar("Introduccion a la Ing. Industrial", introduccion, 1);
        grafo.registrar("Expresion Grafica", expresion, 3);
        grafo.registrar("Competencias comunicativas 1", competencias1, 3);
        grafo.registrar("Ingles 1", ingles1, 0);

        // Semestre 2
        grafo.registrar("Calculo 2", calculo2, 4);
        grafo.registrar("Fisica mecanica", fisicamecanica, 4);
        grafo.registrar("Algoritmia y Programacion 1", algoritmia1, 3);
        grafo.registrar("Electiva de Ciencias de la Vida", logisticaydistribucion, 3);
        grafo.registrar("Competencias comunicativas 2", competencias2, 3);
        grafo.registrar("Ingles 2", ingles2, 0);

        // Semestre 3
        grafo.registrar("Calculo 3", calculo3, 4);
        grafo.registrar("Fisica calor ondas", fisicacalor, 4);
        grafo.registrar("Estatica", estatica, 3);
        grafo.registrar("Ciencia de los Materiales", cienciadelosmateriales, 3);
        grafo.registrar("Humanidades", humanidades, 3);
        grafo.registrar("Ingles 3", ingles3, 0);

        // Semestre 4
        grafo.registrar("Ecuaciones", ecuaciones, 3);
        grafo.registrar("Fisica electricidad", fisicaelectrica, 4);
        grafo.registrar("Termodinamica 1", termo1, 3);
        grafo.registrar("Procesos de Fabricacion", procesosfabricacion, 3);
        grafo.registrar("Estrategia de Operaciones", estrategiaoperaciones, 4);
        grafo.registrar("Ingles 4", ingles4, 0);
        grafo.registrar("Seminario de Carrera 1", seminario1, 0);

        // Semestre 5
        grafo.registrar("Estudio del Trabajo", estudiotrabajo, 3);
        grafo.registrar("Sistemas de Costos de Produccion", sistemascostosproduccion, 3);
        grafo.registrar("Analisis de Datos en Ingenieria", analisisdatoss, 4);
        grafo.registrar("Soluciones Computacionales", soluciones, 3);
        grafo.registrar("Electiva Basica Profesional", basicaprofesionall, 3);
        grafo.registrar("Examen comprehensivo 1", examencom1, 0);
        grafo.registrar("Ingles 5", ingles5, 0);

        // Semestre 6
        grafo.registrar("Diseño de Sistemas Productivos", diseñosistemasproductivos, 3);
        grafo.registrar("Investigacion de Operaciones 1", investigacionoperaciones, 3);
        grafo.registrar("Analisis de Datos en Ingenieria 2", analisisdatos2, 3);
        grafo.registrar("Ingenieria Economica", ingenieriaeconomica, 3);
        grafo.registrar("Electiva ciencias sociales", socialess, 3);
        grafo.registrar("Ingles 6", ingles6, 0);

        // Semestre 7
        grafo.registrar("Plan. Progr. Control produccion", planprog, 3);
        grafo.registrar("Investigacion de Operaciones 2", investigacionoperaciones2, 3);
        grafo.registrar("Control y Gestion integral Calidad", controlygestion, 4);
        grafo.registrar("Analisis y Eval. de Proy. de Inv.", analisisyeval, 3);
        grafo.registrar("Electiva en Etica", eticaa, 3);
        grafo.registrar("Ingles 7", ingles7, 0);

        // Semestre 8
        grafo.registrar("Logistica y Distribucion", logisticaydistribucion, 3);
        grafo.registrar("Simulacion", simulacion, 3);
        grafo.registrar("Seguridad y Gestion Ambiental", seguridadygestionambiental, 3);
        grafo.registrar("Analisis de Mod. de Gest. del Tal. Hum", analisisdemod, 3);
        grafo.registrar("Electiva Innovacion, Dllo y Soc", innovacion, 3);
        grafo.registrar("Ingles 8", ingles8, 0);

        // Semestre 9
        grafo.registrar("Electiva Economico-administrativa", electivaeconomica, 3);
        grafo.registrar("Electiva Gestion de operaciones", electivagestionoperaciones, 3);
        grafo.registrar("Electiva metodos cuantitativos", electivametodoscuantitativos, 3);
        grafo.registrar("Comp. Libre 1", complementaria1, 3);
        grafo.registrar("Examen comprehensivo 2", examencom2, 0);
        grafo.registrar("Seminario de Carrera 2", seminario3, 0);

        // Semestre 10
        grafo.registrar("Proyecto Final", proyectofinal, 3);
        grafo.registrar("Electiva de Estudios del Caribe", estudiosdelcaribe, 3);
        grafo.registrar("Electiva de historia", historia, 3);
        grafo.registrar("Comp. Libre 2", complementaria2, 3);
        grafo.registrar("Electiva de Filosofia", filosofia, 3);
    }
    
    private void definirAristas(){
        //CONECTAR LAS ARISTAS
        grafo.prereq("Calculo 2", "Calculo 1");
        grafo.prereq("Fisica mecanica", "Calculo 1");
        grafo.prereq("Competencias 2", "Competencias 1");
        grafo.prereq("Calculo 3", "Algebra Lineal");
        grafo.prereq("Calculo 3", "Calculo 2");
        grafo.prereq("Fisica calor", "Calculo 1");
        grafo.prereq("Fisica calor", "Fisica mecanica");
        grafo.prereq("Estatica", "Fisica mecanica");
        grafo.prereq("Topografia", "Expresion grafica");
        grafo.prereq("Ecuaciones", "Calculo 2");
        grafo.prereq("Ingles 2", "Ingles 1");
        grafo.prereq("Ingles 3", "Ingles 2");
        grafo.prereq("Ingles 4", "Ingles 3");
        grafo.prereq("Ingles 5", "Ingles 4");
        grafo.prereq("Ingles 6", "Ingles 5");
        grafo.prereq("Ingles 7", "Ingles 6");
        grafo.prereq("Ingles 8", "Ingles 7");
        grafo.prereq("Analisis de datos", "Calculo 2");
        grafo.prereq("Fisica electrica", "Calculo 2");
        grafo.prereq("Fisica electrica", "Fisica mecanica");
        grafo.prereq("Mecanica de solidos", "Estatica");
        grafo.prereq("Materiales de construccion", "Mecanica de solidos");
        grafo.prereq("Soluciones computacionales", "Ecuaciones");
        grafo.prereq("Soluciones computacionales", "Algoritmia 1");
        grafo.prereq("Mecanica de fluidos", "Ecuaciones");
        grafo.prereq("Examen comprehensivo 1", "Ecuaciones");
        grafo.prereq("Examen comprehensivo 1", "Calculo 3");
        grafo.prereq("Examen comprehensivo 1", "Fisica mecanica");
        grafo.prereq("Examen comprehensivo 1", "Fisica calor");
        grafo.prereq("Examen comprehensivo 1", "Fisica electrica");
        grafo.prereq("Analisis estructural", "Mecanica de solidos");
        grafo.prereq("Analisis estructural", "Examen comprehensivo 1");
        grafo.prereq("Mecanica de suelos", "Mecanica de solidos");
        grafo.prereq("Mecanica de suelos", "Geologia");
        grafo.prereq("Mecanica de suelos", "Examen comprehensivo 1");
        grafo.prereq("Hidrologia", "Analisis de datos");
        grafo.prereq("Diseño de vias", "Topografia");
        grafo.prereq("Construccion", "Materiales de construccion");
        grafo.prereq("Diseño estructural", "Analisis estructural");
        grafo.prereq("Fundaciones", "Mecanica de suelos");
        grafo.prereq("Hidraulica", "Mecanica de fluidos");
        grafo.prereq("Ingenieria de transporte", "Diseño de vias");
        grafo.prereq("Administracion y control de la construccion", "Construccion");
        grafo.prereq("Acueducto y alcantarillado", "Hidraulica");
        grafo.prereq("Proyecto final", "Ingenieria de transporte");
        grafo.prereq("Proyecto final", "Acueducto y alcantarillado");
        grafo.prereq("Proyecto final", "Administracion y control de la construccion");
        grafo.prereq("Proyecto final", "Examen comprehensivo 2");
        grafo.prereq("Proyecto final", "Ingles 8");
    }
    
    private void agruparPorSemestre() {
        materiasPorSemestre.put(1, Arrays.asList(
                grafo.getNodo("Algebra Lineal"),
                grafo.getNodo("Calculo 1"),
                grafo.getNodo("Expresion Grafica"),
                grafo.getNodo("Introduccion a la Ing. Industrial"),
                grafo.getNodo("Competencias Comunicativas 1"),
                grafo.getNodo("Ingles 1")
        ));

        materiasPorSemestre.put(2, Arrays.asList(
                grafo.getNodo("Calculo 2"),
                grafo.getNodo("Fisica mecanica"),
                grafo.getNodo("Algoritmia y Programacion 1"),
                grafo.getNodo("Electiva de Ciencias de la Vida"),
                grafo.getNodo("Competencias comunicativas 2"),
                grafo.getNodo("Ingles 2")
        ));
        
        materiasPorSemestre.put(3, Arrays.asList(
                grafo.getNodo("Calculo 3"),
                grafo.getNodo("Fisica calor ondas"),
                grafo.getNodo("Estatica"),
                grafo.getNodo("Ciencia de los Materiales"),
                grafo.getNodo("Humanidades"),
                grafo.getNodo("Ingles 3")
        ));

        materiasPorSemestre.put(4, Arrays.asList(
                grafo.getNodo("Ecuaciones"),
                grafo.getNodo("Fisica electricidad"),
                grafo.getNodo("Termodinamica 1"),
                grafo.getNodo("Procesos de Fabricacion"),
                grafo.getNodo("Estrategia de Operaciones"),
                grafo.getNodo("Ingles 4"),
                grafo.getNodo("Seminario de Carrera 1")
        ));
        
        materiasPorSemestre.put(5, Arrays.asList(
                grafo.getNodo("Estudio del Trabajo"),
                grafo.getNodo("Sistemas de Costos de Produccion"),
                grafo.getNodo("Analisis de Datos en Ingenieria"),
                grafo.getNodo("Soluciones Computacionales"),
                grafo.getNodo("Electiva Basica Profesional"),
                grafo.getNodo("Examen comprehensivo 1"),
                grafo.getNodo("Ingles 5")
        ));

        materiasPorSemestre.put(6, Arrays.asList(
                grafo.getNodo("Diseño de Sistemas Productivos"),
                grafo.getNodo("Investigacion de Operaciones 1"),
                grafo.getNodo("Analisis de Datos en Ingenieria 2"),
                grafo.getNodo("Ingenieria Economica"),
                grafo.getNodo("Electiva ciencias sociales"),
                grafo.getNodo("Ingles 6")
        ));

        materiasPorSemestre.put(7, Arrays.asList(
                grafo.getNodo("Plan. Progr. Control produccion"),
                grafo.getNodo("Investigacion de Operaciones 2"),
                grafo.getNodo("Control y Gestion integral Calidad"),
                grafo.getNodo("Analisis y Eval. de Proy. de Inv."),
                grafo.getNodo("Electiva en Etica"),
                grafo.getNodo("Ingles 7")
        ));

        materiasPorSemestre.put(8, Arrays.asList(
                grafo.getNodo("Logistica y Distribucion"),
                grafo.getNodo("Simulacion"),
                grafo.getNodo("Seguridad y Gestion Ambiental"),
                grafo.getNodo("Analisis de Mod. de Gest. del Tal. Hum"),
                grafo.getNodo("Electiva Innovacion, Dllo y Soc"),
                grafo.getNodo("Ingles 8")
        ));

        materiasPorSemestre.put(9, Arrays.asList(
                grafo.getNodo("Electiva Economico-administrativa"),
                grafo.getNodo("Electiva Gestion de operaciones"),
                grafo.getNodo("Electiva metodos cuantitativos"),
                grafo.getNodo("Comp. Libre 1"),
                grafo.getNodo("Examen comprehensivo 2"),
                grafo.getNodo("Seminario de Carrera 2")
        ));

        materiasPorSemestre.put(10, Arrays.asList(
                grafo.getNodo("Proyecto Final"),
                grafo.getNodo("Electiva de Estudios del Caribe"),
                grafo.getNodo("Electiva de historia"),
                grafo.getNodo("Comp. Libre 2"),
                grafo.getNodo("Electiva de Filosofia")
        ));
    }

    private void seleccionarSemestre(int numero) {
        List<Nodo> materias = materiasPorSemestre.get(numero);
        if (materias == null) {
            return;
        }

        for (Nodo n : materias) {
            if (n.getEstado() != Estado.APROBADA) {
                grafo.aprobarNodo(n); // Marca la materia como aprobada
            }
        }
        actualizarInterfaz();
    }

    private void conectarBotonesSemestre() {
        Isem.addActionListener(e -> seleccionarSemestre(1));
        IIsem.addActionListener(e -> seleccionarSemestre(2));
        IIIsem.addActionListener(e -> seleccionarSemestre(3));
        IVsem.addActionListener(e -> seleccionarSemestre(4));
        Vsem.addActionListener(e -> seleccionarSemestre(5));
        VIsem.addActionListener(e -> seleccionarSemestre(6));
        VIIsem.addActionListener(e -> seleccionarSemestre(7));
        VIIIsem.addActionListener(e -> seleccionarSemestre(8));
        IXsem.addActionListener(e -> seleccionarSemestre(9));
        Xsem.addActionListener(e -> seleccionarSemestre(10));
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
    if (n.getEstado() == Estado.APROBADA) {
        grafo.revocarNodo(n);
        actualizarInterfaz();
        return;
    }
    grafo.aprobarNodo(n);
    actualizarInterfaz();
    if (grafo.todasAprobadas()) {
        int creditosTotales = grafo.calcularCreditosAprobados();
        JOptionPane.showMessageDialog(null,
            "FELICIDADES, Has ganado todas las materias\n" +
            "Créditos completados: " + creditosTotales);
    }
}

    private void actualizarInterfaz() {
        for (Nodo n : grafo.getNodos().values()) {
            switch (n.getEstado()) {
                case BLOQUEADA -> {
                    n.getBoton().setEnabled(false);
                    n.getBoton().setBackground(new java.awt.Color(220,220,220));
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

        innovacion = new javax.swing.JButton();
        controlygestion = new javax.swing.JButton();
        examencom2 = new javax.swing.JButton();
        competencias2 = new javax.swing.JButton();
        ingles2 = new javax.swing.JButton();
        calculo2 = new javax.swing.JButton();
        fisicamecanica = new javax.swing.JButton();
        algebra = new javax.swing.JButton();
        competencias1 = new javax.swing.JButton();
        limpiarbtn = new javax.swing.JButton();
        basicaprofesionall = new javax.swing.JButton();
        analisisyeval = new javax.swing.JButton();
        electivagestionoperaciones = new javax.swing.JButton();
        logisticaydistribucion = new javax.swing.JButton();
        electivametodoscuantitativos = new javax.swing.JButton();
        ingles8 = new javax.swing.JButton();
        ingles1 = new javax.swing.JButton();
        simulacion = new javax.swing.JButton();
        calculo1 = new javax.swing.JButton();
        seguridadygestionambiental = new javax.swing.JButton();
        introduccion = new javax.swing.JButton();
        ingles5 = new javax.swing.JButton();
        sistemascostosproduccion = new javax.swing.JButton();
        analisisdatoss = new javax.swing.JButton();
        soluciones = new javax.swing.JButton();
        diseñosistemasproductivos = new javax.swing.JButton();
        complementaria1 = new javax.swing.JButton();
        algoritmia1 = new javax.swing.JButton();
        humanidades = new javax.swing.JButton();
        cienciadelosmateriales = new javax.swing.JButton();
        ingles3 = new javax.swing.JButton();
        ingles6 = new javax.swing.JButton();
        analisisdatos2 = new javax.swing.JButton();
        Isem = new javax.swing.JButton();
        calculo3 = new javax.swing.JButton();
        seminario1 = new javax.swing.JButton();
        fisicacalor = new javax.swing.JButton();
        examencom1 = new javax.swing.JButton();
        ingenieriaeconomica = new javax.swing.JButton();
        IIsem = new javax.swing.JButton();
        IIIsem = new javax.swing.JButton();
        IVsem = new javax.swing.JButton();
        Vsem = new javax.swing.JButton();
        analisisdemod = new javax.swing.JButton();
        VIsem = new javax.swing.JButton();
        expresion = new javax.swing.JButton();
        VIIsem = new javax.swing.JButton();
        electivaeconomica = new javax.swing.JButton();
        VIIIsem = new javax.swing.JButton();
        RegresarBtn = new javax.swing.JButton();
        IXsem = new javax.swing.JButton();
        seminario3 = new javax.swing.JButton();
        termo1 = new javax.swing.JButton();
        fisicaelectrica = new javax.swing.JButton();
        estatica = new javax.swing.JButton();
        ecuaciones = new javax.swing.JButton();
        planprog = new javax.swing.JButton();
        estudiotrabajo = new javax.swing.JButton();
        investigacionoperaciones = new javax.swing.JButton();
        estrategiaoperaciones = new javax.swing.JButton();
        eticaa = new javax.swing.JButton();
        procesosfabricacion = new javax.swing.JButton();
        ingles7 = new javax.swing.JButton();
        ingles4 = new javax.swing.JButton();
        investigacionoperaciones2 = new javax.swing.JButton();
        historia = new javax.swing.JButton();
        estudiosdelcaribe = new javax.swing.JButton();
        filosofia = new javax.swing.JButton();
        proyectofinal = new javax.swing.JButton();
        complementaria2 = new javax.swing.JButton();
        Xsem = new javax.swing.JButton();
        socialess = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        innovacion.setText("Electiva innovacion");
        innovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                innovacionActionPerformed(evt);
            }
        });

        controlygestion.setText("Control y gestion integral calidad");

        examencom2.setText("Examen comprehensivo 2");

        competencias2.setText("Competencias comunicativas 2");

        ingles2.setText("Ingles 2");

        calculo2.setText("Calculo 2");

        fisicamecanica.setText("Fisica mecanica");

        algebra.setText("Algebra Lineal");
        algebra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algebraActionPerformed(evt);
            }
        });

        competencias1.setText("Competencias comunicativas 1");

        limpiarbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        limpiarbtn.setText("Limpiar");
        limpiarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarbtnActionPerformed(evt);
            }
        });

        basicaprofesionall.setText("Electiva basica profesional");

        analisisyeval.setText("Analisis y eval de proy de inv");

        electivagestionoperaciones.setText("Electiva gestion de operaciones");

        logisticaydistribucion.setText("Logistica y distribucion");

        electivametodoscuantitativos.setText("Electiva metodos cuantitativos");

        ingles8.setText("Ingles 8");
        ingles8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingles8ActionPerformed(evt);
            }
        });

        ingles1.setText("Ingles 1");

        simulacion.setText("Simulacion");
        simulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulacionActionPerformed(evt);
            }
        });

        calculo1.setText("Calculo 1");

        seguridadygestionambiental.setText("Seguridad y gestion ambiental");
        seguridadygestionambiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seguridadygestionambientalActionPerformed(evt);
            }
        });

        introduccion.setText("Introduccion a ingenieria mecanica");

        ingles5.setText("Ingles 5");

        sistemascostosproduccion.setText("Sistemas de costos de produccion");

        analisisdatoss.setText("Analisis de datos");

        soluciones.setText("Soluciones computacionales");

        diseñosistemasproductivos.setText("Diseño de sistemas productivos");

        complementaria1.setText("Electiva formacion complementaria 1");

        algoritmia1.setText("Algoritmia y programacion 1");

        humanidades.setText("Electiva humanidades");

        cienciadelosmateriales.setText("Ciencia de los materiales");

        ingles3.setText("Ingles 3");

        ingles6.setText("Ingles 6");

        analisisdatos2.setText("Analisis de datos 2");

        Isem.setText("I");

        calculo3.setText("Calculo 3");

        seminario1.setText("Seminario de carrera 1");

        fisicacalor.setText("Fisica calor ondas");

        examencom1.setText("Examen comprehensivo 1");

        ingenieriaeconomica.setText("Ingenieria economica");

        IIsem.setText("II");
        IIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IIsemActionPerformed(evt);
            }
        });

        IIIsem.setText("III");

        IVsem.setText("IV");

        Vsem.setText("V");

        analisisdemod.setText("Analisis de mod de gest");

        VIsem.setText("VI");

        expresion.setText("Expresion grafica");

        VIIsem.setText("VII");

        electivaeconomica.setText("Electiva economica-administrativa");

        VIIIsem.setText("VIII");

        RegresarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegresarBtn.setText("Regresar");
        RegresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBtnActionPerformed(evt);
            }
        });

        IXsem.setText("IX");

        seminario3.setText("Seminario de carrera 2");

        termo1.setText("Termodinamica 1");

        fisicaelectrica.setText("Fisica electricidad");

        estatica.setText("Estatica");

        ecuaciones.setText("Ecuaciones");

        planprog.setText("Plan prog control produccion");

        estudiotrabajo.setText("Estudio del trabajo");

        investigacionoperaciones.setText("Investigacion de operaciones 1");

        estrategiaoperaciones.setText("Estrategia de operaciones");

        eticaa.setText("Electiva etica");

        procesosfabricacion.setText("Procesos de fabricacion");

        ingles7.setText("Ingles 7");

        ingles4.setText("Ingles 4");

        investigacionoperaciones2.setText("Investigacion de operaciones 2");

        historia.setText("Electiva historia");

        estudiosdelcaribe.setText("Estudios del caribe");

        filosofia.setText("Electiva filosofia");

        proyectofinal.setText("Proyecto final");

        complementaria2.setText("Electiva formacion complementaria 2");

        Xsem.setText("X");

        socialess.setText("Electiva ciencias sociales");
        socialess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                socialessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ingles1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188)
                                .addComponent(ingles3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(ingles4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(ingles5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(580, 580, 580)
                                        .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(446, 446, 446)
                                        .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(320, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(Isem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(IIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(IIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(IVsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(Vsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(VIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(VIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(VIIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(IXsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(estudiotrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(diseñosistemasproductivos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(planprog, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(logisticaydistribucion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(electivaeconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(termo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(sistemascostosproduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(investigacionoperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(investigacionoperaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(simulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(electivagestionoperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(analisisdatoss, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(analisisdatos2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(controlygestion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(seguridadygestionambiental, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(electivametodoscuantitativos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(estatica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(procesosfabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(cienciadelosmateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(estrategiaoperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(basicaprofesionall, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(socialess, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(eticaa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ingenieriaeconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(analisisyeval, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(analisisdemod, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seminario3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(Xsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Isem)
                            .addComponent(IIsem)
                            .addComponent(IIIsem)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Vsem)
                                .addComponent(IVsem))
                            .addComponent(VIsem)
                            .addComponent(VIIsem)
                            .addComponent(VIIIsem)
                            .addComponent(IXsem))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estudiotrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diseñosistemasproductivos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(planprog, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logisticaydistribucion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electivaeconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(termo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sistemascostosproduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(investigacionoperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(investigacionoperaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electivagestionoperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(analisisdatoss, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(analisisdatos2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(controlygestion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seguridadygestionambiental, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electivametodoscuantitativos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estatica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(procesosfabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ingenieriaeconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(analisisyeval, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(analisisdemod, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cienciadelosmateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(estrategiaoperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(basicaprofesionall, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(eticaa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(socialess, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Xsem)
                        .addGap(12, 12, 12)
                        .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(filosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(complementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingles1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingles3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seminario3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void innovacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_innovacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_innovacionActionPerformed

    private void algebraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algebraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_algebraActionPerformed

    private void limpiarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarbtnActionPerformed
        grafo.limpiarGrafo();
        actualizarInterfaz();
    }//GEN-LAST:event_limpiarbtnActionPerformed

    private void ingles8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingles8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingles8ActionPerformed

    private void simulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simulacionActionPerformed

    private void seguridadygestionambientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seguridadygestionambientalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seguridadygestionambientalActionPerformed

    private void IIsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IIsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IIsemActionPerformed

    private void RegresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarBtnActionPerformed
        SeleccionCarrera frameseleccion = new SeleccionCarrera();
        this.dispose();
        frameseleccion.setVisible(true);
    }//GEN-LAST:event_RegresarBtnActionPerformed

    private void socialessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_socialessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_socialessActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new Industrial().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IIIsem;
    private javax.swing.JButton IIsem;
    private javax.swing.JButton IVsem;
    private javax.swing.JButton IXsem;
    private javax.swing.JButton Isem;
    private javax.swing.JButton RegresarBtn;
    private javax.swing.JButton VIIIsem;
    private javax.swing.JButton VIIsem;
    private javax.swing.JButton VIsem;
    private javax.swing.JButton Vsem;
    private javax.swing.JButton Xsem;
    private javax.swing.JButton algebra;
    private javax.swing.JButton algoritmia1;
    private javax.swing.JButton analisisdatos2;
    private javax.swing.JButton analisisdatoss;
    private javax.swing.JButton analisisdemod;
    private javax.swing.JButton analisisyeval;
    private javax.swing.JButton basicaprofesionall;
    private javax.swing.JButton calculo1;
    private javax.swing.JButton calculo2;
    private javax.swing.JButton calculo3;
    private javax.swing.JButton cienciadelosmateriales;
    private javax.swing.JButton competencias1;
    private javax.swing.JButton competencias2;
    private javax.swing.JButton complementaria1;
    private javax.swing.JButton complementaria2;
    private javax.swing.JButton controlygestion;
    private javax.swing.JButton diseñosistemasproductivos;
    private javax.swing.JButton ecuaciones;
    private javax.swing.JButton electivaeconomica;
    private javax.swing.JButton electivagestionoperaciones;
    private javax.swing.JButton electivametodoscuantitativos;
    private javax.swing.JButton estatica;
    private javax.swing.JButton estrategiaoperaciones;
    private javax.swing.JButton estudiosdelcaribe;
    private javax.swing.JButton estudiotrabajo;
    private javax.swing.JButton eticaa;
    private javax.swing.JButton examencom1;
    private javax.swing.JButton examencom2;
    private javax.swing.JButton expresion;
    private javax.swing.JButton filosofia;
    private javax.swing.JButton fisicacalor;
    private javax.swing.JButton fisicaelectrica;
    private javax.swing.JButton fisicamecanica;
    private javax.swing.JButton historia;
    private javax.swing.JButton humanidades;
    private javax.swing.JButton ingenieriaeconomica;
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
    private javax.swing.JButton investigacionoperaciones;
    private javax.swing.JButton investigacionoperaciones2;
    private javax.swing.JButton limpiarbtn;
    private javax.swing.JButton logisticaydistribucion;
    private javax.swing.JButton planprog;
    private javax.swing.JButton procesosfabricacion;
    private javax.swing.JButton proyectofinal;
    private javax.swing.JButton seguridadygestionambiental;
    private javax.swing.JButton seminario1;
    private javax.swing.JButton seminario3;
    private javax.swing.JButton simulacion;
    private javax.swing.JButton sistemascostosproduccion;
    private javax.swing.JButton socialess;
    private javax.swing.JButton soluciones;
    private javax.swing.JButton termo1;
    // End of variables declaration//GEN-END:variables
}
