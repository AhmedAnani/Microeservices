CREATE TABLE IF NOT EXISTS cards (
  id SERIAL PRIMARY KEY,
  phone varchar(11) NOT NULL,
  card_number varchar(100) NOT NULL,
  card_type varchar(100) NOT NULL,
  total_limit int NOT NULL,
  amount_used int NOT NULL,
  available_amount int NOT NULL

);