-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.24-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para todoapp
CREATE DATABASE IF NOT EXISTS `todoapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `todoapp`;

-- Copiando estrutura para tabela todoapp.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `dataCriacao` datetime NOT NULL,
  `dataModificacao` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela todoapp.projects: ~5 rows (aproximadamente)
INSERT INTO `projects` (`id`, `nome`, `descricao`, `dataCriacao`, `dataModificacao`) VALUES
	(1, 'Novo Nome Projeto', 'Meu projeto teste', '2023-03-08 00:00:00', '2023-03-08 00:00:00'),
	(2, 'Projeto Teste GUI', 'Primeiro projeto cadastrado através da interface gráfica\ncriado no Java, interface criada para o projeto Todo APP.', '2023-03-09 00:00:00', '2023-03-09 00:00:00'),
	(3, 'Mais um Projeto', 'TEste de mais um projeto', '2023-03-09 00:00:00', '2023-03-09 00:00:00'),
	(4, 'teste de outro projeto', 'testando loadProjects() diferente do proposto no projeto original', '2023-03-09 00:00:00', '2023-03-09 00:00:00'),
	(5, 'novo projeto2', 'teste medodo mainScreen.loadProjects();', '2023-03-09 00:00:00', '2023-03-09 00:00:00'),
	(6, 'teste loadProjects()', 'teste da metodologia do jeito proposto pela implementação do projeto', '2023-03-09 00:00:00', '2023-03-09 00:00:00'),
	(7, 'Teste10/03', 'projeto teste', '2023-03-10 00:00:00', '2023-03-10 00:00:00');

-- Copiando estrutura para tabela todoapp.tasks
CREATE TABLE IF NOT EXISTS `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `prazo` date NOT NULL,
  `dataCriacao` datetime NOT NULL,
  `dataModificacao` datetime NOT NULL,
  `idProj` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tasks_ibfk_1` (`idProj`) USING BTREE,
  CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`idProj`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela todoapp.tasks: ~11 rows (aproximadamente)
INSERT INTO `tasks` (`id`, `nome`, `descricao`, `status`, `observacao`, `prazo`, `dataCriacao`, `dataModificacao`, `idProj`) VALUES
	(1, 'Tarefa 1 Modificada', 'Tarefa teste2 Modificada', 1, 'Observação2 Modificada', '2023-03-09', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 1),
	(2, 'Tarefa 2', 'Tarefa teste2', 1, 'Observação2', '2023-03-09', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 1),
	(3, 'Tarefa 3', 'Tarefa 3', 1, 'Observação 3', '2023-03-09', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 1),
	(4, 'Minha primeira tarefa GUI', 'Tarefa criada pela interface gráfica do aplicativo Todo App', 1, 'tarefa criada com interface gráfica', '2023-03-31', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 2),
	(5, 'Tarefa 2 teste', 'Criação da tarefa via interface gráfica para testes', 0, 'teste tarefa nlnasldncl\ncasdcasd\ncasdcasd\nasdcasdc', '2023-04-05', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 2),
	(6, 'tarefa3', 'teste de inclusão de tarefa', 1, 'testes notas', '2023-03-15', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 2),
	(7, 'tarefa 1', 'tarefa do projeto mais um projeto', 1, 'testes', '2023-04-05', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 3),
	(8, 'Tarefa 2', 'teste de tarefa', 0, 'teste', '2023-05-04', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 3),
	(9, 'teste', 'Tarefa teste ', 1, 'teste hkajdgb', '2022-05-04', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 4),
	(12, 'teste2', 'ajsdbncvjklabd', 0, 'asndkjbcnjklabsdl', '2023-03-11', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 4),
	(13, 'teste 3', 'ascvasfdvbasf', 0, 'sdcfafasdfbasdfbasdfvbasdf', '2023-05-08', '2023-03-09 00:00:00', '2023-03-09 00:00:00', 4),
	(14, 'teste de tarefa', 'teste', 0, 'teste', '2023-03-10', '2023-03-10 00:00:00', '2023-03-10 00:00:00', 7);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
