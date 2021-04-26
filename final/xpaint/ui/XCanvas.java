package ui;

import java.awt.Canvas;
import java.awt.Graphics;

import drawing.XDrawing;

import java.awt.Color;

public class XCanvas extends Canvas {
	private XPaint xpaint;
	
	public XCanvas(XPaint xpaint) {
		this.setXpaint(xpaint);
		this.setBackground(Color.WHITE);
	}

	public XPaint getXpaint() {
		return xpaint;
	}

	public void setXpaint(XPaint xpaint) {
		this.xpaint = xpaint;
	}

	public void paint(Graphics graphics) {
		XDrawing drawing = this.xpaint.getDrawing();
		if (drawing != null) {
			drawing.paint(graphics);
		}
	}
}
