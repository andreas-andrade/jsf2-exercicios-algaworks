# -*- coding: utf8 -*-
from MIRA.IWG2.models import Exame, Usuario
from MIRA.IWG2.models.Agendamento import Agendamento
from MIRA.IWG2.models.Medicos import Medico, MedicoSolicitante
from MIRA.IWG2.models.Paciente import Paciente
from MIRA.IWG2.models.Visita import Visita
from django.contrib import admin
from django.contrib.auth.models import User

class ExameAdmin(admin.ModelAdmin):
    prepopulated_fields_js = {'paciente':('visita.paciente.nome'),}
    fieldsets = [        
        (None,{'fields': ['paciente']}),
        #,'genero','idade','tipo_de_exame','convenio'        
        #("Médicos", {'fields': ['medico_solicitante','medico_responsavel',], 'classes': ['grp-collapse grp-closed']}),
        #("Data do Exame", {'fields': ['data','hora'], 'classes': ['grp-collapse grp-closed']}),
        #("Medidas do Paciente", {'fields': ['altura','peso'], 'classes': ['grp-collapse grp-closed']}),        
     ]
    readonly_fields = ['paciente','medico_solicitante','medico_responsavel','idade','convenio','genero','tipo_de_exame']
    
    #js = (settings.MEDIA_URL+'js/jquery-1.8.2.min.js',settings.MEDIA_URL+'js/jquery-1.9.1.js',settings.MEDIA_URL+'js/sofexVideoPlayer.js')
        
    #===================================================
    # Tronks: "list_per_page" define quantos itens aparecerão em cada página
    list_per_page = 15
    #===================================================
    
    #===================================================
    # Tronks: Definições de permissões
    def has_add_permission(self, request, obj=None):
        return False
    def has_change_permission(self, request, obj=None):
        return True
    def has_delete_permission(self, request, obj=None):
        return False
    #===================================================
        
    #list_max_show_all = 30
    list_display = ('exaid','id_do_paciente','paciente','tipo_de_exame','data','medico_solicitante','medico_responsavel')
    #inlines = [XaInline,] 
    search_fields = ['exaid','visita__paciente__prontuario','visita__paciente__nome','visita__paciente__iniciais','visita__paciente__ultimo_nome','visita__tipo_de_exame__nome_do_exame']        
    list_filter = ['exaid','visita__paciente__prontuario','visita__paciente__nome','visita__paciente__iniciais','visita__paciente__ultimo_nome','visita__tipo_de_exame__nome_do_exame']    
    list_display_links = ('paciente',)        
    
    #===================================================
    # Tronks: "actions" impede o usuário de realizar ações (como por exemplo, salvar ou apagar dados)
    actions = None;
    #===================================================
    
    #===================================================
    # Tronks: Ordenação em que os exames serão exibidos:
    ordering = ['-codexa']
    #===================================================
    
    #inlines = [ExameInline]
    
    #===================================================
    # Tronks: métodos da classe exame:        
    def id_do_paciente(self, obj):
        return obj.ID_do_Paciente()
    id_do_paciente.short_description = 'Id do Paciente' 
    id_do_paciente.admin_order_field = 'visita__paciente__prontuario'
    
    def paciente(self, obj):
        return obj.Nome_do_Paciente()
    paciente.short_description = 'Nome do Paciente' 
    paciente.admin_order_field = 'visita__paciente__nome'
    
    def medico_responsavel(self, obj):
        return obj.Medico_Responsavel()
    medico_responsavel.short_description = 'Médico Responsável'
    medico_responsavel.admin_order_field = 'visita__agendamento__medico__nome'
    
    def convenio(self, obj):
        return obj.Convenio()
    convenio.short_description = 'Convênio'
    convenio.admin_order_field = 'visita__convenio__nome'
    
    def genero(self, obj):
        return obj.Sexo_do_Paciente()
    genero.short_description = 'Gênero'
    genero.admin_order_field = 'visita__paciente__genero'
    
    def tipo_de_exame(self, obj):
        return obj.Descricao_do_Procedimento()
    tipo_de_exame.short_description = 'Descrição do procedimento'
    tipo_de_exame.admin_order_field = 'visita__tipo_de_exame__nome_do_exame'
    
    # Tronks: A sobrecarga do método queryset provê o controle dos resultados da pesquisa no admin
    def queryset(self, request):
        v_user = User.objects.get(username=request.user)
        v_usuario = Usuario.objects.get(user = v_user);        
        v_visitas =[]                
        
        if v_usuario.tipo == 3:   #usuário tipo 3 = gerente (vê todos os exames)
            return Exame.objects.all()
        
        elif v_usuario.tipo == 2: #usuário tipo 2 = paciente (vê apenas os exames dele)
            v_paciente = Paciente.objects.filter(codpac = v_usuario.paciente.codpac);
            v_visitas = Visita.objects.filter(paciente = v_paciente);            
            return Exame.objects.filter(visita__in = v_visitas);            
        
        elif v_usuario.tipo == 1: #usuário tipo 1 = médico solicitante (vê apenas os exames solicitados por ele)            
            v_medico = MedicoSolicitante.objects.filter(codsol = v_usuario.medico_solicitante.codsol);
            return Exame.objects.filter(medico_solicitante = v_medico);
        
        elif v_usuario.tipo == 0: #usuário tipo 0 = médico responsável (hemodinamicista) (vê apenas os exames realizados por ele)
            v_agendamentos =[]
            v_medico = Medico.objects.filter(codmed = v_usuario.medico.codmed);
            v_agendamentos = Agendamento.objects.filter(medico = v_medico);
            v_visitas = Visita.objects.filter(agendamento__in = v_agendamentos);
            return Exame.objects.filter(visita__in = v_visitas);
    #===================================================
