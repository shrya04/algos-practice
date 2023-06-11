package com.algo.practice;

public class TrappingRainWater {
    public static void main(String args[]) {
//        System.out.println(trap(new int[] {4,2,3}));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    private static int trap(int[] arr) {
        int ans = 0;
        int left =0;
        int right =left+1;
        int length = arr.length;
        while(arr[right] > arr[left]){
            left++;
        }
        right = left +1;
        while(right < length){
            if(arr[right]> arr[left]){
                while(right<length && arr[right]>arr[left]){
                    left++;
                    right++;
                }
            } else if(arr[right]<arr[left]) {
                int min = arr[left];
                int i=right-1;
                while(right < length && arr[right]<arr[left]){
                    min = Math.min(arr[right], min);
                    right++;
                    i++;
                }
                if(min<arr[left]){
                    int count =0;
                    if(right == length){
                        right--;
                    }
                    for(int a=left+1;a<right;a++){
                        count +=arr[a];
                    }
                    ans = ans + (Math.min(arr[left], arr[right]) * (right-left-1)) - count;
                    left=right;
                    right = left+1;
                } else {
                    break;
                }

//                if(right >= length){
//                    left ++;
//                    right = left+1;
//
//                } else {
//                    int count =0;
//                    for(int a=left+1;a<right;a++){
//                        count +=arr[a];
//                    }
//                    ans = ans + (Math.min(arr[left], arr[right]) * (right-left-1)) - count;
//                    left = right;
//                    right = left+1;
//                }


            } else {
                left++;
                right++;
            }
        }


        return ans;
    }
}

/*









 */
