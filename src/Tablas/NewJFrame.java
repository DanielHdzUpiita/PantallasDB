package Tablas;

import DB.Aviso;
import DB.Privilegio;
import DB.TestCheck;
import DB.Usuario;
import ObjetosDB.ConexionBD;
import java.sql.SQLException;
import java.util.LinkedList;

public final class NewJFrame extends javax.swing.JFrame {
    //ModeloTabla modelo = new ModeloTabla();
    ModeloTabla1 model = new ModeloTabla1(new String[]{"ID","AVISO","CHK"});
    ModeloTabla1 model1 = new ModeloTabla1(new String[]{"ID","PRIVILEGIO"});
    
    public NewJFrame() {
        //model.datos = this.consultaBase();//Avisos
        //model.datos = this.consultaBase2();//Avisos
        model.datos = this.consultaBase3();//Avisos
        model1.datos = this.consultaBase1();//Privilegios
        initComponents();
    }
    
    public LinkedList consultaBase()
    {
        ConexionBD db = new ConexionBD();
        LinkedList res = new LinkedList();
        try {
            db.iniciar();
            db.consultar("SELECT * from avisos order by id_aviso");
            while(db.resultado.next()){
                Aviso aux = new Aviso();
                int a = db.resultado.getInt("id_aviso");
                String b = db.resultado.getString("aviso");
                aux.id = a;
                aux.aviso = b;
                res.add(aux);
            }
        } catch (SQLException ex) {
        }
        finally
        {
            if(db.estaConectado())
            {
                db.detener();
            }
        }
        return res;
    }
    public LinkedList consultaBase1()
    {
        ConexionBD db = new ConexionBD();
        LinkedList res = new LinkedList();
        try {
            db.iniciar();
            db.consultar("SELECT * from privilegios order by id_privilegio");
            while(db.resultado.next()){
                int a = db.resultado.getInt("id_privilegio");
                String b = db.resultado.getString("descripcion");
                Privilegio aux = new Privilegio();
                aux.id = a;
                aux.priv = b;
                res.add(aux);
            }
        } catch (SQLException ex) {
        }
        finally
        {
            if(db.estaConectado())
            {
                db.detener();
            }
        }
        return res;
    }
    public LinkedList consultaBase2()
    {
        ConexionBD db = new ConexionBD();
        LinkedList res = new LinkedList();
        try {
            db.iniciar();
            db.consultar("SELECT * from avisos order by id_aviso");
            while(db.resultado.next()){
                Aviso aux = new Aviso();
                aux.consulta(db.resultado, "*");
                res.add(aux);
            }
        } catch (SQLException ex) {
        }
        finally
        {
            if(db.estaConectado())
            {
                db.detener();
            }
        }
        return res;
    }
    public LinkedList consultaBase3()
    {
        ConexionBD db = new ConexionBD();
        LinkedList res = new LinkedList();
        try {
            db.iniciar();
            db.consultar("SELECT * from avisos order by id_aviso");
            while(db.resultado.next()){
                TestCheck aux = new TestCheck();
                aux.consulta(db.resultado, "*");
                res.add(aux);
            }
        } catch (SQLException ex) {
        }
        finally
        {
            if(db.estaConectado())
            {
                db.detener();
            }
        }
        return res;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(model1);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TestCheck chk1 = (TestCheck)model.datos.get(0);
        if(chk1.flag){
            System.out.println("Funcionó :D");
        }
        else {
            System.out.println("No Funcionó :D");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        u1.user = "abc";
        u1.pass = "123";
        u2.user = "abc";
        u2.pass = "123";
        
        if(u1.isEqual(u2)){
            System.out.println("Great test!!");
        }
        else
        {
            System.out.println("Awwwwwwwww!!");
        }
        
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}