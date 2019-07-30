package com.wulaobo.recursion;

//迷宫问题
public class MiGong {

    public static void main(String[] args) {
        //设置一个8行7列的二维数组 map
        int[][] map = new int[8][7];
        //约定 1表示墙,0表示可以走,2,表示已经走过,3表示回溯
        for(int i = 0;i<7;i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for(int i = 1;i<8;i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
//        System.out.println("初始化棋盘:");
//        for(int i = 0;i<8;i++) {
//            for(int j = 0;j<7;j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        setPath(map,1,1);
        System.out.println("棋子开始走了:");
        for(int i = 0;i<8;i++) {
            for(int j = 0;j<7;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    //棋子找的路径方法 map是地图,i 表示横坐标,j 表示纵坐标
    public static boolean setPath(int[][] map,int i,int j) {
        if(map[6][5]==2){  //通路已经找到
            return true;
        }
        if(map[i][j]==0) {
            map[i][j] = 2;
            if(setPath(map,i,j+1)) {  //向右走
                return true;
            }else if(setPath(map,i+1,j)) {  //向下走
                return true;
            }else if(setPath(map,i,j-1)) {  //向左走
                return true;
            }else if(setPath(map,i+1,j)) {  //向上走
                return true;
            }else{
                map[i][j]=3;
                return false;
            }
        }else{
            return false;
        }

    }


}
