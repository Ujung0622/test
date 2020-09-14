package project.hm.hmp003_d001.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import project.hm.hmp003_d001.vo.Hmp003_d001VO;

public interface Hmp003_d001Service {
	 public List<Hmp003_d001VO> searchList(Map<String, Object> searchMap) throws DataAccessException;
	 public List<Hmp003_d001VO> searchMod(Map<String, Object> searchMap) throws DataAccessException;
	 public List<Hmp003_d001VO> searchAdd() throws DataAccessException;
	 
	 public void updateProduct(Map<String, Object> datahMap) throws Exception;
	 public void insertProduct(Map<String, Object> datahMap) throws Exception;
	 public void deleteProduct(Map<String, Object> datahMap) throws Exception;
}
