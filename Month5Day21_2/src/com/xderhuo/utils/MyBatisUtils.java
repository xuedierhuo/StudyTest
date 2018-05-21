package com.xderhuo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.InputStream;

public class MyBatisUtils {

	
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// 资源
			InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
			// 工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 创建一个本地线程对象
	private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

	// 会话
	public static SqlSession openSession() {
		SqlSession sqlSession = local.get();// 从本地线程对象中获取会话
		if (sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
			
			//创建一个MapperHelper
	        MapperHelper mapperHelper = new MapperHelper();
	        //特殊配置
	        Config config = new Config();
	        // 支持方法上的注解
	        // 3.3.1版本增加
	        config.setEnableMethodAnnotation(true);
	        config.setNotEmpty(true);
	        //设置配置
	        mapperHelper.setConfig(config);
	        // 注册通用Mapper接口 - 可以自动注册继承的接口
	        mapperHelper.registerMapper(Mapper.class);
	        mapperHelper.registerMapper(MySqlMapper.class);
	        //配置完成后，执行下面的操作
	        mapperHelper.processConfiguration(sqlSession.getConfiguration());
	        
			local.set(sqlSession);// 把会话到到线程对象中
		}
		return sqlSession;
	}

	// dao
	public static <T> T getMapper(Class<T> clazz) {
		SqlSession sqlSession = openSession();// 调用上面的方法，得到会话
		return sqlSession.getMapper(clazz);
	}

	// 关闭资源
	public static void close() {
		SqlSession sqlSession = openSession();
		if (sqlSession != null) {
			sqlSession.close();
			local.remove();// 清除线程中的会话
		}
	}

	/**
	 * 提交并释放资源
	 * 
	 * @param sqlSession
	 */
	public static void commitAndclose() {
		SqlSession sqlSession = openSession();
		if (sqlSession != null) {
			sqlSession.commit();
			close();
		}
	}

	/**
	 * 回滚并释放资源
	 * 
	 * @param sqlSession
	 */
	public static void rollbackAndclose() {
		SqlSession sqlSession = openSession();
		if (sqlSession != null) {
			sqlSession.rollback();
			close();
		}
	}
}
