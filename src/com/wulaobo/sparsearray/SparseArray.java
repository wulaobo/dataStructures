package com.wulaobo.sparsearray;

//二维数组转成稀疏数组，再转成二维数组
public class SparseArray {

    public static void main(String[] args) {
        //0表示没有子，1表示黑子，2表示蓝子
        int[][] arr1 = new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        arr1[4][4] = 2;

        //遍历二维数组
        for(int[] a:arr1) {
            for(int data:a){
                System.out.print("\t"+data);
            }
            System.out.println();
        }

        int sum=0;
        for(int[] a:arr1) {
            for(int data:a) {
                if(data!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum:"+sum);

        //二维数组转为稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = arr1.length;
        sparseArray[0][1]=11;
        sparseArray[0][2]=2;

        int count=0;  //count 记录棋子的个数
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                if(arr1[i][j]!=0) {
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=arr1[i][j];
                }
            }
        }

        System.out.println("遍历稀疏数组:");
        for (int[] c:sparseArray) {
            for(int ii:c){
                System.out.print("\t"+ii);
            }
            System.out.println();
        }

        //稀疏数组转为二维数组
        int[][] arr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int a= 1;a<sparseArray.length;a++) {
            arr2[sparseArray[a][0]][sparseArray[a][1]] = sparseArray[a][2];
        }

        System.out.println("稀疏数组转为二维数组:");
        for(int[] a:arr2) {
            for(int data:a){
                System.out.print("\t"+data);
            }
            System.out.println();
        }


    }

}
