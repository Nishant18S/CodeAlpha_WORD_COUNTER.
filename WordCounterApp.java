import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame 
{

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;
    private JTextField nameField; 

    public WordCounterApp() 
    {
        setTitle("Word Counter");
        setSize(500, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 18)); 
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word count: ");
        nameField = new JTextField(20); 

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        resultLabel.setFont(labelFont);
        resultLabel.setForeground(Color.BLUE);

        
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.GREEN); 

        
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); 
        bottomPanel.setBackground(Color.LIGHT_GRAY); 
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        bottomPanel.add(new JLabel("Name:")); 

        nameField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        nameField.setPreferredSize(new Dimension(200, 30)); 

        bottomPanel.add(nameField); 
        bottomPanel.add(countButton);
        bottomPanel.add(resultLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        countButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
             {
                String text = textArea.getText();
                int wordCount = countWords(text);
                resultLabel.setText("Word count: " + wordCount);
                String name = nameField.getText();
                if (name.isEmpty()) 
                {
                    name = "Unknown"; 
                }
                resultLabel.setText("Word count for " + name + ": " + wordCount);
            }
        });
    }

    // Method to count words
    private int countWords(String text)
     {
        if (text == null || text.isEmpty())
         {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                try 
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }

                WordCounterApp app = new WordCounterApp();
                app.setVisible(true);
            }
        });
    }
}
