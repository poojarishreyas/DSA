// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Arrays;
class Main{
 public static int[] maxsubaray(int[] nums){
     int total=nums[0];
     int max=nums[0];
     int startindex=0;
     int endindex=0;
     int tempstartindex=0;
     for(int j=1;j<nums.length;j++){
         total=total+nums[j];
         if(total<nums[j]){
             total=nums[j];
             tempstartindex=j;
         }
         if(total>max){
             max=total;
             endindex=j;
             startindex=tempstartindex;
             
         }
     }
     return Arrays.copyOfRange(nums,startindex,endindex+1);
 }
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int[] result=maxsubaray(nums);
        System.out.println(Arrays.toString(result));
    }
}