package me.hoonti06.handleexceptiondemo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    /**
     *  javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     *  HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     *  주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//        fun handleValidException(ex : MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
//            ErrorCode errorCode = ErrorCode.INVALID_INPUT_VALUE;
//        BindingResult bindingResult = e.getBindingResult();
//
//        StringBuilder builder = new StringBuilder();
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//        builder.append("[");
//        builder.append(fieldError.getField());
//        builder.append("](은)는 ");
//        builder.append(fieldError.getDefaultMessage());
//        builder.append(". ");
//        builder.deleteCharAt(builder.length() - 1);
//
//        final ErrorResponse response = ErrorResponse.of(errorCode, builder.toString());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(BusinessException::class)
    protected fun handleBusinessException(ex: BusinessException): ResponseEntity<ErrorResponse>? {
        val errorCode = ex.errorCode
        val response = ErrorResponse(errorCode.code, ex.message)
        return ResponseEntity.badRequest().body(response)
    }

    @ExceptionHandler(Exception::class)
    protected fun handleResourceNotFoundException(ex: Exception): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.INTERNAL_SERVER_ERROR
        val response = ErrorResponse(errorCode.code, ex.message)
        return ResponseEntity.internalServerError().body(response)
    }
}