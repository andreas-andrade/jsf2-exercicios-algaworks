# -*- coding: utf8 -*-
from django.db import models

class Regiao(models.Model):
    codreg = models.AutoField ( primary_key=True , auto_created=True, unique=True, verbose_name = 'PK Região')
    nomreg = models.CharField ( max_length=2     , verbose_name = 'UF')
    def __unicode__(self):
        return self.nomreg 
    class Meta:
        ordering = ('nomreg',)
        verbose_name = 'Região'
        verbose_name_plural = 'Regiões'
        db_table = u'regiao'
        app_label = 'IWG2'

class Localidade(models.Model):
    codloc = models.AutoField( primary_key=True , auto_created=True,         unique=True)
    regiao = models.ForeignKey      ( Regiao, null=True, db_column='regiao_codreg', blank=True, verbose_name = 'Região')
    nome   = models.CharField       ( max_length=64    , db_column='nomloc',                    verbose_name = 'Localidade')
    def Regiao(self):       
        return self.regiao.nomreg
    def __unicode__(self):
        return self.nome
    class Meta:
        #ordering = ('nome',)
        verbose_name = 'Localidade'
        verbose_name_plural = u'Localidades'    
        db_table = u'localidade'
        app_label = 'IWG2'
