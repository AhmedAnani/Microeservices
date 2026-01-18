CREATE TABLE IF NOT EXISTS loans (
  id SERIAL PRIMARY KEY,
  phone varchar(11) NOT NULL,
  loan_number varchar(100) NOT NULL,
  loan_type varchar(100) NOT NULL,
  total_loan int NOT NULL,
  amount_paid int NOT NULL,
  outstanding_amount int NOT NULL,
)