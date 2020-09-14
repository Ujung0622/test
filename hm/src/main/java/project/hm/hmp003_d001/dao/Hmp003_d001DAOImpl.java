package project.hm.hmp003_d001.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.hm.hmp003_d001.vo.Hmp003_d001VO;


@Repository("hmp003_d001DAO")
public class Hmp003_d001DAOImpl implements Hmp003_d001DAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Hmp003_d001VO> searchList(Map<String, Object> searchMap) throws DataAccessException {
		List<Hmp003_d001VO> list = sqlSession.selectList("hm.hmp003_d001.searchList", searchMap);
		return list;
	}
	
	@Override
	public List<Hmp003_d001VO> searchMod(Map<String, Object> searchMap) throws DataAccessException {
		List<Hmp003_d001VO> list = sqlSession.selectList("hm.hmp003_d001.searchMod", searchMap);
		return list;
	}

	@Override
	public List<Hmp003_d001VO> searchAdd() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.hmp003_d001.updateMember", datahMap);
	}

	@Override
	public void insertProduct(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.hmp003_d001.insertMember", datahMap);
	}

	@Override
	public void deleteProduct(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.hmp003_d001.deleteMember", datahMap);
	}
}
