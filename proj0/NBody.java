public class NBody {

    public static double readRadius(String file) {
        /* N is number of planets.
         * R is radius of the universe.
         */
        In in = new In(file);
        int N = in.readInt();
        double R = in.readDouble();       
        return R;
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int count = 0;
        while(count < 2) {
            double consume = in.readDouble();          
            count ++;
        }
        
        Planet[] planets = new Planet[N]; 
        for(int i = 0; i < N; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV  = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);            
        }    
        return planets;
    }

    public static void main(String[] args) {
        String background = "images/starfield.jpg";
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);

        //animation
        StdDraw.enableDoubleBuffering();
        for(double count = 0; count <= T; count += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for(int i = 0; i < planets.length; i += 1) {        
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);    
            }

            for(int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear(); 
            StdDraw.picture(0, 0, background);           
            for(int i = 0; i < planets.length; i++) {
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
    }
}
