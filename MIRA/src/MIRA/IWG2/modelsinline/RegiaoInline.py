# -*- coding: utf8 -*-
from MIRA.IWG2.models.Regiao import Regiao, Localidade
from django.contrib import admin

class RegiaoInline(admin.StackedInline):
    model = Regiao
    extra = 0
class LocalidadeInline(admin.TabularInline):
    model = Localidade
    extra = 0
