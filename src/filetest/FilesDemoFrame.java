/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filetest;

/**
 *
 * @author Sljuka
 */
public class FilesDemoFrame extends javax.swing.JFrame {

    /**
     * Creates new form FilesDemoFrame
     */
    public FilesDemoFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        copyByteByByteBtn = new javax.swing.JButton();
        randomWordBtn = new javax.swing.JButton();
        copyCharByCharBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        createXmlBtn = new javax.swing.JButton();
        readXmlBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        openFilesFolder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        copyByteByByteBtn.setText("Copy text file byte by byte");
        copyByteByByteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyByteByByteBtnActionPerformed(evt);
            }
        });

        randomWordBtn.setText("Show random word from file");
        randomWordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomWordBtnActionPerformed(evt);
            }
        });

        copyCharByCharBtn.setText("Copy text file char by char");
        copyCharByCharBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyCharByCharBtnActionPerformed(evt);
            }
        });

        createXmlBtn.setText("Create XML file");
        createXmlBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createXmlBtnActionPerformed(evt);
            }
        });

        readXmlBtn.setText("Read from XML file");
        readXmlBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readXmlBtnActionPerformed(evt);
            }
        });

        openFilesFolder.setText("Open project folder");
        openFilesFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFilesFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openFilesFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(randomWordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(copyByteByByteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyCharByCharBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createXmlBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(readXmlBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copyByteByByteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(copyCharByCharBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(randomWordBtn)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createXmlBtn)
                    .addComponent(readXmlBtn))
                .addGap(13, 13, 13)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openFilesFolder)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void copyCharByCharBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyCharByCharBtnActionPerformed
        FilesDemo.copyTextFileCharByChar();
    }//GEN-LAST:event_copyCharByCharBtnActionPerformed

    private void copyByteByByteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyByteByByteBtnActionPerformed
        FilesDemo.copyTextFileByteByByte();
    }//GEN-LAST:event_copyByteByByteBtnActionPerformed

    private void randomWordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomWordBtnActionPerformed
        FilesDemo.readTextFileLineByLine();
    }//GEN-LAST:event_randomWordBtnActionPerformed

    private void createXmlBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createXmlBtnActionPerformed
        FilesDemo.createXmlFile();
    }//GEN-LAST:event_createXmlBtnActionPerformed

    private void readXmlBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readXmlBtnActionPerformed
        FilesDemo.readFromXmlFile();
    }//GEN-LAST:event_readXmlBtnActionPerformed

    private void openFilesFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFilesFolderActionPerformed
        FilesDemo.openProjectFolder();
    }//GEN-LAST:event_openFilesFolderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copyByteByByteBtn;
    private javax.swing.JButton copyCharByCharBtn;
    private javax.swing.JButton createXmlBtn;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton openFilesFolder;
    private javax.swing.JButton randomWordBtn;
    private javax.swing.JButton readXmlBtn;
    // End of variables declaration//GEN-END:variables
}
