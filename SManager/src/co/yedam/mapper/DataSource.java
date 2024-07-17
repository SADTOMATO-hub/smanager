package co.yedam.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	//SqlSessionFactory 생성,
	public static SqlSessionFactory getInstance() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e/*해당 위치에 갔는데 없으면 예외처리하겠다는 의미*/) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory 
		          = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
