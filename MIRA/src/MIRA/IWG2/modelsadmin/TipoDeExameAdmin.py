# -*- coding: utf8 -*-
from MIRA.IWG2.models.Usuario import Usuario
from django.contrib import admin
from django.contrib.auth.models import User
class TipoDeExameAdmin(admin.ModelAdmin):
    fieldsets = [        
        (None,{'fields': ['nome_do_exame','titulo_para_laudo']}),          
     ]
    list_per_page = 15
    #list_max_show_all = 30
    list_display = ('nome_do_exame','titulo_para_laudo')
    search_fields = ['nome_do_exame']    
    list_display_links = ('nome_do_exame',)
    
    #===================================================
    # Tronks: A sobrecarga do método get_model_perms provê o controle do que o usuário poderá ver
    def get_model_perms(self, request, *args, **kwargs):
        v_user = User.objects.get(username=request.user)
        v_usuario = Usuario.objects.get(user = v_user);      
        if v_usuario.tipo == 3:   #usuário tipo 3 = gerente (pode ver as informações dos pacientes)
            perms = admin.ModelAdmin.get_model_perms(self, request, *args, **kwargs)
            return perms        
        else: #usuário dos demais tipos (não podem ver as informações dos pacientes)
            return {}
        
    # Tronks: métodos de definição de permissões
    def has_add_permission(self, request, obj=None):
        return False
    def has_change_permission(self, request, obj=None):
        return True
    def has_delete_permission(self, request, obj=None):
        return False
    #===================================================    
    
#================================================================================================================================
