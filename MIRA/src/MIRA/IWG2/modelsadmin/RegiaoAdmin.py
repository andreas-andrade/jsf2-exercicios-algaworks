# -*- coding: utf8 -*-
from django.contrib import admin

class RegiaoAdmin(admin.ModelAdmin):
    fields = ['nomreg']

#================================================================================================================================
    
class LocalidadeAdmin(admin.ModelAdmin):
    fieldsets = [        
        (None,{'fields': ['nome','regiao']}),          
     ]
    list_per_page = 15
    #list_max_show_all = 30
    list_display = ('nome','regiao')    
    search_fields = ['nome','regiao'] 
    #list_filter = ['local']
    list_display_links = ('nome',)