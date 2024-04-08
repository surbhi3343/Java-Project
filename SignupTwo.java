
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField namTextField, fnamTextField , panTextField, aadharTextField,occupationTextField ;
    JRadioButton seniorYes, seniorNo, existAcc, Notexist;
    JButton next;
    JComboBox category, religion, income,education;
    String formno;
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Opening Form:Page 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel rel = new JLabel("Religion");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);

        String varReligion[] = {"Hindu","Muslim","Christian","Sikh"};
        religion = new JComboBox<>(varReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel cat = new JLabel("Category");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        add(cat);

        String valCategory[] = {"General","OBC","SC","ST","Others"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300,190,400,30);
        add(category);

        JLabel inc = new JLabel("Income");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        String varIncome[] = {"null", "<50,000","<1,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox<>(varIncome);
        income.setBounds(300,240,400,30);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);

        JLabel qualify = new JLabel("Qualification");
        qualify.setFont(new Font("Raleway",Font.BOLD,20));
        qualify.setBounds(100,315,200,30);
        add(qualify);

        String vareducation[] = {"Non-Graduate", "Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox<>(vareducation);
        education.setBounds(300,315,400,30);
        add(education);



        JLabel occ = new JLabel("Occupation");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,390,200,30);
        add(occ);

        occupationTextField = new JTextField();
        occupationTextField.setFont(new Font("Raleway",Font.BOLD,14));
        occupationTextField.setBounds(300,390,400,30);
        add(occupationTextField);


        

        JLabel pan = new JLabel("Pan No.");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel addhar = new JLabel("Addhar No.");
        addhar.setFont(new Font("Raleway",Font.BOLD,20));
        addhar.setBounds(100,490,200,30);
        add(addhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel citizenship = new JLabel("Senior Citizen");
        citizenship.setFont(new Font("Raleway",Font.BOLD,20));
        citizenship.setBounds(100,540,200,30);
        add(citizenship);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300,540,100,30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);


        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(450,540,100,30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        ButtonGroup Citizen = new ButtonGroup();
        Citizen.add(seniorYes);
        Citizen.add(seniorNo);


        JLabel exacc = new JLabel("Exisiting Account");
        exacc.setFont(new Font("Raleway",Font.BOLD,20));
        exacc.setBounds(100,590,200,30);
        add(exacc);

        existAcc = new JRadioButton("Yes");
        existAcc.setBounds(300,590,60,30);
        existAcc.setBackground(Color.WHITE);
        add( existAcc);
        Notexist = new JRadioButton("No");
        Notexist.setBounds(450,590,120,30);
        Notexist.setBackground(Color.WHITE);
        add(Notexist);

        ButtonGroup Accountexist = new ButtonGroup();
        Accountexist.add(existAcc);
        Accountexist.add(Notexist);
        

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        String Religion = (String) religion.getSelectedItem();
        String Category = (String) category.getSelectedItem();
        String Income = (String) income.getSelectedItem();
        String Educational = (String) education.getSelectedItem();
        String Occupation = occupationTextField.getText();
        String Citizen = null;
        if(seniorYes.isSelected()) {
             Citizen = "Yes";
        }
        else if (seniorNo.isSelected()) {
            Citizen = "No";
        }
        String ExistAcc = null;
        if(existAcc.isSelected()) {
            ExistAcc = "Yes";
        }
        else if (seniorNo.isSelected()) {
            ExistAcc = "No";
        }
        String pancard = panTextField.getText();
        String addharno = aadharTextField.getText();
        try {
            if(addharno.equals(" ")) {
                JOptionPane.showMessageDialog(null,"Name is required","Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                conn c = new conn ();
                String query = "insert into signup2 values ('"+formno+"', '"+Religion+"', '"+Category+"','"+Income+"','"+Educational+"','"+Occupation+"','"+addharno+"','"+pancard+"','"+Citizen+"','"+ExistAcc+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        new SignupTwo("");
    }
    
}
