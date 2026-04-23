package com.kosuri.service;

import com.kosuri.entity.Product;
import com.kosuri.entity.Store;
import com.kosuri.repository.ProductRepository;
import com.kosuri.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Long id, Product updatedProduct) {

        Product existing = getProduct(id);

        existing.setProductName(updatedProduct.getProductName());

        if (updatedProduct.getStore() != null) {
            Long storeId = updatedProduct.getStore().getStoreId();

            Store store = storeRepository.findById(storeId)
                    .orElseThrow(() -> new RuntimeException("Store not found"));

            existing.setStore(store);
        }
        return productRepository.save(existing);
    }
}