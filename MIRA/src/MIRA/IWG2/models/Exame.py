# -*- coding: utf8 -*-
from MIRA.IWG2.models.Equipamento import Equipamento
from MIRA.IWG2.models.Medicos import MedicoSolicitante
from MIRA.IWG2.models.Visita import Visita
from django.db import models
class Exame(models.Model):
    codexa              = models.AutoField         (primary_key=True, auto_created=True, unique=True)    
    visita              = models.ForeignKey        (Visita,                               db_column='visita_codvis',             verbose_name = 'Visita')
    medico_solicitante  = models.ForeignKey        (MedicoSolicitante, null=True,         db_column='medico_solicitante_codsol', verbose_name = 'Médico Solicitante', blank=True)    
    data                = models.DateField         (               null=True, blank=True, db_column='datexa',                    verbose_name = 'Data do exame')
    hora                = models.TimeField         (               null=True, blank=True, db_column='horexa',                    verbose_name = 'Hora inicial')
    exauid              = models.CharField         (max_length=64,                        db_column='exauid',                    verbose_name = 'Study UID')
    exaid               = models.CharField         (max_length=16, null=True, blank=True, db_column='exaid',                     verbose_name = 'Id do Procedimento')    
    accnum              = models.CharField         (max_length=16, null=True, blank=True, db_column='accnum',                    verbose_name = 'Prontuário')
    tipo_de_equipamento = models.CharField         (max_length=16, null=True, blank=True, db_column='tipequ',                    verbose_name = 'Tipo de equipamento')
    fabricante          = models.CharField         (max_length=64, null=True, blank=True, db_column='nomfab',                    verbose_name = 'Fabricante')
    modelo              = models.CharField         (max_length=64, null=True, blank=True, db_column='modnam',                    verbose_name = 'Modelo')
    serial              = models.CharField         (max_length=64, null=True, blank=True, db_column='sernumequ',                 verbose_name = 'Serial')
    versao              = models.TextField         (               null=True, blank=True, db_column='sofver',                    verbose_name = 'Versão do software')    
    idade               = models.IntegerField      (               null=True, blank=True, db_column='idapac',                    verbose_name = 'Idade')
    altura              = models.CharField         (max_length=16, null=True, blank=True, db_column='altpac',                    verbose_name = 'Altura')
    peso                = models.CharField         (max_length=16, null=True, blank=True, db_column='pespac',                    verbose_name = 'Peso')    
    estado              = models.SmallIntegerField (               null=True, blank=True, db_column='estexa',                    verbose_name = 'Estado do exame')
    exame_em_uso        = models.SmallIntegerField (               null=True, blank=True, db_column='exauso',                    verbose_name = 'Em uso?')    
    lauhtm              = models.NullBooleanField  (               null=True, blank=True, db_column='lauhtm',                    verbose_name = 'Publicado na web?')
    lauexa              = models.TextField         (               null=True, blank=True, db_column='lauexa')
    tamanho             = models.BigIntegerField   (               null=True, blank=True, db_column='tamexa',                    verbose_name = 'Tamanho')
    #exaval             = models.IntegerField      (               null=True, blank=True)
    equipamento_codequ  = models.ForeignKey        (Equipamento,   null=True, db_column='equipamento_codequ', blank=True)
    teste = '';                                        
    
    def Medico_Responsavel(self):       
        return self.visita.agendamento.medico
    
    def Convenio(self):       
        return self.visita.convenio.nome
    
    def Sexo_do_Paciente(self):
        if (self.visita.paciente.genero == "F"):
            return 'Feminino'
        elif (self.visita.paciente.genero == "M"):
            return 'Masculino'
        else:
            return 'Desconhecido'
        
    def Nome_do_Paciente(self):        
        nomeMontado = u'%s' % (self.visita.paciente.nome)
        if (self.visita.paciente.iniciais):
            nomeMontado += u' %s' % (self.visita.paciente.iniciais)
        if (self.visita.paciente.ultimo_nome):
            nomeMontado += u' %s' % (self.visita.paciente.ultimo_nome)
        return nomeMontado
    Nome_do_Paciente.allow_tags = True
       
    def Descricao_do_Procedimento(self):
        return self.visita.tipo_de_exame.nome_do_exame
    
    def ID_do_Paciente(self):
        return self.visita.paciente.prontuario
    
    def __unicode__(self):
        return self.Nome_do_Paciente()
    
    class Meta:
        verbose_name = 'Exame'
        verbose_name_plural = u'Exames'
        db_table = u'exame'
        app_label = 'IWG2'