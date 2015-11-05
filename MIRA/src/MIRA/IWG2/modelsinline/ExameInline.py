# -*- coding: utf8 -*-
from MIRA.IWG2.models.Exame import Exame
from django.contrib import admin

class ExameInline(admin.ModelAdmin):
    model = Exame
    extra = 0    
    fieldsets = [        
        (None,{'fields': ['exauid','data','hora','altura','peso','idade']}),          
     ]