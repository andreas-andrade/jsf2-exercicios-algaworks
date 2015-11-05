# -*- coding: utf8 -*-
from django.db import models
class Medico(models.Model):
    codmed   = models.AutoField ( primary_key=True, auto_created=True, unique=True, verbose_name = 'PK Médico') 
    nome     = models.CharField ( max_length=64,              db_column='nommed', verbose_name = 'Nome')    
    crm      = models.CharField ( max_length=12,  null=True, blank=True, db_column='crmmed', verbose_name = 'CRM')
    tel      = models.CharField ( max_length=24,  null=True, blank=True, db_column='telmed', verbose_name = 'Telefone')
    endereco = models.CharField ( max_length=128, null=True, blank=True, db_column='endmed', verbose_name = 'Endereço')   
    
    def __unicode__(self):
        nomeMontado = u'%s' % (self.nome)
        if (self.crm):
            nomeMontado += u' CRM: %s' % (self.crm)        
        return nomeMontado
 
    class Meta:
        ordering = ('nome',)
        verbose_name = 'Médico'
        verbose_name_plural = 'Médicos'
        db_table = u'medico'
        app_label = 'IWG2' 

#=========================================================        

class MedicoSolicitante(models.Model):
    codsol = models.AutoField(primary_key=True, auto_created=True, unique=True, verbose_name = 'PK Médico Solicitante')    
    nome   = models.CharField (max_length=64,             db_column='nomsol', verbose_name = 'Nome')
    crm    = models.CharField (max_length=12, null=True, blank=True, db_column='crmsol', verbose_name = 'CRM')
    tel    = models.CharField (max_length=24, null=True, blank=True, db_column='telsol', verbose_name = 'Telefone')    
    def __unicode__(self):
        nomeMontado = u'%s' % (self.nome)
        if (self.crm):
            nomeMontado += u' CRM: %s' % (self.crm)        
        return nomeMontado        
    class Meta:
        verbose_name = 'Médico solicitante'
        verbose_name_plural = u'Médicos solicitantes'
        db_table = u'medico_solicitante'  
        app_label = 'IWG2' 