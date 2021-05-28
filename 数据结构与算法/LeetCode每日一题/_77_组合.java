package LeetCode每日一题;/* 2020/9/15 0:24 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77_组合 {//

    @Test
    public void t() {
        System.out.println(combine(4, 2));
    }

    private List<List<Integer>> list;
    private int n, k;

    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        this.k = k;
        this.n = n;
        if (n < k || k < 0) return list;
        tracking(1, new LinkedList());
        return list;
    }

    void tracking(int pos, LinkedList save) {
        if (save.size() == k) {
            list.add(new ArrayList<>(save));
            return;
        }
        for (int i = pos; i <= n; i++) {//难点
            save.add(i);//
            tracking(i + 1, save);
            save.removeLast();
        }
    }
}
