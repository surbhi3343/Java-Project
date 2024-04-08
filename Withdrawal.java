import java.util.Date;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw,back;
    String Pinno;

    Withdrawal(String Pinno) {
        this.Pinno = Pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please enter the amount you want to withdraw");
        text.setForeground(Color. WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);


        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdraw) {
            String Rupees = amount.getText();
            Date date = new Date();
            if(Rupees.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }
            else {
                try {
                    conn c = new conn();
                    String query = "insert into Bank values('"+Pinno+"' , '"+date+"' , 'withdraw' , '"+Rupees+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs" + Rupees + " " + "Withdraw Succesfully");
                    setVisible(false);
                    new Login2(Pinno).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
        else if (ae.getSource() == back) {
            setVisible(false);
            new Login2(Pinno).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Withdrawal("");
    }
}
