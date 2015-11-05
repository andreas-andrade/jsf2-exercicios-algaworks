DO $$
BEGIN
    IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='agendamento_codage_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE agendamento_codage_seq;';
    END IF;
    IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='convenio_codcon_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE convenio_codcon_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='cr_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE cr_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='ct_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE ct_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='diretorio_coddir_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE diretorio_coddir_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='dx_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE dx_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='equipamento_codequ_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE equipamento_codequ_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='es_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE es_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='exame_codexa_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE exame_codexa_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='hospital_codhos_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE hospital_codhos_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='localidade_codloc_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE localidade_codloc_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='medico_codmed_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE medico_codmed_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='medico_solicitante_codsol_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE medico_solicitante_codsol_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='mg_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE mg_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='mr_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE mr_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='paciente_codpac_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE paciente_codpac_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldatacr_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldatacr_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldatact_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldatact_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldatadx_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldatadx_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldataes_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldataes_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldatamg_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldatamg_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldatamr_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldatamr_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldataseccapt_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldataseccapt_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldataus_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldataus_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='pixeldataxa_codpix_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE pixeldataxa_codpix_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='regiao_codreg_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE regiao_codreg_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='revascularizacoes_codrev_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE revascularizacoes_codrev_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='seccapt_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE seccapt_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='teleficha_codtel_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE teleficha_codtel_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='tipo_de_exame_codtip_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE tipo_de_exame_codtip_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='us_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE us_codima_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='usuario_codusu_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE usuario_codusu_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='visita_codvis_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE visita_codvis_seq;';
    END IF;
	IF NOT EXISTS(SELECT relname FROM pg_class WHERE relname='xa_codima_seq')
    THEN
      EXECUTE 'CREATE SEQUENCE xa_codima_seq;';
    END IF;	
END
$$;

--==================================================================================

SELECT SETVAL('public."agendamento_codage_seq"', max(codage)) FROM agendamento;
SELECT SETVAL('public."convenio_codcon_seq"', max(codcon)) FROM convenio;
SELECT SETVAL('public."cr_codima_seq"', max(codima)) FROM cr;
SELECT SETVAL('public."ct_codima_seq"', max(codima)) FROM ct;
SELECT SETVAL('public."diretorio_coddir_seq"', max(coddir)) FROM diretorio;
SELECT SETVAL('public."dx_codima_seq"', max(codima)) FROM dx;
SELECT SETVAL('public."equipamento_codequ_seq"', max(codequ)) FROM equipamento;
SELECT SETVAL('public."es_codima_seq"', max(codima)) FROM es;
SELECT SETVAL('public."exame_codexa_seq"', max(codexa)) FROM exame;
SELECT SETVAL('public."hospital_codhos_seq"', max(codhos)) FROM hospital;
SELECT SETVAL('public."localidade_codloc_seq"', max(codloc)) FROM localidade;
SELECT SETVAL('public."medico_codmed_seq"', max(codmed)) FROM medico;
SELECT SETVAL('public."medico_solicitante_codsol_seq"', max(codsol)) FROM medico_solicitante;
SELECT SETVAL('public."mg_codima_seq"', max(codima)) FROM mg;
SELECT SETVAL('public."mr_codima_seq"', max(codima)) FROM mr;
SELECT SETVAL('public."paciente_codpac_seq"', max(codpac)) FROM paciente;
SELECT SETVAL('public."pixeldatacr_codpix_seq"', max(codpix)) FROM pixeldatacr;
SELECT SETVAL('public."pixeldatact_codpix_seq"', max(codpix)) FROM pixeldatact;
SELECT SETVAL('public."pixeldatadx_codpix_seq"', max(codpix)) FROM pixeldatadx;
SELECT SETVAL('public."pixeldataes_codpix_seq"', max(codpix)) FROM pixeldataes;
SELECT SETVAL('public."pixeldatamg_codpix_seq"', max(codpix)) FROM pixeldatamg;
SELECT SETVAL('public."pixeldatamr_codpix_seq"', max(codpix)) FROM pixeldatamr;
SELECT SETVAL('public."pixeldataseccapt_codpix_seq"', max(codpix)) FROM pixeldataseccapt;
SELECT SETVAL('public."pixeldataus_codpix_seq"', max(codpix)) FROM pixeldataus;
SELECT SETVAL('public."pixeldataxa_codpix_seq"', max(codpix)) FROM pixeldataxa;
SELECT SETVAL('public."regiao_codreg_seq"', max(codreg)) FROM regiao;
SELECT SETVAL('public."revascularizacoes_codrev_seq"', max(codrev)) FROM revascularizacoes;
SELECT SETVAL('public."seccapt_codima_seq"', max(codima)) FROM seccapt;
SELECT SETVAL('public."teleficha_codtel_seq"', max(codtel)) FROM teleficha;
SELECT SETVAL('public."tipo_de_exame_codtip_seq"', max(codtip)) FROM tipo_de_exame;
SELECT SETVAL('public."us_codima_seq"', max(codima)) FROM us;
SELECT SETVAL('public."usuario_codusu_seq"', max(codusu)) FROM usuario;
SELECT SETVAL('public."visita_codvis_seq"', max(codvis)) FROM visita;
SELECT SETVAL('public."xa_codima_seq"', max(codima)) FROM xa;

