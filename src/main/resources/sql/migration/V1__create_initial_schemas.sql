CREATE TABLE IF NOT EXISTS `tab_partner` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NUll,
    `name` varchar(255),
    `email` varchar(255),
    `password` varchar(255),
    `document_id` varchar(15),
    `fidelity` boolean NOT NULL,
    `phone_number` varchar(20),
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `deleted_at` datetime
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

