package me.hoonti06.handleexceptiondemo

class BusinessException(
    val errorCode: ErrorCode,
    override val message: String?
) : RuntimeException(message)
