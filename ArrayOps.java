public class ArrayOps {
    public static void main(String[] args) {
        int[] numbers = {2,8,3,7,8};
        int[] numbers2 = {2,8,3,7,8, 88};
        System.out.println(findMissingInt(numbers));
        System.out.println(secondMaxValue(numbers));
        System.out.println(isSorted(numbers));
        System.out.println(containsTheSameElements(numbers, numbers2));
        
    }
    
    public static int findMissingInt (int [] array) {
        int sum= 0 ;
        int count = 0;
        for (int i=0; i<array.length;i++)
        {
            sum+=i;
        }
        sum+=array.length;
        for(int i=0; i< array.length;i++)
        {
            count+=array[i];
        }
        sum = sum - count;
        return sum;
    }

    public static int secondMaxValue(int [] array) {
        int max =0; 
        for (int i=0;i<array.length;i++)
        {
            if (max<array[i])
            max = array[i];
        }
        int newmax =0;
        for (int i=0;i<array.length;i++)
        {
            if (array[i] == max)
            array[i] = 0;
            if (newmax< array[i])
            newmax = array[i];
        }
        return newmax;
    }
    public static boolean inArray(int [] array, int num) {

        for(int i = 0; i < array.length; i++){

            if((array[i] == num)){

                return true;
            }
        }
        return false;
    }
    public static boolean containsTheSameElements(int [] array1,int [] array2) {

            for (int i = 0; i < array2.length; i ++){ 
                if(!(inArray(array1, array2[i]))){   
                    return false;
                }  
          }
          for (int i = 0; i < array1.length; i ++){ 
            if(!(inArray(array2, array1[i]))){   
                return false;
            }
        }
       return true;
        }
    public static boolean isSorted(int [] array) {
        int keep = array[0];
        if(keep <= array[1]) // going up
        {
            for(int i=1;i<array.length-1;i++)
            {
                keep = array [i];
                if ((keep <= array[i+1]))
                {
                    if (i+1 == array.length-1)
                    return true;
                }
                
            }
            
        }
        else if(keep >= array[1]) // going down
        {
            for(int i=1;i<array.length-1;i++)
            {
                keep = array [i];
                if ((keep >= array[i+1]))
                {
                    if (i+1 == array.length-1)
                    return true;
                }
                
            }
            
        }
        return false;
    }

}
