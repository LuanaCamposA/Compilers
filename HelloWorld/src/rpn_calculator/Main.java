package rpn_calculator;

import rpn_calculator.RPN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*Scanner ler = new Scanner(System.in);
        String nome = ler.nextLine();*/

        String localDir = System.getProperty("user.dir");

        try{
            FileReader arq = new FileReader(localDir + "\\src\\rpn_calculator\\calculator");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String expression = "";
            while(linha != null){

                expression = expression + linha + " ";
                linha = lerArq.readLine();
            }
            System.out.printf("rpn exp %s\n", expression);
            arq.close();
            System.out.println("printing result ...");
            System.out.println(RPN.evaluate(expression));

        }catch (IOException e){
            System.err.printf("Erro na abertura do arquivo\n");
            e.getMessage();
        }

        System.out.println();
    }

}
