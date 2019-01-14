package hzp.test.pac;

import java.util.Random;

public class doselect {

	// ����һ������:���Բ���һ��ָ����С��int����
	public static int[] randomArray(int i) {
		int[] arr = new int[i];
		Random ran = new Random();
		for (int j = 0; j < i; j++) {
			int a = ran.nextInt(1000);
			arr[j] = a;
		}
		return arr;
	}

	// ����һ��int����,�����������*ð������*:�ݼ�
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
	
//  ����һ��int������*ѡ������*�ݼ�����
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
	
//  ��ѡ������,ֻ��ǰk����
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
        System.out.println("��k�����ֵΪ:"+k1);
        System.out.println("ð�������������ʱ�䣺 "+(endTime1-startTime1)+"ns");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
        System.out.println("-------------------------");
    
        long startTime2=System.nanoTime();
        chooseSort(arr);
        int k2= arr[arr.length/2-1];
        long endTime2=System.nanoTime();
        System.out.println("��k2�����ֵΪ:"+k2);
        System.out.println("ѡ�������������ʱ�䣺 "+(endTime2-startTime2)+"ns");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
        System.out.println("-------------------------");
        
        
        long startTime3=System.nanoTime();
        mySort(arr);
        int k3= arr[arr.length/2-1];
        long endTime3=System.nanoTime();
        System.out.println("��k3�����ֵΪ:"+k3);
        System.out.println("�Զ��������������ʱ�䣺 "+(endTime3-startTime3)+"ns");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
		
	}
	
}
