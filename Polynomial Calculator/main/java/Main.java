public class Main {

    public static void main(String[] args) {
        View v = new View();
        Model m = new Model();
        Controller ctrl = new Controller(v, m);
        ctrl.reset();
    }

}