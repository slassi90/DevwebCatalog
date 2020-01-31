package org.sid.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.hibernate.annotations.Sort;
import org.sid.Entities.Produit;
import org.sid.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitrepository;

	@RequestMapping(value = "/index")
	public String index(Model model,@RequestParam(name="page",defaultValue = "0")int p,
			@RequestParam(name="size",defaultValue = "5")int s,
			@RequestParam(name="motcle",defaultValue ="")String mc) {
	Page<Produit> pageproduit = produitrepository.chercher("%"+mc+"%",PageRequest.of(p, s));
	model.addAttribute("listproduits",pageproduit.getContent());
	int[]pages=new int [pageproduit.getTotalPages()];
	model.addAttribute("pages",pages);
	model.addAttribute("size", s);
	model.addAttribute("pagecourante", p);
		return "Produits";
	}
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String delete(long id,String motcle,int page,int size) {
		produitrepository.deleteById(id);
		return "redirect:/index?page="+page+"&size="+size+"&motcle"+motcle;
	}
	
	
}
