public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67E-11;

    public Body(double xP, double yP, double xV,double yV,double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName =img;
    }
    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;          
    }
    public double calcDistance (Body b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;
        double dist = Math.sqrt( dx * dx + dy * dy);
        return dist;
    }

    public double calcForceExertedBy(Body b) {
        double r = calcDistance(b);
        double F = G * b.mass * mass / (r * r);
        return F;
    }

    public double calcForceExertedByX (Body b) {
        double dx = b.xxPos - xxPos;
        double F = calcForceExertedBy(b);
        double r = calcDistance(b);
        return F * dx / r;
    }

    public double calcForceExertedByY (Body b) {
        double dy = b.yyPos - yyPos;
        double F = calcForceExertedBy(b);
        double r = calcDistance(b);
        return F * dy / r;
    }
 
    public double calcNetForceExertedByX (Body[] allBodys) {
        double netFoceX = 0;
        for (Body b : allBodys){
            if (b.equals(this)){
                continue;
            }
            netFoceX += calcForceExertedByX(b);
        }
        return netFoceX;
    }

    public double calcNetForceExertedByY (Body[] allBodys) {
        double netFoceY = 0;
        for (Body b : allBodys){
            if (b.equals(this)){
                continue;
            }
            netFoceY += calcForceExertedByY(b);
        }
        return netFoceY;
    }

    public void update(double dt, double Fx, double Fy){
        double ax = Fx / mass;
        double ay = Fy / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;

        xxPos += dt * xxVel;
        yyPos += dt * yyVel;

    }
    public void Draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);

    }



}