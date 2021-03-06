/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import clasificadores.CMeans;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author yohovani
 */
public class JFrameClusterImage extends javax.swing.JFrame {

	/**
	 * Creates new form JFrameClusterImage
	 */
	public JFrameClusterImage() {
		initComponents();
                this.setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtCentroides = new javax.swing.JTextField();
        jLabeImagenOriginal = new javax.swing.JLabel();
        jLabelImagenClusterizada = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Abrir Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        txtCentroides.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCentroidesActionPerformed(evt);
            }
        });
        getContentPane().add(txtCentroides, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 100, 30));
        getContentPane().add(jLabeImagenOriginal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 460, 490));
        getContentPane().add(jLabelImagenClusterizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 500, 490));

        jButton2.setText("Aplicar C-Mens");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jLabel3.setText("Numero de clusters:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		i = new IOImage();
		imagenO = i.abrirImagen();
		this.jLabeImagenOriginal.setIcon(null);
		this.jLabeImagenOriginal.setIcon(new ImageIcon(i.getScaledImage(imagenO, 500, 500)));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
		this.jLabelImagenClusterizada.setIcon(null);
		CMeans c = new CMeans(IOImage.instancias,Integer.parseInt(this.txtCentroides.getText()));
        c.clasifica();
		Image clusterImage = Adapter.constriurNuevaImagen(c.getInstancias(), i.getBfi());
		
		this.jLabelImagenClusterizada.setIcon(new ImageIcon(i.getScaledImage(clusterImage, 500, 500)));
		
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCentroidesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCentroidesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCentroidesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

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
			java.util.logging.Logger.getLogger(JFrameClusterImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JFrameClusterImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JFrameClusterImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JFrameClusterImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JFrameClusterImage().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabeImagenOriginal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelImagenClusterizada;
    private javax.swing.JTextField txtCentroides;
    // End of variables declaration//GEN-END:variables
	private IOImage i;
	private Image imagenO;
}
