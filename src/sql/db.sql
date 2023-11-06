-- Active: 1697508141585@@localhost@3306@pruebas

SELECT * FROM curso;

SELECT * FROM facultad;

SELECT * FROM estudiante_curso;

SELECT * FROM estudiante_facultad;

SELECT * FROM estudiante_audit;

SELECT * FROM curso_audit;

-- Triggers

CREATE TABLE
    IF NOT EXISTS `pruebas`.`estudiante_audit` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `estudiante_id` INT NOT NULL,
        `correo` VARCHAR(255) NOT NULL,
        `edad` INT NOT NULL,
        `genero` VARCHAR(255) NOT NULL,
        `nombre` VARCHAR(255) NOT NULL,
        `deleted_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

DELIMITER //
CREATE TRIGGER after_delete_estudiante
AFTER DELETE ON estudiante FOR EACH ROW
BEGIN
    INSERT INTO estudiante_audit (estudiante_id, correo, edad, genero, nombre)
    VALUES (OLD.id, OLD.correo, OLD.edad, OLD.genero, OLD.nombre);
END;
//
DELIMITER ;


-- Trigger para guardar un curso cuando se elimina

CREATE TABLE
    IF NOT EXISTS `pruebas`.`curso_audit` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `curso_id` INT NOT NULL,
        `nombre` VARCHAR(255) NOT NULL,
        `fecha_inicio` DATETIME(6) NOT NULL,
        `fecha_final` DATETIME(6) NULL DEFAULT NULL,
        `profesor_id` INT NULL DEFAULT NULL,
        `facultad_id` INT NULL DEFAULT NULL,
        `deleted_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

DELIMITER //
CREATE TRIGGER after_delete_curso
AFTER DELETE ON curso FOR EACH ROW
BEGIN
    INSERT INTO curso_audit (curso_id, nombre, fecha_inicio, fecha_final, profesor_id, facultad_id)
    VALUES (OLD.id, OLD.nombre, OLD.fecha_inicio, OLD.fecha_final, OLD.profesor_id, OLD.facultad_id);
END;
//
DELIMITER ;


--Trigger para valdiar que un curso no este en varias facultades

DELIMITER //

CREATE TRIGGER before_curso_insert
BEFORE INSERT ON curso FOR EACH ROW
BEGIN
    DECLARE existing_course_count INT;
    
    -- Check if the course with the same name exists in the same faculty
    SET existing_course_count = (
        SELECT COUNT(*)
        FROM curso
        WHERE nombre = NEW.nombre AND facultad_id = NEW.facultad_id
    );
    
    IF existing_course_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Un curso con el mismo nombre no se puede agregar a diferentes facultades';
    END IF;
END;

//

DELIMITER ;

DELIMITER //

CREATE TRIGGER before_curso_update
BEFORE UPDATE ON curso FOR EACH ROW
BEGIN
    DECLARE existing_course_count INT;
    
    -- Check if the course with the same name exists in the same faculty
    SET existing_course_count = (
        SELECT COUNT(*)
        FROM curso
        WHERE nombre = NEW.nombre AND facultad_id = NEW.facultad_id
    );
    
    IF existing_course_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Un curso con el mismo nombre no se puede agregar a diferentes facultades';
    END IF;
END;

//

DELIMITER ;
