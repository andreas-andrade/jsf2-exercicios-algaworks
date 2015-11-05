# -*- coding: utf8 -*-
from MIRA.IWG2.models.Medicos import Medico
from django.db import models
class Agendamento(models.Model):
    codage         = models.AutoField  (primary_key=True, auto_created=True, unique=True, verbose_name = 'PK Agendamento')    
    medico         = models.ForeignKey (Medico, null=True, db_column='medico_codmed', blank=True, verbose_name = 'Médico')
    data_do_inicio = models.DateField  (db_column='datini', verbose_name = 'Data inícial')
    data_do_fim    = models.DateField  (db_column='datfim', verbose_name = 'Data final')
    hora_do_inicio = models.TimeField  (db_column='horini', verbose_name = 'Hora inícial')
    hora_do_fim    = models.TimeField  (db_column='horfim', verbose_name = 'Hora final')  
    def setMedico(self):
        self.medico = 1
        #self.medico = Medico.objects.get(codmed =1)
    def __unicode__(self):
        return u'Medico: %s Data: %s Hora: %s' % (self.medico, self.data_do_inicio, self.hora_do_inicio)
    class Meta:
        verbose_name = 'Agendamento'
        verbose_name_plural = u'Agendamentos'
        db_table = u'agendamento'
        app_label = 'IWG2'