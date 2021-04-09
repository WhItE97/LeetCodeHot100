package _23_合并k个升序链表;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {1,3,2,5,4};
		MergeSort s = new MergeSort();
		s.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void sort(int[] arr) {
		mergeSort(arr,0,arr.length-1);
	}
	
	public void mergeSort(int[] arr,int start,int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
	}
	
	public void merge(int[] arr,int start,int mid,int end) {
		int[] tmp = new int[end-start+1];
		int index = 0;//tmp的下标
		int l = start;
		int r = mid+1;
		while(l<=mid&&r<=end) {
			if(arr[l]<arr[r]) {
				tmp[index] = arr[l];
				l++;
			}
			else {
				tmp[index] = arr[r];
				r++;
			}
			index++;
		}
		while(l<=mid) {
			tmp[index] = arr[l];
			l++;
			index++;
		}
		while(r<=end) {
			tmp[index] = arr[r];
			r++;
			index++;
		}
		//把tmp写回去
		for(int i=0;i<tmp.length;i++) {
			arr[start+i] = tmp[i];
		}
	}
}
