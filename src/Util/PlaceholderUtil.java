package Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderUtil {

    public static void addPlaceholder(JTextField textField, String placeholder) {
        // Đặt màu sắc và font cho placeholder
        Color placeholderColor = Color.GRAY;
        Font placeholderFont = textField.getFont().deriveFont(Font.ITALIC);
        Font originalFont = textField.getFont();
        Color originalColor = textField.getForeground();

        // Thiết lập placeholder ban đầu
        textField.setText(placeholder);
        textField.setFont(placeholderFont);
        textField.setForeground(placeholderColor);

        // Lắng nghe sự kiện focus
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xóa placeholder khi focus
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setFont(originalFont);
                    textField.setForeground(originalColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Hiển thị lại placeholder khi mất focus và nội dung trống
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setFont(placeholderFont);
                    textField.setForeground(placeholderColor);
                }
            }
        });
    }
}
