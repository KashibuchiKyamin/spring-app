package com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.OrderEntity;

/**
 * 案件（注文）テーブル用のMyBatis Mapperインタフェース。
 */
@Mapper
public interface OrderMapper {
	/**
	 * 案件一覧を取得します。
	 * @return 案件エンティティのリスト
	 */
	@Select("""
			SELECT
				order_id, title, customer, sales_rep_id, created_at, updated_at
			FROM
				orders
			ORDER BY
				created_at DESC
			""")
	List<OrderEntity> findAll();

	/**
	 * 1ページ分の案件一覧（最新10件）を取得します。
	 * @return 案件エンティティのリスト
	 */
	@Select("""
			SELECT
				order_id, title, customer, sales_rep_id, created_at, updated_at
			FROM
				orders
			ORDER BY
				created_at DESC
			""")
	List<OrderEntity> findAllLimit10();

	/**
	 * 案件を新規登録します。
	 * @param entity 登録する案件エンティティ
	 */
	@Insert("""
			    INSERT INTO orders (
			        order_id, title, customer, sales_rep_id, created_at, updated_at
			    ) VALUES (
			        #{orderId}, #{title}, #{customer}, #{salesRepId}, NOW(), NOW()
			    )
			""")
	void insert(OrderEntity entity);

	/**
	 * 全案件数を取得します。
	 * @return 全案件数
	 */
	@Select("SELECT COUNT(*) FROM orders")
	int getAllCount();
}