import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    private String numeralin;
    private String numeralout;
    private int numberin;
    private int numberout;
    private JFrame frame;
    private JTextArea numeralLabelIn; //to ask for numeral
    private JTextArea numberLabelOut; //to print decimal number
    private JTextArea numberLabelIn; //to ask for decimal number
    private JTextArea numeralLabelOut; //to print numeral
    private JPanel panel;
    private JTextField numeralInput;
    private JTextField numberInput;
    private JButton convertToNumberButton; //button to convert to number
    private JButton convertToNumeralButton;

    public GUI(){
        frame = new JFrame();
        //create an action button to convert numerals to decimal
        convertToNumberButton = new JButton("Convert to Modern Number");
        convertToNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                numeralin = numeralInput.getText();
                numberout = RomanNumeral.toNumber(numeralin);
                if(numberout == -1){
                    numberLabelOut.setText("Please enter a valid Roman Numeral");
                }else if(numberout == -2) {
                    numberLabelOut.setText("Invalid combination. Try again");
                }else{
                    numberLabelOut.setText(Integer.toString(numberout));
                }

            }
        });
        //create an action button to convert to numeral
        convertToNumeralButton = new JButton("Convert to Numeral");
        convertToNumeralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    numberin = Integer.parseInt(numberInput.getText());
                    numeralLabelOut.setText(RomanNumeral.toNumeral(numberin));
                }catch(Exception NumberFormatException){
                    numeralLabelOut.setText("Please enter a valid number");
                }
            }
        });
        //create an input box for the numerals
        numeralInput = new JTextField();
        numeralInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeralin = numeralInput.getText();
                numberout = RomanNumeral.toNumber(numeralin);
                if(numberout == -1){
                    numberLabelOut.setText("Please enter a valid Roman Numeral");
                }else if(numberout == -2) {
                    numberLabelOut.setText("Invalid combination. Try again");
                }else{
                    numberLabelOut.setText(Integer.toString(numberout));
                }
            }
        });
        //create an input box to get the numbers
        numberInput = new JTextField();
        numberInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    numberin = Integer.parseInt(numberInput.getText());
                    numeralLabelOut.setText(RomanNumeral.toNumeral(numberin));
                }catch(Exception NumberFormatException){
                    numeralLabelOut.setText("Please enter a valid number");
                }
            }
        });
        numeralLabelIn = new JTextArea("Please enter a Roman Numeral below:  ");//ask for the numerals
        numeralLabelIn.setEditable(false);
        numberLabelOut = new JTextArea(""); //label for sending number output
        numberLabelOut.setLineWrap(true);
        numberLabelIn = new JTextArea( "Please enter a Modern Number below:  "); //ask for modern number
        numberLabelIn.setEditable(false);
        numeralLabelOut = new JTextArea(""); // label for printing numerals
        numeralLabelOut.setLineWrap(true);
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        panel.setLayout(new GridLayout(0,2,20,5));

        //*****************the order here is very important! Pay attention JOE********************
        panel.add(numeralLabelIn);
        panel.add(numberLabelIn);
        panel.add(numeralInput);
        panel.add(numberInput);
        panel.add(convertToNumberButton);
        panel.add(convertToNumeralButton);
        panel.add(numberLabelOut);
        panel.add(numeralLabelOut);





        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Roman Numeral Converter");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}
