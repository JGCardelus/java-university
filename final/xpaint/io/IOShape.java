package io;

import java.util.LinkedList;

import shapes.XShape;

public interface IOShape {
	public String toCsv();
	public XShape fromCsv(LinkedList<String> data);
}
