import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Color;

import java.util.Random;

import drawing.shapes.XRectangle;
import exceptions.RGBConversionException;
import drawing.shapes.XOval;
import drawing.shapes.XPolygon;

public class XPaint extends JFrame {
	public static void main(String[] args) {
		new XPaint();
	}
	
	private XDrawing drawing;
	private XCanvas canvas;
	private int status;

	private JButton btnSelect;

	private JButton btnCreateRectangle;
	private JButton btnCreateOval;
	private JButton btnCreatePolygon;

	private JButton btnColor;
	private JButton btnRandomColor;
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtBlue;
	private Color chosenColor;

	private JButton btnClear;
	private JButton btnErase;

	private JLabel lblStatus;

	XPaint() {
		super("XPaint");

		JPanel quickActions = new JPanel(new FlowLayout());
		this.btnSelect = new JButton("Seleccionar");
		this.btnCreateRectangle = new JButton("Rectangulo");
		this.btnCreateOval = new JButton("Ovalo");
		this.btnCreatePolygon = new JButton("Poligono");
		this.btnColor = new JButton("Color");
		this.btnRandomColor = new JButton("Aleatorio");
		this.btnClear = new JButton("Borrar todo");
		this.btnErase = new JButton("Borrar");

		this.txtRed = new JTextField(3);
		this.txtGreen = new JTextField(3);
		this.txtBlue = new JTextField(3);
		this.setRandomColor();
		
		this.handleGenericEvents();

		quickActions.add(this.btnSelect);
		quickActions.add(new JLabel(" | "));

		quickActions.add(this.btnCreateRectangle);
		quickActions.add(this.btnCreateOval);
		quickActions.add(this.btnCreatePolygon);
		quickActions.add(new JLabel(" | "));

		quickActions.add(new JLabel("R: "));
		quickActions.add(this.txtRed);
		quickActions.add(new JLabel("G: "));
		quickActions.add(this.txtGreen);
		quickActions.add(new JLabel("B: "));
		quickActions.add(this.txtBlue);
		quickActions.add(this.btnColor);
		quickActions.add(this.btnRandomColor);

		quickActions.add(new JLabel(" | "));
		quickActions.add(this.btnClear);
		quickActions.add(this.btnErase);

		
		this.setDrawing(new XDrawing(this));
		this.setStatus(Status.SELECTING);
		this.setCanvas(new XCanvas(this));

		JPanel statusPanel = new JPanel(new FlowLayout());
		this.lblStatus = new JLabel(Status.SELECTING_NAME);
		statusPanel.add(this.lblStatus);

		this.setLayout(new BorderLayout());
		this.add(quickActions, BorderLayout.NORTH);
		this.add(this.canvas, BorderLayout.CENTER);
		this.add(statusPanel, BorderLayout.SOUTH);

		// Initialize components
		this.setSize(1000, 800); // Makes the window fit the concatenateToFiguras
		this.setResizable(false); // Does not allow rsize to
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que al pulsar en la X finalice la aplicación

        //Este método siempre debe ser el último mensaje
        this.setVisible(true);
	}

	public void setRandomColor() {
		int r = new Random().ints(0, 256).findFirst().getAsInt();
		int g = new Random().ints(0, 256).findFirst().getAsInt();
		int b = new Random().ints(0, 256).findFirst().getAsInt();

		Color color = new Color(r,g,b);
		this.setChosenColor(color);
	}

