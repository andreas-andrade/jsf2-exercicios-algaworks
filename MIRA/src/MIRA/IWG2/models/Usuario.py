# -*- coding: utf8 -*-
from django.contrib.auth.models import User
from django.db import models
class Usuario(models.Model):
    codusu             = models.AutoField(primary_key=True, auto_created=True, unique=True, verbose_name = 'PK Usuário')   
    medico             = models.ForeignKey   ('Medico', null=True,            db_column='medico_codmed',             verbose_name = 'M�dico',             blank=True)
    medico_solicitante = models.ForeignKey   ('MedicoSolicitante', null=True, db_column='medico_solicitante_codsol', verbose_name = 'M�dico Solicitante', blank=True)
    paciente           = models.ForeignKey   ('Paciente', null=True,          db_column='paciente_codpac',           verbose_name = 'Paciente',           blank=True,)
    nome               = models.CharField    (max_length=64,                db_column='nomusu' ,                   verbose_name = 'Nome')
    senha              = models.CharField    (max_length=64,                db_column='senusu' ,                   verbose_name = 'Senha')
    permissao          = models.IntegerField (                              db_column='permusu',                   verbose_name = 'Permiss�o')
    tipo               = models.IntegerField (                              db_column='tipusu' ,                   verbose_name = 'Tipo de usu�rio')
    remoto             = models.IntegerField (null=True, blank=True,        db_column='remoto' ,                   verbose_name = 'Remoto')
    user               = models.ForeignKey(User,null=True, blank=True, )
    fotusu             = models.TextField(null=True,blank=True)
    digusu             = models.TextField(blank=True) # This field type is a guess.

    def __unicode__(self):
        return self.nome
    class Meta:
        verbose_name = 'Usuário'
        verbose_name_plural = u'Usuários'
        db_table = u'usuario'
        app_label = 'IWG2'