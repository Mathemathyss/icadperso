-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 07 mars 2024 à 11:13
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `icad1`
--

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--

CREATE TABLE `animal` (
  `ID_ICAD` int(11) NOT NULL,
  `ID_PROPRIO` int(11) NOT NULL,
  `NOM_ANIMAL` varchar(50) NOT NULL,
  `DATE_NAISSANCE_ANIMAL` date NOT NULL,
  `RACE_ANIMAL` varchar(50) NOT NULL,
  `ESPECE_ANIMAL` int(50) NOT NULL,
  `SEXE_ANIMAL` int(50) NOT NULL,
  `INFO_ANIMAL` varchar(150) NOT NULL,
  `IS_PERDU_ANIMAL` tinyint(1) NOT NULL DEFAULT 0,
  `IS_SUPPRIMER` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `animal`
--

INSERT INTO `animal` (`ID_ICAD`, `ID_PROPRIO`, `NOM_ANIMAL`, `DATE_NAISSANCE_ANIMAL`, `RACE_ANIMAL`, `ESPECE_ANIMAL`, `SEXE_ANIMAL`, `INFO_ANIMAL`, `IS_PERDU_ANIMAL`, `IS_SUPPRIMER`) VALUES
(10, 3, 'John', '2023-12-01', 'Mastiff', 2, 1, ' Tâches rousses sur le dos. ', 1, 0),
(11, 3, 'Jack', '2023-12-01', 'Pixie-bob', 1, 1, 'Curieux', 0, 1),
(12, 8, 'Bug', '2023-11-01', 'Zibeline', 3, 1, 'Il court vite !', 0, 0),
(13, 7, 'Bob', '2023-10-04', 'York Chocolate Cat', 1, 1, 'Rapide.', 0, 0),
(14, 7, 'Cat', '2023-06-22', 'Ocicat', 1, 2, 'On dirait un tigre', 1, 0),
(15, 6, 'Lo', '2023-12-06', 'Colorpoint', 1, 2, 'Calme', 0, 0),
(16, 8, 'Plume', '2023-11-16', ' Norwegian Forest', 1, 2, 'Monte sur les arbres', 0, 0),
(17, 6, 'Sax', '2023-12-03', ' Otterhound', 2, 1, 'Aucun', 0, 0),
(18, 3, 'Feu', '2023-12-01', 'English Toy Terrier', 2, 2, 'Aucun', 0, 0),
(20, 8, 'Poil', '2023-11-15', 'Newfoundland', 2, 1, 'poil', 0, 0),
(21, 6, 'Redw', '2023-12-02', 'Irish Red and White Setter', 2, 2, 'Fais de la course de compétition', 0, 0),
(22, 7, 'Nesquik', '2023-12-04', 'Chocolat self', 3, 2, 'Aucun', 0, 0),
(23, 3, 'Naya', '2023-09-22', 'Chocolat roan', 3, 2, 'Furtif', 0, 0),
(24, 8, 'Honey', '2022-10-12', 'Cannelle angora', 3, 1, 'Aime la terre', 0, 0),
(25, 6, 'Chips', '2023-12-05', 'Black self poils courts', 3, 1, 'poils courts', 0, 0),
(26, 7, 'Midnight', '2023-07-31', 'Black solid', 3, 1, 'Aucun', 0, 0);

--
-- Déclencheurs `animal`
--
DELIMITER $$
CREATE TRIGGER `after_insert_animal` AFTER INSERT ON `animal` FOR EACH ROW BEGIN
INSERT INTO log_animal(ID_ICAD, NOM_ANIMAL, DATE_NAISSANCE_ANIMAL, ESPECE_ANIMAL, SEXE_ANIMAL, RACE_ANIMAL, INFO_ANIMAL, ID_PROPRIO, TYPE_ACTION) 
VALUES ( NEW.ID_ICAD, NEW.NOM_ANIMAL, NEW.DATE_NAISSANCE_ANIMAL, NEW.ESPECE_ANIMAL, NEW.SEXE_ANIMAL, NEW.RACE_ANIMAL, NEW.INFO_ANIMAL, NEW.ID_PROPRIO, "Ajout");
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_animal` AFTER UPDATE ON `animal` FOR EACH ROW BEGIN
INSERT INTO log_animal(ID_ICAD, NOM_ANIMAL, DATE_NAISSANCE_ANIMAL, ESPECE_ANIMAL, SEXE_ANIMAL, RACE_ANIMAL, INFO_ANIMAL, ID_PROPRIO, TYPE_ACTION, IS_PERDU_ANIMAL) 
VALUES ( NEW.ID_ICAD, NEW.NOM_ANIMAL, NEW.DATE_NAISSANCE_ANIMAL, NEW.ESPECE_ANIMAL, NEW.SEXE_ANIMAL, NEW.RACE_ANIMAL, NEW.INFO_ANIMAL, NEW.ID_PROPRIO, "Modification", NEW.IS_PERDU_ANIMAL);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `declarer_retrouve_animal`
--

CREATE TABLE `declarer_retrouve_animal` (
  `ID_RETROUVE` int(11) NOT NULL,
  `ID_ANIMAL` int(11) NOT NULL,
  `EMAIL_DEMANDE` varchar(100) NOT NULL,
  `TELEPHONE_DEMANDE` int(10) NOT NULL,
  `DATE_RETROUVE` datetime NOT NULL DEFAULT current_timestamp(),
  `INFORMATIONS_SUPPLEMENTAIRES` varchar(100) NOT NULL,
  `IMAGE` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `declarer_retrouve_animal`
--

INSERT INTO `declarer_retrouve_animal` (`ID_RETROUVE`, `ID_ANIMAL`, `EMAIL_DEMANDE`, `TELEPHONE_DEMANDE`, `DATE_RETROUVE`, `INFORMATIONS_SUPPLEMENTAIRES`, `IMAGE`) VALUES
(2, 12, 'animal@retrouve.com', 987678789, '2023-12-03 20:59:39', 'C\'est un chat avec un numéro ICAD 12 sur son collier.', ''),
(3, 0, '', 0, '2023-12-07 08:43:21', '', ''),
(4, 0, '', 0, '2023-12-07 08:43:31', '', ''),
(5, 0, '', 0, '2023-12-07 08:43:36', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `espece_animal`
--

CREATE TABLE `espece_animal` (
  `ID_ESPECE` int(11) NOT NULL,
  `NOM_ESPECE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `espece_animal`
--

INSERT INTO `espece_animal` (`ID_ESPECE`, `NOM_ESPECE`) VALUES
(1, 'Chat'),
(2, 'Chien'),
(3, 'Furet');

-- --------------------------------------------------------

--
-- Structure de la table `log_animal`
--

CREATE TABLE `log_animal` (
  `id` int(11) NOT NULL,
  `DATE_NAISSANCE_ANIMAL` date NOT NULL,
  `ESPECE_ANIMAL` int(11) NOT NULL,
  `ID_PROPRIO` int(11) NOT NULL,
  `ID_ICAD` int(11) NOT NULL,
  `INFO_ANIMAL` varchar(100) NOT NULL,
  `NOM_ANIMAL` varchar(100) NOT NULL,
  `SEXE_ANIMAL` int(11) NOT NULL,
  `RACE_ANIMAL` varchar(100) NOT NULL,
  `DATE_ACTION` datetime NOT NULL DEFAULT current_timestamp(),
  `TYPE_ACTION` varchar(100) NOT NULL,
  `IS_PERDU_ANIMAL` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `log_animal`
--

INSERT INTO `log_animal` (`id`, `DATE_NAISSANCE_ANIMAL`, `ESPECE_ANIMAL`, `ID_PROPRIO`, `ID_ICAD`, `INFO_ANIMAL`, `NOM_ANIMAL`, `SEXE_ANIMAL`, `RACE_ANIMAL`, `DATE_ACTION`, `TYPE_ACTION`, `IS_PERDU_ANIMAL`) VALUES
(15, '2023-12-01', 2, 3, 10, 'Tâches rousses sur le dos.', 'John', 1, 'Mastiff', '2023-12-03 12:28:40', 'Ajout', 0),
(16, '2023-12-01', 2, 3, 10, 'Tâches rousses sur le dos.', 'John', 1, 'Mastiff', '2023-12-03 12:31:05', 'Modification', 0),
(17, '2023-12-01', 1, 3, 11, 'Se fâche très fréquemment !', 'Jack', 1, 'Pixie-bob', '2023-12-03 12:33:49', 'Ajout', 0),
(18, '2023-12-01', 1, 3, 11, 'Se fâche très fréquemment !', 'Jack', 1, 'Pixie-bob', '2023-12-03 12:35:42', 'Modification', 0),
(19, '2023-12-01', 1, 3, 11, ' Se fâche très fréquemment ! ', 'Jack', 1, 'Pixie-bob', '2023-12-03 12:44:28', 'Modification', 0),
(20, '2023-12-01', 2, 3, 11, 'Se fâche très fréquemment ! Mais je l\'adore ! ', 'Jack', 1, 'Pixie-bob', '2023-12-03 12:45:58', 'Modification', 0),
(21, '2023-12-01', 1, 3, 10, ' Tâches rousses sur le dos. ', 'John', 1, 'Mastiff', '2023-12-03 14:37:04', 'Modification', 1),
(22, '2023-11-01', 3, 8, 12, 'Il court vite !', 'Bug', 1, 'Zibeline', '2023-12-03 18:05:10', 'Ajout', 0),
(23, '2023-11-01', 1, 8, 12, 'Il court vite !', 'Bug', 1, 'Zibeline', '2023-12-03 18:06:04', 'Modification', 0),
(24, '2023-12-01', 1, 3, 11, 'Je me calme...', 'Jack', 1, 'Pixie-bob', '2023-12-03 18:33:45', 'Modification', 0),
(25, '2023-11-01', 3, 8, 12, 'Il court vite !', 'Bug', 1, 'Zibeline', '2023-12-03 18:33:51', 'Modification', 0),
(26, '2023-12-01', 2, 3, 10, ' Tâches rousses sur le dos. ', 'John', 1, 'Mastiff', '2023-12-03 18:33:58', 'Modification', 1),
(27, '2023-10-04', 1, 7, 13, 'Rapide.', 'Bob', 1, 'York Chocolate Cat', '2023-12-06 18:14:10', 'Ajout', 0),
(28, '2023-10-04', 1, 7, 13, 'Rapide.', 'Bob', 1, 'York', '2023-12-06 18:14:29', 'Modification', 0),
(29, '2023-06-22', 1, 7, 14, 'On dirait un tigre', 'Cat', 2, 'Ocicat', '2023-12-06 18:16:36', 'Ajout', 0),
(30, '2023-06-22', 1, 7, 14, 'On dirait un tigre', 'Cat', 2, 'Ocicat', '2023-12-06 18:16:45', 'Modification', 0),
(31, '2023-12-06', 1, 6, 15, 'Calme', 'Lo', 2, ' Colorpoint Shorthair', '2023-12-06 18:18:59', 'Ajout', 0),
(32, '2023-12-06', 1, 6, 15, 'Calme', 'Lo', 2, 'Colorpoint', '2023-12-06 18:19:26', 'Modification', 0),
(33, '2023-12-01', 1, 3, 11, 'Curieux', 'Jack', 1, 'Pixie-bob', '2023-12-06 18:19:55', 'Modification', 0),
(34, '2023-10-04', 1, 7, 13, 'Rapide.', 'Bob', 1, 'York Chocolate Cat', '2023-12-06 18:20:43', 'Modification', 0),
(35, '2023-11-16', 1, 8, 16, 'Monte sur les arbres', 'Plume', 2, ' Norwegian Forest', '2023-12-06 18:24:57', 'Ajout', 0),
(36, '2023-11-16', 1, 8, 16, 'Monte sur les arbres', 'Plume', 2, ' Norwegian Forest', '2023-12-06 18:25:05', 'Modification', 0),
(37, '2023-12-03', 2, 6, 17, 'Aucun', 'Sax', 1, ' Otterhound', '2023-12-06 18:28:00', 'Ajout', 0),
(38, '2023-12-03', 2, 6, 17, 'Aucun', 'Sax', 1, ' Otterhound', '2023-12-06 18:33:18', 'Modification', 0),
(39, '2023-12-01', 2, 3, 18, 'Aucun', 'Feu', 2, 'English Toy Terrier', '2023-12-06 18:36:44', 'Ajout', 0),
(40, '2023-12-01', 2, 3, 18, 'Aucun', 'Feu', 2, 'English Toy Terrier', '2023-12-06 18:36:51', 'Modification', 0),
(41, '2023-12-01', 2, 3, 18, 'Aucun', 'Feu', 2, 'English Toy Terrier', '2023-12-06 18:38:32', 'Modification', 0),
(42, '2023-12-01', 2, 3, 18, 'Aucun', 'Feu', 2, 'English Toy Terrier', '2023-12-06 18:38:41', 'Modification', 0),
(43, '2023-11-15', 2, 8, 20, 'poil', 'Poil', 1, 'Newfoundland', '2023-12-06 18:40:25', 'Ajout', 0),
(44, '2023-11-15', 2, 8, 20, 'poil', 'Poil', 1, 'Newfoundland', '2023-12-06 18:40:34', 'Modification', 0),
(45, '2023-12-02', 2, 6, 21, 'Fais de la course de compétition', 'Redw', 2, 'Irish Red and White Setter', '2023-12-06 18:42:01', 'Ajout', 0),
(46, '2023-12-02', 2, 6, 21, 'Fais de la course de compétition', 'Redw', 2, 'Irish Red and White Setter', '2023-12-06 18:42:08', 'Modification', 0),
(47, '2023-12-04', 3, 7, 22, 'Aucun', 'Nesquik', 2, 'Chocolat self', '2023-12-06 18:43:38', 'Ajout', 0),
(48, '2023-12-04', 3, 7, 22, 'Aucun', 'Nesquik', 2, 'Chocolat self', '2023-12-06 18:44:03', 'Modification', 0),
(49, '2023-09-22', 3, 3, 23, 'Furtif', 'Naya', 2, 'Chocolat roan', '2023-12-06 18:46:09', 'Ajout', 0),
(50, '2023-09-22', 3, 3, 23, 'Furtif', 'Naya', 2, 'Chocolat roan', '2023-12-06 18:46:16', 'Modification', 0),
(51, '2022-10-12', 3, 8, 24, 'Aime la terre', 'Honey', 1, 'Cannelle angora', '2023-12-06 18:48:43', 'Ajout', 0),
(52, '2022-10-12', 3, 8, 24, 'Aime la terre', 'Honey', 1, 'Cannelle angora', '2023-12-06 18:48:55', 'Modification', 0),
(53, '2023-12-05', 3, 6, 25, 'poils courts', 'Chips', 1, 'Black self poils courts', '2023-12-06 18:49:55', 'Ajout', 0),
(54, '2023-12-05', 3, 6, 25, 'poils courts', 'Chips', 1, 'Black self poils courts', '2023-12-06 18:50:12', 'Modification', 0),
(55, '2023-07-31', 3, 7, 26, 'Aucun', 'Midnight', 1, 'Black solid', '2023-12-06 18:52:26', 'Ajout', 0),
(56, '2023-07-31', 3, 7, 26, 'Aucun', 'Midnight', 1, 'Black solid', '2023-12-06 18:52:33', 'Modification', 0),
(57, '2023-06-22', 1, 7, 14, 'On dirait un tigre', 'Cat', 2, 'Ocicat', '2023-12-07 08:14:39', 'Modification', 1),
(58, '2023-12-01', 1, 3, 11, 'Curieux', 'Jack', 1, 'Pixie-bob', '2023-12-07 08:36:48', 'Modification', 0);

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `ID_PROPRIO` int(2) NOT NULL,
  `EMAIL_PROPRIO` varchar(100) NOT NULL,
  `NO_TELEPHONE_PROPRIO` int(100) NOT NULL,
  `NOM_PROPRIO` varchar(100) NOT NULL,
  `PRENOM_PROPRIO` varchar(100) NOT NULL,
  `VILLE_PROPRIO` varchar(100) NOT NULL,
  `ADRESSE_PROPRIO` varchar(100) NOT NULL,
  `CP_PROPRIO` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`ID_PROPRIO`, `EMAIL_PROPRIO`, `NO_TELEPHONE_PROPRIO`, `NOM_PROPRIO`, `PRENOM_PROPRIO`, `VILLE_PROPRIO`, `ADRESSE_PROPRIO`, `CP_PROPRIO`) VALUES
(3, 'propri@gmail.com', 987654321, 'Prop', 'Rio', 'Paris', '', 75000),
(6, 'validation@mail.com', 789908990, 'Jack', 'Kcaj', 'Paris', '', 75000),
(7, 'yoyo@gmail.com', 115218037, 'oyoy', 'yoyo', 'Vigneux-sur-seine', '24 Place du Jeu de Paum', 91270),
(8, 'robertmiaou@gmail.com', 776671234, 'Miaou', 'Robert', 'Thionville', ' 24 rue du Faubourg National', 57100);

-- --------------------------------------------------------

--
-- Structure de la table `sexe_animal`
--

CREATE TABLE `sexe_animal` (
  `NOM_SEXE` varchar(50) NOT NULL,
  `ID_SEXE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `sexe_animal`
--

INSERT INTO `sexe_animal` (`NOM_SEXE`, `ID_SEXE`) VALUES
('Masculin', 1),
('Feminin', 2);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `ID_UTILISATEUR` int(2) NOT NULL,
  `EMAIL_UTILISATEUR` varchar(200) NOT NULL,
  `NO_TELEPHONE_UTILISATEUR` int(100) NOT NULL,
  `NOM_UTILISATEUR` varchar(100) NOT NULL,
  `PRENOM_UTILISATEUR` varchar(100) NOT NULL,
  `VILLE_UTILISATEUR` varchar(100) NOT NULL,
  `ADRESSE_UTILISATEUR` varchar(100) NOT NULL,
  `CP_UTILISATEUR` int(100) NOT NULL,
  `FONCTION_UTILISATEUR` varchar(100) NOT NULL,
  `MDP_HASH_UTILISATEUR` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `EMAIL_UTILISATEUR`, `NO_TELEPHONE_UTILISATEUR`, `NOM_UTILISATEUR`, `PRENOM_UTILISATEUR`, `VILLE_UTILISATEUR`, `ADRESSE_UTILISATEUR`, `CP_UTILISATEUR`, `FONCTION_UTILISATEUR`, `MDP_HASH_UTILISATEUR`) VALUES
(3, 'test@test.fr', 123456789, 'Testeur', 'Test', 'Paris', 'Musée du Louvre', 75000, 'Fourrière', '$2y$10$WHNcm0cFoNu8CvUXgPICTeEGWGwGKT3ZW4vw4tnpx1J4TUww9L.ru');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`ID_ICAD`),
  ADD KEY `ID_PROPRIO` (`ID_PROPRIO`),
  ADD KEY `SEXE_ANIMAL` (`SEXE_ANIMAL`),
  ADD KEY `ESPECE_ANIMAL` (`ESPECE_ANIMAL`);

--
-- Index pour la table `declarer_retrouve_animal`
--
ALTER TABLE `declarer_retrouve_animal`
  ADD PRIMARY KEY (`ID_RETROUVE`);

--
-- Index pour la table `espece_animal`
--
ALTER TABLE `espece_animal`
  ADD PRIMARY KEY (`ID_ESPECE`);

--
-- Index pour la table `log_animal`
--
ALTER TABLE `log_animal`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`ID_PROPRIO`);

--
-- Index pour la table `sexe_animal`
--
ALTER TABLE `sexe_animal`
  ADD PRIMARY KEY (`ID_SEXE`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`ID_UTILISATEUR`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `animal`
--
ALTER TABLE `animal`
  MODIFY `ID_ICAD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `declarer_retrouve_animal`
--
ALTER TABLE `declarer_retrouve_animal`
  MODIFY `ID_RETROUVE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `espece_animal`
--
ALTER TABLE `espece_animal`
  MODIFY `ID_ESPECE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `log_animal`
--
ALTER TABLE `log_animal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `ID_PROPRIO` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `sexe_animal`
--
ALTER TABLE `sexe_animal`
  MODIFY `ID_SEXE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `ID_UTILISATEUR` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_2` FOREIGN KEY (`ID_PROPRIO`) REFERENCES `proprietaire` (`ID_PROPRIO`),
  ADD CONSTRAINT `animal_ibfk_3` FOREIGN KEY (`SEXE_ANIMAL`) REFERENCES `sexe_animal` (`ID_SEXE`),
  ADD CONSTRAINT `animal_ibfk_4` FOREIGN KEY (`ESPECE_ANIMAL`) REFERENCES `espece_animal` (`ID_ESPECE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
