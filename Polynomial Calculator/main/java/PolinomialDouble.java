import java.util.ArrayList;

public class PolinomialDouble {
    private int degree;
    private ArrayList<DoubleMonomial> polinomial = new ArrayList<>();

    public PolinomialDouble(ArrayList<DoubleMonomial> a, int i) {
        polinomial=a;
        degree=i;
    }

    public ArrayList<DoubleMonomial> getPolinomial(){
        return this.polinomial;
    }

    @Override
    public String toString() {
        String str = "";
        for(DoubleMonomial monom:this.polinomial) {
            str += monom.toString();
        }
        return str;
    }
}
