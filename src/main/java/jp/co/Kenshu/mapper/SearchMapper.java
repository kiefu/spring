package jp.co.Kenshu.mapper;

import java.util.List;

import jp.co.Kenshu.dto.search.SearchDto;
import jp.co.Kenshu.entity.Search;

public interface SearchMapper {
	Search getSearch(int id);

	List<Search> getSearchAll();

	int update(SearchDto dto);

	int delete(int id);
	}
