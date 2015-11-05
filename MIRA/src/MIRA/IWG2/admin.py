from MIRA.IWG2.models.Agendamento import Agendamento
from MIRA.IWG2.models.Convenio import Convenio
from MIRA.IWG2.models.Exame import Exame
from MIRA.IWG2.models.Medicos import Medico, MedicoSolicitante
from MIRA.IWG2.models.Paciente import Paciente
from MIRA.IWG2.models.TipoDeExame import TipoDeExame
from MIRA.IWG2.modelsadmin.AgendamentoAdmin import AgendamentoAdmin
from MIRA.IWG2.modelsadmin.ConvenioAdmin import ConvenioAdmin
from MIRA.IWG2.modelsadmin.ExameAdmin import ExameAdmin
from MIRA.IWG2.modelsadmin.MedicosAdmin import medicoAdmin, \
    medicosolicitanteAdmin
from MIRA.IWG2.modelsadmin.PacienteAdmin import PacienteAdmin
from MIRA.IWG2.modelsadmin.TipoDeExameAdmin import TipoDeExameAdmin
from django.contrib import admin

#=========================================================

#from MIRA.IWG2.models.Equipamento import Equipamento
#from MIRA.IWG2.models.Hospital    import Hospital
#from MIRA.IWG2.models.Regiao      import Regiao
#from MIRA.IWG2.models.Regiao      import Localidade
#from MIRA.IWG2.models.Usuario     import Usuario
#from MIRA.IWG2.models.Visita      import Visita
#from MIRA.IWG2.models.Xa          import Xa
#from MIRA.IWG2.models.Ct          import Ct
#from MIRA.IWG2.models.Cr          import Cr
#from MIRA.IWG2.models.Dx          import Dx
#from MIRA.IWG2.models.Es          import Es
#from MIRA.IWG2.models.Mg          import Mg
#from MIRA.IWG2.models.Mr          import Mr
#from MIRA.IWG2.models.Us          import Us
#from MIRA.IWG2.models.Seccapt     import Seccapt

#=========================================================

#from MIRA.IWG2.modelsadmin.RegiaoAdmin      import RegiaoAdmin
#from MIRA.IWG2.modelsadmin.MedicosAdmin     import medicoAdmin, medicosolicitanteAdmin
#from MIRA.IWG2.modelsadmin.AgendamentoAdmin import AgendamentoAdmin
#from MIRA.IWG2.modelsadmin.RegiaoAdmin      import LocalidadeAdmin

#=========================================================

admin.site.register ( Agendamento, AgendamentoAdmin )
admin.site.register ( Convenio, ConvenioAdmin   )
admin.site.register ( Exame   , ExameAdmin )
#admin.site.register ( Equipamento )
#admin.site.register ( Hospital    )
#admin.site.register ( Localidade , LocalidadeAdmin )
admin.site.register ( Medico , medicoAdmin )
admin.site.register ( MedicoSolicitante , medicosolicitanteAdmin )
admin.site.register ( Paciente , PacienteAdmin)
#admin.site.register ( Regiao, RegiaoAdmin )
admin.site.register ( TipoDeExame, TipoDeExameAdmin )
#admin.site.register ( Usuario     )
#admin.site.register ( Visita      )
#admin.site.register ( Xa          )
#admin.site.register ( Ct          )
#admin.site.register ( Cr          )
#admin.site.register ( Dx          )
#admin.site.register ( Es          )
#admin.site.register ( Mg          )
#admin.site.register ( Mr          )
#admin.site.register ( Us          )
#admin.site.register ( Seccapt     )

#=========================================================