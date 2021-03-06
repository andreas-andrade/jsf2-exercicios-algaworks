# -*- coding: utf8 -*-
from MIRA.IWG2.models.Exame import Exame
from django.db import models

class Us(models.Model):
    codima       = models.AutoField ( primary_key=True , auto_created=True, unique=True, verbose_name = 'PK Us')
    exame_codexa = models.ForeignKey(Exame, db_column='exame_codexa')
    numimg       = models.CharField(max_length=12, blank=True)
    latera       = models.CharField(max_length=16, blank=True)
    pospac       = models.CharField(max_length=16, blank=True)
    clitricoo    = models.CharField(max_length=64, blank=True)
    frarefuid    = models.CharField(max_length=64, blank=True)
    indposref    = models.CharField(max_length=64, blank=True)
    reglocminx   = models.BigIntegerField(null=True, blank=True)
    reglocminy   = models.BigIntegerField(null=True, blank=True)
    reglocmaxx   = models.BigIntegerField(null=True, blank=True)
    reglocmaxy   = models.BigIntegerField(null=True, blank=True)
    phyunixdir   = models.SmallIntegerField(null=True, blank=True)
    phyuniydir   = models.SmallIntegerField(null=True, blank=True)
    phydelx      = models.FloatField(null=True, blank=True)
    phydely      = models.FloatField(null=True, blank=True)
    synfrarefuid = models.CharField(max_length=64, blank=True)
    syntri       = models.CharField(max_length=16, blank=True)
    syncha       = models.TextField(blank=True)
    acqtimsyn    = models.CharField(max_length=16, blank=True)
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
    conbolage    = models.CharField(max_length=64, blank=True)
    segrpcltdat  = models.TextField(blank=True)
    seggpcltdat  = models.TextField(blank=True)
    segbpcltdat  = models.TextField(blank=True)
    imgtyp       = models.TextField()
    losimgcom    = models.CharField(max_length=16, blank=True)
    numsta       = models.CharField(max_length=64, blank=True)
    numviesta    = models.CharField(max_length=64, blank=True)
    acqdattim    = models.DateTimeField(null=True, blank=True)
    ivuacq       = models.CharField(max_length=16, blank=True)
    ivupullrat   = models.CharField(max_length=16, blank=True)
    ivugatrat    = models.CharField(max_length=16, blank=True)
    ivstafranum  = models.CharField(max_length=12, blank=True)
    ivstofranum  = models.CharField(max_length=12, blank=True)
    sopinsuid    = models.CharField(max_length=64, blank=True)
    icoima       = models.TextField(blank=True)
    sernum       = models.CharField(max_length=12, blank=True)
    tamima       = models.BigIntegerField()
    trasyn       = models.SmallIntegerField(null=True, blank=True)
    lutdes       = models.TextField(blank=True)
    lutdata      = models.TextField(blank=True)
    arqdvd       = models.NullBooleanField(null=True, blank=True)
    pathimg      = models.CharField(max_length=255, blank=True)
    seruid       = models.CharField(max_length=64, blank=True)
    imalau       = models.SmallIntegerField(null=True, blank=True)
    class Meta:        
        ordering = ('codima',)
        verbose_name = 'Us'
        verbose_name_plural = 'Us'
        db_table = u'us'
        app_label = 'IWG2'
