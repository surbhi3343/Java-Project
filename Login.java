import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
public class Login extends JFrame implements ActionListener{
    JButton signin,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login() {
        setLayout(null);
        setTitle("Automated Teller Machine");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,30);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno = new JLabel("Card NO:");
        cardno.setBounds(120,150,150,40);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);

        JLabel pin= new JLabel("Pin:");
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        signin = new JButton("Sign In");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == signin) {
            conn c = new conn();
            String Cardno  = cardTextField.getText();
            // char[] pinChars = pinTextField.getPassword(); 
            // String Pinno = new String(pinChars).trim();
            String Pinno = pinTextField.getText();
            String query = "SELECT * FROM login WHERE Card_No = '" + Cardno + "' AND Pin_No = '" + Pinno + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Login2(Pinno).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card No. or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }
    public static void main (String args[]) {
        new Login();
    } 
    
}