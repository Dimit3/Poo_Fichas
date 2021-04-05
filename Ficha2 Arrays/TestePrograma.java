import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalDate;


public class TestePrograma {
    public static void main (String [] args) {
        Ficha2 f = new Ficha2();
        Scanner sc = new Scanner (System.in);


      /*   //1a
        System.out.print("Numero de inteiros a ler?:     ");
        int n = sc.nextInt();
        int [] arr;
        int valor = 0;
        arr = f.newArr(n);

        for (int i = 0; i < n; i++){
            System.out.print("Valor:     ");
            valor = sc.nextInt();
            arr = f.myFill(arr, i, valor);

        }

        int minimo = 0;
        minimo = f.myMin(arr);
        System.out.println("minimo = " + minimo);

        
        //1b
        System.out.print("Primeiro indice:     ");
        int i1 = sc.nextInt();

        System.out.print("Segundo indice:     ");
        int i2 = sc.nextInt();

        int [] val = f.array_entre(arr, i1, i2);
        String valores = Arrays.toString(val);
        System.out.println(valores);


        //1c
        int [] arr1;
        int [] arr2;

        System.out.print("Numero de inteiros a ler?(Arr1):     ");
        n = sc.nextInt();
        valor = 0;
        arr1 = f.newArr(n);

        for (int i = 0; i < n; i++){
            System.out.print("Valor:     ");
            valor = sc.nextInt();
            arr1 = f.myFill(arr1, i, valor);
        }

        System.out.print("Numero de inteiros a ler? (Arr2):     ");
        n = sc.nextInt();
        valor = 0;
        arr2 = f.newArr(n);

        for (int i = 0; i < n; i++){
            System.out.print("Valor:     ");
            valor = sc.nextInt();
            arr2 = f.myFill(arr2, i, valor);
        }

        int [] arrComuns;
        // System.out.println(Arrays.toString(arr1));
        arrComuns = f.arr_co(arr1,arr2);
        String arrCo = Arrays.toString(arrComuns);
        System.out.println(arrCo); */



        //2a
        /*
        int i;
        int j;
        int r = 0;
        
        for (i = 0; i < 5; i++){
            for (j = 0; j < 5; j++){
                System.out.println("aluno " + (i+1) + " disciplina " + (j+1));
                r = sc.nextInt();
                f.updateGrades(i, j, r);
            }
        } 
        
        
       System.out.println(f.showGrades());

        //2b

        int subject = 0;
        System.out.print("\n Disciplina (para calcular soma das notas):   ");
        subject = sc.nextInt(); 

        int r = 0;
        r = f.subjectAvarage(subject)*5;

        System.out.printf("\nSum of Subject %d is %d \n",subject,r);

        //2c


        int aluno = 0;
        System.out.print("\n Aluno (para calcular media):   ");
        aluno = sc.nextInt(); 

        r = f.alunoAvarage(aluno);

        System.out.printf("\nAvarage of student %d is %d \n",aluno,r);


        //2d

        subject = 0;
        System.out.print("\n Disciplina (para calcular media):   ");
        subject = sc.nextInt(); 
        
        r = 0;
        r = f.subjectAvarage(subject);
        
        System.out.printf("\nAvarage of Subject %d is %d \n\n",subject,r);

        //2e

        int ret[];
        ret = f.highestSubject();

        int i;
        for (i = 0; i < 5; i++){
            System.out.println("Subject " + i + " highest rank " + ret[i]);
        }
        
        //2f
        System.out.println();
        ret = f.lowestSubject();
        
        for (i = 0; i < 5; i++){
            System.out.println("Subject " + i + " lowest rank " + ret[i]);
        }


        //2g

        System.out.println();
        System.out.println("Notas acima de:   ");
        int h = sc.nextInt();

        ret = f.higherThan(h);

        System.out.println(Arrays.toString(ret) + "\n");


        //2h

        System.out.println(f.showGrades() + "\n");


        //2i

        int ind = 0;
        for (i = 0; i < 5; i++){
            r = f.subjectAvarage(i);
            System.out.println(i + " = " + r);
        }

        ind = f.highestAvarage ();
        System.out.println();
        System.out.println("Highest ind = " + ind);

         */
        


        
        //3a

        Ficha2 f3 = new Ficha2(10);

        System.out.println();
        f3.insereData(LocalDate.now());
        f3.insereData(LocalDate.of(2018, 8, 14));
        f3.insereData(LocalDate.of(2019, 2, 13));
        f3.insereData(LocalDate.of(2015, 10, 23));
        f3.insereData(LocalDate.of(2011, 8, 2));
        f3.insereData(LocalDate.of(2010, 7, 7));
        System.out.println(f3.showDates() + "\n");
        
        //3b
        System.out.println();
        LocalDate data;
        System.out.println("dia: ");
        int d = sc.nextInt();
        System.out.println("mes: ");
        int m = sc.nextInt();
        System.out.println("ano: ");
        int y = sc.nextInt();
        System.out.printf("Data mais proxima de %d:%d:%d : ",d,m,y);
        data = f3.dataMaisProxima(LocalDate.of(y, m, d));
        System.out.println(data);
        sc.close();

        //3c
        System.out.println(f3.showDates() + "\n");
    }

    
}