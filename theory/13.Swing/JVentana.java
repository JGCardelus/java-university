import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;

public class JVentana {
	public static void main(String args[]) {
		JFrame miVentana = new JFrame("Hello there!");
		miVentana.setLayout(new FlowLayout());
		//miVentana.setSize(500, 500);

		Font fontAwesome = new Font("Montserrat", Font.BOLD, 40);

		JLabel jlabel = new JLabel("Hello motherfucker!!");
		jlabel.setFont(fontAwesome);
		
		JButton jbutton = new JButton("Click here dumbass");
		jbutton.setFont(fontAwesome);

		miVentana.add(jlabel);
		miVentana.add(jbutton);
		
		// Último método
		miVentana.pack();
		miVentana.setVisible(true);
	}
}
