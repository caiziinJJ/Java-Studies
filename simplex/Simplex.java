import java.util.Scanner;

public class Simplex{
    private String nomeMatriz;
    private double [][] matriz;
    private int linhas;
    private int colunas;

    public Simplex(String nomeMatriz, int linhas, int colunas){
        this.nomeMatriz = nomeMatriz;
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new double[linhas][colunas];
    }

    public void criarMatriz(){
        for(int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                System.out.printf("Você está na linha %d, coluna %d. Digite o valor: %n", i+1, j+1);
                Scanner receba = new Scanner(System.in);
                double valorDigitado = receba.nextInt();
                this.matriz[i][j] = valorDigitado;
            }
        }
    }
    public void verMatriz(){
        for(int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.linhas; j++) {
                System.out.printf("%8.2f", this.matriz[i][j]);
            }
            System.out.println();
        }
    }

    public void simplexBasico(double [][] matriz){
        for(int i = 0; i < this.colunas; i++){ //Aqui vou achar o menor número de "b"
              
        }
    }

    public static void main(String[] args){
        System.out.println("Teste");
        Simplex t1 = new Simplex("m1", 4, 4);
        t1.criarMatriz();
        t1.verMatriz();
        
        
    }


}

