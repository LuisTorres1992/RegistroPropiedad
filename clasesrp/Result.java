/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import java.io.Serializable;

/**
 *
 * @author evill
 */
public class Result implements Serializable {
       public static final int OK = 0,//GENERAL
        FALLO = 1,//GENERAL
        NO_EXISTE = 2,
        EXISTE = 3,
        VALOR_NULO = 4, //NULO
        PARAMETRO_FALTANTE = 5,
        FALLA_SERIALIZACION = 6,//GENERAL
        REGISTRO_BLOQUEADO = 7,
        VALOR_INVALIDO = 8,
        REGISTRO_INHABILITADO = 10,

        AUTORIZACION_FALLO = 11,

        AJUSTE_PRECIO_DESCONFIGURADO = 89,
        SERVIDOR_EN_MANTENIMIENTO = 99,

        ENTIDAD_NO_EXISTE = 202,
        ENTIDAD_EXISTE = 203,
        ENTIDAD_VALOR_NULO = 204, //NULO
        ENTIDAD_PARAMETRO_FALTANTE = 205,
        ENTIDAD_BLOQUEADA = 207,
        ENTIDAD_INVALIDA = 208,
        ENTIDAD_INHABILITADA = 210,

        USUARIO_NO_EXISTE = 302,
        USUARIO_EXISTE = 303,
        USUARIO_VALOR_NULO = 304, //NULO
        USUARIO_PARAMETRO_FALTANTE = 305,
        USUARIO_BLOQUEADO = 307,
        USUARIO_INVALIDO = 308,
        USUARIO_INHABILITADO = 310,

        NOTIFICACION_NO_EXISTE = 402,
        NOTIFICACION_EXISTE = 403,
        NOTIFICACION_VALOR_NULO = 404,
        NOTIFICACION_PARAMETRO_FALTANTE = 405,
        NOTIFICACION_BLOQUEADO = 407,
        NOTIFICACION_INVALIDA = 408,
        NOTIFICACION_INHABILITADA = 410,

        PAGO_NO_EXISTE = 502,
        PAGO_EXISTE = 503,



        FORMULARIO_NO_EXISTE = 602,
        FORMULARIO_EXISTE = 603,
        FORMULARIO_VALOR_NULO = 604,
        FORMULARIO_PARAMETRO_FALTANTE = 605,
        FORMULARIO_BLOQUEADO = 607,
        FORMULARIO_INVALIDO = 608,
        FORMULARIO_INHABILITADO = 610,

        PERSONA_NO_EXISTE = 702,
        PERSONA_EXISTE = 703,
        PERSONA_VALOR_NULO = 704, //NULO
        PERSONA_PARAMETRO_FALTANTE = 505,
        PERSONA_BLOQUEADO = 707,
        PERSONA_INVALIDO = 708,
        PERSONA_INHABILITADO = 710;
}
