
class Solution {
    public int maximumSum(int[] arr) {
        int nodelete = arr[0];
        int one_delete = 0;
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int prevnodelete = nodelete;

            nodelete = Math.max(
                prevnodelete + arr[i],
                arr[i]
            );

            one_delete = Math.max(
                prevnodelete,
                one_delete + arr[i]
            );

            max = Math.max(max,
                Math.max(nodelete, one_delete));
        }

        return max;
    }
}
