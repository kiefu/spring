package jp.co.Kenshu.mapper;

import java.util.List;

import jp.co.Kenshu.entity.Search;

public interface SearchMapper {
	Search getSearch(Integer id);

	List<Search> getSearchAll();

	int update();

	int delete(int id);
	}
