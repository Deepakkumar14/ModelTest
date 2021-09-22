package Test1;

public class ContiguousSubArray {
    public static void main(String[] args) {
        int sum=15;
        int[] array={1,2,3,4,5,6,7,8,9,10};
        int i;
        int j=0;
        for( i=0;i<array.length;i++){
            int total=array[i];
            for(j=i+1;j<array.length;j++) {
                if (total+array[j]<= sum) {
                    total+=array[j];
                }else
                    break;
            }
            if(total==sum) {
                break;
            }
        }
        System.out.println(i+1);
        System.out.println(j);
    }
}
