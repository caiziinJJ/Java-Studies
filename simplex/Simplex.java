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

    public void preencherMatriz(){
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
        //Primeiro eu vou printar a matriz antes das iterações
        int iteracoes = 0;
        System.out.printf("Quantidade de iterações: %d%n", iteracoes);
        //Aqui eu vou identificar as minhas colunas básicas
        int [] posicoesVariaveisBasicas = new int[0];
        int contadorColunasBasicas = 0;
        for (int j = 0; j< matriz[0].length; j++){
            boolean colunaBasica = true;
            int posicaoUm = -1;
            for (int i = 0; i < matriz.length; i++){
                if(matriz[i][j] == 0 || matriz[i][j] == 1){
                    if (matriz [i][j] == 1){
                        posicaoUm = i;
                    }
                }
                else{
                    colunaBasica = false;
                    break;
                }
            }
            if(colunaBasica && posicaoUm != 0){
                contadorColunasBasicas++;
            }
        }
        System.out.printf("Quantidade de colunas básicas: %d%n",contadorColunasBasicas);
        //aqui eu crio a variável que armazena o menor número da linha "b"
        double menorNumeroArray = 0;
        //aqui eu armazeno a coluna onde encontramos o número mais negativo
        int posicaoColunaInferior = 0;
        //aqui eu crio um array que vai conter os elementos da linha "b". Eles são usados
        //para definirmos qual variável se tornará básica através do cálculo que eu esqueci
        //o nome. Vou negativá-los para eles voltarem ao "original"
        double [] elementosFuncaoMae = new double[matriz[0].length];
        for(int j = 0; j < matriz[0].length; j++){
           elementosFuncaoMae[j] = matriz[0][j];
           for(int i = 0; i < elementosFuncaoMae.length ; i++){
               elementosFuncaoMae[i] = elementosFuncaoMae[i] * - 1;
           }
        }
        for (int i = 0; i < elementosFuncaoMae.length; i++){
            System.out.printf("%8.2f", elementosFuncaoMae[i]);
        }
        /*
        for(int j = 0; j < this.matriz[0].length; j++){
            if(menorNumeroArray > matriz[matriz.length - 1][j]){
                menorNumeroArray = matriz[matriz.length - 1][j];
                posicaoColunaInferior = j;
            }
        }

         */
    }

    public static void main(String[] args){
        double [][] matrizSimplex = {
                {1,1,1,1,0,0,0,40},
                {2,1,-1,0,1,0,0,20},
                {3,2,-1,0,0,1,0,30},
                {-2,-3,-1,0,0,0,1,0}
        };
        Simplex t1 = new Simplex("m1", 4, 8);
        //System.out.println(t1.matriz[0].length);
        System.out.println();
        t1.simplexBasico(matrizSimplex);
        //t1.preencherMatriz();
        //.verMatriz();
        
        
    }


}

