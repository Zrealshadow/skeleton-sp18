
/**
 * @program: skeleton-sp18
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-14 22:34
 **/

public class NBody {

    public static void main(String [] args){
        Double T=Double.parseDouble(args[0]);
        Double dt=Double.parseDouble(args[1]);
        String filename=args[2];
//        String userDirectory = System.getProperty("user.dir");
//        filename=userDirectory+'/'+filename;
        double radius=NBody.readRadius(filename);

        Planet [] planets =NBody.readPlanets(filename);
        int N=planets.length;
        StdDraw.enableDoubleBuffering();

//        System.out.println(N);
//        System.out.println(filename);
        double t=0;
        while(t<=T){
            NBody.drawPlanet(radius,filename,planets);
            StdDraw.pause(1);
            Double [] FxArray=new Double[N];
            Double [] FyArray=new Double[N];
            for(int i=0;i<N;i++){
                Planet planet=planets[i];
                Double Fx=planet.calcNetForceExertedByX(planets);
                Double Fy=planet.calcNetForceExertedByY(planets);
                FxArray[i]=Fx;
                FyArray[i]=Fy;
            }
            for(int i=0;i<N;i++){
                planets[i].update(dt,FxArray[i],FyArray[i]);
            }
            t+=dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

    private static void drawPlanet(double radius,String filename,Planet [] planets){
//        String userDirectory = System.getProperty("user.dir");
        String starfield="./images/starfield.jpg";
        StdDraw.clear();
        StdDraw.setScale(-radius,radius);
        StdDraw.picture(0,0,starfield);
        for(Planet planet:planets){
            planet.draw();
        }
        StdDraw.show();
    }

    public static double readRadius(String filename){
        In in = new In(filename);
        int N=in.readInt();
        double radius=in.readDouble();
        return radius;
    }

    public static Planet [] readPlanets(String filename){
        In in=new In(filename);
        int N=in.readInt();
        double radius=in.readDouble();
        Planet [] planets =new Planet[N];
        for(int i=0;i<N;i++){
            planets[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),
                    in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }

}
