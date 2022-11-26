public class Monomial  implements Comparable<Monomial>{
    private int power;
    private int coefficient;

    public Monomial(int coef, int power){
        this.power = power;
        this.coefficient = coef;
    }

    public void setCoefficient(int coef) {
        this.coefficient = coef;
    }

    public int getCoefficient() {
        return this.coefficient;
    }

    public int getPower() {
        return this.power;
    }

    public Monomial transformareMonom(String str) {
        int pow,coef;
        if (!str.contains("x")){
            coef = Integer.parseInt(str);
            return new Monomial(coef, 0);
        }
        else{
            if(str.contains("^")) {
                pow = Integer.parseInt( str.substring( str.indexOf("^")+1 ) );
            } else
                pow = 1;
            if(str.indexOf("x") > 1 || (str.indexOf("x") == 1 && str.charAt(0) != '+' && str.charAt(0) != '-')) {
                coef = Integer.parseInt(str.substring(0,str.indexOf("x")));
            }
            else if (str.indexOf("x")== 1 && str.charAt(0) == '-') {
                coef = -1;
            }else
                coef = 1;
            return new Monomial(coef, pow);
        }
    }


    public Monomial multiply(Monomial monom) {
        Monomial m = new Monomial(0,0);
        m.power = this.power + monom.power;
        m.coefficient = this.coefficient * monom.coefficient;
        return m;
    }

    public Monomial div(Monomial monom){
        return new Monomial((this.coefficient / monom.coefficient), this.power - monom.power);
    }

    public void deriv() {
        if(this.power != 0){
            this.coefficient = this.coefficient * this.power;
            this.power--;
        }else
            this.coefficient = 0;
    }


    public DoubleMonomial integration() {
        return new DoubleMonomial(++this.power, (double)this.coefficient /(double)(this.power));
    }

    @Override
    public String toString() {
        String str = "";
        if(this.coefficient > 0)
            str = "+" ;
        str += this.coefficient;
        if(this.power > 1)
            str += "x^" + this.power;
        else if(this.power == 1)
            str += "x";
        return str;
    }

    public int compareTo(Monomial monom) {
        if(monom.power == power && monom.coefficient == coefficient)
            return 0;
        return Integer.compare(monom.power, power);
    }
}
