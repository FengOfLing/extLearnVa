package org.edu.cqu.learn.design.tempmethod;

/*
以前阅读 Tomcat 源码的时候，经常会发现，欸，居然抽象符类调用自己的抽象方法
然后方法之间又相互调用，特点就是这些方法基本上都是抽象的
为什么是抽象的，本质上就是要我们自己来实现这些方法
啊，真是很有用的方法

模板方法设计模式有啥用
就是父类统一提供方法，公有的方法，是不需要子类单独写一遍的
这个不难，但是看起来会很高级

这里为什么没有接口，因为接口不能被实例化，方法里面，用 this 你找不到类
编译这一关都过不了
 */