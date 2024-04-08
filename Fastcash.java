import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    JButton five, twothous,fivethous,tenthous,Back;
    String Pinno;
    Fastcash(String Pinno) {
        this.Pinno = Pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        five = new JButton("500");
        five.setBounds(170,415,150,30);
        five.addActionListener(this);
        image.add(five);

        twothous = new JButton("2000");
        twothous.setBounds(335,415,150,30);
        twothous.addActionListener(this);
        image.add(twothous);

        fivethous = new JButton("5000");
        fivethous.setBounds(170,450,150,30);
        fivethous.addActionListener(this);
        image.add(fivethous);

        tenthous = new JButton("10000");
        tenthous.setBounds(335,450,150,30);
        tenthous.addActionListener(this);
        image.add(tenthous);

        
        Back= new JButton("Back");
        Back.setBounds(250,520,150,30);
        Back.addActionListener(this);
        image.add(Back);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Back) {
            setVisible(false);
            new Login2(Pinno).setVisible(true);
        }
        else {
            String rupees = ((JButton)ae.getSource()).getText();
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where Pin_No = '"+Pinno+"'");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("deposit")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if(ae.getSource() != Back && balance < Integer.parseInt(rupees)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Amount");
                    return;
                }
                else {
                    Date date = new Date();
                    String query = "insert into Bank values('"+Pinno+"' , '"+date+"' , 'withdraw', '"+rupees+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs" + rupees + " " + "Debited Successfully");

                    setVisible(false);
                    new Login2(Pinno).setVisible(true);
                }
            } catch (Exception e) {

            }
        }
    }
    public static void main(String args[]) {
        new Fastcash("");
    }
}
