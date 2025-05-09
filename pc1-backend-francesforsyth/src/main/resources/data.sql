-- Usuarios con diferentes roles
INSERT INTO usuario (username, password, rol) VALUES ('admin', 'admin123', 'ADMIN');
INSERT INTO usuario (username, password, rol) VALUES ('medico1', 'medico123', 'MÉDICO');
INSERT INTO usuario (username, password, rol) VALUES ('recepcion', 'recep123', 'RECEPCIONISTA');
INSERT INTO usuario (username, password, rol) VALUES ('enfermero1', 'enfer123', 'ENFERMERO');

-- Paciente de prueba
INSERT INTO paciente (nombre, apellido, genero, tipo_sangre, correo, fecha_nacimiento)
VALUES ('Carlos', 'Ramírez', 'Masculino', 'A+', 'carlos@example.com', '1990-06-15');

-- Médico de prueba
INSERT INTO medico (nombre, especialidad, correo)
VALUES ('Dra. Ana Pérez', 'Cardiología', 'ana.perez@hospital.com');

-- Consulta de prueba
INSERT INTO consulta (fecha_hora, motivo, diagnostico, paciente_id, medico_id)
VALUES ('2025-05-09T10:00:00', 'Dolor en el pecho', 'Angina leve', 1, 1);
