# -*- coding: utf8 -*-
from MIRA import settings
from MIRA.IWG2.models.Exame import Exame
from django.shortcuts import render_to_response
import glob
import os

def mplayer(request, id_exame):
    
    #C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\iwg2\pages\cines\1.2.826.0.1.3680043.2.532.1.20100212083402296
    
    #============================================================
    # Buscando as pastas de media
    #v_url_media = settings.MEDIA_URL 
    v_root_media = settings.MEDIA_ROOT
    
    #============================================================    
    v_exame_publicado = True
    #============================================================
    
    # Buscando o exame a partir de sua chave primaria
    v_exame = Exame.objects.get(codexa = id_exame)     
    
    #============================================================  
    # Montando o diretório do exame e do laudo:
    v_diretorio_do_exame = v_root_media + "\\cines\\" + v_exame.exauid    
    #v_diretorio_do_exame = v_diretorio_do_exame.replace('\\', '/')
    
    v_diretorio_do_laudo = v_root_media + "\\laudos\\" + v_exame.exauid    
    #v_diretorio_do_laudo = v_diretorio_do_laudo.replace('\\', '/')
    
    #============================================================
    
    # Verifica se o arquivo de laudo existe:
    v_laudo = os.path.isdir(v_diretorio_do_laudo)
    #You're looking for os.path.isdir, or os.path.exists if you don't care whether it's a file or a directory.
    
    #============================================================
        
    # Encontrando quantos arquivos existem no diretório:
    if v_laudo:
        v_numero_de_arquivos = len(os.walk(v_diretorio_do_laudo).next()[2])
    else:
        v_numero_de_arquivos = 0
    
    #============================================================
    
    # Montando a lista de arquivos:    
    v_lista_de_arquivos = []
    try:
        for arquivo in os.listdir(v_diretorio_do_exame.replace('\\', '\\\\')):
            if arquivo.endswith("jpg"):
                v_lista_de_arquivos.append("%s" % (os.path.splitext("%s" % (arquivo))[:1]))
    except Exception as e: 
        v_lista_de_arquivos.append("");
        v_exame_publicado = False
    #============================================================
    
    # Tronks: Se não conseguiu acessar nenhum arquivo, é porque a pasta existe, porém está vazia
    if len(v_lista_de_arquivos) == 0:
        v_lista_de_arquivos.append("");
        v_exame_publicado = False
    #============================================================
    
    # Encontrando quantos arquivos de um determinado tipo existem no diretório:    
    v_numero_de_jpg = len(glob.glob1(v_diretorio_do_laudo,"*.jpg"))     
    #v_numero_de_swf = len(glob.glob1(v_diretorio_do_exame,"*.swf"))
    #v_numero_de_mov = len(glob.glob1(v_diretorio_do_exame,"*.mov"))
    #v_numero_de_mp4 = len(glob.glob1(v_diretorio_do_exame,"*.mp4"))
         
    return render_to_response('admin/mplayer.html',{'diretorio_do_exame'  :v_diretorio_do_exame,
                                                    'exame'               :v_exame,                                                    
                                                    'laudo'               :v_laudo,
                                                    'exame_publicado'     :v_exame_publicado,
                                                    'primeiro'            :("%s" % v_lista_de_arquivos[0]),                                                    
                                                    'lista_de_arquivos'   :v_lista_de_arquivos,
                                                    'numero_de_arquivos'  :v_numero_de_arquivos,
                                                    'numero_de_jpg'       :v_numero_de_jpg})