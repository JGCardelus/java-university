package utils;

import java.awt.Color;
import java.util.Random;

import utils.exceptions.RGBConversionException;

public class ColorTools {
	public static Color rbgToColor(int r, int g, int b) throws RGBConversionException  {
		if (r >= 0 && r <= 255) {
			if  (g >= 0 && g <= 255) {
				if  (b >= 0 && b <= 255) {
					return new Color(r,g,b);
				}
			}
		} 
		
		throw new RGBConversionException(r,g,b);
	}

	public static Color getRandomColor() {
		int r = new Random().ints(0, 256).findFirst().getAsInt();
		int g = new Random().ints(0, 256).findFirst().getAsInt();
		int b = new Random().ints(0, 256).findFirst().getAsInt();

		return new Color(r,g,b);
	}
}
