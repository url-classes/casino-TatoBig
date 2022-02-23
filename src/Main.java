
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Tato
 */
public class Main extends javax.swing.JFrame {

    String[] imageList = new String[]{
        "/img/img1.png",
        "/img/img2.png",
        "/img/img3.png",
        "/img/img4.png",
        "/img/img5.png",
        "/img/img6.png",
        "/img/img7.png",
        "/img/img8.png",
        "/img/img9.png",
        "/img/img10.png",
        "/img/img11.png",
        "/img/img12.png",
        "/img/img13.png",
        "/img/img14.png",
        "/img/img15.png"
    };

    public Integer randomizer() {
        return rand.nextInt(15);
    }

    public class Slot extends Thread {

        private Boolean active;
        private Integer number;
        private Integer label;
        private Integer slot;
        private Integer random;

        public Slot() {
            this.active = false;
            this.number = 0;
        }

        public Slot(Integer slot) {
            this.active = false;
            this.number = 0;
            this.slot = slot;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getRandom() {
            return random;
        }

        public void setRandom(Integer random) {
            this.random = random;
        }

        @Override
        public void run() {
            Image img;
            img = new ImageIcon(this.getClass().getResource(imageList[11])).getImage();
            img = img.getScaledInstance(240, 240, java.awt.Image.SCALE_SMOOTH);
            imageTest1.setIcon(new ImageIcon(img));
            imageTest2.setIcon(new ImageIcon(img));
            imageTest3.setIcon(new ImageIcon(img));

            while (this.slot == 1) {
                // DUDA: Porque solo cuando esta el print parece funcionar el ciclo?

                System.out.println("Slot 1");
                while (this.active) {
                    this.random = randomizer();
                    try {
                        sleep(100);
                        img = new ImageIcon(this.getClass().getResource(imageList[this.random])).getImage();
                        img = img.getScaledInstance(240, 240, java.awt.Image.SCALE_SMOOTH);
                        imageTest1.setIcon(new ImageIcon(img));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            while (this.slot == 2) {
                System.out.println("Slot 2");
                while (this.active) {
                    this.random = randomizer();
                    try {
                        sleep(100);
                        img = new ImageIcon(this.getClass().getResource(imageList[this.random])).getImage();
                        img = img.getScaledInstance(240, 240, java.awt.Image.SCALE_SMOOTH);
                        imageTest2.setIcon(new ImageIcon(img));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            while (this.slot == 3) {
                System.out.println("Slot 3");
                while (this.active) {
                    this.random = randomizer();
                    try {
                        sleep(100);
                        img = new ImageIcon(this.getClass().getResource(imageList[this.random])).getImage();
                        img = img.getScaledInstance(240, 240, java.awt.Image.SCALE_SMOOTH);
                        imageTest3.setIcon(new ImageIcon(img));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    Slot slot1 = new Slot(1);
    Slot slot2 = new Slot(2);
    Slot slot3 = new Slot(3);

    public Main() {
        Image img;
        img = new ImageIcon(this.getClass().getResource("/img/layout.png")).getImage();
        img = img.getScaledInstance(1120, 1000, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(img);
        setContentPane(new JLabel(imageIcon));
        slot1.start();
        slot2.start();
        slot3.start();
        System.out.println("Inicializando los hilos");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        stop2 = new javax.swing.JButton();
        stop3 = new javax.swing.JButton();
        stop1 = new javax.swing.JButton();
        imageTest1 = new javax.swing.JLabel();
        imageTest2 = new javax.swing.JLabel();
        imageTest3 = new javax.swing.JLabel();
        stopAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Casino de Konter");

        startButton.setText("Iniciar");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stop2.setText("Detener casilla 2");
        stop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop2ActionPerformed(evt);
            }
        });

        stop3.setText("Detener casilla 3");
        stop3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop3ActionPerformed(evt);
            }
        });

        stop1.setText("Detener casilla 1");
        stop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop1ActionPerformed(evt);
            }
        });

        imageTest1.setText(".");
        imageTest1.setAutoscrolls(true);

        imageTest2.setText(".");

        imageTest3.setText(".");

        stopAll.setText("Detener Todos");
        stopAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(471, 471, 471)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(imageTest1)
                                .addGap(18, 18, 18)
                                .addComponent(imageTest2)
                                .addGap(18, 18, 18)
                                .addComponent(imageTest3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(stop1)
                        .addGap(335, 335, 335)
                        .addComponent(stop2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                        .addComponent(stop3)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(stopAll)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(startButton)
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageTest1)
                    .addComponent(imageTest2)
                    .addComponent(imageTest3))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stop1)
                    .addComponent(stop2)
                    .addComponent(stop3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(startButton)
                .addGap(18, 18, 18)
                .addComponent(stopAll)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Random rand = new Random();

    public void verifyWin () {
        if (slot1.getRandom() == slot2.getRandom() && slot2.getRandom() == slot3.getRandom()) {
            JOptionPane.showMessageDialog(null, "Ganaste!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Perdiste!");
        }
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        System.out.println(slot1.getActive());
        slot1.setActive(true);
        slot2.setActive(true);
        slot3.setActive(true);
    }//GEN-LAST:event_startButtonActionPerformed

    private void stop2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop2ActionPerformed
        slot2.setActive(false);
        if (!slot1.getActive() && !slot3.getActive()) {
            verifyWin();
        }
    }//GEN-LAST:event_stop2ActionPerformed

    private void stop3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop3ActionPerformed
        slot3.setActive(false);
        if (!slot1.getActive() && !slot2.getActive()) {
            verifyWin();
        }
    }//GEN-LAST:event_stop3ActionPerformed

    private void stop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop1ActionPerformed
        slot1.setActive(false);
        if (!slot2.getActive() && !slot3.getActive()) {
            verifyWin();
        }
    }//GEN-LAST:event_stop1ActionPerformed

    private void stopAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopAllActionPerformed
        slot1.setActive(false);
        slot2.setActive(false);
        slot3.setActive(false);
        verifyWin();
    }//GEN-LAST:event_stopAllActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageTest1;
    private javax.swing.JLabel imageTest2;
    private javax.swing.JLabel imageTest3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stop1;
    private javax.swing.JButton stop2;
    private javax.swing.JButton stop3;
    private javax.swing.JButton stopAll;
    // End of variables declaration//GEN-END:variables
}
