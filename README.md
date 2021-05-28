JavaStudy <JavaLearn>
---

一个学习与复习JAVA相关编程知识的Repos.
刷题Repos, 2021继续加油

Create by Mark Clemens, a java learner and user.

# 目录 <Contents>

[TOC]

---

# Intro
A project for beginners to learn Java.

## HelloWorld

- [HelloWorld.java](./基础语法/Hello/HelloWorld.java)
- [HelloWorldJava.java](./基础语法/Hello/HelloWorldJava.java)
- [ScannerInput.java](./基础语法/Hello/ScannerInput.java)
- [...](./基础语法/Hello)


Java编程第一步：HelloWorld程序

在IDEA或者记事本中编辑代码，**[HelloWorld.java](./基础语法/Hello/HelloWorld.java)**

**CMD调出命令行，执行如下：**

- 生成 *.class* 文件: javac HelloWorld.java
- 执行Java程序: java HelloWorld.class
- 可看到命令行中打印出“This is a Java Program”

执行完成。

...

## 文件结构 <Files Structure>

未同步更新此目录结构...

```bash 2020-08
README.md
基础语法
    Hello
    target
    Test
    工具类
    排序算法
多线程
    多线程.原子类
数据结构与算法
    排序
    数据结构
    算法
核心基础
设计模式
    设计模式.A创建型.DM01_单例模式
```

```bash
D:.
├─.idea
│  └─inspectionProfiles
├─BasicGrammar
│  ├─Hello
│  └─工具类
└─ClassOut
    └─production
        └─BasicGrammar
            ├─Hello
            └─工具类
```

---

# Java基础

<Remains to be updated.>

## Java语言

## 面向对象

## 集合框架

## Java8新特性

## JVM与性能调优


--- 

# 多线程与并发

## 并发理论

## 线程的创建方式

## 锁

## 线程池、参数


---

# 数据库

## SQL语句

## 索引、数据结构

## 事务

## 慢查询识别与优化

---

# 操作系统

这部分暂时不全，只是记录了近期了解的知识点。

## 内存管理

## 进程的通信方式

## 线程的通信方式

## 进程的上下文切换

## IO多路复用

## 进程和线程

- 进程 Process
- 线程 Thread
- 进程的调度

## 内存管理

- 虚拟内存
- 分段
- 分页
- 多级页表
- 段页式内存管理
- Linux内存管理
  - 页式内存管理

---

# 计算机网络

## OSI参考模型

## TCP\UDP\HTTP(S)

## 网络编程

---

# 学习资源

## 网络资源

- Cyc2018/CS-Note
- Aobing/JavaFamily
- NowCoder
- 负雪明烛 算法模板

--

# 工具

Version Control System

## VCS版本控制

- 红色，未加入版本控制
- 绿色，版本控制，暂未提交
- 蓝色，版本控制，已提交，有改动
- 白色，版本控制，已提交，无改动
- 灰色，忽略的文件

## Git中删除.idea 文件夹

- echo .idea >> .gitignore
- git rm --cached -r .idea
- git commit -am "remove .idea"
- git push

## Git本地提交、远程提交
提交本地库
- git init
- git add .
- git commit -m "test"

更新远程库
- git pull --rebase origin master
- git push -u origin master

## Maven

## Linux & VScode
- Visual Studio Code
- 快速配置java 环境
  - `sudo apt install openjdk-8-jre-headless`  
  - `sudo apt install openjdk-8-jdk-headless`  
  - 测试
    - `javac` `java`
- VScode安装可找网上教程
- 扩展插件：Code Runner、Java Test Runner、Java Extention Pack 
- man 汉化
  - apt install manpages-zh

## Linux 常用命令
- 目录操作
  - cd
  - pwd
  - mv test test_
  - cp a.txt ~/a.txt
  - rm -rf
  - mkdir -p test/sub_test //TODO
- 文件查看
  - cat/tac
  - more/less
  - head/tail
  - nl (show numbered line)
- 文件编辑
  - vi test (create a file named test, and textual edit)
  - apt install vim
  - set number
  - touch test (change timestamps, create a file if not exists)
  - apt install gedit
  - gedit test (graphic edit)
  - wc
- 时间查看
  - date
  - cal (calendar) / ncal
- 其他
  - echo
  - which java (return one)
  - whereis java (return all)
- 进程查看
  - top -o %MEM
  - ps -a /jps (java processes snapshot)
  - kill



---

# 杂记

## IDEA快捷键与使用效率

```xml
Alt-Enter 万能快捷键，试了就知道了
Alt-Enter 插入/新建/
Ctrl-Shift-Enter 自动补全
```

## IDEA性能配置

Maven项目运行之前有明显卡顿（编译、Parsing缓慢），严重影响代码体验和测试效率。

具体原因可以谷歌，我也是先查的资料再设置。

*解决方案如下*：

1.配置Maven: 
- Settings.Maven里Threads(-c option)设置为 `4C`
- .Runner里VM Options设置为 `-DarchetypeCatalog=internal`
- 修改配置文件，适当位置插入如下内容
...IDEA\plugins\maven\lib\maven3\conf\settings.xml
```xml
<offline>true</offline>
<!-- 增加阿里云镜像 -->
<mirrors>
  <mirror>  <!-- 增加阿里云镜像 -->
    <id>nexus-aliyun</id>  
    <mirrorOf>central</mirrorOf>    
    <name>Nexus aliyun</name>  
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
  </mirror>
</mirrors>
```

2.配置JVM
```xml
custom IntelliJ IDEA VM options # idea64.exe.vmoptions
-Xms1024m
-Xmx2048m
-XX:ReservedCodeCacheSize=500m
-XX:+UseConcMarkSweepGC
-XX:SoftRefLRUPolicyMSPerMB=50
-ea
-Dsun.io.useCanonCaches=false
-Djava.net.preferIPv4Stack=true
-Djdk.http.auth.tunneling.disabledSchemes=""
-XX:+HeapDumpOnOutOfMemoryError
-XX:-OmitStackTraceInFastThrow
-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2018.3.5\bin\JetbrainsIdesCrack-4.2-release.jar
-Deditable.java.test.console=true
```

3.停用无关插件
- Settings.Plugins: 搜索并停用Kotlin插件，disable


# TODO

- 算法.非递归快排 need review
- 设计模式
