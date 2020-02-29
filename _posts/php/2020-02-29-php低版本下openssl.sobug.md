---
layout: post
title: php低版本 openssl.so的问题
categories: [php, 踩坑]
description: some word here
keywords: php, openssl
---

# php 5.2.3 openssl_decrypt bug
php5.2.3下php问题 openssl.so疑似有bug，用高本版的源码到低版本编译，才可用
现象是 openssl_decrypt解不出aes结果，openssl_encrypt进行aes加密是，指定padding无效（结果全都一样）坑。