--==================================================================================

ALTER TABLE agendamento ALTER COLUMN codage SET DEFAULT nextval('agendamento_codage_seq'::regclass);
ALTER TABLE convenio ALTER COLUMN codcon SET DEFAULT nextval('convenio_codcon_seq'::regclass);
ALTER TABLE agendamento ALTER COLUMN codage SET DEFAULT nextval('agendamento_codage_seq'::regclass);
ALTER TABLE convenio ALTER COLUMN codcon SET DEFAULT nextval('convenio_codcon_seq'::regclass);
ALTER TABLE paciente ALTER COLUMN codpac SET DEFAULT nextval('paciente_codpac_seq'::regclass);
ALTER TABLE exame ALTER COLUMN codexa SET DEFAULT nextval('exame_codexa_seq'::regclass);
ALTER TABLE hospital ALTER COLUMN codhos SET DEFAULT nextval('hospital_codhos_seq'::regclass);
ALTER TABLE localidade ALTER COLUMN codloc SET DEFAULT nextval('localidade_codloc_seq'::regclass);
ALTER TABLE medico_solicitante ALTER COLUMN codsol SET DEFAULT nextval('medico_solicitante_codsol_seq'::regclass);
ALTER TABLE medico ALTER COLUMN codmed SET DEFAULT nextval('medico_codmed_seq'::regclass);
ALTER TABLE regiao ALTER COLUMN codreg SET DEFAULT nextval('regiao_codreg_seq'::regclass);
ALTER TABLE tipo_de_exame ALTER COLUMN codtip SET DEFAULT nextval('tipo_de_exame_codtip_seq'::regclass);
ALTER TABLE usuario ALTER COLUMN codusu SET DEFAULT nextval('usuario_codusu_seq'::regclass);
ALTER TABLE visita ALTER COLUMN codvis SET DEFAULT nextval('visita_codvis_seq'::regclass);
ALTER TABLE paciente ALTER COLUMN codpac SET DEFAULT nextval('paciente_codpac_seq'::regclass);
ALTER TABLE exame ALTER COLUMN codexa SET DEFAULT nextval('exame_codexa_seq'::regclass);
ALTER TABLE hospital ALTER COLUMN codhos SET DEFAULT nextval('hospital_codhos_seq'::regclass);
ALTER TABLE localidade ALTER COLUMN codloc SET DEFAULT nextval('localidade_codloc_seq'::regclass);
ALTER TABLE medico_solicitante ALTER COLUMN codsol SET DEFAULT nextval('medico_solicitante_codsol_seq'::regclass);
ALTER TABLE medico ALTER COLUMN codmed SET DEFAULT nextval('medico_codmed_seq'::regclass);
ALTER TABLE regiao ALTER COLUMN codreg SET DEFAULT nextval('regiao_codreg_seq'::regclass);
ALTER TABLE tipo_de_exame ALTER COLUMN codtip SET DEFAULT nextval('tipo_de_exame_codtip_seq'::regclass);
ALTER TABLE usuario ALTER COLUMN codusu SET DEFAULT nextval('usuario_codusu_seq'::regclass);
ALTER TABLE visita ALTER COLUMN codvis SET DEFAULT nextval('visita_codvis_seq'::regclass);

