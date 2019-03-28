package controller;

/**
 * Runner Object for the Patient Management System
 */
public class Runner {
    /**
     * Main starter method or entry point for this java program
     * @param args Unused as ths is a GUI app
     */
    public static void main(String[] args){
        MainController controller = new MainController();
        controller.start();
    }
}
