import java.util.Scanner;

public class T200314 {

    public static int jump(int n) {
        if(n == 1) {
            //跳一个台阶只有一种跳法
            return 1;
        }
        if(n == 2) {
            //跳两个台阶有两种跳法
            return 2;
        }
        //跳多个台阶：
        //第一次跳一级，则有 n-1 种跳法
        //第一次跳两级，则有 n-2 种跳法
        //总数为(n-1) + (n-2) 种
        //为斐波那契数列
        return jump(n-1) + jump(n-2);
    }

    public static void main(String[] args) {
        //剑指offer：
        //青蛙跳台阶
        //一只青蛙一次可以跳上一个台阶，也可以一次跳上两个台阶
        //跳上n个台阶总共有多少种跳法
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = jump(n);
        System.out.println(ret);
    }

    public static void move(char pos1, char pos3) {
        System.out.print(pos1 + "->" + pos3 + " ");
    }

    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if(n == 1) {
            move(pos1, pos3);//A->C
            return ;
        }
        hanoi(n-1, pos1, pos3, pos2);
        //将n-1个盘子从A先通过C移至B
        //n-1：除底座最大盘子之外的全部盘子
        move(pos1, pos3);
        //将底座最大盘子从A移至C
        hanoi(n-1, pos2, pos1, pos3);
        //将B中盘子通过B移至C
        //转移完成
    }

    public static void main1(String[] args) {

        //psvm  主函数快捷键
        //sout  输出快捷键

        //汉诺塔游戏
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        hanoi(n, 'A', 'B', 'C');
        //n个盘子
        //A, B, C 三个底座
    }
}
