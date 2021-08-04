package com.ssafy.db.repository.product;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.api.response.product.ProductListGetRes;
import com.ssafy.db.entity.Product;
import com.ssafy.db.entity.QProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QProduct qProduct = QProduct.product;

    public Optional<Product> findByProductId(Long productId) {
        Product product = jpaQueryFactory.select(qProduct).from(qProduct)
                .where(qProduct.id.eq(productId)).fetchOne();
        if (product == null) return Optional.empty();
        return Optional.ofNullable(product);
    }

    public List<ProductListGetRes> findByUserId(String userId) {
        List<ProductListGetRes> productList = jpaQueryFactory
                .select(Projections.constructor(ProductListGetRes.class,qProduct.id, qProduct.user.userId,
                qProduct.productName,qProduct.basePrice, qProduct.categories,qProduct.description,qProduct.state,
                qProduct.imageUrl, qProduct.isSold,qProduct.registTime,qProduct.reserveTime,qProduct.restrictTime))
                .from(qProduct)
                .where(qProduct.user.userId.eq(userId)).fetch();
         return (productList);
    }

    public List<ProductListGetRes> findAll(){
        List<ProductListGetRes> productList = jpaQueryFactory
                .select(Projections.constructor(ProductListGetRes.class,qProduct.id, qProduct.user.userId,
                        qProduct.productName,qProduct.basePrice, qProduct.categories,qProduct.description,qProduct.state,
                        qProduct.imageUrl, qProduct.isSold,qProduct.registTime,qProduct.reserveTime,qProduct.restrictTime))
                .from(qProduct)
                .fetch();
        return productList;
    }

    public Page<ProductListGetRes> findAllList(Pageable pageable){
        QueryResults<ProductListGetRes> result = jpaQueryFactory
                .select(Projections.constructor(ProductListGetRes.class,qProduct.id, qProduct.user.userId,
                        qProduct.productName,qProduct.basePrice, qProduct.categories,qProduct.description,qProduct.state,
                        qProduct.imageUrl, qProduct.isSold,qProduct.registTime,qProduct.reserveTime,qProduct.restrictTime))
                .from(qProduct)
                .orderBy(qProduct.registTime.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }

    public Page<ProductListGetRes> findAllReserveTime(Pageable pageable){
        QueryResults<ProductListGetRes> result = jpaQueryFactory
                .select(Projections.constructor(ProductListGetRes.class,qProduct.id, qProduct.user.userId,
                        qProduct.productName,qProduct.basePrice, qProduct.categories,qProduct.description,qProduct.state,
                        qProduct.imageUrl, qProduct.isSold,qProduct.registTime,qProduct.reserveTime,qProduct.restrictTime))
                .from(qProduct)
                .orderBy(qProduct.reserveTime.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }

    public Page<ProductListGetRes> findAllHighPrice(Pageable pageable){
        QueryResults<ProductListGetRes> result = jpaQueryFactory
                .select(Projections.constructor(ProductListGetRes.class,qProduct.id, qProduct.user.userId,
                        qProduct.productName,qProduct.basePrice, qProduct.categories,qProduct.description,qProduct.state,
                        qProduct.imageUrl, qProduct.isSold,qProduct.registTime,qProduct.reserveTime,qProduct.restrictTime))
                .from(qProduct)
                .orderBy(qProduct.basePrice.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }

    public Page<ProductListGetRes> findAllLowPrice(Pageable pageable){
        QueryResults<ProductListGetRes> result = jpaQueryFactory
                .select(Projections.constructor(ProductListGetRes.class,qProduct.id, qProduct.user.userId,
                        qProduct.productName,qProduct.basePrice, qProduct.categories,qProduct.description,qProduct.state,
                        qProduct.imageUrl, qProduct.isSold,qProduct.registTime,qProduct.reserveTime,qProduct.restrictTime))
                .from(qProduct)
                .orderBy(qProduct.basePrice.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }
}
