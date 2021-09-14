package com.pcwk.ehr.menuscore;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pcwk.ehr.menuscore.MenuScoreVO;

@Repository
public class MenuScoreDaoImpl implements MenuScoreDao {

	@Autowired
	private SqlSession session;
	static String namespace = "com.pcwk.ehr.menuscore";
	
	//별점 등록
	@Override
	public int menuScoreInsert(MenuScoreVO score) throws Exception {
		return session.insert(namespace+".menuScoreInsert", score);
	}
	
	//별점 삭제
	@Override
	public int menuScoreDelete(MenuScoreVO score) throws Exception {
		return session.delete(namespace+".menuScoreDelete", score);
	}
	
	//별점 변경
	@Override
	public int menuScoreUpdate(MenuScoreVO score) throws Exception {
		return session.update(namespace+".menuScoreUpdate", score);
	}
	
	//별점 평균
	@Override
	public  int menuScoreAvg(MenuScoreVO score) throws Exception {
		int avg_score = 0;
		avg_score=session.selectOne(namespace+".menuScoreAvg", score);
		return avg_score;
	}
	
	//별점의 부여한 사람의 수
	@Override
	public  int menuScoreCount(MenuScoreVO score) throws Exception {
		int cnt = 0;
		cnt = session.selectOne(namespace+".menuScoreCount", score);
		return cnt;
	}
}
