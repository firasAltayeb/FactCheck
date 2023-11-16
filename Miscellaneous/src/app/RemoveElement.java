package app;

//    Given an integer array nums and an integer val, remove all occurrences
//    of val in nums in-place. The order of the elements may be changed.
//    Then return the number of elements in nums which are not equal to val.
public class RemoveElement {

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int removeElementVerbose(int[] nums, int val) {
        int boundary = nums.length - 1;
        int i = 0;
        while (i <= boundary) {
            if (nums[i] == val) {
                swap(nums, i, boundary);
                boundary -= 1;
            } else {
                i += 1;
            }
        }
        return i;
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

}
