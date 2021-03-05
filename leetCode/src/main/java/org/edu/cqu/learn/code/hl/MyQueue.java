package org.edu.cqu.learn.code.hl;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> seq ;
    Stack<Integer> rev ;
    int deletenum = 0;//已经从rev移除的个数
    /** Initialize your data structure here. */
    public MyQueue() {
        seq = new Stack<>();
        rev = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        seq.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if( !rev.isEmpty()){
//            deletenum++;
            return rev.pop();
        }else{
            trans();
            if( rev.isEmpty()){
                return 0;
            }
            return rev.pop();
        }
    }

    private void trans(){
        if(rev.isEmpty()){
            //需要从seq里面倒腾
            while(!seq.isEmpty()){
                rev.push( seq.pop());
            }
//            while(deletenum > 0){
//                rev.pop();
//                deletenum--;
//            }
        }
    }

    /** Get the front element. */
    public int peek() {
        if( !rev.isEmpty()){
            return rev.peek();
        }else{
            trans();
            return rev.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if( rev.isEmpty()){
            trans();
            return rev.isEmpty();
        }else{
            return false;
        }
    }
}
