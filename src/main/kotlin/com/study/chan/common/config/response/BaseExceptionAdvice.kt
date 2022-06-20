package com.study.chan.common.config.response

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import java.io.IOException
import java.sql.SQLIntegrityConstraintViolationException
import java.util.UnknownFormatConversionException
import javax.persistence.EntityNotFoundException
import javax.servlet.http.HttpServletRequest
import mu.KotlinLogging
import org.apache.commons.lang3.exception.ExceptionUtils
import org.hibernate.exception.ConstraintViolationException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.dao.CannotAcquireLockException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.orm.jpa.JpaSystemException
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.server.MethodNotAllowedException
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
class BaseExceptionAdvice {

    protected fun getExceptionDtoDefault(exception: Exception, errorCode: ErrorCodeEnum, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        val stackTrace: String = ExceptionUtils.getStackTrace(exception)
        val returnMsg: String = if (exception is MethodArgumentNotValidException)
            exception.allErrors[0].defaultMessage ?: "입력값이 잘못되었습니다."
        else
            errorCode.msg
        return ResponseEntity<ExceptionDto>(
            ExceptionDto(
                code = errorCode.status.value(),
                status = errorCode.status.name,
                message = returnMsg,
                errors = ExceptionDto.Error(
                    status = errorCode.status.name,
                    message = returnMsg,
                    stacktrace = stackTrace,
                )
            ),
            errorCode.status
        )
    }

    protected fun getExceptionDto(exception: Exception, errorCode: ErrorCodeEnum, request: HttpServletRequest) : ResponseEntity<ExceptionDto> =
        getExceptionDtoDefault(exception, errorCode, request)

    @ExceptionHandler(
        MethodArgumentNotValidException::class,
        HttpMessageNotReadableException::class,
        MissingRequestHeaderException::class,
        MissingServletRequestParameterException::class
    )
    fun methodArgValidException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.METHOD_ARG_NOT_VALID, request = request)
    }

    @ExceptionHandler(
        JsonParseException::class,
        MethodArgumentTypeMismatchException::class,
        IllegalArgumentException::class,
        InvalidFormatException::class
    )
    fun parseValidException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.BAD_REQUEST_FORMAT, request = request)
    }

    @ExceptionHandler(
        HttpRequestMethodNotSupportedException::class,
        MethodNotAllowedException::class
    )
    fun notSupportMethodException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.NOT_SUPPORT_METHOD, request = request)
    }

    @ExceptionHandler(
        AccessDeniedException::class,
    )
    fun accessDeniedException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.ACCESS_DENY, request = request)
    }

    @ExceptionHandler(
        NoSuchElementException::class,
        NoHandlerFoundException::class,
        EntityNotFoundException::class
    )
    fun noSuchException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.NO_SUCH, request = request)
    }

    @ExceptionHandler(
        ConstraintViolationException::class,
        DataIntegrityViolationException::class,
        SQLIntegrityConstraintViolationException::class,
        IllegalStateException::class,
        CannotAcquireLockException::class,
        NullPointerException::class,
        JpaSystemException::class
    )
    fun handleConflictException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.INTERNAL_SERVER_ERROR, request = request)
    }

    @ExceptionHandler(
        HttpMessageNotWritableException::class,
        HttpMediaTypeNotAcceptableException::class
    )
    fun notAcceptableException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.NOT_ACCEPT, request = request)
    }

    @ExceptionHandler(
        IOException::class,
        UnknownFormatConversionException::class
    )
    fun internalServerErrorException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.INTERNAL_SERVER_ERROR, request = request)
    }

    @ExceptionHandler(
        Exception::class
    )
    fun unknownException(exception: Exception, request: HttpServletRequest) : ResponseEntity<ExceptionDto> {
        return getExceptionDto(exception = exception, errorCode = ClientErrorCode.UNKNOWN_ERROR, request = request)
    }
}