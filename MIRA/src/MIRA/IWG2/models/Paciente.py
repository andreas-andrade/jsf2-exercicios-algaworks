# -*- coding: utf8 -*-
from MIRA.IWG2.models.Regiao import Localidade
from django.db import models

class Paciente(models.Model):    
    codpac            = models.AutoField  (primary_key=True, auto_created=True, unique=True, null=False, db_column='codpac', verbose_name = 'PK Paciente')
    localidade        = models.ForeignKey (Localidade,     null=True, db_column='localidade_codloc', blank=True, verbose_name = 'Localidade')    
    nome              = models.CharField  (max_length=64,             db_column='nompac', verbose_name = 'Nome',help_text='Note que o nome do paciente é formado por três campos: nome, nome do meio e último nome')
    ultimo_nome       = models.CharField  (max_length=64,  null=True, blank=True, db_column='fampac', verbose_name = 'Último nome')
    iniciais          = models.CharField  (max_length=64,  null=True, blank=True, db_column='inipac', verbose_name = 'Nome do meio')
    documento         = models.CharField  (max_length=24,  null=True, blank=True, db_column='docpac', verbose_name = 'Documento')
    tipo_de_documento = models.CharField  (max_length=64,  null=True, blank=True, db_column='tipdoc', verbose_name = 'Tipo de documento')    
    nascimento        = models.DateField  (                null=True, blank=True, db_column='datnas', verbose_name = 'Data de nascimento')
    genero            = models.CharField  (max_length=1,   null=True, blank=True, db_column='sexpac', verbose_name = 'Gênero')
    endereco          = models.CharField  (max_length=128, null=True, blank=True, db_column='endpac', verbose_name = 'Endereço')
    cep               = models.CharField  (max_length=24,  null=True, blank=True, db_column='ceppac', verbose_name = 'CEP')
    nacionalidade     = models.CharField  (max_length=20,  null=True, blank=True, db_column='nacpac', verbose_name = 'Nacionalidade')
    etnia             = models.CharField  (max_length=16,  null=True, blank=True, db_column='etnpac', verbose_name = 'Etnia')
    tel               = models.CharField  (max_length=24,  null=True, blank=True, db_column='telpac', verbose_name = 'Telefone')
    comercial         = models.CharField  (max_length=24,  null=True, blank=True, db_column='compac', verbose_name = 'Telefone Comercial')
    cel               = models.CharField  (max_length=24,  null=True, blank=True, db_column='celpac', verbose_name = 'Telefone Celular')
    mae               = models.CharField  (max_length=64,  null=True, blank=True, db_column='maepac', verbose_name = 'Mãe')
    pai               = models.CharField  (max_length=64,  null=True, blank=True, db_column='paipac', verbose_name = 'Pai')
    profissao         = models.CharField  (max_length=64,  null=True, blank=True, db_column='propac', verbose_name = 'Profissão')
    estado_civil      = models.CharField  (max_length=16,  null=True, blank=True, db_column='estciv', verbose_name = 'Estado Civil')
    prontuario        = models.CharField  (max_length=64,  null=True, blank=True, db_column='prtpac', verbose_name = 'ID do Paciente')
    responsavel       = models.CharField  (max_length=64,  null=True, blank=True, db_column='respac', verbose_name = 'Responsável')  
    #status            = models.CharField  (max_length=128, null=True, blank=True, db_column='status', verbose_name = 'Status')       
    email             = models.CharField  (max_length=64,  null=True, blank=True, db_column='emapac', verbose_name = 'E-mail')    
    # ========================================================================================================================================================         
    
    def __unicode__(self):
        nomeMontado = u'%s' % (self.nome)
        if (self.iniciais):
            nomeMontado += u' %s' % (self.iniciais)
        if (self.ultimo_nome):
            nomeMontado += u' %s' % (self.ultimo_nome)
        return nomeMontado
            
    class Meta:
        ordering = ('prontuario',)
        verbose_name = 'Paciente'
        verbose_name_plural = u'Pacientes'
        db_table = u'paciente'
        app_label = 'IWG2'