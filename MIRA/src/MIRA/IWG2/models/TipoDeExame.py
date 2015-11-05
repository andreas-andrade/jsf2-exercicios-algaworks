# -*- coding: utf8 -*-
from django.db import models
class TipoDeExame(models.Model):
    codtip            = models.AutoField (primary_key=True, auto_created=True, unique=True, verbose_name = 'PK Tipo de exame')
    nome_do_exame     = models.CharField (max_length=64, db_column='nomtip', verbose_name = 'Tipo de Exame')
    titulo_para_laudo = models.CharField (max_length=64, null=True, blank=True, db_column='tittip', verbose_name = 'Título para o laudo')
    def __unicode__(self):
        return self.nome_do_exame     
    class Meta:
        verbose_name = 'Tipo de exames'
        verbose_name_plural = u'Tipos de exame'
        db_table = u'tipo_de_exame'
        app_label = 'IWG2'