public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double g = 6.67e-11 ;

    public Body(double xP, double yP, double xV,
              double yV, double m, String img) {
               xxPos = xP;
               yyPos = yP;
               xxVel = xV;
               yyVel = yV;
               mass = m;
               imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        return Math.sqrt(Math.pow(b.xxPos - xxPos, 2) + Math.pow(b.yyPos - yyPos, 2));
    }
     
    public double calcForceExertedBy(Body b) {
        return g * mass * b.mass / Math.pow(calcDistance(b), 2);
    }

    public double calcForceExertedByX(Body b) {
        return calcForceExertedBy(b) * (b.xxPos - xxPos) / calcDistance(b);

    }

    public double calcForceExertedByY(Body b) {
        return calcForceExertedBy(b) * (b.yyPos - yyPos) / calcDistance(b);
    }

    public double calcNetForceExertedByX(Body[] allBodies) {
        double netForceX = 0;
        for(int i = 0; i < allBodies.length; i += 1) {
            if(allBodies[i].equals(this)) {
                continue;
            }
            netForceX = netForceX + calcForceExertedByX(allBodies[i]);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Body[] allBodies) {
        double netForceY = 0;
        for(int i = 0; i < allBodies.length; i += 1) {
            if(allBodies[i].equals(this)) {
                continue;
            }
            netForceY = netForceY + calcForceExertedByY(allBodies[i]);
        }
        return netForceY;       
    }

    public void update(double dt, double fX, double fY) {
        xxVel = xxVel + dt * fX / mass;
        yyVel = yyVel + dt * fY / mass;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        String imageToDraw = "images/"+ imgFileName;
        StdDraw.picture(xxPos, yyPos, imageToDraw);
    }
}