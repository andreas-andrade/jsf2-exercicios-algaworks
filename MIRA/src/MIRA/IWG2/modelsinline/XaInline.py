# -*- coding: utf8 -*-
from MIRA.IWG2.models.Xa import Xa
from django.contrib import admin

class XaInline(admin.StackedInline):
    model = Xa
    extra = 0