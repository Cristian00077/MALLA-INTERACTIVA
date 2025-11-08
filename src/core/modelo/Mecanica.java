package core.modelo;

import core.persistencia.Estado;
import static core.persistencia.Estado.APROBADA;
import static core.persistencia.Estado.BLOQUEADA;
import static core.persistencia.Estado.DISPONIBLE;
import core.persistencia.Grafo;
import core.persistencia.Nodo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    Grafo grafo = new Grafo();

    private void armarGrafo() {
        // Semestre 1
        grafo.registrar("Algebra Lineal", null, 3);
        grafo.registrar("Calculo 1", null, 5);
        grafo.registrar("Expresion Grafica", null, 3);
        grafo.registrar("Introduccion a la Ing Mecanica", null, 1);
        grafo.registrar("Competencias Comunicativas 1", null, 3);
        grafo.registrar("Ingles 1", null, 0);

        // Semestre 2
        grafo.registrar("Calculo 2", null, 4);
        grafo.registrar("Fisica Mecanica", null, 4);
        grafo.registrar("Algoritmia y Programacion 1", null, 3);
        grafo.registrar("Competencias Comunicativas 2", null, 3);
        grafo.registrar("Ingles 2", null, 0);

        // Semestre 3
        grafo.registrar("Calculo 3", null, 4);
        grafo.registrar("Ecuaciones Diferenciales", null, 3);
        grafo.registrar("Fisica calor ondas", null, 4);
        grafo.registrar("Ciencia de los Materiales", null, 3);
        grafo.registrar("Estatica", null, 3);     
        grafo.registrar("Ingles 3", null, 0);

        // Semestre 4
        grafo.registrar("Fisica electricidad", null, 4);
        grafo.registrar("Termodinamica 1", null, 4);
        grafo.registrar("Ingenieria de materiales", null, 3);
        grafo.registrar("Dinamica", null, 3);
        grafo.registrar("Mecanica de Solidos", null, 4);
        grafo.registrar("Seminario de Carrera 1", null, 0);
        grafo.registrar("Ingles 4", null, 0);

        // Semestre 5
        grafo.registrar("Termodinamica 2", null, 3);
        grafo.registrar("Soln. Comput. de Problem. Ing.", null, 3);
        grafo.registrar("Mecanica de Fluidos", null, 4);
        grafo.registrar("Mecanica de Maquinas", null, 4);
        grafo.registrar("Procesos de Fabricacion", null, 3);
        grafo.registrar("Examen Comprehensivo 1", null, 0);
        grafo.registrar("Ingles 5", null, 0);

        // Semestre 6
        grafo.registrar("Ingenieria Economica", null, 3);
        grafo.registrar("Analisis de Datos en Ingenieria", null, 4);
        grafo.registrar("Transferencia de Calor", null, 4);
        grafo.registrar("Diseño Mecanico", null, 4);
        grafo.registrar("Ingles 6", null, 0);

        // Semestre 7
        grafo.registrar("Electiva Sistemas Electricos", null, 3);
        grafo.registrar("Modelos de Sistemas Dinamicos", null, 3);
        grafo.registrar("Diseño de Sistemas Termofluidos", null, 3);
        grafo.registrar("Diseño de Sistemas Mecanicos", null, 4);
        grafo.registrar("Electiva en Etica", null, 3);
        grafo.registrar("Ingles 7", null, 0);

        // semestre 8
        grafo.registrar("Electiva Ciencias de la vida", null, 3);
        grafo.registrar("Proyecto de Investigacion", null, 2);
        grafo.registrar("Instrumentacion y Control", null, 3);
        grafo.registrar("Gestion de Activos", null, 2);
        grafo.registrar("Electiva en Filosofia", null, 3);
        grafo.registrar("Electiva Innov y Dllo Soc", null, 3);
        grafo.registrar("Ingles 8", null, 0);

        // Semestre 9
        grafo.registrar("Electiva Form Compl Libre 1", null, 3);
        grafo.registrar("Electiva en Energia", null, 3);
        grafo.registrar("Electiva en Diseño y Materiales", null, 3);
        grafo.registrar("Electiva en Humanidades", null, 3);
        grafo.registrar("Electiva en Historia", null, 3);
        grafo.registrar("Examen Comprehensivo 2", null, 0);
        grafo.registrar("Seminario de Carrera 2", null, 0);

        // Semestre 10
        grafo.registrar("Electiva Ing. Mecanica", null, 3);
        grafo.registrar("Proyecto Final", null, 3);
        grafo.registrar("El Form Compl Libre 2", null, 3);
        grafo.registrar("Electiva ciencias sociales", null, 3);
        grafo.registrar("Electiva Estudios del Caribe", null, 3);
    }

    private void definirAristas() {
        //CONECTAR LAS ARISTAS
        /*grafo.prereq("Calculo 2", "Calculo 1");
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
        grafo.prereq("Ing Materiales", "CienciaMateriales");
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
        grafo.prereq("Proyecto final", "Ingles 8");*/
        grafo.prereq("Calculo 2", "Calculo 1");
        grafo.prereq("Fisica mecanica", "Calculo 1");
        grafo.prereq("Competencias 2", "Competencias 1");
        grafo.prereq("Calculo 3", "Algebra lineal");
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
        cienciasbasicas = new javax.swing.JButton();
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
        formacioncomplementaria2 = new javax.swing.JButton();
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

        cienciasbasicas.setText("Procesos de fabricacion");

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

        formacioncomplementaria2.setText("Electiva formacion complementaria 2");

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
                .addGap(56, 56, 56)
                .addComponent(Isem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(IIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(IIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(IVsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(Vsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(VIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(VIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(VIIIsem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
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
                .addComponent(cienciasbasicas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Isem)
                    .addComponent(IIsem)
                    .addComponent(IIIsem)
                    .addComponent(IVsem)
                    .addComponent(Vsem)
                    .addComponent(VIsem)
                    .addComponent(VIIsem)
                    .addComponent(VIIIsem)
                    .addComponent(IXsem)
                    .addComponent(Xsem))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(termo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cienciasbasicas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(limpiarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private javax.swing.JButton cienciasbasicas;
    private javax.swing.JButton cienciasvida;
    private javax.swing.JButton competencias1;
    private javax.swing.JButton competencias2;
    private javax.swing.JButton complementaria1;
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
    private javax.swing.JButton formacioncomplementaria2;
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
