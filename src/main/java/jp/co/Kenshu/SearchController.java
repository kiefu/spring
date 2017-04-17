package jp.co.Kenshu;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.Kenshu.dto.search.SearchDto;
import jp.co.Kenshu.form.Dto;
import jp.co.Kenshu.service.SearchService;

@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;

		@RequestMapping(value="/serach/{id}",method = RequestMethod.GET)
		public String search(Model model, @PathVariable int id) {
		    SearchDto search = searchService.getsearch(id);
		    model.addAttribute("search", search);
		    return "search";
		}
		@RequestMapping(value = "/update/input/", method = RequestMethod.GET)
		public String update(Model model,@PathVariable int id) {
			SearchDto search =searchService.getsearch(id);
		    Dto form = new Dto();
		    form.setId(search.getId());
		    form.setName(search.getName());
		    form.setDescription(search.getDescription());
		    form.setFile(search.getFile());

		    model.addAttribute("Dto", form);
		    return "update";
		}
		@RequestMapping(value = "/update/input/", method = RequestMethod.POST)
		public String update(@ModelAttribute Dto form, Model model) {
			SearchDto dto = new SearchDto();
		    BeanUtils.copyProperties(form, dto);
		    int count = searchService.update(dto);
		    return "redirect:/search/";
		}
		@RequestMapping(value = "/delete/input/", method = RequestMethod.GET)
		public String testDelete(Model model) {
			Dto form = new Dto();
		    model.addAttribute("Dto", form);
		    return "search";
		}

		@RequestMapping(value = "/delete/input/", method = RequestMethod.POST)
		public String Delete(@ModelAttribute Dto form, Model model) {
		    int count = searchService.delete(form.getId());
		    return "redirect:/search/";
		}
}

