package core.modelo;

import core.persistencia.Estado;
import core.persistencia.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Mecanica extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Mecanica.class.getName());
    private Map<Integer, List<Nodo>> materiasPorSemestre = new HashMap<>();

    public Mecanica() {
        initComponents();
        armarGrafo();
        definirAristas();
        inicializarEstados();
        conectarListeners();
        actualizarInterfaz();
        agruparPorSemestre();
        conectarBotonesSemestre();
    }

    Grafo grafo = new Grafo();

    private void armarGrafo() {
        // Semestre 1
        grafo.registrar("Algebra Lineal", algebra, 3);
        grafo.registrar("Calculo 1", calculo1, 5);
        grafo.registrar("Expresion Grafica", expresion, 3);
        grafo.registrar("Introduccion a la Ing Mecanica", introduccion, 1);
        grafo.registrar("Competencias Comunicativas 1", competencias1, 3);
        grafo.registrar("Ingles 1", ingles1, 0);

        // Semestre 2
        grafo.registrar("Calculo 2", calculo2, 4);
        grafo.registrar("Fisica Mecanica", fisicamecanica, 4);
        grafo.registrar("Algoritmia y Programacion 1", algoritmia1, 3);
        grafo.registrar("Competencias Comunicativas 2", competencias2, 3);
        grafo.registrar("Ingles 2", ingles2, 0);

        // Semestre 3
        grafo.registrar("Calculo 3", calculo3, 4);
        grafo.registrar("Ecuaciones Diferenciales", ecuaciones, 3);
        grafo.registrar("Fisica calor ondas", fisicacalor, 4);
        grafo.registrar("Ciencia de los Materiales", cienciadelosmateriales, 3);
        grafo.registrar("Estatica", estatica, 3);     
        grafo.registrar("Ingles 3", ingles3, 0);

        // Semestre 4
        grafo.registrar("Fisica electricidad", fisicaelectrica, 4);
        grafo.registrar("Termodinamica 1", termo1, 3);
        grafo.registrar("Ingenieria de materiales", ingenieriamateriales, 2);
        grafo.registrar("Dinamica", dinamica, 3);
        grafo.registrar("Mecanica de Solidos", mecanicadesolidos, 3);
        grafo.registrar("Seminario de Carrera 1", seminario1, 0);
        grafo.registrar("Ingles 4", ingles4, 0);

        // Semestre 5
        grafo.registrar("Termodinamica 2", termo2, 4);
        grafo.registrar("Soln. Comput. de Problem. Ing.", soluciones, 3);
        grafo.registrar("Mecanica de Fluidos", mecanicadefluidos, 4);
        grafo.registrar("Mecanica de Maquinas", mecanicamaquinas, 3);
        grafo.registrar("Procesos de Fabricacion", procesosfabricacion, 3);
        grafo.registrar("Examen Comprehensivo 1", examencom1, 0);
        grafo.registrar("Ingles 5", ingles5, 0);

        // Semestre 6
        grafo.registrar("Ingenieria Economica", ingenieriaeconomica, 3);
        grafo.registrar("Analisis de Datos en Ingenieria", analisisdatos, 4);
        grafo.registrar("Transferencia de Calor", transferenciacalor, 4);
        grafo.registrar("Diseño Mecanico", diseñomecanico, 4);
        grafo.registrar("Ingles 6", ingles6, 0);

        // Semestre 7
        grafo.registrar("Electiva Sistemas Electricos", electivasistemaselectricos, 3);
        grafo.registrar("Modelos de Sistemas Dinamicos", modelossistemasdinamicos, 3);
        grafo.registrar("Diseño de Sistemas Termofluidos", diseñosistemastermofluidos, 3);
        grafo.registrar("Diseño de Sistemas Mecanicos", diseñosistemasmecanicos, 3);
        grafo.registrar("Electiva en Etica", eticaa, 3);
        grafo.registrar("Ingles 7", ingles7, 0);

        // semestre 8
        grafo.registrar("Electiva Ciencias de la vida", cienciasvida, 3);
        grafo.registrar("Proyecto de Investigacion", proyectoinvestigacion, 2);
        grafo.registrar("Instrumentacion y Control", instrumentacionycontrol, 4);
        grafo.registrar("Gestion de Activos", gestionactivos, 2);
        grafo.registrar("Electiva en Filosofia", filosofiaa, 3);
        grafo.registrar("Electiva Innov y Dllo Soc", innovacion, 3);
        grafo.registrar("Ingles 8", ingles8, 0);

        // Semestre 9
        grafo.registrar("Electiva Form Compl Libre 1", complementaria1, 3);
        grafo.registrar("Electiva en Energia", electivaenergia, 3);
        grafo.registrar("Electiva en Diseño y Materiales", electivadiseñoymateriales, 3);
        grafo.registrar("Electiva en Humanidades", humanidadess, 3);
        grafo.registrar("Electiva en Historia", historia, 3);
        grafo.registrar("Examen Comprehensivo 2", examencom2, 0);
        grafo.registrar("Seminario de Carrera 2", seminario3, 0);

        // Semestre 10
        grafo.registrar("Electiva Ing. Mecanica", electivaingenieriamecanica, 3);
        grafo.registrar("Proyecto Final", proyectofinal, 3);
        grafo.registrar("El Form Compl Libre 2", complementaria2, 3);
        grafo.registrar("Electiva ciencias sociales", sociales, 3);
        grafo.registrar("Electiva Estudios del Caribe", estudiosdelcaribe, 3);
    }

    private void definirAristas() {
        //CONECTAR LAS ARISTAS
        grafo.prereq("Calculo 2", "Calculo 1");
        grafo.prereq("Fisica Mecanica", "Calculo 1");
        grafo.prereq("Competencias Comunicativas 2", "Competencias Comunicativas 1");

        grafo.prereq("Calculo 3", "Calculo 2");
        grafo.prereq("Calculo 3", "Algebra Lineal");
        grafo.prereq("Ecuaciones Diferenciales", "Calculo 2");
        grafo.prereq("Fisica calor ondas", "Calculo 1");
        grafo.prereq("Fisica calor ondas", "Fisica Mecanica");
        grafo.prereq("Estatica", "Fisica Mecanica");

        grafo.prereq("Fisica electricidad", "Calculo 2");
        grafo.prereq("Fisica electricidad", "Fisica Mecanica");
        grafo.prereq("Termodinamica 1", "Fisica calor ondas");
        grafo.prereq("Ingenieria de materiales", "Ciencia de los Materiales");
        grafo.prereq("Dinamica", "Calculo 2");
        grafo.prereq("Dinamica", "Estatica");
        grafo.prereq("Mecanica de Solidos", "Estatica");
        
        grafo.prereq("Ingles 2", "Ingles 1");
        grafo.prereq("Ingles 3", "Ingles 2");
        grafo.prereq("Ingles 4", "Ingles 3");
        grafo.prereq("Ingles 5", "Ingles 4");
        grafo.prereq("Ingles 6", "Ingles 5");
        grafo.prereq("Ingles 7", "Ingles 6");
        grafo.prereq("Ingles 8", "Ingles 7");
        
        //5
        grafo.prereq("Soln. Comput. de Problem. Ing.", "Algoritmia y Programacion 1");
        grafo.prereq("Soln. Comput. de Problem. Ing.", "Ecuaciones Diferenciales");
        grafo.prereq("Examen Comprehensivo 1", "Ecuaciones Diferenciales");
        grafo.prereq("Examen Comprehensivo 1", "Calculo 3");
        grafo.prereq("Examen Comprehensivo 1", "Fisica Mecanica");
        grafo.prereq("Examen Comprehensivo 1", "Fisica calor ondas");
        grafo.prereq("Examen Comprehensivo 1", "Fisica electricidad");
        grafo.prereq("Termodinamica 2", "Termodinamica 1");
        grafo.prereq("Mecanica de Fluidos", "Ecuaciones Diferenciales");
        grafo.prereq("Mecanica de Maquinas", "Dinamica");
        grafo.prereq("Procesos de Fabricacion", "Ciencia de los Materiales");

        //6
        grafo.prereq("Analisis de Datos en Ingenieria", "Calculo 2");
        grafo.prereq("Transferencia de Calor", "Examen Comprehensivo 1");
        grafo.prereq("Transferencia de Calor", "Termodinamica 1");
        grafo.prereq("Transferencia de Calor", "Mecanica de Fluidos");
        grafo.prereq("Diseño Mecanico", "Examen Comprehensivo 1");
        grafo.prereq("Diseño Mecanico", "Mecanica de Solidos");
        grafo.prereq("Diseño Mecanico", "Mecanica de Maquinas");

        //7
        grafo.prereq("Electiva Sistemas Electricos", "Fisica electricidad");
        grafo.prereq("Modelos de Sistemas Dinamicos", "Ecuaciones Diferenciales");
        grafo.prereq("Modelos de Sistemas Dinamicos", "Fisica calor ondas");
        grafo.prereq("Modelos de Sistemas Dinamicos", "Fisica electricidad");
        grafo.prereq("Diseño de Sistemas Termofluidos", "Termodinamica 2");
        grafo.prereq("Diseño de Sistemas Termofluidos", "Transferencia de Calor");
        grafo.prereq("Diseño de Sistemas Mecanicos", "Diseño Mecanico");

        //8
        grafo.prereq("Proyecto de Investigacion", "Transferencia de Calor");
        grafo.prereq("Proyecto de Investigacion", "Diseño Mecanico");
        grafo.prereq("Instrumentacion y Control", "Modelos de Sistemas Dinamicos");

        //9
        grafo.prereq("Electiva en Energia", "Transferencia de Calor");
        grafo.prereq("Electiva en Diseño y Materiales", "Diseño Mecanico");

        //10
        grafo.prereq("Proyecto Final", "Proyecto de Investigacion");
        grafo.prereq("Proyecto Final", "Diseño de Sistemas Mecanicos");
        grafo.prereq("Proyecto Final", "Diseño de Sistemas Termofluidos");
        grafo.prereq("Proyecto Final", "Instrumentacion y Control");
        grafo.prereq("Proyecto Final", "Ingles 8");
        grafo.prereq("Electiva Ing. Mecanica", "Transferencia de Calor");
        grafo.prereq("Electiva Ing. Mecanica", "Diseño Mecanico");
        
    }
    
    private void agruparPorSemestre() {
        materiasPorSemestre.put(1, Arrays.asList(
                grafo.getNodo("Algebra Lineal"),
                grafo.getNodo("Calculo 1"),
                grafo.getNodo("Expresion Grafica"),
                grafo.getNodo("Introduccion a la Ing Mecanica"),
                grafo.getNodo("Competencias Comunicativas 1"),
                grafo.getNodo("Ingles 1")
        ));

        materiasPorSemestre.put(2, Arrays.asList(
                grafo.getNodo("Calculo 2"),
                grafo.getNodo("Fisica Mecanica"),
                grafo.getNodo("Algoritmia y Programacion 1"),
                grafo.getNodo("Competencias Comunicativas 2"),
                grafo.getNodo("Ingles 2")
        ));

        materiasPorSemestre.put(3, Arrays.asList(
                grafo.getNodo("Calculo 3"),
                grafo.getNodo("Ecuaciones Diferenciales"),
                grafo.getNodo("Fisica calor ondas"),
                grafo.getNodo("Ciencia de los Materiales"),
                grafo.getNodo("Estatica"),
                grafo.getNodo("Ingles 3")
        ));

        materiasPorSemestre.put(4, Arrays.asList(
                grafo.getNodo("Termodinamica 1"),
                grafo.getNodo("Fisica electricidad"),
                grafo.getNodo("Ingenieria de materiales"),
                grafo.getNodo("Dinamica"),
                grafo.getNodo("Mecanica de Solidos"),
                grafo.getNodo("Ingles 4"),
                grafo.getNodo("Seminario de Carrera 1")
        ));

        materiasPorSemestre.put(5, Arrays.asList(
                grafo.getNodo("Soln. Comput. de Problem. Ing."),
                grafo.getNodo("Termodinamica 2"),
                grafo.getNodo("Mecanica de Fluidos"),
                grafo.getNodo("Mecanica de Maquinas"),
                grafo.getNodo("Procesos de Fabricacion"),
                grafo.getNodo("Examen Comprehensivo 1"),
                grafo.getNodo("Ingles 5")
        ));

        materiasPorSemestre.put(6, Arrays.asList(
                grafo.getNodo("Ingenieria Economica"),
                grafo.getNodo("Analisis de Datos en Ingenieria"),
                grafo.getNodo("Transferencia de Calor"),
                grafo.getNodo("Diseño Mecanico"),
                grafo.getNodo("Ingles 6")
        ));

        materiasPorSemestre.put(7, Arrays.asList(
                grafo.getNodo("Electiva Sistemas Electricos"),
                grafo.getNodo("Modelos de Sistemas Dinamicos"),
                grafo.getNodo("Diseño de Sistemas Termofluidos"),
                grafo.getNodo("Diseño de Sistemas Mecanicos"),
                grafo.getNodo("Electiva en Etica"),
                grafo.getNodo("Ingles 7")
        ));

        materiasPorSemestre.put(8, Arrays.asList(
                grafo.getNodo("Electiva Ciencias de la vida"),
                grafo.getNodo("Proyecto de Investigacion"),
                grafo.getNodo("Instrumentacion y Control"),
                grafo.getNodo("Gestion de Activos"),
                grafo.getNodo("Electiva en Filosofia"),
                grafo.getNodo("Electiva Innov y Dllo Soc"),
                grafo.getNodo("Ingles 8")
        ));

        materiasPorSemestre.put(9, Arrays.asList(
                grafo.getNodo("Electiva Form Compl Libre 1"),
                grafo.getNodo("Electiva en Energia"),
                grafo.getNodo("Electiva en Diseño y Materiales"),
                grafo.getNodo("Electiva en Humanidades"),
                grafo.getNodo("Electiva en Historia"),
                grafo.getNodo("Examen Comprehensivo 2"),
                grafo.getNodo("Seminario de Carrera 2")
        ));

        materiasPorSemestre.put(10, Arrays.asList(
                grafo.getNodo("Electiva Ing. Mecanica"),
                grafo.getNodo("Proyecto Final"),
                grafo.getNodo("El Form Compl Libre 2"),
                grafo.getNodo("Electiva ciencias sociales"),
                grafo.getNodo("Electiva Estudios del Caribe")
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
                    "FELICIDADES, Has ganado todas las materias\n"
                    + "Créditos completados: " + creditosTotales);
        }
    }

    private void actualizarInterfaz() {
        for (Nodo n : grafo.getNodos().values()) {
            switch (n.getEstado()) {
                case BLOQUEADA -> {
                    n.getBoton().setEnabled(false);
                    n.getBoton().setBackground(new java.awt.Color(220, 220, 220));
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
                    n.getBoton().setBackground(new java.awt.Color(180, 255, 180));
                    n.getBoton().setForeground(java.awt.Color.BLACK);

                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calculo3 = new javax.swing.JButton();
        seminario1 = new javax.swing.JButton();
        fisicacalor = new javax.swing.JButton();
        examencom1 = new javax.swing.JButton();
        diseñomecanico = new javax.swing.JButton();
        estatica = new javax.swing.JButton();
        electivasistemaselectricos = new javax.swing.JButton();
        analisisdatos = new javax.swing.JButton();
        eticaa = new javax.swing.JButton();
        dinamica = new javax.swing.JButton();
        ingles7 = new javax.swing.JButton();
        ingles4 = new javax.swing.JButton();
        modelossistemasdinamicos = new javax.swing.JButton();
        innovacion = new javax.swing.JButton();
        diseñosistemastermofluidos = new javax.swing.JButton();
        limpiarbtn = new javax.swing.JButton();
        diseñosistemasmecanicos = new javax.swing.JButton();
        cienciasvida = new javax.swing.JButton();
        filosofiaa = new javax.swing.JButton();
        ingles8 = new javax.swing.JButton();
        ingles1 = new javax.swing.JButton();
        proyectoinvestigacion = new javax.swing.JButton();
        calculo1 = new javax.swing.JButton();
        instrumentacionycontrol = new javax.swing.JButton();
        introduccion = new javax.swing.JButton();
        gestionactivos = new javax.swing.JButton();
        expresion = new javax.swing.JButton();
        humanidadess = new javax.swing.JButton();
        RegresarBtn = new javax.swing.JButton();
        electivadiseñoymateriales = new javax.swing.JButton();
        mecanicadesolidos = new javax.swing.JButton();
        fisicaelectrica = new javax.swing.JButton();
        termo1 = new javax.swing.JButton();
        procesosfabricacion = new javax.swing.JButton();
        ingenieriamateriales = new javax.swing.JButton();
        examencom2 = new javax.swing.JButton();
        competencias2 = new javax.swing.JButton();
        ingles2 = new javax.swing.JButton();
        calculo2 = new javax.swing.JButton();
        fisicamecanica = new javax.swing.JButton();
        algebra = new javax.swing.JButton();
        competencias1 = new javax.swing.JButton();
        mecanicadefluidos = new javax.swing.JButton();
        historia = new javax.swing.JButton();
        complementaria1 = new javax.swing.JButton();
        ingles5 = new javax.swing.JButton();
        mecanicamaquinas = new javax.swing.JButton();
        termo2 = new javax.swing.JButton();
        soluciones = new javax.swing.JButton();
        ingenieriaeconomica = new javax.swing.JButton();
        electivaenergia = new javax.swing.JButton();
        electivaingenieriamecanica = new javax.swing.JButton();
        algoritmia1 = new javax.swing.JButton();
        estudiosdelcaribe = new javax.swing.JButton();
        ecuaciones = new javax.swing.JButton();
        sociales = new javax.swing.JButton();
        cienciadelosmateriales = new javax.swing.JButton();
        proyectofinal = new javax.swing.JButton();
        ingles3 = new javax.swing.JButton();
        ingles6 = new javax.swing.JButton();
        complementaria2 = new javax.swing.JButton();
        transferenciacalor = new javax.swing.JButton();
        Isem = new javax.swing.JButton();
        IIsem = new javax.swing.JButton();
        IIIsem = new javax.swing.JButton();
        IVsem = new javax.swing.JButton();
        Vsem = new javax.swing.JButton();
        VIsem = new javax.swing.JButton();
        VIIsem = new javax.swing.JButton();
        VIIIsem = new javax.swing.JButton();
        IXsem = new javax.swing.JButton();
        Xsem = new javax.swing.JButton();
        seminario3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calculo3.setText("Calculo 3");

        seminario1.setText("Seminario de carrera 1");

        fisicacalor.setText("Fisica calor ondas");

        examencom1.setText("Examen comprehensivo 1");

        diseñomecanico.setText("Diseño mecanico");

        estatica.setText("Estatica");

        electivasistemaselectricos.setText("Electiva sistemas electricos");

        analisisdatos.setText("Analisis de datos");

        eticaa.setText("Electiva etica");

        dinamica.setText("Dinamica");

        ingles7.setText("Ingles 7");

        ingles4.setText("Ingles 4");

        modelossistemasdinamicos.setText("Modelos de sistemas dinamicos");

        innovacion.setText("Electiva innovacion");
        innovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                innovacionActionPerformed(evt);
            }
        });

        diseñosistemastermofluidos.setText("Diseño de sistemas termofluidos");

        limpiarbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        limpiarbtn.setText("Limpiar");
        limpiarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarbtnActionPerformed(evt);
            }
        });

        diseñosistemasmecanicos.setText("Diseño de sistemas mecanicos");

        cienciasvida.setText("Electiva ciencias de la vida");

        filosofiaa.setText("Electiva filosofia");

        ingles8.setText("Ingles 8");
        ingles8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingles8ActionPerformed(evt);
            }
        });

        ingles1.setText("Ingles 1");

        proyectoinvestigacion.setText("Proyecto de investigacion");
        proyectoinvestigacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proyectoinvestigacionActionPerformed(evt);
            }
        });

        calculo1.setText("Calculo 1");

        instrumentacionycontrol.setText("Instrumentacion y control");
        instrumentacionycontrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrumentacionycontrolActionPerformed(evt);
            }
        });

        introduccion.setText("Introduccion a ingenieria mecanica");

        gestionactivos.setText("Gestion de activos");

        expresion.setText("Expresion grafica");

        humanidadess.setText("Electiva humanidades");

        RegresarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegresarBtn.setText("Regresar");
        RegresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBtnActionPerformed(evt);
            }
        });

        electivadiseñoymateriales.setText("Electiva en diseño y materiales");

        mecanicadesolidos.setText("Mecanica de solidos");

        fisicaelectrica.setText("Fisica electricidad");

        termo1.setText("Termodinamica 1");

        procesosfabricacion.setText("Procesos de fabricacion");

        ingenieriamateriales.setText("Ingenieria de los materiales");

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

        mecanicadefluidos.setText("Mecanica de fluidos");

        historia.setText("Electiva historia");

        complementaria1.setText("Electiva formacion complementaria 1");

        ingles5.setText("Ingles 5");

        mecanicamaquinas.setText("Mecanica de maquinas");

        termo2.setText("Termodinamica 2");

        soluciones.setText("Soluciones computacionales");

        ingenieriaeconomica.setText("Ingenieria economica");

        electivaenergia.setText("Electiva energia");

        electivaingenieriamecanica.setText("Electiva ingenieria mecanica");

        algoritmia1.setText("Algoritmia y programacion 1");

        estudiosdelcaribe.setText("Estudios del caribe");

        ecuaciones.setText("Ecuaciones diferenciales");

        sociales.setText("Electiva ciencias sociales");

        cienciadelosmateriales.setText("Ciencia de los materiales");

        proyectofinal.setText("Proyecto final");

        ingles3.setText("Ingles 3");

        ingles6.setText("Ingles 6");

        complementaria2.setText("Electiva formacion complementaria 2");

        transferenciacalor.setText("Transferencia de calor");

        Isem.setText("I");

        IIsem.setText("II");
        IIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IIsemActionPerformed(evt);
            }
        });

        IIIsem.setText("III");

        IVsem.setText("IV");

        Vsem.setText("V");

        VIsem.setText("VI");

        VIIsem.setText("VII");

        VIIIsem.setText("VIII");

        IXsem.setText("IX");

        Xsem.setText("X");

        seminario3.setText("Seminario de carrera 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(Isem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(IIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(IIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(IVsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(Vsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(VIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(VIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(VIIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(IXsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(Xsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(termo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(procesosfabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(ingenieriaeconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(electivasistemaselectricos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cienciasvida, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(humanidadess, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(electivaingenieriamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(mecanicadesolidos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(mecanicamaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(modelossistemasdinamicos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(proyectoinvestigacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(termo2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(transferenciacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(diseñosistemastermofluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(instrumentacionycontrol, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(estatica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(dinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(diseñomecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(diseñosistemasmecanicos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(gestionactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(electivaenergia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(complementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cienciadelosmateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(ingenieriamateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(mecanicadefluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(eticaa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(filosofiaa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(electivadiseñoymateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
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
                        .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(476, 476, 476)
                        .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327)
                        .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(seminario3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(610, 610, 610)
                        .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Isem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IIIsem)
                        .addComponent(IIsem))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Vsem)
                        .addComponent(IVsem))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(VIIsem)
                        .addComponent(VIsem))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IXsem)
                        .addComponent(VIIIsem))
                    .addComponent(Xsem))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(termo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procesosfabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingenieriaeconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(electivasistemaselectricos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cienciasvida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humanidadess, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(electivaingenieriamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mecanicadesolidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mecanicamaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelossistemasdinamicos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proyectoinvestigacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(termo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transferenciacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diseñosistemastermofluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instrumentacionycontrol, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estatica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diseñomecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diseñosistemasmecanicos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gestionactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electivaenergia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(ingenieriamateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(mecanicadefluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(eticaa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(filosofiaa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(electivadiseñoymateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
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
                            .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seminario3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
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

    private void proyectoinvestigacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proyectoinvestigacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proyectoinvestigacionActionPerformed

    private void instrumentacionycontrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrumentacionycontrolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instrumentacionycontrolActionPerformed

    private void RegresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarBtnActionPerformed
        SeleccionCarrera frameseleccion = new SeleccionCarrera();
        this.dispose();
        frameseleccion.setVisible(true);
    }//GEN-LAST:event_RegresarBtnActionPerformed

    private void algebraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algebraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_algebraActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Mecanica().setVisible(true));
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
    private javax.swing.JButton calculo1;
    private javax.swing.JButton calculo2;
    private javax.swing.JButton calculo3;
    private javax.swing.JButton cienciadelosmateriales;
    private javax.swing.JButton cienciasvida;
    private javax.swing.JButton competencias1;
    private javax.swing.JButton competencias2;
    private javax.swing.JButton complementaria1;
    private javax.swing.JButton complementaria2;
    private javax.swing.JButton dinamica;
    private javax.swing.JButton diseñomecanico;
    private javax.swing.JButton diseñosistemasmecanicos;
    private javax.swing.JButton diseñosistemastermofluidos;
    private javax.swing.JButton ecuaciones;
    private javax.swing.JButton electivadiseñoymateriales;
    private javax.swing.JButton electivaenergia;
    private javax.swing.JButton electivaingenieriamecanica;
    private javax.swing.JButton electivasistemaselectricos;
    private javax.swing.JButton estatica;
    private javax.swing.JButton estudiosdelcaribe;
    private javax.swing.JButton eticaa;
    private javax.swing.JButton examencom1;
    private javax.swing.JButton examencom2;
    private javax.swing.JButton expresion;
    private javax.swing.JButton filosofiaa;
    private javax.swing.JButton fisicacalor;
    private javax.swing.JButton fisicaelectrica;
    private javax.swing.JButton fisicamecanica;
    private javax.swing.JButton gestionactivos;
    private javax.swing.JButton historia;
    private javax.swing.JButton humanidadess;
    private javax.swing.JButton ingenieriaeconomica;
    private javax.swing.JButton ingenieriamateriales;
    private javax.swing.JButton ingles1;
    private javax.swing.JButton ingles2;
    private javax.swing.JButton ingles3;
    private javax.swing.JButton ingles4;
    private javax.swing.JButton ingles5;
    private javax.swing.JButton ingles6;
    private javax.swing.JButton ingles7;
    private javax.swing.JButton ingles8;
    private javax.swing.JButton innovacion;
    private javax.swing.JButton instrumentacionycontrol;
    private javax.swing.JButton introduccion;
    private javax.swing.JButton limpiarbtn;
    private javax.swing.JButton mecanicadefluidos;
    private javax.swing.JButton mecanicadesolidos;
    private javax.swing.JButton mecanicamaquinas;
    private javax.swing.JButton modelossistemasdinamicos;
    private javax.swing.JButton procesosfabricacion;
    private javax.swing.JButton proyectofinal;
    private javax.swing.JButton proyectoinvestigacion;
    private javax.swing.JButton seminario1;
    private javax.swing.JButton seminario3;
    private javax.swing.JButton sociales;
    private javax.swing.JButton soluciones;
    private javax.swing.JButton termo1;
    private javax.swing.JButton termo2;
    private javax.swing.JButton transferenciacalor;
    // End of variables declaration//GEN-END:variables
}
