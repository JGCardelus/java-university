package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import shapes.XOval;
import shapes.XPolygon;
import shapes.XRectangle;
import shapes.XShape;

public class IODrawing {
	public static final String LAST = "last";
	
	public static final String RECTANGLE = XRectangle.CSV_NAME;
	public static final String OVAL = XOval.CSV_NAME;
	public static final String POLYGON = XPolygon.CSV_NAME;

	private LinkedList<XShape> shapes;

	public IODrawing(LinkedList<XShape> shapes) {
		this.setShapes(shapes);
	}

	public IODrawing() {
		this(new LinkedList<XShape>());
	}

	public LinkedList<XShape> getShapes() {
		return shapes;
	}

	public void setShapes(LinkedList<XShape> shapes) {
		this.shapes = shapes;
	}

	public void save(String filePath) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			for (XShape shape : this.getShapes())
				oos.writeObject(shape);

			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public LinkedList<XShape> open(String filePath) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		LinkedList<XShape> shapes = new LinkedList<>();
		
		try {
			fis = new FileInputStream(filePath);
			ois = new ObjectInputStream(fis);
			while (true) {
				XShape shape = (XShape) ois.readObject();
				shapes.add(shape);
			}
		}
		catch (EOFException eofe) {
			try {
				ois.close();
				fis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		return shapes;
	}

	public void exportToCsv(String filePath) {
		FileWriter fiw = null;
		BufferedWriter bfw = null;

		try {
			fiw = new FileWriter(filePath);
			bfw = new BufferedWriter(fiw);

			for (XShape shape: this.getShapes())
				bfw.append(shape.toCsv());
			
			bfw.close();
			fiw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public LinkedList<XShape> importFromCsv(String filePath) {
		// Emtpy shapes
		this.setShapes(new LinkedList<XShape>());

		FileReader fir = null;
		BufferedReader bfr = null;

		try {
			fir = new FileReader(filePath);
			bfr = new BufferedReader(fir);

			String shapeCode = null;
			LinkedList<String> shapeBuffer = new LinkedList<String>();
			while (true) {
				String line = bfr.readLine();
				if (line == null)
					break;
				
				String chunks[] = line.split(IOConfig.CSV_SEPARATOR);
				if (chunks.length == IOConfig.CSV_COLS) {
					String possibleCode = this.getLineCode(chunks);
					
					if (possibleCode != null) {
						if (!shapeBuffer.isEmpty() && shapeCode != null) {
							this.handleShapeBuffer(shapeCode, shapeBuffer);
							shapeBuffer = new LinkedList<String>();
						}
						shapeCode = possibleCode;
					}

					shapeBuffer.add(line);
				}
			}

			if (!shapeBuffer.isEmpty() && shapeCode != null) {
				this.handleShapeBuffer(shapeCode, shapeBuffer);
			}

			fir.close();
			bfr.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return this.getShapes();
	}

	private void handleShapeBuffer(String shapeCode, LinkedList<String> shapeBuffer) {
		XShape shape = null;
		switch (shapeCode) {
			case RECTANGLE:
					shape = new XRectangle().fromCsv(shapeBuffer);
				break;
			case OVAL:
					shape = new XOval().fromCsv(shapeBuffer);
				break;
			case POLYGON:
					shape = new XPolygon().fromCsv(shapeBuffer);
				break;
			default:
				break;
		}

		if (shape != null)
			this.shapes.add(shape);
	}

	public String getLineCode(String chunks[]) {
		if (!chunks[0].equals(LAST)) {
			return chunks[0];
		} else {
			return null;
		}
	}
}
