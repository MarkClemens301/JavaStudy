# JavaStudy <JavaLearn>

一个学习与复习用的Repos.

Create by Mark Clemens, a java learner and user.


# Intro

A project for beginners to learn Java.

## Hello

[HelloWorld.java](./BasicGrammar/Hello/HelloWorld.java)

[HelloWorldJava.java](./BasicGrammar/Hello/HelloWorldJava.java)

[ScannerInput.java](./BasicGrammar/Hello/ScannerInput.java)

[...](./BasicGrammar/Hello)

## HelloWorld

Java编程第一步，HelloWorld

在IDEA或者记事本中编辑代码，**HelloWorld.java**

**代码**：[HelloWorldJava.java](./BasicGrammar/Hello/HelloWorldJava.java)

**在命令行执行：**

javac HelloWorld.java //生成 *.class* 文件

java HelloWorld.class //执行Java程序

执行完成。


# 目录 <Contents>

## 文件结构 <Files Structure>

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
    设计模式.DM01_单例模式
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

## 基础语法

<Remains to be updated.>


## 操作系统

### 进程和线程

- 进程 Process
- 线程 Thread
- 进程的调度

### 内存管理

- 虚拟内存
- 分段
- 分页
- 多级页表
- 段页式内存管理
- Linux内存管理
    - 页式内存管理


## 学习资源

Cyc2018/CS-Note
Aobing/JavaFamily
NowCoder
负雪明烛 算法模板


# 杂记

## IDEA快捷键与使用效率

```xml
Alt-Enter 万能快捷键，试了就知道了
Alt-Enter 插入/新建/
Ctrl-Shift-Enter 自动补全
```

## IDEA性能配置

Maven项目运行之前有明显卡顿（编译、Parsing缓慢），严重影响代码体验和测试效率。

*解决方案*：

（具体原因可以谷歌，我也是先查的资料再设置）

1.配置Maven: 

Settings.Maven里Threads(-c option)设置为 `4C`

.Runner里VM Options设置为 `-DarchetypeCatalog=internal`

修改配置文件，适当位置插入如下内容
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
Settings.Plugins: 搜索并停用Kotlin插件，disable

4.版本控制
红色，未加入版本控制
绿色，版本控制，暂未提交
蓝色，版本控制，已提交，有改动
白色，版本控制，已提交，无改动
灰色，忽略的文件

# TODO

算法.非递归快排 --review
设计模式
