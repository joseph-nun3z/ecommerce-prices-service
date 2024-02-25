-- Create BRAND table
CREATE TABLE IF NOT EXISTS BRAND (
                       ID IDENTITY PRIMARY KEY,
                       BRAND_NAME VARCHAR(255) NOT NULL
);

-- Create PRODUCT table
CREATE TABLE IF NOT EXISTS PRODUCT (
                         ID IDENTITY PRIMARY KEY,
                         PRODUCT_NAME VARCHAR(255)
);

-- Create PRICE_LIST table
CREATE TABLE IF NOT EXISTS PRICE_LIST (
                            ID IDENTITY PRIMARY KEY,
                            DESCRIPTION VARCHAR(255) NOT NULL
);

-- Create PRICE table
CREATE TABLE IF NOT EXISTS PRICE (
                        ID IDENTITY PRIMARY KEY,
                        BRAND_ID INT,
                        START_DATE TIMESTAMP NOT NULL,
                        END_DATE TIMESTAMP NOT NULL,
                        PRICE_LIST_ID INT,
                        PRODUCT_ID INT,
                        PRIORITY INT NOT NULL,
                        PRICE DECIMAL(10, 2) NOT NULL,
                        CURR VARCHAR(3) NOT NULL,
                        FOREIGN KEY (BRAND_ID) REFERENCES BRAND(ID),
                        FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(ID),
                        FOREIGN KEY (PRICE_LIST_ID) REFERENCES PRICE_LIST(ID)
);

