---
layout: wiki
title: docker常用命令
categories: docker
description: docker常用命令
keywords: docker, 容器
---

本文主要记录docker常用命令





## 启动容器

```shell
docker start 容器id    #启动容器
docker restart 容器id  #重启
docker stop 容器id	 #停止当前正在运行的容器
docker kill 容器id     #强制停止当前容器

docker ps 			  #查看容器

exit        # 直接退出并停止容器
ctrl +P + Q # 退出不停止容器


docker rm -f $(docker ps -ap)  # 递归删除所有容器
docker rm -f dockerid          # 按容器id删除
```



## 常用其他命令

```shell
docker run -d centos 后台启动  
```






