package com.freestyle.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.freestyle.model.Product;
import com.freestyle.model.User;
import com.freestyle.service.ProductService;
import com.freestyle.service.UserService;

@Controller
public class AdminController {

	public static Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@RequestMapping("/viewUser")
	public ModelAndView viewUser() throws JsonGenerationException, JsonMappingException, IOException {
		log.debug("Starting of method viewUser");
		List<User> list = userService.viewUser();
		ObjectMapper object = new ObjectMapper();
		String jsonlist = object.writeValueAsString(list);
		System.out.println(("List is:" + list));
		log.debug("Ending of method viewUser");
		return new ModelAndView("viewUser", "listofusers", jsonlist);
	}

	@RequestMapping("/products")
	public ModelAndView addProducts() {
		Product product = new Product();
		return new ModelAndView("product", "addProduct", product);
	}

	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ModelAndView addProd(@Valid @ModelAttribute("addProduct") Product p, @RequestParam("file") MultipartFile file,
			BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()){
			return new ModelAndView("product");
		}
		System.out.println("add product called");
		productService.addProduct(p);
		MultipartFile productImage = p.getFile();
		Path path = Paths.get("D://workspace//FreeStyle//src//main//webapp//WEB-INF//resources//images//"
				+ p.getProduct_id() + ".jpg");
		if (productImage != null && !productImage.isEmpty()) {
			productImage.transferTo(new File(path.toString()));
			System.out.println("image added");
		}
		System.out.println(p);

		return new ModelAndView("product","success","\"Your product is added\"");

	}

	@RequestMapping("/viewProduct")
	public ModelAndView viewProduct() throws JsonGenerationException, JsonMappingException, IOException {
		log.debug("Starting of method viewProduct");
		List<Product> list = productService.viewProduct();
		ObjectMapper object = new ObjectMapper();
		String jsondata = object.writeValueAsString(list);
		System.out.println(("List is:" + list));
		log.debug("Ending of method viewProducts");
		return new ModelAndView("viewProduct", "listofproducts", jsondata);
	}

	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id) {
		productService.deleteProduct(id);
		return new ModelAndView("redirect:/viewProduct","delete","Product deleted!!");
	}

	@RequestMapping("/editProduct")
	public ModelAndView editProduct(@RequestParam("id") int id) {
		System.out.println("id:" + id);
		Product product = productService.getId(id);
		System.out.println("product name:" + product.getProduct_name());
		return new ModelAndView("editedProduct", "product", product);
	}

	@RequestMapping("/updateProduct")
	public String updateThisItem(@RequestParam("product_id") String product_id,
			@RequestParam("product_name") String product_name, @RequestParam("product_desc") String product_desc,
			@RequestParam("category") String category, @RequestParam("product_price") String product_price) {
		int proId = Integer.parseInt(product_id);
		Product product = productService.getId(proId);
		product.setProduct_name(product_name);
		product.setProduct_desc(product_desc);
		product.setCategory(category);
		product.setProduct_price(Float.parseFloat(product_price));
		productService.updateProduct(product);

		return "redirect:/viewProduct";
	}
}
