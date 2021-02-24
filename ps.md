

@[TOC](本地虚拟机环境)

# 本地虚拟机环境说明

### 虚拟机版本

			VMware® Workstation 16 Pro 16.1.0 build-17198959

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

			vim  wget  c++等其他依赖软件直接下载安装

#### 2. liunx 常用命令

```bash
    # 常用命令
    ##刷新环境变量
    source /etc/profile
    ##系统重启
    reboot
    #生成 Makefile，为下一步的编译做准备,检测你的安装平台的目标特征的。比如它会检测你是不是有CC或GCC，并不是需要CC或GCC，它是个shell脚本。
    ./configure 
    #从Makefile中读取指令，然后编译
　  make
    #从Makefile中读取指令，安装到指定的位置
　  make install
    
    
    
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

#### 3. java环境

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

#### 4. mysql

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

#### 5. MongoDB4

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

#### 6.RabbitMQ安装

##### 安装依赖环境Erlang

1.首先下载Erlang 下载地址 "http://www.erlang.org/downloads/”
将下载好的源码上传到Linux服务器上

2.先安装依赖 "yum install ncurses-devel”

3.执行安装命令"./configure --prefix=/usr/local/[安装目录] --without-javac"

4.进行编译，输入命令"make" , 执行安装命令"make install"

5.进入[安装目录]/bin目录下执行“./erl”命令 查看安装状态

##### 安装rabbitMQ

1.首先下载rabbitMQ 将下载好的源码上传到Linux服务器上 后缀名是“XZ” 先安装XZ压缩软件 解压到安装目录

2.安装相关依赖

3.启动rabbitMQ“./rabbitmq-server”

4.设置开机启动 创建服务文件

```bash
#!/bin/bash
    #chkconfig:2345 61 61

    export PATH=$PATH:/usr/local/src/erlang/bin
    export PATH=$PATH:/usr/local/src/rabbitmq_server-3.8.12/sbin
    
    case "$1" in
    start)
    echo "Starting RabbitMQ ..."
    rabbitmq-server  -detached
    ;;
    stop)
    echo "Stopping RabbitMQ ..."
    rabbitmqctl stop
    ;;
    status)
    echo "Status RabbitMQ ..."
    rabbitmqctl status
    ;;
    restart)
    echo "Restarting RabbitMQ ..."
    rabbitmqctl stop
    rabbitmq-server  restart
    ;;
    
    *)
    echo "Usage: $prog {start|stop|status|restart}"
    ;;
    esac
    exit 0    
```

5.开机启动服务创建(systemctl命令)

```bash
    
    [Unit]
    Description=rabbitmq
    After=network.target remote-fs.target nss-lookup.target
    
    [Service]
    Type=forking
    ExecStart=/usr/local/src/rabbitmq_server-3.8.12/sbin/rabbitmq start
    ExecReload=/usr/local/src/rabbitmq_server-3.8.12/sbin/rabbitmq status
    ExecStop=/usr/local/src/rabbitmq_server-3.8.12/sbin/rabbitmq stop
    PrivateTmp=true
    
    [Install]
    WantedBy=multi-user.target

```

#### 7.fastDFS安装 ([下载地址](https://github.com/happyfish100/FastDFS))

##### - 基础安装

1、安装基础环境

    yum install -y gcc gcc-c++
    yum -y install libevent

2、解压libfatscommon函数库

    # 解压
    tar -zxvf libfastcommon-1.0.43.tar.gz

3、进入libfastcommon文件夹，编译并且安装

    ./make.sh
    ./make.sh install

4、解压fastdfs主程序文件

    # 解压
    tar -zxvf fastdfs-6.06.tar.gz

5、进入fastdfs目录，fastdfs主程序编译并且安装

    ./make.sh
    ./make.sh install 

6、将安装文件夹下的配置文件拷贝到/etc/fdfs目录下

##### - 配置服务(方便管理每个配置一个文件夹)

1.配置tracker服务

	#复制一份配置文件
	cp tracker.conf.sample tracker.conf
	############修改配置#################
	tracker基础地址
	base_path=/usr/local/fastdfs/tracker
	配置 http 端口：
	http.server_port=80

```bash
# 相关命令
##启动
/usr/bin/fdfs_trackerd /etc/fdfs/tracker.conf start
##重启
/usr/bin/fdfs_trackerd /etc/fdfs/tracker.conf restart
##关闭
/usr/bin/fdfs_trackerd /etc/fdfs/tracker.conf stop
```

2.配置storage服务(多个服务)

	#复制一份配置文件
	cp storage.conf.sample storage.conf
	############修改配置#################
	# 修改storage的工作空间
	base_path=/usr/local/fastdfs/storage
	# 修改storage的存储空间
	store_path0=/usr/local/fastdfs/storage
	# 修改tracker服务的地址和端口号，用于心跳
	tracker_server=192.168.0.11:22122

```bash
# 相关命令
##启动
/usr/bin/fdfs_storaged /etc/fdfs/storage.conf  start
##重启
/usr/bin/fdfs_storaged /etc/fdfs/storage.conf  restart
##关闭
/usr/bin/fdfs_storaged /etc/fdfs/storage.conf  stop
```

3.配置client 测试

	#修改配置文件
	base_path=/usr/local/fastdfs/client 
	   #tracker的ip根据实际tracker的ip地址配置
	tracker_server=192.168.0.11:22122
	tracker_server=192.168.0.12:22122

```bash
##上传文件
/usr/bin/fdfs_test 客户端配置文件地址 upload 上传文件

