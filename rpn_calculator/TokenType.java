package rpn_calculator;

public class TokenType {

        public static String tokenType(String operand) {

                switch (operand) {
                        case "0":
                                return "NUM";
                        case "1":
                                return "NUM";

                        case "2":
                                return "NUM";

                        case "3":
                                return "NUM";

                        case "4":
                                return "NUM";

                        case "5":
                                return "NUM";

                        case "6":
                                return "NUM";

                        case "7":
                                return "NUM";

                        case "8":
                                return "NUM";

                        case "9":
                                return "NUM";

                        case "-":
                                return "MINUS";

                        case "+":
                                return "PLUS";

                        case "*":
                                return "STAR";

                        case "/":
                                return "SLASH";

                        case "\n":
                                return "WHITE SPACE";

                        case " ":
                                return "WHITE SPACE";

                        default:
                                return "UNEXPECTED";

                }
        }
}
