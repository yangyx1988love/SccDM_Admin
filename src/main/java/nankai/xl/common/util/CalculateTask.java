package nankai.xl.common.util;

import java.io.*;
import java.util.concurrent.CountDownLatch;
public class CalculateTask extends Thread {
    private int[][] A;
    private int[][] B;
    private int index;
    private int gap;
    private int[][] result;
    private CountDownLatch countDownLatch;

    public CalculateTask(int[][] A, int[][] B, int index, int gap, int[][] result, CountDownLatch countDownLatch) {
        this.A = A;
        this.B = B;
        this.index = index;
        this.gap = gap;
        this.result = result;
        this.countDownLatch = countDownLatch;
    }

    // 计算特定范围内的结果
    public void run() {
        // TODO Auto-generated method stub
        for (int i = index * gap; i < (index + 1) * gap; i++)
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++)
                    result[i][j] += A[i][k] * B[k][j];
            }
        // 线程数减1
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        // 声明和初始化
        long startTime;
        long endTime;
        int row_A = 80000;
        int col_A = 1000;
        int col_B = 1000;
        int[][] A = new int[row_A][col_A];
        int[][] B = new int[col_A][col_B];
        //存放并行计算结果
        int[][] parallel_result = new int[A.length][B[0].length];
        //存放串行计算结果
        int[][] serial_result = new int[A.length][B[0].length];
        //子线程数量
        int threadNum = 50;
        //子线程的分片计算间隔
        int gap = A.length / threadNum;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        // 为A和B矩阵随机赋值
        for (int i = 0; i < row_A; i++)
            for (int j = 0; j < col_A; j++) {
                A[i][j] = (int) (Math.random() * 100000);
            }
        for (int i = 0; i < col_A; i++)
            for (int j = 0; j < col_B; j++) {
                B[i][j] = (int) (Math.random() * 100000);
            }
        // 并行计算
        startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            CalculateTask ct = new CalculateTask(A, B, i, gap, parallel_result, countDownLatch);
            ct.start();
        }
        countDownLatch.await();
        endTime = System.currentTimeMillis();
        System.out.println("并行计算开始时刻:" + (startTime));
        System.out.println("并行计算结束时刻:" + (endTime));
        System.out.println("并行计算运行时间:" + (endTime - startTime));

        // 串行计算
        startTime = System.currentTimeMillis();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++)
                    serial_result[i][j] += A[i][k] * B[k][j];
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("串行计算开始时刻:" + (startTime));
        System.out.println("串行计算结束时刻:" + (endTime));
        System.out.println("串行计算运行时间:" + (endTime - startTime));
//        for (int i = 0; i <parallel_result.length ; i++) {
//            for (int j = 0; j <parallel_result[0].length ; j++) {
//                System.out.print(parallel_result[i][j]+" ");
//            }
//            System.out.println();
//        }

//        File file = new File("D:\\hs_hbnetmonitordb2.bak");
//        BufferedReader reader = null;
//        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
//            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
//            String tempString = null;
//            int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
    }
}

