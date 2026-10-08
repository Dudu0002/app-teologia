-- 1. Inserir o Aluno de Teste
INSERT INTO tb_students (id, name, email) 
VALUES (1, 'Eduardo Silva', 'henriqueedu5099@gmail.com');

-- 2. Inserir o Progresso da Prova/Apostila
-- Substitua 'SEU_GOOGLE_FORM_ID_AQUI' pelo ID real que fica na URL do seu Google Forms
INSERT INTO tb_study_material_progress (id, material_title, google_form_id, passing_grade, status, student_id) 
VALUES (1, 'Apostila 1 - Bibliologia', '1FAIpQLSdHX3Gw_Fi2RItan_I34Pqq52IjMmXTgexB8YF63YLb3hE96w', 7.0, 'PENDING', 1);