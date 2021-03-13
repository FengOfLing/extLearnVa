package org.edu.cqu.learn.code.hl;

import java.util.ArrayList;

public class MyHashSet {


    //使用排序链表？ 重复不加入
    /** Initialize your data structure here. */
    ArrayList<Integer> alt;
    public MyHashSet() {
        alt = new ArrayList<>();
    }

    public void add(int key) {
        for (int i = 0; i < alt.size(); i++) {
            if( alt.get(i) == key){
                return;
            }else if( alt.get(i) > key){
                alt.add(i,key);
                return;
            }
        }
        alt.add(key);
        return;
    }

    public void remove(int key) {
        for (int i = 0; i < alt.size(); i++) {
            if( alt.get(i) == key){
                alt.remove(i);
            }else if( alt.get(i) > key){
                break;
            }
        }
        return;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for (int i = 0; i < alt.size(); i++) {
            if( alt.get(i) == key){
                return true;
            }
        }
        return false;
    }
}
