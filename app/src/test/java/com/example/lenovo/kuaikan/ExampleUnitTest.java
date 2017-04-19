package com.example.lenovo.kuaikan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    public static void main(String[] args) {

        int s[] = {9,3,2,7,1,5,9,12,6,19,};
        int[] afterSort = fastSort(s, 0, 9);

    }

    /**
     * 1.先从数列中取一个基准数
     * 2.分区：将比这个数大的放右边，小的放左边
     * 3.对左右区间重复第2步，直到各区间只有一个数
     */
    private static int[] fastSort(int s[], int left, int right){
        if (left < right)
        {
            int i = left, j = right, x = s[left];
            while (i < j) {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;

            fastSort(s, left, i - 1);

            fastSort(s, i + 1, right);
        }
        return s;
    }
}
