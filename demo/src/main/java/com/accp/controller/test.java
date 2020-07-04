package com.accp.controller;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arry[] =new int[]{10,9,6,7,13,20,4,3,2,1};
		int temp=0;
		for (int i = 0; i < arry.length; i++) {
			//System.out.println(arry[1]);
			for (int j = i; j < arry.length; j++) {
				if(!(arry[i]>arry[j])) {
					temp=arry[i];
					arry[i]=arry[j];
					arry[j] =temp;
				}
			}
		}
		for (int i = 0; i < arry.length; i++) {
			System.out.println(arry[i]+",");
		}
		
	}

}
