import java.util.ArrayList;
import java.util.List;

//我们具体来看一个例子，比如3562这个数字
//
//使用第一种情况将其分解，将其排列组合可以选择的数字列出来
//
//4th 3th 2th 1th total
//0   0   0  1-9 9xA(9,0)
//0   0  1-9 0-9 9xA(9,1)
//0  1-9 0-9 0-9 9xA(9,2)
//使用第二种情况将其分解：
//
//4th 3th 2th 1th total
//1-2 0-9 0-9 0-9 2xA(9,3)
//3  0-4 0-9 0-9 5xA(8,2)
//3   5  0-5 0-9 6xA(7,1)
//3   5   6  0-1 2xA(6,0)
//3   5   6   2  1


public class ND {

    public int numDupDigitsAtMostN(int N) {
        return N - dp(N);
    }

    public int dp(int n) {
        List<Integer> digits = new ArrayList<>();  //存放每一位数字
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int k = digits.size();   //k表示总位数

        int[] used = new int[10];  //已经用了的数字
        int total = 0;

        for (int i = 1; i < k; i++) {  //第一种情况已解决
            total += 9 * A(9, i - 1);
        }  //total = 738

        for (int i = k - 1; i >= 0; i--) {
            int num = digits.get(i);

            for (int j = i == k - 1 ? 1 : 0; j < num; j++) {
                if (used[j] != 0) {
                    continue;
                }
                total += A(10 - (k - i), i);
            }

            if (++used[num] > 1) {
                break;
            }

            if (i == 0) {
                total += 1;
            }
        }
        return total;
    }

    public int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int A(int m, int n) {
        return fact(m) / fact(m - n);
    }

    public static void main(String[] args) {
        int n = 3562;
        ND nd = new ND();
        int res = nd.numDupDigitsAtMostN(n);
        System.out.println(res);;
    }
}
