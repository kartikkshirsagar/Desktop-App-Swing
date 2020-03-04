/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author kartik
 */
public class FeePayment {
    private JFrame frame;
    private JLabel amount,hidden;
    private JTextField money;
    private JButton btn;
    
    
    FeePayment(){
    frame = new JFrame("Donate to us");
    amount = new JLabel("How much would you like to donate?");
    hidden = new JLabel();
    money = new JTextField();
    btn = new JButton("Donate");
    money.setPreferredSize(new Dimension(100, 30));
    frame.setPreferredSize(new Dimension(500, 300));
    frame.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridx=0;c.gridy=0;c.anchor = GridBagConstraints.LINE_END;c.insets=new Insets(5, 5, 5, 5);
    frame.add(amount,c);
    c.gridx=1;c.gridy=0;c.anchor = GridBagConstraints.LINE_START;
    frame.add(money,c);
     c.gridx=0;c.gridy=1;c.anchor = GridBagConstraints.CENTER;c.gridwidth=2;
    frame.add(btn,c);
    c.gridx=0;c.gridy=2;c.anchor = GridBagConstraints.CENTER;c.gridwidth=2;
    frame.add(hidden,c);
    //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
   
    
    btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            hidden.setText("Thank you for donating Rs. "+money.getText());
        }
    });
    }
    
    public static void main(String[] args) {
        new FeePayment();
   
    }
    
}
