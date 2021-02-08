public class AppDibujo03 {
	/**
	 * When calling the app, you have two options, pass no 
	 * args which will render a square following a defautl path
	 * or you can enter pair of points, that the square will follow.
	 * For example:
	 * java AppDibujo03 0 0 400 0 400 400 0 400
	 * Will draw a square which goes to all corners of the canvas
	 * @param args
	 */
	public static void main(String[] args) {
		// Create frame 600 by 600
		Dibujo dibujo = new Dibujo(600, 600);

		// Create the square
		Cuadrado cuadrado = new Cuadrado(100, 100, 200);
		
		if (args.length < 2 || args.length % 2 != 0) {
			doDefaultPath(cuadrado, dibujo);
		} else {
			int points = args.length / 2;
			Point[] path = new Point[points];

			for (int i = 0; i < points; i++) {
				int x = Integer.parseInt(args[i*2]);
				int y = Integer.parseInt(args[i*2 + 1]);

				Point newPoint = new Point(x,y);
				path[i] = newPoint;
			}

			dibujo.pintarPath(cuadrado, path, 50, 5);
		}
		
	}

	public static void doDefaultPath(Cuadrado cuadrado, Dibujo dibujo) {
		Point point1 = new Point(0,0);
		Point point2 = new Point(400, 0);
		Point point3 = new Point(400,400);
		Point point4 = new Point(0, 400);
		Point point5 = new Point(300, 300);

		Point[] path = new Point[]{point1, point2, point3, point4, point5};
		dibujo.pintarPath(cuadrado, path, 50, 5);
		dibujo.setInTheMiddle(cuadrado);
		dibujo.pintar(cuadrado);
	}
}