	public void handleGenericEvents() {
		this.btnCreateRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.drawing.setNewShape(new XRectangle());
				XPaint.this.lblStatus.setText(Status.DRAWING_NEW_RECTANGLE_NAME);
				XPaint.this.setNewShapeStatus();
			}
		});

		this.btnCreateOval.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.drawing.setNewShape(new XOval());
				XPaint.this.lblStatus.setText(Status.DRAWING_NEW_OVAL_NAME);
				XPaint.this.setNewShapeStatus();
			}
		});

		this.btnCreatePolygon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.drawing.setNewShape(new XPolygon());
				XPaint.this.lblStatus.setText(Status.DRAWING_NEW_POLYGON_NAME);
				XPaint.this.setNewShapeStatus();
			}
		});

		this.btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.drawing.clear();
				XPaint.this.paint();
			}
		});

		this.btnErase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.setEraseStatus();
			}
		});

		this.btnColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.getChosenColorFromText();
				XPaint.this.setColorStatus();
			}
		});

		this.btnRandomColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.setRandomColor();
			}
		});

		this.btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.setSelectingStatus();
			}
		});

		this.txtRed.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!XPaint.this.txtRed.getText().equals("")) {
					XPaint.this.getChosenColorFromText();
				}
			}
		});

		this.txtGreen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!XPaint.this.txtGreen.getText().equals("")) {
					XPaint.this.getChosenColorFromText();
				}
			}
		});

		this.txtBlue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!XPaint.this.txtBlue.getText().equals("")) {
					XPaint.this.getChosenColorFromText();
				}
			}
		});
	}

	public void setColorStatus() {
		this.drawing.deselectShapes();
		XPaint.this.lblStatus.setText(Status.COLOR_NAME);
		XPaint.this.status = Status.COLOR;
	}

	public void setEraseStatus() {
		this.drawing.deselectShapes();
		XPaint.this.lblStatus.setText(Status.ERASE_NAME);
		XPaint.this.status = Status.ERASE;
	}

	public void setNewShapeStatus() {
		this.drawing.deselectShapes();
		this.status = Status.DRAWING_NEW_SHAPE;
	}

	public void setSelectingStatus() {
		if (this.drawing.getNewShape() != null) {
			if (this.drawing.getNewShape().isDefined()) {
				this.drawing.addNewShape();
				this.drawing.setNewShape(null);
			}
		}
		XPaint.this.lblStatus.setText(Status.SELECTING_NAME);
		this.status = Status.SELECTING;
	}

	public void handleCanvasEvents() {
		this.canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XPaint.this.drawing.canvasMouseClicked(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				XPaint.this.drawing.canvasMouseReleased(e);
			}
		});

		this.canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int status = XPaint.this.getStatus();
				if (status == Status.DRAWING_NEW_SHAPE || status == Status.DRAWING_NEW_SELECTOR) {
					XPaint.this.drawing.canvasMouseMoved(e);
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				XPaint.this.drawing.canvasMouseDragged(e);
			}
		});
	}

	public void paint() {
		this.canvas.repaint();
	}

	public XDrawing getDrawing() {
		return drawing;
	}

	public void setDrawing(XDrawing drawing) {
		this.drawing = drawing;
	}

	public XCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(XCanvas canvas) {
		this.canvas = canvas;
		this.handleCanvasEvents();
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Color getChosenColor() {
		return this.chosenColor;
	}

	public void setChosenColor(Color color) {
		this.chosenColor = color;

		if (this.txtRed != null) {
			this.txtRed.setText(Integer.toString(color.getRed()));
		}
		if (this.txtGreen != null) {
			this.txtGreen.setText(Integer.toString(color.getGreen()));
		}
		if (this.txtBlue != null) {
			this.txtBlue.setText(Integer.toString(color.getBlue()));
		}
	}

	public void getChosenColorFromText() {
		try {
			int red = Integer.parseInt(this.txtRed.getText());
			int green = Integer.parseInt(this.txtGreen.getText());
			int blue = Integer.parseInt(this.txtBlue.getText());

			this.chosenColor = this.rbgToColor(red, green, blue);
		} catch (RGBConversionException exception) {
			JOptionPane.showMessageDialog(this, exception.toString());
			if (exception.isRed()) {
				this.txtRed.setText("0");
			}
			if (exception.isGreen()) {
				this.txtGreen.setText("0");
			}
			if (exception.isBlue()) {
				this.txtBlue.setText("0");
			}
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(this, "La letra introducida no en un número. Por favor, vuelva a intentarlo.");
		}
	}

	public Color rbgToColor(int r, int g, int b) throws RGBConversionException  {
		if (r >= 0 && r <= 255) {
			if  (g >= 0 && g <= 255) {
				if  (b >= 0 && b <= 255) {
					return new Color(r,g,b);
				}
			}
		} 
		
		throw new RGBConversionException(r,g,b);
	}
}