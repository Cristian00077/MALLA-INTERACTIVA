
package core.modelo;
import core.persistencia.*;
import static core.persistencia.Estado.APROBADA;
import static core.persistencia.Estado.BLOQUEADA;
import static core.persistencia.Estado.DISPONIBLE;
import javax.swing.JOptionPane;
public class Mecanica extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Mecanica.class.getName());

    public Mecanica() {
        initComponents();
        armarGrafo();
        definirAristas();
        inicializarEstados();
        conectarListeners();
        actualizarInterfaz();
    }
    private Grafo grafo = new Grafo();
    
    private void armarGrafo(){
        grafo.registrar("Algebra lineal", algebra, 3);    
        grafo.registrar("Calculo 1", calculo1, 5);   
        grafo.registrar("Introduccion a la ingenieria", introduccion, 1);    
        grafo.registrar("Expresion grafica", expresion, 3);
        grafo.registrar("Competencias 1",  competencias1, 3);    
        grafo.registrar("Ingles 1",  ingles1, 0);      
        grafo.registrar("Calculo 2", calculo2, 4);   
        grafo.registrar("Fisica mecanica", fisicamecanica, 4);
        grafo.registrar("Algoritmia 1", algoritmia1, 3);
        grafo.registrar("Quimica", quimica, 3);
        grafo.registrar("Competencias 2", competencias2, 3);
        grafo.registrar("Ingles 2", ingles2, 0);       
        grafo.registrar("Calculo 3", calculo3, 4);   
        grafo.registrar("Fisica calor", fisicacalor, 4);
        grafo.registrar("Estatica", estatica, 3);
        grafo.registrar("Topografia", topografia, 3);
        grafo.registrar("Ecuaciones", ecuaciones, 3); 
        grafo.registrar("Ingles 3", ingles3, 0);    
        grafo.registrar("Analisis de datos", analisisdatos, 4);
        grafo.registrar("Fisica electrica", fisicaelectrica, 4);
        grafo.registrar("Mecanica de solidos", mecanicadesolidos, 3);      
        grafo.registrar("Geologia", geologia, 3);
        grafo.registrar("Electiva estudios caribe", estudiosdelcaribe, 3); 
        grafo.registrar("Ingles 4", ingles4, 0);   
        grafo.registrar("Seminario 1", seminario1, 0);
        grafo.registrar("Electiva ciencias basicas", cienciasbasicas, 3);
        grafo.registrar("Electiva basica profesional", basicaprofesional, 3);
        grafo.registrar("Materiales de construccion", materiales, 3);   
        grafo.registrar("Soluciones computacionales", soluciones, 3);
        grafo.registrar("Mecanica de fluidos", mecanicadefluidos, 3);   
        grafo.registrar("Examen comprehensivo 1", examencom1, 0); 
        grafo.registrar("Ingles 5", ingles5, 0); 
        grafo.registrar("Formulacion de proyectos", formulacion, 3);       
        grafo.registrar("Electiva historia", historia, 3);
        grafo.registrar("Analisis estructural", analisisestructural, 3);
        grafo.registrar("Mecanica de suelos", mecanicadesuelos, 3);
        grafo.registrar("Hidrologia", hidrologia, 3); 
        grafo.registrar("Ingles 6", ingles6, 0);  
        grafo.registrar("Diseño de vias", diseñodevias, 3);
        grafo.registrar("Construccion", construccion, 3);
        grafo.registrar("Diseño estructural", diseñoestructural, 3);
        grafo.registrar("Fundaciones", fundaciones, 3);
        grafo.registrar("Hidraulica", hidraulica, 3); 
        grafo.registrar("Ingles 7", ingles7, 0);
        grafo.registrar("Ingenieria de transporte", ingenieriadetransporte, 3); 
        grafo.registrar("Administracion y control de la construccion", administracion, 3);
        grafo.registrar("Ingenieria ambiental", ingenieriaambiental, 2);
        grafo.registrar("Electiva etica", etica, 3); 
        grafo.registrar("Acueducto y alcantarillado", acueducto, 3);
        grafo.registrar("Electiva innovacion", innovacion, 3); 
        grafo.registrar("Ingles 8", ingles8, 0); 
        grafo.registrar("Electiva profesional 1", profesional1, 3);  
        grafo.registrar("Electiva profesional 2", profesional2, 3);
        grafo.registrar("Electiva formacion complementaria 1", complementaria1, 3);
        grafo.registrar("Electiva filosofia", filosofia, 3); 
        grafo.registrar("Electiva sociales", sociales, 3);           
        grafo.registrar("Examen comprehensivo 2", examencom2, 0); 
        grafo.registrar("Seminario 2", seminario2, 0);
        grafo.registrar("Electiva humanidades", humanidades, 3); 
        grafo.registrar("Electiva profesional 3", profesional3, 3);   
        grafo.registrar("Proyecto final", proyectofinal, 3);
        grafo.registrar("Electiva formacion complementaria 2", formacioncomplementaria2, 3);
    }
    
    private void definirAristas(){
        //CONECTAR LAS ARISTAS
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

        etica = new javax.swing.JButton();
        geologia = new javax.swing.JButton();
        cienciasbasicas = new javax.swing.JButton();
        humanidades = new javax.swing.JButton();
        algoritmia1 = new javax.swing.JButton();
        expresion = new javax.swing.JButton();
        seminario2 = new javax.swing.JButton();
        mecanicadefluidos = new javax.swing.JButton();
        ecuaciones = new javax.swing.JButton();
        profesional1 = new javax.swing.JButton();
        profesional3 = new javax.swing.JButton();
        topografia = new javax.swing.JButton();
        RegresarBtn = new javax.swing.JButton();
        proyectofinal = new javax.swing.JButton();
        ingles3 = new javax.swing.JButton();
        formacioncomplementaria2 = new javax.swing.JButton();
        calculo3 = new javax.swing.JButton();
        ingles5 = new javax.swing.JButton();
        sociales = new javax.swing.JButton();
        quimica = new javax.swing.JButton();
        seminario1 = new javax.swing.JButton();
        basicaprofesional = new javax.swing.JButton();
        fisicacalor = new javax.swing.JButton();
        examencom2 = new javax.swing.JButton();
        examencom1 = new javax.swing.JButton();
        materiales = new javax.swing.JButton();
        mecanicadesuelos = new javax.swing.JButton();
        competencias2 = new javax.swing.JButton();
        estatica = new javax.swing.JButton();
        ingles2 = new javax.swing.JButton();
        diseñodevias = new javax.swing.JButton();
        calculo2 = new javax.swing.JButton();
        analisisdatos = new javax.swing.JButton();
        hidraulica = new javax.swing.JButton();
        ingles7 = new javax.swing.JButton();
        construccion = new javax.swing.JButton();
        fisicamecanica = new javax.swing.JButton();
        soluciones = new javax.swing.JButton();
        formulacion = new javax.swing.JButton();
        diseñoestructural = new javax.swing.JButton();
        algebra = new javax.swing.JButton();
        estudiosdelcaribe = new javax.swing.JButton();
        hidrologia = new javax.swing.JButton();
        ingles4 = new javax.swing.JButton();
        competencias1 = new javax.swing.JButton();
        innovacion = new javax.swing.JButton();
        ingles6 = new javax.swing.JButton();
        limpiarbtn = new javax.swing.JButton();
        profesional2 = new javax.swing.JButton();
        fundaciones = new javax.swing.JButton();
        historia = new javax.swing.JButton();
        ingenieriadetransporte = new javax.swing.JButton();
        acueducto = new javax.swing.JButton();
        mecanicadesolidos = new javax.swing.JButton();
        ingles8 = new javax.swing.JButton();
        ingles1 = new javax.swing.JButton();
        fisicaelectrica = new javax.swing.JButton();
        administracion = new javax.swing.JButton();
        calculo1 = new javax.swing.JButton();
        complementaria1 = new javax.swing.JButton();
        ingenieriaambiental = new javax.swing.JButton();
        analisisestructural = new javax.swing.JButton();
        introduccion = new javax.swing.JButton();
        filosofia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etica.setText("Electiva etica");

        geologia.setText("Geologia");

        cienciasbasicas.setText("Electiva ciencias basicas ");

        humanidades.setText("Electiva humanidades");

        algoritmia1.setText("Algoritmia y programacion 1");

        expresion.setText("Expresion grafica");

        seminario2.setText("Seminario de carrera 2");

        mecanicadefluidos.setText("Mecanica de fluidos");

        ecuaciones.setText("Ecuaciones diferenciales");

        profesional1.setText("Electiva profesional 1");

        profesional3.setText("Electiva profesional 3");

        topografia.setText("Topografia");

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

        quimica.setText("Quimica");

        seminario1.setText("Seminario de carrera 1");

        basicaprofesional.setText("Electiva basica profesional");

        fisicacalor.setText("Fisica calor ondas");

        examencom2.setText("Examen comprehensivo 2");

        examencom1.setText("Examen comprehensivo 1");

        materiales.setText("Materiales de construccion");

        mecanicadesuelos.setText("Mecanica de suelos");

        competencias2.setText("Competencias comunicativas 2");

        estatica.setText("Estatica");

        ingles2.setText("Ingles 2");

        diseñodevias.setText("Diseño de vias");

        calculo2.setText("Calculo 2");

        analisisdatos.setText("Analisis de datos");

        hidraulica.setText("Hidraulica");

        ingles7.setText("Ingles 7");

        construccion.setText("Construccion");

        fisicamecanica.setText("Fisica mecanica");

        soluciones.setText("Soluciones computacionales");

        formulacion.setText("Formulacion y evaluacion de proyectos");

        diseñoestructural.setText("Diseño estructural");

        algebra.setText("Algebra Lineal");
        algebra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algebraActionPerformed(evt);
            }
        });

        estudiosdelcaribe.setText("Estudios del caribe");

        hidrologia.setText("Hidrologia");

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

        profesional2.setText("Electiva profesional 2");

        fundaciones.setText("Fundaciones");

        historia.setText("Electiva historia");

        ingenieriadetransporte.setText("Ingenieria de transporte");

        acueducto.setText("Acueducto y alcantarillado");

        mecanicadesolidos.setText("Mecanica de solidos");

        ingles8.setText("Ingles 8");
        ingles8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingles8ActionPerformed(evt);
            }
        });

        ingles1.setText("Ingles 1");

        fisicaelectrica.setText("Fisica electricidad");

        administracion.setText("Administraccion y control de la construccion");
        administracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administracionActionPerformed(evt);
            }
        });

        calculo1.setText("Calculo 1");

        complementaria1.setText("Electiva formacion complementaria 1");

        ingenieriaambiental.setText("Ingenieria ambiental");
        ingenieriaambiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingenieriaambientalActionPerformed(evt);
            }
        });

        analisisestructural.setText("Analisis estructural");

        introduccion.setText("Introduccion a ingenieria civil");

        filosofia.setText("Electiva filosofia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1442, Short.MAX_VALUE)
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
                            .addComponent(mecanicadesolidos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(basicaprofesional, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(construccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(administracion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(profesional2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(profesional3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(analisisestructural, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(diseñoestructural, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(ingenieriaambiental, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(geologia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(mecanicadesuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(fundaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(etica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(filosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(quimica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(cienciasbasicas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(formulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(diseñodevias, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(ingenieriadetransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(topografia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(mecanicadefluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(hidrologia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(hidraulica, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(acueducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(algebra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quimica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(analisisdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cienciasbasicas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(formulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(diseñodevias, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingenieriadetransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profesional1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(humanidades, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(calculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mecanicadesolidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(basicaprofesional, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(historia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(construccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(administracion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profesional2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profesional3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(introduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fisicamecanica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fisicacalor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fisicaelectrica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(analisisestructural, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(diseñoestructural, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingenieriaambiental, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(complementaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(proyectofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(algoritmia1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estatica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(geologia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(soluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mecanicadesuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fundaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filosofia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(formacioncomplementaria2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(competencias1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(competencias2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(topografia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estudiosdelcaribe, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mecanicadefluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hidrologia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hidraulica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(acueducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sociales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(ingles8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(examencom2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
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

    private void administracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_administracionActionPerformed

    private void ingenieriaambientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingenieriaambientalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingenieriaambientalActionPerformed

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
    private javax.swing.JButton RegresarBtn;
    private javax.swing.JButton acueducto;
    private javax.swing.JButton administracion;
    private javax.swing.JButton algebra;
    private javax.swing.JButton algoritmia1;
    private javax.swing.JButton analisisdatos;
    private javax.swing.JButton analisisestructural;
    private javax.swing.JButton basicaprofesional;
    private javax.swing.JButton calculo1;
    private javax.swing.JButton calculo2;
    private javax.swing.JButton calculo3;
    private javax.swing.JButton cienciasbasicas;
    private javax.swing.JButton competencias1;
    private javax.swing.JButton competencias2;
    private javax.swing.JButton complementaria1;
    private javax.swing.JButton construccion;
    private javax.swing.JButton diseñodevias;
    private javax.swing.JButton diseñoestructural;
    private javax.swing.JButton ecuaciones;
    private javax.swing.JButton estatica;
    private javax.swing.JButton estudiosdelcaribe;
    private javax.swing.JButton etica;
    private javax.swing.JButton examencom1;
    private javax.swing.JButton examencom2;
    private javax.swing.JButton expresion;
    private javax.swing.JButton filosofia;
    private javax.swing.JButton fisicacalor;
    private javax.swing.JButton fisicaelectrica;
    private javax.swing.JButton fisicamecanica;
    private javax.swing.JButton formacioncomplementaria2;
    private javax.swing.JButton formulacion;
    private javax.swing.JButton fundaciones;
    private javax.swing.JButton geologia;
    private javax.swing.JButton hidraulica;
    private javax.swing.JButton hidrologia;
    private javax.swing.JButton historia;
    private javax.swing.JButton humanidades;
    private javax.swing.JButton ingenieriaambiental;
    private javax.swing.JButton ingenieriadetransporte;
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
    private javax.swing.JButton materiales;
    private javax.swing.JButton mecanicadefluidos;
    private javax.swing.JButton mecanicadesolidos;
    private javax.swing.JButton mecanicadesuelos;
    private javax.swing.JButton profesional1;
    private javax.swing.JButton profesional2;
    private javax.swing.JButton profesional3;
    private javax.swing.JButton proyectofinal;
    private javax.swing.JButton quimica;
    private javax.swing.JButton seminario1;
    private javax.swing.JButton seminario2;
    private javax.swing.JButton sociales;
    private javax.swing.JButton soluciones;
    private javax.swing.JButton topografia;
    // End of variables declaration//GEN-END:variables
}
