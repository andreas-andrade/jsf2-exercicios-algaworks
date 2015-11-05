# -*- coding: utf8 -*-
from MIRA.IWG2.models.Agendamento import Agendamento
from MIRA.IWG2.models.Convenio import Convenio
from MIRA.IWG2.models.TipoDeExame import TipoDeExame
from django.db import models
class Visita(models.Model):
    codvis        = models.AutoField  ( primary_key=True, auto_created=True, unique=True)
    tipo_de_exame = models.ForeignKey ( TipoDeExame, null=True,    db_column='tipo_de_exame_codtip', verbose_name = '', blank=True)
    agendamento   = models.ForeignKey ( Agendamento,               db_column='agendamento_codage',   verbose_name = '')
    convenio      = models.ForeignKey ( Convenio, null=True,       db_column='convenio_codcon',      verbose_name = '', blank=True)
    paciente      = models.ForeignKey ( 'Paciente',                db_column='paciente_codpac',      verbose_name = '')
    status        = models.CharField  ( max_length=16,             db_column='stavis',    verbose_name = 'Status')
    matricula     = models.CharField  ( max_length=64, null=True, blank=True, db_column='matconvis', verbose_name = 'Matrícula')
    titular       = models.CharField  ( max_length=64, null=True, blank=True, db_column='titconvis', verbose_name = 'Titular')
    def __unicode__(self):
        return u'EXAME:%s' % (self.tipo_de_exame)
    class Meta:
        verbose_name = 'Visita'
        verbose_name_plural = u'Visitas'
        db_table = u'visita' 
        app_label = 'IWG2'  