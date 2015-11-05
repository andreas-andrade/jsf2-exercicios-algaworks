# -*- coding: utf8 -*-
from django.contrib import admin
from MIRA.IWG2.models import Paciente

class PacienteInline(admin.ModelAdmin):
    model = Paciente
    extra = 0