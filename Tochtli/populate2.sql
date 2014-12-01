INSERT INTO `category` (`ID`, `DESCRIPTION`, `NAME`, `PHOTO_PATH`) VALUES
(1, 'A tamale is a traditional Mesoamerican dish made of masa which is steamed or boiled in a leaf wrapper. ', 'Tamales', 'tamales/t1.JPG'),
(2, 'Mole is a Mexican sauce made from chili peppers, other spices, and chocolate', 'Mole', 'mole/mole1.JPG'),
(3, 'Something unknown', 'Masa', 'tamales/t2.JPG');

INSERT INTO `ordered_product` (`ID`, `quantity`, `order_id`, `prodct_id`) VALUES
(1, 5, 1, 1),
(2, 1, 4, 3),
(3, 1, 4, 2),
(4, 4, 5, 2);

INSERT INTO `product` (`ID`, `ACTIVE`, `NAME`, `PHOTO_PATH`, `PRICE`, `STOCK`, `UNITS`, `category`) VALUES
(1, 1, 'Tamales T1', '/tamales/t1.JPG', 12.2, 50, 'KG', 1),
(2, 1, 'Mole 22', '/mole/mole2.JPG', 128, 12, 'KG', 2),
(3, 1, '1111', '/tch.jpg', 89, 29, 'uni', 3);

INSERT INTO `t_order` (`ID`, `DATE`, `TOTAL`, `user`) VALUES
(1, '2014-12-01 14:44:12', 61, 1),
(2, '2014-12-02 00:00:00', 0, 1),
(3, '2013-11-05 00:00:00', 12, 1),
(4, '2014-06-01 20:21:56', 217, 2),
(5, '2013-12-01 20:25:55', 512, 3);

INSERT INTO `user` (`ID`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PHONE`) VALUES
(1, 'adella.neacsu@gmail.com', 'ww', 'dd', 'qqqq'),
(2, 'somarariana@yahoo.com', 'Sorana', 'Last', '07698'),
(3, 'e@w.e', 'e', 'e', '07522');