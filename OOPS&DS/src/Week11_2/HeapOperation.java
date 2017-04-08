package Week11_2;

public class HeapOperation {
	

	private int minHeap[];
	private int pos;
	private int size;
	
	HeapOperation(int l)
	{
		size=l;
		pos=0;
		minHeap=new int[size+1];
	}
	
	public void create(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			insert(arr[i]);
		}
	}
	
	public void insert(int n)
	{
			if(pos==0){
				minHeap[pos+1]=n;
				pos= 2;
			}
			else
			{
				minHeap[pos++]=n;
				finalise();
			}
				
	}
	
	public void finalise(){
		int pos2 = pos-1;
		while(pos2>0 && minHeap[pos2/2]>minHeap[pos2]){
			int y = minHeap[pos2];
			minHeap[pos2]=minHeap[pos2/2];
			minHeap[pos2/2] = y;
			pos2 = pos2/2;
		}
	}
	
	void MaxHeap(int arr[], int i, int n)
	{
	    int l = 2*i + 1;
	    int r = 2*i + 2;
	    int largest = i;
	    if (l < n && arr[l] > arr[i])
	        largest = l;
	    if (r < n && arr[r] > arr[largest])
	        largest = r;
	    if (largest != i)
	    {
	        int tmp=arr[i];
	        arr[i]=arr[largest];
	        arr[largest]=tmp;
	        
	        MaxHeap(arr, largest, n);
	    }
	}
	 
	void convertMaxHeap(int n)
	{
	    for (int i = (n-2)/2; i >= 0; --i)
	        MaxHeap(minHeap, i, n);
	}
	
	public void display(){
		for(int i=1;i<minHeap.length;i++){
			System.out.print(" " + minHeap[i]);			
		}
		System.out.println("");
	}
}
