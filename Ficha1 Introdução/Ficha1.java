import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ficha1
{
    public double celsiusParaFarenheit(double graus)
    {
        return graus * 1.8 + 32;
    }
    
    public int maximoNumeros (int a, int b)
    {
        if (a > b) return a;
        else return b;
    }
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
    
    public String diaDaSemana (int dia, int mes, int ano)
    {
        int inAno = ano;
        int aux = 0;
        ano = (inAno - 1900) * 365;
        ano = ano + ((inAno - 1900)/ 4);
        if (bissexto(inAno) == 1 && (mes == 1 || mes == 2))
        {
            ano = ano -1;
        }
        if (mes == 1) aux = 31;
        if (mes == 2) aux = 31 + 28;
        if (mes == 3) aux = 31 + 28 + 31;
        if (mes == 4) aux = 31 + 28 + 31 + 30;
        if (mes == 5) aux = 31 + 28 + 31 + 30 + 31;
        if (mes == 6) aux = 31 + 28 + 31 + 30 + 31 + 30;
        if (mes == 7) aux = 31 + 28 + 31 + 30 + 31 + 30 +31;
        if (mes == 8) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31;
        if (mes == 9) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30;
        if (mes == 10) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30 + 31;
        if (mes == 11) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30 + 31 + 30 ;
        if (mes == 12) aux = 31 + 28 + 31 + 30 + 31 + 30 +31 + 31 + 30 + 31 + 30 + 31;

        ano = ano + aux + dia;
        int resto = 0;
        resto = ano % 7;
       
        String[] dias = {"Domingo" , "Segunda" , "Terça", "Quarta" , "Quinta" , "Sexta", "Sabado"};
        
        return dias[resto];

 
    }


    public void tempoGasto ()
    {
        LocalTime time = LocalTime.now();
        int hour = time.getHour(); 
        int second = time.getSecond(); 
        int minute = time.getMinute(); 

        System.out.println ("iniciou em" + hour + ":" + minute + ":" + second );
        long fact = 1;

        for (int i=2;i <= 5000; i++){
            fact=fact*i;
            System.out.println(fact);
        }

        hour = time.getHour(); 
        second = time.getSecond(); 
        minute = time.getMinute();    

        System.out.println("Factorial de 5000: " + fact + "\n" + "Acabou em: " + hour +":"+ minute +":" + second);
        int tempoDeExec = 0;
        System.out.println("Demorou: " + tempoDeExec);
    }

}