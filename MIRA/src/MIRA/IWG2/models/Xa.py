# -*- coding: utf8 -*-
from MIRA.IWG2.models.Exame import Exame
from django.db import models

class Xa(models.Model):
    codima       = models.AutoField         ( primary_key=True , auto_created=True, unique=True, verbose_name = 'PK Xa')
    exame_codexa = models.ForeignKey        ( Exame, db_column='exame_codexa')
    latera       = models.CharField         ( max_length=16, blank=True, verbose_name = 'Lateralidade')
    numimg       = models.CharField         ( max_length=12, blank=True, verbose_name = 'Número da imagem')
    oripac       = models.CharField         ( max_length=32, blank=True, verbose_name = 'Orientação do paciente')
    datima       = models.DateField         ( null=True, blank=True, verbose_name = 'Data em que foi feita a imagem')
    horima       = models.TimeField         ( null=True, blank=True, verbose_name = 'Hora em que foi feita a imagem')
    samperpix    = models.SmallIntegerField ( verbose_name = 'Amostras por pixel (RGB=3, Mono=1)')
    phoint       = models.CharField         ( max_length=16, verbose_name = 'Interpretação fotométrica')
    numlin       = models.SmallIntegerField ( verbose_name = 'Número de linhas')
    numcol       = models.SmallIntegerField ( verbose_name = 'Número de colunas')
    bitall       = models.SmallIntegerField ( verbose_name = 'Bits alocados para cada camada da imagem')
    bitsto       = models.SmallIntegerField ( verbose_name = 'Bits armazenados para cada camada da imagem')
    higbit       = models.SmallIntegerField ( verbose_name = 'Bit mais significativo para os dados dos pixels da camada')
    pixrep       = models.SmallIntegerField ( verbose_name = 'Dados da representação da camada de pixels')
    placon       = models.SmallIntegerField ( null=True, blank=True, verbose_name = 'Configuração planar (color-by-plane ou color-by-pixel)')
    pixasprat    = models.CharField         ( max_length=24, blank=True, verbose_name = 'Razão de aspecto do pixel')
    rpcltdes     = models.TextField         ( blank=True, verbose_name = 'Descritor da Lookup Table vermelha') 
    gpcltdes     = models.TextField         ( blank=True, verbose_name = 'Descritor da Lookup Table verde') 
    bpcltdes     = models.TextField         ( blank=True, verbose_name = 'Descritor da Lookup Table azul') 
    rpcltdat     = models.TextField         ( blank=True, verbose_name = 'Dados da Lookup Table vermelha') 
    gpcltdat     = models.TextField         ( blank=True, verbose_name = 'Dados da Lookup Table verde') 
    bpcltdat     = models.TextField         ( blank=True, verbose_name = 'Dados da Lookup Table azul') 
    conbolage    = models.CharField         ( max_length=64, blank=True, verbose_name = 'Contraste utilizado no exame')
    fratim       = models.CharField         ( max_length=16, blank=True, verbose_name = 'Duração de um frame')
    fravec       = models.TextField         ( blank=True, verbose_name = 'Valores de duração de cada um dos frames da cine')
    numfra       = models.CharField         ( max_length=12, verbose_name = 'Número do frame')
    fraincpoi    = models.IntegerField      ( null=True, blank=True, verbose_name = 'Tempo de duração dos frames')
    masope       = models.CharField         ( max_length=16, blank=True, verbose_name = 'Tipo da máscara (NONE, AVG_SUB ou TID)')
    masfranum    = models.TextField         ( blank=True, verbose_name = 'Número de frames para aplicação da máscara') 
    massubshi    = models.TextField         ( blank=True, verbose_name = 'Shift da máscara') 
    tidoff       = models.SmallIntegerField ( null=True, blank=True, verbose_name = 'TID Offset')
    recviewmod   = models.CharField         ( max_length=16, blank=True, verbose_name = 'Modo recomendado de visualização')
    losimgcom    = models.CharField         ( max_length=16, blank=True, verbose_name = 'Compressão Lossy')
    imgtyp       = models.TextField         ( verbose_name = 'Tipo da imagem')
    pixintrel    = models.CharField         ( max_length=16, verbose_name = 'Relação Pixel/Intensidade de raio X')
    kvp          = models.CharField         ( max_length=16, blank=True, verbose_name = 'Kilovolts')
    radset       = models.CharField         ( max_length=16, verbose_name = 'Nível de exposição')
    ma           = models.CharField         ( max_length=16, blank=True, verbose_name = 'Miliamperes')
    exptim       = models.CharField         ( max_length=12, blank=True, verbose_name = 'Tempo de exposição')
    exposu       = models.CharField         ( max_length=12, blank=True, verbose_name = 'Exposição')
    tabmot       = models.CharField         ( max_length=16, blank=True, verbose_name = 'Movimento da mesa')
    tabverinc    = models.TextField         ( blank=True, verbose_name = 'Incremento vertical da mesa')
    tabloninc    = models.TextField         ( blank=True, verbose_name = 'Incremento longitudinal da mesa')
    tablatinc    = models.TextField         ( blank=True, verbose_name = 'incremento lateral da mesa ')
    pospriang    = models.CharField         ( max_length=16, blank=True, verbose_name = 'Ângulo primário do posicionador')
    possecang    = models.CharField         ( max_length=16, blank=True, verbose_name = 'Ângulo secundário do posicionador')
    posprianginc = models.TextField         ( blank=True, verbose_name = 'Incremento no ângulo primário do posicionador para cada frame')
    possecaninc  = models.TextField         ( blank=True, verbose_name = 'Incremento no ângulo secundário do posicionador para cada frame')
    posmot       = models.CharField         ( max_length=16, blank=True, verbose_name = 'Movimento do posicionador')
    lutdes       = models.TextField         ( blank=True, verbose_name = 'Descritor da LUT') 
    modluttyp    = models.CharField         ( max_length=64, blank=True, verbose_name = 'Unidades de saída da LUT')
    lutdata      = models.TextField         ( blank=True, verbose_name = 'Dados da LUT') 
    resint       = models.CharField         ( max_length=16, blank=True, verbose_name = 'Rescale Intercept')
    resslo       = models.CharField         ( max_length=16, blank=True, verbose_name = 'Rescale Slope')
    restyp       = models.CharField         ( max_length=64, blank=True, verbose_name = 'Rescale Type')
    sopinsuid    = models.CharField         ( max_length=64, blank=True, verbose_name = 'Identificador da instancia SOP')
    icoima       = models.TextField         ( blank=True, verbose_name = 'Ícone da imagem') 
    sernum       = models.CharField         ( max_length=12, blank=True, verbose_name = 'Numero da série')
    tamima       = models.BigIntegerField   ( verbose_name = 'Tamanho da imagem em disco (em bytes)')
    trasyn       = models.SmallIntegerField ( null=True, blank=True, verbose_name = 'Sintaxe de transferência')
    arqdvd       = models.NullBooleanField  ( null=True, blank=True, verbose_name = 'Possibilidade de arquivamento em CD/DVD')
    pathimg      = models.CharField         ( max_length=255, blank=True, verbose_name = 'Caminho do arquivo de imagem')
    seruid       = models.CharField         ( max_length=64, blank=True, verbose_name = 'Identificador único da série')
    imalau       = models.SmallIntegerField ( null=True, blank=True, verbose_name = 'Imagem de laudo')
    class Meta:
        ordering = ('codima',)
        verbose_name = 'Xa'
        verbose_name_plural = 'Xas'
        db_table = u'xa'
        app_label = 'IWG2'