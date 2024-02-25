-- Create PRICE table
CREATE TABLE IF NOT EXISTS PRICE (
                        ID IDENTITY NOT NULL PRIMARY KEY,
                        BRAND_ID INT,
                        START_DATE TIMESTAMP NOT NULL,
                        END_DATE TIMESTAMP NOT NULL,
                        PRICE_LIST_ID INT,
                        PRODUCT_ID INT,
                        PRIORITY INT NOT NULL,
                        PRICE DECIMAL(10, 2) NOT NULL,
                        CURR VARCHAR(3) NOT NULL
);

