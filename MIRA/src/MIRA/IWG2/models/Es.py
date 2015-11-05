# -*- coding: utf8 -*-
from MIRA.IWG2.models.Exame import Exame
from django.db import models

class Es(models.Model):
    codima       = models.AutoField ( primary_key=True , auto_created=True, unique=True, verbose_name = 'PK Es')
    exame_codexa = models.ForeignKey(Exame, db_column='exame_codexa')
    numimg       = models.CharField(max_length=12, blank=True)
    latera       = models.CharField(max_length=16, blank=True)
    pospac       = models.CharField(max_length=16, blank=True)
    oripac       = models.CharField(max_length=32, blank=True)
    datima       = models.DateField(null=True, blank=True)
    horima       = models.TimeField(null=True, blank=True)
    samperpix    = models.SmallIntegerField()
    phoint       = models.CharField(max_length=16)
    numlin       = models.SmallIntegerField()
    numcol       = models.SmallIntegerField()
    bitall       = models.SmallIntegerField()
    bitsto       = models.SmallIntegerField()
    higbit       = models.SmallIntegerField()
    pixrep       = models.SmallIntegerField()
    placon       = models.SmallIntegerField(null=True, blank=True)
    pixasprat    = models.CharField(max_length=24, blank=True)
    rpcltdes     = models.TextField(blank=True)
    gpcltdes     = models.TextField(blank=True)
    bpcltdes     = models.TextField(blank=True)
    rpcltdat     = models.TextField(blank=True)
    gpcltdat     = models.TextField(blank=True)
    bpcltdat     = models.TextField(blank=True)
    imgtyp       = models.TextField()
    losimgcom    = models.CharField(max_length=16, blank=True)
    refsopclauid = models.CharField(max_length=64, blank=True)
    refsopinsuid = models.CharField(max_length=64, blank=True)
    sopinsuid    = models.CharField(max_length=64, blank=True)
    icoima       = models.TextField(blank=True)
    sernum       = models.CharField(max_length=12, blank=True)
    tamima       = models.BigIntegerField()
    trasyn       = models.SmallIntegerField(null=True, blank=True)
    arqdvd       = models.NullBooleanField(null=True, blank=True)
    pathimg      = models.CharField(max_length=255, blank=True)
    seruid       = models.CharField(max_length=64, blank=True)
    imalau       = models.SmallIntegerField(null=True, blank=True)
    class Meta:        
        ordering = ('codima',)
        verbose_name = 'Es'
        verbose_name_plural = 'Es'
        db_table = u'es'
        app_label = 'IWG2'