package core.modelo;

import core.persistencia.*;
import static core.persistencia.Estado.APROBADA;
import static core.persistencia.Estado.BLOQUEADA;
import static core.persistencia.Estado.DISPONIBLE;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    private Grafo grafo = new Grafo();

    private void armarGrafo() {
        grafo.registrar("Algebra lineal", algebra, 3);
        grafo.registrar("Calculo 1", calculo1, 5);
        grafo.registrar("Introduccion a la ingenieria", introduccion, 1);
        grafo.registrar("Expresion grafica", expresion, 3);
        grafo.registrar("Competencias 1", competencias1, 3);
        grafo.registrar("Ingles 1", ingles1, 0);
        grafo.registrar("Calculo 2", calculo2, 4);
        grafo.registrar("Fisica mecanica", fisicamecanica, 4);
        grafo.registrar("Algoritmia 1", algoritmia1, 3);
        grafo.registrar("Competencias 2", competencias2, 3);
        grafo.registrar("Ingles 2", ingles2, 0);
        grafo.registrar("Calculo 3", calculo3, 4);
        grafo.registrar("Fisica calor", fisicacalor, 4);
        grafo.registrar("Estatica", estatica, 3);
        grafo.registrar("CienciaMateriales", CienciaMateriales, 3);
        grafo.registrar("Ecuaciones", ecuaciones, 3);
        grafo.registrar("Ingles 3", ingles3, 0);
        grafo.registrar("Ing Materiales", IngMateriales, 4);
        grafo.registrar("Fisica electrica", fisicaelectrica, 4);
        grafo.registrar("Termodinamica 1", Termo1, 3);
        grafo.registrar("Dinamica", Dinamica, 3);
        grafo.registrar("Mecanica de Solidos", MecanicaSolidos, 3);
        grafo.registrar("Ingles 4", ingles4, 0);
        grafo.registrar("Seminario 1", seminario1, 0);
        grafo.registrar("Solucion computacionales", SolucionComput, 3);
        grafo.registrar("Termo2", Termo2, 3);
        grafo.registrar("MecanicaMaquinas", MecanicaMaquinas, 3);
        grafo.registrar("Procesos Fabricacion", ProcesosFabricacion, 3);
        grafo.registrar("Mecanica de fluidos", mecanicadefluidos, 3);
        grafo.registrar("Examen comprehensivo 1", examencom1, 0);
        grafo.registrar("Ingles 5", ingles5, 0);
        grafo.registrar("Ing. Economica", IngEconomica, 3);
        grafo.registrar("Analisis Datos", AnalisisDatos, 3);
        grafo.registrar("Transferencia de calor", TransferenciaCalor, 3);
        grafo.registrar("DiseñoMec", DiseñoMec, 3);
        grafo.registrar("EstudioCaribe", ElectivaEstudioCaribe, 3);
        grafo.registrar("Ingles 6", ingles6, 0);
        grafo.registrar("Electiva de Sistemas Electricos", ElectivaSistemaElec, 3);
        grafo.registrar("Modelo Sistemas Dinamicos", ModelosSistemasDinam, 3);
        grafo.registrar("Diseño Sistema Termo", DiseñoSistemaTermo, 3);
        grafo.registrar("Diseño Sistema Mecanico", DiseñoSistemaMec, 3);
        grafo.registrar("Electiva Etica", ElectivaEtica, 3);
        grafo.registrar("Ingles 7", ingles7, 0);
        grafo.registrar("Electiva ciencias vida", ElectivaCienciasVida, 3);
        grafo.registrar("Proyecto de investigacion", ProyectoInves, 3);
        grafo.registrar("Instrumentacion Control", InstrumentacionControl, 2);
        grafo.registrar("Gestion Activos", GestionActivos, 3);
        grafo.registrar("Electiva filosofia", ElectivaFilosofia, 3);
        grafo.registrar("Electiva innovacion", innovacion, 3);
        grafo.registrar("Ingles 8", ingles8, 0);
        grafo.registrar("Electiva Energia", ElectivaEnergia, 3);
        grafo.registrar("Electiva Diseño Materiales", ElectivaDiseñoMateriales, 3);
        grafo.registrar("Electiva formacion complementaria 1", complementaria1, 3);
        grafo.registrar("Electiva Historia", ElectivaHistoria, 3);
        grafo.registrar("Electiva sociales", sociales, 3);
        grafo.registrar("Examen comprehensivo 2", examencom2, 0);
        grafo.registrar("Seminario 2", seminario2, 0);
        grafo.registrar("Electiva humanidades", humanidades, 3);
        grafo.registrar("Electiva Mecanica", ElecativaMec, 3);
        grafo.registrar("Proyecto final", proyectofinal, 3);
        grafo.registrar("Electiva formacion complementaria 2", formacioncomplementaria2, 3);
    }

    private void definirAristas() {
        // CONECTAR LAS ARISTAS SEGÚN PLAN DE ESTUDIOS DE INGENIERÍA MECÁNICA

        grafo.prereq("Calculo 2", "Calculo 1");
        grafo.prereq("Fisica mecanica", "Calculo 1");
        grafo.prereq("Competencias 2", "Competencias 1");

        grafo.prereq("Calculo 3", "Calculo 2");
        grafo.prereq("Calculo 3", "Algebra lineal");
        grafo.prereq("Fisica calor", "Calculo 1");
        grafo.prereq("Fisica calor", "Fisica mecanica");
        grafo.prereq("Estatica", "Fisica mecanica");
        grafo.prereq("Ecuaciones", "Calculo 2");
        
        grafo.prereq("Fisica electrica", "Calculo 2");
        grafo.prereq("Fisica electrica", "Fisica mecanica");
        grafo.prereq("Dinamica", "Calculo 2");
        grafo.prereq("Dinamica", "Estatica");
        grafo.prereq("Termodinamica 1", "Fisica calor");
        grafo.prereq("Ing Materiales" , "CienciaMateriales");
        grafo.prereq("Mecanica de Solidos", "Estatica");
        

        grafo.prereq("Solucion computacionales", "Algoritmia 1");
        grafo.prereq("Solucion computacionales", "Ecuaciones");
        grafo.prereq("Examen comprehensivo 1", "Ecuaciones");
        grafo.prereq("Examen comprehensivo 1", "Calculo 3");
        grafo.prereq("Examen comprehensivo 1", "Fisica mecanica");
        grafo.prereq("Examen comprehensivo 1", "Fisica calor");
        grafo.prereq("Examen comprehensivo 1", "Fisica electrica");
        grafo.prereq("Termo2", "Termodinamica 1");
        grafo.prereq("Procesos Fabricacion", "CienciaMateriales");
        grafo.prereq("MecanicaMaquinas", "Dinamica");
        grafo.prereq("Mecanica de fluidos", "Ecuaciones");
        
        
        grafo.prereq("Analisis Datos", "Calculo 2");
        grafo.prereq("Transferencia de calor", "Termo2");
        grafo.prereq("Transferencia de calor", "Mecanica de fluidos");
        grafo.prereq("Transferencia de calor", "Examen comprehensivo 1");
        grafo.prereq("DiseñoMec", "Mecanica de Solidos");
        grafo.prereq("DiseñoMec", "MecanicaMaquinas");
        grafo.prereq("DiseñoMec", "Examen comprehensivo 1");

        grafo.prereq("Electiva de Sistemas Electricos", "Fisica electrica");
        grafo.prereq("Modelo Sistemas Dinamicos", "Fisica electrica");
        grafo.prereq("Modelo Sistemas Dinamicos", "Ecuaciones");
        grafo.prereq("Modelo Sistemas Dinamicos", "Fisica calor");
        grafo.prereq("Diseño Sistema Termo", "Transferencia de calor");
        grafo.prereq("Diseño Sistema Termo", "Termo2");
        grafo.prereq("Diseño Sistema Mecanico", "DiseñoMec");

        
        grafo.prereq("Instrumentacion Control", "Modelo Sistemas Dinamicos");
        grafo.prereq("Proyecto de investigacion", "Transferencia de calor");
        grafo.prereq("Proyecto de investigacion", "DiseñoMec");


        grafo.prereq("Electiva Energia", "Transferencia de calor");
        grafo.prereq("Electiva Diseño Materiales", "DiseñoMec");
        
        grafo.prereq("Electiva Mecanica", "DiseñoMec");
        grafo.prereq("Electiva Mecanica", "Transferencia de calor");
        grafo.prereq("Proyecto final", "Proyecto de investigacion");
        grafo.prereq("Proyecto final", "DiseñoMec");
        grafo.prereq("Proyecto final", "Diseño Sistema Termo");
        grafo.prereq("Proyecto final", "Instrumentacion Control");
        grafo.prereq("Proyecto final", "Ingles 8");
    }

    private void agruparPorSemestre() {
        materiasPorSemestre.put(1, Arrays.asList(
                grafo.getNodo("Algebra lineal"),
                grafo.getNodo("Calculo 1"),
                grafo.getNodo("Introduccion a la ingenieria"),
                grafo.getNodo("Expresion grafica"),
                grafo.getNodo("Competencias 1"),
                grafo.getNodo("Ingles 1")
        ));

        materiasPorSemestre.put(2, Arrays.asList(
                grafo.getNodo("Calculo 2"),
                grafo.getNodo("Fisica mecanica"),
                grafo.getNodo("Algoritmia 1"),
                grafo.getNodo("Competencias 2"),
                grafo.getNodo("Ingles 2")
        ));

        materiasPorSemestre.put(3, Arrays.asList(
                grafo.getNodo("Calculo 3"),
                grafo.getNodo("Fisica calor"),
                grafo.getNodo("Estatica"),
                grafo.getNodo("CienciaMateriales"),
                grafo.getNodo("Ecuaciones"),
                grafo.getNodo("Ingles 3")
        ));

        materiasPorSemestre.put(4, Arrays.asList(
                grafo.getNodo("Ing Materiales"),
                grafo.getNodo("Fisica electrica"),
                grafo.getNodo("Termodinamica 1"),
                grafo.getNodo("Dinamica"),
                grafo.getNodo("Mecanica de Solidos"),
                grafo.getNodo("Ingles 4"),
                grafo.getNodo("Seminario 1")
        ));

        materiasPorSemestre.put(5, Arrays.asList(
                grafo.getNodo("Solucion computacionales"),
                grafo.getNodo("Termo2"),
                grafo.getNodo("MecanicaMaquinas"),
                grafo.getNodo("Procesos Fabricacion"),
                grafo.getNodo("Mecanica de fluidos"),
                grafo.getNodo("Examen comprehensivo 1"),
                grafo.getNodo("Ingles 5")
        ));

        materiasPorSemestre.put(6, Arrays.asList(
                grafo.getNodo("Ing. Economica"),
                grafo.getNodo("Analisis Datos"),
                grafo.getNodo("Transferencia de calor"),
                grafo.getNodo("DiseñoMec"),
                grafo.getNodo("Ingles 6")
        ));

        materiasPorSemestre.put(7, Arrays.asList(
                grafo.getNodo("Electiva de Sistemas Electricos"),
                grafo.getNodo("Modelo Sistemas Dinamicos"),
                grafo.getNodo("Diseño Sistema Termo"),
                grafo.getNodo("Diseño Sistema Mecanico"),
                grafo.getNodo("Electiva Etica"),
                grafo.getNodo("Ingles 7")
        ));

        materiasPorSemestre.put(8, Arrays.asList(
                grafo.getNodo("Electiva ciencias vida"),
                grafo.getNodo("Proyecto de investigacion"),
                grafo.getNodo("Instrumentacion Control"),
                grafo.getNodo("Gestion Activos"),
                grafo.getNodo("Electiva filosofia"),
                grafo.getNodo("Electiva innovacion"),
                grafo.getNodo("Ingles 8")
        ));

        materiasPorSemestre.put(9, Arrays.asList(
                grafo.getNodo("Electiva Energia"),
                grafo.getNodo("Electiva Diseño Materiales"),
                grafo.getNodo("Electiva formacion complementaria 1"),
                grafo.getNodo("Electiva Historia"),
                grafo.getNodo("Electiva humanidades"),
                grafo.getNodo("Examen comprehensivo 2"),
                grafo.getNodo("Seminario 2")
        ));

        materiasPorSemestre.put(10, Arrays.asList(
                grafo.getNodo("Electiva Mecanica"),
                grafo.getNodo("Proyecto final"),
                grafo.getNodo("Electiva formacion complementaria 2"),
                grafo.getNodo("EstudioCaribe"),
                grafo.getNodo("Electiva sociales")
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

        GestionActivos = new javax.swing.JButton();
        Dinamica = new javax.swing.JButton();
        SolucionComput = new javax.swing.JButton();
        humanidades = new javax.swing.JButton();
        algoritmia1 = new javax.swing.JButton();
        expresion = new javax.swing.JButton();
        seminario2 = new javax.swing.JButton();
        mecanicadefluidos = new javax.swing.JButton();
        ecuaciones = new javax.swing.JButton();
        ElectivaEnergia = new javax.swing.JButton();
        ElecativaMec = new javax.swing.JButton();
        CienciaMateriales = new javax.swing.JButton();
        RegresarBtn = new javax.swing.JButton();
        proyectofinal = new javax.swing.JButton();
        ingles3 = new javax.swing.JButton();
        formacioncomplementaria2 = new javax.swing.JButton();
        calculo3 = new javax.swing.JButton();
        ingles5 = new javax.swing.JButton();
        sociales = new javax.swing.JButton();
        seminario1 = new javax.swing.JButton();
        Termo2 = new javax.swing.JButton();
        fisicacalor = new javax.swing.JButton();
        examencom2 = new javax.swing.JButton();
        examencom1 = new javax.swing.JButton();
        MecanicaMaquinas = new javax.swing.JButton();
        DiseñoMec = new javax.swing.JButton();
        competencias2 = new javax.swing.JButton();
        estatica = new javax.swing.JButton();
        ingles2 = new javax.swing.JButton();
        ElectivaSistemaElec = new javax.swing.JButton();
        calculo2 = new javax.swing.JButton();
        IngMateriales = new javax.swing.JButton();
        ElectivaEtica = new javax.swing.JButton();
        ingles7 = new javax.swing.JButton();
        ModelosSistemasDinam = new javax.swing.JButton();
        fisicamecanica = new javax.swing.JButton();
        ProcesosFabricacion = new javax.swing.JButton();
        IngEconomica = new javax.swing.JButton();
        DiseñoSistemaTermo = new javax.swing.JButton();
        algebra = new javax.swing.JButton();
        MecanicaSolidos = new javax.swing.JButton();
        ElectivaEstudioCaribe = new javax.swing.JButton();
        ingles4 = new javax.swing.JButton();
        competencias1 = new javax.swing.JButton();
        innovacion = new javax.swing.JButton();
        ingles6 = new javax.swing.JButton();
        limpiarbtn = new javax.swing.JButton();
        ElectivaDiseñoMateriales = new javax.swing.JButton();
        DiseñoSistemaMec = new javax.swing.JButton();
        AnalisisDatos = new javax.swing.JButton();
        ElectivaCienciasVida = new javax.swing.JButton();
        ElectivaFilosofia = new javax.swing.JButton();
        Termo1 = new javax.swing.JButton();
        ingles8 = new javax.swing.JButton();
        ingles1 = new javax.swing.JButton();
        fisicaelectrica = new javax.swing.JButton();
        ProyectoInves = new javax.swing.JButton();
        calculo1 = new javax.swing.JButton();
        complementaria1 = new javax.swing.JButton();
        InstrumentacionControl = new javax.swing.JButton();
        TransferenciaCalor = new javax.swing.JButton();
        introduccion = new javax.swing.JButton();
        ElectivaHistoria = new javax.swing.JButton();
        IIsem = new javax.swing.JButton();
        Isem = new javax.swing.JButton();
        IVsem = new javax.swing.JButton();
        IIIsem = new javax.swing.JButton();
        VIsem = new javax.swing.JButton();
        Vsem = new javax.swing.JButton();
        VIIIsem = new javax.swing.JButton();
        VIIsem = new javax.swing.JButton();
        Xsem = new javax.swing.JButton();
        IXsem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GestionActivos.setText("Gestión de Activos");

        Dinamica.setText("Dinámica");

        SolucionComput.setText("Soln. Comput. de Problem. Ing.");

        humanidades.setText("Electiva humanidades");

        algoritmia1.setText("Algoritmia y programacion 1");

        expresion.setText("Expresion grafica");

        seminario2.setText("Seminario de carrera 2");

        mecanicadefluidos.setText("Mecanica de fluidos");

        ecuaciones.setText("Ecuaciones diferenciales");

        ElectivaEnergia.setText("Electiva en Energía");

        ElecativaMec.setText("Electiva Ing. Mecanica");

        CienciaMateriales.setText("Ciencia de los Materiales");

        RegresarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegresarBtn.setText("Regresar");
        RegresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarBtnActionPerformed(evt);
            }
        });

        proyectofinal.setText("Proyecto final");

        ingles3.setText("Ingles 3");

        formacioncomplementaria2.setText("Electiva formacion complementaria 2");

        calculo3.setText("Calculo 3");

        ingles5.setText("Ingles 5");

        sociales.setText("Electiva ciencias sociales");

        seminario1.setText("Seminario de carrera 1");

        Termo2.setText("Termodinámica II");

        fisicacalor.setText("Fisica calor ondas");

        examencom2.setText("Examen comprehensivo 2");

        examencom1.setText("Examen comprehensivo 1");

        MecanicaMaquinas.setText("Mecánica de Máquinas");

        DiseñoMec.setText("Diseño Mecánico");

        competencias2.setText("Competencias comunicativas 2");

        estatica.setText("Estatica");

        ingles2.setText("Ingles 2");

        ElectivaSistemaElec.setText("Electiva Sistemas Eléctricos");

        calculo2.setText("Calculo 2");

        IngMateriales.setText("Ingeniería de Materiales");

        ElectivaEtica.setText("Electiva en Etica");

        ingles7.setText("Ingles 7");

        ModelosSistemasDinam.setText("Modelos de Sistemas Dinámicos");

        fisicamecanica.setText("Fisica mecanica");

        ProcesosFabricacion.setText("Procesos de Fabricación");

        IngEconomica.setText("Ingeniería Económica");

        DiseñoSistemaTermo.setText("Diseño de Sistemas Térmofluidos");

        algebra.setText("Algebra Lineal");
        algebra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algebraActionPerformed(evt);
            }
        });

        MecanicaSolidos.setText("Mecánica de Sólidos");

        ElectivaEstudioCaribe.setText("Elect Estudios del Caribe");

        ingles4.setText("Ingles 4");

        competencias1.setText("Competencias comunicativas 1");

        innovacion.setText("Electiva innovacion");
        innovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                innovacionActionPerformed(evt);
            }
        });

        ingles6.setText("Ingles 6");

        limpiarbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        limpiarbtn.setText("Limpiar");
        limpiarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarbtnActionPerformed(evt);
            }
        });

        ElectivaDiseñoMateriales.setText("Electiva en Diseño y Materiales");

        DiseñoSistemaMec.setText("Diseño de Sistemas Mecánicos");

        AnalisisDatos.setText("Análisis de Datos en Ingeniería I");

        ElectivaCienciasVida.setText("Elec Ciencias de la vida");

        ElectivaFilosofia.setText("Electiva en Filosofía");

        Termo1.setText("Termodinámica I");

        ingles8.setText("Ingles 8");
        ingles8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingles8ActionPerformed(evt);
            }
        });

        ingles1.setText("Ingles 1");

        fisicaelectrica.setText("Fisica electricidad");

        ProyectoInves.setText("Proyecto de Investigación");
        ProyectoInves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProyectoInvesActionPerformed(evt);
            }
        });

        calculo1.setText("Calculo 1");

        complementaria1.setText("Electiva formacion complementaria 1");

        InstrumentacionControl.setText("Instrumentación y Control");
        InstrumentacionControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstrumentacionControlActionPerformed(evt);
            }
        });

        TransferenciaCalor.setText("Transferencia de Calor");

        introduccion.setText("Introducción a la Ing Mecánica ");

        ElectivaHistoria.setText("Electiva en Historia");

        IIsem.setText("II");
        IIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IIsemActionPerformed(evt);
            }
        });

        Isem.setText("I");
        Isem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsemActionPerformed(evt);
            }
        });

        IVsem.setText("IV");
        IVsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVsemActionPerformed(evt);
            }
        });

        IIIsem.setText("III");
        IIIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IIIsemActionPerformed(evt);
            }
        });

        VIsem.setText("VI");
        VIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIsemActionPerformed(evt);
            }
        });

        Vsem.setText("V");
        Vsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VsemActionPerformed(evt);
            }
        });

        VIIIsem.setText("VIII");
        VIIIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIIIsemActionPerformed(evt);
            }
        });

        VIIsem.setText("VII");
        VIIsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIIsemActionPerformed(evt);
            }
        });

        Xsem.setText("X");
        Xsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XsemActionPerformed(evt);
            }
        });

        IXsem.setText("IX");
        IXsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IXsemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ElectivaHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ElectivaEstudioCaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Isem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(IIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(IIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(IVsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(Vsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(VIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(VIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(VIIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(IXsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(Xsem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(Termo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(Termo2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(AnalisisDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(ModelosSistemasDinam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(ProyectoInves, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(ElectivaDiseñoMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(ElecativaMec, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(MecanicaMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(TransferenciaCalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(DiseñoSistemaTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(InstrumentacionControl, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(estatica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(Dinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(ProcesosFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(DiseñoMec, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(DiseñoSistemaMec, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(GestionActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(182, 182, 182)
                            .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(185, 185, 185)
                            .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(IngMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(SolucionComput, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(IngEconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(ElectivaSistemaElec, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(ElectivaCienciasVida, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(ElectivaEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(443, 443, 443)
                                    .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(328, 328, 328)
                                    .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(seminario2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(CienciaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(MecanicaSolidos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(mecanicadefluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(181, 181, 181)
                            .addComponent(ElectivaEtica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(ElectivaFilosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Isem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IVsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Vsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VIIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Xsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IXsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ElectivaEstudioCaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ElectivaHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(91, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IngMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SolucionComput, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IngEconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ElectivaSistemaElec, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ElectivaCienciasVida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ElectivaEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Termo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Termo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AnalisisDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ModelosSistemasDinam, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProyectoInves, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ElectivaDiseñoMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ElecativaMec, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MecanicaMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TransferenciaCalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DiseñoSistemaTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(InstrumentacionControl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estatica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Dinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProcesosFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DiseñoMec, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DiseñoSistemaMec, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GestionActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CienciaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MecanicaSolidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mecanicadefluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ElectivaEtica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ElectivaFilosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ingles1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingles2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingles3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingles4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingles5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingles6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingles7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(seminario1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(examencom1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(innovacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seminario2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RegresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
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

    private void ProyectoInvesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProyectoInvesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProyectoInvesActionPerformed

    private void InstrumentacionControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstrumentacionControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InstrumentacionControlActionPerformed

    private void IIsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IIsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IIsemActionPerformed

    private void IsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsemActionPerformed

    private void IVsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IVsemActionPerformed

    private void IIIsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IIIsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IIIsemActionPerformed

    private void VIsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VIsemActionPerformed

    private void VsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VsemActionPerformed

    private void VIIIsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIIIsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VIIIsemActionPerformed

    private void VIIsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIIsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VIIsemActionPerformed

    private void XsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XsemActionPerformed

    private void IXsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IXsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IXsemActionPerformed

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
    private javax.swing.JButton AnalisisDatos;
    private javax.swing.JButton CienciaMateriales;
    private javax.swing.JButton Dinamica;
    private javax.swing.JButton DiseñoMec;
    private javax.swing.JButton DiseñoSistemaMec;
    private javax.swing.JButton DiseñoSistemaTermo;
    private javax.swing.JButton ElecativaMec;
    private javax.swing.JButton ElectivaCienciasVida;
    private javax.swing.JButton ElectivaDiseñoMateriales;
    private javax.swing.JButton ElectivaEnergia;
    private javax.swing.JButton ElectivaEstudioCaribe;
    private javax.swing.JButton ElectivaEtica;
    private javax.swing.JButton ElectivaFilosofia;
    private javax.swing.JButton ElectivaHistoria;
    private javax.swing.JButton ElectivaSistemaElec;
    private javax.swing.JButton GestionActivos;
    private javax.swing.JButton IIIsem;
    private javax.swing.JButton IIsem;
    private javax.swing.JButton IVsem;
    private javax.swing.JButton IXsem;
    private javax.swing.JButton IngEconomica;
    private javax.swing.JButton IngMateriales;
    private javax.swing.JButton InstrumentacionControl;
    private javax.swing.JButton Isem;
    private javax.swing.JButton MecanicaMaquinas;
    private javax.swing.JButton MecanicaSolidos;
    private javax.swing.JButton ModelosSistemasDinam;
    private javax.swing.JButton ProcesosFabricacion;
    private javax.swing.JButton ProyectoInves;
    private javax.swing.JButton RegresarBtn;
    private javax.swing.JButton SolucionComput;
    private javax.swing.JButton Termo1;
    private javax.swing.JButton Termo2;
    private javax.swing.JButton TransferenciaCalor;
    private javax.swing.JButton VIIIsem;
    private javax.swing.JButton VIIsem;
    private javax.swing.JButton VIsem;
    private javax.swing.JButton Vsem;
    private javax.swing.JButton Xsem;
    private javax.swing.JButton algebra;
    private javax.swing.JButton algoritmia1;
    private javax.swing.JButton calculo1;
    private javax.swing.JButton calculo2;
    private javax.swing.JButton calculo3;
    private javax.swing.JButton competencias1;
    private javax.swing.JButton competencias2;
    private javax.swing.JButton complementaria1;
    private javax.swing.JButton ecuaciones;
    private javax.swing.JButton estatica;
    private javax.swing.JButton examencom1;
    private javax.swing.JButton examencom2;
    private javax.swing.JButton expresion;
    private javax.swing.JButton fisicacalor;
    private javax.swing.JButton fisicaelectrica;
    private javax.swing.JButton fisicamecanica;
    private javax.swing.JButton formacioncomplementaria2;
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
    private javax.swing.JButton limpiarbtn;
    private javax.swing.JButton mecanicadefluidos;
    private javax.swing.JButton proyectofinal;
    private javax.swing.JButton seminario1;
    private javax.swing.JButton seminario2;
    private javax.swing.JButton sociales;
    // End of variables declaration//GEN-END:variables
}
