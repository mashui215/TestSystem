package hzp.test.pac;

import java.util.Random;

public class doselect {

	// 定义一个方法:可以产生一个指定大小的int数组
	public static int[] randomArray(int i) {
		int[] arr = new int[i];
		Random ran = new Random();
		for (int j = 0; j < i; j++) {
			int a = ran.nextInt(1000);
			arr[j] = a;
		}
		return arr;
	}

	// 接收一个int数组,将里面的数字*冒泡排序*:递减
	public static void bubbleSort(int[] arr) {
		int temp = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j] < arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
//  接收一个int数组用*选择排序法*递减排序
	public static void chooseSort(int[] arr){
		int temp = -1;
		for(int i = 0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length-1;j++){
				if(arr[i] < arr[j]){
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
//  简化选择排序,只排前k个数
	public static void mySort(int[] arr){
		int temp = -1;
		for(int i=0;i<arr.length/2-1;i++){
			for(int j=i+1;j<arr.length/2-1;j++){
				if(arr[i]<arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		int[] arr = randomArray(100);
		for(int i=0;i<arr.length-1;i++){
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
        System.out.println("-------------------------");
        
        long startTime1 = System.nanoTime();
        bubbleSort(arr);
        int k1= arr[arr.length/2-1];
        long endTime1 = System.nanoTime();
        System.out.println("第k个最大值为:"+k1);
        System.out.println("冒泡排序程序运行时间： "+(endTime1-startTime1)+"ns");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
        System.out.println("-------------------------");
    
        long startTime2=System.nanoTime();
        chooseSort(arr);
        int k2= arr[arr.length/2-1];
        long endTime2=System.nanoTime();
        System.out.println("第k2个最大值为:"+k2);
        System.out.println("选择排序程序运行时间： "+(endTime2-startTime2)+"ns");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
        System.out.println("-------------------------");
        
        
        long startTime3=System.nanoTime();
        mySort(arr);
        int k3= arr[arr.length/2-1];
        long endTime3=System.nanoTime();
        System.out.println("第k3个最大值为:"+k3);
        System.out.println("自定义排序程序运行时间： "+(endTime3-startTime3)+"ns");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
		
	}
	
}
