# -*- coding: utf8 -*-
#===============================================================================================
# Tronks - Configurações para o projeto quando executado em modo local (fora da IDE Eclipse):
import os
PROJECT_ROOT_PATH = os.path.realpath(os.path.dirname(__file__))

LOCAL = True
DEBUG = True
TEMPLATE_DEBUG = DEBUG

DATABASE_ENGINE = 'postgresql_psycopg2'
DATABASE_NAME = 'sismed'
DATABASE_HOST = 'localhost'
DATABASE_USER = 'sismed'
DATABASE_PASSWORD = 'iwg2pacs'
#===============================================================================================