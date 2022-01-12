package com.ecommerce.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;

@Component
public class LoadData {

	
	public CategoryService categoryService;
	public ProductService productService;
	
	@Autowired
	public LoadData(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
		addCategoryData();
		addProductData();
	}
	
	public void addCategoryData() {
		List<Category> cat = new ArrayList<>();
		
		cat.add(new Category(1, "Electronics"));
		cat.add(new Category(2, "Home and Furniture"));
		cat.add(new Category(3, "Clothing and Accessories"));
		cat.add(new Category(4, "Footwear"));
		cat.add(new Category(5, "Beauty and Personal Care"));
		
		cat.forEach(df -> {categoryService.addCategory(df);});
	}
	
	public void addProductData() {
		List<ProductDTO> pro = new ArrayList<>();

		pro.add(new ProductDTO(1, "SAMSUNG 23.8 inch Curved Full HD LED Backlit VA Panel Monitor (LC24F390FHWXXL)  (AMD Free Sync, Response Time: 4 ms, 60 Hz Refresh Rate)", "lc24f390fhwxxl-full-hd-lc24f390fh-samsung-original-imag7gk5zzdhdgsu.jpeg", "SAMSUNG 23.8 inch Curved Full HD LED", 12390, 1));
		pro.add(new ProductDTO(2, "RedmiBook Pro Core i5 11th Gen - (8 GB/512 GB SSD/Windows 10 Home) Thin and Light Laptop  (15.6 inch, Charcoal Gray, 1.8 kg, With MS Office)", "redmibook-15-pro-thin-and-light-laptop-redmi-original-imag7xhnakyazyma.jpeg", "RedmiBook Pro Core i5 11th Gen", 49990, 1));
		pro.add(new ProductDTO(3, "Electrobot Core 2 Duo (4 GB RAM/Intel Onboard Graphics Graphics/500 GB Hard Disk/Windows 7 Ultimate) Full Tower (EB31)", "tower-pc-assembled-computer-comes-with-intel-core-2-duo-2gb-ddr2-original-imaf5chu58egjwbt.jpeg", "Electrobot Core 2 Duo ", 6890, 1));
		pro.add(new ProductDTO(4, "REDMI 9i Sport (Coral Green, 64 GB)  (4 GB RAM)", "9i-sport-mzb0a0yin-redmi-original-imag785ryfspqg3a.jpeg", "REDMI 9i Sport", 8499, 1));
		pro.add(new ProductDTO(5, "Canon EOS 3000D DSLR Camera 1 Camera Body, 18 - 55 mm Lens  (Black)", "canon-eos-eos-3000d-dslr-original-imaf3t5h9yuyc5zu.jpeg", "Canon DSLR Camera", 33499, 1));
		pro.add(new ProductDTO(6, "Bharat Lifestyle Nano Fabric 6 Seater Sofa  (Finish Color - Black Grey, DIY(Do-It-Yourself))", "black-polycotton-nano-bharat-lifestyle-black-grey-original-imaf9jnxsemqtmgk.jpeg", "6 Seater Sofa", 21999, 2));
		pro.add(new ProductDTO(7, "Tzoo Romantic Sky Star Master Night Projector Lamp with USB 9 Colour 4 LED Rotation Baby Sleep Lighting USB Lamp Led Projection for Diwali Decor,Kids Room, Home Decor Night Lamp  (9 cm, Pink, Blue, Purple)", "star-moon-projector-lamp-360-degree-rotation-9-light-color-original-imafvpydqfyxc3vf.jpeg", "Night Projector Lamp", 349, 2));
		pro.add(new ProductDTO(8, "Perfect Homes Rhea 4 inch Queen PU Foam Mattress  (L x W: 72 inch x 60 inch)#JustHere", "normal-top-queen-4-rhea-pu-foam-pu-foam-flipkart-perfect-homes-original-imag6g7xrjz3jxsg.jpeg", "Foam Mattress", 5461, 2));
		pro.add(new ProductDTO(9, "UltraSlim Stainless Steel Heavy Rain Shower Head with 15 inch Arm (Silver, Chrome Finish) Shower Head", "8x8-8inch-ultraslim-stainless-steel-heavy-rain-shower-head-with-original-imafwhgudkwhdghg.jpeg", "Shower Head", 399, 2));
		pro.add(new ProductDTO(10, "Kendalwood Furniture Solid Wood 6 Seater Dining Set  (Finish Color -Warm Chestnut Finish, Knock Down)", "6-seater-gray-rosewood-sheesham-afk-93-abishaka-decor-warm-original-imafnvk2kawut7dv.jpeg", "Dining Set ", 24649, 2));
		pro.add(new ProductDTO(11, "Casual Regular Sleeves Solid Women Black Top", "xs-157-black-aahwan-original-imag5trwttumkgrh.jpeg", "Women Black Top", 399, 3));
		pro.add(new ProductDTO(13, "Regular Fit Men Blue Cotton Blend Trousers", "32-8237591-roadster-original-imafgmryjhzjdmrh.jpeg", "Mens Trousers", 1007, 3));
		pro.add(new ProductDTO(14, "UV Protection Rectangular Sunglasses (Free Size)  (For Men & Women, Red, Black, Yellow, Blue, Black)", "small-medium-lv-new-kingsunglasses-original-imagyffmhtczh5bg.jpeg", "Sunglasses ", 259, 3));
		pro.add(new ProductDTO(15, "Women Printed Pure Cotton Straight Kurta  (White)", "xl-sa19kr328w-surhi-original-imafpf3cqbzkxuhz.jpeg", "Kurta  ", 220, 3));
		pro.add(new ProductDTO(16, "Full Sleeve Color Block Men Casual Jacket", "m-tnvgyrdhdfulsweat-k15-tripr-original-imafmzbq9xtcwhsg.jpeg", "Jacket", 290, 3));
		pro.add(new ProductDTO(17, "Boots For Women  (Brown)", "ts47-026-8-trase-brown-original-imafxa3fzvhzj8ax.jpeg", "Boots ", 899, 4));
		pro.add(new ProductDTO(18, "Running Shoes For Men  (Black)", "inklen-7-ezdezario-black-original-imafzc3wntpmqfss.jpeg", "Running Shoes", 297, 4));
		pro.add(new ProductDTO(19, "Boys Slip On Slipper Flip Flop  (Multicolor)", "1-4-k-newyork-gry-welcome-original-imag93zgg57vfzve.jpeg", "Flip Flop", 399, 4));
		pro.add(new ProductDTO(20, "Leather Casual Stylish Look Boots Shoes Boots For Women  (Pink)", "hand-boot9612-8-creattoes-black-pink-original-imafhtkj4kse7dec.jpeg", " Boots Shoes ", 388, 4));
		pro.add(new ProductDTO(21, "Lace Sneakers For Boys & Girls  (White)", "6-blackwhite-u2shoes-original-imag46trqkxdvya6.jpeg", "Lace Sneakers", 499, 4));
		pro.add(new ProductDTO(22, "Bold Care Extend - Long Last Spray Non-transferable Safe to Use Lubricant  (20 g)", "20-extend-long-last-spray-1-body-spray-bold-care-men-original-imafzug9zpeujdw7.jpeg", "Long Last Spray", 285, 5));
		pro.add(new ProductDTO(23, "TRESemme Hair Fall Defense Shampoo  (180 ml)", "hair-fall-defense-shampoo-tresemme-original-imag35ebpbhyg36b.jpeg", "TRESemme Shampoo  ", 130, 5));
		pro.add(new ProductDTO(24, "Lakmé Sun Expert Ultra Matte SPF40 PA+++ 2units Compact  (Beige, 7 g)", "7-sun-expert-ultra-matte-spf-40-pa-lakme-original-imafvfqqcg6x7hfj.jpeg", "Lakmé Sun Expert Compact ", 190, 5));
		pro.add(new ProductDTO(25, "MARS velvet creamy eyeshadow palette 30 g  (Velvet Glamour)", "223-mars-original-imafygq6gnvwubua.jpeg", "Eyeshadow palette ", 275, 5));
		pro.add(new ProductDTO(26, "Clean & Clear Face Wash  (450 ml)", "450-face-wash-clean-clear-original-imafz3hz4fgwhfnf.jpeg", "Face Wash", 301, 5));
	
		
		pro.forEach(productDTO -> {
			Product product = new Product();
			product.setId(productDTO.getId());
			product.setName(productDTO.getName());
			product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
			product.setPrice(productDTO.getPrice());
			product.setDescription(productDTO.getDescription());
			product.setImageName(productDTO.getImageName());

			productService.addProduct(product);
		});
	}
}
