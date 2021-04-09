import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import figuras.*;
import utils.Util;

public class JVentanaDibujo extends JFrame {
	private Dibujo dibujo;
	private Lienzo lienzo;
	private Canvas canvas;

	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtSize;
	private JTextField txtGroup;

	private JButton btnCircle;
	private JButton btnSquare;
	private JButton btnChangeGroupVisibility;
	private JButton btnChangeGroupFill;

	private JButton btnTestRoutine;

	public static void main(String[] args) {
		new JVentanaDibujo();
	}

	public JVentanaDibujo() {
		super("Hello motherfucker");

		this.dibujo = new Dibujo();
		this.lienzo = new Lienzo(this);
		// Define control panel
		JPanel controlPanel = new JPanel(new FlowLayout());
		this.txtX = new JTextField(3);
		this.txtY = new JTextField(3);
		this.txtSize = new JTextField(4);
		this.txtGroup = new JTextField(5);

		this.btnCircle = new JButton("Circulo");
		this.btnSquare = new JButton("Cuadrado");
		this.btnChangeGroupVisibility = new JButton("Mostrar/Esconder");
		this.btnChangeGroupFill = new JButton("Rellenar/Vaciar");

		controlPanel.add(new JLabel("X: "));
		controlPanel.add(txtX);
		controlPanel.add(new JLabel("Y: "));
		controlPanel.add(txtY);
		controlPanel.add(new JLabel("Lado/Radio: "));
		controlPanel.add(txtSize);
		controlPanel.add(new JLabel("Grupo: "));
		controlPanel.add(txtGroup);

		controlPanel.add(this.btnCircle);
		controlPanel.add(this.btnSquare);
		controlPanel.add(this.btnChangeGroupVisibility);
		controlPanel.add(this.btnChangeGroupFill);

		// Test panels
		JPanel testPanel = new JPanel(new FlowLayout());
		this.btnTestRoutine = new JButton("Rutina Test");
		testPanel.add(this.btnTestRoutine);

		this.initEvents();
		// Add panels and define layout
		this.setLayout(new BorderLayout());
		this.add(this.lienzo, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(testPanel, BorderLayout.SOUTH);
		// Initialize components
		this.setSize(900, 800); // Makes the window fit the concatenateToFiguras
		this.setResizable(false); // Does not allow rsize to
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que al pulsar en la X finalice la aplicación

        //Este método siempre debe ser el último mensaje
        this.setVisible(true);
	}

	public void initEvents() {
		// Local copy of self, better way??
		JVentanaDibujo self = this;
		this.txtX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					self.txtY.requestFocus();
				}	
			}
		});

		this.txtY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					self.txtSize.requestFocus();
				}	
			}
		});

		this.txtSize.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					self.txtGroup.requestFocus();
				}	
			}
		});

		this.txtGroup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					self.handleTxtGroupEnter();
				}
			}
		});

		this.btnCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.addCircle(self.getBasicShapePropertiesFromText());
			}
		});

		this.btnSquare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.addSquare(self.getBasicShapePropertiesFromText());
			}
		});

		this.btnChangeGroupVisibility.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.changeGroupVisibility(self.getBasicShapePropertiesFromText().group);
				
			}
		});

		this.btnChangeGroupFill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.changeGroupFill(self.getBasicShapePropertiesFromText().group);
			}
		});

		this.btnTestRoutine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//self.testRoutine();
				System.out.println("Not working yet.");
			}
		});
	}

	public void changeGroupVisibility(String group) {
		this.dibujo.changeGroupVisibility(group);
		this.lienzo.repaint();
	}

	public void changeGroupFill(String group) {
		this.dibujo.changeGroupFill(group);
		this.lienzo.repaint();
	}

	public void addCircle(BasicShapeProperties circleProperties) {
		Circulo circulo = new Circulo(circleProperties);
		this.addFiguraToDibujo(circleProperties.group, circulo);
	}

	public void addSquare(BasicShapeProperties squareProperties) {
		Cuadrado cuadrado = new Cuadrado(squareProperties);
		this.addFiguraToDibujo(squareProperties.group, cuadrado);
	}

	public void addFiguraToDibujo(String group, Figura figura) {
		this.dibujo.paint(group, figura);
		this.lienzo.repaint();
	}

	public BasicShapeProperties getBasicShapePropertiesFromText() {
		String x = this.txtX.getText();
		String y = this.txtY.getText();
		String size = this.txtSize.getText();
		String group = this.txtGroup.getText();

		return new BasicShapeProperties(x, y, size, group);
	}

	public void handleTxtGroupEnter() {
		BasicShapeProperties properties = this.getBasicShapePropertiesFromText();
		if (!properties.isShape()) {
			this.changeGroupVisibility(properties.group);
		} else {
			this.addSquare(properties);
		}
	}

	public void testRoutine() {
		this.dibujo.clear();
		this.lienzo.repaint();

		Cuadrado cuadrado1 = new Cuadrado(0,0,200,false,Color.PINK);
		Cuadrado cuadrado2 = new Cuadrado(100,100, 200,true,Color.RED);
		Circulo circulo1 = new Circulo(300,300,200,true,Color.GREEN);
		Circulo circulo2 = new Circulo(200,200,200,false,Color.BLUE);

		this.dibujo.paint("a", cuadrado1);
		this.dibujo.paint("a", circulo1);

		this.dibujo.paint("b", cuadrado2);
		this.dibujo.paint("b", circulo2);

		this.lienzo.repaint();
		System.out.println(this);
		System.out.println(this.dibujo.toString());
		Util.wait(2);

		this.dibujo.fillGroup("a");
		this.dibujo.hideGroup("b");
		this.lienzo.repaint();
		Util.wait(2);

		this.dibujo.hideGroup("a");
		this.dibujo.showGroup("b");
		this.dibujo.setGroupColor("b", Color.MAGENTA);
		this.lienzo.repaint();
		Util.wait(2);

		this.dibujo.clear();
		this.lienzo.repaint();
	}
	
	public Dibujo getDibujo() {
		return this.dibujo;
	}
}
