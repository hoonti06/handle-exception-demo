package me.hoonti06.handleexceptiondemo

enum class ErrorCode(
    val code: String,
    val description: String
) {
    INVALID_INPUT_VALUE("4001", "유효성 검증에 실패한 경우"),
    INVALID_("4002", "서버에서 처리할 수 없는 경우"),
    DUPLICATE_LOGIN_ID("4003", "계정명이 중복된 경우"),
    UNAUTHORIZED("4004", "인증에 실패한 경우"),
    ACCOUNT_NOT_FOUND("4005", "계정을 찾을 수 없는 경우"),
    ROLE_NOT_EXISTS("4006", "권한이 부족한 경우"),
    TOKEN_NOT_EXISTS("4007", "해당 key의 인증 토큰이 존재하지 않는 경우")
}