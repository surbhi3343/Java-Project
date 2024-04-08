import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;

public class Balance extends JFrame implements ActionListener {
    String Pinno;
    JTextField bal;
    JButton Back;
    Balance(String Pinno) {
        this.Pinno = Pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        Back = new JButton("Back");
        Back.setBounds(355,520,150,30);
        Back.addActionListener(this);
        image.add(Back);
        
        int balance = 0;
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where Pin_No = '"+Pinno+"'");
            while(rs.next()) {
            if(rs.getString("type").equals("deposit")) {
                balance += Integer.parseInt(rs.getString("Amount"));
            }
            else {
                balance -= Integer.parseInt(rs.getString("Amount"));
            }
        }
    } catch (Exception e){
        System.out.println(e);
    }

    JLabel text = new JLabel("Your current account balance is Rs:" + balance );
    text.setForeground(Color.WHITE);
    text.setBounds(170,300,400,30);
    image.add(text);


        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login2(Pinno).setVisible(true);

    }
    public static void main(String args[]) {
        new Balance("");
    }
}
