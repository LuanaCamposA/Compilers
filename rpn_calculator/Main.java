package rpn_calculator;

import rpn_calculator.RPN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*  Seleciona o arquivo do diretório */
        String localDir = System.getProperty("user.dir");

        try{
            FileReader arq = new FileReader(localDir + "\\src\\rpn_calculator\\calculator");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String expression = "";
            String tokenExpression = "";
            boolean unexpectedChar = false;
            /*  No loop, é executado um analisador léxico,
            para saber se só existem números e operadores no arquivo de entrada */
            /*  Caso seja verificado um input não esperado, o código não executa o parser */
            while(linha != null){
                    if(TokenType.tokenType(linha) == "UNEXPECTED"){
                        System.err.printf("Error: Unexpected character: %s\n", linha);
                        unexpectedChar = true;
                        linha = null;
                    }
                    else{
                        String tokenType = TokenType.tokenType(linha);
                        //expression = expression + linha + " ";
                        // token expression contém a tabela de tokens
                        tokenExpression = tokenExpression + Token.token(tokenType, linha) + "\n";
                        linha = lerArq.readLine();
                    }
            }
            arq.close();
            /* Se não for verificado nenhum input desconhecido, o interpreter, interpreta os tokens do tokenExpression
            * É exibida a tabela de tokens
            * E esta tabela interpretada é lida na RPN stacker
            *   */
            if(unexpectedChar == false){
                System.out.println(tokenExpression);
                String tokenExpressionAnalysis = TokenInterpreter.interpreter(tokenExpression);
                System.out.println(RPN.evaluate(tokenExpressionAnalysis));
                System.out.printf("Result: %2f\n", RPN.evaluate(tokenExpressionAnalysis) );
            }

        }catch (IOException e){
            System.err.printf("Erro na abertura do arquivo\n");
            e.getMessage();
        }

        System.out.println();
    }

}
