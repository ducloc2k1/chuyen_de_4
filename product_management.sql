CREATE DATABASE product_management

GO

USE product_management

GO

CREATE TABLE tblCategory
(
	id INT PRIMARY KEY IDENTITY(1,1),
	name VARCHAR(50),
	status BIT
)

GO

CREATE TABLE tblProduct
(
	id VARCHAR(50) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	producer VARCHAR(255) NOT NULL,
	quantity INT NOT NULL,
	price FLOAT NOT NULL,
	vat FLOAT NOT NULL,
	category_id INT FOREIGN KEY REFERENCES tblCategory(id)
)

GO

SELECT * FROM tblProduct WHERE id = 'SP01'

GO

CREATE PROC Add_New_Product
	@id VARCHAR(50),
	@name VARCHAR(255),
	@producer VARCHAR(255),
	@quantity INT,
	@price FLOAT,
	@vat FLOAT,
	@category_id INT
AS
BEGIN
	INSERT INTO tblProduct(id,name,producer,quantity,price,vat,category_id) 
	VALUES(@id,@name,@producer,@quantity,@price,@vat,@category_id)
END

GO

CREATE PROC Products_List
AS
BEGIN
SELECT * FROM tblProduct 
END

GO

CREATE PROC Update_Product
	@id VARCHAR(50),
	@name VARCHAR(255),
	@producer VARCHAR(255),
	@quantity INT,
	@price FLOAT,
	@vat FLOAT,
	@category_id INT
AS
BEGIN
	UPDATE tblProduct 
	SET name = @name,
		producer = @producer,
		quantity = @quantity,
		price = @price,
		vat = @vat,
		category_id = @category_id
	WHERE id = @id
END
GO

CREATE PROC Find_By_Id
@id VARCHAR(50)
AS
BEGIN
	SELECT * FROM tblProduct WHERE id = @id
END

GO

CREATE PROC Remove
@id VARCHAR(50)
AS
BEGIN 
	DELETE FROM tblProduct WHERE id = @id
END

GO

CREATE PROC listCategory
AS
BEGIN 
	SELECT * FROM tblCategory
END

GO

CREATE PROC productByCategory
@id_cat INT
AS
BEGIN 
	SELECT
			p.name,
			p.price,
			p.producer,
			p.quantity,
			p.vat,
			c.name as category
	FROM tblProduct p JOIN tblCategory c
	ON   p.category_id = c.id
	WHERE c.id = @id_cat
END

productByCategory 2