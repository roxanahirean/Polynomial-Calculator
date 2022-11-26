import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolinomialInteger {
    private int degree;
    private ArrayList<Monomial> polinomial = new ArrayList<>();

    PolinomialInteger(){
        super();
    }

    PolinomialInteger(ArrayList<Monomial> polinomial, int d){
        this.polinomial = polinomial;
        this.degree = d;
    }


    public void simplify(){
        Collections.sort(this.polinomial);
        for(int i=0; i < polinomial.size(); i++) {
            while( i < polinomial.size()-1 && polinomial.get(i).getPower() == polinomial.get(i+1).getPower()) {
                polinomial.get(i).setCoefficient(polinomial.get(i).getCoefficient() + polinomial.get(i+1).getCoefficient());
                polinomial.remove(i+1);
            }
            if(polinomial.get(i).getCoefficient() == 0) {
                polinomial.remove(i);
                if(polinomial.size() == 0)
                    return;
            }
        }
        this.degree = polinomial.get(0).getPower();
    }

    public ArrayList<Monomial> getPolinomial(){
        return this.polinomial;
    }

    public PolinomialInteger sub(List<Monomial> pol){
        for(Monomial monom : pol)
            monom.setCoefficient(-monom.getCoefficient());
        PolinomialInteger result = this.add1(pol);
        result.simplify();
        return result;
    }

    public PolinomialInteger add1(List<Monomial> pol) {
        ArrayList<Monomial> result = this.polinomial;
        result.addAll(pol);
        PolinomialInteger result1 = new PolinomialInteger(result, 0);
        result1.simplify();
        return result1;
    }

    public ArrayList<Monomial> der(){
        for(Monomial monom:this.polinomial)
            monom.deriv();
        this.simplify();
        return this.polinomial;
    }


    public ArrayList<Monomial> div(PolinomialInteger p) throws Exception{
        PolinomialInteger q = new PolinomialInteger();
        PolinomialInteger r = this;
        q.polinomial.add(new Monomial(0,0));

        if(p.polinomial.size() != 0)
            while(r.polinomial.size() != 0 && r.degree >= p.degree) {
                System.out.println("r=" +r.degree+"    p="+ p.degree);
                System.out.println("r=" +r+"    p="+ p);
                Monomial t = r.polinomial.get(0).div(p.polinomial.get(0));
                if(t.getCoefficient() == 0) {
                    r.polinomial.remove(0);
                    continue;
                }
                q.polinomial.add(t);
                PolinomialInteger tp = new PolinomialInteger();
                tp.polinomial.add(t);
                r = r.sub(tp.multiply(p.polinomial) );
            }
        else throw new Exception ("Impartire la 0");
        q.simplify();
        return q.polinomial;
    }

    public ArrayList<Monomial> multiply(List<Monomial> pol){
        ArrayList<Monomial> result = new ArrayList<Monomial>();
        PolinomialInteger p;
        if(pol.size() > 0) {
            for (Monomial m : polinomial)
                for (Monomial m2 : pol)
                    result.add(m.multiply(m2));
            p = new PolinomialInteger(result, 0);
            p.simplify();
        } else {
            result.add(new Monomial(0, 0));
        }
        return result;
    }

    public ArrayList<DoubleMonomial> integration(){
        ArrayList<DoubleMonomial> p = new ArrayList<>();
        for(Monomial monom:polinomial)
            p.add(monom.integration());
        return p;
    }

    public PolinomialInteger transformarePolinom(String input) throws Exception {
        PolinomialInteger pol = new PolinomialInteger();
        Monomial monom = new Monomial(1, 0);
        final String patternString = "([-+]?[0-9]*x[ ^][0-9]+)|([+-]?[0-9]+x?)|([+-]?[0-9]*x)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            pol.getPolinomial().add(monom.transformareMonom(matcher.group(0)));
        }
        pol.simplify();
        System.out.println(pol);
        return pol;
    }

    @Override
    public String toString() {
        String str = "";
        for(Monomial monom:this.polinomial) {
            str += monom.toString();
        }
        return str;
    }
}