package com.yzj.dao;

import java.util.List;

import com.yzj.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findBaseDictByTypeCode(String string);

	

}
