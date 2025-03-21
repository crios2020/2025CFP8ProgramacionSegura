package ar.org.centro8.curso.java.gui;
import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.enums.Dia;
import ar.org.centro8.curso.java.enums.Turno;
import ar.org.centro8.curso.java.repositories.interfaces.I_AlumnoRepository;
import ar.org.centro8.curso.java.repositories.interfaces.I_CursoRepository;
import ar.org.centro8.curso.java.repositories.jdbc.AlumnoRepository;
import ar.org.centro8.curso.java.repositories.jdbc.CursoRepository;
import ar.org.centro8.curso.java.utils.swing.Table;
import ar.org.centro8.curso.java.utils.swing.Validator;
import javax.swing.JOptionPane;
public class FormCursos extends javax.swing.JInternalFrame {
    private I_CursoRepository cr=new CursoRepository(Connector.getConnection());
    private I_AlumnoRepository ar=new AlumnoRepository(Connector.getConnection());
    public FormCursos() {
        super(
                "Formulario de cursos",         //title
                false,                          //resizable
                true,                           //closable
                false,                          //maximizable
                true                            //iconable
        );
        initComponents();
        
        cargarElementos();
         
    }

    
    private void cargarElementos() {
        //cargar cmbDia
        //cmbDia.removeAllItems();
        for(Dia d:Dia.values()) cmbDia.addItem(d);
        
        //cargar cmbTurno
        cmbTurno.removeAllItems();
        for(Turno t:Turno.values()) cmbTurno.addItem(t);
        
        //cargar tblCursos
        new Table<Curso>().cargar(tblCursos, cr.getAll());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProfesor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbDia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbTurno = new javax.swing.JComboBox<>();
        lblInfo = new javax.swing.JLabel();
        btnAlta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarTitulo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnoMostarAlumnos = new javax.swing.JButton();

        jLabel1.setText("Titulo:");

        jLabel2.setText("Profesor:");

        jLabel3.setText("Día:");

        jLabel4.setText("Turno:");

        lblInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAlta.setText("Dar de Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCursos);

        jLabel5.setText("Buscar Titulo:");

        txtBuscarTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarTituloKeyReleased(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnoMostarAlumnos.setText("Mostar Alumnos");
        btnoMostarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoMostarAlumnosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTitulo)
                                    .addComponent(txtProfesor)
                                    .addComponent(cmbDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(btnEliminar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnoMostarAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnoMostarAlumnos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        // Alta de Curso
        if(!validar()) return;
        Curso curso=new Curso(
                txtTitulo.getText(),
                txtProfesor.getText(),
                cmbDia.getItemAt(cmbDia.getSelectedIndex()),
                cmbTurno.getItemAt(cmbTurno.getSelectedIndex())
        );
        cr.save(curso);
        lblInfo.setText("Se dio de alta el curso id: "+curso.getId());
        limpiar();
        cargarElementos();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void limpiar(){
        txtTitulo.setText("");
        txtTitulo.requestFocus();
        txtProfesor.setText("");
        cmbDia.setSelectedIndex(0);
        cmbTurno.setSelectedIndex(0);
    }
    
    private void txtBuscarTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTituloKeyReleased
        // Evento Buscar Titulo
        new Table().cargar(tblCursos, cr.getLikeTitulo(txtBuscarTitulo.getText()));
    }//GEN-LAST:event_txtBuscarTituloKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Evento Eliminar
        int fila=tblCursos.getSelectedRow();
        if(fila==-1) return;
        int id=(int)tblCursos.getValueAt(fila, 0);
        //System.out.println(id);
        if(JOptionPane.showConfirmDialog(this, "Desea borrar el curso id:"+id+"?")!=0) return;
        Curso curso=cr.getById(id);
        if(ar.getByCurso(curso).size()!=0){
            JOptionPane.showMessageDialog(this, "El curso no se puede eliminar, por que contiene alumnos!","error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        cr.remove(curso);
        cargarElementos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnoMostarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoMostarAlumnosActionPerformed
        // Evento Mostrar Alumnos
        int fila=tblCursos.getSelectedRow();
        if(fila==-1) return;
        int id=(int)tblCursos.getValueAt(fila, 0);
        Curso curso=cr.getById(id);
        ListarAlumnos la=new ListarAlumnos(curso);
        this.getParent().add(la);
        la.setVisible(true);
    }//GEN-LAST:event_btnoMostarAlumnosActionPerformed

    private boolean validar(){
        if(!new Validator(txtTitulo).length(3, 20))     return false;
        if(!new Validator(txtProfesor).length(3, 20))   return false;
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnoMostarAlumnos;
    private javax.swing.JComboBox<Dia> cmbDia;
    private javax.swing.JComboBox<Turno> cmbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextField txtBuscarTitulo;
    private javax.swing.JTextField txtProfesor;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
