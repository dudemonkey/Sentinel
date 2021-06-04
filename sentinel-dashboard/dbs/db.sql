
-- need db init

create table  saaf_middleware_config(
    id int auto_increment primary key comment '主键id',
    mtype varchar(100) comment '中间件类型',
    username varchar(100) comment '账号',
    password varchar(100) comment '密码' ,

    created_by           int comment '创建人',
   creation_date        datetime comment '创建时间',
   last_updated_by      int comment '最后更新人',
   last_update_date     datetime comment '最后更新时间',
   version_num          int default 1 comment '版本号'

)   ;

insert into saaf_middleware_config(mtype, username, password, created_by, creation_date, last_updated_by, last_update_date) VALUES
('sentinel','admin','admin',1,now(),1,now());

select t.* from saaf_middleware_config  t where t.mtype=?  and t.username=? and t.password=? ;


