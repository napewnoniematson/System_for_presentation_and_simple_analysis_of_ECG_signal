package pl.dmcs.mcypel.bachelors_degree.application.model;

/**
 * Created by Matson on 19.12.2016.
 */
public final class Logger {
    public static void log(String msg) {
        System.out.println("------------------- " + msg + " -------------------");
    }

    public static void log(String className, String msg) {
        System.out.println("------------------- " + className + ": " + msg + " -------------------");
    }

    public static void log(Class c, String msg) {
        System.out.println("------------------- " + c.getSimpleName() + ": " + msg + " -------------------");
    }


}
