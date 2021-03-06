
import controller.CheckoutFlowManager;
import javax.swing.JOptionPane;
import model.Bank;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author cgonz
 */
public class CardPayment2 extends javax.swing.JFrame {

    public CheckoutFlowManager checkoutFlowManager;
    /**
     * Creates new form CardPayment2
     */
    public CardPayment2(CheckoutFlowManager checkoutFlowManager) {
        initComponents();
        this.checkoutFlowManager = checkoutFlowManager;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        InsertCard = new javax.swing.JButton();
        PrintReceiptButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CardNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Credit Card Payment");

        InsertCard.setText("Insert Card");
        InsertCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertCardActionPerformed(evt);
            }
        });

        PrintReceiptButton.setText("Print Receipt");
        PrintReceiptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintReceiptButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Card Number:");

        CardNumber.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(InsertCard, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(PrintReceiptButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CardNumber))
                .addGap(33, 33, 33)
                .addComponent(InsertCard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintReceiptButton)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrintReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintReceiptButtonActionPerformed
        // TODO add your handling code here:
        Receipt3 jfrm = new Receipt3(this.checkoutFlowManager, "CREDIT");
        jfrm.setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_PrintReceiptButtonActionPerformed

    private void InsertCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertCardActionPerformed
        // TODO add your handling code here:
           Bank bank = new Bank();
        Long cardNo = bank.getCardDBHelper().getRandomCreditCardNumber();

        CardNumber.setText(Long.toString(cardNo));
        double amountDue = this.checkoutFlowManager.getOrder().netTotal;
        double amountPaid = amountDue;
        this.checkoutFlowManager.processCreditCardPayment(cardNo, amountDue, amountPaid);
        if (cardNo == 0L) {
             JOptionPane.showMessageDialog(null, "Something went wrong, order canceled");
            GUI jfrm = new GUI();
            jfrm.setVisible(true);
            
            this.setVisible(false);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            this.dispose();
            
            return;
        }

    }//GEN-LAST:event_InsertCardActionPerformed

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
            java.util.logging.Logger.getLogger(CardPayment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardPayment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardPayment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardPayment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardPayment2(new CheckoutFlowManager()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CardNumber;
    private javax.swing.JButton InsertCard;
    private javax.swing.JButton PrintReceiptButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
