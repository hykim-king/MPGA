
package com.pcwk.ehr.menuscore;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MenuScoreDao {
	int menuScoreInsert(final MenuScoreVO score) throws Exception;
	int menuScoreDelete(MenuScoreVO score) throws Exception;
	int menuScoreUpdate(MenuScoreVO score) throws Exception;
    int menuScoreAvg(MenuScoreVO score) throws Exception;
	int menuScoreCount(MenuScoreVO score) throws Exception;

}
