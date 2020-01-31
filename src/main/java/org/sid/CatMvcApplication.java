package org.sid;

import org.sid.Entities.Produit;
import org.sid.dao.ProduitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class CatMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(CatMvcApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
        produitRepository.save(new Produit(1L,"clavier",20.00,1));
        produitRepository.save(new Produit(2L,"elitebook",250.00,4));
        produitRepository.save(new Produit(4l,"samsung",110.00,7));
        produitRepository.save(new Produit(5l,"jbl",88.00,2));
        produitRepository.save(new Produit (6l,"celio",50.00,2));
        produitRepository.save(new Produit (7l,"nike",40.00,1));
        produitRepository.save(new Produit (8l,"jule",20.00,1));
        produitRepository.save(new Produit(9l,"gucci",182.00,1));
        produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
      	produitRepository.findAll().forEach(p->System.out.println(p.getPrix()));
		
	}

}
