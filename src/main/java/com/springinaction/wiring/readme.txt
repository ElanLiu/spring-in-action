=================================================
一、手动注册bean
1 通过xml中bean配置
	1 通过property注入
	2 通过constructor-arg构造器注入
	3 注意bean的scope，比如singleton和prototype
	4 使用init-method和destroy-method来初始化和销毁bean
2 通过ref引入其他bean
3 通过命名空间使用p装配bean
4 list、map、props装配
5 使用SpEL装配
=================================================
二、自动装配
1 xml中使用autowire来自动装配，byName、byType等等
2 @Autowired注解自动装配，@Qualifier限定器.需要在xml中配置注解
3 @Value中通过SpEL注入基本类型&String类型
4 通过@Component注册bean。需要在xml中配置扫描
5 通过@Configuration和@Bean自动检测并标注bean。需要在xml中配置扫描
=================================================