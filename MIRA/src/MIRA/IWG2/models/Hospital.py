# -*- coding: utf8 -*-
from django.db import models
class Hospital(models.Model):
    codhos   = models.AutoField ( primary_key=True, auto_created=True, unique=True, verbose_name = 'PK Hospital')
    nome     = models.CharField ( max_length=64, db_column='nomhos', verbose_name = 'Nome')
    endereco = models.TextField ( null=True, blank=True, db_column='endhos', verbose_name = 'Endereço')
    cep      = models.CharField ( max_length=24, null=True, blank=True, db_column='cephos', verbose_name = 'CEP')
    tel      = models.CharField ( max_length=24, null=True, blank=True, db_column='telhos', verbose_name = 'Telefone')
    fax      = models.CharField ( max_length=24, null=True, blank=True, db_column='faxhos', verbose_name = 'Fax')
    web      = models.CharField ( max_length=64, null=True, blank=True, db_column='webhos', verbose_name = 'Página')
    email    = models.CharField ( max_length=64, null=True, blank=True, db_column='emahos', verbose_name = 'E-mail')
    def __unicode__(self):
        return self.nome
    class Meta:
        verbose_name = 'Hospital'
        verbose_name_plural = u'Hospitais'
        db_table = u'hospital'
        app_label = 'IWG2'