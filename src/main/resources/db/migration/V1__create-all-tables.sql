CREATE TABLE users(
id BIGSERIAL PRIMARY KEY NOT NULL,
name VARCHAR(100) NOT NULL,
role VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
active BOOLEAN,
token VARCHAR(255)
);

CREATE TABLE file(
id BIGSERIAL PRIMARY KEY NOT NULL,
file_size VARCHAR(255) NOT NULL,
extension_type VARCHAR(50) NOT NULL,
file_name VARCHAR(100) NOT NULL
);

CREATE TABLE address(
id BIGSERIAL PRIMARY KEY NOT NULL,
zip_code VARCHAR(100) NOT NULL,
street VARCHAR(100) NOT NULL,
complement VARCHAR(100) NOT NULL,
locality VARCHAR(100) NOT NULL,
neighborhood VARCHAR(100) NOT NULL,
federative_unit VARCHAR(50) NOT NULL,
state VARCHAR(50) NOT NULL,
region VARCHAR(100) NOT NULL

);

CREATE TABLE task(
id BIGSERIAL PRIMARY KEY NOT NULL,
user_id BIGINT NOT NULL,
CONSTRAINT fk_task_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
task_name VARCHAR(255) NOT NULL,
additional_information VARCHAR(255) NOT NULL,
recurring_type VARCHAR(50) NOT NULL,
expiration_date DATE NOT NULL,
generates_fine BOOLEAN,
task_number INTEGER NOT NULL,
task_status VARCHAR(50) NOT NULL,
automatically_generating BOOLEAN

);


CREATE TABLE permission(
id BIGSERIAL PRIMARY KEY NOT NULL,
user_id BIGINT NOT NULL,
CONSTRAINT fk_permission_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
permission_name VARCHAR(100) NOT NULL,
type VARCHAR(50) NOT NULL,
description VARCHAR(255) NOT NULL,
creation_date DATE NOT NULL

);


CREATE TABLE client(
id BIGSERIAL PRIMARY KEY NOT NULL,
fantasy_name VARCHAR(100) NOT NULL,
corporate_reason VARCHAR(100) NOT NULL,
telephone VARCHAR(50) NOT NULL,
address_id BIGINT NOT NULL,
email VARCHAR(50) NOT NULL,
entry_date DATE NOT NULL,
CONSTRAINT fk_client_address_id FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE

);

CREATE TABLE partner(
id BIGSERIAL PRIMARY KEY NOT NULL,
name VARCHAR(100) NOT NULL,
telephone VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
address_id BIGINT NOT NULL,
vacancy VARCHAR(50) NOT NULL,
client_id BIGINT NOT NULL,
CONSTRAINT fk_partner_client_id FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
CONSTRAINT fk_partner_address_id FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE,
cpf VARCHAR(11) NOT NULL,
CONSTRAINT uk_partner_cpf UNIQUE (cpf)

);

CREATE TABLE library_document(
id BIGSERIAL PRIMARY KEY NOT NULL,
document_type VARCHAR(50) NOT NULL,
creation_date DATE NOT NULL,
folder_name VARCHAR(100),
file_id BIGINT NOT NULL,
CONSTRAINT fk_library_document_file_id FOREIGN KEY (file_id) REFERENCES file(id) ON DELETE CASCADE

);


CREATE TABLE fees(
id BIGSERIAL PRIMARY KEY NOT NULL,
client_id BIGINT NOT NULL,
CONSTRAINT fk_fees_client_id FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
value_fees FLOAT(53) NOT NULL,
service VARCHAR(255) NOT NULL,
situation VARCHAR(255) NOT NULL,
additional_information VARCHAR(255) NOT NULL,
payment_method VARCHAR(100) NOT NULL,
competence DATE NOT NULL

);

CREATE TABLE contract_management(
id BIGSERIAL PRIMARY KEY NOT NULL,
client_id BIGINT NOT NULL,
CONSTRAINT fk_contract_management_client_id FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
service VARCHAR(255) NOT NULL,
additional_information VARCHAR(255) NOT NULL,
validity DATE NOT NULL
);


CREATE TABLE client_information(
id BIGSERIAL PRIMARY KEY NOT NULL,
fgts_date DATE NOT NULL,
ecac_date DATE NOT NULL,
simple_access_code VARCHAR(255) NOT NULL,
nfse_access VARCHAR(255) NOT NULL,
company_activity VARCHAR(100) NOT NULL,
municipal_state_registration VARCHAR(255) NOT NULL,
tax_regime VARCHAR(255) NOT NULL,
city_hall_notes VARCHAR(255) NOT NULL,
responsible_partner BIGINT NOT NULL,
client_id BIGINT NOT NULL,
CONSTRAINT fk_client_information_partner_id FOREIGN KEY (responsible_partner) REFERENCES partner(id) ON DELETE CASCADE,
CONSTRAINT fk_client_information_client_id FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE

);

CREATE TABLE contract(
id BIGSERIAL PRIMARY KEY NOT NULL,
contract_title VARCHAR(100) NOT NULL,
contract_number INTEGER NOT NULL,
contract_management_id BIGINT NOT NULL,
file_id BIGINT NOT NULL,
CONSTRAINT fk_contract_contract_management_id FOREIGN KEY (contract_management_id) REFERENCES contract_management(id) ON DELETE CASCADE,
CONSTRAINT fk_contract_file_id FOREIGN KEY (file_id) REFERENCES file(id) ON DELETE CASCADE

);



