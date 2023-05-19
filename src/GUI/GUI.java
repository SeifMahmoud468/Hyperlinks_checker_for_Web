package GUI;

import Classes.Validation;
import Classes.threadValidation;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GUI extends javax.swing.JFrame {

    boolean error;

    public GUI() {
        initComponents();
    }

    public boolean DepthValidation() {
        boolean valid;
        int DepthNumber = 0;
        String D = Depth.getText();
        try {
            DepthNumber = Integer.parseInt(D);
            valid = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Depth Number!!", "Error", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        if (valid) {
            if (DepthNumber < 0) {
                valid = false;
                JOptionPane.showMessageDialog(this, "Incorrect Depth Number!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return valid;
    }

    public boolean ThreadsValidation() {
        boolean valid;
        int ThreadsNumber = 0;
        String D = Threadsno.getText();
        try {
            ThreadsNumber = Integer.parseInt(D);
            valid = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Threads Number!!", "Error", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        if (valid) {
            if (ThreadsNumber <= 0) {
                valid = false;
                JOptionPane.showMessageDialog(this, "Incorrect Threads Number!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return valid;
    }

    public boolean partionIsEmpty() {
        if (URL.getText().length() == 0 || Depth.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Empty Partion !!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        URL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Threadsno = new javax.swing.JTextField();
        Depth = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Page");
        setBackground(new java.awt.Color(205, 205, 205));
        setLocation(new java.awt.Point(500, 250));

        jPanel2.setBackground(new java.awt.Color(205, 205, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        URL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                URLFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Depth:");

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 30)); // NOI18N
        jLabel1.setText("Websites Checker");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("No. of Threads:");

        Threadsno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ThreadsnoFocusLost(evt);
            }
        });

        Depth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DepthFocusLost(evt);
            }
        });
        Depth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DepthKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("URL:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Threadsno, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(URL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Depth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(URL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Threadsno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Depth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void URLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_URLFocusLost
        if (URL.getText().length() > 0) {
            try {
                Document doc = Jsoup.connect(URL.getText()).get();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Invalid URL !!", "Error", JOptionPane.ERROR_MESSAGE);
                URL.setText("");
                URL.grabFocus();
            }
        }
    }//GEN-LAST:event_URLFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        long time = 0;
        if (partionIsEmpty()) {
            error = false;
            error = DepthValidation();
            boolean b = ThreadsValidation();
            if (error && b) {
                try {
                    threadValidation n = new threadValidation(Integer.parseInt(Threadsno.getText()));
                    time = n.v.TimeCalculation(URL.getText(), Integer.parseInt(Depth.getText()));
                    while (((ThreadPoolExecutor) Validation.executor).getActiveCount() > 0) {
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                Output out = new Output(URL.getText(), Validation.sitesNumber, (Validation.validSites - 1), Validation.invalidSites, ((time * 1.0) / 1000));
                out.setVisible(true);
                this.hide();
                threadValidation.v.destroy();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ThreadsnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ThreadsnoFocusLost
        if (Threadsno.getText().length() > 0) {
            error = ThreadsValidation();
            if (!error) {
                Threadsno.setText("");
                Threadsno.grabFocus();
            }
        }
    }//GEN-LAST:event_ThreadsnoFocusLost

    private void DepthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DepthFocusLost
        if (Depth.getText().length() > 0) {
            error = DepthValidation();
            if (!error) {
                Depth.setText("");
                Depth.grabFocus();
            }
        }
    }//GEN-LAST:event_DepthFocusLost

    private void DepthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DepthKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButton1.doClick();
        }
    }//GEN-LAST:event_DepthKeyPressed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Depth;
    private javax.swing.JTextField Threadsno;
    private javax.swing.JTextField URL;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
