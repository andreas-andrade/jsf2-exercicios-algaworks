# -*- coding: utf8 -*-
#=========================================
#=== Inline Capítulo 1: Anamnese:=========
#========================================= 
from MIRA.IWG2.models.Agendamento import Agendamento

from django.contrib import admin

class AgendamentoInline(admin.ModelAdmin):
    model = Agendamento
    extra = 0