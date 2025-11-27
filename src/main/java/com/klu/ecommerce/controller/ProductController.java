package com.klu.ecommerce.controller;

import com.klu.ecommerce.entity.Product;
import com.klu.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class ProductController {

    private final ProductRepository productRepository;

    @Value("${product.upload-dir:uploads/}")
    private String uploadDir;

    private Path uploadPath;

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;

    private static final List<String> ALLOWED_TYPES = List.of(
            "image/jpeg", "image/png", "image/jpg", "image/gif"
    );

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(uploadPath);
    }

    // ----------------------- ADD PRODUCT -----------------------
    @PostMapping("/upload")
    public ResponseEntity<String> uploadProduct(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("price") double price,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @RequestParam(value = "unit", required = false) String unit,
            @RequestParam(value = "discount", required = false) Double discount,
            @RequestParam(value = "brand", required = false) String brand
    ) {

        try {
            if (file.getSize() > MAX_FILE_SIZE) {
                return ResponseEntity.badRequest().body("File too large");
            }

            if (!ALLOWED_TYPES.contains(file.getContentType())) {
                return ResponseEntity.badRequest().body("Invalid file type");
            }

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path target = uploadPath.resolve(fileName);

            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

            Product product = new Product(
                    name,
                    category,
                    price,
                    fileName,
                    description,
                    quantity != null ? quantity : 0,
                    unit,
                    discount != null ? discount : 0.0,
                    brand
            );

            productRepository.save(product);

            return ResponseEntity.ok("Product uploaded successfully!");

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + ex.getMessage());
        }
    }

    // ----------------------- GET ALL -----------------------
    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // ----------------------- GET BY CATEGORY (OLD WORKING STYLE) -----------------------
    // 👈 THIS FIXES YOUR 405 ERROR
    @GetMapping("/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }

    // ----------------------- UPDATE PRODUCT -----------------------
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct
    ) {
        return productRepository.findById(id).map(product -> {

            product.setPrice(updatedProduct.getPrice());
            productRepository.save(product);

            return ResponseEntity.ok("Product updated");

        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found"));
    }

    // ----------------------- DELETE PRODUCT -----------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (!productRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        productRepository.deleteById(id);
        return ResponseEntity.ok("Product deleted");
    }

    // ----------------------- SERVE IMAGE -----------------------
    @GetMapping("/images/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        try {
            Path filePath = uploadPath.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"")
                    .body(resource);

        } catch (MalformedURLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
