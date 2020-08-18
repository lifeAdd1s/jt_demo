# 分布式项目新建过程
## 新建一个项目，删除src文件夹，在pom.xml文件中的groupId为子包的parentId
## 在新建的project上右键新建module，这是子项目
    * 新建的module名称包包名要注意，所有的子系统的保命路径要一致，com.xxxx.dao,com.xxxx.service  
    类似这种
    * 新建的子系统中的application.xml要注意不能使用默认命名，在主系统中引用时会冲突，注意改名  
    * 在主启动系统中需要在application.yml/properties中引用子系统的配置文件
    * 子系统配置文件命名类似application-dao.yml,applicaiton-service.yml这种
## 子系统的pom文件中parentId需要设置为项目的groupId
## 在有相互调用关系的子系统中，可以在pom文件中添加dependency依赖来引用：service调用dao，controller调用dao和service
## 只在主启动系统中的pom文件中保留build配置，其他子系统删除不使用
## 当需要分布式部署时，即单独模块一个服务器运行，需要在模块下的pom文件中保留build选项

# mybatis-plus注意事项
## mybatis-plus支持分页查询，但是需要在springboot中进行配置，配置完成后即可通过selectPage进行分页查询