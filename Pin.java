import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class Pin extends JFrame implements ActionListener {
    String Pinno;
    JPasswordField npinTextField, rpinTextField;
    JButton Change, Back;
    Pin(String Pinno) {
        this.Pinno = Pinno;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color. WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,400,35);
        image.add(text);

        JLabel newpin = new JLabel("Enter new pin:");
        newpin.setForeground(Color. WHITE);
        newpin.setFont(new Font("System",Font.BOLD,16));
        newpin.setBounds(165,320,180,25);
        image.add(newpin);

        npinTextField = new JPasswordField();
        npinTextField.setFont(new Font("System",Font.BOLD,16));
        npinTextField.setBounds(330,320,180,25);
        image.add(npinTextField);


        JLabel repin = new JLabel("Re-Enter the pin:");
        repin.setForeground(Color. WHITE);
        repin.setFont(new Font("System",Font.BOLD,16));
        repin.setBounds(165,360,180,25);
        image.add(repin);

        rpinTextField = new JPasswordField();
        rpinTextField.setFont(new Font("System",Font.BOLD,16));
        rpinTextField.setBounds(330,360,180,25);
        image.add(rpinTextField);

        Change = new JButton("Change");
        Change.setBounds(355,485,150,30);
        Change.addActionListener(this);
        image.add(Change);

        Back = new JButton("Back");
        Back.setBounds(355,520,150,30);
        Back.addActionListener(this);
        image.add(Back); 


        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            String NewPin = npinTextField.getText();
            String Re_Pin = rpinTextField.getText();
            if(ae.getSource() == Change) {
                if(!NewPin.equals(Re_Pin)) {
                    JOptionPane.showMessageDialog(null,"Entered Pin does not match. ");
                }
                else if(NewPin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter pin  ");
                }
                else if(Re_Pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter the pin ");
                }
                else if (NewPin.equals(Re_Pin)) {
                conn c = new conn();
                String query1 = "update bank SET Pin_No = '"+Re_Pin+"' where Pin_No = '"+Pinno+"'";
                String query2 = "update login SET Pin_No = '"+Re_Pin+"' where Pin_No = '"+Pinno+"'";
                String query3 = "update signup3 SET Pin_No = '"+Re_Pin+"' where Pin_No = '"+Pinno+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed succesfully");
                setVisible(false);
                new Login2(Re_Pin).setVisible(true);
                }
            }
            else if(ae.getSource() == Back) {
                setVisible(false);
                new Login2(Pinno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new Pin("");
    }
}
