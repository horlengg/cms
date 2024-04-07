

-- *** CREATE table user details
CREATE TABLE tb_user_detail (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(25),
    gender VARCHAR(10),
    marital_status VARCHAR(25),
    phone VARCHAR(20),
    present_address VARCHAR(255),
    profile_url VARCHAR(255),
    effective_date Date NOT NULL,
    contract_end_date Date NOT NULL,
    dob DATE NOT NULL,
    id_no VARCHAR(20) UNIQUE NOT NULL,
    id_type VARCHAR(20) NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);
-- *** create table user
CREATE TABLE tb_user (
    id SERIAL PRIMARY KEY,
    email VARCHAR(25) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(25) NOT NULL,
    login_attempt SMALLINT DEFAULT 0,
    user_detail_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (user_detail_id) REFERENCES tb_user_detail(id),
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);

-- *** create table category
CREATE TABLE tb_category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    description VARCHAR(255) ,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);

-- *** create table supplier
CREATE TABLE tb_supplier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(255) ,
    phone VARCHAR(20) UNIQUE,
    email VARCHAR(50) UNIQUE,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);

-- *** create table product
CREATE TABLE tb_product (
    id SERIAL PRIMARY KEY,
    barcode VARCHAR(6) NOT NULL UNIQUE,
    category_id BIGINT NOT NULL,
    supplier_id BIGINT NOT NULL,
    name VARCHAR(25) NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    qty INTEGER NOT NULL,
    description VARCHAR(255) NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES tb_category(id),
    FOREIGN KEY (supplier_id) REFERENCES tb_supplier(id),
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);

-- *** create table import
CREATE TABLE tb_import (
    id SERIAL PRIMARY KEY,
    import_date TIMESTAMP NOT NULL,
    total_item INTEGER NOT NULL,
    total_amt DECIMAL(10,2) NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);

-- *** create table import details
CREATE TABLE tb_import_details (
    import_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    qty INTEGER NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (import_id) REFERENCES tb_import(id),
    FOREIGN KEY (product_id) REFERENCES tb_product(id),
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id),
    PRIMARY KEY(import_id,product_id)
);

-- *** create table checkin item
CREATE TABLE tb_checkin_item (
    id SERIAL PRIMARY KEY,
    cms_card_number VARCHAR(6),
    cashier_id BIGINT NOT NULL,
    status VARCHAR(25) NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (cashier_id) REFERENCES tb_user_detail(id),
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);
-- *** create table checkin item detail
CREATE TABLE tb_checkin_item_detail (
    id SERIAL PRIMARY KEY,
    checkin_item_id BIGINT NOT NULL,
    product_id INTEGER NOT NULL,
    qty INTEGER NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (checkin_item_id) REFERENCES tb_checkin_item(id),
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);
-- *** create table payment
CREATE TABLE tb_payment (
    id SERIAL PRIMARY KEY,
    cms_card_number VARCHAR(5),
    cashier_id BIGINT NOT NULL,
    checkin_item_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    updated_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (cashier_id) REFERENCES tb_user_detail(id),
    FOREIGN KEY (checkin_item_id) REFERENCES tb_checkin_item(id),
    FOREIGN KEY (created_by) REFERENCES tb_user_detail(id),
    FOREIGN KEY (updated_by) REFERENCES tb_user_detail(id)
);


-- =================> insert data into to table <=====================
INSERT INTO tb_user_detail(full_name,gender,marital_status,phone,present_address,profile_url,effective_date,contract_end_date,dob,id_no,id_type,created_by) VALUES
    ('Ly Horleng','MALE','SINGLE','+88509837733','PHNOM PENH','https://drive.google.com/thumbnail?id=1-YNn0imkZlYy2R181VtzzDPamd6Ft-ci','2022-01-01','2024-12-30','2002-02-02','00009838','NATIONAL ID CARD',null),
    ('Sok Channy','MALE','SINGLE','+88509837733','PHNOM PENH','https://drive.google.com/thumbnail?id=1-YNn0imkZlYy2R181VtzzDPamd6Ft-ci','2022-01-01','2024-12-30','2002-02-02','00009389','NATIONAL ID CARD',1);

INSERT INTO tb_user(email,password,role,user_detail_id,created_by) VALUES
    ('ly.horleng@gmail.com','$2a$10$Db1we.vKFBalDA.FwOJ4UuTLq.obuLcGrU4bgiEaPNcJha1YCqBIS','ADMIN',1,NULL),
    ('sok.channy@gmail.com','$2a$10$Db1we.vKFBalDA.FwOJ4UuTLq.obuLcGrU4bgiEaPNcJha1YCqBIS','CASHIER',2,1);


INSERT INTO tb_category( name, description, created_by ) VALUES 
    ('Drink','Drink much die fast!.',1),
    ('BREAK FAST','Drink much die fast!.',1),
    ('LUNCH','Drink much die fast!.',1),
    ('DINNER','Drink much die fast!.',1),
    ('MILK','Drink much die fast!.',1);
    
INSERT INTO tb_supplier( name, address,phone,email,created_by ) VALUES 
    ('Sting Company Co.Ltd','PHNOM PENH','+88529727727763','sting@gmail.com.kh',1),
    ('Pepsi Company Co.Ltd','PHNOM PENH','+88529727727764','pepsi@gmail.com.kh',1),
    ('Carabao Company Co.Ltd','PHNOM PENH','+88529727727765','carabao@gmail.com.kh',1),
    ('Ductch Milk Company Co.Ltd','PHNOM PENH','+88529727727766','ductchmilk@gmail.com.kh',1),
    ('Latesoy Company Co.Ltd','PHNOM PENH','+88529727727767','latesoy@gmail.com.kh',1);

INSERT INTO tb_product (barcode,category_id,supplier_id,name,description,unit_price,qty,created_by) VALUES
    ('101010',1,1,'Sting Engergy Drink','Happy with your friends',0.99,330,1),
    ('101011',1,2,'Pepsi Engergy Drink','Happy with your friends',0.5,20,1),
    ('101012',5,5,'Latesoy','Good for kids',1.4,102,1),
    ('101013',1,4,'Dutch Milk','Happy with your friends',1.99,200,1);
INSERT INTO tb_checkin_item(cms_card_number,cashier_id,status,created_by) VALUES ('0001',2,'ACTIVE',1);
INSERT INTO tb_checkin_item_detail(checkin_item_id,product_id,qty,created_by) VALUES (1,1,21,1),(1,2,3,1),(1,3,44,1),(1,4,2,1);
INSERT INTO tb_payment(cms_card_number,cashier_id,checkin_item_id,created_by) VALUES ('0001',2,1,1);