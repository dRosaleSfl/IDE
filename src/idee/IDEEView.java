/*
 * IDEEView.java
 */

package idee;

import idee.token;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.*;

/**
 * The application's main frame.
 */
public class IDEEView extends FrameView {
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    gestion gestion = new gestion();
    NumeroLinea linea;
    DefaultStyledDocument document;

    public IDEEView(SingleFrameApplication app) {
        super(app);

        initComponents();
       // buscarpalabras();
        linea = new NumeroLinea(jTextPane1);
        jScrollPane8.setRowHeaderView(linea);

         linea.setCurrentLineForeground(Color.red);

         

          document = new DefaultStyledDocument();
          jTextPane1.setDocument(document);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                   jMenuItem5ActionPerformed(evt);
                }
                catch(Exception e){
                    System.out.println("");
                }
            }
        });

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
               
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
       
       

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                      
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                   
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                  
                  
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                   
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                }
            }
        });

       /* String text = jTextArea5.getText();
        for( int i = 0; i< text.length(); i++){
            if()
        }*/
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = IDEEApp.getApplication().getMainFrame();
            aboutBox = new IDEEAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        IDEEApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToolBar2 = new javax.swing.JToolBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jToolBar3 = new javax.swing.JToolBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jToolBar4 = new javax.swing.JToolBar();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jToolBar5 = new javax.swing.JToolBar();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jToolBar6 = new javax.swing.JToolBar();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(idee.IDEEApp.class).getContext().getResourceMap(IDEEView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setPreferredSize(new java.awt.Dimension(173, 98));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jToolBar1.add(jScrollPane1);

        jTabbedPane1.addTab(resourceMap.getString("jToolBar1.TabConstraints.tabTitle"), jToolBar1); // NOI18N

        jToolBar2.setRollover(true);
        jToolBar2.setName("jToolBar2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setName("jTextArea2"); // NOI18N
        jScrollPane2.setViewportView(jTextArea2);

        jToolBar2.add(jScrollPane2);

        jTabbedPane1.addTab(resourceMap.getString("jToolBar2.TabConstraints.tabTitle"), jToolBar2); // NOI18N

        jToolBar3.setRollover(true);
        jToolBar3.setName("jToolBar3"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setName("jTextArea3"); // NOI18N
        jScrollPane3.setViewportView(jTextArea3);

        jToolBar3.add(jScrollPane3);

        jTabbedPane1.addTab(resourceMap.getString("jToolBar3.TabConstraints.tabTitle"), jToolBar3); // NOI18N

        jToolBar4.setRollover(true);
        jToolBar4.setName("jToolBar4"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setName("jTextArea4"); // NOI18N
        jScrollPane4.setViewportView(jTextArea4);

        jToolBar4.add(jScrollPane4);

        jTabbedPane1.addTab(resourceMap.getString("jToolBar4.TabConstraints.tabTitle"), jToolBar4); // NOI18N

        jTabbedPane2.setName("jTabbedPane2"); // NOI18N

        jToolBar5.setRollover(true);
        jToolBar5.setName("jToolBar5"); // NOI18N

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jTextArea6.setName("jTextArea6"); // NOI18N
        jScrollPane6.setViewportView(jTextArea6);

        jToolBar5.add(jScrollPane6);

        jTabbedPane2.addTab(resourceMap.getString("jToolBar5.TabConstraints.tabTitle"), jToolBar5); // NOI18N

        jToolBar6.setRollover(true);
        jToolBar6.setName("jToolBar6"); // NOI18N

        jScrollPane7.setName("jScrollPane7"); // NOI18N

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jTextArea7.setName("jTextArea7"); // NOI18N
        jScrollPane7.setViewportView(jTextArea7);

        jToolBar6.add(jScrollPane7);

        jTabbedPane2.addTab(resourceMap.getString("jToolBar6.TabConstraints.tabTitle"), jToolBar6); // NOI18N

        jScrollPane8.setName("jScrollPane8"); // NOI18N

        jTextPane1.setName("jTextPane1"); // NOI18N
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPane1KeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(jTextPane1);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1233, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setActionCommand(resourceMap.getString("jMenuItem1.actionCommand")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        fileMenu.add(jMenuItem3);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(idee.IDEEApp.class).getContext().getActionMap(IDEEView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu4.setText(resourceMap.getString("jMenu4.text")); // NOI18N
        jMenu4.setName("jMenu4"); // NOI18N

        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenu4.add(jMenuItem5);

        menuBar.add(jMenu4);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N
        menuBar.add(jMenu1);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        menuBar.add(jMenu2);

        jMenu3.setText(resourceMap.getString("jMenu3.text")); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N
        menuBar.add(jMenu3);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
    
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
      
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
            // TODO add your handling code here:
        if(seleccionado.showDialog(null,"abrir archivo")==JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String contenido = gestion.abrirtexto(archivo);
                   jTextPane1.setText(contenido);
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        if(seleccionado.showDialog(null,"Guardar archivo")==JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String contenido =jTextPane1.getText();
                String respuesta= gestion.guardartexto(archivo, contenido);
                if(respuesta!=null){
                    JOptionPane.showMessageDialog(null,respuesta);
                }else{
                     JOptionPane.showMessageDialog(null,("error al guardar"));
                }
            }else{
                 JOptionPane.showMessageDialog(null," no es .txt");
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        jTextPane1.copy();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
   


    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

        // TODO add your handling code here:
        String nombre= archivo.getName();
        File borrar;
        try{
            borrar = new File("C:\\Users\\ASUS\\Desktop\\MyStuff\\SchoolShit\\8vo\\Compiladores\\proyeto\\3raentrega\\java\\talvez\\IDEE\\rls.txt");
            borrar.delete();
            wait(1000);
        } catch(Exception e){}

        try {
            new ProcessBuilder("C:\\Users\\ASUS\\Desktop\\MyStuff\\SchoolShit\\8vo\\Compiladores\\proyeto\\3raentrega\\java\\talvez\\IDEE\\lexico.exe", nombre).start();
            wait(1000);
        }
        catch(Exception e) {

        }

        FileInputStream entrada, entrada2;
            String lexico = "rsl.txt";
            String contenido="";
            try{
            entrada =new FileInputStream(lexico);
                int i;
             while((i=entrada.read())!=-1){
              char caracter = (char)i;
               contenido+=caracter;
           }
           }catch(Exception e){}
            jTextArea1.setText(contenido);
            try {
            new ProcessBuilder("C:\\Users\\ASUS\\Desktop\\MyStuff\\SchoolShit\\8vo\\Compiladores\\proyeto\\3raentrega\\java\\talvez\\IDEE\\parser.exe").start();
            wait(1000);
        }
        catch(Exception e) {

        }
        String lexico2 = "parsed.txt";
        String contenido2="";
        boolean chk = false;
        try{
            entrada2 =new FileInputStream(lexico2);
            int i;
            int e = 0;
            char err = 'E';
            while((i=entrada2.read())!=-1){
              char caracter = (char)i;
              if(e == 0 && Character.valueOf(caracter).compareTo(err) == 0) {
                  System.out.print("Error detectado");
                  chk = true;
              }
              contenido2 += caracter;
              e++;
            }
           }catch(Exception e){}
           if (!chk) {
               jTextArea2.setText(contenido2);
               jTextArea6.setText("");
           }
            else {
                jTextArea1.setText("");
                jTextArea2.setText("");
                jTextArea6.setText(contenido2);
                jTextArea6.setForeground(Color.red);
            }
           

    }//GEN-LAST:event_jMenu2MouseClicked

    private void jTextPane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyReleased
         try {
             Lexer lexico = new Lexer(new BufferedReader (new StringReader(jTextPane1.getText())));
              String resultado ="";
            while (true) {
                token token = lexico.yylex();
                if (token == null) {
                      jTextArea1.setText(resultado);
                    return;
                }
                switch (token) {
                    case ERROR:
  //                      resultado +="Es una Palabra= "+token+": "+lexico.lexeme+"-"+lexico.pos+"-"+lexico.lng+"\n";
                        pintarTxt(Color.RED, lexico.pos, lexico.lng);
                        break;
                    case Identificador:
    //                     resultado +="Es una Palabra= "+token+": "+lexico.lexeme+"-"+lexico.pos+"-"+lexico.lng+"\n";
                        pintarTxt(new Color(196, 140, 213  ), lexico.pos, lexico.lng);
                        break;
                    case Main:case If: case Then: case Else: case Int: case Real: case Float: case Print: case End:
                    case Repeat: case Until: case Do: case While: case Cin: case Cout: case Boolean:
                        pintarTxt(Color.BLUE, lexico.pos, lexico.lng);
      //                   resultado +="Es una Palabra= "+token+": "+lexico.lexeme+"-"+lexico.pos+"-"+lexico.lng+"\n";
                        break;
                    case Comentarios:
                        pintarTxt(Color.darkGray,lexico.pos,lexico.lng);
        //               resultado +="Es una Palabra= "+token+": "+lexico.lexeme+"-"+lexico.pos+"-"+lexico.lng+"\n";
                    case Relacional:
                        pintarTxt(Color.red,lexico.pos,lexico.lng);
           //             resultado +="Es una Palabra= "+token+": "+lexico.lexeme+"-"+lexico.pos+"-"+lexico.lng+"\n";
                        break;
                    case Entero: case Especial: case Flotante:
                        pintarTxt(Color.orange,lexico.pos,lexico.lng);
             //            resultado +="Es una Palabra= "+token+": "+lexico.lexeme+"-"+lexico.pos+"-"+lexico.lng+"\n";
                        break;
                    default:break;
                }
            }
                } catch (IOException ex) {
                    Logger.getLogger(IDEEView.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jTextPane1KeyReleased
 private void pintarTxt(Color color,int pos,int lng){
      StyleContext context = new StyleContext();

        //Style style = context.addStyle("test", null);
        javax.swing.text.Style style = context.addStyle("test", null);
        StyleConstants.setForeground(style, color);
        document.setCharacterAttributes(pos, lng, style, true);

    }
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
        jTextPane1.paste();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    private void buscarpalabras() {
       String texto = jTextPane1.getText();
         String arreglo[] = texto.split(" ");
        // Highlighter h = jTextArea5.getHighlighter();
        for (int j=0;j<texto.length();j++){
            if(arreglo[j].equals("int")){
                //entero
                /*try{
                    h.addHighlight(j, j+1, DefaultHighlighter.DefaultPainter);
                }catch(java.lang.Exception e){}*/
               jTextPane1.setForeground(Color.red);

            }else if(arreglo[j].equals("program")){
                //program
                 jTextPane1.setBackground(Color.BLUE);
            }else if(arreglo[j].equals("else")){
                //else
                 jTextPane1.setForeground(Color.YELLOW);
            }else if(arreglo[j].equals("fi")){
                //fi
            }else if(arreglo[j].equals("do")){
                //do
                 jTextPane1.setBackground(Color.orange);
            }else if(arreglo[j].equals("until")){
                //until
            }else if(arreglo[j].equals("while")){
                //while
            }else if(arreglo[j].equals("read")){
                //read
            }else if(arreglo[j].equals("write")){
                //write
            }else if(arreglo[j].equals("float")){
                //float
            }else if(arreglo[j].equals("bool")){
               //bool
            }else if(arreglo[j].equals("not")){
                //not
            }else if(arreglo[j].equals("and")){
                //and
            }else if(arreglo[j].equals("or")){
                //or
            }

        }
    }
}
