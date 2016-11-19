package proj.view;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import proj.model.Imagem;
import proj.control.MostrarImagem;

public class gui extends javax.swing.JFrame {
    
    private File arqImagem = null;
    private File arqJson = null;
    
    private Imagem imagem;
    private Imagem jsonImagem;
    
    public gui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_json = new javax.swing.JButton();
        btn_abrirImagem = new javax.swing.JButton();
        btn_carregarJSON = new javax.swing.JToggleButton();
        txtArquivo = new javax.swing.JTextField();
        txtJson = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_json.setText("Converter JSON");
        btn_json.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jsonActionPerformed(evt);
            }
        });

        btn_abrirImagem.setText("Carregar Imagem");
        btn_abrirImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirImagemActionPerformed(evt);
            }
        });

        btn_carregarJSON.setText("Carregar JSON");
        btn_carregarJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carregarJSONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtJson)
                        .addContainerGap())
                    .addComponent(txtArquivo, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_abrirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_json)
                    .addComponent(btn_carregarJSON, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_abrirImagem)
                .addGap(1, 1, 1)
                .addComponent(txtArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_json)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_carregarJSON)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_carregarJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carregarJSONActionPerformed
        
        JFileChooser abrir = new JFileChooser();
        abrir.setFileFilter(new FileNameExtensionFilter("Arquivos JSON", "json"));
        int retorno = abrir.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String caminho = abrir.getSelectedFile().getAbsolutePath();
            txtJson.setText(caminho);
            arqJson = abrir.getSelectedFile();
        }
        
    }//GEN-LAST:event_btn_carregarJSONActionPerformed

    private void btn_abrirImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirImagemActionPerformed
        JFileChooser abrir = new JFileChooser();
        abrir.setFileFilter(new FileNameExtensionFilter("Arquivos de Imagens", ImageIO.getReaderFileSuffixes()));
        int retorno = abrir.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String caminho = abrir.getSelectedFile().getAbsolutePath();
            txtArquivo.setText(caminho);
            arqImagem = abrir.getSelectedFile();
        }       
    }//GEN-LAST:event_btn_abrirImagemActionPerformed

    private void btn_jsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jsonActionPerformed
        
    }//GEN-LAST:event_btn_jsonActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrirImagem;
    private javax.swing.JToggleButton btn_carregarJSON;
    private javax.swing.JButton btn_json;
    private javax.swing.JTextField txtArquivo;
    private javax.swing.JTextField txtJson;
    // End of variables declaration//GEN-END:variables
    
}
