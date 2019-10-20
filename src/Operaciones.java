public class Operaciones {

    private String operador1;
    private String operador2;
    private String operacion;

    Operaciones() {
        operador1 = "";
        operador2 = "";
        operacion = "";
    }

    public void entrada(String opcion) {

        if(opcion.length()==1) {

            Character c = opcion.charAt(0);
            if(Character.isDigit(c))
                operador((int) c);
            else
                operacion(c.toString());

        } else
            operacion(opcion);

    }

    private void operacion(String input) {
        System.out.println("operación->" + input);

        switch (input) {
            case "CE":
                vaciar();
                break;
            case "C":
                vaciarOperador();
                break;
            case "x2":
                elevar();
            break;
            case "%":
                setOperacion(input);
                break;
            case "X":
                setOperacion(input);
                break;
            case "-":
                setOperacion(input);
                break;
            case "+":
                setOperacion(input);
                break;
            case "=":
                igual();
                break;
            case ",":
                decimal();
                break;
            case "+-":
                cambiarSigno();
                break;
            default:
                System.out.println("Entrada '" + input + "' inesperada");
        }

    }

    private void igual() {

        if(!operador2.isEmpty()) {

            double op1 = Double.valueOf(operador1);
            double op2 = Double.valueOf(operador2);
            String res = "";

            switch (operacion)
            {
                case "X":
                    res = String.valueOf(op1 * op2);
                    break;
                case "+":
                    res = String.valueOf(op1 + op2);
                    break;
                case "-":
                    res = String.valueOf(op1 - op2);
                    break;
                case "%":
                    res = String.valueOf(op1 / op2);
                    break;
            }

            System.out.println("Resultado -> " + operador1 + operacion + operador2 + "=" + res);

            operacion = "";
            operador2 = "";
            operador1 = res;

        }

    }

    private void decimal() {

        if(operador2.isEmpty())
            operador1 += ",";
        else
            operador2 += ",";

    }

    private void cambiarSigno() {

        double op = 0;

        if(operador2.isEmpty()) {
            op = Double.valueOf(operador1);
            op *= -1;
            operador1 = String.valueOf(op);
        }
        else {
            op = Double.valueOf(operador2);
            op *= -1;
            operador2 = String.valueOf(op);
        }

    }

    private void elevar() {

        double op = 0;

        if(operador2.isEmpty()) {
            op = Double.valueOf(operador1);
            op *= op;
            operador1 = String.valueOf(op);
        }
        else {
            op = Double.valueOf(operador2);
            op *= op;
            operador2 = String.valueOf(op);
        }

    }

    private void vaciarOperador() {

        if(operador2.isEmpty())
            operador1 = "";
        else
            operador2 = "";

    }

    private void vaciar() {
        operador1 = "";
        operador2 = "";
        operacion = "";
    }

    private void operador(int input) {
        input -= 48;
        System.out.println("operador->" + input);

        if(operacion.isEmpty())
            operador1 += input;
        else
            operador2 += input;

    }

    public String getDisplayAcumulado() {
        return operador1 + " " + operacion + " " + operador2;
    }

    public String getDisplayOperador() {
        if(operador2.isEmpty())
            return operador1;
        else
            return operador2;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
