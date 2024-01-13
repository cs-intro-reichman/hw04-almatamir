public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String str = args[0];
        String ch = args[1];
        char chr = ch.charAt(0);
        System.out.println(capVowelsLowRest(str));
        System.out.println(camelCase(str));
        int arr[] = (allIndexOf(str, chr));
        System.out.print("{");
        for (int i=0; i< arr.length; i++)
        {
            System.out.print(arr[i]+",");
            if (i+1==arr.length)
            System.out.print(arr[i]+"}");
            
        }
        
        
        
    }

    public static String capVowelsLowRest (String string) {
        String news = "";
        String vowelsC ="AEUIO";
        String vowels ="aeuio";
        for (int i=0; i < string.length() ;i++)
        {
            char ch = string.charAt(i);
            if ( ((ch >= 'A') && (ch <= 'Z'))) // if its capital
            {
                if (vowelsC.indexOf(ch) == -1) // check if ch is is in vowelsC, if it isnt it changes
                {
                    char lowercaseChar = (char) (ch + ('a' - 'A')); // turns to small letters
                    news += lowercaseChar;
                }
                else if(vowelsC.indexOf(ch) != -1)
                {
                    news+= ch;
                }
            }
            else if (vowels.indexOf(ch) != -1) // check if ch is lower letter vowel, if it is it changes
                {
                    char uppercaseChar = (char) (ch + ('A' - 'a')); // turns to capital letters
                    news += uppercaseChar;
                }
            else news+= ch;
        }
        
        return news;
    }

    public static String camelCase (String string) {
        String news ="";
        char ch = ' ';
        String substring1 = "";
        for (int j=0; j < string.length(); j++) //in case of spaces
        {
            if (string.charAt(j) != ' ')
            {
                substring1 = string.substring(j-1);
                j=string.length();
            }
        }
        ch = substring1.charAt(0);
        if ( ((ch >= 'A') && (ch <= 'Z'))) //fixes first letter
                {
                    char lowercaseChar = (char) (ch + ('a' - 'A')); // turns to small letters
                    news += lowercaseChar;
                }
                else news += ch;

        
       
        for (int k = 1 ; k < substring1.length(); k++)
        {
            ch = substring1.charAt(k);
            if (substring1.charAt(k)== ' ')
            {
                ch = substring1.charAt(k+1);
                if ( ((ch >= 'A') && (ch <= 'Z'))) // if its capital
                {
                    news+= ch;
                }
                else 
                {
                   char uppercaseChar = (char) (ch + ('A' - 'a')); // turns to capital letters
                   news += uppercaseChar;
                   k++;
                }
            }
            else if ( ((ch >= 'A') && (ch <= 'Z'))) // if its capital
              {
                char lowercaseChar = (char) (ch + ('a' - 'A')); // turns to small letters
                news += lowercaseChar;
              }
             else news+= ch;                
            
            
            
        }
        return news;
    }

    public static int[] allIndexOf (String string, char chr) {
        int countch = 0;
        int place = 0;
        for (int i=0; i < string.length(); i++)
        {
            if (string.charAt(i)==chr)
            countch++;
        }
        int[] numbers = new int[countch];
        for ( int j=0; j< string.length(); j++)
        {
            if (string.charAt(j)==chr)
            {
                 numbers[place]= j;
                 place++;
            }
           
        }
        return numbers;
    }
}
