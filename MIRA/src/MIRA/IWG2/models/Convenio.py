# -*- coding: utf8 -*-
from django.db import models
class Convenio(models.Model):
    codcon = models.AutoField (primary_key=True, auto_created=True, unique=True, verbose_name = 'PK Convênio')
    nome   = models.CharField (max_length=24, db_column='nomcon', verbose_name = 'Nome')
    def __unicode__(self):
        return self.nome
    class Meta:
        verbose_name = 'Convênio'
        verbose_name_plural = u'Convênios'
        db_table = u'convenio'
        app_label = 'IWG2'