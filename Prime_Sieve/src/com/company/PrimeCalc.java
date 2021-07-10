package com.company;

public class PrimeCalc{

    public static boolean sieveRet(long prime){
        if(prime == 2 || prime == 3){
            return true;
        }
        else if(prime%2 == 0 || prime == 1){
            return false;
        }
        else{
            boolean loop = true;
            boolean prim = true;
            int y = 3;
            double mid = Math.floor(prime/2);
            while(loop) {
                if(prime%y == 0){
                    loop = false;
                    prim = false;
                }
                else{
                    y+=2;
                    if(y>mid){
                        loop = false;
                    }
                }
            }
            return prim;
        }
    }

}
