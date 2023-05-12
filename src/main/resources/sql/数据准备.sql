USE test01;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `badstu`;
DROP TABLE IF EXISTS `goodstu`;
create table student
(
    id      int unsigned primary key auto_increment comment 'ID',
    name    varchar(10) not null comment '姓名',
    number  varchar(20) not null comment '学号',
    status  varchar(10) not null comment '听课',
    action1 varchar(50) comment '行为1',
    action2 varchar(50) comment '行为2'
) comment '学生表';
