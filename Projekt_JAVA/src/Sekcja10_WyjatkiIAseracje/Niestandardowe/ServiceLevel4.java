package Sekcja10_WyjatkiIAseracje.Niestandardowe;

public class ServiceLevel4 {

    public double calculate(int var)
    {
        //jesli ServiceLevel4 wyrzucilby CheckedException, to jesli chcielibysmy obsluzyc go dopiero w mainie. trzeba by go przepychac przez wsyzstkie serwisy 4-3-2-1-main, dlatego lepiej tutaj Unchecked
        if(var==0)
        {
            throw new UncheckedException(var);
        }
        return var*1.5;
    }
}
