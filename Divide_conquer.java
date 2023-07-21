public class Divide_conquer {
    
    public static void main(String[] args){
        int arr[] = {4,5,6,7,0,2};
        
   /*    merge_sort(arr, 0, arr.length-1);
        print(arr); */
   /*    quickSort(arr, 0, arr.length-1);
        print(arr); */
   int k=  rotated_sort(arr, 6, 0, arr.length-1);
  System.out.println(k);
    }
    public static void print(int arr[]){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        
    }

    public static void merge_sort(int arr[],int si,int end){
        if(si>=end){
            return;
        }
        int mid = (end+si)/2;
        merge_sort(arr,si,mid);
         merge_sort(arr, mid+1, end);
         merge(arr ,si,mid,end);
    }
    
    public static void merge(int arr[],int si,int mid,int end){
        int i= si;
        int j = mid+1;
        int k = 0;
        int temp[] = new int[end-si+1];
     while(i<=mid&&j<=end){
        if(arr[i]<arr[j]){
            temp[k]=arr[i];
            i++;
        }else{
            temp[k]=arr[j];
            j++;
        }
        k++;
     }

     while(i<=mid){
      temp[k++]=arr[i++];
     }

     while(j<=end){
        temp[k++]=arr[j++];
     }

     //copy to orginal
     for(k=0 ,i=si;k<temp.length;k++,i++){
        arr[i]=temp[k];
     }


    }

    public static void quickSort(int arr[],int si,int end) {
        if(si>=end){
            return;
        }

        int pIDX = partition(arr,si,end);
     quickSort(arr, si, pIDX-1);
     quickSort(arr, pIDX+1, end);
    }

    public static int partition(int arr[],int si,int end) {
        int pivot = arr[end];
        int j = si-1;

        for(int i=si;i<=end;i++){
            if(arr[i]<pivot){
                j++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        j++;
        int temp = arr[end];
        arr[end] = arr[j];
        arr[j] = temp;

return j;
    }

    public static int rotated_sort(int arr[],int key,int si,int ei) {

        int mid = (si+ei)/2;
        if(key == arr[mid]){
            return mid;
        }
        //case 1 key on l1
        if(key >arr[si]){
            return rotated_sort(arr, key, si, mid-1);
        }//case 2 key on 2
        else if(key<arr[si]){
         return rotated_sort(arr, key, mid+1, ei);
        }else{
            return -1;
        }

        

        
    }
}
