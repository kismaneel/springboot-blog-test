insert into article (title, content, author, created_at, updated_at) values ('제목 1', '내용 1', 'user1', NOW(), NOW());
insert into article (title, content, author, created_at, updated_at) values ('제목 2', '내용 2', 'user2', NOW(), NOW());
insert into article (title, content, author, created_at, updated_at) values ('제목 3', '내용 3', 'user3', NOW(), NOW());

insert into comments (article_id, author, content, created_at) values (1, 'user4', '댓글1', NOW());
insert into comments (article_id, author, content, created_at) values (1, 'user5', '댓글2', NOW());
insert into comments (article_id, author, content, created_at) values (2, 'user6', '댓글3', NOW());

--insert into users (id, email, password) values ('1', 'kismaneel@gmail.com', '$2a$10$r2ZAZzG1iM2jE5hNSAA4Ru5ccSXP0LgjgcGxvLIzOSlzi.QZfCRoy')