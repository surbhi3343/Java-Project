import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login2 extends JFrame implements ActionListener {
    JButton Deposit, Withdrawal,Ministatement,Pinchange,Fastcash,Balance,Exit;
    String Pinno;
    Login2(String Pinno) {
        this.Pinno = Pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        Deposit = new JButton("Deposit");
        Deposit.setBounds(170,415,150,30);
        Deposit.addActionListener(this);
        image.add(Deposit);

        Withdrawal = new JButton("Withdrawal");
        Withdrawal.setBounds(335,415,150,30);
        Withdrawal.addActionListener(this);
        image.add(Withdrawal);

        Fastcash = new JButton("Fastcash");
        Fastcash.setBounds(170,450,150,30);
        Fastcash.addActionListener(this);
        image.add(Fastcash);

        Ministatement = new JButton("Ministatement");
        Ministatement.setBounds(335,450,150,30);
        Ministatement.addActionListener(this);
        image.add(Ministatement);

        Pinchange = new JButton("Pin Change");
        Pinchange.setBounds(170,485,150,30);
        Pinchange.addActionListener(this);
        image.add(Pinchange);

        Balance = new JButton("Balance Enquiry");
        Balance.setBounds(335,485,150,30);
        Balance.addActionListener(this);
        image.add(Balance);

        Exit= new JButton("Exit");
        Exit.setBounds(250,520,150,30);
        Exit.addActionListener(this);
        image.add(Exit);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Exit) {
            System.exit(0);
        }
        else if (ae.getSource() == Deposit) {
            setVisible(false);
            new Deposit(Pinno).setVisible(true);
        }
        else if (ae.getSource() == Withdrawal) {
            setVisible(false);
            new Withdrawal(Pinno).setVisible(true);
        }
        else if (ae.getSource() == Fastcash) {
            setVisible(false);
            new Fastcash(Pinno).setVisible(true);
        }
        else if (ae.getSource() == Pinchange) {
            setVisible(false);
            new Pin(Pinno).setVisible(true);
        }
        else if(ae.getSource() == Balance) {
            setVisible(false);
            new Balance(Pinno).setVisible(true);
        }
        else if(ae.getSource() == Ministatement) {
            new MiniStatement(Pinno).setVisible(true);
        }
    }

    public static void main (String args[]) {
        new Login2("");
    }
}
