public class DivArrays {

    public DivArrays(){
        arrayA = new int[10];
        arrayB = new int[10];
    }
    
    private int[] arrayA;
    private int[] arrayB;

    public int[] getArrayA() {
        return arrayA;
    }

    public int[] getArrayB() {
        return arrayB;
    }

    public void setArrayA(int[] arrayA) {
        this.arrayA = arrayA;
    }

    public void setArrayB(int[] arrayB) {
        this.arrayB = arrayB;
    }
    //p=posicao
    public void setArrayANaPosicao(int valor, int pArray){
        validador(pArray, arrayA);
        arrayA[pArray] = valor;
    }
    //p=posição
    public void setArrayBNaPosicao(int valor, int pArray){
        validador(pArray, arrayB);
        arrayB[pArray] = valor;
    }
    //exceção
    public int calcula(int a, int b) throws ExcecaoDivisaoResultadoZero{
        int result = 0;
        try{
            result = a/b;
            if(result == 0){
                throw new ExcecaoDivisaoResultadoZero("A divisão tem resultado igual a zero");
            }
        }catch(ArithmeticException e){
            System.out.println("Não é possivel dividir um número por 0! Tente mais uma vez.");
        }
        
        return result;
    }

    public void calculaDivisaoArrays(){
        
        int [] resultDiv = new int [10];

        try{
            for(int i = 0; i < arrayA.length; i++){
                resultDiv[i] = calcula(arrayA[i], arrayB[i]);
            }
        }catch(ExcecaoDivisaoResultadoZero e){
            System.out.println(e.getMessage());

        }finally{
            for(int i = 0; i < arrayA.length; i++){
                System.out.println("Valor "+i+1+" do arrayA, arrayB e Resultado, respectivamente:"
                + arrayA[i]+","+arrayB[i]+","+resultDiv[i]);
            }
        }
    }

    private void validador(int posicaoValidar, int[] array){
        if(!((posicaoValidar >= 0) && (posicaoValidar <= array.length -1))){
            throw new IllegalArgumentException("Posição não existe no array. Por favor, tente de novo.");
        }
    }
}
