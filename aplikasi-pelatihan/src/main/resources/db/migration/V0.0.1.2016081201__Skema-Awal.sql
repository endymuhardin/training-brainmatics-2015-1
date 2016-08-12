CREATE TABLE `materi` (
  `id` varchar(255) NOT NULL,
  `kode` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_61lgf31ivihw8ysmi0br0hmge` (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `peserta` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4pf6h2ver6d4igrrq6vvo4dbv` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sesi` (
  `id` varchar(255) NOT NULL,
  `mulai` date DEFAULT NULL,
  `sampai` date DEFAULT NULL,
  `id_materi` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ll8gwi7iocrsgc11wftyb2dwf` (`id_materi`),
  CONSTRAINT `FK_ll8gwi7iocrsgc11wftyb2dwf` FOREIGN KEY (`id_materi`) REFERENCES `materi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `peserta_pelatihan` (
  `id_sesi` varchar(255) NOT NULL,
  `id_peserta` varchar(255) NOT NULL,
  KEY `FK_nu06xg3gshjdqajpjunsaoxeb` (`id_peserta`),
  KEY `FK_n0ten5mrabvefx4c59xlyvbea` (`id_sesi`),
  CONSTRAINT `FK_n0ten5mrabvefx4c59xlyvbea` FOREIGN KEY (`id_sesi`) REFERENCES `sesi` (`id`),
  CONSTRAINT `FK_nu06xg3gshjdqajpjunsaoxeb` FOREIGN KEY (`id_peserta`) REFERENCES `peserta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `s_roles` (
  `id` varchar(36) NOT NULL,
  `nama` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `s_user_role` (
  `id_user` varchar(36) NOT NULL,
  `id_role` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `s_users` (
  `id` varchar(36) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
