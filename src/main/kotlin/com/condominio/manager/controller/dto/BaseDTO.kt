package com.condominio.manager.controller.dto

abstract class BaseDTO<T> {
    abstract fun toEntity() : T
}