-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Хост: 10.7.110.69:3306
-- Время создания: Янв 29 2021 г., 10:10
-- Версия сервера: 5.7.18-0ubuntu0.16.04.1
-- Версия PHP: 7.2.34-1+ubuntu16.04.1+deb.sury.org+1

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
  `project_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `projects_tasks`
--

CREATE TABLE `projects_tasks` (
  `project_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `title`) VALUES
(1, 'Admin'),
(2, 'User'),
(3, 'Pending'),
(4, 'Guest');

-- --------------------------------------------------------

--
-- Структура таблицы `statuses`
--

CREATE TABLE `statuses` (
  `id` int(11) NOT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `title` varchar(20) NOT NULL,
  `this_complete` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `statuses`
--

INSERT INTO `statuses` (`id`, `creator_id`, `title`, `this_complete`) VALUES
(1, 2, 'Created', NULL),
(2, 2, 'Started', NULL),
(3, 2, 'In Progress', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `executor_id` int(11) DEFAULT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  `is_complete` tinyint(1) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `description` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `tasks_events`
--

CREATE TABLE `tasks_events` (
  `task_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `tasks_followers`
--

CREATE TABLE `tasks_followers` (
  `task_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `tasks_messages`
--

CREATE TABLE `tasks_messages` (
  `task_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `tasks_statuses`
--

CREATE TABLE `tasks_statuses` (
  `status_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
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
  `team_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `teams_projects`
--

CREATE TABLE `teams_projects` (
  `team_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Индексы сохранённых таблиц
--

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
  ADD PRIMARY KEY (`project_id`,`member_id`),
  ADD KEY `projects_followers_member_id_index` (`member_id`),
  ADD KEY `projects_followers_project_id_index` (`project_id`);

--
-- Индексы таблицы `projects_tasks`
--
ALTER TABLE `projects_tasks`
  ADD PRIMARY KEY (`project_id`,`task_id`),
  ADD KEY `projects_tasks_project_id_index` (`project_id`),
  ADD KEY `projects_tasks_task_id_index` (`task_id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `statuses`
--
ALTER TABLE `statuses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `creator_statuses_id` (`creator_id`);

--
-- Индексы таблицы `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tasks_creators_id_fk` (`creator_id`),
  ADD KEY `tasks_executor_id_fk` (`executor_id`),
  ADD KEY `tasks_supervisor_id_fk` (`supervisor_id`);

--
-- Индексы таблицы `tasks_events`
--
ALTER TABLE `tasks_events`
  ADD PRIMARY KEY (`task_id`,`event_id`),
  ADD KEY `tasks_events_event_id_index` (`event_id`),
  ADD KEY `tasks_events_task_id_index` (`task_id`);

--
-- Индексы таблицы `tasks_followers`
--
ALTER TABLE `tasks_followers`
  ADD PRIMARY KEY (`task_id`,`member_id`),
  ADD KEY `tasks_followers_member_id_index` (`member_id`),
  ADD KEY `tasks_followers_task_id_index` (`task_id`);

--
-- Индексы таблицы `tasks_messages`
--
ALTER TABLE `tasks_messages`
  ADD PRIMARY KEY (`task_id`,`message_id`),
  ADD KEY `tasks_messages_message_id_index` (`message_id`),
  ADD KEY `tasks_messages_task_id_index` (`task_id`);

--
-- Индексы таблицы `tasks_statuses`
--
ALTER TABLE `tasks_statuses`
  ADD PRIMARY KEY (`task_id`,`status_id`),
  ADD KEY `tasks_statuses_statuses_id_fk` (`status_id`),
  ADD KEY `tasks_statuses_task_id_index` (`task_id`);

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
  ADD PRIMARY KEY (`team_id`,`member_id`),
  ADD KEY `teams_followers_member_id_index` (`member_id`),
  ADD KEY `teams_followers_team_id_index` (`team_id`);

--
-- Индексы таблицы `teams_projects`
--
ALTER TABLE `teams_projects`
  ADD PRIMARY KEY (`team_id`,`project_id`),
  ADD KEY `teams_projects_project_id_index` (`project_id`),
  ADD KEY `teams_projects_team_id_index` (`team_id`);

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
-- AUTO_INCREMENT для таблицы `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `teams`
--
ALTER TABLE `teams`
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
  ADD CONSTRAINT `projects_followers_members_id_fk` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `projects_followers_projects_id_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

--
-- Ограничения внешнего ключа таблицы `projects_tasks`
--
ALTER TABLE `projects_tasks`
  ADD CONSTRAINT `projects_tasks_projects_id_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `projects_tasks_tasks_id_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `statuses`
--
ALTER TABLE `statuses`
  ADD CONSTRAINT `creator_statuses_id` FOREIGN KEY (`creator_id`) REFERENCES `members` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `tasks_creators_id_fk` FOREIGN KEY (`creator_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `tasks_executor_id_fk` FOREIGN KEY (`executor_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `tasks_supervisor_id_fk` FOREIGN KEY (`supervisor_id`) REFERENCES `members` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks_events`
--
ALTER TABLE `tasks_events`
  ADD CONSTRAINT `tasks_events_events_id_fk` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `tasks_events_tasks_id_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks_followers`
--
ALTER TABLE `tasks_followers`
  ADD CONSTRAINT `tasks_followers_members_id_fk` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `tasks_followers_tasks_id_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks_messages`
--
ALTER TABLE `tasks_messages`
  ADD CONSTRAINT `tasks_messages_messages_id_fk` FOREIGN KEY (`message_id`) REFERENCES `messages` (`id`),
  ADD CONSTRAINT `tasks_messages_tasks_id_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Ограничения внешнего ключа таблицы `tasks_statuses`
--
ALTER TABLE `tasks_statuses`
  ADD CONSTRAINT `tasks_statuses_statuses_id_fk` FOREIGN KEY (`status_id`) REFERENCES `statuses` (`id`),
  ADD CONSTRAINT `tasks_statuses_tasks_id_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

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
  ADD CONSTRAINT `teams_followers_members_id_fk` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `teams_followers_teams_id_fk` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`);

--
-- Ограничения внешнего ключа таблицы `teams_projects`
--
ALTER TABLE `teams_projects`
  ADD CONSTRAINT `teams_projects_projects_id_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `teams_projects_teams_id_fk` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
