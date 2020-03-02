---
layout: post
title: php出现Segmentation fault
categories: [php, linux]
description: some word here
keywords: php, linux
---

#php出现Segmentation fault
php -v 出现 Segmentation fault，使用gdb简单查看

##1、生成core dump
这种错误信息, 借助 core.dump 文件分析是种比较好的办法

默认文件是关闭的, 开启生成 core.dump 文件

```ulimit -c unlimited```

##2、重新执行php -v
gdb php +core文件
看吧。

``` 对于libphp7.so 也可以试试 ```
