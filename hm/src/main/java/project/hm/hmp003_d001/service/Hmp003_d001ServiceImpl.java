package project.hm.hmp003_d001.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.hm.hmp003_d001.dao.Hmp003_d001DAO;
import project.hm.hmp003_d001.vo.Hmp003_d001VO;

@Service("hmp003_d001Service")
@Transactional(propagation = Propagation.REQUIRED)
public class Hmp003_d001ServiceImpl implements Hmp003_d001Service {
	@Autowired
	private Hmp003_d001DAO hmp003_d001DAO;

	@Override
	public List<Hmp003_d001VO> searchList(Map<String, Object> searchMap) throws DataAccessException {
		List<Hmp003_d001VO> list =  hmp003_d001DAO.searchList(searchMap); 
		return list;
	}

	@Override
	public List<Hmp003_d001VO> searchMod(Map<String, Object> searchMap) throws DataAccessException {
		List<Hmp003_d001VO> list =  hmp003_d001DAO.searchMod(searchMap);
		return list;
	}

	@Override
	public List<Hmp003_d001VO> searchAdd() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Map<String, Object> datahMap) throws Exception {
		hmp003_d001DAO.updateProduct(datahMap);
	}

	@Override
	public void insertProduct(Map<String, Object> datahMap) throws Exception {
		hmp003_d001DAO.insertProduct(datahMap);
	}

	@Override
	public void deleteProduct(Map<String, Object> datahMap) throws Exception {
		hmp003_d001DAO.deleteProduct(datahMap);
	}
}
