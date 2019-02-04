package mybatis.model.service;

import org.apache.ibatis.session.SqlSession;

import mybatis.model.dao.MyBatisDao;

import static common.SqlSessionTemplate.getSession;

public class MyBatisService {

	private MyBatisDao dao = new MyBatisDao();
	
	public int insertStudent() {
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		return result;
	}

}
