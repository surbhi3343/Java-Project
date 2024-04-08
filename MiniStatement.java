import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class MiniStatement extends JFrame {
    String Pinno;
    MiniStatement(String Pinno) {
        this.Pinno = Pinno;
        setTitle("MiniStatement");
        setLayout(null);
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel Bank = new JLabel("Indian Bank");
        Bank.setBounds(150,20,100,20);
        add(Bank);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);


        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where Pin_No = '"+Pinno+"'");
            while(rs.next()) {
                card.setText("Card Number:" + rs.getString("Card_No").substring(0,4)+"XXXXXXXX"+rs.getString("Card_No").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where Pin_No = '"+Pinno+"'");
            int bal = 0;
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");
                if(rs.getString("type").equals("deposit")) {
                    bal += Integer.parseInt(rs.getString("Amount"));
                }
                else {
                    bal -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            balance.setText("Your current balance is Rs:" + bal);
        } catch (Exception e) {
            System.out.println(e);
        }
        setSize(400,600);
        setLocation(20,20);
        setVisible(true); 
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