```

#### Nginx 模块 fastdfs-nginx-module配置

- [模块下载](https://github.com/happyfish100/fastdfs-nginx-module/releases)
- 解压文件 修改/src/config文件，主要是修改路径，把原路径/usr/local/include/修改为/usr/include/ (fastdfs默认安装fastcommon,fastdfs文件到/usr/include/)
- 将 FastDFS-nginx-module/src 下的 mod_FastDFS.conf 拷贝至/etc/fdfs/下

  		修改文件mod_FastDFS.conf
  		#存储数据和日志文件的基本路径(store0_path存在base_path只存储日志)
  		base_path=/usr/local/fastdfs/storage
  		#tracker 服务地址
  		tracker_server=192.168.200.128:22122
  		url_have_group_name = true
  		#如果store0_path 不存在使用base_path地址
  		store0_path=/usr/local/fastdfs/storage
  		ps:目录不存在 注意创建
- Nginx 生成 Makefile 时增加 --add-module 参数配置解压目录

#### Nginx安装

1、去[官网下载](http://nginx.org/)对应的nginx包，推荐使用稳定版本
2、上传nginx到linux系统 3、安装依赖环境

```bash
##c++依赖
yum install gcc-c++
##安装PCRE库，用于解析正则表达式
yum install -y pcre pcre-devel
##zlib压缩和解压缩依赖
yum install -y zlib zlib-devel
SSL 安全的加密的套接字协议层，用于HTTP安全传输，也就是https
yum install -y openssl openssl-devel
```

3、解压nginx包并编译

- 解压

```bash
		tar -zxvf  [name]
```

- 先创建nginx临时目录，如果不创建，在启动nginx的过程中会报错

```bash
		mkdir /var/temp/nginx -p
```

- 生成 Makefile

|参数|说明 | |--|--| | --prefix | 指定nginx安装目录 | | --pid-path|指向nginx的pid| | --lock-path| 锁定安装文件|		
| --error-log-path| 错误日志|		
| --http-log-path| http日志|		
| --with-http_gzip_static_module| 启用gzip模块,在线实时压缩输出数据流 |		
| --http-client-body-temp-path| 客户端请求临时目录|				
| --http-proxy-temp-path| http代理临时目录 |		
| --http-fastcgi-temp-path| fastcgi临时目录|		
| --http-uwsgi-temp-path| uwsgi临时目录|				
| --http-scgi-temp-path| scgi临时目录| | --add-module| nginx 增加模块|

```bash
## 复制注意换行
		./configure 
        --prefix=/usr/local/src/nginx
        --pid-path=/usr/local/src/nginx/pid/nginx.pid
        --lock-path=/usr/local/src/nginx/lock/nginx.lock
        --error-log-path=/usr/local/src/nginx/log/error.log
        --http-log-path=/usr/local/src/nginx/log/http.log
        --with-http_gzip_static_module
        --http-client-body-temp-path=/usr/local/src/nginx/temp/client
        --http-proxy-temp-path=/usr/local/src/nginx/temp/proxy
        --http-fastcgi-temp-path=/usr/local/src/nginx/temp/fastcgi
        --http-uwsgi-temp-path=/usr/local/src/nginx/temp/uwsgi
        --http-scgi-temp-path=/usr/local/src/nginx/temp/scgi
        --add-module=/usr/local/src/nginx/module/fastdfs-nginx-module-1.22/src
```

- 从Makefile中读取指令，然后编译

```bash
		make
```

- 从Makefile中读取指令，安装到指定的位置

```bash
		 make install    
```

- 修改nginx.conf，添加fastdfs虚拟主机

```bash
	server {
         listen       8888;
         server_name  localhost;
         location /group1/M00 {
         root /usr/local/fastdfs/storage/data/;
         ngx_fastdfs_module;
         }
     }
```

- 常用命令

```bash
#启动
./nginx
#停止
./nginx -s stop
#重新加载
./nginx -s reload
```



