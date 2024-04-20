package com.philipp_lackner.cleanCodeHacks.utils

typealias  PhotoUrl = String
interface PhotoUploader {

    suspend fun uploadPhoto(byteArray: ByteArray): Result<PhotoUrl>
}

