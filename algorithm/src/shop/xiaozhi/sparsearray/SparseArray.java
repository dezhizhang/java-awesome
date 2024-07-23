package shop.xiaozhi.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组11*11
        //0：表示没有棋子，1：表示黑子，2示不白子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        for(int[] row:chessArr) {
            for(int col:row) {
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }

        //1 将二维数组转换成稀疏数组
        //2 先遍历二维数组，得到非0数据个数
        int sum = 0;
        for(int i =0;i < chessArr.length;i++) {
            for(int j =0;j < chessArr[i].length;j++) {
                if(chessArr[i][j] !=0) {
                    sum++;
                }
            }
        }

        //3 创建对应的稀疏数组
        int spareArr[][] = new int[sum + 1][3];
        //4 给稀疏数赋值
        spareArr[0][0] = chessArr.length;
        spareArr[0][1] = chessArr.length;
        spareArr[0][2] = sum;

        int count = 0;

        for(int i =0;i < chessArr.length;i++) {
            for(int j =0;j < chessArr[i].length;j++) {
                if(chessArr[i][j] !=0) {
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                   spareArr[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("得到的稀疏数组");
        for(int[] row:spareArr) {
            for(int col:row) {
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }

        // 稀疏数组恢复成原始二维数组
        // 先读取稀疏数组的第一行，概据第一行的数据创建原始的二维数组
        // 在读取稀疏数组后几行的数据，并赋给原始二维数组即可
        int cheeseArr2[][] = new int[spareArr[0][0]][spareArr[0][1]];

        for(int i = 1;i < spareArr.length;i++) {
            cheeseArr2[spareArr[i][0]][spareArr[i][1]] =spareArr[i][2];
        }

        for(int[] row:chessArr) {
            for(int col:row) {
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }
    }
}
