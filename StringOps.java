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
        boolean stop = true;
        String newString ="";
        int i;
        // SKIP FIRST SPACES
        for (i=0; i < string.length(); i++) //in case of spaces
        {
            if (string.charAt(i) != ' ')
                break;
        }
        char ch = string.charAt(i);

        // System.out.println(string.substring(j));
        if ( ((ch >= 'A') && (ch <= 'Z'))) //fixes first letter
                {
                    char lowercaseChar = (char) (ch + ('a' - 'A')); // turns to small letters
                    newString += lowercaseChar;
                }
        else newString += ch;
        boolean spaceOn = false;
        int index = i + 1;

        while (index < string.length()) {
            if (string.charAt(index) == ' ') {
                spaceOn = true;
                index++;
                continue;
            }

            ch = string.charAt(index);
            if (spaceOn) {
                // turn now to big letter

                newString += toUpp(ch);
            } else {
                newString += toLow(ch);
            }

            spaceOn = false;
            index++;
        }
        return newString;

        
    }
    public static char toUpp(char ch) {
        char uppercaseChar = ch; // Default to the original character if not a lowercase letter
    
        if (ch >= 'a' && ch <= 'z') {
            uppercaseChar = (char) (ch + ('A' - 'a')); // Convert to uppercase
        }
    
        return uppercaseChar;
    }
 
    public static char toLow(char ch) {
        char lowercaseChar = ch; // Default to the original character if not an uppercase letter
    
        if (ch >= 'A' && ch <= 'Z') {
            lowercaseChar = (char) (ch + ('a' - 'A')); // Convert to lowercase
        }
    
        return lowercaseChar;
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
