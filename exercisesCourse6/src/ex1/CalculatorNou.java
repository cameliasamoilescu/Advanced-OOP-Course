package ex1;

public class CalculatorNou implements Calculator {

    @Override
    public double add(Double a, Double b) {
        if (a ==  null){
            throw new NullParameterException("Primul parametru al adunarii este null");
        }

        if (b ==  null){
            throw new NullParameterException("Al doilea parametru al adunarii este null");
        }

        double sum = a + b;

        if(sum == Double.POSITIVE_INFINITY){
            throw new OverflowException("suma este +infinit");
        }

        if(sum == Double.NEGATIVE_INFINITY){
            throw new UnderflowException("suma este -infinit");
        }

        return sum;
    }

    @Override
    public double divide(Double a, Double b) {
        if (a ==  null){
            throw new NullParameterException("Primul parametru al impartirii este null");
        }

        if (b ==  null){
            throw new NullParameterException("Al doilea parametru al impartirii este null");
        }

        if (b == 0){
            throw new DivideByZero("Impartire la 0");
        }

        double div = a / b;

        return div;
    }

    @Override
    public double average(Double[] vector) {
        Double avg = 0d;

        for(Double number : vector)
            avg = add(avg, number);

        avg = divide(avg, (double)vector.length);
        return avg;
    }
}
