-- 案件（注文）テーブル定義
CREATE TABLE orders (
  order_id VARCHAR(32) PRIMARY KEY COMMENT '案件ID',
  title VARCHAR(255) NOT NULL COMMENT '案件タイトル',
  customer VARCHAR(255) NOT NULL COMMENT '顧客名',
  sales_rep_id VARCHAR(32) NOT NULL COMMENT '担当営業ID',
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  INDEX idx_customer (customer),
  INDEX idx_sales_rep_id (sales_rep_id)
) COMMENT='案件（注文）テーブル';