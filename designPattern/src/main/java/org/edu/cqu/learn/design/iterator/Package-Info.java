package org.edu.cqu.learn.design.iterator;

/*
迭代器模式
1，什么是迭代器模式
2，迭代器模式有什么用
 */

/*
1，迭代器模式，本质上是用来遍历集合的，只是一种通用的集合遍历的方法
数组当然可以用索引位去遍历元素了，但是树能吗，肯定不能
所以，只能使用迭代器模式
2，迭代器模式就是用于集合迭代的


以后，我在设计结构的时候，就去实现迭代器接口
然后，去实现迭代器的功能
一般来说，都是集合去实现接口

比如这里的 Book 类，就是普通的业务对象类
这里的 BookShelf 类，就是业务对象的集合类
这里的 BookIterator 就是 BookShelf 实现可迭代器模式之后，再去实现迭代器接口方法的返回对象
Aggregate 就是可迭代的接口标志
 */