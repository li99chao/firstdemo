package day7;

import java.util.Random;
import java.util.Scanner;

public class test9 {
    public static void main(String[] args) {
        //1.生成中奖号码
        System.out.println("----------------");
        System.out.print("双色球中奖号码是：");
        int[] brr = creatNumber();
        for (int i = 0; i < brr.length; i++) {
            System.out.print(brr[i] + " ");
        }
        System.out.println();
        System.out.println("----------------");
        //2.用户输入彩票号码（红球+蓝球）
        int[] userInputArr = userInputNumber();

        //3.判断用户的中奖情况
        //红球、蓝球
        int redCount = 0;
        int buleCount = 0;
        //红球中奖数
        for (int i = 0; i < userInputArr.length - 1; i++) {
            int redNumber = userInputArr[i];
            for (int j = 0; j < brr.length - 1; j++) {
                if (redNumber == brr[j]) {
                    redCount++;
                    break;
                }
            }
        }
        System.out.println("一共有" + redCount + "个红球号码一样");
        //蓝球中奖数
        int blueNumber = userInputArr[userInputArr.length - 1];
        if (blueNumber == brr[brr.length - 1]) {
            buleCount++;
        }
        if (redCount == 6 && buleCount == 1) {
            System.out.println("恭喜中得一等奖：10000万");
        } else if (redCount == 6 && buleCount == 0) {
            System.out.println("恭喜中得二等奖：500万");
        } else if (redCount == 5 && buleCount == 1) {
            System.out.println("恭喜中得三等奖：3000元");
        } else if (redCount == 4 && buleCount == 1 || redCount == 4 && buleCount == 0) {
            System.out.println("恭喜中得四等奖：200");
        } else if (redCount == 3 && buleCount == 1 || redCount == 2 && buleCount == 1) {
            System.out.println("恭喜中得五等奖：10元");
        } else if (redCount == 1 && buleCount == 1 || redCount == 0 && buleCount == 1) {
            System.out.println("恭喜中得六等奖：5元");
        } else {
            System.out.println("恭喜发财，谢谢惠顾");
        }


    }

    //2.创建一个方法用于生成用户购买的号码
    public static int[] userInputNumber() {
        //定义一个数组存储用户购买的号码
        int[] arr = new int[7];
        //键盘录入用户输入的号码
        Scanner sc = new Scanner(System.in);
        //生成红球号码
        for (int i = 0; i < 6; ) {
            System.out.println("第" + (i + 1) + "个红球的号码是：");
            int redNumber = sc.nextInt();
            //redNumber在1-33不重复
            if (redNumber >= 1 && redNumber <= 33) {
                if (!contains(arr, redNumber)) {
                    arr[i] = redNumber;
                    i++;
                } else {
                    System.out.println("当前输入的号码已经存在，请重新输入");
                }
            } else {
                System.out.println("输入的号码超出范围，请重新输入");
            }
        }
        //输入蓝球号码
        System.out.println("请输入蓝球的号码");
        while (true) {
            int blueNumber = sc.nextInt();
            //蓝球号码在1-16中选择
            if (blueNumber >= 1 && blueNumber <= 16) {
                arr[arr.length - 1] = blueNumber;
                break;
            } else {
                System.out.println("当前号码超出范围请重新输入");
            }
        }
        return arr;
    }


    //1.创建一个方法用于生成中奖号码
    public static int[] creatNumber() {
        //定义一个数组用于添加中奖号码
        int[] arr = new int[7];
        //产生随机数
        Random r = new Random();
        //生成红球号码
        for (int i = 0; i < 6; ) {
            int redNumber = r.nextInt(33) + 1;
            //把红球号码添加到数组中,红球号码不能重复
            //调用contains方法对红球去重添加
            if (!contains(arr, redNumber)) {
                arr[i] = redNumber;
                //移动索引
                i++;
            }
        }
        //生成蓝球
        int buleNumber = r.nextInt(16) + 1;
        //将蓝球添加到数组的最大索引中
        arr[arr.length - 1] = buleNumber;
        return arr;
    }


    //创建一个方法判断红球号码是否重复
    //返回true表示重复
    //返回false表示不重复
    public static boolean contains(int[] arr, int redNumber) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == redNumber) {
                return true;
            }
        return false;
    }

}







