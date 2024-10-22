INSERT INTO tb_users (user_name, last_name, user_email) VALUES ('Jacob', 'Taylor', 'jacob@gmail.com')
INSERT INTO tb_users (user_name, last_name, user_email) VALUES ('Zack', 'Hunter', 'zack@gmail.com')

INSERT INTO tb_account (account_balance, account_rank, account_type, account_status, user_id) VALUES (1200, 2, 'Silver', true, 1)
INSERT INTO tb_account (account_balance, account_rank, account_type, account_status, user_id) VALUES (1900, 2, 'Gold', true, 2)

INSERT INTO tb_bank (bank_name) VALUES ('Bank Broadway')

INSERT INTO tb_employee (employee_name, last_name, employee_email, bank_id) VALUES ('Ambrose', 'Gotobed', 'ambr@gmail.com', 1)