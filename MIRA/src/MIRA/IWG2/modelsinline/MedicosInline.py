# -*- coding: utf8 -*-
from django.contrib import admin

class medicoAdmin(admin.ModelAdmin):
    fieldsets = [        
        (None,{'fields': ['nome','crm', 'tel', 'endereco']}),          
     ]
    list_per_page = 15
    #list_max_show_all = 30
    list_display = ('nome','crm', 'tel','endereco')
    search_fields = ['nome','crm']    
    list_display_links = ('nome',)
    
#================================================================================================================================

class medicosolicitanteAdmin(admin.ModelAdmin):
    fieldsets = [        
        (None,{'fields': ['nome','crm', 'tel']}),          
     ]
    list_per_page = 15
    #list_max_show_all = 30
    list_display = ('nome','crm', 'tel')
    search_fields = ['nome','crm']    
    list_display_links = ('nome',)
