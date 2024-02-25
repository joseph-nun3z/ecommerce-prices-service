-- Create BRAND table
CREATE TABLE BRAND (
                       BRAND_ID INT AUTO_INCREMENT PRIMARY KEY,
                       BRAND_NAME VARCHAR(255) NOT NULL
);

-- Create PRODUCT table
CREATE TABLE PRODUCT (
                         PRODUCT_ID INT AUTO_INCREMENT PRIMARY KEY,
                         PRODUCT_NAME VARCHAR(255) NOT NULL,
                         BRAND_ID INT,
                         FOREIGN KEY (BRAND_ID) REFERENCES BRAND(BRAND_ID)
);

-- Create PRICE_LIST table
CREATE TABLE PRICE_LIST (
                            PRICE_LIST_ID INT AUTO_INCREMENT PRIMARY KEY,
                            DESCRIPTION VARCHAR(255) NOT NULL
);

-- Create PRICES table with relationships
CREATE TABLE PRICES (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        BRAND_ID INT,
                        START_DATE TIMESTAMP NOT NULL,
                        END_DATE TIMESTAMP NOT NULL,
                        PRICE_LIST_ID INT,
                        PRODUCT_ID INT,
                        PRIORITY INT NOT NULL,
                        PRICE DECIMAL(10, 2) NOT NULL,
                        CURR VARCHAR(3) NOT NULL,
                        FOREIGN KEY (BRAND_ID) REFERENCES BRAND(BRAND_ID),
                        FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID),
                        FOREIGN KEY (PRICE_LIST_ID) REFERENCES PRICE_LIST(PRICE_LIST_ID)
);
