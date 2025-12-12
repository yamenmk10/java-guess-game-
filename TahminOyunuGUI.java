import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TahminOyunuGUI {

    private static int dogru = 0;
    private static int yanlis = 0;
    private static int tur = 1;
    private static int rastgeleSayi;

    public static void main(String[] args) {

        // Random
        Random rnd = new Random();
        rastgeleSayi = rnd.nextInt(51); // 0-50 arası

        // Pencere
        JFrame frame = new JFrame("Tahmin Oyunu");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Label
        JLabel label = new JLabel("0-50 arası sayı tahmininizi yazın:");
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // TextField
        JTextField input = new JTextField(10);

        // Sonuç gösterme
        JLabel sonucLabel = new JLabel(" ");
        sonucLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Bilgi alanı
        JLabel bilgi = new JLabel("Doğru: 0   Yanlış: 0   Tur: 1/6");
        bilgi.setFont(new Font("Arial", Font.PLAIN, 14));

        // Buton
        JButton buton = new JButton("Tahmin Et");

        buton.addActionListener(e -> {
            try {
                int tahmin = Integer.parseInt(input.getText());

                if (tahmin == rastgeleSayi) {
                    sonucLabel.setText("Doğru! Sayı: " + rastgeleSayi);
                    dogru++;
                } else {
                    sonucLabel.setText("Yanlış! Sayı: " + rastgeleSayi);
                    yanlis++;
                }

                tur++;
                bilgi.setText("Doğru: " + dogru + "   Yanlış: " + yanlis + "   Tur: " + (tur <= 6 ? tur : 6) + "/6");

                // Yeni sayı üret
                if (tur <= 6) {
                    rastgeleSayi = new Random().nextInt(3);
                }

                // Oyun bitti
                if (tur > 6) {
                    buton.setEnabled(false);
                    sonucLabel.setText("Oyun bitti!   Doğru: " + dogru + "  Yanlış: " + yanlis);
                }

            } catch (Exception ex) {
                sonucLabel.setText("Geçersiz giriş!");
            }

            input.setText("");
        });

        // Eklemeler
        frame.add(label);
        frame.add(input);
        frame.add(buton);
        frame.add(sonucLabel);
        frame.add(bilgi);

        frame.setVisible(true);
    }
}
