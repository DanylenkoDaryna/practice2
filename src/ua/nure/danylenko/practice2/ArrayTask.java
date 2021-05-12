package ua.nure.danylenko.practice2;

public class ArrayTask {


    public static void main(String[] args){

        //знайти максимальний добуток двох чисел у несортованому масиві

        System.out.println("---");
        //35
        int[] t1 = {5,3,2,5,7,0,1};
        //32
        int[] t2 = {-2,-1,-3,4,8,0};
        //200
        int[] t3 = {-20, -10, 3, 9, -8};

        int[] t4 = {-20, 10, 3, 9, 8};

        System.out.println(maximumProduct(t1));
        System.out.println(maximumProduct(t2));
        System.out.println(maximumProduct(t3));
        System.out.println(maximumProduct(t4));

    }

    private static int maximumProduct(int[] arr){
        int maxProd =0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++) {
               if(j==i){
                   continue;
               }else if(arr[i]*arr[j]>maxProd){
                   maxProd=arr[i]*arr[j];
               }
            }
        }
        return maxProd;
    }
}
