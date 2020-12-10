INSERT INTO Developer(id_developer, name, avatar) VALUES (1, 'colras', 'test');
INSERT INTO Developer(id_developer, name, avatar) VALUES (2, 'bal', 'test2');
INSERT INTO Bug (id_bug, title, description, priority, etat, date_creation, id_developer) VALUES (1, 'title', 'description', 'priority', 'TO_DO', '2020-09-16', 1);
INSERT INTO Bug (id_bug, title, description, priority, etat, date_creation, id_developer) VALUES (2, 'title2', 'description2', 'priority2', 'IN_PROGRESS', '2020-07-13', 1);
INSERT INTO Bug (id_bug, title, description, priority, etat, date_creation, id_developer) VALUES (3, 'title3', 'description3', 'priority3', 'TO_DO', '2020-01-27', 1);
INSERT INTO Bug (id_bug, title, description, priority, etat, date_creation, id_developer) VALUES (4, 'title4', 'description4', 'priority4', 'DONE', '2020-03-08', 2);
INSERT INTO Bug (id_bug, title, description, priority, etat, date_creation, id_developer) VALUES (5, 'title5', 'description5', 'priority5', 'DONE', '2020-05-06', 2);
INSERT INTO Comment(id_comment, comment, date_comment, id_bug, id_developer) VALUES (1, 'comment', '2020-06-05', 1, 1);
INSERT INTO Comment(id_comment, comment, date_comment, id_bug, id_developer) VALUES (2, 'comment', '2020-06-05', 1, 2);