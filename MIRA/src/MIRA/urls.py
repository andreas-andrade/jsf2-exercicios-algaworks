# -*- coding: utf8 -*-
from MIRA import settings
from django.conf.urls import patterns, include, url
from django.contrib import admin
from django.views.generic.base import RedirectView

# Uncomment the next two lines to enable the admin:
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'MIRA.views.home', name='home'),
    # url(r'^MIRA/', include('MIRA.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),
    
    (r'^grappelli/', include('grappelli.urls')),
    # Uncomment the next line to enable the admin:
    url(r'^admin/', include(admin.site.urls)),
    url(r'^mplayer/(?P<id_exame>\w+)/$', 'MIRA.IWG2.views.mplayer'),    
    #=======================================================
    # Tronks: A URL abaixo redireciona o diretório raiz diretamente para a pasta admin
    url(r'^$', RedirectView.as_view(url='/admin')),
    #=======================================================
)

urlpatterns += patterns('',
                            (r'^cines/(.*)$', 'django.views.static.serve',{'document_root': settings.MEDIA_ROOT+'\cines'}),
                            (r'^laudos/(.*)$', 'django.views.static.serve',{'document_root': settings.MEDIA_ROOT+'\laudos'}),)
