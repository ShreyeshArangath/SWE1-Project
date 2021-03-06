
import controller.CheckoutFlowManager;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import model.Customer;
import model.Order;
import model.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author cgonz
 */
public class Receipt2 extends javax.swing.JFrame {

    private Component frame;
    private CheckoutFlowManager checkoutFlowManager;

    /**
     * Creates new form Receipt2
     */
    public Receipt2(CheckoutFlowManager checkoutFlowManager) {
        initComponents();
        this.checkoutFlowManager = checkoutFlowManager;
                String items = "";
        Order order = this.checkoutFlowManager.getOrder();
        for (Product product : order.getItemsOrdered()) {
            String itemPrice = String.format("%.2f", product.getRetailPrice());
            items += product.getItemDescription() + "\t\t" + itemPrice + "\n";
        }
        Items.setText(items);
        String subtotal = String.format("%.2f", this.checkoutFlowManager.getOrder().getSubTotal());
        Subtotal.setText(subtotal);

        Double taxValue = this.checkoutFlowManager.getOrder().getSalesTaxPercentage() / 100
                * this.checkoutFlowManager.getOrder().getSubTotal();
        String tax = String.format("%.2f", taxValue);
        Tax.setText(tax);

        String total = String.format("%.2f", this.checkoutFlowManager.getOrder().netTotal);
        Total.setText(total);

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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Subtotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Tax = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        CloseTillButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Items = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Check Receipt");

        jLabel2.setText("Items:");

        jLabel4.setText("Subtotal:");

        Subtotal.setText("jLabel5");

        jLabel6.setText("Tax:");

        Tax.setText("jLabel7");

        jLabel8.setText("Total:");

        Total.setText("jLabel9");

        CloseTillButton.setText("Close Till");
        CloseTillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseTillButtonActionPerformed(evt);
            }
        });

        Items.setColumns(20);
        Items.setRows(5);
        jScrollPane2.setViewportView(Items);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(CloseTillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Tax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Subtotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Tax))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Total))
                .addGap(44, 44, 44)
                .addComponent(CloseTillButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseTillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseTillButtonActionPerformed

        // TODO: Add code to restock inventory here 
        List<Product> restockedItems = this.checkoutFlowManager.updateInventory();
        if (restockedItems.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("The following items need to be restocked. \n");

            for (Product product : restockedItems) {
                sb.append(product.getItemDescription()).append("\n");
            }

            JOptionPane.showMessageDialog(frame, sb.toString());
        }
        
         if (this.checkoutFlowManager.loyaltyPointsFlowManager.getCustomer()!=null){
            Customer customer = this.checkoutFlowManager.loyaltyPointsFlowManager.getCustomer();
            JOptionPane.showMessageDialog(frame, "Loyalty Points have been added to " + customer.getName() + "\'s account" );
        }

        int dialogButton = 0;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to return to Checkout?", "Thanks for Shopping!", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            GUI jfrm = new GUI();
            jfrm.setVisible(true);
            this.setVisible(false);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            this.dispose();
        } else if (dialogResult == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(frame, "Thanks for Shopping!");
            if (JOptionPane.OK_OPTION == 0) {
                this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
                this.dispose();
            }
        }

        // TODO: Add code to restock inventory here 
        this.checkoutFlowManager.updateInventory();

        this.setVisible(false);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_CloseTillButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Receipt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt2(new CheckoutFlowManager()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseTillButton;
    private javax.swing.JTextArea Items;
    private javax.swing.JLabel Subtotal;
    private javax.swing.JLabel Tax;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
