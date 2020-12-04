INSERT INTO Developer(id_developer, name, avatar) VALUES (1, 'colras', 'test');
INSERT INTO Developer(id_developer, name, avatar) VALUES (2, 'bal', 'test2');
INSERT INTO Bug (id_bug, title, description, priority, etat, date_creation, id_developer) VALUES (1, 'title', 'description', 'priority', 'etat', '2020-09-16', 1);
INSERT INTO Comment(id_comment, comment, date_comment, id_bug, id_developer) VALUES (1, 'comment', '2020-06-05', 1, 1);