package com.ssafy.api.service.product;

import com.ssafy.api.request.product.ProductRegisterPostReq;
import com.ssafy.api.request.product.ProductUpdatePatchReq;
import com.ssafy.api.response.product.ProductListGetRes;
import com.ssafy.db.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductListGetRes> getAllProduct();

    List<ProductListGetRes> getAllProductByUserId(String userId);

    Product createProduct(String productId, ProductRegisterPostReq productRegisterPostReq);
    Product getProductByProductId(Long productIndexId);
    Boolean getProductExistMessage(Long productIndexId);
    Boolean checkProductAuth(String sellerId, Long productId);
    Product updateProduct(String sellerId, Long productId, ProductUpdatePatchReq productUpdatePatchReq);
    void updateIsSold(Product product);
    void deleteProduct(Long productIndexId);
}