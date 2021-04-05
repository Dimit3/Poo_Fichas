import java.time.LocalDate;
import java.lang.Math;
import java.util.Arrays;



public class Ficha2 {

    

    //1a
    public int[] newArr (int n){

        int []arr = new int [n];
        return arr;
    };

    public int[] myFill (int [] arr, int i, int n){
        arr[i] = n;
        return arr;
    }

    public int myMin (int [] arr) {
        int minimo = arr[0];

        for (int i = 0; i < arr.length; i++){
            if (arr[i] < minimo){
                minimo = arr[i];
            }
        }

        return minimo;
    }

    //1b
    public int[] array_entre(int [] arr, int i1, int i2)
    {
        int quantos = i2-i1+1;
        int retArray[] = new int[quantos];
        System.arraycopy(arr, i1, retArray, 0, quantos);
        return retArray;
    }


    //1c

    public int[] arr_co (int [] arr1, int [] arr2){
        
        int maxl = Math.max(arr1.length,arr2.length);
        int ret[] = new int[maxl];
        int k = 0;
        int l = 0;
        int f = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]){
                    for (l = 0; l < k; l++)
                        if (ret[l] == arr1[i]) f = 1;
                    if (f==0) {
                        ret[k] = arr1[i];
                        k++;
                    }
                    
                f = 0;
                }
            }
            
        }

        int ret2 [] = new int [k];
        System.arraycopy(ret, 0, ret2, 0, k);


        return ret2;


    }


    //2a

    private int[][] notasTurma = {{56, 87, 89, 42, 44}, {45, 23, 20, 57, 12}, {98, 87, 74, 88, 95}, {55, 47, 85, 98, 14}, {41, 28, 57, 74, 46}};
   

    public void updateGrades (int aluno, int disciplina, int nota)
    {
        notasTurma[aluno][disciplina] = nota;
    }

    public String showGrades ()
    {
        return (Arrays.deepToString(notasTurma));
    }

    //2b e 2d  (soma / media)

    public int subjectAvarage (int subject){
        int i = 0;
        int m = 0;

        for (i = 0; i < 5; i++){
            m += notasTurma[i][subject];
        }

        return (m/5);
    }

    //2c

    public int alunoAvarage (int aluno){
        int i = 0;
        int m = 0;

        for (i = 0; i < 5; i++){
            m += notasTurma[aluno][i];
        }

        return (m/5);
    }


    //2e 

    private int maxS (int s){
        int i;
        int max = -1;
        for ( i = 0; i < 5; i++){
            if (notasTurma[i][s] > max) max = notasTurma[i][s];
        }

        return max;
    }

    public int[] highestSubject (){
        int [] ret = new int [5];

        int i;
        for (i = 0; i < 5; i++){
            ret[i] = maxS(i);
        }

        return ret;
    }


    //2f

    private int minS (int s){
        int i;
        int min = 101;
        for ( i = 0; i < 5; i++){
            if (notasTurma[i][s] < min) min = notasTurma[i][s];
        }

        return min;
    }

    public int[] lowestSubject (){
        int [] ret = new int [5];

        int i;
        for (i = 0; i < 5; i++){
            ret[i] = minS(i);
        }

        return ret;
    }

    //2g

    public int[] higherThan (int h){
        int i,j;
        int arr[] = new int[25];
        int k = 0;


        for (i = 0; i < 5; i++){
            for(j = 0; j < 5; j++){
                if (notasTurma[i][j] > h){
                    arr[k] = notasTurma[i][j];
                    k++;
                }
            }
        }

        int ret[];
        ret = new int [arr.length];

        System.arraycopy(arr, 0, ret, 0, k);

        return ret;

    }

    //2i

    public int highestAvarage(){
        int i,j;
        int rMax = 0;
        int avarageMax = -1;
        int avarageNow = 0;

        for (i = 0; i < 5; i++){
            for (j = 0; j < 5; j++){
                avarageNow = subjectAvarage(j);
                if (avarageNow > avarageMax){
                    avarageMax = avarageNow;
                    rMax = j;
                }
            }
        }

        return rMax;
    }



    //3a
    // Ficha2 f3 = new Ficha2 (100)


    private LocalDate [] datas;
    private int i = 0;

    //contrutor 3a quando ficha2 for iniciado

    public Ficha2(){
        this.i = 0;
        this.datas = new LocalDate[10];
        //this.array = new int [10]; se tiver um array chamado array

    }

    public Ficha2 (int tamanho) {
        this.i = 0;
        this.datas = new LocalDate[tamanho];

    }


    public void insereData (LocalDate data){

        this.datas[i] = data;
        this.i++;

    }
    //3c
    public String showDates (){
        return (Arrays.toString(datas));
    }

    //3b 

    public int bissexto (int ano){
		
        if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)))
        {
			return 1;
		}
        else
        {
			return 0;
		}
    }

    public int toDias (LocalDate data){
        int day = data.getDayOfMonth();
        int month = data.getMonthValue();
        int year = data.getYear();
        int aux = 0;
        int i = 0;
        int ano = 0;

        for (i = 0; i < year; i++){
            if (bissexto(i)==1) ano = ano + 366;
            else ano = ano + 365;
        }

        if (month == 1) aux = 31;
        if (month == 2) aux = 31 + 28;
        if (month == 3) aux = 31 + 28 + 31;
        if (month == 4) aux = 31 + 28 + 31 + 30;
        if (month == 5) aux = 31 + 28 + 31 + 30 + 31;
        if (month == 6) aux = 31 + 28 + 31 + 30 + 31 + 30;
        if (month == 7) aux = 31 + 28 + 31 + 30 + 31 + 30 +31;
        if (month == 8) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31;
        if (month == 9) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30;
        if (month == 10) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30 + 31;
        if (month == 11) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30 + 31 + 30 ;
        if (month == 12) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30 + 31 + 30 + 31;

        ano = ano + aux + day;
        return ano;
    }


    public LocalDate dataMaisProxima (LocalDate dataTarget){
        int i = 0;
        LocalDate maisProx = datas[0];
        int minDias = Integer.MAX_VALUE;
        int diasTarget = toDias(dataTarget);
        int dif = Integer.MAX_VALUE;

        for (i = 0; i < (datas.length); i++){
            if (datas[i] == null) break;
            dif = Math.abs(diasTarget - toDias(datas[i]));
            if (dif < minDias){
                minDias = dif;
                maisProx = datas[i];
            } 

        }

        return maisProx;
    }
}
