INSERT INTO `materi` VALUES 
('aa6','JF-001','Java Fundamental'),
('aa7','JF-002','Java Web'),
('aa8','MB-001','Android Fundamental'),
('aa9','MB-002','iOS Fundamental');

INSERT INTO `peserta` VALUES 
('aa1','peserta.test.001@gmail.com','Peserta Test 001','2011-01-01'),
('aa2','peserta.test.002@gmail.com','Peserta Test 002','2011-01-02'),
('aa3','peserta.test.003@gmail.com','Peserta Test 003','2011-01-03');

INSERT INTO `sesi` VALUES 
('aa','2015-01-01','2015-01-05','aa6'),
('ab','2015-01-08','2015-01-12','aa6'),
('ac','2015-01-01','2015-01-05','aa7');

INSERT INTO `peserta_pelatihan` VALUES 
('aa','aa1'),
('aa','aa2'),
('aa','aa3'),
('ab','aa2'),
('ab','aa3'),
('ac','aa2');

INSERT INTO `s_roles` VALUES 
('adm','ROLE_ADMIN'),('stf','ROLE_STAFF');

INSERT INTO `s_users` VALUES 
('u001','endy','123',1),('u002','adi','123',1);

INSERT INTO `s_user_role` VALUES 
('u001','adm'),('u001','stf'),('u002','stf');
