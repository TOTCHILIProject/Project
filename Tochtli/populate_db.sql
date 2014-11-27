INSERT INTO `category` (`ID`, `DESCRIPTION`, `NAME`, `PHOTO_PATH`) VALUES
(1, 'A tamale is a traditional Mesoamerican dish made of masa which is steamed or boiled in a leaf wrapper. ', 'Tamales', 'tamales/t1.JPG'),
(2, 'Mole is a Mexican sauce made from chili peppers, other spices, and chocolate', 'Mole', 'mole/mole1.JPG'),
(3, 'Something unknown', 'Masa', 'tamales/t2.JPG');

INSERT INTO `product` (`ID`, `NAME`, `PHOTO_PATH`, `PRICE`, `STOCK`, `UNITS`, `category`) VALUES
(1, 'Tamales T1', '/tamales/t1.JPG', 12.2, 50, 'KG', 1);