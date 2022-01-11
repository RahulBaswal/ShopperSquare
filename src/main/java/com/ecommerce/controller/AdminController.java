package com.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class AdminController {

	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}

	@GetMapping("/admin/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}

	@GetMapping("/admin/categories/add")
	public String getAddCategorie(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}

	@PostMapping("/admin/categories/add")
	public String saveCategorie(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);

		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		}
		return "404";
	}

	// -----------Product--Section----------

	@GetMapping("/admin/products")
	public String productsHome(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}

	@GetMapping("/admin/products/add")
	public String getAddProduct(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "productsAdd";
	}

	@PostMapping("/admin/products/add")
	public String postAddProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName)
			throws IOException {

		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());

		String imageUUID;

		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUID = imgName;
		}

		product.setImageName(imageUUID);

		productService.addProduct(product);

		return "redirect:/admin/products";
	}

	@GetMapping("/admin/product/delete/{id}")
	public String deletePrduct(@PathVariable long id) {
		productService.removeProductById(id);
		return "redirect:/admin/products";
	}

	@GetMapping("/admin/product/update/{id}")
	public String updateProduct(@PathVariable long id, Model model) {
		Product product = productService.getProductById(id).get();

		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setImageName(product.getImageName());

		model.addAttribute("productDTO", productDTO);
		model.addAttribute("categories", categoryService.getAllCategory());

		return "productsAdd";
	}

}
