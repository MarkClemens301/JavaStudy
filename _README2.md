JavaStudy <JavaLearn>
---



## Java


```java
// region 使用region

// endregion
```

```xml
<!--region 使用region-->
<!--...-->
<!--endregion-->
```




# GIT 操作


git config --global http.sslVerify false # 忽略SSL证书错误


@分支管理和切换
git status
git log
git diff --stat origin/master master
git checkout $commit_id
git checkout -b $new_branch  # 基于commit_id 新建分支
git branch -a 
git branch -D $local_branch  # 删除本地分支

@拉取和推送
git pull [ origin master ]  # git fetch + git merge
git fetch
git rebase origin/master
git pull --rebase # git fetch + git rebase
git push origin develop
git push origin develop:master --force  # 覆盖主分支 使用开发分支
git push origin --delete $remote_branch  # 删除远端分支

@回滚操作
git rebase --abort
git reset --soft HEAD~2
git restore $file   # 取消文件修改，回滚。
git add .
git restore --staged .  # 从暂存区移出来。
git commit -m $msg

git restore --staged .


@gitbash 中文乱码问题
git config --global core.quotepath false
git config --global i18n.commitencoding utf-8    #如果是GBK 请换成gbk
git config --global i18n.logoutputencoding utf-8   #如果是GBK 请换成gbk
export LESSCHARSET=utf-8

最好不要这样解决，很鸡肋。用可视化工具来看commit即可。




# IDEA 集锦



## [IDEA Settings]

Settings: Code Style: Java:
Continuation Indent == 4
Imports == 

all static other imports
com.xxx.*
com.*
all other imports
net.*
org.*
java.*
javax.*

General: Editor Tabs:
Tab位置：左侧
Tab最大个数：33
enable preview tab



## [IDEA Plugins]

restfulTool
maven helper
arthas

code navigator
tool-window



## [IDEA Keymap]

中大型工程代码阅读，增效
代码走读训练

ctrl-e   查看近期文件
ctrl-alt-h  查看代码调用     #选择范围 scope 为生产文件: Production
ctrl-alt-shift-u  查看diagram   # 插件code navigator: UML图 4+1视图
ctrl-shift-f  查询内容    #技巧：在指定目录

@search
ctrl-n  查询类
ctrl-shift-n  查询文件
ctrl-shift-alt-n  查询符号
shift-shift  查询所有



# END

