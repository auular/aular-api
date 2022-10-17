CREATE TABLE IF NOT EXISTS `tab_partner` (
    `partner_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `partner_uuid` varchar(36) NOT NUll,
    `name` varchar(255),
    `email` varchar(255),
    `password` varchar(255),
    `document_id` varchar(15),
    `fidelity` boolean NOT NULL,
    `phone_number` varchar(20),
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `deactivated_at` datetime,
    `number_of_campaigns` int
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS tab_hotel (
    `hotel_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `hotel_uuid` varchar(36) NOT NULL,
    `name` varchar(255),
    `email` varchar(255),
    `password` varchar(255),
    `document_id` varchar(15),
    `fidelity` boolean NOT NULL,
    `plan_type` varchar(10),
    `rates` double,
    `phone_number` varchar(20),
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `deactivated_at` datetime
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS tab_pet_tutor (
    `pet_tutor_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `pet_tutor_uuid` varchar(36) NOT NULL,
    `name` varchar(255),
    `email` varchar(255),
    `password` varchar(255),
    `document_id` varchar(15),
    `phone_number` varchar(20),
    `active` boolean NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `deactivated_at` datetime
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;