package cinemamanagementsystem.Views;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JMultilineLabel extends JTextArea{
    private static final long serialVersionUID = 1L;
    public JMultilineLabel(String text){
        super(text);
        setEditable(false);  
        setCursor(null);  
        setOpaque(false);  
        setFocusable(false);  
        setFont(UIManager.getFont("Label.font"));      
        setWrapStyleWord(true);  
        setLineWrap(true);
        setColumns(55);
        //According to Mariana this might improve it
        setBorder(new EmptyBorder(5, 135, 5, 5));  
        setAlignmentY(JLabel.CENTER_ALIGNMENT);
    }
} 
