
package core.modelo;

import core.persistencia.Estado;
import core.persistencia.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Electrica extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Electrica.class.getName());
    private Map<Integer, List<Nodo>> materiasPorSemestre = new HashMap<>();

    public Electrica() {
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
        grafo.registrar("Expresion Grafica", expresion, 3);
        grafo.registrar("Intro Ingenieria Electrica", introduccion, 1);
        grafo.registrar("Competencias comunicativas 1", competencias1, 3);
        grafo.registrar("Ingles 1", ingles1, 0);

        // Semestre 2
        grafo.registrar("Calculo 2", calculo2, 4);
        grafo.registrar("Fisica mecanica", fisicamecanica, 4);
        grafo.registrar("Algoritmia 1", algoritmia1, 3);
        grafo.registrar("Competencias comunicativas 2", competencias2, 3);
        grafo.registrar("Ciencias de la Vida", cienciasvida, 3);
        grafo.registrar("Ingles 2", ingles2, 0);

        // Semestre 3
        grafo.registrar("Ecuaciones", ecuaciones, 3);
        grafo.registrar("Calculo 3", calculo3, 4);
        grafo.registrar("Fisica electricidad", fisicaelectricaa, 4);
        grafo.registrar("Historia", historia, 3);
        grafo.registrar("Sociales", socialess, 3);
        grafo.registrar("Ingles 3", ingles3, 0);

        // Semestre 4
        grafo.registrar("Circuitos 1", circuitos1, 3);
        grafo.registrar("Fisica calor ondas", fisicacalor, 4);
        grafo.registrar("Teoria Electromagnetica", teoria, 3);
        grafo.registrar("Analisis Datos Ing", analisisdatos, 4);
        grafo.registrar("Estudios del Caribe", estudiosdelcaribe, 3);
        grafo.registrar("Ingles 4", ingles4, 0);
        grafo.registrar("Seminario de Carrera 1", seminario1, 0);

        // Semestre 5
        grafo.registrar("Circuitos 2", circuitos2, 4);
        grafo.registrar("Electronica 1", electronica1, 4);
        grafo.registrar("Sol. Comp. Prob. Ing", soluciones, 3);
        grafo.registrar("Termodinamica 1", termodinamica1, 3);
        grafo.registrar("Electiva basica profesional", basicaprofesional1, 3);
        grafo.registrar("Ingles 5", ingles5, 0);
        grafo.registrar("Examen comprehensivo 1", examencom1, 0);

        // Semestre 6
        grafo.registrar("Logica Digital", logicadigital, 3);
        grafo.registrar("Maquinas Electricas 1", maquinaselectricas1, 4);
        grafo.registrar("Medicion e Instrum.", medicion, 3);
        grafo.registrar("Señales y sistemas", señales, 4);
        grafo.registrar("Etica", etica, 3);
        grafo.registrar("Ingles 6", ingles6, 0);

        // Semestre 7
        grafo.registrar("Maquinas Electricas 2", maquinaselectricas2, 3);
        grafo.registrar("Inst. Electricas", instelectricas, 3);
        grafo.registrar("Elem. de Sis. de Pot.", elemdesis, 3);
        grafo.registrar("Control Automatico", controlautomatico, 4);
        grafo.registrar("Filosofia", filosofiaa, 3);
        grafo.registrar("Ingles 7", ingles7, 0);

        // Semestre 8
        grafo.registrar("Protec. Electricas", protectelectricas, 3);
        grafo.registrar("Anal. Sist. de Pot.", analsistdepot, 3);
        grafo.registrar("Subes. Electricas", substelectricas, 3);
        grafo.registrar("Lin. y Red. de Trans.", linyredes, 3);
        grafo.registrar("Gestion", gestion, 3);
        grafo.registrar("Ingles 8", ingles8, 0);

        // Semestre 9
        grafo.registrar("Examen comprehensivo 2", examencom2, 0);
        grafo.registrar("Profesional 1", profesional1, 3);
        grafo.registrar("Profesional 2", profesional2, 3);
        grafo.registrar("Complem. Libre 1", complementaria1, 3);
        grafo.registrar("Innov. Desar. Socie.", innovacion, 3);
        grafo.registrar("Seminario de Carrera 2", seminario2, 0);

        // Semestre 10
        grafo.registrar("Proyecto Final", proyectofinal, 3);
        grafo.registrar("Complem. Libre 2", complementaria2, 3);
        grafo.registrar("Profesional 3", profesional3, 3);
        grafo.registrar("Humanidades", humanidades, 3);
    }
    
    private void definirAristas(){
        //CONECTAR LAS ARISTAS
        grafo.prereq("Calculo 2", "Calculo 1");
        grafo.prereq("Fisica mecanica", "Calculo 1");
        grafo.prereq("Competencias comunicativas 2", "Competencias comunicativas 1");
        
        //3
        grafo.prereq("Ecuaciones", "Calculo 2");
        grafo.prereq("Calculo 3", "Algebra Lineal");
        grafo.prereq("Calculo 3", "Calculo 2");
        grafo.prereq("Fisica electricidad", "Calculo 2");
        grafo.prereq("Fisica electricidad", "Fisica mecanica");
        
        //4
        grafo.prereq("Circuitos 1", "Algebra Lineal");
        grafo.prereq("Circuitos 1", "Fisica electricidad");
        grafo.prereq("Fisica calor ondas", "Calculo 1");
        grafo.prereq("Fisica calor ondas", "Fisica mecanica");
        grafo.prereq("Teoria Electromagnetica", "Fisica electricidad");
        grafo.prereq("Teoria Electromagnetica", "Ecuaciones");
        grafo.prereq("Analisis Datos Ing", "Calculo 2");
        
        grafo.prereq("Ingles 2", "Ingles 1");
        grafo.prereq("Ingles 3", "Ingles 2");
        grafo.prereq("Ingles 4", "Ingles 3");
        grafo.prereq("Ingles 5", "Ingles 4");
        grafo.prereq("Ingles 6", "Ingles 5");
        grafo.prereq("Ingles 7", "Ingles 6");
        grafo.prereq("Ingles 8", "Ingles 7");
        
        //5
        grafo.prereq("Examen comprehensivo 1", "Ecuaciones");
        grafo.prereq("Examen comprehensivo 1", "Calculo 3");
        grafo.prereq("Examen comprehensivo 1", "Fisica mecanica");
        grafo.prereq("Examen comprehensivo 1", "Fisica electricidad");
        grafo.prereq("Examen comprehensivo 1", "Fisica calor ondas");
        grafo.prereq("Circuitos 2", "Circuitos 1");
        grafo.prereq("Electronica 1", "Circuitos 1");
        grafo.prereq("Sol. Comp. Prob. Ing", "Ecuaciones");
        grafo.prereq("Sol. Comp. Prob. Ing", "Algoritmia 1");
        grafo.prereq("Termodinamica 1", "Fisica calor ondas");
        
        //6
        grafo.prereq("Logica Digital", "Circuitos 1");
        grafo.prereq("Maquinas Electricas 1", "Circuitos 2");
        grafo.prereq("Maquinas Electricas 1", "Teoria Electromagnetica");
        grafo.prereq("Medicion e Instrum.", "Circuitos 2");
        grafo.prereq("Medicion e Instrum.", "Electronica 1");
        grafo.prereq("Señales y sistemas", "Examen comprehensivo 1");
        grafo.prereq("Señales y sistemas", "Ecuaciones");
        
        //7
        grafo.prereq("Maquinas Electricas 2", "Maquinas Electricas 1");
        grafo.prereq("Maquinas Electricas 2", "Termodinamica 1");
        grafo.prereq("Inst. Electricas", "Maquinas Electricas 1");
        grafo.prereq("Elem. de Sis. de Pot.", "Maquinas Electricas 1");
        grafo.prereq("Elem. de Sis. de Pot.", "Sol. Comp. Prob. Ing");
        grafo.prereq("Elem. de Sis. de Pot.", "Señales y sistemas");
        grafo.prereq("Control Automatico", "Señales y sistemas");
        grafo.prereq("Control Automatico", "Medicion e Instrum.");
        
        //8
        grafo.prereq("Anal. Sist. de Pot.", "Elem. de Sis. de Pot.");
        
        //10
        grafo.prereq("Proyecto Final", "Examen comprehensivo 2");
        grafo.prereq("Proyecto Final", "Anal. Sist. de Pot.");
        grafo.prereq("Proyecto Final", "Ingles 8");
        grafo.prereq("Proyecto Final", "Protec. Electricas");
        grafo.prereq("Proyecto Final", "Subes. Electricas");
        grafo.prereq("Proyecto Final", "Lin. y Red. de Trans.");
        grafo.prereq("Proyecto Final", "Control Automatico");
    }
    
    private void agruparPorSemestre() {
        materiasPorSemestre.put(1, Arrays.asList(
                grafo.getNodo("Algebra Lineal"),
                grafo.getNodo("Calculo 1"),
                grafo.getNodo("Expresion Grafica"),
                grafo.getNodo("Intro Ingenieria Electrica"),
                grafo.getNodo("Competencias comunicativas 1"),
                grafo.getNodo("Ingles 1")
        ));

        materiasPorSemestre.put(2, Arrays.asList(
                grafo.getNodo("Calculo 2"),
                grafo.getNodo("Fisica mecanica"),
                grafo.getNodo("Algoritmia 1"),
                grafo.getNodo("Competencias comunicativas 2"),
                grafo.getNodo("Ciencias de la Vida"),
                grafo.getNodo("Ingles 2")
        ));

        materiasPorSemestre.put(3, Arrays.asList(
                grafo.getNodo("Ecuaciones"),
                grafo.getNodo("Calculo 3"),
                grafo.getNodo("Fisica electricidad"),
                grafo.getNodo("Historia"),
                grafo.getNodo("Sociales"),
                grafo.getNodo("Ingles 3")
        ));

        materiasPorSemestre.put(4, Arrays.asList(
                grafo.getNodo("Circuitos 1"),
                grafo.getNodo("Fisica calor ondas"),
                grafo.getNodo("Teoria Electromagnetica"),
                grafo.getNodo("Analisis Datos Ing"),
                grafo.getNodo("Estudios del Caribe"),
                grafo.getNodo("Ingles 4"),
                grafo.getNodo("Seminario de Carrera 1")
        ));

        materiasPorSemestre.put(5, Arrays.asList(
                grafo.getNodo("Circuitos 2"),
                grafo.getNodo("Electronica 1"),
                grafo.getNodo("Sol. Comp. Prob. Ing"),
                grafo.getNodo("Termodinamica 1"),
                grafo.getNodo("Electiva basica profesional"),
                grafo.getNodo("Examen comprehensivo 1"),
                grafo.getNodo("Ingles 5")
        ));
        
        materiasPorSemestre.put(6, Arrays.asList(
                grafo.getNodo("Logica Digital"),
                grafo.getNodo("Maquinas Electricas 1"),
                grafo.getNodo("Medicion e Instrum."),
                grafo.getNodo("Señales y sistemas"),
                grafo.getNodo("Etica"),
                grafo.getNodo("Ingles 6")
        ));

        materiasPorSemestre.put(7, Arrays.asList(
                grafo.getNodo("Maquinas Electricas 2"),
                grafo.getNodo("Inst. Electricas"),
                grafo.getNodo("Elem. de Sis. de Pot."),
                grafo.getNodo("Control Automatico"),
                grafo.getNodo("Filosofia"),
                grafo.getNodo("Ingles 7")
        ));
        
        materiasPorSemestre.put(8, Arrays.asList(
                grafo.getNodo("Protec. Electricas"),
                grafo.getNodo("Anal. Sist. de Pot."),
                grafo.getNodo("Subes. Electricas"),
                grafo.getNodo("Lin. y Red. de Trans."),
                grafo.getNodo("Gestion"),
                grafo.getNodo("Ingles 8")
        ));

        materiasPorSemestre.put(9, Arrays.asList(
                grafo.getNodo("Examen comprehensivo 2"),
                grafo.getNodo("Profesional 1"),
                grafo.getNodo("Profesional 2"),
                grafo.getNodo("Complem. Libre 1"),
                grafo.getNodo("Innov. Desar. Socie."),
                grafo.getNodo("Seminario de Carrera 2")
        ));
        
        materiasPorSemestre.put(10, Arrays.asList(
                grafo.getNodo("Proyecto Final"),
                grafo.getNodo("Complem. Libre 2"),
                grafo.getNodo("Profesional 3"),
                grafo.getNodo("Humanidades")
        ));
    }

    private void seleccionarSemestre(int numero) {
        List<Nodo> materias = materiasPorSemestre.get(numero);
        if (materias == null) {
            return;
        }

        for (Nodo n : materias) {
            if (n.getEstado() != Estado.APROBADA) {
                grafo.aprobarNodo(n); 
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

        humanidades = new javax.swing.JButton();
        algoritmia1 = new javax.swing.JButton();
        seminario2 = new javax.swing.JButton();
        ecuaciones = new javax.swing.JButton();
        profesional3 = new javax.swing.JButton();
        socialess = new javax.swing.JButton();
        proyectofinal = new javax.swing.JButton();
        ingles3 = new javax.swing.JButton();
        complementaria2 = new javax.swing.JButton();
        calculo3 = new javax.swing.JButton();
        seminario1 = new javax.swing.JButton();
        fisicaelectricaa = new javax.swing.JButton();
        examencom1 = new javax.swing.JButton();
        señales = new javax.swing.JButton();
        historia = new javax.swing.JButton();
        maquinaselectricas2 = new javax.swing.JButton();
        analisisdatos = new javax.swing.JButton();
        filosofiaa = new javax.swing.JButton();
        ingles7 = new javax.swing.JButton();
        instelectricas = new javax.swing.JButton();
        elemdesis = new javax.swing.JButton();
        estudiosdelcaribe = new javax.swing.JButton();
        ingles4 = new javax.swing.JButton();
        innovacion = new javax.swing.JButton();
        limpiarbtn = new javax.swing.JButton();
        controlautomatico = new javax.swing.JButton();
        protectelectricas = new javax.swing.JButton();
        gestion = new javax.swing.JButton();
        teoria = new javax.swing.JButton();
        ingles8 = new javax.swing.JButton();
        ingles1 = new javax.swing.JButton();
        fisicacalor = new javax.swing.JButton();
        analsistdepot = new javax.swing.JButton();
        calculo1 = new javax.swing.JButton();
        substelectricas = new javax.swing.JButton();
        introduccion = new javax.swing.JButton();
        linyredes = new javax.swing.JButton();
        circuitos1 = new javax.swing.JButton();
        circuitos2 = new javax.swing.JButton();
        expresion = new javax.swing.JButton();
        basicaprofesional1 = new javax.swing.JButton();
        profesional1 = new javax.swing.JButton();
        RegresarBtn = new javax.swing.JButton();
        ingles5 = new javax.swing.JButton();
        cienciasvida = new javax.swing.JButton();
        electronica1 = new javax.swing.JButton();
        examencom2 = new javax.swing.JButton();
        termodinamica1 = new javax.swing.JButton();
        competencias2 = new javax.swing.JButton();
        ingles2 = new javax.swing.JButton();
        calculo2 = new javax.swing.JButton();
        fisicamecanica = new javax.swing.JButton();
        soluciones = new javax.swing.JButton();
        logicadigital = new javax.swing.JButton();
        algebra = new javax.swing.JButton();
        etica = new javax.swing.JButton();
        competencias1 = new javax.swing.JButton();
        ingles6 = new javax.swing.JButton();
        profesional2 = new javax.swing.JButton();
        maquinaselectricas1 = new javax.swing.JButton();
        complementaria1 = new javax.swing.JButton();
        medicion = new javax.swing.JButton();
        Xsem = new javax.swing.JButton();
        IVsem = new javax.swing.JButton();
        Vsem = new javax.swing.JButton();
        VIsem = new javax.swing.JButton();
        VIIsem = new javax.swing.JButton();
        VIIIsem = new javax.swing.JButton();
        IXsem = new javax.swing.JButton();
        Isem = new javax.swing.JButton();
        IIsem = new javax.swing.JButton();
        IIIsem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        humanidades.setText("Electiva humanidades");

        algoritmia1.setText("Algoritmia y programacion 1");

        seminario2.setText("Seminario de carrera 2");

        ecuaciones.setText("Ecuaciones diferenciales");

        profesional3.setText("Electiva profesional 3");

        socialess.setText("Electiva ciencias sociales");

        proyectofinal.setText("Proyecto final");

        ingles3.setText("Ingles 3");

        complementaria2.setText("Electiva formacion complementaria 2");

        calculo3.setText("Calculo 3");

        seminario1.setText("Seminario de carrera 1");

        fisicaelectricaa.setText("Fisica electricidad");

        examencom1.setText("Examen comprehensivo 1");

        señales.setText("Señales y sistemas");

        historia.setText("Electiva historia");

        maquinaselectricas2.setText("Maquinas electricas 2");

        analisisdatos.setText("Analisis de datos");

        filosofiaa.setText("Electiva filosofia");

        ingles7.setText("Ingles 7");

        instelectricas.setText("Inst. electricas");
        instelectricas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instelectricasActionPerformed(evt);
            }
        });

        elemdesis.setText("Elem. de sist. de pot");

        estudiosdelcaribe.setText("Estudios del caribe");

        ingles4.setText("Ingles 4");

        innovacion.setText("Electiva innovacion");
        innovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                innovacionActionPerformed(evt);
            }
        });

        limpiarbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        limpiarbtn.setText("Limpiar");
        limpiarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarbtnActionPerformed(evt);
            }
        });

        controlautomatico.setText("Control automatico");

        protectelectricas.setText("Protect. electricas");

        gestion.setText("Electiva gestion");

        teoria.setText("Teoria electromagnetica");

        ingles8.setText("Ingles 8");
        ingles8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingles8ActionPerformed(evt);
            }
        });

        ingles1.setText("Ingles 1");

        fisicacalor.setText("Fisica calor ondas");

        analsistdepot.setText("Anal. sist. de pot.");
        analsistdepot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analsistdepotActionPerformed(evt);
            }
        });

        calculo1.setText("Calculo 1");

        substelectricas.setText("Subst. electricas");
        substelectricas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                substelectricasActionPerformed(evt);
            }
        });

        introduccion.setText("Introduccion a ingenieria civil");

        linyredes.setText("Lin. y redes de transf");

        circuitos1.setText("Circuitos 1");

        circuitos2.setText("Circuitos 2");

        expresion.setText("Expresion grafica");

        basicaprofesional1.setText("Electiva basica profesional 1");

        profesional1.setText("Electiva profesional 1");

        RegresarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegresarBtn.setText("Regresar");
        RegresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBtnActionPerformed(evt);
            }
        });

        ingles5.setText("Ingles 5");

        cienciasvida.setText("Electiva ciencias de la vida");

        electronica1.setText("Electronica 1");

        examencom2.setText("Examen comprehensivo 2");

        termodinamica1.setText("Termodinamica 1");

        competencias2.setText("Competencias comunicativas 2");

        ingles2.setText("Ingles 2");

        calculo2.setText("Calculo 2");

        fisicamecanica.setText("Fisica mecanica");

        soluciones.setText("Soluciones computacionales");

        logicadigital.setText("Logica digital");

        algebra.setText("Algebra Lineal");
        algebra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algebraActionPerformed(evt);
            }
        });

        etica.setText("Electiva etica");

        competencias1.setText("Competencias comunicativas 1");

        ingles6.setText("Ingles 6");

        profesional2.setText("Electiva profesional 2");

        maquinaselectricas1.setText("Maquinas electricas 1");

        complementaria1.setText("Electiva formacion complementaria 1");

        medicion.setText("Medicion e instrum");

        Xsem.setText("X");

        IVsem.setText("IV");

        Vsem.setText("V");

        VIsem.setText("VI");

        VIIsem.setText("VII");

        VIIIsem.setText("VIII");

        IXsem.setText("IX");

        Isem.setText("I");

        IIsem.setText("II");
        IIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IIsemActionPerformed(evt);
            }
        });

        IIIsem.setText("III");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(teoria, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(electronica1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(maquinaselectricas1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(instelectricas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(analsistdepot, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(profesional2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(profesional3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(fisicaelectricaa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(termodinamica1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(medicion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(elemdesis, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(substelectricas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(cienciasvida, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(circuitos2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(logicadigital, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(maquinaselectricas2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(protectelectricas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(profesional1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ingles1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(ingles3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(ingles4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(ingles5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(443, 443, 443)
                                .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addComponent(seminario2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(circuitos1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(señales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(controlautomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(linyredes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182)
                        .addComponent(complementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(socialess, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(basicaprofesional1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(etica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(filosofiaa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Isem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(IIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(IIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(IVsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(Vsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(VIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(VIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(VIIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(IXsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Xsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Xsem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(VIIIsem)
                        .addComponent(IXsem))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Vsem)
                        .addComponent(VIsem)
                        .addComponent(VIIsem))
                    .addComponent(IVsem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Isem)
                        .addComponent(IIsem)
                        .addComponent(IIIsem)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cienciasvida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(circuitos2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logicadigital, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maquinaselectricas2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(protectelectricas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profesional1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teoria, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(electronica1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maquinaselectricas1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instelectricas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analsistdepot, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profesional2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profesional3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fisicaelectricaa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(termodinamica1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elemdesis, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(substelectricas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(circuitos1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(señales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(controlautomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linyredes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(complementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(socialess, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(basicaprofesional1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filosofiaa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingles1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingles3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingles4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingles5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seminario2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void innovacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_innovacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_innovacionActionPerformed

    private void limpiarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarbtnActionPerformed
        grafo.limpiarGrafo();
        actualizarInterfaz();
    }//GEN-LAST:event_limpiarbtnActionPerformed

    private void ingles8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingles8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingles8ActionPerformed

    private void analsistdepotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analsistdepotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_analsistdepotActionPerformed

    private void substelectricasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_substelectricasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_substelectricasActionPerformed

    private void RegresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarBtnActionPerformed
        SeleccionCarrera frameseleccion = new SeleccionCarrera();
        this.dispose();
        frameseleccion.setVisible(true);
    }//GEN-LAST:event_RegresarBtnActionPerformed

    private void algebraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algebraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_algebraActionPerformed

    private void instelectricasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instelectricasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instelectricasActionPerformed

    private void IIsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IIsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IIsemActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Electrica().setVisible(true));
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
    private javax.swing.JButton analisisdatos;
    private javax.swing.JButton analsistdepot;
    private javax.swing.JButton basicaprofesional1;
    private javax.swing.JButton calculo1;
    private javax.swing.JButton calculo2;
    private javax.swing.JButton calculo3;
    private javax.swing.JButton cienciasvida;
    private javax.swing.JButton circuitos1;
    private javax.swing.JButton circuitos2;
    private javax.swing.JButton competencias1;
    private javax.swing.JButton competencias2;
    private javax.swing.JButton complementaria1;
    private javax.swing.JButton complementaria2;
    private javax.swing.JButton controlautomatico;
    private javax.swing.JButton ecuaciones;
    private javax.swing.JButton electronica1;
    private javax.swing.JButton elemdesis;
    private javax.swing.JButton estudiosdelcaribe;
    private javax.swing.JButton etica;
    private javax.swing.JButton examencom1;
    private javax.swing.JButton examencom2;
    private javax.swing.JButton expresion;
    private javax.swing.JButton filosofiaa;
    private javax.swing.JButton fisicacalor;
    private javax.swing.JButton fisicaelectricaa;
    private javax.swing.JButton fisicamecanica;
    private javax.swing.JButton gestion;
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
    private javax.swing.JButton instelectricas;
    private javax.swing.JButton introduccion;
    private javax.swing.JButton limpiarbtn;
    private javax.swing.JButton linyredes;
    private javax.swing.JButton logicadigital;
    private javax.swing.JButton maquinaselectricas1;
    private javax.swing.JButton maquinaselectricas2;
    private javax.swing.JButton medicion;
    private javax.swing.JButton profesional1;
    private javax.swing.JButton profesional2;
    private javax.swing.JButton profesional3;
    private javax.swing.JButton protectelectricas;
    private javax.swing.JButton proyectofinal;
    private javax.swing.JButton seminario1;
    private javax.swing.JButton seminario2;
    private javax.swing.JButton señales;
    private javax.swing.JButton socialess;
    private javax.swing.JButton soluciones;
    private javax.swing.JButton substelectricas;
    private javax.swing.JButton teoria;
    private javax.swing.JButton termodinamica1;
    // End of variables declaration//GEN-END:variables
}
