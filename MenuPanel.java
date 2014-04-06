import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iancook
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    public MenuPanel() {
        initComponents();
    }

    static public void updateMenuPanel()
    {
        AttemptsP1.setText(""+ SetOfCards.numberOfTries[1]);
        SuccessP1.setText(""+ SetOfCards.numberOfSuccess[1]);
        FailuresP1.setText(""+ SetOfCards.numberOfFailures[1]);
        
        if(SetOfCards.twoPlayers==true)
        {
        AttemptsP2Label.setText("Number of attempts:");
        SuccessP2Label.setText("Number of success:");
        FailuresP2Label.setText("Number of failures:");
        Player1.setText("Player 1");
        Player2.setText("Player 2");
        if(SetOfCards.player==1)
        {
            ActiveP1.setText("Active");
            ActiveP2.setText("");
        }
        else {
            ActiveP1.setText("");
            ActiveP2.setText("Active");
        }
        AttemptsP2.setText(""+ SetOfCards.numberOfTries[2]);
        SuccessP2.setText(""+ SetOfCards.numberOfSuccess[2]);
        FailuresP2.setText(""+ SetOfCards.numberOfFailures[2]);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Player1 = new javax.swing.JLabel();
        Player2 = new javax.swing.JLabel();
        AttemptsP1Label = new javax.swing.JLabel();
        SuccessP1Label = new javax.swing.JLabel();
        FailuresP1Label = new javax.swing.JLabel();
        AttemptsP2Label = new javax.swing.JLabel();
        SuccessP2Label = new javax.swing.JLabel();
        FailuresP2Label = new javax.swing.JLabel();
        AttemptsP1 = new javax.swing.JLabel();
        SuccessP1 = new javax.swing.JLabel();
        FailuresP1 = new javax.swing.JLabel();
        AttemptsP2 = new javax.swing.JLabel();
        SuccessP2 = new javax.swing.JLabel();
        FailuresP2 = new javax.swing.JLabel();
        Help = new javax.swing.JButton();
        Menu = new javax.swing.JButton();
        ActiveP1 = new javax.swing.JLabel();
        ActiveP2 = new javax.swing.JLabel();

        Player1.setText("jLabel1");

        Player2.setText("jLabel2");

        AttemptsP1Label.setText("Number of attempts:");

        SuccessP1Label.setText("Number of success:");

        FailuresP1Label.setText("Number of failures");

        AttemptsP2Label.setText("jLabel3");

        SuccessP2Label.setText("jLabel4");

        FailuresP2Label.setText("jLabel5");

        AttemptsP1.setText("jLabel3");

        SuccessP1.setText("jLabel4");

        FailuresP1.setText("jLabel5");

        AttemptsP2.setText("jLabel3");

        SuccessP2.setText("jLabel4");

        FailuresP2.setText("jLabel5");

        Help.setText("jButton1");

        Menu.setText("jButton1");

        ActiveP1.setText("jLabel1");

        ActiveP2.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Player2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ActiveP2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Player1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ActiveP1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SuccessP1Label)
                            .addComponent(AttemptsP1Label)
                            .addComponent(FailuresP1Label)
                            .addComponent(Menu)
                            .addComponent(SuccessP2Label)
                            .addComponent(AttemptsP2Label)
                            .addComponent(FailuresP2Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SuccessP1)
                            .addComponent(AttemptsP1)
                            .addComponent(FailuresP1)
                            .addComponent(SuccessP2)
                            .addComponent(AttemptsP2)
                            .addComponent(FailuresP2)
                            .addComponent(Help))))
                .addGap(38, 38, 38))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AttemptsP1Label, AttemptsP2Label, FailuresP2Label, SuccessP2Label});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player1)
                    .addComponent(ActiveP1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AttemptsP1Label)
                        .addGap(18, 18, 18)
                        .addComponent(SuccessP1Label)
                        .addGap(18, 18, 18)
                        .addComponent(FailuresP1Label))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AttemptsP1)
                        .addGap(18, 18, 18)
                        .addComponent(SuccessP1)
                        .addGap(18, 18, 18)
                        .addComponent(FailuresP1)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Player2)
                            .addComponent(ActiveP2))
                        .addGap(18, 18, 18)
                        .addComponent(AttemptsP2Label)
                        .addGap(18, 18, 18)
                        .addComponent(SuccessP2Label)
                        .addGap(18, 18, 18)
                        .addComponent(FailuresP2Label))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AttemptsP2)
                        .addGap(18, 18, 18)
                        .addComponent(SuccessP2)
                        .addGap(18, 18, 18)
                        .addComponent(FailuresP2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Help)
                    .addComponent(Menu))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>                        

    static private javax.swing.JLabel ActiveP1;
    static private javax.swing.JLabel ActiveP2;
    static private javax.swing.JLabel AttemptsP1;
    static private javax.swing.JLabel AttemptsP1Label;
    static private javax.swing.JLabel AttemptsP2;
    static private javax.swing.JLabel AttemptsP2Label;
    static private javax.swing.JLabel FailuresP1;
    static private javax.swing.JLabel FailuresP1Label;
    static private javax.swing.JLabel FailuresP2;
    static private javax.swing.JLabel FailuresP2Label;
    static private javax.swing.JButton Help;
    static private javax.swing.JButton Menu;
    static private javax.swing.JLabel Player1;
    static private javax.swing.JLabel Player2;
    static private javax.swing.JLabel SuccessP1;
    static private javax.swing.JLabel SuccessP1Label;
    static private javax.swing.JLabel SuccessP2;
    static private javax.swing.JLabel SuccessP2Label;
/*   
    // Variables declaration - do not modify                     
    private javax.swing.JLabel ActiveP1;
    private javax.swing.JLabel ActiveP2;
    private javax.swing.JLabel AttemptsP1;
    private javax.swing.JLabel AttemptsP1Label;
    private javax.swing.JLabel AttemptsP2;
    private javax.swing.JLabel AttemptsP2Label;
    private javax.swing.JLabel FailuresP1;
    private javax.swing.JLabel FailuresP1Label;
    private javax.swing.JLabel FailuresP2;
    private javax.swing.JLabel FailuresP2Label;
    private javax.swing.JButton Help;
    private javax.swing.JButton Menu;
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JLabel SuccessP1;
    private javax.swing.JLabel SuccessP1Label;
    private javax.swing.JLabel SuccessP2;
    private javax.swing.JLabel SuccessP2Label;
    // End of variables declaration                   
*/
    }
