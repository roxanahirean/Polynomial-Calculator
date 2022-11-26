import java.util.ArrayList;

public class Model {
    private PolinomialInteger polinomial1 = new PolinomialInteger();
    private PolinomialInteger polinomial2 = new PolinomialInteger();

    Model(String polinom1, String polinom2) throws Exception {
        this.polinomial1 = this.polinomial1.transformarePolinom(polinom1);
        this.polinomial2 = this.polinomial2.transformarePolinom(polinom2);
    }
    Model() {
        super();
    }

    public void reset() {
        polinomial2.getPolinomial().clear();
        polinomial1.getPolinomial().clear();
    }

    public PolinomialInteger sub()  {
        PolinomialInteger rezultat =  polinomial1.sub(polinomial2.getPolinomial());
        return rezultat;
    }


    public PolinomialInteger add()  {
        PolinomialInteger rezultat = polinomial1.add1(polinomial2.getPolinomial());
        return rezultat;
    }

    public ArrayList<Monomial> div() throws Exception  {
        ArrayList<Monomial> rezultat =  polinomial1.div(polinomial2);
        return rezultat;
    }

    public ArrayList<Monomial> multiply() {
        ArrayList<Monomial> rezultat = polinomial1.multiply(polinomial2.getPolinomial());
        return rezultat;
    }

    public ArrayList<DoubleMonomial> integrare() {
        ArrayList<DoubleMonomial> rezultat =  polinomial1.integration();
        return rezultat;
    }

    public ArrayList<Monomial> derivation()  {
        ArrayList<Monomial> rezultat =  polinomial1.der();
        return rezultat;
    }
}