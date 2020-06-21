1.工程打包
1.1 工程之间关系
                       admin-parent
                            |
                         继承、聚合
                            |
    admin-webui ----> admin-component ----> admin-entity
                            |
                           依赖
                            |
                        common-util

1.2 Maven对于安装顺序的要求
1.2.1 依赖关系对安装顺序的要求
A 依赖 B
Maven 要求先安装 B，再安装 A
1.2.2 继承关系对安装顺序的要求
A（子工程）继承 B（父工程）
Maven 要求先安装 B（父工程），再安装 A（子工程）

如果配置聚合，那么对聚合工程执行 install 命令，Maven 就会自动按照正确的顺序安装各个模块工程。

但是我们现在 common-util 工程没有参与聚合，所以要先单独对 common-util执行安装。

1.3
maven在install过程中已经执行打包命令，所以再不需要执行package命令

先执行common-util的安装。
    mvn clear install