import java.math.BigDecimal;
import javax.swing.*;
import java.awt.event.*;

public class MyGUI {

    private JFrame myInterface;
    private JComboBox<String> currencyOptions;
    private JComboBox<String> toCurrencyOptions;
    private JLabel result;
    private JTextField fromValue;


    private String[] CURRENCY_OPTIONS = {
            "US Dollar (USD)", "Euro (EUR)", "British Pound (GBP)", "Japanese Yen (JPY)",
            "Canadian Dollar (CAD)", "Australian Dollar (AUD)", "Swiss Franc (CHF)",
            "Chinese Yuan (CNY)", "Indian Rupee (INR)", "Brazilian Real (BRL)"
    };

    BigDecimal[][] taxasConversao = {
        // USD,  EUR,   GBP,   JPY,   CAD,   AUD,   CHF,   CNY,   INR,   BRL
        {BigDecimal.ONE, new BigDecimal("0.85"), new BigDecimal("0.73"), new BigDecimal("112.08"), new BigDecimal("1.28"), new BigDecimal("1.39"), new BigDecimal("0.92"), new BigDecimal("6.39"), new BigDecimal("74.48"), new BigDecimal("4.90")},  // USD
        {new BigDecimal("1.18"), BigDecimal.ONE, new BigDecimal("0.86"), new BigDecimal("131.92"), new BigDecimal("1.49"), new BigDecimal("1.62"), new BigDecimal("1.07"), new BigDecimal("7.43"), new BigDecimal("86.58"), new BigDecimal("6.25")},  // EUR
        {new BigDecimal("1.38"), new BigDecimal("1.16"), BigDecimal.ONE, new BigDecimal("153.27"), new BigDecimal("1.74"), new BigDecimal("1.88"), new BigDecimal("1.24"), new BigDecimal("8.63"), new BigDecimal("100.48"), new BigDecimal("7.18")},  // GBP
        {new BigDecimal("0.0089"), new BigDecimal("0.0076"), new BigDecimal("0.0065"), BigDecimal.ONE, new BigDecimal("0.011"), new BigDecimal("0.012"), new BigDecimal("0.008"), new BigDecimal("0.055"), new BigDecimal("0.64"), new BigDecimal("0.045")}, // JPY
        {new BigDecimal("0.78"), new BigDecimal("0.67"), new BigDecimal("0.58"), new BigDecimal("88.16"), BigDecimal.ONE, new BigDecimal("1.08"), new BigDecimal("0.71"), new BigDecimal("4.94"), new BigDecimal("57.56"), new BigDecimal("4.11")},  // CAD
        {new BigDecimal("0.72"), new BigDecimal("0.62"), new BigDecimal("0.54"), new BigDecimal("82.76"), new BigDecimal("0.92"), BigDecimal.ONE, new BigDecimal("0.66"), new BigDecimal("4.57"), new BigDecimal("53.23"), new BigDecimal("3.80")},  // AUD
        {new BigDecimal("1.09"), new BigDecimal("0.92"), new BigDecimal("0.80"), new BigDecimal("122.23"), new BigDecimal("1.38"), new BigDecimal("1.49"), BigDecimal.ONE, new BigDecimal("6.95"), new BigDecimal("81.01"), new BigDecimal("5.78")},  // CHF
        {new BigDecimal("0.16"), new BigDecimal("0.13"), new BigDecimal("0.11"), new BigDecimal("16.72"), new BigDecimal("0.19"), new BigDecimal("0.20"), new BigDecimal("0.13"), BigDecimal.ONE, new BigDecimal("11.66"), new BigDecimal("0.83")},  // CNY
        {new BigDecimal("0.013"), new BigDecimal("0.011"), new BigDecimal("0.0095"), new BigDecimal("1.45"), new BigDecimal("0.016"), new BigDecimal("0.018"), new BigDecimal("0.012"), new BigDecimal("0.083"), BigDecimal.ONE, new BigDecimal("0.071")}, // INR
        {new BigDecimal("0.19"), new BigDecimal("0.16"), new BigDecimal("0.14"), new BigDecimal("21.43"), new BigDecimal("0.24"), new BigDecimal("0.26"), new BigDecimal("0.17"), new BigDecimal("1.18"), new BigDecimal("13.75"), BigDecimal.ONE}    // BRL
};




    public MyGUI() {
        myInterface = new JFrame();
        myInterface.setTitle("Currency Converter");
        myInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myInterface.setSize(800, 600);
        myInterface.setLocationRelativeTo(null);
        myInterface.setLayout(null);
        myInterface.setVisible(true);

        JLabel title = new JLabel("Currency converter in Java");
        title.setBounds(300, 100, 400, 30);
        myInterface.add(title);

        currencyOptions = new JComboBox<>(CURRENCY_OPTIONS);
        currencyOptions.setSelectedIndex(0);
        currencyOptions.setBounds(200, 150, 180, 30);
        myInterface.add(currencyOptions);

        fromValue = new JTextField("Insert a value that you want to convert");
        addPlaceholderBehavior(fromValue);
        fromValue.setBounds(400, 150, 250, 30);
        myInterface.add(fromValue);

        toCurrencyOptions = new JComboBox<>(CURRENCY_OPTIONS);
        toCurrencyOptions.setSelectedIndex(0);
        toCurrencyOptions.setBounds(400, 250, 250, 30);
        myInterface.add(toCurrencyOptions);

        JLabel toValue = new JLabel("What currency you want to convert to?");
        toValue.setBounds(120, 250, 300, 30);
        myInterface.add(toValue);

        result = new JLabel("");
        result.setBounds(200, 300, 400, 30);
        myInterface.add(result);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(350, 350, 100, 30);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        myInterface.add(convertButton);

        


    
}

    private void addPlaceholderBehavior(JTextField textField) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Insert a value that you want to convert")) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("Insert a value that you want to convert");
                }
            }
        }); 
    }

    private void convertCurrency() {
        try {
            int fromCurrency = currencyOptions.getSelectedIndex();
            int toCurrency = toCurrencyOptions.getSelectedIndex();

            BigDecimal value = new BigDecimal(fromValue.getText());

            BigDecimal ourResult = value.multiply(taxasConversao[fromCurrency][toCurrency]);

            result.setText("Converted Value: " + ourResult);
        } catch (NumberFormatException ex) {
            result.setText("Invalid input. Please enter a valid number.");
        }
    }

}