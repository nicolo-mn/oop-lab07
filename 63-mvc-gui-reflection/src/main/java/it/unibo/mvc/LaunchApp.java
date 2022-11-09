package it.unibo.mvc;

import java.lang.reflect.Constructor;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberConsoleView;
import it.unibo.mvc.view.DrawNumberSwingView;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws SecurityException
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws Exception {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        // Part 1
        // app.addView(new DrawNumberSwingView());
        // app.addView(new DrawNumberSwingView());
        // app.addView(new DrawNumberConsoleView());
        // Part 2
        final Class<?> clConsoleView = Class.forName("it.unibo.mvc.view.DrawNumberConsoleView");
        final Class<?> clSwingView = Class.forName("it.unibo.mvc.view.DrawNumberSwingView");
        final Constructor<?> cns1 = clConsoleView.getConstructor();
        final Constructor<?> cns2 = clSwingView.getConstructor();
        for (int i = 0; i < 3; i++) {
            app.addView((DrawNumberConsoleView)cns1.newInstance());
            app.addView((DrawNumberSwingView)cns2.newInstance());
        }
    }
}
