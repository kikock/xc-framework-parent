@[TOC](本地虚拟机环境)

# 本地虚拟机环境说明

### 虚拟机版本

			VMware® Workstation 16 Pro 16.1.0 build-17198959
			CentOS-8.1.1911-x86_64

### 系统版本

			CentOS-8.1.1911-x86_64

#### 1. 安装,这里最小化安装

#### 2. 关闭防火墙

```bash
	##查看防火墙状态
	firewall-cmd --state
	##关闭防火墙
	systemctl stop firewalld.service
	##禁止开机启动
	systemctl disable firewalld.service 
```

### Centos 8 软件安装和配置

#### 1.依赖软件

			vim  wget  等其他依赖软件直接下载安装

#### 2. java环境

- 安装(java version "1.8.0_281")

  	略
- 环境变量

```bash
	##java环境配置
	## 编辑 /etc/profile 文件  最后添加
	
	export JAVA_HOME=/opt/java/jdk1.8.0_121
	export  CLASSPATH=$:CLASSPATH:$JAVA_HOME/lib/
	export  PATH=$PATH:$JAVA_HOME/bin
	## 安装状态
	java -version
	
```

#### 2. mysql

- 安装(8.0.21 for Linux on x86_64)

  	略

- 相关命令

```bash
## 启动mysql
	systemctl start mysqld 
## 	加入开机启动
	systemctl enable --now mysqld 
## 启动状态
	systemctl status mysqld
## 配置mysql安全参数如:密码强度,远程访问等	
	mysql_secure_installation 
```

	ps: mysql_secure_installation 执行完成后依然可以通过之前修改方法修改密码强度等参数
	
	参数名称有变化

#### 2. MongoDB4

- 安装

  			mongodb-linux-x86_64-rhel80-4.4.4.tgz

- 相关配置(mongo.conf)

```bash

#日志配置
systemLog:
  quiet: false # MongoDB试图最大程度精简日志数量，以安静模式运行，不建议生产环境打开
  destination: file # 日志输出的目的地，如果值是file，即文件类型，则必须指定path的值
  path: /usr/local/src/mongodb4.4.4/log/mongod.log # 日志的路径，该值即默认路径
  logAppend: true # 重启MongoDB实例时，是否在同一个文件追加日志，如果为false，则备份原有日志，同时新增日志文件
  verbosity: 2 # 日志的详细程度，范围0-5，默认是0，即最简单日志；最高是5，最详细日志。
#数据库配置
storage:
  dbPath: /usr/local/src/mongodb4.4.4/db # 数据存储位置，该值即默认值，可手动配置
  journal:
    enabled: true # 是否启用持久性日志存储，64位系统默认true，32位默认false
##端口和网络
net:
  port: 27017 # MongoDB监听的tcp端口，默认是27017，建议修改
  bindIp: 0.0.0.0 # 允许链接的IP地址，如需远程连接，应该改为对应IP，或改为0.0.0.0(::,0.0.0.0)以允许所有IPv4(IPv6)链接

```

- 启动命令

```bash
##启动命令
/usr/local/src/mongodb/bin/mongod --config /usr/local/src/mongodb/bin/mongo.conf  --fork
```

- 开机启动服务

```bash
$ systemctl cat mongodb.service

#启动顺序与依赖关系
## Description字段给出当前服务的简单描述，Documentation字段给出文档位置。
## After(程序后面启动)和Before(程序前面启动)字段只涉及启动顺序，不涉及依赖关系

[Unit]
Description=mongodb
After=network.target remote-fs.target nss-lookup.target

#启动行为 Service区块定义如何启动当前服务。
## Type字段定义启动类型。
### simple（默认值）：ExecStart字段启动的进程为主进程
### forking：ExecStart字段将以fork()方式启动，此时父进程将会退出，子进程将成为主进程
### oneshot：类似于simple，但只执行一次，Systemd 会等它执行完，才启动其他服务
### dbus：类似于simple，但会等待 D-Bus 信号后启动
### notify：类似于simple，启动结束后会发出通知信号，然后 Systemd 再启动其他服务
### idle：类似于simple，但是要等到其他任务都执行完，才会启动该服务。一种使用场合是为让该服务的输出，不与其他服务的输出相混合
## ExecStart字段：定义启动进程时执行的命令。
## ExecReload字段：重启服务时执行的命令
## ExecStop字段：停止服务时执行的命令
## ExecStartPre字段：启动服务之前执行的命令
## ExecStartPost字段：启动服务之后执行的命令
## ExecStopPost字段：停止服务之后执行的命令
## PrivateTmp字段：设置是否使用私有的tmp目录

[Service]
Type=forking
ExecStart=/usr/local/mongodb/bin/mongod --config /usr/local/mongodb/mongodb.conf
ExecReload=/bin/kill -s HUP $MAINPID
ExecStop=/usr/local/mongodb/bin/mongod --shutdown --config /usr/local/mongodb/mongodb.conf
PrivateTmp=true

#Install区块，定义如何安装这个配置文件，即怎样做到开机启动
## WantedBy字段：表示该服务所在的 Target。
## 通过multi-user.target 服务组开机启动
[Install]
WantedBy=multi-user.target

```

ps:[Systemd 入门教程：实战篇](https://www.ruanyifeng.com/blog/2016/03/systemd-tutorial-part-two.html)

```

```bash
    # 常用命令
    ##刷新环境变量
    source /etc/profile
    ##系统重启
    reboot
    
    #systemctl 常用命令
    ##开机启动服务列表
    systemctl list-unit-files --type=service | grep enabled
    ##重载系统服务
    systemctl daemon-reload
    ##设置开机启动
    systemctl enable  [name]
    ##启动服务
    systemctl start [name]
    ##停止服务
    systemctl stop [name]
    ##重启服务
    systemctl restart [name]
    ##移除开机启动项的服务
    systemctl disable [name]
    
    #chkconfig 命令
    ### 在/etc/init.d 目录下
    ## 开机启动列表
    chkconfig --list 
    ## 添加开机启动
    chkconfig --add [name]
    ## 删除开机启动
    chkconfig --del [name]
    ## 设置开机启动
    chkconfig [name] on
```

