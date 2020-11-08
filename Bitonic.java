/*
Bitonic array has an increasing sequence followed by decreasing sequence.
1.Find bitonic point
2.Find the index of the value with binary search (array is somehow sorted since its bitonic)
*/
import java.util.Scanner;
public class Bitonic{

    public static int Bitonicpoint(int array1[],int arraySize,int low,int high) //Returns Bitonic point
    {
        int point; 
     
        point = (low + high) / 2; 
        if(array1[point-1]<array1[point] && array1[point]>array1[point+1]){
         
                return point;         
        }
         else   if (array1[point] > array1[point - 1] && array1[point] < array1[point + 1]) { 
               return Bitonicpoint(array1, arraySize, point, high); 
            }
             else    if (array1[point] < array1[point - 1] && array1[point] > array1[point + 1]) { 
                    return Bitonicpoint(array1, arraySize, low,point); 
                } 
            
        return point;
        
    }
    
    public static int increasingSequence(int array1[],int low, int high,int value)
    {
    
    while(low<=high)
    {
        int mid= low + (high-low)/2; //Low is not always 0
    
    if(array1[mid]==value)
    {
         return mid;
    }
    else if(array1[mid]>value)
    {
    high=mid-1;
    }
    else if(array1[mid]<value)
    {
        low=mid+1;
    }
    }
    return -1;
    }
    
    
    public static int decreasingSequence(int array1[],int low, int high, int value)
    {
        while(low<=high)
    {
        int mid= low + (high-low)/2; //Low is not always 0
    
    if(array1[mid]==value)
    {
         return mid;
    }
    else if(array1[mid]<value)
    {
    high=mid-1;
    }
    else if(array1[mid]>value)
    {
        low=mid+1;
    }
    }
    return -1;
    }
    
    
    
    
    public static int Searchvalue(int array1[],int arraySize, int value,int bitonicpt)
    {
    
    if(value>array1[bitonicpt])
    {
        return -1;
    }
    
    else if(array1[bitonicpt]==value)
    {
    return bitonicpt;
    }
    
    else {
     int index= increasingSequence(array1, 0, bitonicpt-1, value);
     if(index!=-1)
       return index;
         }
    
        return decreasingSequence(array1, bitonicpt+1,arraySize-1, value);
        
    }
    
    
    public static void main(String[] args) 
    {
     int a[] = {-100,-76,10,20,50,100,91,-10};     // Bitonic array created 
System.out.println("Please enter the value that you want to scan: ");
     Scanner scs= new Scanner(System.in);
     
     int v = scs.nextInt();                             //Let's find if v is in the following array!
    int Size=a.length;
     int h=Size-1;                         //highest index in the following array
     int l = 0;  
     int p;              
     p = Bitonicpoint(a,Size,l,h);
    System.out.println("The bitonic point is in the following index: "+ p);
     int index;
     index=Searchvalue(a,Size,v,p);
     System.out.println("The value " + v + " is found in the index: "+ index);
    }
    }
