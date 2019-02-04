package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSession() {
		String resource = "/mybatis-config.xml";
		SqlSession session = null;
		try {
			//xml 파일을 가져온다.
			InputStream is= Resources.getResourceAsStream(resource);
			//SqlSession을 만들기 위해
			//SqlSessionFactoryBuilder 를 만들고
			//만들어진 builder 로 SqlSessionFactory를 만든다.
			//만들어진 factory 로 session을 만들게 된다.
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false); //인자 값은 트랜잭션 설정
			//session 안에는 CRUD 가 가능한 메소드들이 들어있다.
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
