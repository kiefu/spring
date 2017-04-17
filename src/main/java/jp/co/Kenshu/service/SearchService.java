package jp.co.Kenshu.service;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.Kenshu.dto.search.SearchDto;
import jp.co.Kenshu.entity.Search;
import jp.co.Kenshu.mapper.SearchMapper;
@Service
public class SearchService {
	@Autowired
    private SearchMapper searchMapper;

    public SearchDto getsearch(Integer id) {
        SearchDto dto = new SearchDto();
        Search entity = searchMapper.getSearch(id);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
    public List<SearchDto> getSearchAll() {
        List<Search> searchList = searchMapper.getSearchAll();
        List<SearchDto> resultList = convertToDto(searchList);
        return resultList;
    }

    private List<SearchDto> convertToDto(List<Search> serachList) {
        List<SearchDto> resultList = new LinkedList<>();
        for (Search entity : serachList) {
        	SearchDto dto = new SearchDto();
            BeanUtils.copyProperties(entity, dto);
            resultList.add(dto);
        }
        return resultList;
    }
	public int update(SearchDto dto) {
		   int count = searchMapper.update(dto);
		   return count;
	}
	public int delete(int id) {
		   int count = searchMapper.delete(id);
		   return count;
}
}