--==================================================================================

CREATE TABLE auth_group
(
  id serial NOT NULL,
  name character varying(80) NOT NULL,
  CONSTRAINT auth_group_pkey PRIMARY KEY (id),
  CONSTRAINT auth_group_name_key UNIQUE (name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE auth_group
  OWNER TO sismed;

--==================================================================================

CREATE TABLE django_content_type
(
  id serial NOT NULL,
  name character varying(100) NOT NULL,
  app_label character varying(100) NOT NULL,
  model character varying(100) NOT NULL,
  CONSTRAINT django_content_type_pkey PRIMARY KEY (id),
  CONSTRAINT django_content_type_app_label_model_key UNIQUE (app_label, model)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE django_content_type
  OWNER TO sismed;

INSERT INTO django_content_type (id, name, app_label, model) values (1,'permission',	'auth',	'permission');
INSERT INTO django_content_type (id, name, app_label, model) values (2,'group',	'auth',	'group');
INSERT INTO django_content_type (id, name, app_label, model) values (3,'user',	'auth',	'user');
INSERT INTO django_content_type (id, name, app_label, model) values (4,'content type',	'contenttypes',	'contenttype');
INSERT INTO django_content_type (id, name, app_label, model) values (5,'session',	'sessions',	'session');
INSERT INTO django_content_type (id, name, app_label, model) values (6,'site',	'sites',	'site');
INSERT INTO django_content_type (id, name, app_label, model) values (7,'log entry',	'admin',	'logentry');
INSERT INTO django_content_type (id, name, app_label, model) values (8,'Médico',	'IWG2',	'medico');
INSERT INTO django_content_type (id, name, app_label, model) values (9,'Médico solicitante',	'IWG2',	'medicosolicitante');
INSERT INTO django_content_type (id, name, app_label, model) values (10,'Agendamento',	'IWG2',	'agendamento');
INSERT INTO django_content_type (id, name, app_label, model) values (11,'Convênio',	'IWG2',	'convenio');
INSERT INTO django_content_type (id, name, app_label, model) values (12,'Hospital',	'IWG2',	'hospital');
INSERT INTO django_content_type (id, name, app_label, model) values (13,'Equipamento',	'IWG2',	'equipamento');
INSERT INTO django_content_type (id, name, app_label, model) values (14,'Tipo de exames',	'IWG2',	'tipodeexame');
INSERT INTO django_content_type (id, name, app_label, model) values (15,'Usuário',	'IWG2',	'usuario');
INSERT INTO django_content_type (id, name, app_label, model) values (16,'Visita',	'IWG2',	'visita');
INSERT INTO django_content_type (id, name, app_label, model) values (17,'Exame',	'IWG2',	'exame');
INSERT INTO django_content_type (id, name, app_label, model) values (18,'Região',	'IWG2',	'regiao');
INSERT INTO django_content_type (id, name, app_label, model) values (19,'Localidade',	'IWG2',	'localidade');
INSERT INTO django_content_type (id, name, app_label, model) values (20,'Paciente',	'IWG2',	'paciente');
INSERT INTO django_content_type (id, name, app_label, model) values (21,'Xa',	'IWG2',	'xa');
INSERT INTO django_content_type (id, name, app_label, model) values (22,'Ct',	'IWG2',	'ct');
INSERT INTO django_content_type (id, name, app_label, model) values (23,'Cr',	'IWG2',	'cr');
INSERT INTO django_content_type (id, name, app_label, model) values (24,'Dx',	'IWG2',	'dx');
INSERT INTO django_content_type (id, name, app_label, model) values (25,'Es',	'IWG2',	'es');
INSERT INTO django_content_type (id, name, app_label, model) values (26,'Mg',	'IWG2',	'mg');
INSERT INTO django_content_type (id, name, app_label, model) values (27,'Mr',	'IWG2',	'mr');
INSERT INTO django_content_type (id, name, app_label, model) values (28,'Us',	'IWG2',	'us');
INSERT INTO django_content_type (id, name, app_label, model) values (29,'Seccapt',	'IWG2',	'seccapt');
SELECT setval('public."django_content_type_id_seq"', max(id)) FROM django_content_type;

--==================================================================================

CREATE TABLE auth_permission
(
  id serial NOT NULL,
  name character varying(50) NOT NULL,
  content_type_id integer NOT NULL,
  codename character varying(100) NOT NULL,
  CONSTRAINT auth_permission_pkey PRIMARY KEY (id),
  CONSTRAINT content_type_id_refs_id_728de91f FOREIGN KEY (content_type_id)
      REFERENCES django_content_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT auth_permission_content_type_id_codename_key UNIQUE (content_type_id, codename)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE auth_permission
  OWNER TO sismed;

  CREATE INDEX auth_permission_content_type_id
  ON auth_permission
  USING btree
  (content_type_id);
  
INSERT INTO auth_permission (id, name, content_type_id, codename) values (1,'Can add permission',	1,	'add_permission');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (2,'Can change permission',	1,	'change_permission');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (3,'Can delete permission',	1,	'delete_permission');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (4,'Can add group',	2,	'add_group');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (5,'Can change group',	2,	'change_group');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (6,'Can delete group',	2,	'delete_group');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (7,'Can add user',	3,	'add_user');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (8,'Can change user',	3,	'change_user');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (9,'Can delete user',	3,	'delete_user');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (10,'Can add content type',	4,	'add_contenttype');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (11,'Can change content type',	4,	'change_contenttype');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (12,'Can delete content type',	4,	'delete_contenttype');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (13,'Can add session',	5,	'add_session');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (14,'Can change session',	5,	'change_session');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (15,'Can delete session',	5,	'delete_session');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (16,'Can add site',	6,	'add_site');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (17,'Can change site',	6,	'change_site');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (18,'Can delete site',	6,	'delete_site');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (19,'Can add log entry',	7,	'add_logentry');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (20,'Can change log entry',	7,	'change_logentry');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (21,'Can delete log entry',	7,	'delete_logentry');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (22,'Can add Médico',	8,	'add_medico');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (23,'Can change Médico',	8,	'change_medico');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (24,'Can delete Médico',	8,	'delete_medico');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (25,'Can add Médico solicitante',	9,	'add_medicosolicitante');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (26,'Can change Médico solicitante',	9,	'change_medicosolicitante');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (27,'Can delete Médico solicitante',	9,	'delete_medicosolicitante');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (28,'Can add Agendamento',	10,	'add_agendamento');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (29,'Can change Agendamento',	10,	'change_agendamento');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (30,'Can delete Agendamento',	10,	'delete_agendamento');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (31,'Can add Convênio',	11,	'add_convenio');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (32,'Can change Convênio',	11,	'change_convenio');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (33,'Can delete Convênio',	11,	'delete_convenio');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (34,'Can add Hospital',	12,	'add_hospital');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (35,'Can change Hospital',	12,	'change_hospital');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (36,'Can delete Hospital',	12,	'delete_hospital');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (37,'Can add Equipamento',	13,	'add_equipamento');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (38,'Can change Equipamento',	13,	'change_equipamento');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (39,'Can delete Equipamento',	13,	'delete_equipamento');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (40,'Can add Tipo de exames',	14,	'add_tipodeexame');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (41,'Can change Tipo de exames',	14,	'change_tipodeexame');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (42,'Can delete Tipo de exames',	14,	'delete_tipodeexame');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (43,'Can add Usuário',	15,	'add_usuario');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (44,'Can change Usuário',	15,	'change_usuario');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (45,'Can delete Usuário',	15,	'delete_usuario');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (46,'Can add Visita',	16,	'add_visita');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (47,'Can change Visita',	16,	'change_visita');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (48,'Can delete Visita',	16,	'delete_visita');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (49,'Can add Exame',	17,	'add_exame');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (50,'Can change Exame',	17,	'change_exame');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (51,'Can delete Exame',	17,	'delete_exame');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (52,'Can add Região',	18,	'add_regiao');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (53,'Can change Região',	18,	'change_regiao');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (54,'Can delete Região',	18,	'delete_regiao');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (55,'Can add Localidade',	19,	'add_localidade');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (56,'Can change Localidade',	19,	'change_localidade');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (57,'Can delete Localidade',	19,	'delete_localidade');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (58,'Can add Paciente',	20,	'add_paciente');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (59,'Can change Paciente',	20,	'change_paciente');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (60,'Can delete Paciente',	20,	'delete_paciente');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (61,'Can add Xa',	21,	'add_xa');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (62,'Can change Xa',	21,	'change_xa');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (63,'Can delete Xa',	21,	'delete_xa');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (64,'Can add Ct',	22,	'add_ct');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (65,'Can change Ct',	22,	'change_ct');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (66,'Can delete Ct',	22,	'delete_ct');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (67,'Can add Cr',	23,	'add_cr');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (68,'Can change Cr',	23,	'change_cr');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (69,'Can delete Cr',	23,	'delete_cr');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (70,'Can add Dx',	24,	'add_dx');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (71,'Can change Dx',	24,	'change_dx');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (72,'Can delete Dx',	24,	'delete_dx');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (73,'Can add Es',	25,	'add_es');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (74,'Can change Es',	25,	'change_es');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (75,'Can delete Es',	25,	'delete_es');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (76,'Can add Mg',	26,	'add_mg');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (77,'Can change Mg',	26,	'change_mg');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (78,'Can delete Mg',	26,	'delete_mg');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (79,'Can add Mr',	27,	'add_mr');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (80,'Can change Mr',	27,	'change_mr');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (81,'Can delete Mr',	27,	'delete_mr');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (82,'Can add Us',	28,	'add_us');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (83,'Can change Us',	28,	'change_us');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (84,'Can delete Us',	28,	'delete_us');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (85,'Can add Seccapt',	29,	'add_seccapt');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (86,'Can change Seccapt',	29,	'change_seccapt');
INSERT INTO auth_permission (id, name, content_type_id, codename) values (87,'Can delete Seccapt',	29,	'delete_seccapt');
SELECT setval('public."auth_permission_id_seq"', max(id)) FROM auth_permission;

--==================================================================================  
CREATE TABLE auth_group_permissions
(
  id serial NOT NULL,
  group_id integer NOT NULL,
  permission_id integer NOT NULL,
  CONSTRAINT auth_group_permissions_pkey PRIMARY KEY (id),
  CONSTRAINT auth_group_permissions_permission_id_fkey FOREIGN KEY (permission_id)
      REFERENCES auth_permission (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT group_id_refs_id_3cea63fe FOREIGN KEY (group_id)
      REFERENCES auth_group (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT auth_group_permissions_group_id_permission_id_key UNIQUE (group_id, permission_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE auth_group_permissions
  OWNER TO sismed;

CREATE INDEX auth_group_permissions_group_id
  ON auth_group_permissions
  USING btree
  (group_id);

CREATE INDEX auth_group_permissions_permission_id
  ON auth_group_permissions
  USING btree
  (permission_id);

--==================================================================================

CREATE TABLE auth_user
(
  id serial NOT NULL,
  username character varying(30) NOT NULL,
  first_name character varying(30) NOT NULL,
  last_name character varying(30) NOT NULL,
  email character varying(75) NOT NULL,
  password character varying(128) NOT NULL,
  is_staff boolean NOT NULL,
  is_active boolean NOT NULL,
  is_superuser boolean NOT NULL,
  last_login timestamp with time zone NOT NULL,
  date_joined timestamp with time zone NOT NULL,
  CONSTRAINT auth_user_pkey PRIMARY KEY (id),
  CONSTRAINT auth_user_username_key UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE auth_user
  OWNER TO sismed;

INSERT INTO auth_user (id, username, first_name, last_name, email, password, is_staff, is_active, is_superuser, last_login, date_joined) values (1,'sismed','','','mira@sismed.com.br','pbkdf2_sha256$10000$ichV4L97BeOS$XFi6s++jKQx9VrbnFFBTi2AY6W6blVOQd6lOruxZ4NY=',true,true,true,'2013-04-10 13:34:22.782-03','2013-04-10 13:33:36.912-03');
SELECT setval('public."auth_user_id_seq"', max(id)) FROM auth_user;

--==================================================================================

CREATE TABLE auth_user_groups
(
  id serial NOT NULL,
  user_id integer NOT NULL,
  group_id integer NOT NULL,
  CONSTRAINT auth_user_groups_pkey PRIMARY KEY (id),
  CONSTRAINT auth_user_groups_group_id_fkey FOREIGN KEY (group_id)
      REFERENCES auth_group (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT user_id_refs_id_7ceef80f FOREIGN KEY (user_id)
      REFERENCES auth_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT auth_user_groups_user_id_group_id_key UNIQUE (user_id, group_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE auth_user_groups
  OWNER TO sismed;

CREATE INDEX auth_user_groups_group_id
  ON auth_user_groups
  USING btree
  (group_id);

CREATE INDEX auth_user_groups_user_id
  ON auth_user_groups
  USING btree
  (user_id);

--==================================================================================

CREATE TABLE auth_user_user_permissions
(
  id serial NOT NULL,
  user_id integer NOT NULL,
  permission_id integer NOT NULL,
  CONSTRAINT auth_user_user_permissions_pkey PRIMARY KEY (id),
  CONSTRAINT auth_user_user_permissions_permission_id_fkey FOREIGN KEY (permission_id)
      REFERENCES auth_permission (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT user_id_refs_id_dfbab7d FOREIGN KEY (user_id)
      REFERENCES auth_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT auth_user_user_permissions_user_id_permission_id_key UNIQUE (user_id, permission_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE auth_user_user_permissions
  OWNER TO sismed;

CREATE INDEX auth_user_user_permissions_permission_id
  ON auth_user_user_permissions
  USING btree
  (permission_id);

CREATE INDEX auth_user_user_permissions_user_id
  ON auth_user_user_permissions
  USING btree
  (user_id);

--==================================================================================

CREATE TABLE django_admin_log
(
  id serial NOT NULL,
  action_time timestamp with time zone NOT NULL,
  user_id integer NOT NULL,
  content_type_id integer,
  object_id text,
  object_repr character varying(200) NOT NULL,
  action_flag smallint NOT NULL,
  change_message text NOT NULL,
  CONSTRAINT django_admin_log_pkey PRIMARY KEY (id),
  CONSTRAINT django_admin_log_content_type_id_fkey FOREIGN KEY (content_type_id)
      REFERENCES django_content_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT django_admin_log_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES auth_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY DEFERRED,
  CONSTRAINT django_admin_log_action_flag_check CHECK (action_flag >= 0)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE django_admin_log
  OWNER TO sismed;

CREATE INDEX django_admin_log_content_type_id
  ON django_admin_log
  USING btree
  (content_type_id);

CREATE INDEX django_admin_log_user_id
  ON django_admin_log
  USING btree
  (user_id);

--==================================================================================

CREATE TABLE django_session
(
  session_key character varying(40) NOT NULL,
  session_data text NOT NULL,
  expire_date timestamp with time zone NOT NULL,
  CONSTRAINT django_session_pkey PRIMARY KEY (session_key)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE django_session
  OWNER TO sismed;

CREATE INDEX django_session_expire_date
  ON django_session
  USING btree
  (expire_date);

--==================================================================================

CREATE TABLE django_site
(
  id serial NOT NULL,
  domain character varying(100) NOT NULL,
  name character varying(50) NOT NULL,
  CONSTRAINT django_site_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE django_site
  OWNER TO sismed;

INSERT INTO django_site (id, domain, name) values (1,'example.com','example.com');
SELECT setval('public."django_site_id_seq"', max(id)) FROM django_site;

--==================================================================================

--Atualização do tipo de usuário SISMED
UPDATE usuario set tipusu=3 where nomusu='SISMED';