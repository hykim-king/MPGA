package com.pcwk.ehr.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.SearchVO;

@Repository
public class UserDaoImpl implements UserDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	SqlSessionTemplate   sqlSessionTemplate;
	
	final String NAMESPACE = "com.pcwk.ehr.member";
	

	public UserDaoImpl() {
	}
		

	/**
	 * 닉네임 중복 확인
	 * @param user
	 * @return flag
	 * @throws SQLException
	 */
	public int SameNickCheck(UserVO user) throws SQLException {
		int flag = 0;
		
		String statement = this.NAMESPACE+".doSameNickCheck";
		
		LOG.debug("==================================");
		LOG.debug("=statement="+user);
		LOG.debug("=statement="+statement);
		LOG.debug("==================================");
		
		flag = this.sqlSessionTemplate.selectOne(statement, user);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	
	
	/**
	 * 아이디 중복 확인
	 * @param user
	 * @return flag
	 * @throws SQLException
	 */
	public int SameIdCheck(UserVO user) throws SQLException {
		int flag = 0;
		
		String statement = this.NAMESPACE+".doSameIdCheck";
		
		LOG.debug("==================================");
		LOG.debug("=statement="+user);
		LOG.debug("=statement="+statement);
		LOG.debug("==================================");
		
		flag = this.sqlSessionTemplate.selectOne(statement, user);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	
	
	/**
	 * 동일 비밀번호 입력 확인
	 * @param user
	 * @return flag
	 * @throws SQLException
	 */
	public int SamePasswdCheck(UserVO user) throws SQLException {
		int flag = 0;
		
		String statement = this.NAMESPACE+".doSamePasswdCheck";
		
		LOG.debug("==================================");
		LOG.debug("=statement="+user);
		LOG.debug("=statement="+statement);
		LOG.debug("==================================");
		
		flag = this.sqlSessionTemplate.selectOne(statement, user);
		LOG.debug("=flag="+flag);
		
		return flag;
	}

	@Override
	public int doInsert(final UserVO user) throws ClassNotFoundException, SQLException {
		int flag = 0;
		
		LOG.debug("=========================================");
		LOG.debug("param=" + user.toString());
		LOG.debug("=========================================");

		//NAMESPACE +"."+id
		String statement = NAMESPACE + ".doInsert";

		flag = sqlSessionTemplate.insert(statement, user);
		LOG.debug("flag=" + flag);

		return flag;
	}
	
	//쓸필요가 없다.
	@Override
	@SuppressWarnings("deprecation")
	public UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException {
		UserVO outVO = null;

		String statement = this.NAMESPACE+".doSelectOne";
		
		
		LOG.debug("=========================================");
		LOG.debug("inVO=" + inVO.toString());
		LOG.debug("statement=" + statement);
		LOG.debug("=========================================");

		outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("outVO=" + outVO);
		return outVO;
	}
	
	//아이디, 닉네임 인증시 데이터 비교할때 사용.
	@Override
	public List<?> doRetrieve(SearchVO searchVO) throws SQLException {
		List<UserVO>   list = new ArrayList<UserVO>();
		
		String statement = this.NAMESPACE +".doRetrieve";
		LOG.debug("=========================================");
		LOG.debug("statement" + statement);
		LOG.debug("searchVO" + searchVO);
		LOG.debug("=========================================");		
		
		list = this.sqlSessionTemplate.selectList(statement, searchVO);
		
		for (UserVO vo : list) {
			LOG.debug("vo:" + vo);
		}		
		return list;
	}

	@Override
	@SuppressWarnings({ "deprecation" })
	public List<UserVO> getAll() {
		List<UserVO> list = new ArrayList<UserVO>();
		
		String statement = this.NAMESPACE +".getAll";
		
		list = this.sqlSessionTemplate.selectList(statement);
		
		for (UserVO vo : list) {
			LOG.debug("vo:" + vo);
		}

		return list;
	}

	@Override
	@SuppressWarnings("deprecation")
	public int getCount() throws ClassNotFoundException, SQLException {
		int cnt = 0;

		String statement = this.NAMESPACE +".getCount";
		
		cnt = this.sqlSessionTemplate.selectOne(statement);
		LOG.debug("=========================================");
		LOG.debug("cnt=" + cnt);
		LOG.debug("=========================================");

		return cnt;
	}

	@Override
	public void deleteAll() throws SQLException {

		//NAMESPACE +"."+id
		String statement = NAMESPACE + ".deleteAll";
		int flag = sqlSessionTemplate.delete(statement);
		LOG.debug("=========================================");
		LOG.debug("flag=" + flag);
		LOG.debug("=========================================");		
	}

	@Override
	public int doDelete(UserVO user) throws SQLException {
		int flag = 0;

		LOG.debug("=========================================");
		LOG.debug("param=" + user.toString());
		LOG.debug("=========================================");
		//com.pcwk.ehr.member.doDelete
		//com.pcwk.ehr.member
		//NAMESPACE +"."+id
		String statement = NAMESPACE + ".doDelete";
		
		
		flag = this.sqlSessionTemplate.delete(statement, user);
		
		LOG.debug("flag=" + flag);
		return flag;
	}

	@Override
	public int doUpdate(UserVO user) throws SQLException {
        int flag = 0;
        
		LOG.debug("=========================================");
		LOG.debug("param=" + user.toString());
		LOG.debug("=========================================");		
		String statement  = NAMESPACE +".doUpdate";
		flag = sqlSessionTemplate.update(statement, user);
		LOG.debug("flag=" + flag);
		return flag;
	}
	

	
	  

}
