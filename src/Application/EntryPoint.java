/*
    This class is the first class called when the user opens the project. this creates a new View, Controller and model
    parent-classes which then creates the specific elements of the sections.
*/

package Application;

public class EntryPoint {

    public View view;
    public Controller controller;
    public Model model;

    public EntryPoint() {
        this.view = new View();
        this.controller = new Controller();
        this.model = new Model();
    }
}
