package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @ClassName: MyHibernateSessionFactory.java
 * @Description: 获得会话工厂对象工具类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年12月8日 上午9:13:05
 */
public class MyHibernateSessionFactory {
	//会话工厂属性
	private static SessionFactory sessionFactory;

	//构造方法私有化，保证单例模式
	private MyHibernateSessionFactory() {

	}
	//公有的静态方法，获得会话工厂对象
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			//创建配置对象
			Configuration config = new Configuration().configure();
			//创建服务注册对象
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
  	        sessionFactory=config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
			
		}else{
			return sessionFactory;
		}
		
	}
	
}
