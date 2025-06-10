public class QuickSort 
{
    

    public static void quickSort(int nums[], int si, int ei)
    {
        if(si >= ei)    return;

        int pivotIndex = partition(nums, si ,ei);
        quickSort(nums, si, pivotIndex-1);
        quickSort(nums, pivotIndex+1, ei);
    }

    public static int partition(int nums[], int si, int ei)
    {
        int i=si-1;
        int pivotValue = nums[ei];
        for(int j=si ; j<ei ; j++) // j<ei only kemke mare pivot ne loop pachi j swap karavvano chhe
        {
            if(nums[j] <= pivotValue)
            {
                i++;
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }

        i++;
        int t = pivotValue;
        nums[ei] = nums[i];
        nums[i] = t;

        return i;
    }

    public static void printNums(int nums[])
    {
        for(int i=0 ; i<nums.length ; i++)  System.out.print(nums[i]+ " ");
    }
    public static void main(String args[])
    {
        // int nums[] = {6, 3, 9, 8, 2, 5};
        // int nums[] = {6, 3, 9, 9, 5, 2, 8, 9, 3, 2, 3, -9};
        int nums[] = {2, 0, 1, 1, 2, 0};
        quickSort(nums, 0, nums.length-1);
        printNums(nums);
    }    
}
