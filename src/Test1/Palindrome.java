package Test1;

public class Palindrome {
    public static void main(String[] args) {
        String jerry="71515";
        String Tom="";
         Tom+=jerry;
//         Tom+=jerry.charAt(0);
//        if(isPalindrome(Tom)){
//            System.out.println(Tom);
//        }
//       else {

           Tom=jerry;
            System.out.println(Tom);
            for (int i = jerry.length() / 2; i >=0 ; i--) {
                char c = jerry.charAt(i);
                Tom += c;
                if (isPalindrome(Tom))
                    break;
            }
            System.out.println(Tom);
        }

//        }
//
        public static boolean isPalindrome(String Tom){
            for(int j=0;j<Tom.length()/2;j++) {
                if(Tom.charAt(j)!=Tom.charAt(Tom.length() - j - 1)){
                    return false;
                }
            }
            return true;
        }
}

