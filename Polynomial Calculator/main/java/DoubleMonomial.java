public class DoubleMonomial {
    private int power;
    private double coefficient;

    public DoubleMonomial( int power, double coefficient){
        this.power = power;
        this.coefficient = coefficient;
    }

//    public DoubleMonomial integration() {
//        return new DoubleMonomial(this.power++, this.coefficient /(this.power+1));
//    }


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
}

