public class MergeSort 
{
    
    public static void mergeSort(int nums[], int si, int ei)
    {
        // base case
        if(si >= ei)    return;

        //kaam ----> Divide kari didha 6 3 9 pachi 6 3 and 9 pachi ---> 6   3   9
        int midIndex = si + (ei-si)/2;
        mergeSort(nums, si, midIndex); // left
        mergeSort(nums, midIndex+1, ei); // right
        //conquer means have sort kari ne bhega karish
        merge(nums, si, midIndex, ei);
    }

    public static void merge(int nums[], int si, int midIndex, int ei)
    {
        // 3 6     and      9   &&&&&&&&&&&&     5 2        and      8
        // 0 1     and      2   &&&&&&&&&&&&     3 4        and      5
        
        // temp array banavvano
        int temp[] = new int[ei-si+1];

        // three iterator for three types of the arrays
        int i=si; // 0
        int j=midIndex+1; // 1+1 => j=2
        int k=0;

        while(i<=midIndex && j<=ei)
        {
            if(nums[i] <= nums[j])
            {
                temp[k] = nums[i];
                i++; k++;
            }
            else
            {
                temp[k] = nums[j];
                j++; k++;
            }
            //k++;
        }

        while(j<=ei)
        {
            temp[k] = nums[j];
            j++; k++;
        }

        while(i<=midIndex)
        {
            temp[k] = nums[i];
            i++; k++;
        }

        //finally merge into nums[] array
        for(k=0, i=si ; k<temp.length ; k++, i++)
        {
            nums[i] = temp[k];
        }
    }

    public static void printNums(int nums[])
    {
        for(int i=0 ; i<nums.length ; i++)  System.out.print(nums[i]+ " ");
    }
    public static void main(String args[])
    {
        int nums[] = {6, 3, 9, 9, 5, 2, 8, 9, 3, 2, 3, -9};
        mergeSort(nums, 0, nums.length-1);
        printNums(nums);
    }    
}
