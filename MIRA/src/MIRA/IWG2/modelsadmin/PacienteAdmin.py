# -*- coding: utf8 -*-
from MIRA import settings
from MIRA.IWG2.models.Usuario import Usuario
from django import template
from django.contrib import admin
from django.contrib.auth.models import User
register = template.Library()
 
class PacienteAdmin(admin.ModelAdmin):    
    fieldsets = [        
        (None,{'fields': ['nome','iniciais','ultimo_nome','prontuario','nascimento','genero','profissao','email']}),        
        ("Endereço", {'fields': ['endereco','cep','nacionalidade','tel','comercial','cel','localidade'], 'classes': ['grp-collapse grp-closed']}),                       
        ("Documentos e dados", {'fields': ['documento','tipo_de_documento','etnia','mae','pai','estado_civil'], 'classes': ['grp-collapse grp-closed']}),                
     ]
    #===================================================
    # Tronks: "list_per_page" define quantos itens aparecerão em cada página
    list_per_page = 15
    #===================================================
    
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
    
    #list_max_show_all = 15
    list_display = ('prontuario','nome','iniciais', 'ultimo_nome','genero','nascimento','endereco')    
    search_fields = ['prontuario','nome','iniciais','ultimo_nome'] 
    #===================================================
    # Tronks: define quais campos são somente leitura
    readonly_fields = ('nome','codpac','localidade','ultimo_nome','iniciais','documento','tipo_de_documento','nascimento','genero','endereco','cep','nacionalidade','etnia','tel','comercial','cel','mae','pai','profissao','estado_civil','prontuario','responsavel','email',)
    #===================================================
    #readonly_fields = ('nome','iniciais' ,'ultimo_nome', 'prontuario','nascimento','genero')  
    list_filter = ['prontuario','nome','iniciais','ultimo_nome','genero']
    #date_hierarchy = 'nascimento'
    
    #===================================================
    # Tronks: "actions" impede o usuário de realizar ações como salvar ou apagar dados
    actions = None;
    #===================================================  
    
    #===================================================
    # Tronks: Ordenação em que os pacientes serão exibidos:
    ordering = ['-codpac']
    #===================================================
    
    #class Meta:
    #    order_with_respect_to = 'codpac'   
    #def get_ordering(self, request):
    #    return ['codpac']        
    
    class Media:        
        js = (settings.MEDIA_URL+'js/jquery-1.8.2.min.js',settings.MEDIA_URL+'js/jquery.maskedinput-1.2.2.js',settings.MEDIA_URL+'js/mascarasiwg2.js',settings.MEDIA_URL+'js/fechamento.js')
    list_select_related = True
    list_display_links = ('nome',)
        
#================================================================================================================================     
