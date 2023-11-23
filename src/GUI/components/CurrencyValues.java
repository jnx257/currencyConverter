package GUI.components;

import javax.swing.*;
import javax.swing.text.*;

public class CurrencyValues {

    public JTextField fromInsertValue = createNumericTextField();
    public JTextField toInsertValue = createNumericTextField();
    

    private JTextField createNumericTextField() {
        JTextField textField = new JTextField();
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new NumericFilter());
        return textField;
    }

    private static class NumericFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
            if (isValidNumeric(newText)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
            if (isValidNumeric(newText)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isValidNumeric(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

    }
}


