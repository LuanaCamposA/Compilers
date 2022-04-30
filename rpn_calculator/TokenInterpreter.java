package rpn_calculator;

public class TokenInterpreter {
    public static String interpreter(String expr) {

        String inputChar = "";
        String expression = expr;
        int i = 0;
        int endOfString;

        while (expression != null){
            endOfString = expression.indexOf("\n");
            if(expression.length() > 3){
                inputChar = inputChar + expression.substring(endOfString-2, endOfString - 1) + " ";
                expression = expression.substring(endOfString+1);
            }
            else{
                expression = null;
            }

        }

        inputChar = inputChar.substring(0, inputChar.length() - 1);
        return inputChar;
    }
}
