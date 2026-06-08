import java.util.Scanner;

public class Simplex{
    private String nomeMatriz;
    private double [][] matriz;
    private int linhas;
    private int colunas;
    private int colunaVariavelMaiorImpacto;
    private int linhaVariavelMenorImpacto;
    private int [] posicaoUmColunasBasicas;
    private int [] colunasBasicas;

    public Simplex(String nomeMatriz, int linhas, int colunas){
        this.nomeMatriz = nomeMatriz;
        this.linhas = linhas;
        this.colunas = colunas;
        this.colunaVariavelMaiorImpacto = 0;
        this.linhaVariavelMenorImpacto= 0;
        this.matriz = new double[linhas][colunas];
        this.posicaoUmColunasBasicas = new int[linhas];
        this.colunasBasicas = new int[linhas];
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
    public void verArrayInt(int[] posicaoUmColunasBasicas){
        for(int i = 0; i < posicaoUmColunasBasicas.length; i++) {
            System.out.printf("%d, ", posicaoUmColunasBasicas[i]);
        }
    }
    public void verArrayDouble(double[] arrayDouble){
        for(int i = 0; i < arrayDouble.length; i++) {
            System.out.printf("%.2f, ", arrayDouble[i]);
        }
    }
    public void verMatriz(double [][] matriz){
        for(int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%8.2f", matriz[i][j]);
            }
            System.out.println();
        }
    }
    public boolean possuiApenasPositivosNaUltimaLinha(double[][] matriz){
        for (int j = 0; j < matriz[0].length - 1; j++){
            if (matriz[matriz.length -1][j] < 0){
                return false;
            }
        }
        return true;
    }
    public void identificarColunasBasicas (double [][]matriz){
        colunasBasicas = new int[matriz[0].length];
        //Aqui eu vou armazenar a posição das minhas linhas básicas
        posicaoUmColunasBasicas = new int[matriz[0].length];

        //Vou verificar se a minha coluna é basica ou não
        for (int j = 0; j< matriz[0].length; j++){
            boolean colunaBasica = true;
            int posicaoUm = -1;
            int contadorDeUm = 0;
            for (int i = 0; i < matriz.length; i++){
                if(matriz[i][j] == 0 || matriz[i][j] == 1){
                    if (matriz [i][j] == 1){
                        posicaoUm = i;
                        contadorDeUm++;
                        if (contadorDeUm > 1){
                            colunaBasica = false;
                        }
                    }
                }
                else{
                    colunaBasica = false;
                    break;
                }
            }
            if(colunaBasica && posicaoUm != -1){
                posicaoUmColunasBasicas[j] = posicaoUm;
                colunasBasicas[j] = j;
            }
        }
    }
    public void primeiraVezDefinindoColunasBasicasENaoBasicas(double[][] matriz){
        //aqui eu crio um array que vai conter os elementos da linha "b". Eles são usados
        //para definirmos qual variável se tornará básica através do cálculo de qual numero
        //é menor influente na função objetivo. Vou negativá-los para eles voltarem ao "original"
        double [] elementosLinhaB = new double[matriz[0].length];
        double [] elementosFuncaoObjetivo = new double[3];
        for(int j = 0; j < matriz[0].length; j++){
            elementosLinhaB[j] = matriz[matriz.length - 1][j];
            if(j < 3) {
                elementosFuncaoObjetivo[j] = matriz[matriz.length - 1][j] * -1;
            }

        }
        //AQUI EU DESCUBRO QUAL VARIÁVEL VAI SE TORNAR BÁSICA ANALISANDO
        //QUAL É A VARIÁVEL DE MAIOR IMPACTO. PARA ISSO EU VOU NA FUNÇÃO
        //OBJETIVO E SUBSTITUO O VALOR DAS VARIÁVEIS POR "1", ASSIM A QUE
        //TIVER O MAIOR VALOR COMO RESULTADO SERÁ ESCOLHIDA COMO V.B
        double maiorNumero = elementosFuncaoObjetivo[0];
        for(int j = 0; j < elementosFuncaoObjetivo.length; j++){
            elementosFuncaoObjetivo[j] = elementosFuncaoObjetivo[j] * 1;
            if (elementosFuncaoObjetivo[j] > maiorNumero){
                maiorNumero = elementosFuncaoObjetivo[j];
                colunaVariavelMaiorImpacto = j;
            }
        }
        //AQUI EU VOU DESCOBRIR QUAL VARIÁVEL VAI DEIXAR DE SER BÁSICA
        //POIS AO DESCOBRIR QUAL VARIÁVEL É BÁSICA USAMOS OS ELEMENTOS
        //DA SUA COLUNA QUE FOI ESCOLHIDA COMO BÁSICA COMO DIVISORES DOS RESPECTIVOS ELEMENTOS DA """COLUNA""" B
        //OU SEJA, A ULTIMA COLUNA.
        double resultadoConta = 0;
        double menorNumero = matriz[0][matriz[0].length-1];
        for (int j = 0; j < matriz.length -1 ; j++ ){ //COLOQUEI O -1 POIS NÃO ERA PRA COMPARAR COM A ÚLTIMA LINHA
            resultadoConta = matriz[j][matriz[0].length - 1] / matriz[j][colunaVariavelMaiorImpacto] ;
            if (menorNumero > resultadoConta){
                menorNumero = resultadoConta;
                linhaVariavelMenorImpacto  = j;
            }
        }
    }
    public void definindoColunasBasicasENaoBasicas(double[][] matriz){
        double [] elementosLinhaB = new double[matriz[0].length];
        for(int j = 0; j < matriz[0].length; j++){
            elementosLinhaB[j] = matriz[matriz.length - 1][j];
        }
        for(int j = 0; j < elementosLinhaB.length - 1; j++){
            double menorNumero = 0;
            if (elementosLinhaB[j] < menorNumero){
                menorNumero = elementosLinhaB[j];
                colunaVariavelMaiorImpacto = j;
            }
        }
        double resultadoOperacaoColunaNaoBasica = 0;
            for (int i = 0; i < matriz.length; i++){
                double menorNumero = 0;
                if(matriz[i][colunaVariavelMaiorImpacto] >= 0){
                    resultadoOperacaoColunaNaoBasica = matriz[i][matriz[0].length - 1] / matriz[i][colunaVariavelMaiorImpacto];
                    if(menorNumero > resultadoOperacaoColunaNaoBasica){
                        menorNumero = resultadoOperacaoColunaNaoBasica;
                        linhaVariavelMenorImpacto = i;
                    }
                }
            }
    }
    public void basificacaoDoTablo(double[][] matriz){
        //NESSE MOMENTO COMEÇAREI O PROCESSO DE "BASIFICAÇÃO" DA MINHA
        //COLUNA, TRANSFORMANDO O ELEMENTO DA POSIÇÃO PIVÔ EM 1, E OS
        //DEMAIS EM 0. LEMBRANDO QUE EU MULTIPLICO TODOS OS ELEMENTOS
        //DA LINHA DO MEU PIVÔ. A LINHA INTEIRA SERÁ MODIFICADA.
        double divisor = matriz[linhaVariavelMenorImpacto][colunaVariavelMaiorImpacto];
        for (int i = 0; i < matriz[0].length; i++ ) {
            matriz[linhaVariavelMenorImpacto][i] = ( matriz[linhaVariavelMenorImpacto][i] * (1 / divisor));
        }
        System.out.println("MATRIZ inicial");
        verMatriz(matriz);
        for(int i = 0; i < matriz.length ; i++) {
            double multiplicador = (matriz[i][colunaVariavelMaiorImpacto] * -1) / matriz[linhaVariavelMenorImpacto][colunaVariavelMaiorImpacto];
            if( i == linhaVariavelMenorImpacto){
                continue;
            }
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = matriz[linhaVariavelMenorImpacto][j] * multiplicador + matriz[i][j];
                System.out.printf("Valor na coluna %d da linha %d: %.2f%n", j, i, matriz[i][j]);
            }
        }
        System.out.println("MATRIZ FINAL");
        verMatriz(matriz);
    }

    public void simplexBasico(double [][] matriz){
        //Primeiro eu vou printar a matriz antes das iterações
        int iteracoes = 0;
        System.out.printf("Quantidade de iterações: %d%n", iteracoes);
        //boolean jaBasificada = tabloJaBasificado(matriz);
        identificarColunasBasicas(matriz);
        verArrayInt(colunasBasicas);
        primeiraVezDefinindoColunasBasicasENaoBasicas(matriz);
        basificacaoDoTablo(matriz);
        iteracoes++;
        System.out.printf("Quantidade de iterações: %d%n", iteracoes);
        identificarColunasBasicas(matriz);
        verArrayInt(colunasBasicas);
        definindoColunasBasicasENaoBasicas(matriz);

//        do {
//            identificarColunasBasicas(matriz);
//            primeiraVezDefinindoColunasBasicasENaoBasicas(matriz);
//            basificacaoDoTablo(matriz);
//            iteracoes++;
//            System.out.printf("Quantidade de iterações: %d%n", iteracoes);
//        }while(jaBasificada ==false || iteracoes == 5);

    }

    public static void main(String[] args){
        double [][] matrizSimplex = {
                {1,1,1,1,0,0,40},
                {2,1,-1,0,1,0,20},
                {3,2,-1,0,0,1,30},
                {-2,-3,-1,0,0,0,0}
        };
        Simplex t1 = new Simplex("m1", 4, 8);
        //System.out.println(t1.matriz[0].length);
        System.out.println();
        t1.simplexBasico(matrizSimplex);
        //t1.preencherMatriz();
        //.verMatriz();
        
        
    }


}

