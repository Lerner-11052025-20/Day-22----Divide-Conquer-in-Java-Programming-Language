public class SortedAndRotatedArray 
{
    public static int indexWithLoop(int nums[], int key)
    {
        int i=0;
        int j=nums.length-1;
        
        while(i<=j)
        {
            int midIndex = i + (j-i)/2;
            int midValue = nums[midIndex];

            if(key == midValue)     return midIndex;
            else if(nums[i] <= midValue)
            {
                if(nums[i]<=key && key<=midValue)  j=midIndex-1;
                else    i=midIndex+1;
            }
            else // midValue <= nums[ei]  0<=2
            {
                if(midValue<=key && key<=nums[j])      i=midIndex+1;
                else    j=midIndex-1;
            }
        }
        
        return -1;
    }
    // public static int index(int nums[], int key, int si, int ei)
    // {
    //     if(si > ei)     return -1;

    //     int midIndex = si + (ei-si)/2;
    //     int midValue = nums[midIndex];

    //     if(key == midValue)     return midIndex;

    //     if(nums[si] <= midValue)
    //     {
    //         if(nums[si]<=key && key<=midValue)  return index(nums, key, si, midIndex-1);
    //         else    return index(nums, key, midIndex+1, ei);
    //     }
    //     else
    //     {
    //         if(midValue<=key && key<=nums[ei])      return index(nums, key, midIndex+1, ei);
    //         else    return index(nums, key, si, midIndex-1);
    //     }
    // }
    public static void main(String args[])
    {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        // System.out.println(index(nums, 0, 0, nums.length-1));
        System.out.println(indexWithLoop(nums, 0));
    }    
}
