import java.awt.Color;
import java.awt.Font;
//import com.toedter.calendar;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.lang.String;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton t1,t2,t3,t4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit , cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,140,200,20);
        add(type);

        t1 = new JRadioButton("Saving Account");
        t1.setFont(new Font("Raleway",Font.BOLD,16));
        t1.setBackground(Color.WHITE);
        t1.setBounds(100,180,150,20);
        add(t1);

        t2 = new JRadioButton("Fixed Deposit Account");
        t2.setFont(new Font("Raleway",Font.BOLD,16));
        t2.setBackground(Color.WHITE);
        t2.setBounds(350,180,250,20);
        add(t2);

        t3 = new JRadioButton("Current Account");
        t3.setFont(new Font("Raleway",Font.BOLD,16));
        t3.setBackground(Color.WHITE);
        t3.setBounds(100,220,250,20);
        add(t3);

        t4 = new JRadioButton("Reccuring Deposit Account");
        t4.setFont(new Font("Raleway",Font.BOLD,16));
        t4.setBackground(Color.WHITE);
        t4.setBounds(350,220,250,20);
        add(t4);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(t1);
        accountgroup.add(t2);
        accountgroup.add(t3);
        accountgroup.add(t4);

        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(100,300,200,30);
        add(cardno);

        JLabel cardDetails = new JLabel("(This is your Card Number)");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,330,200,30);
        add(cardDetails);


        JLabel number = new JLabel("XXXX-XXXX-XXXX-2310");
        number.setFont(new Font("Raleway",Font.BOLD,16));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel pinNo = new JLabel("Pin No.");
        pinNo.setFont(new Font("Raleway",Font.BOLD,20));
        pinNo.setBounds(100,370,200,30);
        add(pinNo);

        JLabel pindetails = new JLabel("(This is your pin number)");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,400,300,30);
        add(pindetails);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,16));
        pnumber.setBounds(330,370,300,20);
        add(pnumber);


        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100,450,200,30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("SMS & Email Alert");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above stated information is correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,630,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,660,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,660,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == submit) {
                String accountType = null;
                if(t1.isSelected()) {
                    accountType = "Saving Account";
                } else if (t2.isSelected()) {
                    accountType = "Fixed Deposit Account";
                } else if(t3.isSelected()) {
                    accountType = "Current Account";
                } else if(t4.isSelected()) {
                    accountType = "Reccurent Deposit Account";
                }
                Random random = new Random();
                String cardnumber = " " + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
                String pinnumber = " " + Math.abs((random.nextLong() % 9000L) + 1000L);
                String services =  " ";
                if(c1.isSelected()) {
                    services = services + "ATM Card";
                } else if(c2.isSelected()) {
                    services = services + "Internet Banking";
                } else if(c3.isSelected()) {
                    services = services + "Mobile Banking";
                } else if(c4.isSelected()) {
                    services = services + "Email & SMS Alerts";
                } else if(c5.isSelected()) {
                    services = services + "Cheque Book";
                } else if(c6.isSelected()) {
                    services = services + "E-statement";
                }

                try {
                    if(accountType.equals("")) {
                        JOptionPane.showMessageDialog(null, "Account type is required");
                    }
                    else  {
                        conn c = new conn();
                        String query1 = "insert into signup3 values('"+formno+"',  '"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+services+"')";
                        String query2 = "insert into login values('"+formno+"' , '"+cardnumber+"' , '"+pinnumber+"')";
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);

                        JOptionPane.showMessageDialog(null, "Card Number:" + cardnumber + "\n Pin" + pinnumber);
                        setVisible(false);
                        new Deposit(pinnumber).setVisible(true);
                    }
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
            else if (ae.getSource() == cancel) {
                setVisible(false);
                new Login().setVisible(true);
            }

    }
    public static void main (String args[]) {
        new SignupThree("");
    }
}
