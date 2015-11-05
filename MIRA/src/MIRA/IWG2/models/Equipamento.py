# -*- coding: utf8 -*-
from MIRA.IWG2.models.Hospital import Hospital
from django.db import models

class Equipamento(models.Model):
    codequ          = models.AutoField ( primary_key=True , auto_created=True, unique=True, verbose_name = 'PK Equipamento')
    hospital_codhos = models.ForeignKey (Hospital, null=True, db_column='hospital_codhos', blank=True)
    nomfab          = models.CharField  (max_length=64, blank=True, verbose_name = 'Nome do fabricante')
    modnam          = models.CharField  (max_length=64, blank=True, verbose_name = 'Modelo')
    sernumequ       = models.CharField  (max_length=64, blank=True, verbose_name = 'Número de série')
    sofver          = models.TextField  (blank=True, verbose_name = 'Versão do software')
    nomapl          = models.CharField  (max_length=16, blank=True, verbose_name = 'Nome da aplicação (AETitle)')
    class Meta:
        ordering = ('modnam',)
        verbose_name = 'Equipamento'
        verbose_name_plural = 'Equipamentos'
        db_table = u'equipamento'
        app_label = 'IWG2'