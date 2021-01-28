DROP DATABASE  IF EXISTS `up`;

CREATE DATABASE  IF NOT EXISTS `up`;
USE `up`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `DEV__etd`
--

-- --------------------------------------------------------

--
-- Структура таблицы `events`
--


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `user` (username,password,first_name,last_name,email)
VALUES 
('admin','$2b$10$oy9sC62W9vIDEoScfuc3fOaAmzORktLrr4LxlES9mXJojTwnmBpBG','admin','admin','admin@gmail.com'),
('user','$2b$10$oy9sC62W9vIDEoScfuc3fOaAmzORktLrr4LxlES9mXJojTwnmBpBG','user','user','user@gmail.com'),
('guest','$2b$10$oy9sC62W9vIDEoScfuc3fOaAmzORktLrr4LxlES9mXJojTwnmBpBG','guest','guest','guest@gmail.com');



CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `members`
--

CREATE TABLE `members` (
  `id` int(11) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `members`
--

INSERT INTO `members` (`id`, `user_name`, `first_name`, `last_name`, `email`, `password`, `role`) VALUES
(2, 'Admin', 'Admin', NULL, 'druzini@gmail.com', 'admin', 1),
(3, 'newUser', 'new', 'user', 'some@email.com', '1234', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `text` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `projects`
--

CREATE TABLE `projects` (
  `id` int(11) NOT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `projects_followers`
--

CREATE TABLE `projects_followers` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `projects_tasks`
--

CREATE TABLE `projects_tasks` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--
DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (name)
VALUES 
('ROLE_USER'),
('ROLE_GUEST'),
('ROLE_ADMIN');


DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `roles` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `statuses`
--

CREATE TABLE `statuses` (
  `id` int(11) NOT NULL,
  `creator` int(11) DEFAULT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `statuses`
--

INSERT INTO `statuses` (`id`, `creator`, `title`) VALUES
(1, 2, 'Created'),
(2, 2, 'Started'),
(3, 2, 'In Progress');

-- --------------------------------------------------------

--
-- Структура таблицы `statuses_project`
--

CREATE TABLE `statuses_project` (
  `id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `creator` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `description` tinytext,
  `is_complete` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `tasks`
--

INSERT INTO `tasks` (`id`, `creator`, `status`, `title`, `description`, `is_complete`) VALUES
(1, 2, NULL, 'New super Task', NULL, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `tasks_events`
--

CREATE TABLE `tasks_events` (
  `id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `tasks_followers`
--

CREATE TABLE `tasks_followers` (
  `id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `tasks_followers`
--

INSERT INTO `tasks_followers` (`id`, `task_id`, `member_id`) VALUES
(3, 1, 3),
(4, 1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `tasks_messages`
--

CREATE TABLE `tasks_messages` (
  `id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `teams`
--

CREATE TABLE `teams` (
  `id` int(11) NOT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `teams_followers`
--

CREATE TABLE `teams_followers` (
  `id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `teams_projects`
--

CREATE TABLE `teams_projects` (
  `id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Индексы таблицы `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `event_creator_id` (`creator_id`);

--
-- Индексы таблицы `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`),
  ADD KEY `members_role_id` (`role`);

--
-- Индексы таблицы `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `message_creator_id` (`creator_id`);

--
-- Индексы таблицы `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `creator_projects_id` (`creator_id`),
  ADD KEY `supervisor_projects_id` (`supervisor_id`);

--
-- Индексы таблицы `projects_followers`
--
ALTER TABLE `projects_followers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `projects_folowers_project_id` (`project_id`),
  ADD KEY `projects_folowers_member_id` (`member_id`);

--
-- Индексы таблицы `projects_tasks`
--
ALTER TABLE `projects_tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `projects_tasks_task_id` (`task_id`),
  ADD KEY `projects_tasks_project_id` (`project_id`);

--
-- Индексы таблицы `roles`
--
--
-- Индексы таблицы `statuses`
--
ALTER TABLE `statuses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `creator_statuses_id` (`creator`);

--
-- Индексы таблицы `statuses_project`
--
ALTER TABLE `statuses_project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `statuses_project_status_id` (`status_id`),
  ADD KEY `statuses_project_project_id` (`project_id`);

--
-- Индексы таблицы `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `task_creator_id` (`creator`),
  ADD KEY `tasks_status_is` (`status`);

--
-- Индексы таблицы `tasks_events`
--
ALTER TABLE `tasks_events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `task_events_task_id` (`task_id`),
  ADD KEY `task_events_event_id` (`event_id`);

--
-- Индексы таблицы `tasks_followers`
--
ALTER TABLE `tasks_followers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `task_folowers_task_id` (`task_id`),
  ADD KEY `task_folowers_member_id` (`member_id`);

--
-- Индексы таблицы `tasks_messages`
--
ALTER TABLE `tasks_messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `task_messages_task_id` (`task_id`),
  ADD KEY `task_messages_message_id` (`message_id`);

--
-- Индексы таблицы `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`id`),
  ADD KEY `creator_teams_id` (`creator_id`),
  ADD KEY `supervisor_teams_id` (`supervisor_id`);

--
-- Индексы таблицы `teams_followers`
--
ALTER TABLE `teams_followers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `team_folowers_team_id` (`team_id`),
  ADD KEY `team_folowers_member_id` (`member_id`);

--
-- Индексы таблицы `teams_projects`
--
ALTER TABLE `teams_projects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `team_project_team_id` (`team_id`),
  ADD KEY `team_projects_project_id` (`project_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `members`
--
ALTER TABLE `members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `projects`
--
ALTER TABLE `projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `projects_followers`
--
ALTER TABLE `projects_followers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `projects_tasks`
--
ALTER TABLE `projects_tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `statuses`
--
ALTER TABLE `statuses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `statuses_project`
--
ALTER TABLE `statuses_project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `tasks_events`
--
ALTER TABLE `tasks_events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `tasks_followers`
--
ALTER TABLE `tasks_followers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `tasks_messages`
--
ALTER TABLE `tasks_messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `teams`
--
ALTER TABLE `teams`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `teams_followers`
--
ALTER TABLE `teams_followers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `teams_projects`
--
ALTER TABLE `teams_projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `event_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `members` (`id`);

--
-- Ограничения внешнего ключа таблицы `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `members_role_id` FOREIGN KEY (`role`) REFERENCES `roles` (`id`);

--
-- Ограничения внешнего ключа таблицы `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `message_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `members` (`id`);

--
-- Ограничения внешнего ключа таблицы `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `creator_projects_id` FOREIGN KEY (`creator_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `supervisor_projects_id` FOREIGN KEY (`supervisor_id`) REFERENCES `members` (`id`);

--
-- Ограничения внешнего ключа таблицы `projects_followers`
--
ALTER TABLE `projects_followers`
  ADD CONSTRAINT `projects_folowers_member_id` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `projects_folowers_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

--
-- Ограничения внешнего ключа таблицы `projects_tasks`
--
ALTER TABLE `projects_tasks`
  ADD CONSTRAINT `projects_tasks_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `projects_tasks_task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `statuses`
--
ALTER TABLE `statuses`
  ADD CONSTRAINT `creator_statuses_id` FOREIGN KEY (`creator`) REFERENCES `members` (`id`);

--
-- Ограничения внешнего ключа таблицы `statuses_project`
--
ALTER TABLE `statuses_project`
  ADD CONSTRAINT `statuses_project_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `statuses_project_status_id` FOREIGN KEY (`status_id`) REFERENCES `statuses` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `task_creator_id` FOREIGN KEY (`creator`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `tasks_status_is` FOREIGN KEY (`status`) REFERENCES `statuses_project` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks_events`
--
ALTER TABLE `tasks_events`
  ADD CONSTRAINT `task_events_event_id` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `task_events_task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks_followers`
--
ALTER TABLE `tasks_followers`
  ADD CONSTRAINT `task_folowers_member_id` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `task_folowers_task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks_messages`
--
ALTER TABLE `tasks_messages`
  ADD CONSTRAINT `task_messages_message_id` FOREIGN KEY (`message_id`) REFERENCES `messages` (`id`),
  ADD CONSTRAINT `task_messages_task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `teams`
--
ALTER TABLE `teams`
  ADD CONSTRAINT `creator_teams_id` FOREIGN KEY (`creator_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `supervisor_teams_id` FOREIGN KEY (`supervisor_id`) REFERENCES `members` (`id`);

--
-- Ограничения внешнего ключа таблицы `teams_followers`
--
ALTER TABLE `teams_followers`
  ADD CONSTRAINT `team_folowers_member_id` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `team_folowers_team_id` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`);

--
-- Ограничения внешнего ключа таблицы `teams_projects`
--
ALTER TABLE `teams_projects`
  ADD CONSTRAINT `team_project_team_id` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`),
  ADD CONSTRAINT `team_projects_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;