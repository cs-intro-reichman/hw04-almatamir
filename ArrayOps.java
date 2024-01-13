public class ArrayOps {
    public static void main(String[] args) {
        int[] numbers = {9, 8, 5, 7};
        System.out.println(findMissingInt(numbers));
        System.out.println(secondMaxValue(numbers));
        System.out.println(isSorted(numbers));
        
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
            if (array[i]!= max)
            {
                if (newmax < array[i])
                 {
                     newmax = array[i];
                 }
            }

        }
        return newmax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int count=0;
        for (int i=0; i<array1.length; i++)
        {
            for ( int j=0; j<array2.length;j++)
            {
                if(array1[i]==array2[j])
                {
                count++;
                j=array2.length;
                }

            }
            if (count >= array2.length)
            return true;
        }
        return false;
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
