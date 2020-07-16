public class NBody {
    public static double readRadius (String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double UR = in.readDouble();
        return UR;
    }

    public static Body[] readBodies (String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double UR = in.readDouble();
        Body[] bodies = new Body[N];

        int i = 0;
        while (i < N) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            bodies[i] = new Body(xP, yP, xV, yV, m, img);
            i++;
        }
        return bodies;
    }

    public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		
		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);
		int N = bodies.length;

        StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for (Body b: bodies) {
			b.Draw();
        }
        StdDraw.enableDoubleBuffering();

        double t = 0;
        while (t <= T){
            double[] ForceX = new double[N];
            double[] ForceY = new double[N];

            for (int i = 0; i < N; i++){
                ForceX[i] = bodies[i].calcNetForceExertedByX(bodies);
                ForceY[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for (int i = 0; i < N; i++) {
				bodies[i].update(dt, ForceX[i], ForceY[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body b: bodies) {
                b.Draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
            
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
                }
    }

}
