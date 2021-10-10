/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emptystack;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author DigitalMonster
 */
public class IDE extends javax.swing.JFrame {

    NumeroLinea numerolinea;
    Directorio dir;

    /**
     * Creates new form IDE
     */
    public IDE() {
        initComponents();
        inizializar();
        colors();
    }

    //METODO PARA ENCONTRAR LAS ULTIMAS CADENAS
    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            //  \\W = [A-Za-Z0-9]
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    //METODO PARA ENCONTRAR LAS PRIMERAS CADENAS 
    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }

    //METODO PARA PINTAS LAS PALABRAS RESEVADAS
    private void colors() {

        final StyleContext cont = StyleContext.getDefaultStyleContext();

        //COLORES 
        final AttributeSet attred = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(255, 0, 35));
        final AttributeSet attgreen = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 255, 54));
        final AttributeSet attblue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 147, 255));
        final AttributeSet attblack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 0, 0));

        //STYLO 
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(SI|HAZ|ENTONCES|LOOP|A)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attblue, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(INT|DEC|CAD)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attgreen, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(RET|ETD|SLD)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attred, false);
                        } else {
                            setCharacterAttributes(wordL, wordR - wordL, attblack, false);
                        }
                        wordL = wordR;

                    }
                    wordR++;
                }
            }

            public void romeve(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) {
                    before = 0;
                }
            }
        };

        JTextPane txt = new JTextPane(doc);
        String temp = jtpCode.getText();
        jtpCode.setStyledDocument(txt.getStyledDocument());
        jtpCode.setText(temp);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnReserved = new javax.swing.JButton();
        btnTokens = new javax.swing.JButton();
        btnCompile = new javax.swing.JButton();
        btnIdentifiers = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaCompile = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/Icon/icons8_save_48px.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar documento ");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/pressed/icons8_save_48px_p.png"))); // NOI18N
        btnGuardar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8_save_48px_on.png"))); // NOI18N
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 80, 110));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/Icon/icons8_code_file_48px.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/pressed/icons8_code_file_48px_p.png"))); // NOI18N
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8_code_file_48px_on.png"))); // NOI18N
        btnNuevo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8_code_file_48px_on.png"))); // NOI18N
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 110));

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/Icon/icons8_opened_folder_48px.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setToolTipText("Abrir documento existente");
        btnAbrir.setBorderPainted(false);
        btnAbrir.setContentAreaFilled(false);
        btnAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrir.setFocusPainted(false);
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/pressed/icons8_opened_folder_48px_P.png"))); // NOI18N
        btnAbrir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8_opened_folder_48px_ON.png"))); // NOI18N
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, 110));

        btnReserved.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/Icon/icons8-text-color-48.png"))); // NOI18N
        btnReserved.setText("Reservadas");
        btnReserved.setBorderPainted(false);
        btnReserved.setContentAreaFilled(false);
        btnReserved.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReserved.setFocusPainted(false);
        btnReserved.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReserved.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/pressed/icons8-text-color-48.png"))); // NOI18N
        btnReserved.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8-text-color-48.png"))); // NOI18N
        btnReserved.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8-text-color-48.png"))); // NOI18N
        btnReserved.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReserved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservedActionPerformed(evt);
            }
        });
        getContentPane().add(btnReserved, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, 110));

        btnTokens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/Icon/icons8-index-48.png"))); // NOI18N
        btnTokens.setText("Tokens");
        btnTokens.setBorderPainted(false);
        btnTokens.setContentAreaFilled(false);
        btnTokens.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTokens.setFocusPainted(false);
        btnTokens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTokens.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/pressed/icons8-index-48.png"))); // NOI18N
        btnTokens.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8-index-48.png"))); // NOI18N
        btnTokens.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8-index-48.png"))); // NOI18N
        btnTokens.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnTokens, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 110));

        btnCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/Icon/icons8_code_48px.png"))); // NOI18N
        btnCompile.setText("Compilar");
        btnCompile.setBorderPainted(false);
        btnCompile.setContentAreaFilled(false);
        btnCompile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompile.setFocusPainted(false);
        btnCompile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompile.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/pressed/icons8_code_48px_p.png"))); // NOI18N
        btnCompile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8_code_48px_on.png"))); // NOI18N
        btnCompile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnCompile, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, 110));

        btnIdentifiers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/Icon/icons8-text-cursor-48.png"))); // NOI18N
        btnIdentifiers.setText("Ident");
        btnIdentifiers.setBorderPainted(false);
        btnIdentifiers.setContentAreaFilled(false);
        btnIdentifiers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIdentifiers.setFocusPainted(false);
        btnIdentifiers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIdentifiers.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/pressed/icons8-text-cursor-48.png"))); // NOI18N
        btnIdentifiers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/emptystack/iconos/On Layer/icons8-text-cursor-48.png"))); // NOI18N
        btnIdentifiers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIdentifiers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdentifiersActionPerformed(evt);
            }
        });
        getContentPane().add(btnIdentifiers, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 110));

        jtpCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtpCodeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtpCode);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1310, 420));

        jtaCompile.setColumns(20);
        jtaCompile.setRows(5);
        jScrollPane2.setViewportView(jtaCompile);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 1310, 120));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jtaCompile.setText("");
        dir.Nuevo(this);
        clearAllComp();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        dir.Guardar(this);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        dir.Abrir(this);
        clearAllComp();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnReservedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservedActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservedActionPerformed

    private void btnIdentifiersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdentifiersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIdentifiersActionPerformed

    private void jtpCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpCodeKeyReleased
        int keyCode = evt.getKeyCode();
        if ((keyCode >= 65 && keyCode <= 90) || (keyCode >= 48 && keyCode <= 57)
                || (keyCode >= 97 && keyCode <= 122) || (keyCode != 27 && !(keyCode >= 37
                && keyCode <= 40) && !(keyCode >= 16
                && keyCode <= 18) && keyCode != 524
                && keyCode != 20)) {

            if (!getTitle().contains("*")) {
                setTitle(getTitle() + "*");
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jtpCodeKeyReleased

    private void inizializar() {

        dir = new Directorio();

        //Importante 
        setTitle("[#EmptyStack]");
        String[] options = new String[]{"Guardar y continuar", "Descargar"};

        //Numero de linea
        numerolinea = new NumeroLinea(jtpCode);
        jScrollPane1.setRowHeaderView(numerolinea);

    }

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
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IDE().setVisible(true);
            }
        });
    }

    public void clearAllComp() {
        jtaCompile.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompile;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIdentifiers;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReserved;
    private javax.swing.JButton btnTokens;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea jtaCompile;
    public javax.swing.JTextPane jtpCode;
    // End of variables declaration//GEN-END:variables
}
