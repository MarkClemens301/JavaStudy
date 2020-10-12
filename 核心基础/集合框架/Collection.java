package 集合框架;/* 2020/10/13 0:37 */

import java.util.ArrayList;
import java.util.Collections;

public class Collection {//

    public static void main(String[] args) {
        ArrayList<Float> list = new ArrayList<>();
        list.add(12F);
        list.add(2.6F);
        list.add(2.566666F);
        list.add(199.5f);
        System.out.println(list);
        //Sort
        Collections.sort(list);
        System.out.println(list);
    }
}
