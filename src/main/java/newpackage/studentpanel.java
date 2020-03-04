
package newpackage;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */

public class studentpanel {
    private JFrame frame;
    private JLabel name,id,password,mobno,l1,l2,l3,l4;
    private String checkUser,checkPass;
    private String mobno1,id1,name1,pass1;
    boolean login1 = false;
    private JButton logout,feebtn;
    
    public studentpanel()
    {
        
    }
    public studentpanel(String user,String pass)
    {
                try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AWPusers_and_Login", "kartik", "Kartik1901");
                            Statement sta= (Statement) con.createStatement();
                          
                            String query= "SELECT * FROM Users WHERE Name=? AND pass=?";
                            PreparedStatement ps=con.prepareStatement(query);
                            //ps.setString(1,ID);
                            ps.setString(1, user);
                            ps.setString(2, pass);
                            ResultSet rs=ps.executeQuery();
                            if(rs.next())
                            {
                                checkUser = rs.getString(1);
                                checkPass = rs.getString(2);
                                mobno1=rs.getString("mobno");
                                id1=rs.getString("ID");
                                name1=user;
                                pass1=pass;
                                if((checkUser.equals(user)) && (checkPass.equals(pass))){
                                    System.out.println("Name: " + checkUser+ " Password: "+checkPass + " Mobile Number: "+mobno1+" ID "+id1);
                                    login1=true;
                                }       
                            

                            }

                            con.close();  
       
                            
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
        frame=new JFrame("Student");
        
        frame.setSize(500, 500);
        frame.setLocation(400, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridBagLayout());
        name=new JLabel(name1);
        id=new JLabel(id1);
        password=new JLabel(pass1);
        mobno=new JLabel(mobno1);
        l1=new JLabel("Name: ");
        l2=new JLabel("ID: ");
        l3=new JLabel("Mobile Number: ");
        l4=new JLabel("Password: ");
        logout=new JButton("LogOut");
        feebtn = new JButton("Pay your Fees");
        panel.setBackground(Color.white);
        GridBagConstraints c=new GridBagConstraints();
        c.insets=new Insets(15,15,0,15);
        c.gridx=0;
        c.gridy=0;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(l1,c);
        
        c.gridx=1;
        c.gridy=0;
        c.anchor=GridBagConstraints.LINE_START;
        panel.add(name,c);
        c.gridx=0;
        c.gridy=1;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(l2,c);
        
        c.gridx=1;
        c.gridy=1;
        c.anchor=GridBagConstraints.LINE_START;
        panel.add(id,c);
        c.gridx=0;
        c.gridy=2;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(l3,c);

        c.gridx=1;
        c.gridy=2;
        c.anchor=GridBagConstraints.LINE_START;
        panel.add(mobno,c);
        c.gridx=0;
        c.gridy=3;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(l4,c);

        c.gridx=1;
        c.gridy=3;
        c.anchor=GridBagConstraints.LINE_START;
        panel.add(password,c);
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=2;
        c.anchor=GridBagConstraints.LINE_END;
        panel.add(logout,c);
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=2;
        c.anchor=GridBagConstraints.LINE_START;
        panel.add(feebtn,c);
        
        frame.setVisible(true);
        
        feebtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //frame.dispose();
                        new FeePayment();
                    }
        });
        
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                new Login();
                frame.dispose();
            }
        });
    }
    public static void main(String args[])
    {
        studentpanel studentpanel1 = new studentpanel();
    }

}