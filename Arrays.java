

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayClass {

	
	public static void main(String[] args) 
	{
		//implementation of Single dimensional array
		String[] arr2 = SingleDArray();
		System.out.println(arr2.length);
		
		//implementation of 2 dimensional array
		String[][] pp = MultiDArray();
		print2DArray(pp);		
	}	
	public static void SingleArray()	
	{		
		int[] ar = {10,20,30,10,20,30,40,50,60};
		int n =9;
		List<Integer> al = new ArrayList<Integer>(); 
		al.add(10); 
        al.add(20); 
        al.add(30); 
        al.add(40); 

		int result=0; 
		
		for(int i=0;i<n;i++) 
		{ 
			for(int j=i+1;j<n;j++) 
			{ 
				System.out.println(ar[i]);				
						
				if(ar[i]==ar[j]) 
				{ 
					
				ar=ArrayUtils.removeElement(ar,i); 
				ar=ArrayUtils.removeElement(ar,j);  
				result++;  
				} 
				System.out.println(ar.length); 
			} 
		} 		
		
		System.out.println(ar.length); 
	}
	
	public static void print2DArray(String[][] arr1)
	{
		System.out.println(arr1.length);
		System.out.println(arr1[0].length);
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr1[i].length;j++)
			{
				System.out.println(arr1[i][j]);
			}			
		}
		
	}
	public static String[][] MultiDArray()
	{
		String[][] strs = { {"hello","hi"},{"how","are"},{"you","hi"}};
		return strs;
	}
	public static String[] SingleDArray()
	{
		String[] strs = {"hello","hi"};
		return strs;
	}
}
