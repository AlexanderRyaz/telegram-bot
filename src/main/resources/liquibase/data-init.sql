-- liquibase formatted sql

-- changeset aryazanov:1
CREATE TABLE IF NOT EXISTS notification_task (
                                                 id
                                                 bigint
                                                 not
                                                 null
                                                 primary
                                                 key,
                                                 text
                                                 varchar,
                                                 chat_id
                                                 bigint,
                                                 sent_at timestamp with time zone

);