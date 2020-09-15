import static java.lang.Math.sqrt;

/**
 * @program: skeleton-sp18
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-13 20:05
 **/

public class Planet {
    private static final double G=6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP,double yP,double xV,
                  double yV,double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    }

    public Planet(Planet p){
        this(p.xxPos,p.yyPos,p.xxVel,p.yyVel,p.mass,p.imgFileName);
    }

    public double calcDistance(Planet roinate){
        double delta_x=this.xxPos-roinate.xxPos;
        double delta_y=this.yyPos-roinate.yyPos;
        return sqrt(delta_x*delta_x+delta_y*delta_y);
    }

    public double calcForceExertedBy(Planet roinate){
        double r=this.calcDistance(roinate);
        return G*this.mass*roinate.mass/r/r;
    }

    public double calcForceExertedByX(Planet roinate){
        double F=this.calcForceExertedBy(roinate);
        double delta_x=roinate.xxPos-this.xxPos;
        double r=this.calcDistance(roinate);
        return F*delta_x/r;
    }

    public double calcForceExertedByY(Planet roinate){
        double F=this.calcForceExertedBy(roinate);
        double delta_y=roinate.yyPos-this.yyPos;
        double r=this.calcDistance(roinate);
        return F*delta_y/r;
    }

    private Boolean equal(Planet roinate){
        if(this.xxPos==roinate.xxPos && this.yyPos==roinate.yyPos
                && this.mass==roinate.mass){
            return true;
        }
        else{
            return false;
        }
    }

    public double calcNetForceExertedByX(Planet [] allPlanet){
        double ForcesByX=0.0;
        for(Planet roinate:allPlanet){
            if(this.equal((roinate))) continue;
            else{
                double x=this.calcForceExertedByX(roinate);
                ForcesByX+=x;
            }
        }
        return ForcesByX;
    }

    public double calcNetForceExertedByY(Planet [] allPlanet){
        double ForcesByY =0.0;

        for(Planet roinate:allPlanet){
            if(this.equal((roinate))) continue;
            else{
                double y=this.calcForceExertedByY(roinate);
                ForcesByY+=y;
            }
        }
        return ForcesByY;
    }

    public void update(double dt,double fx, double fy){
        double ax=fx/this.mass;
        double ay=fy/this.mass;

        this.xxVel+=dt*ax;
        this.yyVel+=dt*ay;

        this.xxPos+=dt*this.xxVel;
        this.yyPos+=dt*this.yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"./images/"+this.imgFileName);
    }


}
