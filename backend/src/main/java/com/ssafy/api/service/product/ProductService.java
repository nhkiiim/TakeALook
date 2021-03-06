package com.ssafy.api.service.product;

import com.ssafy.api.request.paging.PageReq;
import com.ssafy.api.request.product.ProductRegisterPostReq;
import com.ssafy.api.request.product.ProductSearchPostReq;
import com.ssafy.api.request.product.ProductUpdatePatchReq;
import com.ssafy.api.response.product.ProductListGetRes;
import com.ssafy.db.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductListGetRes> getAllProduct();

    Page<ProductListGetRes> getAllProductByUserId(PageReq pageReq, String userId);
    Page<ProductListGetRes> searchProduct(ProductSearchPostReq productSearchInfo);
    Page<ProductListGetRes> getList(PageReq pageReq);
    Page<ProductListGetRes> getListByReserveTime(PageReq pageReq);
    Page<ProductListGetRes> getListByHighPrice(PageReq pageReq);
    Page<ProductListGetRes> getListByLowPrice(PageReq pageReq);

    Product createProduct(String productId, ProductRegisterPostReq productRegisterPostReq);
    Product getProductByProductId(Long productIndexId);
    Product updateProduct(String sellerId, Long productId, ProductUpdatePatchReq productUpdatePatchReq);

    Boolean getProductExistMessage(Long productIndexId);
    Boolean checkProductAuth(String sellerId, Long productId);

    void updateIsSold(Product product);
    void deleteProduct(Long productIndexId);
}
