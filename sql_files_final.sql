CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    Password VARCHAR(250),
    LastLogin DATE,
    IsLoggedIn BOOLEAN
);

use code_fury_database;
desc Employees;
select * from Employees;
-- Insert 20 Employee records
INSERT INTO Employees (EmployeeID, Name, Password, LastLogin, IsLoggedIn)
VALUES
    (1, 'Ram', 'LPJNul+wow4m6DsqxbninhsWHlwfp0JecwQzYpOLmCQ=', '2023-09-14', true),
    (2, 'Raju', '4D0+yNUDX4ch9dxkVG5Z7XkNvLO3tZj+VwV8zXtoOwA=', '2023-09-13', false),
    (3, 'Bheem', 'jwDb7JxlzPWBfDzJgYp9/XxX8GUP2XxZxqycahWq3VI=', '2023-09-12', true),
    (4, 'Chutki', '3JDmB7A/ItfIjhStx0Pq71V5xKzg2ouWtP9Z3B8iFkE=', '2023-09-11', false),
    (5, 'Indumati', 'PqdeTlrw4DYudG3V1aVyC7b/Zy7Wpx0rSEpDZg8TXzU=', '2023-09-10', true),
    (6, 'Dholu', '4RqF5mV05UeMfia3u4WMf7OBwqPx+7/sNRuYn0L+Pj8=', '2023-09-09', false),
    (7, 'Bholu', '2U8jdr3EEhsu7wgtGe5X0Z0YNvTZu7N2xt/VCNPSKQ4=', '2023-09-08', true),
    (8, 'Kalia', 'P3z0sZ/SFZ18r1uyPYgFAKQ13lZQALX8cxECGmPjN5E=', '2023-09-07', false),
    (9, 'Nobita', 'cnTymOnLs6Y//cb46f9lQ3G+QYD6hE7C/r76SksNExQ=', '2023-09-06', true),
    (10, 'Shezuka', 'ctSJrjF28PzUsmM9KqPdOvVo7flW0q9qmbXPGD85l3U=', '2023-09-05', false),
    (11, 'Sunio', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-09-04', true),
    (12, 'Giyan', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-09-03', false),
    (13, 'Doremon', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-09-02', true),
    (14, 'Sejal', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-09-01', false),
    (15, 'Aditya', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-08-31', true),
    (16, 'Raunak', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-08-30', false),
    (17, 'Shrikant', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-08-29', true),
    (18, 'Ashmika', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-08-28', false),
    (19, 'Yash', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-08-27', true),
    (20, 'Neil', '0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=', '2023-08-26', false);
-- Create a table for Company Sellers
CREATE TABLE CompanySellers (
    SellerID INT PRIMARY KEY,
    CompanyName VARCHAR(255),
    Address VARCHAR(255),
    City VARCHAR(255),
    GSTNumber VARCHAR(15)
);

-- Insert 20 Company Seller records
INSERT INTO CompanySellers (SellerID, CompanyName, Address, City, GSTNumber)
VALUES
    (1, 'ABC Electronics', '123 Main Street', 'Mumbai', '29ABCDE1234F1Z5'),
    (2, 'XYZ Appliances', '456 Park Avenue', 'Delhi', '08XYZF5678G2H9'),
    (3, 'PQR Gadgets', '789 Lake Road', 'Kolkata', '12PQRS9876T3U4V'),
    (4, 'LMN Electronics', '321 Green Lane', 'Bangalore', '45MNOB1234A5C6D'),
    (5, 'RST Appliances', '234 River Street', 'Chennai', '67EFGH5678I9J0K'),
    (6, 'GHI Gadgets', '789 Hill Road', 'Hyderabad', '89QRST1234U5V6W'),
    (7, 'JKL Electronics', '456 Sunshine Avenue', 'Pune', '23UVWX6789Y0Z1A'),
    (8, 'MNO Appliances', '123 Rose Street', 'Jaipur', '34ABCD5678E9F1G'),
    (9, 'UVW Gadgets', '234 Garden Road', 'Lucknow', '56HIJK1234L5M6N'),
    (10, 'CDE Electronics', '789 Oak Street', 'Chandigarh', '78OPQR5678S9T0U'),
    (11, 'PQS Appliances', '321 Maple Lane', 'Ahmedabad', '90UVWX1234Y5Z6A'),
    (12, 'FGL Gadgets', '456 Sunset Avenue', 'Bhopal', '12BCDE5678F9G1H'),
    (13, 'XYZ Electronics', '123 Ocean Road', 'Kochi', '34EFGH1234I5J6K'),
    (14, 'LMN Appliances', '234 Forest Lane', 'Guwahati', '56IJKL5678M9N0O'),
    (15, 'RST Gadgets', '789 Riverfront Road', 'Varanasi', '78MNOP1234Q5R6S'),
    (16, 'JKL Electronics', '321 Hilltop Avenue', 'Dehradun', '90STUV5678W9X0Y'),
    (17, 'GHI Appliances', '456 Valley Road', 'Shimla', '12WXYZ1234A5B6C'),
    (18, 'ABC Gadgets', '123 Hillside Lane', 'Jammu', '34ABCD5678E9F1G'),
    (19, 'PQR Electronics', '234 Garden Lane', 'Srinagar', '56HIJK1234L5M6N'),
    (20, 'XYZ Appliances', '789 Lakeside Avenue', 'Leh', '78OPQR5678S9T0U');

-- Create a table for customer information
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(255),
    GSTNumber VARCHAR(15),
    Address VARCHAR(255),
    City VARCHAR(255),
    Email VARCHAR(255),
    Phone VARCHAR(15),
    PinCode VARCHAR(10),
    Password VARCHAR(250)
);

use code_fury_database;
select * from Customers;
-- Insert the 20 customer records into the table
INSERT INTO Customers (CustomerID, Name, GSTNumber, Address, City, Email, Phone, PinCode,Password)
VALUES
    (1, 'Rajesh Sharma', '29ABCDE1234F1Z5', '123, Main Street', 'Mumbai', 'rajesh@gmail.com', '9876543210', '400001','LPJNul+wow4m6DsqxbninhsWHlwfp0JecwQzYpOLmCQ='),
    (2, 'Priya Patel', '08XYZF5678G2H9', '456, Park Avenue', 'Delhi', 'priya@yahoo.com', '8901234567', '110001','mtSbL6Z3n3uG8UHSCq2VWlTc+jCJ8EDRcFoPSEJZlVE='),
    (3, 'Arjun Singhania', '12PQRS9876T3U4V', '789, Lake Road', 'Kolkata', 'arjun@hotmail.com', '7654321098', '700001','jwDb7JxlzPWBfDzJgYp9/XxX8GUP2XxZxqycahWq3VI='),
    (4, 'Sneha Desai', '45MNOB1234A5C6D', '321, Green Lane', 'Bangalore', 'sneha@gmail.com', '8765432109', '560001','3JDmB7A/ItfIjhStx0Pq71V5xKzg2ouWtP9Z3B8iFkE='),
    (5, 'Anand Verma', '67EFGH5678I9J0K', '234, River Street', 'Chennai', 'anand@yahoo.com', '7890123456', '600001','PqdeTlrw4DYudG3V1aVyC7b/Zy7Wpx0rSEpDZg8TXzU='),
    (6, 'Ayesha Khan', '89QRST1234U5V6W', '789, Hill Road', 'Hyderabad', 'ayesha@hotmail.com', '9876543211', '500001','4RqF5mV05UeMfia3u4WMf7OBwqPx+7/sNRuYn0L+Pj8='),
    (7, 'Vikram Patel', '23UVWX6789Y0Z1A', '456, Sunshine Avenue', 'Pune', 'vikram@gmail.com', '8765432101', '411001','2U8jdr3EEhsu7wgtGe5X0Z0YNvTZu7N2xt/VCNPSKQ4='),
    (8, 'Nisha Sharma', '34ABCD5678E9F1G', '123, Rose Street', 'Jaipur', 'nisha@yahoo.com', '7890123456', '302001','P3z0sZ/SFZ18r1uyPYgFAKQ13lZQALX8cxECGmPjN5E='),
    (9, 'Rajat Kapoor', '56HIJK1234L5M6N', '234, Garden Road', 'Lucknow', 'rajat@hotmail.com', '8901234567', '226001','cnTymOnLs6Y//cb46f9lQ3G+QYD6hE7C/r76SksNExQ='),
    (10, 'Meera Gupta', '78OPQR5678S9T0U', '789, Oak Street', 'Chandigarh', 'meera@gmail.com', '9876543210', '160001','ctSJrjF28PzUsmM9KqPdOvVo7flW0q9qmbXPGD85l3U='),
    (11, 'Amit Dubey', '90UVWX1234Y5Z6A', '321, Maple Lane', 'Ahmedabad', 'amit@yahoo.com', '8765432109', '380001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (12, 'Pooja Reddy', '12BCDE5678F9G1H', '456, Sunset Avenue', 'Bhopal', 'pooja@hotmail.com', '8901234567', '462001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (13, 'Rahul Jain', '34EFGH1234I5J6K', '123, Ocean Road', 'Kochi', 'rahul@gmail.com', '9876543211', '682001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (14, 'Deepika Sharma', '56IJKL5678M9N0O', '234, Forest Lane', 'Guwahati', 'deepika@yahoo.com', '8765432101', '781001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (15, 'Mohan Das', '78MNOP1234Q5R6S', '789, Riverfront Road', 'Varanasi', 'mohan@hotmail.com', '7890123456', '221001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (16, 'Anjali Khanna', '90STUV5678W9X0Y', '321, Hilltop Avenue', 'Dehradun', 'anjali@gmail.com', '9876543210', '248001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (17, 'Ramesh Gupta', '12WXYZ1234A5B6C', '456, Valley Road', 'Shimla', 'ramesh@yahoo.com', '8901234567', '171001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (18, 'Aisha Khan', '34ABCD5678E9F1G', '123, Hillside Lane', 'Jammu', 'aisha@hotmail.com', '8765432109', '180001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (19, 'Sanjay Verma', '56HIJK1234L5M6N', '234, Garden Lane', 'Srinagar', 'sanjay@gmail.com', '9876543211', '190001','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c='),
    (20, 'Preeti Kapoor', '78OPQR5678S9T0U', '789, Lakeside Avenue', 'Leh', 'preeti@yahoo.com', '8901234567', '194101','0lAzpMJa7dZl5SGy5s5WVbqZfu1mzNXGz6LBtmHiz4c=');
    -- Create a table for invoice information
CREATE TABLE Invoices (
    InvoiceID INT PRIMARY KEY,
    InvoiceDate DATE,
    OrderID INT,
    CustomerID INT,
    CustomerName VARCHAR(255),
    ProductIDs VARCHAR(255),
    GSTType VARCHAR(20),
    TotalGSTAmount DECIMAL(10, 2),
    TotalInvoiceValue DECIMAL(10, 2),
    Status VARCHAR(20)
);

select * from Invoices;
desc Invoices;
-- Insert 20 sample invoices
INSERT INTO Invoices (InvoiceID, InvoiceDate, OrderID, CustomerID, CustomerName, ProductIDs, GSTType, TotalGSTAmount, TotalInvoiceValue, Status)
VALUES
    (1, '2023-09-14', 1, 1, 'Rajesh Sharma', '101,102', 'Same State', 13500.00, 155500.00, 'Paid'),
    (2, '2023-09-14', 2, 2, 'Priya Patel', '103,104', 'Inter-State', 7500.00, 100900.00, 'Paid'),
    (3, '2023-09-15', 3, 3, 'Arjun Singhania', '105,106', 'Same State', 980.00, 11080.00, 'Paid'),
    (4, '2023-09-15', 4, 4, 'Sneha Desai', '107,108', 'Inter-State', 4000.00, 27000.00, 'Unpaid'),
    (5, '2023-09-16', 5, 5, 'Anand Verma', '109,110', 'Same State', 550.00, 12850.00, 'Paid'),
    (6, '2023-09-16', 6, 6, 'Ayesha Khan', '111,112', 'Inter-State', 160.00, 2760.00, 'Paid'),
    (7, '2023-09-17', 7, 7, 'Vikram Patel', '113,114', 'Same State', 76.00, 1684.00, 'Unpaid'),
    (8, '2023-09-17', 8, 8, 'Nisha Sharma', '115,116', 'Inter-State', 220.00, 10240.00, 'Paid'),
    (9, '2023-09-18', 9, 9, 'Rajat Kapoor', '117,118', 'Same State', 126.00, 5776.00, 'Paid'),
    (10, '2023-09-18', 10, 10, 'Meera Gupta', '119,120', 'Inter-State', 160.00, 6860.00, 'Unpaid'),
    (11, '2023-09-19', 11, 11, 'Amit Dubey', '101,102,103', 'Same State', 21750.00, 244750.00, 'Paid'),
    (12, '2023-09-19', 12, 12, 'Pooja Reddy', '104,105,106', 'Inter-State', 8250.00, 94850.00, 'Paid'),
    (13, '2023-09-20', 13, 13, 'Rahul Jain', '107,108,109', 'Same State', 1320.00, 15180.00, 'Unpaid'),
    (14, '2023-09-20', 14, 14, 'Deepika Sharma', '110,111,112', 'Inter-State', 2220.00, 25430.00, 'Paid'),
    (15, '2023-09-21', 15, 15, 'Mohan Das', '113,114,115', 'Same State', 270.00, 3080.00, 'Paid'),
    (16, '2023-09-21', 16, 16, 'Anjali Khanna', '116,117,118', 'Inter-State', 2060.00, 23680.00, 'Unpaid'),
    (17, '2023-09-22', 17, 17, 'Ramesh Gupta', '119,120,101', 'Same State', 15600.00, 177100.00, 'Paid'),
    (18, '2023-09-22', 18, 18, 'Aisha Khan', '102,103,104', 'Inter-State', 6300.00, 72000.00, 'Paid'),
    (19, '2023-09-23', 19, 19, 'Sanjay Verma', '105,106,107', 'Same State', 300.00, 3430.00, 'Unpaid'),
    (20, '2023-09-23', 20, 20, 'Preeti Kapoor', '108,109,110', 'Inter-State', 1160.00, 13220.00, 'Paid');

-- Create a table for order information
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    OrderDate DATE,
    CustomerID INT,
    CustomerName VARCHAR(255),
    ShippingAddress VARCHAR(255),
    ProductIDs VARCHAR(255),
    TotalOrderValue DECIMAL(10, 2),
    ShippingCost DECIMAL(10, 2),
    ShippingAgency VARCHAR(100),
    Status ENUM('PENDING','APPROVED','COMPLETE','EXPIRED','INVOICED'),
    InvoiceID INT
);

select * from Orders;
use code_fury_database;
desc Orders;
-- Insert 20 sample orders
INSERT INTO Orders (OrderID, OrderDate, CustomerID, CustomerName, ShippingAddress, ProductIDs, TotalOrderValue, ShippingCost, ShippingAgency, Status,InvoiceID)
VALUES
    (1, '2023-09-14', 1, 'Rajesh Sharma', '123, Main Street, Mumbai', '101,102', 105000.00, 500.00, 'ABC Shipping', 1,1),
    (2, '2023-09-14', 2, 'Priya Patel', '456, Park Avenue, Delhi', '103,104', 75000.00, 400.00, 'XYZ Logistics', 2,2),
    (3, '2023-09-15', 3, 'Arjun Singhania', '789, Lake Road, Kolkata', '105,106', 8000.00, 100.00, 'FastShip', 3,3),
    (4, '2023-09-15', 4, 'Sneha Desai', '321, Green Lane, Bangalore', '107,108', 20000.00, 200.00, 'Swift Couriers', 1,4),
    (5, '2023-09-16', 5, 'Anand Verma', '234, River Street, Chennai', '109,110', 11000.00, 150.00, 'Reliable Shippers', 5,5),
    (6, '2023-09-16', 6, 'Ayesha Khan', '789, Hill Road, Hyderabad', '111,112', 1600.00, 50.00, 'Express Cargo', 3,6),
    (7, '2023-09-17', 7, 'Vikram Patel', '456, Sunshine Avenue, Pune', '113,114', 900.00, 40.00, 'Global Express', 2,7),
    (8, '2023-09-17', 8, 'Nisha Sharma', '123, Rose Street, Jaipur', '115,116', 8600.00, 110.00, 'Swift Couriers', 2,8),
    (9, '2023-09-18', 9, 'Rajat Kapoor', '234, Garden Road, Lucknow', '117,118', 4500.00, 60.00, 'ABC Shipping', 3,9),
    (10, '2023-09-18', 10, 'Meera Gupta', '789, Oak Street, Chandigarh', '119,120', 5000.00, 80.00, 'Express Cargo', 2,10),
    (11, '2023-09-19', 11, 'Amit Dubey', '321, Maple Lane, Ahmedabad', '101,102,103', 145000.00, 300.00, 'Swift Couriers', 2,11),
    (12, '2023-09-19', 12, 'Pooja Reddy', '456, Sunset Avenue, Bhopal', '104,105,106', 105000.00, 200.00, 'ABC Shipping', 3,12),
    (13, '2023-09-20', 13, 'Rahul Jain', '123, Ocean Road, Kochi', '107,108,109', 18000.00, 100.00, 'Reliable Shippers', 1,13),
    (14, '2023-09-20', 14, 'Deepika Sharma', '234, Forest Lane, Guwahati', '110,111,112', 1850.00, 30.00, 'Express Cargo', 2,14),
    (15, '2023-09-21', 15, 'Mohan Das', '789, Riverfront Road, Varanasi', '113,114,115', 2700.00, 50.00, 'Global Express', 3,15),
    (16, '2023-09-21', 16, 'Anjali Khanna', '321, Hilltop Avenue, Dehradun', '116,117,118', 10500.00, 120.00, 'Swift Couriers', 1,16),
    (17, '2023-09-22', 17, 'Ramesh Gupta', '456, Valley Road, Shimla', '119,120,101', 113500.00, 200.00, 'ABC Shipping', 2,17),
    (18, '2023-09-22', 18, 'Aisha Khan', '123, Hillside Lane, Jammu', '102,103,104', 105000.00, 150.00, 'Reliable Shippers', 3,18),
    (19, '2023-09-23', 19, 'Sanjay Verma', '234, Garden Lane, Srinagar', '105,106,107', 5300.00, 70.00, 'Express Cargo', 1,19),
    (20, '2023-09-23', 20, 'Preeti Kapoor', '789, Lakeside Avenue, Leh', '108,109,110', 12500.00, 180.00, 'Global Express', 5,20);

-- Create a table for product information
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    Name VARCHAR(255),
    Price DECIMAL(10, 2),
    Category  ENUM('Level_1','Level_2','Level_3')
);
desc Products;
ALTER TABLE Products MODIFY COLUMN Category VARCHAR(255);
select * from Products;
-- Insert the 20 product records into the table
INSERT INTO Products (ProductID, Name, Price, Category)
VALUES
    (101, 'Laptop', 75000.00, 1),
    (102, 'Smartphone', 30000.00, 1),
    (103, 'LED TV', 40000.00, 1),
    (104, 'Refrigerator', 35000.00, 1),
    (105, 'Washing Machine', 28000.00, 1),
    (106, 'Bluetooth Speaker', 2000.00, 2),
    (107, 'Noise-Canceling Headphones', 5000.00, 2),
    (108, 'Digital Camera', 15000.00, 2),
    (109, 'Fitness Tracker', 3000.00, 2),
    (110, 'Smartwatch', 8000.00, 2),
    (111, 'Basketball', 500.00, 3),
    (112, 'Tennis Racket', 1000.00, 3),
    (113, 'Yoga Mat', 300.00, 3),
    (114, 'Chess Set', 600.00, 3),
    (115, 'Board Game', 800.00, 3),
    (116, 'Microwave Oven', 6000.00, 1),
    (117, 'Blender', 2500.00, 1),
    (118, 'Coffee Maker', 2000.00, 1),
    (119, 'Toaster', 1500.00, 1),
    (120, 'Food Processor', 3500.00, 1);

-- Create a table for quote information
CREATE TABLE Quotes (
    QuoteID INT PRIMARY KEY,
    OrderDate DATE,
    CustomerName VARCHAR(255),
    CustomerGSTNo VARCHAR(15),
    ShippingAddress VARCHAR(255),
    CustomerCity VARCHAR(255),
    PhoneNumber VARCHAR(15),
    Email VARCHAR(255),
    PinCode VARCHAR(10),
    ShippingCost DECIMAL(10, 2),
    TotalOrderValue DECIMAL(10, 2),
    Status VARCHAR(20)
);
select * from Quotes;
-- Insert 20 quote records
INSERT INTO Quotes (QuoteID, OrderDate, CustomerName, CustomerGSTNo, ShippingAddress, CustomerCity, PhoneNumber, Email, PinCode, ShippingCost, TotalOrderValue, Status)
VALUES
    (1, '2023-09-14', 'Rajesh Sharma', '29ABCDE1234F1Z5', '123 Main Street', 'Mumbai', '9876543210', 'rajesh@gmail.com', '400001', 500.00, 155500.00, 'Pending'),
    (2, '2023-09-14', 'Priya Patel', '08XYZF5678G2H9', '456 Park Avenue', 'Delhi', '8901234567', 'priya@yahoo.com', '110001', 400.00, 100900.00, 'Approved'),
    (3, '2023-09-15', 'Arjun Singhania', '12PQRS9876T3U4V', '789 Lake Road', 'Kolkata', '7654321098', 'arjun@hotmail.com', '700001', 100.00, 11080.00, 'Complete'),
    (4, '2023-09-15', 'Sneha Desai', '45MNOB1234A5C6D', '321 Green Lane', 'Bangalore', '8765432109', 'sneha@gmail.com', '560001', 200.00, 27000.00, 'Pending'),
    (5, '2023-09-16', 'Anand Verma', '67EFGH5678I9J0K', '234 River Street', 'Chennai', '7890123456', 'anand@yahoo.com', '600001', 150.00, 12850.00, 'Approved'),
    (6, '2023-09-16', 'Ayesha Khan', '89QRST1234U5V6W', '789 Hill Road', 'Hyderabad', '9876543211', 'ayesha@hotmail.com', '500001', 50.00, 2760.00, 'Complete'),
    (7, '2023-09-17', 'Vikram Patel', '23UVWX6789Y0Z1A', '456 Sunshine Avenue', 'Pune', '8765432101', 'vikram@gmail.com', '411001', 40.00, 1684.00, 'Pending'),
    (8, '2023-09-17', 'Nisha Sharma', '34ABCD5678E9F1G', '123 Rose Street', 'Jaipur', '7890123456', 'nisha@yahoo.com', '302001', 110.00, 10240.00, 'Approved'),
    (9, '2023-09-18', 'Rajat Kapoor', '56HIJK1234L5M6N', '234 Garden Road', 'Lucknow', '8901234567', 'rajat@hotmail.com', '226001', 60.00, 5776.00, 'Complete'),
    (10, '2023-09-18', 'Meera Gupta', '78OPQR5678S9T0U', '789 Oak Street', 'Chandigarh', '9876543210', 'meera@gmail.com', '160001', 80.00, 6860.00, 'Pending'),
    (11, '2023-09-19', 'Amit Dubey', '90UVWX1234Y5Z6A', '321 Maple Lane', 'Ahmedabad', '8765432109', 'amit@yahoo.com', '380001', 300.00, 244750.00, 'Approved'),
    (12, '2023-09-19', 'Pooja Reddy', '12BCDE5678F9G1H', '456 Sunset Avenue', 'Bhopal', '8901234567', 'pooja@hotmail.com', '462001', 200.00, 94850.00, 'Complete'),
    (13, '2023-09-20', 'Rahul Jain', '34EFGH1234I5J6K', '123 Ocean Road', 'Kochi', '9876543211', 'rahul@gmail.com', '682001', 100.00, 15180.00, 'Pending'),
    (14, '2023-09-20', 'Deepika Sharma', '56IJKL5678M9N0O', '234 Forest Lane', 'Guwahati', '8765432101', 'deepika@yahoo.com', '781001', 30.00, 25430.00, 'Approved'),
    (15, '2023-09-21', 'Mohan Das', '78MNOP1234Q5R6S', '789 Riverfront Road', 'Varanasi', '7890123456', 'mohan@hotmail.com', '221001', 50.00, 3080.00, 'Complete'),
    (16, '2023-09-21', 'Anjali Khanna', '90STUV5678W9X0Y', '321 Hilltop Avenue', 'Dehradun', '9876543210', 'anjali@gmail.com', '248001', 120.00, 23680.00, 'Pending'),
    (17, '2023-09-22', 'Ramesh Gupta', '12WXYZ1234A5B6C', '456 Valley Road', 'Shimla', '8901234567', 'ramesh@yahoo.com', '171001', 200.00, 177100.00, 'Approved'),
    (18, '2023-09-22', 'Aisha Khan', '34ABCD5678E9F1G', '123 Hillside Lane', 'Jammu', '8765432109', 'aisha@hotmail.com', '180001', 150.00, 72000.00, 'Complete'),
    (19, '2023-09-23', 'Sanjay Verma', '56HIJK1234L5M6N', '234 Garden Lane', 'Srinagar', '7890123456', 'sanjay@gmail.com', '190001', 70.00, 3430.00, 'Pending'),
    (20, '2023-09-23', 'Preeti Kapoor', '78OPQR5678S9T0U', '789 Lakeside Avenue', 'Leh', '9876543211', 'preeti@yahoo.com', '194101', 180.00, 13220.00, 'Approved');


select * from Quotes;