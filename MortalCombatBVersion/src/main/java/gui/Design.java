package gui;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Design {
    public static Color black_blue = new Color(17,24,40);
    public static Color red = new Color(237,69,68);
    public static Color yellow = new Color(252,207,28);
    public static Color green = new Color(23,163,74);
    public static Color purple = new Color(147,52,234);
    public static Color blue = new Color(37,99,234);
    
    public static final Color debuffColor = new Color(138, 43, 226); // Цвет дебаффа (фиолетовый)
    public static final Color regenColor = new Color(0, 128, 0);     // Регенерация (зелёный)
    
    public static Font font;
    static {
        try (InputStream fontStream = Design.class.getResourceAsStream("/font.ttf")) {
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            font = font.deriveFont(28f);
        } catch (IOException | FontFormatException e) {
            font = new Font("Serif", Font.PLAIN, 22);
        }
    }
    
    
    public static Image logo;
    public static Image playerImage;
    public static Image sasuke;
    public static Image pink;
    public static Image bLue;
    public static Image sonik;
    public static Image bibizyan;
    public static Image minion;
    
    static {
        try {
            logo = ImageIO.read(Design.class.getResourceAsStream("/logo.png"));
            playerImage = ImageIO.read(Design.class.getResourceAsStream("/player.png"));
            sasuke = ImageIO.read(Design.class.getResourceAsStream("/sasuke.png"));
            pink = ImageIO.read(Design.class.getResourceAsStream("/pink.png"));
            bLue = ImageIO.read(Design.class.getResourceAsStream("/blue.png"));
            sonik = ImageIO.read(Design.class.getResourceAsStream("/Соник.png"));
            bibizyan = ImageIO.read(Design.class.getResourceAsStream("/обезьяна.png"));
            minion = ImageIO.read(Design.class.getResourceAsStream("/миньон.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static JPanel createPanelWithPhoto(Image image) {
        if (image == null) {
            System.out.println("Изображение не загружено.");
            return (new JPanel(new BorderLayout())); 
        }

        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setOpaque(false);
        return backgroundPanel;
    }
    
    
        public static void setFontForAllComponents(Container container) {
        for (Component component : container.getComponents()) {
            component.setFont(font);
            component.setForeground( Color.WHITE);
            
            if (component instanceof Container) {
                Container container1 = (Container) component;
                setFontForAllComponents(container1);
            }
        }
    }
 
}

