package com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper;

import com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 案件（注文）テーブル用のMyBatis Mapperインタフェース。
 */
@Mapper
public interface OrderMapper {
    /**
     * 案件一覧を取得します。
     * @return 案件エンティティのリスト
     */
    @Select("SELECT order_id, title, customer, sales_rep_id, created_at, updated_at FROM orders")
    List<OrderEntity> findAll();

    /**
     * 案件を新規登録します。
     * @param entity 登録する案件エンティティ
     */
    @org.apache.ibatis.annotations.Insert("""
        INSERT INTO orders (
            order_id, title, customer, sales_rep_id, created_at, updated_at
        ) VALUES (
            #{orderId}, #{title}, #{customer}, #{salesRepId}, NOW(), NOW()
        )
    """)
    void insert(OrderEntity entity);
}