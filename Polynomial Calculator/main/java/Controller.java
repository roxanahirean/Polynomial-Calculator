import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final View view;
    private Model model ;

    Controller( View v, Model m) {
        view = v;
        view.resetBtnL(new resetL());
        view.derivationL(new derivL());
        view.integrationL(new integrL());
        view.divisionL(new divL());
        view.multiplyL(new mulL());
        view.subL(new difL());
        view.addL(new sumL());
        model  = m;
    }


    class resetL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            reset();
        }
    }
    public void reset() {
        view.reset();
        model.reset();
    }

    class derivL implements ActionListener {
        public void actionPerformed(ActionEvent actEvent ) {
            try {
                model = new Model(view.getPolinomial1(), view.getPolinomial2());
                view.setResult(new PolinomialInteger(model.derivation(), 0).toString());
            } catch (Exception exception) {
                view.showErrorMessage(exception.getMessage());
            }
        }
    }
    class difL implements ActionListener {
        public void actionPerformed(ActionEvent actEvent) {
            try {
                model  = new Model(view.getPolinomial1(), view.getPolinomial2());
                view.setResult(model .sub().toString());
            } catch (Exception exception) {
                view.showErrorMessage(exception.getMessage());
            }
        }
    }
    class integrL implements ActionListener {
        public void actionPerformed(ActionEvent actEvent) {
            try {
                model = new Model(view.getPolinomial1(), view.getPolinomial2());
                view.setResult(new PolinomialDouble(model.integrare(),0).toString());
            } catch (Exception exception) {
                view.showErrorMessage(exception.getMessage());
            }
        }
    }

    class sumL implements ActionListener {
        public void actionPerformed(ActionEvent actEvent) {
            try {
                model  = new Model(view.getPolinomial1(), view.getPolinomial2());
                view.setResult(model .add().toString());
            } catch (Exception exception) {
                view.showErrorMessage(exception.getMessage());
            }
        }
    }

    class divL implements ActionListener {
        public void actionPerformed(ActionEvent actEvent) {
            try {
                model =  new Model(view.getPolinomial1(), view.getPolinomial2());
                view.setResult(new PolinomialInteger(model.div(), 0).toString());
            } catch (Exception exception) {
                view.showErrorMessage(exception.getMessage());
            }
        }
    }

    class mulL implements ActionListener {
        public void actionPerformed(ActionEvent actEvent) {
            try {
                model  = new Model(view.getPolinomial1(), view.getPolinomial2());
                view.setResult(new PolinomialInteger(model.multiply(), 0).toString());
            } catch (Exception exception) {
                view.showErrorMessage(exception.getMessage());
            }
        }
    }
}