package GUI;

import javax.swing.*;
import GUI.components.*;

public class MyGUI extends JFrame {


    /**
     * 
     */
    public MyGUI (){

        //our interface
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setVisible(true);

        this.setLayout(null);
        this.setLocationRelativeTo(null);


        //our labels
        Labels labels = new Labels();

        labels.fromLabel.setBounds(50,50,200,30);
        add(labels.fromLabel);

        labels.toLabel.setBounds(50,100,200,30);
        add(labels.toLabel);

        //our selecte

        Currency fromCurrency = new Currency();

        fromCurrency.fromOptions.setBounds(250,50,120,30); 
        fromCurrency.fromOptions.setSelectedIndex(0);
        add(fromCurrency.fromOptions);

        String from = fromCurrency.fromOptions.getSelectedItem().toString();

        fromCurrency.toOptions.setBounds(250,100,120,30);
        fromCurrency.toOptions.setSelectedIndex(1);
        add(fromCurrency.toOptions);

        String to = fromCurrency.toOptions.getSelectedItem().toString();


        //our currency value

        CurrencyValues fromCurrencyValues = new CurrencyValues();
        
        fromCurrencyValues.fromInsertValue.setBounds(410,50,70,30);
        add(fromCurrencyValues.fromInsertValue);
        System.out.println(fromCurrencyValues.fromInsertValue.getText());

        fromCurrencyValues.toInsertValue.setBounds(410,100,70,30);
        add(fromCurrencyValues.toInsertValue);
        System.out.println(fromCurrencyValues.toInsertValue.getText());

        //adding our main action on our button
        double fromValue = Double.parseDouble(fromCurrencyValues.fromInsertValue.getText());
        double toValue = Double.parseDouble(fromCurrencyValues.toInsertValue.getText()); 

        JButton convertButton = new JButton();


        convertButton.addActionListener(e -> {
            switch(from){
                case "Dolar(USR)":
                switch (to) {
                    case "Reais(BRL)":
                        double result = fromValue * 4.91;
                        System.out.println("Resultado: " + result);
                        break;
                
                    default:
                        break;
                }
                break;
                default:
                break;

            }
        });
        convertButton.setBounds(410, 150, 150, 30);
        add(convertButton);
    }




}
