# -*- coding: utf8 -*-
from MIRA.IWG2.models.Visita import Visita
from django.contrib import admin

class VisitaInline(admin.ModelAdmin):
    model = Visita
    extra = 0
