package GUI.components;

import javax.swing.JComboBox;

public class Currency {

    public String[] currencyOptions = {"Dolar(USR)", "Reais(BRL)", "Peso Argentino(ARS)","Euro(EUR)", "Pounds (GBP)", "Iene (JPY)", "Yuan (CNY)","Swiss Franc (CHF)", "Russian Ruble (RUB)"}; 
    public JComboBox fromOptions = new JComboBox(currencyOptions);
    public JComboBox toOptions = new JComboBox(currencyOptions);

}
