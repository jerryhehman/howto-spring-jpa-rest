/* File used by Spring Boot to build the h2 database schema */
    create table lookup_marital_status (
        mar_status_cd char(1) not null,
        mar_status_tx varchar(32) not null,
        primary key (mar_status_cd)
    );

    create table lookup_rating_level (
        rating_cd smallint not null,
        rating_tx varchar(32) not null,
        primary key (rating_cd)
    );

    create table pers_eval_answer (
        pers_eval_question_id integer not null,
        person_eval_id integer not null,
        person_id varchar(12) not null,
        answer smallint,
        create_by varchar(30) not null,
        create_dt timestamp not null,
        mod_by varchar(30),
        mod_dt timestamp,
        primary key (pers_eval_question_id, person_eval_id, person_id)
    );

    create table person (
        person_id varchar(12) not null,
        first_name varchar(30),
        last_name varchar(30),
        mar_status_cd char(1),
        primary key (person_id)
    );

    create table person_address (
        person_id varchar(12) not null,
        addr_usg_cd char(1) not null,
        city_tx varchar(30),
        cntry_cd varchar(2) not null,
        create_by varchar(30),
        create_dt timestamp,
        fips_cd varchar(5),
        latitude decimal(10,5),
        longitude decimal(10,5),
        mod_by varchar(30),
        mod_dt timestamp,
        state_ab varchar(2),
        street_line1_tx varchar(60),
        street_line2_tx varchar(60),
        zip_cd varchar(5),
        zip_sfx_cd varchar(4),
        primary key (person_id, addr_usg_cd)
    );

    create table person_eval (
        person_id varchar(12) not null,
        person_eval_id integer not null,
        other_tx varchar(1024),
        rating_cd smallint,
        create_by varchar(30) not null,
        create_dt timestamp not null,
        mod_by varchar(30),
        mod_dt timestamp,
        primary key (person_id, person_eval_id)
    );

    create table person_eval_question (
        pers_eval_question_id integer not null,
        question_beg_dt date not null,
        question_end_dt date not null,
        question_name varchar(32) not null,
        question_order integer not null,
        question_tx varchar(255) not null,
        primary key (pers_eval_question_id)
    );
    alter table person_address 
        add constraint FK_anrg3ju8wu2kes1a2gr8bp7kg 
        foreign key (person_id) 
        references person;

	alter table person_eval 
        add constraint FK_cncv6wcy2n0ndk7ug9aq0vbf1 
        foreign key (rating_cd) 
        references lookup_rating_level;

	alter table person_eval 
        add constraint FK_fpcnhtg9w5ojf6j0bgng2vb4m 
        foreign key (person_id) 
        references person;

